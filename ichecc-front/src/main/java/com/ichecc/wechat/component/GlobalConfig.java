package com.ichecc.wechat.component;

import org.springframework.stereotype.Component;


public class GlobalConfig {

	private InitConfigBean config = new InitConfigBean();
	
	public final String appid = config.getAppid();
	public final String secrectKey = config.getSecrectKey();
	public final String mch_id = config.getMch_id();
	public final String notify_url = config.getNotify_url();

}
