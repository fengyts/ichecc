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
			String xmlData = XmlUtil.beanToXmlStr(dto);
			UnifiedOrderResponseDTO resDto = RequestUtil.doRequestXml(ApiConfigConstant.UFDODER_URL_TEST, xmlData, UnifiedOrderResponseDTO.class);
			
			if(!resDto.validate()){
				logger.info(resDto.getReturn_msg());
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
