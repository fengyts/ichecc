package com.ichecc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.TopicItemAO;
import com.ichecc.common.Constants;
import com.ichecc.common.ResultData;
import com.ichecc.front.dto.FrontTopicItemDTO;


@Controller
@RequestMapping(Constants.API_BASE_PATH + "index")
public class HomeController {
	
	@Autowired
	private TopicItemAO topicItemAO;

	@RequestMapping(value ="/itemList", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResultData itemList() {
		List<FrontTopicItemDTO> list = topicItemAO.selectList();
		return ResultData.success(list);
	}

}
