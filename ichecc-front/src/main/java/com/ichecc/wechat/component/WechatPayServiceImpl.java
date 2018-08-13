package com.ichecc.wechat.component;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.common.ResultCode;
import com.ichecc.domain.IcheccUserDO;
import com.ichecc.domain.VipDepositConfigDO;
import com.ichecc.domain.VipDepositOrderDO;
import com.ichecc.service.IcheccUserService;
import com.ichecc.service.VipDepositConfigService;
import com.ichecc.service.VipDepositOrderService;
import com.ichecc.wechat.bean.PayOrderNoGenerator;
import com.ichecc.wechat.constant.ApiConfigConstant;
import com.ichecc.wechat.constant.WechatPayConstants;
import com.ichecc.wechat.dto.ApiOrderQueryDTO;
import com.ichecc.wechat.dto.ApiUnifiedOrderDTO;
import com.ichecc.wechat.dto.JsApiWXPayDTO;
import com.ichecc.wechat.dto.OrderQueryResponseDTO;
import com.ichecc.wechat.dto.UnifiedOrderInputDTO;
import com.ichecc.wechat.dto.UnifiedOrderResponseDTO;
import com.ichecc.wechat.dto.WechatPayCallbackDTO;
import com.ichecc.wechat.payment.WechatPayService;
import com.ichecc.wechat.util.RequestUtil;
import com.ichecc.wechat.util.SignUtil;
import com.ichecc.wechat.util.XmlUtil;

import ng.bayue.common.CommonResultMessage;
import ng.bayue.util.DateUtils;

@Service
public class WechatPayServiceImpl implements WechatPayService {

	@Autowired
	private VipDepositOrderService depositOrderService;
	@Autowired
	private IcheccUserService userService;
	@Autowired
	private VipDepositConfigService depositConfigService;

	@Override
	public CommonResultMessage unifiedOrder(UnifiedOrderInputDTO inputDto) throws Exception {
		try {
			Long userId = inputDto.getUserId();
			if (null == userId) {
				logger.info("支付异常，用户信息不能为空");
				return CommonResultMessage.failure("支付异常，用户信息不能为空");
			}
			IcheccUserDO userDO = userService.selectById(userId);
			if (null == userDO) {
				logger.info("支付下单异常，用户信息不存在");
				return CommonResultMessage.failure("支付下单异常，用户信息不存在");
			}
			// 查询最新未支付订单
			VipDepositOrderDO orderLatest = depositOrderService.selectLatestUnPaidOrder(userId);
			// Double totalFee = inputDto.getDepositAmount();
			// if (null == totalFee || totalFee.doubleValue() <= 0) {
			// logger.info("微信支付下单失败: 支付金额为空");
			// return CommonResultMessage.failure("微信支付下单失败: 支付金额为空");
			// }
			// 获取支付信息
			VipDepositConfigDO configDO = null;
			Long configId = inputDto.getConfigId();
			if (null != configId) {
				configDO = depositConfigService.selectById(configId);
			} else {
				logger.info("支付异常：请稍后重试");
				return CommonResultMessage.failure("支付异常：请稍后重试");
			}
			if (null == configDO) {
				logger.info("支付异常：请稍后重试");
				return CommonResultMessage.failure("支付异常：请稍后重试");
			}

			JsApiWXPayDTO wxPayDto = new JsApiWXPayDTO();
			String paySign = "";
			if (null != orderLatest) {
				// 校验未支付订单金额以及类型和本次请求是否一样, 若一样并且未支付，则使用微支付订单重新发起支付，否则生成新订单
				if (checkDepositOrderConfig(configDO, orderLatest)) {
					// 校验该订单状态-> 是否已经支付
					// 若已经支付或者支付异常, 重新下单
					OrderQueryResponseDTO resQueryDto = orderQueryFromWX(orderLatest);
					OrderTradeStateEnums tradeStateWX = getOrderState(resQueryDto);
					if (OrderTradeStateEnums.USERPAYING == tradeStateWX) {
						// 订单待支付则直接返回支付
						wxPayDto.setPkage(orderLatest.getPrepayId());
						paySign = SignUtil.createJsApiPaySign(wxPayDto);
						wxPayDto.setPaySign(paySign);
						return CommonResultMessage.success(wxPayDto);
					} else {
						// 若微信端已经支付成功状态 并且和本地订单状态不一样，则更新本地订单状态
						if (OrderTradeStateEnums.SUCCESS == tradeStateWX
								&& (DepositOrderStatus.UNPAID.equals(orderLatest.getOrderStatus()))) {
							logger.info("支付成功订单：更新本地订单状态");
							orderLatest.setOrderStatus(DepositOrderStatus.SUCCESS);
							orderLatest.setTransactionId(resQueryDto.getTransaction_id());
							orderLatest.setBankType(resQueryDto.getBank_type());
							orderLatest.setTradeState(DepositOrderTradeState.SUCCESS);
							orderLatest.setTradeStateDesc(resQueryDto.getTrade_state_desc());
							orderLatest.setTimeEnd(DateUtils.parseDate(resQueryDto.getTime_end(), "yyyyMMddHHmmss"));
							orderLatest.setModifyTime(new Date());
							// 更新订单状态以及用户vip信息
							depositOrderService.updateVipInfoByOrder(orderLatest);
						}
						// 从微信查询到的订单既不是成功，也不是用户支付中的状态，即其他状态的，统统更新为订单支付失败
						if (OrderTradeStateEnums.SUCCESS != tradeStateWX
								&& OrderTradeStateEnums.USERPAYING != tradeStateWX) {
							logger.info("过期或失败订单：更新本地订单状态");
							String tradeStateDb = orderLatest.getTradeState();
							if (!DepositOrderTradeState.SUCCESS.equals(tradeStateDb)
									&& !DepositOrderTradeState.USERPAYING.equals(tradeStateDb)
									&& StringUtils.isNotBlank(tradeStateDb)) {
								orderLatest.setOrderStatus(DepositOrderStatus.FAILURE);
								orderLatest.setTransactionId(resQueryDto.getTransaction_id());
								orderLatest.setBankType(resQueryDto.getBank_type());
								orderLatest.setTradeState(tradeStateWX.code);
								orderLatest.setTradeStateDesc(resQueryDto.getTrade_state_desc());
								orderLatest.setModifyTime(new Date());
								depositOrderService.update(orderLatest, false);
							}
						}
					}
				}
			}

			String orderNo = generateOrderNo(); // 生成订单编号
			String openid = userDO.getOpenid();

			Double originalAmount = configDO.getOriginalAmount();
			Double realAmount = originalAmount * configDO.getDiscount();
			Double totalFee = realAmount * 100; // 元转为分

			ApiUnifiedOrderDTO dto = new ApiUnifiedOrderDTO();
			dto.setOut_trade_no(orderNo);
			dto.setTotal_fee(totalFee.intValue());
			dto.setTrade_type(WechatPayConstants.TradeType.JSAPI.name());
			dto.setOpenid(openid);
			dto.setBody(inputDto.getBody());
			dto.setAttach(inputDto.getAttach());
			dto.setSpbill_create_ip(inputDto.getIp());

			String sign = SignUtil.createSign(dto);
			dto.setSign(sign);
			if (!dto.validate()) {
				logger.info("支付下单异常, 存在空的必填项参数");
				// throw new Exception("支付异常, 存在空的必填项参数");
				return CommonResultMessage.failure("支付下单异常, 存在空的必填项参数");
			}
			String xmlData = XmlUtil.beanToXmlStr(dto);
			logger.info("支付下单请求报文信息: {}", xmlData);
			UnifiedOrderResponseDTO resDto = RequestUtil.doRequestXml(ApiConfigConstant.UFDODER_URL, xmlData,
					UnifiedOrderResponseDTO.class);

			if (!resDto.validate()) {
				logger.info("支付下单异常, 系统错误信息：{}-业务错误信息：{}", resDto.getReturn_msg(), resDto.getErr_code_des());
				// throw new Exception("支付异常, 系统错误信息：" + resDto.getReturn_msg()
				// + "-业务错误信息：" + resDto.getErr_code_des());
				return CommonResultMessage.failure("支付下单异常: 请求微信服务器下单异常");
			}

			// 保存订单
			VipDepositOrderDO orderDO = new VipDepositOrderDO();
			orderDO.setUserId(userId);
			orderDO.setOpenid(openid);
			orderDO.setOrderNo(orderNo);
			orderDO.setPrepayId(resDto.getPrepay_id());

			orderDO.setConfigId(configDO.getId());
			orderDO.setOriginalAmount(originalAmount);
			orderDO.setRealAmount(realAmount);
			orderDO.setExpiryDate(configDO.getExpiryDate());
			orderDO.setExpiryType(configDO.getExpiryType());

			orderDO.setOrderStatus(DepositOrderStatus.UNPAID);
			orderDO.setTradeState(DepositOrderTradeState.USERPAYING);
			orderDO.setCreateTime(new Date());

			Long status = depositOrderService.insert(orderDO);
			if (status <= 0) {
				logger.info("支付下单异常，保存订单信息失败");
				// throw new CommonServiceException("支付下单异常，保存订单信息失败");
				return CommonResultMessage.failure("支付下单异常，保存订单信息失败");
			}

			wxPayDto.setPkage(orderDO.getPrepayId());
			paySign = SignUtil.createJsApiPaySign(wxPayDto);
			wxPayDto.setPaySign(paySign);

			return CommonResultMessage.success(wxPayDto);
		} catch (Exception e) {
			logger.info("支付下单异常:{}", e);
			throw e;
		}
	}

	/**
	 * 校验是否同一订单：金额，充值类型，充值期限均一样。用于同一下单未过期且未支付订单发起重新支付请求
	 * 
	 * @param configDO
	 * @param orderDO
	 * @return
	 */
	private boolean checkDepositOrderConfig(VipDepositConfigDO configDO, VipDepositOrderDO orderDO) {
		if (null == configDO || null == orderDO) {
			return false;
		}
		Double ca = configDO.getOriginalAmount();
		Double oa = orderDO.getRealAmount();
		if (null == ca || null == oa || ca.doubleValue() != oa.doubleValue()) {
			return false;
		}
		ca = ca * configDO.getDiscount(); // 实际充值金额
		if (configDO.getExpiryDate().intValue() != orderDO.getExpiryDate().intValue()) {
			return false;
		}
		if (!configDO.getExpiryType().equals(orderDO.getExpiryType())) {
			return false;
		}
		return true;
	}

	private String generateOrderNo() {
		PayOrderNoGenerator generator = new PayOrderNoGenerator();
		String payOrderNo = generator.generatePayOrderNo();
		return payOrderNo;
	}

	@Override
	public CommonResultMessage orderQuery(String orderNo) throws Exception {
		try {
			VipDepositOrderDO orderDO = depositOrderService.selectByOrderNo(orderNo);
			if (null == orderDO) {
				logger.info("查询订单结果：该订单不存在");
				return CommonResultMessage.failure("订单不存在");
			}

			// 订单已支付成功
			if (DepositOrderStatus.SUCCESS.equals(orderDO.getOrderStatus())
					&& DepositOrderTradeState.SUCCESS.equals(orderDO.getTradeState())) {
				return CommonResultMessage.success(orderDO);
			}

			OrderQueryResponseDTO resDto = orderQueryFromWX(orderDO);
			if (!resDto.validateBiz()) {
				logger.info("支付订单查询异常, 系统错误信息：{}-业务错误信息：{}", resDto.getReturn_msg(), resDto.getErr_code_des());
				// throw new Exception("支付异常, 系统错误信息：" + resDto.getReturn_msg()
				// + "-业务错误信息：" + resDto.getErr_code_des());
				return CommonResultMessage.failure("支付订单查询异常");
			}

			// 更新订单状态
			String tradeState = resDto.getTrade_state();
			String orderStatus = "";
			switch (tradeState) {
			case DepositOrderTradeState.SUCCESS:
				orderStatus = DepositOrderStatus.SUCCESS;
				break;
			case DepositOrderTradeState.NOTPAY:
				orderStatus = DepositOrderStatus.UNPAID;
				break;
			case DepositOrderTradeState.REFUND:
				orderStatus = DepositOrderStatus.SUCCESS;
				break;
			case DepositOrderTradeState.USERPAYING:
				orderStatus = DepositOrderStatus.UNPAID;
				break;
			case DepositOrderTradeState.PAYERROR:
				orderStatus = DepositOrderStatus.FAILURE;
				break;
			default:
				orderStatus = DepositOrderStatus.FAILURE;
				break;
			}

			orderDO.setOrderStatus(orderStatus);
			orderDO.setTradeState(tradeState);
			orderDO.setTradeStateDesc(resDto.getTrade_state_desc());
			orderDO.setTransactionId(resDto.getTransaction_id());
			String time_end = resDto.getTime_end();
			if (StringUtils.isNotBlank(time_end)) {
				orderDO.setTimeEnd(DateUtils.parseDate(time_end, DateUtils.Format.YYYYMMDDHHMMSS3));
			} else {
				orderDO.setTimeEnd(new Date());
			}
			orderDO.setBankType(resDto.getBank_type());
			orderDO.setModifyTime(new Date());

			int status = depositOrderService.updateByOrderNo(orderDO);
			if (1 != status) {
				logger.info("查询订单更新异常: {}");
				throw new Exception("查询订单更新异常: {}");
			}

			return CommonResultMessage.success(orderDO);
		} catch (Exception e) {
			logger.info("查询订单异常：{}", e);
			throw e;
		}
	}

	private OrderQueryResponseDTO orderQueryFromWX(VipDepositOrderDO orderDO) throws Exception {
		if (null == orderDO) {
			return null;
		}
		String transactionId = orderDO.getTransactionId();
		String orderNo = orderDO.getOrderNo();
		if (StringUtils.isBlank(transactionId) && StringUtils.isBlank(orderNo)) {
			return null;
		}
		ApiOrderQueryDTO dto = new ApiOrderQueryDTO();
		dto.setTransaction_id(transactionId);
		dto.setOut_trade_no(orderNo);

		String sign = SignUtil.createSign(dto);
		dto.setSign(sign);
		if (!dto.validate()) {
			logger.info("支付订单查询异常, 存在空的必填项参数");
			return null;
		}
		String xmlData = XmlUtil.beanToXmlStr(dto);
		logger.info("支付订单查询请求报文信息: {}", xmlData);

		OrderQueryResponseDTO resDto = RequestUtil.doRequestXml(ApiConfigConstant.ORDER_QUERY_URL, xmlData,
				OrderQueryResponseDTO.class);
		return resDto;
	}

	private OrderTradeStateEnums getOrderState(OrderQueryResponseDTO resQueryDto) {
		OrderTradeStateEnums res = OrderTradeStateEnums.PAYERROR;
		if (null == resQueryDto) {
			return res;
		}
		String tradeState = resQueryDto.getTrade_state();
		if (StringUtils.isBlank(tradeState)) {
			return res;
		}
		switch (tradeState) {
		case DepositOrderTradeState.SUCCESS:
			res = OrderTradeStateEnums.SUCCESS;
			break;
		case DepositOrderTradeState.USERPAYING:
			res = OrderTradeStateEnums.USERPAYING;
			break;
		case DepositOrderTradeState.CLOSED:
			res = OrderTradeStateEnums.CLOSED;
			break;
		case DepositOrderTradeState.NOTPAY:
			res = OrderTradeStateEnums.NOTPAY;
			break;
		case DepositOrderTradeState.REFUND:
			res = OrderTradeStateEnums.REFUND;
			break;
		case DepositOrderTradeState.REVOKED:
			res = OrderTradeStateEnums.REVOKED;
			break;
		case DepositOrderTradeState.PAYERROR:
			res = OrderTradeStateEnums.PAYERROR;
			break;
		default:
			res = OrderTradeStateEnums.PAYERROR;
			break;
		}

		return res;
	}

	@Override
	public CommonResultMessage callback(String paramXmlStr) throws Exception {
		try {
			if (StringUtils.isBlank(paramXmlStr)) {
				return CommonResultMessage.failure();
			}
			WechatPayCallbackDTO callbackDto = XmlUtil.parseXmlToBean(paramXmlStr, WechatPayCallbackDTO.class);
			if (!callbackDto.validate()) {
				logger.info("支付结果通知异常：returnMsg:{}, resultCode:{}", callbackDto.getReturn_msg(),
						callbackDto.getResult_code());
				return CommonResultMessage.failure(callbackDto.getReturn_msg());
			}
			boolean checkSign = SignUtil.checkSign(callbackDto);
			if (!checkSign) {
				logger.info("支付结果通知异常：签名错误");
				return CommonResultMessage.failure(ResultCode.getDesc(ResultCode.Biz.WECHAT_PAY_CALLBACK_SIGN_ERROR));
			}

			String orderNo = callbackDto.getOut_trade_no();
			String transactionId = callbackDto.getTransaction_id();
			String bankType = callbackDto.getBank_type();
			String timeEndStr = callbackDto.getTime_end();

			VipDepositOrderDO order = depositOrderService.selectByOrderNo(orderNo);
			if (null == order) {
				logger.info("支付结果通知异常:订单不存在");
				return CommonResultMessage.failure("订单不存在");
			}
			Double amt = order.getRealAmount();
			int amtTmp = new Double(amt * 100).intValue(); // 转为分
			if (amtTmp != callbackDto.getTotal_fee()) {
				logger.info("支付结果通知异常: 金额不统一");
				return CommonResultMessage.failure("本交易存在安全风险:金额不统一");
			}
			order.setTransactionId(transactionId);
			order.setBankType(bankType);
			order.setOrderStatus(DepositOrderStatus.SUCCESS);
			order.setTradeState(DepositOrderTradeState.SUCCESS);
			order.setTradeStateDesc("支付成功");
			Date timeEnd = DateUtils.parseDate(timeEndStr, "yyyyMMddHHmmss");
			order.setTimeEnd(timeEnd);
			order.setModifyTime(new Date());
			
			// 更新订单状态以及用户vip信息
			depositOrderService.updateVipInfoByOrder(order);
			

			return CommonResultMessage.success(order);
		} catch (Exception e) {
			logger.info("支付结果通知异常：{}");
			throw e;
		}
	}

	/**
	 * 充值订单状态
	 * 
	 * @author lenovopc
	 *
	 */
	public static interface DepositOrderStatus {
		/** 待支付 */
		static final String UNPAID = "01";
		/** 支付成功 */
		static final String SUCCESS = "02";
		/** 支付失败 */
		static final String FAILURE = "03";
		/** 支付超时 */
		static final String TIMEOUT = "04";
	}

	/**
	 * 交易状态,查询订单时返回：SUCCESS-支付成功;REFUND-转入退款;NOTPAY-未支付;CLOSED-已关闭;REVOKED-已撤销（
	 * 刷卡支付）; USERPAYING-用户支付中;PAYERROR-支付失败(其他原因，如银行返回失败)
	 * 
	 * @author lenovopc
	 *
	 */
	public static interface DepositOrderTradeState {
		/** 支付成功 */
		static final String SUCCESS = "SUCCESS";
		/** 转入退款 */
		static final String REFUND = "REFUND";
		/** 未支付 */
		static final String NOTPAY = "NOTPAY";
		/** 已关闭 */
		static final String CLOSED = "CLOSED";
		/** 已撤销（刷卡支付） */
		static final String REVOKED = "REVOKED";
		/** 用户支付中 */
		static final String USERPAYING = "USERPAYING";
		/** 支付失败(其他原因，如银行返回失败) */
		static final String PAYERROR = "PAYERROR";
	}

	public static enum OrderTradeStateEnums {
		SUCCESS(DepositOrderTradeState.SUCCESS, "支付成功"), REFUND(DepositOrderTradeState.REFUND, "转入退款"), NOTPAY(
				DepositOrderTradeState.NOTPAY, "未支付"), CLOSED(DepositOrderTradeState.CLOSED, "已关闭"), REVOKED(
						DepositOrderTradeState.REVOKED, "已撤销（刷卡支付）"), USERPAYING(DepositOrderTradeState.USERPAYING,
								"用户支付中"), PAYERROR(DepositOrderTradeState.PAYERROR, "支付失败(其他原因，如银行返回失败)");

		public String code;
		public String desc;

		private OrderTradeStateEnums(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}
	}

}
