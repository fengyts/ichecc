package com.ichecc.service;

import java.util.List;

import com.ichecc.domain.VipDepositConfigDO;

import ng.bayue.service.common.GeneralService;

 /**
 * 会员充值选项配置 Service
 * @author fengyts 2018-05-09 09:29:16
 */
public interface VipDepositConfigService extends GeneralService<VipDepositConfigDO, VipDepositConfigDO> {
	
	/**
	 * 获取所有有效的配置项, 按照金额升序
	 * @return
	 */
	List<VipDepositConfigDO> listAllConfig();
	
}
