package com.ichecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.TopicItemAO;
import com.ichecc.common.Constants;
import com.ichecc.common.ResultData;

@Controller
@RequestMapping(Constants.API_BASE_PATH + "topicItem/")
public class TopicItemController {
	
	@Autowired
	private TopicItemAO topicItemAO;
	
	@RequestMapping("countdownTime")
	@ResponseBody
	public ResultData countDownTime(){
		Long countTime = topicItemAO.getCountdownTime();
		return ResultData.success(countTime);
	}
	
	@RequestMapping("itemDetail")
	@ResponseBody
	public ResultData itemDetail(Long tiId){
		return ResultData.success();
	}

}
