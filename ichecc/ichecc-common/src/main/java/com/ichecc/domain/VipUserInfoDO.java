package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * vip会员用户信息
 * 
 * @author fengyts Fri Jul 06 16:07:17 CST 2018
 */

public class VipUserInfoDO extends BaseDO {

	private static final long serialVersionUID = 6890195297738251616L;

	/** 主键 */
	private Long userId;

	/** 会员卡号 */
	private String vipCardNo;

	/** 会员生效时间 */
	private Date startTime;

	/** 会员截止日期 */
	private Date endTime;

	/** 是否是新会员（第一次充值）：1-是；0-不是 */
	private Boolean isNew;

	/**
	 * 设置 主键
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置 会员卡号
	 * 
	 * @param vipCardNo
	 */
	public void setVipCardNo(String vipCardNo) {
		this.vipCardNo = vipCardNo;
	}

	/**
	 * 设置 会员生效时间
	 * 
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
	 * 设置 是否是新会员（第一次充值）：1-是；0-不是
	 * 
	 * @param isNew
	 */
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	/**
	 * 获取 主键
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 获取 会员卡号
	 * 
	 * @return vipCardNo
	 */
	public String getVipCardNo() {
		return vipCardNo;
	}

	/**
	 * 获取 会员生效时间
	 * 
	 * @return startTime
	 */
	public Date getStartTime() {
		return startTime;
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
	 * 获取 是否是新会员（第一次充值）：1-是；0-不是
	 * 
	 * @return isNew
	 */
	public Boolean getIsNew() {
		return isNew;
	}

}