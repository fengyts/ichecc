package com.ichecc.dao;

import java.util.Map;

import com.ichecc.domain.VipDepositOrderDO;

import ng.bayue.exception.CommonDAOException;
import ng.bayue.service.common.GeneralDAO;

/**
 * vip会员充值订单 DAO
 *
 * @author fengyts 2018-07-18 09:59:49
 */
public interface VipDepositOrderDAO extends GeneralDAO<VipDepositOrderDO> {

	/**
	 * 查询该用户近两小时 待支付 的订单; 该订单2小时内仍然有效; 未避免重复下单
	 * 
	 * @param userId
	 * @return
	 */
	VipDepositOrderDO selectLatestUnPaidOrder(Map<String, Object> params);

	/**
	 * 根据订单编号查询
	 * 
	 * @param orderNo
	 * @return
	 */
	VipDepositOrderDO selectByOrderNo(String orderNo);

	/**
	 * 根据订单编号更新订单
	 * 
	 * @param orderDO
	 * @return
	 */
	int updateByOrderNo(VipDepositOrderDO orderDO) throws CommonDAOException;

}
