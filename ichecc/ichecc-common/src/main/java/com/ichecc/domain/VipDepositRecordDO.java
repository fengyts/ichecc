package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 会员充值记录
 * 
 * @author fengyts Fri Aug 10 14:44:06 CST 2018
 */

public class VipDepositRecordDO extends BaseDO {

	private static final long serialVersionUID = 3323780006362828498L;

	/** 主键 */
	private Long id;

	/** 充值人 */
	private Long userId;

	/** 充值订单号 */
	private String orderNo;

	/** 实际充值金额 */
	private Double realAmount;

	/** 充值时间（会员生效时间） */
	private Date createTime;

	/** 会员截止日期 */
	private Date endTime;

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
	 * 设置 充值订单号
	 * 
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * 设置 实际充值金额
	 * 
	 * @param realAmount
	 */
	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
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
	 * 获取 充值订单号
	 * 
	 * @return orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * 获取 实际充值金额
	 * 
	 * @return realAmount
	 */
	public Double getRealAmount() {
		return realAmount;
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

}