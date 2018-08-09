package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 会员充值选项配置
 * 
 * @author fengyts Thu Aug 09 16:13:39 CST 2018
 */

public class VipDepositConfigDO extends BaseDO {

	private static final long serialVersionUID = 5210995158419868873L;

	/** 主键 */
	private Long id;

	/** 充值金额 */
	private Double amount;

	/** 折扣,范围区间:(0,1],如95折则为0.95,默认无折扣为1 */
	private Double discount;

	/** 有效期限，含当天 */
	private Integer expiryDate;

	/** 期限类型: 01-按天；02-按月 */
	private String expiryType;

	/** 配置生效状态：1-有效；0-无效 */
	private Boolean status;

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
	 * 设置 充值金额
	 * 
	 * @param amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * 设置 折扣,范围区间:(0,1],如95折则为0.95,默认无折扣为1
	 * 
	 * @param discount
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * 设置 有效期限，含当天
	 * 
	 * @param expiryDate
	 */
	public void setExpiryDate(Integer expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * 设置 期限类型: 01-按天；02-按月
	 * 
	 * @param expiryType
	 */
	public void setExpiryType(String expiryType) {
		this.expiryType = expiryType;
	}

	/**
	 * 设置 配置生效状态：1-有效；0-无效
	 * 
	 * @param status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
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
	 * 获取 充值金额
	 * 
	 * @return amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * 获取 折扣,范围区间:(0,1],如95折则为0.95,默认无折扣为1
	 * 
	 * @return discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * 获取 有效期限，含当天
	 * 
	 * @return expiryDate
	 */
	public Integer getExpiryDate() {
		return expiryDate;
	}

	/**
	 * 获取 期限类型: 01-按天；02-按月
	 * 
	 * @return expiryType
	 */
	public String getExpiryType() {
		return expiryType;
	}

	/**
	 * 获取 配置生效状态：1-有效；0-无效
	 * 
	 * @return status
	 */
	public Boolean getStatus() {
		return status;
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