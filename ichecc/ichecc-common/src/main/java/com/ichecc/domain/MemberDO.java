package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 会员
 * 
 * @author fengyts Wed May 09 09:29:15 CST 2018
 */

public class MemberDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = 2756818063025897564L;

	/** 主键 */
	private Long id;

	/** 会员卡号 */
	private String memberCardNo;

	/** 用户id */
	private Long userId;

	/** 会员开始时间 */
	private Date startTime;

	/** 会员截止时间 */
	private Date endTime;

	/** 创建时间 */
	private Date createTime;

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
	 * 设置 会员卡号
	 * 
	 * @param memberCardNo
	 */
	public void setMemberCardNo(String memberCardNo) {
		this.memberCardNo = memberCardNo;
	}

	/**
	 * 设置 用户id
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置 会员开始时间
	 * 
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 设置 会员截止时间
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	 * 获取 会员卡号
	 * 
	 * @return memberCardNo
	 */
	public String getMemberCardNo() {
		return memberCardNo;
	}

	/**
	 * 获取 用户id
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 获取 会员开始时间
	 * 
	 * @return startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 获取 会员截止时间
	 * 
	 * @return endTime
	 */
	public Date getEndTime() {
		return endTime;
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
	 * 获取 修改时间
	 * 
	 * @return modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

}