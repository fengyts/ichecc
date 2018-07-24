package com.ichecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.annotation.Authority;
import com.ichecc.ao.VipAO;
import com.ichecc.common.Constants;
import com.ichecc.common.ResultData;

@Controller
@RequestMapping(Constants.API_BASE_PATH + "vip")
public class VipController {
	
	@Autowired
	private VipAO vipAO;
	
	@RequestMapping("vipinfo")
	@ResponseBody
	@Authority
	public ResultData vipInfo(Long userId){
		
		return vipAO.getVipInfo(userId);
	}
	
	@RequestMapping("vipinfoDetail")
	@ResponseBody
	@Authority
	public ResultData vipinfoDetail(Long userId){
		
		return vipAO.getVipInfoDetail(userId);
	}

}
