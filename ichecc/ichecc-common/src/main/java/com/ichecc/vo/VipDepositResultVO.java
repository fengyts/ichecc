package com.ichecc.vo;

import java.util.Date;

public class VipDepositResultVO extends BaseVO {

	private static final long serialVersionUID = 5882224247271235016L;

	/** 充值时间 */
	private Date startTime;
	/** 会员截至日期 */
	private Date endTime;
	/** 本次充值会员期限 */
	private Integer expiryDate = 0;
	/** 会员剩余总期限 */
	private Integer residueDate = 0;

	private Double realAmount;
	/** 本次充值是否是顺延的有效期 */
	private Boolean isContinue = false;

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

	public Integer getResidueDate() {
		return residueDate;
	}

	public void setResidueDate(Integer residueDate) {
		this.residueDate = residueDate;
	}

	public Double getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}

	public Boolean getIsContinue() {
		return isContinue;
	}

	public void setIsContinue(Boolean isContinue) {
		this.isContinue = isContinue;
	}

}
