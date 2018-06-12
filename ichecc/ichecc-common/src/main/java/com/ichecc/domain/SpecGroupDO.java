package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 规格组
 * 
 * @author fengyts Mon Jun 04 14:08:05 CST 2018
 */

public class SpecGroupDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = 111051907248069519L;

	/** 主键 */
	private Long id;

	/** 规格组名称 */
	private String name;

	/** 规格组类型 ：0-其他；1-选车 */
	private String type;

	/** 排序 */
	private Integer sort;

	/** 备注 */
	private String remark;

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
	 * 设置 规格组名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置 规格组类型 ：0-其他；1-选车
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * 设置 备注
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * 获取 规格组名称
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取 规格组类型 ：0-其他；1-选车
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
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
	 * 获取 备注
	 * 
	 * @return remark
	 */
	public String getRemark() {
		return remark;
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