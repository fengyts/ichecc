package com.ichecc.service;

import ng.bayue.service.common.GeneralService;

import com.ichecc.domain.DepositRecordDO;
import com.ichecc.vo.VipInfoVO;

 /**
 * 会员充值记录 Service
 * @author fengyts 2018-05-09 09:29:16
 */
public interface DepositRecordService extends GeneralService<DepositRecordDO, DepositRecordDO> {
	
	/**
	 * <pre>
	 * 根据用户最新充值记录获取用户会员信息
	 * </pre>
	 *
	 * @param userId
	 * @return
	 */
	VipInfoVO getVipInfo(Long userId);
}
