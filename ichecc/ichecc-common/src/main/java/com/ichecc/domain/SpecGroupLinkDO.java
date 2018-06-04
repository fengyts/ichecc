package com.ichecc.domain;

import ng.bayue.common.BaseDO;

/**
 * 规格组关联规格
 * 
 * @author fengyts Mon Jun 04 14:08:05 CST 2018
 */

public class SpecGroupLinkDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = -874947796746366641L;

	/** 主键 */
	private Long specGroupId;

	/**  */
	private Long specId;

	/**
	 * 设置 主键
	 * 
	 * @param specGroupId
	 */
	public void setSpecGroupId(Long specGroupId) {
		this.specGroupId = specGroupId;
	}

	/**
	 * 设置
	 * 
	 * @param specId
	 */
	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	/**
	 * 获取 主键
	 * 
	 * @return specGroupId
	 */
	public Long getSpecGroupId() {
		return specGroupId;
	}

	/**
	 * 获取
	 * 
	 * @return specId
	 */
	public Long getSpecId() {
		return specId;
	}

}