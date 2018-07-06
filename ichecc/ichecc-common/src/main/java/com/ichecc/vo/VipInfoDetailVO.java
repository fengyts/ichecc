package com.ichecc.vo;

public class VipInfoDetailVO extends BaseVO {

	private static final long serialVersionUID = 387301223313702827L;

	private VipInfoVO vipInfo;

	/** 会员权益 */
	private String vipBenefit;

	/** 会员注意事项 */
	private String vipNotice;

	public VipInfoVO getVipInfo() {
		return vipInfo;
	}

	public void setVipInfo(VipInfoVO vipInfo) {
		this.vipInfo = vipInfo;
	}

	public String getVipBenefit() {
		return vipBenefit;
	}

	public void setVipBenefit(String vipBenefit) {
		this.vipBenefit = vipBenefit;
	}

	public String getVipNotice() {
		return vipNotice;
	}

	public void setVipNotice(String vipNotice) {
		this.vipNotice = vipNotice;
	}

}
