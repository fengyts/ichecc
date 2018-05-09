package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 会员充值记录
 * 
 * @author fengyts Wed May 09 09:29:16 CST 2018
 */

public class DepositRecordDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = -2327458936900056480L;

	/** 主键 */
	private Long id;

	/** 充值人 */
	private Long userId;

	/** 充值金额 */
	private Double depositAmount;

	/** 充值折扣，默认值为1，即无折扣 */
	private Double discount;

	/** 充值时间（会员生效时间） */
	private Date createTime;

	/** 会员截止日期 */
	private Date endTime;

	/** 会员有效期（冗余） */
	private Integer expiryDate;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 充值人
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置 充值金额
	 * 
	 * @param depositAmount
	 */
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	/**
	 * 设置 充值折扣，默认值为1，即无折扣
	 * 
	 * @param discount
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * 设置 充值时间（会员生效时间）
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置 会员截止日期
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 设置 会员有效期（冗余）
	 * 
	 * @param expiryDate
	 */
	public void setExpiryDate(Integer expiryDate) {
		this.expiryDate = expiryDate;
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
	 * 获取 充值人
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 获取 充值金额
	 * 
	 * @return depositAmount
	 */
	public Double getDepositAmount() {
		return depositAmount;
	}

	/**
	 * 获取 充值折扣，默认值为1，即无折扣
	 * 
	 * @return discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * 获取 充值时间（会员生效时间）
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取 会员截止日期
	 * 
	 * @return endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 获取 会员有效期（冗余）
	 * 
	 * @return expiryDate
	 */
	public Integer getExpiryDate() {
		return expiryDate;
	}

}