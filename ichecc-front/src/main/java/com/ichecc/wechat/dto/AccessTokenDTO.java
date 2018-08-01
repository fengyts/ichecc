package com.ichecc.wechat.dto;

import com.ichecc.wechat.BaseDTO;

public class AccessTokenDTO extends BaseDTO {

	private static final long serialVersionUID = 3678869255039419141L;

	private String access_token;
	private Integer expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

}