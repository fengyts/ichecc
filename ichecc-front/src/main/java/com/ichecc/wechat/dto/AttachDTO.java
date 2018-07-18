package com.ichecc.wechat.dto;

import com.ichecc.wechat.BaseDTO;
import com.ichecc.wechat.constant.AttachConstant;

/**
 * 用户自定义参数封装
 * 
 * @author lenovopc
 *
 */
public class AttachDTO extends BaseDTO {

	private static final long serialVersionUID = 4120441877978770569L;

	/** 系统标识 */
	private String sysIdentify = AttachConstant.ICHECC;

	public String getSysIdentify() {
		return sysIdentify;
	}

	public void setSysIdentify(String sysIdentify) {
		this.sysIdentify = sysIdentify;
	}

	public String toString() {
		return "{\"sysIdentify\":" + sysIdentify + "}";
	}

}
