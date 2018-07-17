package com.ichecc.wechat.component;

import com.ichecc.dto.BaseDTO;

/**
 * 从配置文件获取公共配置封装类
 * 
 * @author lenovopc
 *
 */
public class ApiCommonConfig extends BaseDTO {

	private static final long serialVersionUID = 789982054532259897L;

	private String appid;
	/** 商户秘钥 */
	private String apiKey;
	/** 商户id */
	private String mch_id;
	/** 微信回调地址 */
	private String notify_url;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

}
