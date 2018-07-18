package com.ichecc.wechat.dto;

import com.ichecc.wechat.BaseValidateDTO;

public class ApiBaseResponseDTO extends BaseValidateDTO {

	private static final long serialVersionUID = -1069492927054302666L;

	static final String SUCCESS = "SUCCESS";
	static final String FAILURE = "FAIL";

	/**
	 * SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
	 */
	private String return_code;
	/**
	 * 当return_code为FAIL时返回信息为错误原因 ， 例如:签名失败、参数格式校验错误 eg1:
	 * <xml><return_code><![CDATA[FAIL]]></return_code>
	 * <return_msg><![CDATA[缺少参数]]></return_msg> </xml>
	 * 
	 * eg2: <xml><return_code><![CDATA[FAIL]]></return_code>
	 * <return_msg><![CDATA[签名错误]]></return_msg> </xml>
	 */
	private String return_msg;

	@Override
	public boolean validate() {
		if (isBlank(return_code) || FAILURE.equals(return_code)) {
			return false;
		}
		return true;
	}

	public boolean validateSys() {
		return validate();
	}

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

}
