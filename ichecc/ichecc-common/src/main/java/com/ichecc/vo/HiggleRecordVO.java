package com.ichecc.vo;

import java.util.List;

/**
 * <pre>
 * 砍价记录数据封装
 * </pre>
 *
 * @author fengyts
 * @version $Id: HiggleRecordVO.java, v 0.1 2018年7月1日 上午12:32:55 fengyts Exp $
 */
public class HiggleRecordVO extends BaseVO {

	private static final long serialVersionUID = -1232626429278634271L;

	/** 自己砍价次数 */
	private Integer bargainCountSelf;
	/** 别人帮砍次数 */
	private Integer bargainCountOther;

	private List<HiggleListVO> records;

	public Integer getBargainCountSelf() {
		return bargainCountSelf;
	}

	public void setBargainCountSelf(Integer bargainCountSelf) {
		this.bargainCountSelf = bargainCountSelf;
	}

	public Integer getBargainCountOther() {
		return bargainCountOther;
	}

	public void setBargainCountOther(Integer bargainCountOther) {
		this.bargainCountOther = bargainCountOther;
	}

	public List<HiggleListVO> getRecords() {
		return records;
	}

	public void setRecords(List<HiggleListVO> records) {
		this.records = records;
	}

}
