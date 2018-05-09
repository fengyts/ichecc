package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 会员充值选项配置
 * 
 * @author fengyts Wed May 09 09:29:16 CST 2018
 */

public class VipDepositConfigDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = -4337624942583337889L;

	/** 主键 */
	private Long id;

	/** 充值金额 */
	private Double depositAmount;

	/** 有效期：月份值（按每月30天算） */
	private Integer expiryDate;

	/** 折扣,范围区间:(0,1],如95折则为0.95,默认无折扣为1 */
	private Double discount;

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
	 * @param depositAmount
	 */
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	/**
	 * 设置 有效期：月份值（按每月30天算）
	 * 
	 * @param expiryDate
	 */
	public void setExpiryDate(Integer expiryDate) {
		this.expiryDate = expiryDate;
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
	 * @return depositAmount
	 */
	public Double getDepositAmount() {
		return depositAmount;
	}

	/**
	 * 获取 有效期：月份值（按每月30天算）
	 * 
	 * @return expiryDate
	 */
	public Integer getExpiryDate() {
		return expiryDate;
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