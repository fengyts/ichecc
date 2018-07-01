package com.ichecc.vo;

import java.util.Date;

/**
 * <pre>
 * 前端选车记录详情
 * </pre>
 *
 * @author fengyts
 * @version $Id: ChoiceOrderDetailVO.java, v 0.1 2018年7月1日 上午12:13:35 fengyts Exp $
 */
public class ChoiceOrderDetailVO extends ChoiceOrderBaseVO {

	private static final long serialVersionUID = 5072808923399979599L;

	/** 订单处理结果 */
	private String result;

	/** 订单处理时间 */
	private Date handleTime;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

}
