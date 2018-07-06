package com.ichecc.ao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.service.IcheccUserService;
import com.ichecc.service.VipUserInfoService;
import com.ichecc.vo.VipInfoVO;

@Service
public class ICheccUserAO extends BaseAO {

	@Autowired
	private IcheccUserService userService;
	@Autowired
	private VipUserInfoService vipUserService;

	public VipInfoVO getVipInfo(Long userId) {
		VipInfoVO vo = vipUserService.getVipInfo(userId);
		return vo;
	}

}
