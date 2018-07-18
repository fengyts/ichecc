package com.ichecc.wechat.dto;

import com.ichecc.wechat.BaseValidateDTO;
import com.ichecc.wechat.component.InitConfigBean;
import com.ichecc.wechat.util.SignUtil;

/**
 * 主动调用微信接口基础参数
 * 
 * @author lenovopc
 *
 */
public class ApiCommonDTO extends BaseValidateDTO {

	private static final long serialVersionUID = 437849644203294539L;
	
	protected static final InitConfigBean config = new InitConfigBean();

	public static final class SignType {
		// MD5, SHA1;
		/** 默认签名算法 */
		public static final String MD5_DEFAULT = "MD5";
		public static final String SHA1 = "SHA1";
	}

	/** 【必填】微信支付分配的公众账号ID（企业号corpid即为此appId） */
	private String appid = config.getAppid();
	/** 【必填】微信支付分配的商户号 */
	private String mch_id = config.getMch_id();
	/** 【必填】随机字符串，长度要求在32位以内。推荐随机数生成算法 */
	private String nonce_str = SignUtil.uuidString();
	/** 【必填】通过签名算法计算得出的签名值，详见签名生成算法 */
	private String sign;
	/** 【选填】签名类型，默认为MD5，支持HMAC-SHA256和MD5。此参数在有些接口是必填项，具体参考接口文档 */
	private String sign_type = SignType.MD5_DEFAULT;

	@Override
	protected boolean validate() {
		if (isBlank(appid) || isBlank(mch_id) || isBlank(nonce_str) || isBlank(sign) || isBlank(sign)) {
			return false;
		}
		return true;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

}
