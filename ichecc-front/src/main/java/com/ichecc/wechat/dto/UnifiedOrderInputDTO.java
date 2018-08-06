package com.ichecc.wechat.dto;

import com.ichecc.wechat.BaseValidateDTO;

/**
 * <pre>
 * 用户充值前台传入的参数
 * </pre>
 *
 * @author fengyts
 * @version $Id: UnifiedOrderIInputDTO.java, v 0.1 2018年7月28日 下午4:35:40 fengyts
 *          Exp $
 */
public class UnifiedOrderInputDTO extends BaseValidateDTO {

	private static final long serialVersionUID = -575255333174490297L;

	private Long userId;
	/** 优惠折扣id */
	private Long discountId;
	/** 充值选项id */
	private Long depositConfigId;
	/** 充值金额 */
	private Double depositAmount;

	private String body;
	private String ip;
	private String attach;

	@Override
	protected boolean validate() {
		return false;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public Long getDepositConfigId() {
		return depositConfigId;
	}

	public void setDepositConfigId(Long depositConfigId) {
		this.depositConfigId = depositConfigId;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

}
