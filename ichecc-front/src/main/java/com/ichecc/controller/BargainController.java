package com.ichecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.annotation.Authority;
import com.ichecc.ao.BargainAO;
import com.ichecc.common.Constants;
import com.ichecc.common.ResultData;

@Controller
@RequestMapping(Constants.API_BASE_PATH + "bargain")
public class BargainController {
	
	@Autowired
	private BargainAO bargainAO;

	/**
	 * <pre>
	 * 参与砍价页面
	 * </pre>
	 *
	 * @param userId
	 * @param tiId
	 * @return
	 */
	@RequestMapping("participationHiggle")
	@ResponseBody
	@Authority
	public ResultData participationHiggle(Long userId, Long tiId) {
		return bargainAO.participationHiggle(userId, tiId);
	}
	
	
	/**
	 * <pre>
	 * 个人中心，砍价详情页
	 * </pre>
	 *
	 * @param userId
	 * @param tiId
	 * @return
	 */
	@RequestMapping("bargainDetail")
	@ResponseBody
	@Authority
	public ResultData bargainDetail(Long userId, Long tiId) {

		return ResultData.success();
	}

}
