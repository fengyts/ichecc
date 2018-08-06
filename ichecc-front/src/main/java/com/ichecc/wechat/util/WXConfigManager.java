package com.ichecc.wechat.util;

import com.ichecc.wechat.component.InitConfigBean;

public class WXConfigManager {
	
	private final static InitConfigBean config = new InitConfigBean();
	
	public static String getAppid(){
		return config.getAppid();
	}

}
