package com.ichecc.dto;

import com.ichecc.domain.WechatUserDO;

public class ICheccUserDTO extends BaseDTO {

	private static final long serialVersionUID = 5075317923767974876L;

	private WechatUserDO wechatUser;

	/** ichecc_user的id */
	private Long id;
	/** 手机号 */
	private String mobile;
	/** 是否实名认证：0-未认证；1-已认证 */
	private Boolean isCertification;

	public WechatUserDO getWechatUser() {
		return wechatUser;
	}

	public void setWechatUser(WechatUserDO wechatUser) {
		this.wechatUser = wechatUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getIsCertification() {
		return isCertification;
	}

	public void setIsCertification(Boolean isCertification) {
		this.isCertification = isCertification;
	}

}
