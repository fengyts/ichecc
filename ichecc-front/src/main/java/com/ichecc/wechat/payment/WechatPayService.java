package com.ichecc.wechat.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ichecc.wechat.component.WechatPayServiceImpl;
import com.ichecc.wechat.dto.UnifiedOrderInputDTO;

import ng.bayue.common.CommonResultMessage;

public interface WechatPayService {

	Logger logger = LoggerFactory.getLogger(WechatPayServiceImpl.class);

	/**
	 * 统一下单
	 * 
	 * @return
	 */
	CommonResultMessage unifiedOrder(UnifiedOrderInputDTO inputDto) throws Exception;

	/**
	 * 订单查询
	 * 
	 * @param orderNo
	 * @return
	 */
	CommonResultMessage orderQuery(String orderNo) throws Exception;

	/**
	 * 微信支付结果通知
	 * 
	 * @param paramXmlStr
	 * @return
	 */
	CommonResultMessage callback(String paramXmlStr) throws Exception;

}
