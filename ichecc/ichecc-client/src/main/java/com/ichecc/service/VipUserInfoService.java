package com.ichecc.service;

import ng.bayue.service.common.GeneralService;
import com.ichecc.domain.VipUserInfoDO;
import com.ichecc.vo.VipInfoVO;

 /**
 * vip会员用户信息 Service
 * @author fengyts 2018-07-06 14:45:16
 */
public interface VipUserInfoService extends GeneralService<VipUserInfoDO, VipUserInfoDO> {
	
	/**
	 * 获取用户vip信息
	 * @param userId
	 * @return
	 */
	VipInfoVO getVipInfo(Long userId);
	
}
