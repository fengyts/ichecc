package com.ichecc.wechat.component;

import org.springframework.stereotype.Component;


public class GlobalConfig {

	private static InitConfigBean config = new InitConfigBean();
	
	public String appid;
	public String secrectKey;
	public String mch_id;
	public String notify_url;
	
//	static {
//		appid = config.getAppid();
//	}
	
	public GlobalConfig(){
//		appid = config.getAppid();
//		secrectKey = config.getSecrectKey();
//		init();
	}
	
	public void init(){
		String str = config.getMch_id();
		System.out.println(str);
	}

}
