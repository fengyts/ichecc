package com.ichecc.wechat;

public class ApiCommonResponseDTO extends ApiBaseResponseDTO {

	private static final long serialVersionUID = -5493071813651554977L;

	private String appid;
	private String mch_id;
	private String nonce_str;
	private String sign;

	/** 自定义参数，可以为请求支付的终端设备号等 */
	private String device_info;

	/** 业务结果: SUCCESS/FAIL */
	private String result_code;
	/** 当result_code为FAIL时返回错误代码，详细参见错误列表 */
	private String err_code;
	/** 当result_code为FAIL时返回错误描述，详细参见错误列表 */
	private String err_code_des;

	@Override
	public boolean validate() {
		if (!super.validate()) {
			return false;
		}
		if (isBlank(result_code) || FAILURE.equals(result_code)) {
			return false;
		}
		return true;
	}
	
	public boolean validateBiz(){
//		return validate();
		return (isBlank(result_code) || FAILURE.equals(result_code));
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

}
