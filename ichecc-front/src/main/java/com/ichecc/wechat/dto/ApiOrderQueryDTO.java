package com.ichecc.wechat.dto;

/**
 * 支付订单查询参数
 * 
 * @author lenovopc
 *
 */
public class ApiOrderQueryDTO extends ApiCommonDTO {

	private static final long serialVersionUID = 3425263407245264167L;

	// transaction_id 和 out_trade_no 必须有一个不为空

	/** 微信的订单号，建议优先使用 */
	private String transaction_id;
	/** 商户订单号 */
	private String out_trade_no;

	@Override
	public boolean validate() {
		if (!super.validate()) {
			return false;
		}
		if (isBlank(transaction_id) && isBlank(out_trade_no)) {
			return false;
		}
		return true;
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

}
