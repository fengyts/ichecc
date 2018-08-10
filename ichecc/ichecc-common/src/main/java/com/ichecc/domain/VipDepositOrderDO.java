package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * vip会员充值订单
 * 
 * @author fengyts Fri Aug 10 14:44:06 CST 2018
 */

public class VipDepositOrderDO extends BaseDO {

	private static final long serialVersionUID = 3561577169184238766L;

	/** 主键 */
	private Long id;

	/** 订单编号，全局唯一 */
	private String orderNo;

	/** 用户id */
	private Long userId;

	/** 用户openid,冗余 */
	private String openid;

	/** 预支付订单id */
	private String prepayId;

	/** 订单状态:01-待支付；02-支付成功；03:-支付失败；04-支付超时 */
	private String orderStatus;

	/** 微信支付订单号，查询订单或支付结果通知时返回 */
	private String transactionId;

	/** 充值配置选项id */
	private Long configId;

	/** 原始金额 */
	private Double originalAmount;

	/** 折扣值 */
	private Double discount;

	/** 实际充值金额，即折扣后的金额,单位:元 */
	private Double realAmount;

	/** 充值期限类型: 01-按天；02-按月 */
	private String expiryType;

	/** 充值会员期限 */
	private Integer expiryDate;

	/**
	 * 交易状态,查询订单时返回：SUCCESS-支付成功;REFUND-转入退款;NOTPAY-未支付;CLOSED-已关闭;REVOKED-已撤销（
	 * 刷卡支付）;USERPAYING-用户支付中;PAYERROR-支付失败(其他原因，如银行返回失败)
	 */
	private String tradeState;

	/** 交易状态描述，查询订单或支付结果通知时返回 */
	private String tradeStateDesc;

	/** 付款银行代码，查询订单或支付结果通知时返回 */
	private String bankType;

	/** 订单支付完成时间，查询订单或支付结果通知时返回 */
	private Date timeEnd;

	/** 下单时间 */
	private Date createTime;

	/** 订单状态更新(支付)时间 */
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
	 * 设置 订单编号，全局唯一
	 * 
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	 * 设置 用户openid,冗余
	 * 
	 * @param openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 设置 预支付订单id
	 * 
	 * @param prepayId
	 */
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	/**
	 * 设置 订单状态:01-待支付；02-支付成功；03:-支付失败；04-支付超时
	 * 
	 * @param orderStatus
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * 设置 微信支付订单号，查询订单或支付结果通知时返回
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * 设置 充值配置选项id
	 * 
	 * @param configId
	 */
	public void setConfigId(Long configId) {
		this.configId = configId;
	}

	/**
	 * 设置 原始金额
	 * 
	 * @param originalAmount
	 */
	public void setOriginalAmount(Double originalAmount) {
		this.originalAmount = originalAmount;
	}

	/**
	 * 设置 折扣值
	 * 
	 * @param discount
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * 设置 实际充值金额，即折扣后的金额,单位:元
	 * 
	 * @param realAmount
	 */
	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}

	/**
	 * 设置 充值期限类型: 01-按天；02-按月
	 * 
	 * @param expiryType
	 */
	public void setExpiryType(String expiryType) {
		this.expiryType = expiryType;
	}

	/**
	 * 设置 充值会员期限
	 * 
	 * @param expiryDate
	 */
	public void setExpiryDate(Integer expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * 设置
	 * 交易状态,查询订单时返回：SUCCESS-支付成功;REFUND-转入退款;NOTPAY-未支付;CLOSED-已关闭;REVOKED-已撤销（
	 * 刷卡支付）;USERPAYING-用户支付中;PAYERROR-支付失败(其他原因，如银行返回失败)
	 * 
	 * @param tradeState
	 */
	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	/**
	 * 设置 交易状态描述，查询订单或支付结果通知时返回
	 * 
	 * @param tradeStateDesc
	 */
	public void setTradeStateDesc(String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}

	/**
	 * 设置 付款银行代码，查询订单或支付结果通知时返回
	 * 
	 * @param bankType
	 */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	/**
	 * 设置 订单支付完成时间，查询订单或支付结果通知时返回
	 * 
	 * @param timeEnd
	 */
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	/**
	 * 设置 下单时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置 订单状态更新(支付)时间
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
	 * 获取 订单编号，全局唯一
	 * 
	 * @return orderNo
	 */
	public String getOrderNo() {
		return orderNo;
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
	 * 获取 用户openid,冗余
	 * 
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 获取 预支付订单id
	 * 
	 * @return prepayId
	 */
	public String getPrepayId() {
		return prepayId;
	}

	/**
	 * 获取 订单状态:01-待支付；02-支付成功；03:-支付失败；04-支付超时
	 * 
	 * @return orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * 获取 微信支付订单号，查询订单或支付结果通知时返回
	 * 
	 * @return transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * 获取 充值配置选项id
	 * 
	 * @return configId
	 */
	public Long getConfigId() {
		return configId;
	}

	/**
	 * 获取 原始金额
	 * 
	 * @return originalAmount
	 */
	public Double getOriginalAmount() {
		return originalAmount;
	}

	/**
	 * 获取 折扣值
	 * 
	 * @return discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * 获取 实际充值金额，即折扣后的金额,单位:元
	 * 
	 * @return realAmount
	 */
	public Double getRealAmount() {
		return realAmount;
	}

	/**
	 * 获取 充值期限类型: 01-按天；02-按月
	 * 
	 * @return expiryType
	 */
	public String getExpiryType() {
		return expiryType;
	}

	/**
	 * 获取 充值会员期限
	 * 
	 * @return expiryDate
	 */
	public Integer getExpiryDate() {
		return expiryDate;
	}

	/**
	 * 获取
	 * 交易状态,查询订单时返回：SUCCESS-支付成功;REFUND-转入退款;NOTPAY-未支付;CLOSED-已关闭;REVOKED-已撤销（
	 * 刷卡支付）;USERPAYING-用户支付中;PAYERROR-支付失败(其他原因，如银行返回失败)
	 * 
	 * @return tradeState
	 */
	public String getTradeState() {
		return tradeState;
	}

	/**
	 * 获取 交易状态描述，查询订单或支付结果通知时返回
	 * 
	 * @return tradeStateDesc
	 */
	public String getTradeStateDesc() {
		return tradeStateDesc;
	}

	/**
	 * 获取 付款银行代码，查询订单或支付结果通知时返回
	 * 
	 * @return bankType
	 */
	public String getBankType() {
		return bankType;
	}

	/**
	 * 获取 订单支付完成时间，查询订单或支付结果通知时返回
	 * 
	 * @return timeEnd
	 */
	public Date getTimeEnd() {
		return timeEnd;
	}

	/**
	 * 获取 下单时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取 订单状态更新(支付)时间
	 * 
	 * @return modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

}