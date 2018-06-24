package com.ichecc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping("home")
	@ResponseBody
	public String authRedirectHome(@RequestBody String code){
		logger.info("===== wechat auth code: =====" + code);
		return "hello+ code : " + code;
	}
	
	@RequestMapping("authorize")
	@ResponseBody
	public ResultData authorize(String code){
		try {
			return wechatAO.authorize(code);
		} catch (Exception e) {
			return ResultData.failure("服务器异常");
		}
	}
	
	public static void main(String[] args) {
		String appid = "wx11b8b11348ff6db3", scope = "snsapi_base", redirect_uri="";
		String authUrl = "https://open.weixin.qq.com/connect/qrconnect?"
				+ "appid=wx11b8b11348ff6db3&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	}

}
