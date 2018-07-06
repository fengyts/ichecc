package com.ichecc.vo;

import java.util.Date;

public class VipInfoVO extends BaseVO {

	private static final long serialVersionUID = -7639850359948825806L;

	private Long userId;

	private String vipCardNo;

//	/** 是否曾经是vip，即至少一次充值 ,默认充值过 */
//	private Boolean isVipEver = true;
//
//	/** 是否是新会员（第一次充值）：1-是；0-不是 */
//	private Boolean isNew;
	
	/** vip类型：01-从没充值过，不是会员；02-第一次充值，新会员；03-至少一次充值过，老会员 */
	private String vipCate;

	/** 充值时间 */
	private Date startTime;
	/** 会员截至日期 */
	private Date endTime;

	/** 是否vip, 根据截至日期计算 ：true-是vip */
	private Boolean isVip = false;
	/** 会员剩余天数(天数),根据截至日期计算 */
	private Integer expiryDate = 0;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getVipCardNo() {
		return vipCardNo;
	}

	public void setVipCardNo(String vipCardNo) {
		this.vipCardNo = vipCardNo;
	}

	public String getVipCate() {
		return vipCate;
	}

	public void setVipCate(String vipCate) {
		this.vipCate = vipCate;
	}

	public Boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Integer expiryDate) {
		this.expiryDate = expiryDate;
	}

}
