package com.ichecc.front.dto;

import java.io.Serializable;

public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = -6199824418687029745L;

	/**
	 * 参数校验
	 * @return true-校验通过；false-参数不合规
	 */
	protected abstract boolean validate();

}
