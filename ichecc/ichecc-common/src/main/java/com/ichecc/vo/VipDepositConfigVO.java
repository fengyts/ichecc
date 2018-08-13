package com.ichecc.vo;

/**
 * 充值配置选项数据
 * 
 * @author lenovopc
 *
 */
public class VipDepositConfigVO extends BaseVO {

	private static final long serialVersionUID = 3025072996725854087L;

	private Long id;
	private Double amount;
	private Integer expiryDate;
	private String expiryType;
	/** 营销描述 */
	private String attractDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Integer expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getExpiryType() {
		return expiryType;
	}

	public void setExpiryType(String expiryType) {
		this.expiryType = expiryType;
	}

	public String getAttractDesc() {
		return attractDesc;
	}

	public void setAttractDesc(String attractDesc) {
		this.attractDesc = attractDesc;
	}

}
