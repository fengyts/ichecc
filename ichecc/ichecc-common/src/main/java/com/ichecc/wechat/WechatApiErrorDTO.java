package com.ichecc.wechat;

import com.ichecc.dto.BaseDTO;

/**
 * <pre>
 * 微信接口调用错误信息
 * </pre>
 *
 * @author fengyts
 * @version $Id: WechatApiErrorDTO.java, v 0.1 2018年6月24日 下午4:09:38 fengyts Exp $
 */
public class WechatApiErrorDTO extends BaseDTO {

	private static final long serialVersionUID = 3310360815483334216L;

	private String errcode;
	private String errmsg;
	private String hints;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getHints() {
		return hints;
	}

	public void setHints(String hints) {
		this.hints = hints;
	}

}
