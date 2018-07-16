package com.ichecc.wechat.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitConfigBean {
	
	private static ApiCommonConfig config;

	// @Resource(name="config")
	@Autowired
	private void setConfig(ApiCommonConfig config) {
		InitConfigBean.config = config;
	}

	public String getAppid() {
		return config.getAppid();
	}

	public String getSecrectKey() {
		return config.getSecrectKey();
	}

	public String getMch_id() {
		return config.getMch_id();
	}

	public String getNotify_url() {
		return config.getNotify_url();
	}

}
