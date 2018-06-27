package com.ichecc.ao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.service.DepositRecordService;
import com.ichecc.service.IcheccUserService;
import com.ichecc.vo.VipInfoVO;

@Service
public class ICheccUserAO extends BaseAO {

	@Autowired
	private IcheccUserService userService;
	@Autowired
	private DepositRecordService depositRecordService;

	public VipInfoVO getVipInfo(Long userId) {
		VipInfoVO vo = depositRecordService.getVipInfo(userId);
		return vo;
	}

}
