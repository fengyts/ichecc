package com.ichecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.WechatAO;
import com.ichecc.common.Constants;
import com.ichecc.common.ResultData;

@Controller
@RequestMapping(Constants.API_BASE_PATH + "wechat/")
public class WechatController extends BaseController {
	
	@Autowired
	private WechatAO wechatAO;
	
	@RequestMapping("authorize")
	@ResponseBody
	public ResultData authorize(String code){
		try {
			return wechatAO.authorize(code);
		} catch (Exception e) {
			return ResultData.failure("服务器异常");
		}
	}
	
}
