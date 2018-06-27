package com.ichecc.dao;

import ng.bayue.service.common.GeneralDAO;

import com.ichecc.domain.DepositRecordDO;

 /**
 * 会员充值记录 DAO
 *
 * @author fengyts 2018-05-09 09:29:16
 */
public interface DepositRecordDAO extends GeneralDAO<DepositRecordDO> {
	
	
	/**
	 * <pre>
	 * 根据用户id获取最新充值信息
	 * </pre>
	 *
	 * @param userId
	 * @return
	 */
	DepositRecordDO selectLatestDepositRecord(Long userId);

}
