package com.ichecc.wechat.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ichecc.domain.VipDepositOrderDO;
import com.ichecc.wechat.component.WechatPayServiceImpl;
import com.ichecc.wechat.dto.ApiUnifiedOrderDTO;

public interface WechatPayService {

	Logger logger = LoggerFactory.getLogger(WechatPayServiceImpl.class);

	/**
	 * 统一下单
	 * 
	 * @return
	 */
	VipDepositOrderDO unifiedOrder(VipDepositOrderDO orderDO, ApiUnifiedOrderDTO dto) throws Exception;

	/**
	 * 订单查询
	 * 
	 * @param orderNo
	 * @return
	 */
	VipDepositOrderDO orderQuery(String orderNo) throws Exception;

}
