package com.ichecc.wechat.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ichecc.wechat.ApiOrderQueryDTO;
import com.ichecc.wechat.ApiUnifiedOrderDTO;
import com.ichecc.wechat.OrderQueryResponseDTO;
import com.ichecc.wechat.UnifiedOrderResponseDTO;
import com.ichecc.wechat.component.WechatPayServiceImpl;

public interface WechatPayService {

	Logger logger = LoggerFactory.getLogger(WechatPayServiceImpl.class);

	/**
	 * 统一下单
	 * 
	 * @return
	 */
	UnifiedOrderResponseDTO unifiedOrder(ApiUnifiedOrderDTO dto) throws Exception;

	/**
	 * 订单查询
	 * 
	 * @param dto
	 * @return
	 */
	OrderQueryResponseDTO orderQuery(ApiOrderQueryDTO dto) throws Exception;

}
