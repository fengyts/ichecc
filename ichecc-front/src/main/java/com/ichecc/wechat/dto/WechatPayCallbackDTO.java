package com.ichecc.wechat.dto;

public class WechatPayCallbackDTO extends ApiCommonResponseDTO {

	private static final long serialVersionUID = -8394230874315147351L;

	private String openid;
	/** 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效 */
	private String is_subscribe;
	/** 交易类型:JSAPI、NATIVE、APP */
	private String trade_type;
	private String bank_type;
	private Integer total_fee;
	/** 应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。 */
	private Integer settlement_total_fee;
	/** 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型 */
	private String fee_type;
	/** 现金支付金额订单现金支付金额，详见支付金额 */
	private Integer cash_fee;
	/** 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型 */
	private String cash_fee_type;
	/** 代金券金额<=订单金额，订单金额-代金券金额=现金支付金额，详见支付金额 */
	private Integer coupon_fee;
	/** 代金券使用数量 */
	private Integer coupon_count;
	/**
	 * CASH--充值代金券; NO_CASH---非充值代金券
	 * 并且订单使用了免充值券后有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_0
	 */
	private String coupon_type_$n;
	/** 代金券ID,$n为下标，从0开始编号 */
	private String coupon_id_$n;
	/** 单个代金券支付金额,$n为下标，从0开始编号 */
	private Integer coupon_fee_$n;
	/** 微信支付订单号 */
	private String transaction_id;
	/** 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一 */
	private String out_trade_no;
	/** 商家数据包，原样返回 */
	private String attach;
	/**
	 * 支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
	 */
	private String time_end;

	@Override
	public boolean validate() {
		if (!super.validate()) {
			return false;
		}

		if (isBlank(openid)) {
			return false;
		}
		if (isBlank(trade_type)) {
			return false;
		}
		if (isBlank(bank_type)) {
			return false;
		}
		if (null == total_fee || total_fee <= 0) {
			return false;
		}
		if (null == cash_fee || cash_fee <= 0) {
			return false;
		}
		if (isBlank(transaction_id)) {
			return false;
		}
		if (isBlank(out_trade_no)) {
			return false;
		}
		if (isBlank(time_end)) {
			return false;
		}

		return true;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public Integer getSettlement_total_fee() {
		return settlement_total_fee;
	}

	public void setSettlement_total_fee(Integer settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public Integer getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(Integer coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public Integer getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(Integer coupon_count) {
		this.coupon_count = coupon_count;
	}

	public String getCoupon_type_$n() {
		return coupon_type_$n;
	}

	public void setCoupon_type_$n(String coupon_type_$n) {
		this.coupon_type_$n = coupon_type_$n;
	}

	public String getCoupon_id_$n() {
		return coupon_id_$n;
	}

	public void setCoupon_id_$n(String coupon_id_$n) {
		this.coupon_id_$n = coupon_id_$n;
	}

	public Integer getCoupon_fee_$n() {
		return coupon_fee_$n;
	}

	public void setCoupon_fee_$n(Integer coupon_fee_$n) {
		this.coupon_fee_$n = coupon_fee_$n;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

}
