package com.ichecc.vo;

import java.util.Date;

/**
 * <pre>
 * 选车记录前端列表页vo
 * </pre>
 *
 * @author fengyts
 * @version $Id: ChoiceOrderBaseVO.java, v 0.1 2018年7月1日 上午12:13:09 fengyts Exp $
 */
public class ChoiceOrderBaseVO extends BaseVO {

	private static final long serialVersionUID = -7771931934584670848L;

	/** 选车记录id */
	private Long orderId;

	/** 选车详细需求 */
	private String choiceRequirement;

	/** 选车订单处理状态 */
	private String orderStatus;

	/** 状态描述 */
	private String orderStatusDesc;

	/** 选车订单提交时间 */
	private Date choiceOrderTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getChoiceRequirement() {
		return choiceRequirement;
	}

	public void setChoiceRequirement(String choiceRequirement) {
		this.choiceRequirement = choiceRequirement;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusDesc() {
		return orderStatusDesc;
	}

	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
	}

	public Date getChoiceOrderTime() {
		return choiceOrderTime;
	}

	public void setChoiceOrderTime(Date choiceOrderTime) {
		this.choiceOrderTime = choiceOrderTime;
	}

}
