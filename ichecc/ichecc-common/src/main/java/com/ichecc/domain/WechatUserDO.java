package com.ichecc.domain;

import ng.bayue.common.BaseDO;

/**
 * 微信用户授权
 * 
 * @author fengyts Wed May 09 09:29:15 CST 2018
 */

public class WechatUserDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = 3514459719056651112L;

	/** 主键 */
	private Long id;

	/** 微信用户openId */
	private String openId;

	/** 昵微信称 */
	private String nickName;

	/** 微信头像链接 */
	private String avatarUrl;

	/** 性别：1-男；0-女；-1-未知 */
	private String gender;

	/** 省 */
	private String province;

	/** 市 */
	private String city;

	/** 国家 */
	private String country;

	/** unionId */
	private String unionId;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 微信用户openId
	 * 
	 * @param openId
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * 设置 昵微信称
	 * 
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 设置 微信头像链接
	 * 
	 * @param avatarUrl
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * 设置 性别：1-男；0-女；-1-未知
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 设置 省
	 * 
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 设置 市
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 设置 国家
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 设置 unionId
	 * 
	 * @param unionId
	 */
	public void setUnionId(String unionId) {
		this.unionId = unionId;
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
	 * 获取 微信用户openId
	 * 
	 * @return openId
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * 获取 昵微信称
	 * 
	 * @return nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 获取 微信头像链接
	 * 
	 * @return avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * 获取 性别：1-男；0-女；-1-未知
	 * 
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 获取 省
	 * 
	 * @return province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 获取 市
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 获取 国家
	 * 
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 获取 unionId
	 * 
	 * @return unionId
	 */
	public String getUnionId() {
		return unionId;
	}

}