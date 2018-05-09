package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 商品
 * 
 * @author fengyts Wed May 09 09:29:18 CST 2018
 */

public class ItemDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = 8172080176073130731L;

	/** 主键 */
	private Long id;

	/** 商品名称 */
	private String itemTitle;

	/** 副标题 */
	private String subTitle;

	/** 市场价 */
	private Double marketPrice;

	/** 商品状态(是否上架)：0-未上架；1-已上架；2-已作废 */
	private Integer status;

	/** 备注 */
	private String remark;

	/** 创建人 */
	private Long createUserId;

	/** 创建时间 */
	private Date createTime;

	/** 修改人 */
	private Long modifyUserId;

	/** 修改时间 */
	private Date modifyTime;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 商品名称
	 * 
	 * @param itemTitle
	 */
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	/**
	 * 设置 副标题
	 * 
	 * @param subTitle
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * 设置 市场价
	 * 
	 * @param marketPrice
	 */
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	/**
	 * 设置 商品状态(是否上架)：0-未上架；1-已上架；2-已作废
	 * 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 设置 备注
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 设置 创建人
	 * 
	 * @param createUserId
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 设置 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置 修改人
	 * 
	 * @param modifyUserId
	 */
	public void setModifyUserId(Long modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	/**
	 * 设置 修改时间
	 * 
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 获取 主键
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 获取 商品名称
	 * 
	 * @return itemTitle
	 */
	public String getItemTitle() {
		return itemTitle;
	}

	/**
	 * 获取 副标题
	 * 
	 * @return subTitle
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * 获取 市场价
	 * 
	 * @return marketPrice
	 */
	public Double getMarketPrice() {
		return marketPrice;
	}

	/**
	 * 获取 商品状态(是否上架)：0-未上架；1-已上架；2-已作废
	 * 
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 获取 备注
	 * 
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 获取 创建人
	 * 
	 * @return createUserId
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 获取 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取 修改人
	 * 
	 * @return modifyUserId
	 */
	public Long getModifyUserId() {
		return modifyUserId;
	}

	/**
	 * 获取 修改时间
	 * 
	 * @return modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

}