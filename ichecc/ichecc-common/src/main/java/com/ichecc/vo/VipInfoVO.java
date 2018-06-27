package com.ichecc.vo;

import java.util.Date;

public class VipInfoVO extends BaseVO {

	private static final long serialVersionUID = -7639850359948825806L;

	private Long userId;

	/** 充值时间 */
	private Date createTime;
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

	public Boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
