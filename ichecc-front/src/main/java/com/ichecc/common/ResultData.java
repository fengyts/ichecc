package com.ichecc.common;

import java.io.Serializable;

public class ResultData implements Serializable {

	private static final long serialVersionUID = 4652614684172657081L;

	public static final String SUCCESS = "1";
	public static final String FAILURE = "0";

	private String code = SUCCESS;
	private String message;
	private Object data;

	public ResultData() {
	}

	public ResultData(String code, String message) {
		this(code, message, null);
	}

	public ResultData(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ResultData success() {
		return new ResultData();
	}

	public static ResultData success(Object data) {
		return new ResultData(SUCCESS, null, data);
	}

	public static ResultData failure(String message) {
		return new ResultData(FAILURE, message);
	}

	public static ResultData failure(String message, Object data) {
		return new ResultData(FAILURE, message, data);
	}

}
