package com.ichecc.front.dto;

import java.io.Serializable;

public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = -6199824418687029745L;

	/**
	 * 参数校验
	 * @return true-校验通过；false-参数不合规
	 */
	protected abstract boolean validate();
	
	/**
     * <p>Checks if a CharSequence is whitespace, empty ("") or null.</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace
     * @since 2.0
     * @since 3.0 Changed signature from isBlank(String) to isBlank(CharSequence)
     */
	protected static boolean isBlank(CharSequence attr) {
		int len;
		if (null == attr || 0 == (len = attr.length())) {
			return true;
		}
		for (int i = 0; i < len; i++) {
			if(!Character.isWhitespace(attr.charAt(i))){
				return false;
			}
		}
		return true;
	}
	

}
