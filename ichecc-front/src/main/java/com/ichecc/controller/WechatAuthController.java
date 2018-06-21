package com.ichecc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mp/")
public class WechatAuthController extends BaseController {
	
	@RequestMapping("home")
	public String authRedirectHome(String code){
		logger.info("===== wechat auth code: =====" + code);
		return "hello+ code : " + code;
	}
	
	@RequestMapping("home1")
	@ResponseBody
	public String authRedirectHome1(String code){
		logger.info("===== wechat auth code: =====" + code);
		return "hello+ code : " + code;
	}
	
	@RequestMapping("home2")
	public String authRedirectHome2(String code){
		logger.info("===== wechat auth code: =====" + code);
		return "redirect: http://www.checc.cc/myeleme";
	}

	public static void main(String[] args) {
		String appid = "wx11b8b11348ff6db3", scope = "snsapi_base", redirect_uri="";
		String authUrl = "https://open.weixin.qq.com/connect/qrconnect?"
				+ "appid=wx11b8b11348ff6db3&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	}

}
