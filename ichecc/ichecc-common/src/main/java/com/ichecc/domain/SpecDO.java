package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 规格
 * 
 * @author fengyts Mon Jun 04 14:08:03 CST 2018
 */

public class SpecDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = -2630966976814853768L;

	/** 主键 */
	private Long id;

	/** 规格值 */
	private String specValue;

	/** 排序值 */
	private Integer sort;

	/** 规格状态：1-有效；0-无效 */
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
	 * 设置 规格值
	 * 
	 * @param specValue
	 */
	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}

	/**
	 * 设置 排序值
	 * 
	 * @param sort
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 设置 规格状态：1-有效；0-无效
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
	 * 获取 规格值
	 * 
	 * @return specValue
	 */
	public String getSpecValue() {
		return specValue;
	}

	/**
	 * 获取 排序值
	 * 
	 * @return sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 获取 规格状态：1-有效；0-无效
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