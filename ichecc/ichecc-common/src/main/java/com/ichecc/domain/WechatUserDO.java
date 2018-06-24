package com.ichecc.domain;

import ng.bayue.common.BaseDO;

/**
 * 微信用户授权
 * 
 * @author fengyts Sat Jun 23 12:33:14 CST 2018
 */

public class WechatUserDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = 8166115817641356463L;

	/** 主键 */
	private Long id;

	/** 微信用户openId */
	private String openid;

	/** 微信昵称 */
	private String nickname;

	/** 语言 */
	private String language;

	/** 微信头像链接 */
	private String headimgurl;

	/** 性别：1-男；0-女；-1-未知 */
	private String sex;

	/** 省 */
	private String province;

	/** 市 */
	private String city;

	/** 国家 */
	private String country;

	/** unionId */
	private String unionId;

	/** 用户特权信息 */
	private String privilege;

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
	 * @param openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 设置 微信昵称
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 设置 语言
	 * 
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * 设置 微信头像链接
	 * 
	 * @param headimgurl
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	/**
	 * 设置 性别：1-男；0-女；-1-未知
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
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
	 * 设置 用户特权信息
	 * 
	 * @param privilege
	 */
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
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
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 获取 微信昵称
	 * 
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 获取 语言
	 * 
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * 获取 微信头像链接
	 * 
	 * @return headimgurl
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}

	/**
	 * 获取 性别：1-男；0-女；-1-未知
	 * 
	 * @return sex
	 */
	public String getSex() {
		return sex;
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

	/**
	 * 获取 用户特权信息
	 * 
	 * @return privilege
	 */
	public String getPrivilege() {
		return privilege;
	}

}