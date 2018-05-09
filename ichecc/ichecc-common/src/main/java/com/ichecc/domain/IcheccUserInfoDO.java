package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 用户实名认证信息
 * 
 * @author fengyts Wed May 09 09:29:18 CST 2018
 */

public class IcheccUserInfoDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = -8005017785886907781L;

	/** 主键 */
	private Long userId;

	/** 姓名 */
	private String name;

	/** 身份证 */
	private String identityCard;

	/** 详细地址 */
	private String address;

	/** 省代码 */
	private String province;

	/** 市代码 */
	private String city;

	/** 区县代码 */
	private String country;

	/** 认证时间 */
	private Date createTime;

	/** 修改时间 */
	private Date modifyTime;

	/**
	 * 设置 主键
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置 姓名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置 身份证
	 * 
	 * @param identityCard
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	/**
	 * 设置 详细地址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 设置 省代码
	 * 
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 设置 市代码
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 设置 区县代码
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 设置 认证时间
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
	 * 获取 主键
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 获取 姓名
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取 身份证
	 * 
	 * @return identityCard
	 */
	public String getIdentityCard() {
		return identityCard;
	}

	/**
	 * 获取 详细地址
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 获取 省代码
	 * 
	 * @return province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 获取 市代码
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 获取 区县代码
	 * 
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 获取 认证时间
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

}