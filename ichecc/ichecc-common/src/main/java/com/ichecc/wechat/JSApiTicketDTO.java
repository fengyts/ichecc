package com.ichecc.wechat;

import com.ichecc.dto.BaseDTO;

/**
 * 微信JS接口的临时票据
 * 
 * @author lenovopc
 *
 */
public class JSApiTicketDTO extends BaseDTO {

	private static final long serialVersionUID = 1301846801877900886L;

	private String errcode;
	private String errmsg;
	private String ticket;
	private Integer expires_in;

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

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

}
