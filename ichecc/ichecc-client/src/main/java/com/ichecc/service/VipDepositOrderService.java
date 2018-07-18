package com.ichecc.service;

import ng.bayue.exception.CommonServiceException;
import ng.bayue.service.common.GeneralService;
import com.ichecc.domain.VipDepositOrderDO;

/**
 * vip会员充值订单 Service
 * 
 * @author fengyts 2018-07-18 09:59:49
 */
public interface VipDepositOrderService extends GeneralService<VipDepositOrderDO, VipDepositOrderDO> {

	/**
	 * 查询该用户近两小时 待支付 的订单; 该订单2小时内仍然有效; 未避免重复下单
	 * 
	 * @param userId
	 * @return
	 */
	VipDepositOrderDO selectLatestUnPaidOrder(Long userId);
	
	/**
	 * 根据订单编号查询
	 * @param orderNo
	 * @return
	 */
	VipDepositOrderDO selectByOrderNo(String orderNo);
	
	/**
	 * 根据订单编号更新订单
	 * @param orderDO
	 * @return
	 */
	int updateByOrderNo(VipDepositOrderDO orderDO) throws CommonServiceException;

}
