package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 选车配置
 * 
 * @author fengyts Tue Jun 05 09:32:59 CST 2018
 */

public class ChoiceConfigDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = 1293804076640621274L;

	/** 主键 */
	private Long id;

	/** 配置名称 */
	private String name;

	/** 级别：1-父选项；2-子选项 */
	private Integer level;

	/** 父选项id */
	private Long parentId;

	/** 状态：1-有效；0-无效 */
	private Boolean status;

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
	 * 设置 配置名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置 级别：1-父选项；2-子选项
	 * 
	 * @param level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * 设置 父选项id
	 * 
	 * @param parentId
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 设置 状态：1-有效；0-无效
	 * 
	 * @param status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
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
	 * 获取 配置名称
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取 级别：1-父选项；2-子选项
	 * 
	 * @return level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * 获取 父选项id
	 * 
	 * @return parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 获取 状态：1-有效；0-无效
	 * 
	 * @return status
	 */
	public Boolean getStatus() {
		return status;
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