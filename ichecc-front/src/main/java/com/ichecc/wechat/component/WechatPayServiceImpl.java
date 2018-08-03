package com.ichecc.wechat.component;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.common.ResultCode;
import com.ichecc.domain.IcheccUserDO;
import com.ichecc.domain.VipDepositOrderDO;
import com.ichecc.service.IcheccUserService;
import com.ichecc.service.VipDepositOrderService;
import com.ichecc.wechat.bean.PayOrderNoGenerator;
import com.ichecc.wechat.constant.ApiConfigConstant;
import com.ichecc.wechat.dto.ApiOrderQueryDTO;
import com.ichecc.wechat.dto.ApiUnifiedOrderDTO;
import com.ichecc.wechat.dto.OrderQueryResponseDTO;
import com.ichecc.wechat.dto.UnifiedOrderResponseDTO;
import com.ichecc.wechat.dto.WechatPayCallbackDTO;
import com.ichecc.wechat.payment.WechatPayService;
import com.ichecc.wechat.util.RequestUtil;
import com.ichecc.wechat.util.SignUtil;
import com.ichecc.wechat.util.XmlUtil;

import ng.bayue.common.CommonResultMessage;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.util.DateUtils;

@Service
public class WechatPayServiceImpl implements WechatPayService {

	@Autowired
	private VipDepositOrderService depositOrderService;
	@Autowired
	private IcheccUserService userService;

	@Override
	public CommonResultMessage unifiedOrder(VipDepositOrderDO orderDO, ApiUnifiedOrderDTO dto) throws Exception {
		try {
			Long userId = orderDO.getUserId();
			if (null == userId) {
				logger.info("支付异常，用户信息不能为空");
				return CommonResultMessage.failure("支付异常，用户信息不能为空");
			}
			// 查询最新未支付订单
			VipDepositOrderDO orderLatest = depositOrderService.selectLatestUnPaidOrder(userId);
			Double totalFee = orderDO.getAmount();
			if (null == totalFee || totalFee.doubleValue() <= 0) {
				logger.info("微信支付下单失败: 支付金额为空");
				return CommonResultMessage.failure("微信支付下单失败: 支付金额为空");
			}
			if (null != orderLatest) {
				// 校验未支付订单金额和本次请求是否一样, 若一样，则使用微支付订单重新发起支付，否则生成新订单
				if (totalFee.doubleValue() == orderLatest.getAmount().doubleValue()) {
					return CommonResultMessage.success(orderLatest);
				}
			}
			IcheccUserDO userDO = userService.selectById(userId);
			if (null == userDO) {
				logger.info("支付下单异常，用户信息不存在");
				return null;
			}
			String openid = userDO.getOpenid();
			String orderNo = generateOrderNo();

			// ApiUnifiedOrderDTO dto = new ApiUnifiedOrderDTO();
			dto.setOut_trade_no(orderNo);
			totalFee = totalFee * 100; // 元转为分
			dto.setTotal_fee(totalFee.intValue());
			dto.setTrade_type(ApiUnifiedOrderDTO.TradeType.JSAPI.type);
			dto.setOpenid(openid);

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
			orderDO.setOpenid(openid);
			orderDO.setOrderNo(orderNo);
			orderDO.setPrepayId(resDto.getPrepay_id());
			// orderDO.setAmount(orderDO.getAmount());
			orderDO.setOrderStatus(DepositOrderStatus.UNPAID);
			orderDO.setTradeState(DepositOrderTradeState.USERPAYING);
			orderDO.setCreateTime(new Date());

			Long status = depositOrderService.insert(orderDO);
			if (status <= 0) {
				logger.info("支付下单异常，保存订单信息失败");
				throw new CommonServiceException("支付下单异常，保存订单信息失败");
			}

			return CommonResultMessage.success(orderDO);
		} catch (Exception e) {
			logger.info("支付下单异常:{}", e);
			throw e;
		}
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
				return null;
			}

			// 订单已支付成功
			if (DepositOrderStatus.SUCCESS.equals(orderDO.getOrderStatus())
					&& DepositOrderTradeState.SUCCESS.equals(orderDO.getTradeState())) {
				return CommonResultMessage.success(orderDO);
			}

			ApiOrderQueryDTO dto = new ApiOrderQueryDTO();
			dto.setTransaction_id(orderDO.getTransactionId());
			dto.setOut_trade_no(orderNo);

			String sign = SignUtil.createSign(dto);
			dto.setSign(sign);
			if (!dto.validate()) {
				logger.info("支付订单查询异常, 存在空的必填项参数");
				return CommonResultMessage.failure("支付订单查询异常, 存在空的必填项参数");
			}
			String xmlData = XmlUtil.beanToXmlStr(dto);
			logger.info("支付订单查询请求报文信息: {}", xmlData);

			OrderQueryResponseDTO resDto = RequestUtil.doRequestXml(ApiConfigConstant.ORDER_QUERY_URL, xmlData,
					OrderQueryResponseDTO.class);
			if (!resDto.validate()) {
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
			Double amt = order.getAmount();
			int amtTmp = new Double(amt * 100).intValue(); // 转为分
			if (amtTmp != callbackDto.getTotal_fee()) {
				logger.info("支付结果通知异常: 金额不统一");
				return CommonResultMessage.failure("本交易存在安全风险:金额不统一");
			}
			order.setTransactionId(transactionId);
			order.setBankType(bankType);
			order.setOrderStatus(DepositOrderTradeState.SUCCESS);
			Date timeEnd = DateUtils.parseDate(timeEndStr, "yyyyMMddHHmmss");
			order.setTimeEnd(timeEnd);
			order.setModifyTime(new Date());

			depositOrderService.update(order, false);

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
	public interface DepositOrderStatus {
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
	public interface DepositOrderTradeState {
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

}
