package com.ichecc.wechat;

public class UnifiedOrderResponseDTO extends ApiCommonResponseDTO {

	private static final long serialVersionUID = 8083988534592350156L;

	/**
	 * JSAPI-公众号支付 NATIVE-扫码支付 APP-APP支付
	 * 
	 * 说明详见参数规定
	 */
	private String trade_type;
	/** 微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时 */
	private String prepay_id;
	/** trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付 */
	private String code_url;

	@Override
	public boolean validate() {
		if (!super.validate()) {
			return false;
		}
		if (isBlank(trade_type) || isBlank(prepay_id)) {
			return false;
		}
		return true;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public String getCode_url() {
		return code_url;
	}

	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}

}
