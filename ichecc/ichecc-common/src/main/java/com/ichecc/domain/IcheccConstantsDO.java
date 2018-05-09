package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 常量
 * 
 * @author fengyts Wed May 09 09:29:18 CST 2018
 */

public class IcheccConstantsDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = 213717979762279624L;

	/** 主键 */
	private String key;

	/** 常量值 */
	private String value;

	/** 常量说明 */
	private String desc;

	/** 添加人 */
	private Long createUserId;

	/** 添加时间 */
	private Date createTime;

	/** 修改人 */
	private Long modifyUserId;

	/** 修改时间 */
	private Date modifyTime;

	/**
	 * 设置 主键
	 * 
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 设置 常量值
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 设置 常量说明
	 * 
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 设置 添加人
	 * 
	 * @param createUserId
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 设置 添加时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置 修改人
	 * 
	 * @param modifyUserId
	 */
	public void setModifyUserId(Long modifyUserId) {
		this.modifyUserId = modifyUserId;
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
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 获取 常量值
	 * 
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 获取 常量说明
	 * 
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 获取 添加人
	 * 
	 * @return createUserId
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 获取 添加时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取 修改人
	 * 
	 * @return modifyUserId
	 */
	public Long getModifyUserId() {
		return modifyUserId;
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