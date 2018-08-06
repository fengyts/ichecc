package com.ichecc.wechat.dto;

import java.io.Serializable;

import com.ichecc.wechat.constant.WechatPayConstants;
import com.ichecc.wechat.util.SignUtil;
import com.ichecc.wechat.util.WXConfigManager;

/**
 * @author lenovopc
 *
 */
public class JsApiWXPayDTO implements Serializable {

	private static final long serialVersionUID = -8611115500688015873L;

	private String appid = WXConfigManager.getAppid();
	/**
	 * 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。
	 * 但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
	 */
	private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
	/** 支付签名随机串，不长于 32 位 */
	private String nonceStr = SignUtil.uuidString();
	/** 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=\*\*\*） */
	private String pkage;
	/** 签名方式，默认为'SHA1'，使用新版支付需传入'MD5' */
	private String signType = WechatPayConstants.SignType.MD5_DEFAULT;
	/** 支付签名 */
	private String paySign;

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

	public String getPkage() {
		return pkage;
	}

	public void setPkage(String pkage) {
		this.pkage = "prepay_id=" + pkage;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

}
