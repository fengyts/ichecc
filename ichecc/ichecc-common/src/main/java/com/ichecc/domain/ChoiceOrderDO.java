package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 选车订单
 * 
 * @author fengyts Tue Jun 26 12:10:01 CST 2018
 */

public class ChoiceOrderDO extends BaseDO {

	private static final long serialVersionUID = 3623155716349769028L;

	/** 主键 */
	private Long id;

	/** 订单编号 */
	private String orderNo;

	/** 选车用户 */
	private Long userId;

	/** 预算金额 */
	private String budget;

	/** 品牌 */
	private String brand;

	/** 能源类型 */
	private String energy;

	/** 车辆类型 */
	private String type;

	/** 座位类型 */
	private String seat;

	/** 车型结构 */
	private String structure;

	/** 变速箱 */
	private String gearbox;

	/** 其他需求 */
	private String otherRequirement;

	/** 提交时间 */
	private Date createTime;

	/** 订单处理状态：01-处理中；02-已处理 */
	private String status;

	/** 选车处理反馈结果 */
	private String result;

	/** 处理反馈时间 */
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
	 * 设置 订单编号
	 * 
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * 设置 选车用户
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置 预算金额
	 * 
	 * @param budget
	 */
	public void setBudget(String budget) {
		this.budget = budget;
	}

	/**
	 * 设置 品牌
	 * 
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * 设置 能源类型
	 * 
	 * @param energy
	 */
	public void setEnergy(String energy) {
		this.energy = energy;
	}

	/**
	 * 设置 车辆类型
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 设置 座位类型
	 * 
	 * @param seat
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}

	/**
	 * 设置 车型结构
	 * 
	 * @param structure
	 */
	public void setStructure(String structure) {
		this.structure = structure;
	}

	/**
	 * 设置 变速箱
	 * 
	 * @param gearbox
	 */
	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	/**
	 * 设置 其他需求
	 * 
	 * @param otherRequirement
	 */
	public void setOtherRequirement(String otherRequirement) {
		this.otherRequirement = otherRequirement;
	}

	/**
	 * 设置 提交时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置 订单处理状态：01-处理中；02-已处理
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 设置 选车处理反馈结果
	 * 
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 设置 处理反馈时间
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
	 * 获取 订单编号
	 * 
	 * @return orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * 获取 选车用户
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 获取 预算金额
	 * 
	 * @return budget
	 */
	public String getBudget() {
		return budget;
	}

	/**
	 * 获取 品牌
	 * 
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * 获取 能源类型
	 * 
	 * @return energy
	 */
	public String getEnergy() {
		return energy;
	}

	/**
	 * 获取 车辆类型
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 获取 座位类型
	 * 
	 * @return seat
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * 获取 车型结构
	 * 
	 * @return structure
	 */
	public String getStructure() {
		return structure;
	}

	/**
	 * 获取 变速箱
	 * 
	 * @return gearbox
	 */
	public String getGearbox() {
		return gearbox;
	}

	/**
	 * 获取 其他需求
	 * 
	 * @return otherRequirement
	 */
	public String getOtherRequirement() {
		return otherRequirement;
	}

	/**
	 * 获取 提交时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取 订单处理状态：01-处理中；02-已处理
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 获取 选车处理反馈结果
	 * 
	 * @return result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 获取 处理反馈时间
	 * 
	 * @return modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

}