package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 用户
 * 
 * @author fengyts Wed May 09 09:29:19 CST 2018
 */

public class IcheccUserDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = 8700680859137838654L;

	/** 主键 */
	private Long id;

	/** 昵称 */
	private String nickname;

	/** 手机号 */
	private String mobile;

	/** 密码，可以使用短信验证码登录，可为空 */
	private String password;

	/** 登录盐 */
	private String salt;

	/** 是否实名认证：0-未认证；1-已认证 */
	private Boolean isCertification;

	/** 注册时间 */
	private Date createTime;

	/** 修改时间 */
	private Date modifyTime;

	/** 最后登录时间 */
	private Date lastLoginTime;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 昵称
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 设置 手机号
	 * 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 设置 密码，可以使用短信验证码登录，可为空
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 设置 登录盐
	 * 
	 * @param salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * 设置 是否实名认证：0-未认证；1-已认证
	 * 
	 * @param isCertification
	 */
	public void setIsCertification(Boolean isCertification) {
		this.isCertification = isCertification;
	}

	/**
	 * 设置 注册时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置 修改时间
	 * 
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 设置 最后登录时间
	 * 
	 * @param lastLoginTime
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 获取 主键
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 获取 昵称
	 * 
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 获取 手机号
	 * 
	 * @return mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 获取 密码，可以使用短信验证码登录，可为空
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 获取 登录盐
	 * 
	 * @return salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * 获取 是否实名认证：0-未认证；1-已认证
	 * 
	 * @return isCertification
	 */
	public Boolean getIsCertification() {
		return isCertification;
	}

	/**
	 * 获取 注册时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取 修改时间
	 * 
	 * @return modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 获取 最后登录时间
	 * 
	 * @return lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

}