package com.ichecc.wechat.component;

import org.springframework.stereotype.Service;

import com.ichecc.wechat.ApiOrderQueryDTO;
import com.ichecc.wechat.ApiUnifiedOrderDTO;
import com.ichecc.wechat.OrderQueryResponseDTO;
import com.ichecc.wechat.UnifiedOrderResponseDTO;
import com.ichecc.wechat.payment.WechatPayService;
import com.ichecc.wechat.util.ApiConfigConstant;
import com.ichecc.wechat.util.RequestUtil;
import com.ichecc.wechat.util.SignUtil;
import com.ichecc.wechat.util.XmlUtil;

@Service
public class WechatPayServiceImpl implements WechatPayService {

	@Override
	public UnifiedOrderResponseDTO unifiedOrder(ApiUnifiedOrderDTO dto) throws Exception {
		try {
			String sign = SignUtil.createSign(dto);
			dto.setSign(sign);
			if(!dto.validate()){
				logger.info("支付异常, 存在空的必填项参数");
				throw new Exception("支付异常, 存在空的必填项参数");
			}
			String xmlData = XmlUtil.beanToXmlStr(dto);
			UnifiedOrderResponseDTO resDto = RequestUtil.doRequestXml(ApiConfigConstant.UFDODER_URL, xmlData, UnifiedOrderResponseDTO.class);
			
			if(!resDto.validate()){
				logger.info("支付异常, 系统错误信息：{}-业务错误信息：{}", resDto.getReturn_msg(), resDto.getErr_code_des());
				throw new Exception("支付异常, 系统错误信息：" + resDto.getReturn_msg() + "-业务错误信息：" + resDto.getErr_code_des());
			}
			return resDto;
		} catch (Exception e) {
			logger.info("支付下单异常:{}", e);
			throw e;
		}
	}

	@Override
	public OrderQueryResponseDTO orderQuery(ApiOrderQueryDTO dto) throws Exception {
		return null;
	}

}
