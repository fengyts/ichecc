package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 商品属性
 * 
 * @author fengyts Mon Jun 04 14:08:04 CST 2018
 */

public class ItemAttributeDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = -7134663300334599362L;

	/** 主键 */
	private Long id;

	/** 属性名称 */
	private String name;

	/** 属性值 */
	private String value;

	/** 排序 */
	private Integer sort;

	/**  */
	private Long createUserId;

	/**  */
	private Date createTime;

	/**  */
	private Long modifyUserId;

	/**  */
	private Date modifyTime;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 属性名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置 属性值
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 设置 排序
	 * 
	 * @param sort
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 设置
	 * 
	 * @param createUserId
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 设置
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置
	 * 
	 * @param modifyUserId
	 */
	public void setModifyUserId(Long modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	/**
	 * 设置
	 * 
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
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
	 * 获取 属性名称
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取 属性值
	 * 
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 获取 排序
	 * 
	 * @return sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 获取
	 * 
	 * @return createUserId
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 获取
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取
	 * 
	 * @return modifyUserId
	 */
	public Long getModifyUserId() {
		return modifyUserId;
	}

	/**
	 * 获取
	 * 
	 * @return modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

}