package com.ichecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.ChoiceAO;
import com.ichecc.common.Constants;
import com.ichecc.common.ResultData;

@Controller
@RequestMapping(Constants.API_BASE_PATH + "choice")
public class ChoiceController {
	
	@Autowired
	private ChoiceAO choiceAO;
	
	@RequestMapping("choiceConfig")
	@ResponseBody
	public ResultData getChoiceConfig(){
		return choiceAO.selectAllConfig();
	}
	
}
