package com.ichecc.wechat.dto;

import java.util.ArrayList;
import java.util.List;

import com.ichecc.wechat.BaseDTO;

public class WechatJsConfigDTO extends BaseDTO {

	private static final long serialVersionUID = 4564345024805001050L;

	/**
	 * 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，
	 * 仅在pc端时才会打印。
	 */
	private Boolean debug = false;

	/** 必填，公众号的唯一标识 */
	private String appid;
	/** 必填，生成签名的时间戳 */
	private String timestamp;
	/** 必填，生成签名的随机串 */
	private String nonceStr;
	/** 必填，签名 */
	private String signature;
	/** 必填，需要使用的JS接口列表 */
	private List<String> jsApiList = new ArrayList<String>();

	public Boolean getDebug() {
		return debug;
	}

	public void setDebug(Boolean debug) {
		this.debug = debug;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<String> getJsApiList() {
		return jsApiList;
	}

	public void setJsApiList(List<String> jsApiList) {
		this.jsApiList = jsApiList;
	}

}
