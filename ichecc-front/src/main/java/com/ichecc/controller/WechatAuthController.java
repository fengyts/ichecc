package com.ichecc.controller;

public class WechatAuthController {

	public static void main(String[] args) {
		String appid = "wx11b8b11348ff6db3", scope = "snsapi_base", redirect_uri="";
		String authUrl = "https://open.weixin.qq.com/connect/qrconnect?"
				+ "appid=wx11b8b11348ff6db3&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	}

}
