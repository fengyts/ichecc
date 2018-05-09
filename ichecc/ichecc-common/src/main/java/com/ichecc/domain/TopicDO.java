package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 专题
 * 
 * @author fengyts Wed May 09 09:29:15 CST 2018
 */

public class TopicDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = -636703760907323645L;

	/** 主键 */
	private Long id;

	/** 专题期号 */
	private String periodNo;

	/** 开始时间 */
	private Date startTime;

	/** 结束时间 */
	private Date endTime;

	/** 状态(以开始和结束时间为第一条件)：01-未开始；02-进行中；03-已结束 */
	private String status;

	/** 专题描述 */
	private String description;

	/** 备注 */
	private String remark;

	/** 创建人 */
	private Long createUserId;

	/** 创建时间 */
	private Date createTime;

	/** 修改人 */
	private Long modifyUserId;

	/** 修改时间 */
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
	 * 设置 专题期号
	 * 
	 * @param periodNo
	 */
	public void setPeriodNo(String periodNo) {
		this.periodNo = periodNo;
	}

	/**
	 * 设置 开始时间
	 * 
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 设置 结束时间
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 设置 状态(以开始和结束时间为第一条件)：01-未开始；02-进行中；03-已结束
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 设置 专题描述
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * 设置 创建人
	 * 
	 * @param createUserId
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 设置 创建时间
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
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 获取 专题期号
	 * 
	 * @return periodNo
	 */
	public String getPeriodNo() {
		return periodNo;
	}

	/**
	 * 获取 开始时间
	 * 
	 * @return startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 获取 结束时间
	 * 
	 * @return endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 获取 状态(以开始和结束时间为第一条件)：01-未开始；02-进行中；03-已结束
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 获取 专题描述
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
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
	 * 获取 创建人
	 * 
	 * @return createUserId
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 获取 创建时间
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