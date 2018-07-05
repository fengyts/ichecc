package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 专题商品
 * 
 * @author fengyts Thu Jul 05 10:34:39 CST 2018
 */

public class TopicItemDO extends BaseDO {

	private static final long serialVersionUID = 1793379954188082277L;

	/** 主键 */
	private Long id;

	/** 专题id */
	private Long topicId;

	/** 商品id */
	private Long itemId;

	/** 商品名称（冗余字段） */
	private String itemTitle;

	/** 副标题（冗余字段） */
	private String subTitle;

	/** 市场价（冗余字段） */
	private Double marketPrice;

	/** 指导价,默认为tiem的指导价 */
	private Double guidePrice;

	/** 特卖价 */
	private Double specialPrice;

	/** 允许砍价金额，该值<=指导价减去特卖价 */
	private Double bargainAmount;

	/** 砍价最大次数 */
	private Integer bargainMaxTimes;

	/** 默认已参与人数 */
	private Integer participationNum;

	/** 专题商品在专题排序值 */
	private Integer sort;

	/** 专题商品是否上线：1-上线；0-下线 */
	private Boolean status;

	/** 特卖描述,关联商品属性表id,多个属性用逗号分隔 */
	private String attributes;

	/** 是否有人砍价成功：1-是；0-否 */
	private Boolean isSuccess;

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
	 * 设置 专题id
	 * 
	 * @param topicId
	 */
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	/**
	 * 设置 商品id
	 * 
	 * @param itemId
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * 设置 商品名称（冗余字段）
	 * 
	 * @param itemTitle
	 */
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	/**
	 * 设置 副标题（冗余字段）
	 * 
	 * @param subTitle
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * 设置 市场价（冗余字段）
	 * 
	 * @param marketPrice
	 */
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	/**
	 * 设置 指导价,默认为tiem的指导价
	 * 
	 * @param guidePrice
	 */
	public void setGuidePrice(Double guidePrice) {
		this.guidePrice = guidePrice;
	}

	/**
	 * 设置 特卖价
	 * 
	 * @param specialPrice
	 */
	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}

	/**
	 * 设置 允许砍价金额，该值<=指导价减去特卖价
	 * 
	 * @param bargainAmount
	 */
	public void setBargainAmount(Double bargainAmount) {
		this.bargainAmount = bargainAmount;
	}

	/**
	 * 设置 砍价最大次数
	 * 
	 * @param bargainMaxTimes
	 */
	public void setBargainMaxTimes(Integer bargainMaxTimes) {
		this.bargainMaxTimes = bargainMaxTimes;
	}

	/**
	 * 设置 默认已参与人数
	 * 
	 * @param participationNum
	 */
	public void setParticipationNum(Integer participationNum) {
		this.participationNum = participationNum;
	}

	/**
	 * 设置 专题商品在专题排序值
	 * 
	 * @param sort
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 设置 专题商品是否上线：1-上线；0-下线
	 * 
	 * @param status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * 设置 特卖描述,关联商品属性表id,多个属性用逗号分隔
	 * 
	 * @param attributes
	 */
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	/**
	 * 设置 是否有人砍价成功：1-是；0-否
	 * 
	 * @param isSuccess
	 */
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
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
	 * 获取 专题id
	 * 
	 * @return topicId
	 */
	public Long getTopicId() {
		return topicId;
	}

	/**
	 * 获取 商品id
	 * 
	 * @return itemId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * 获取 商品名称（冗余字段）
	 * 
	 * @return itemTitle
	 */
	public String getItemTitle() {
		return itemTitle;
	}

	/**
	 * 获取 副标题（冗余字段）
	 * 
	 * @return subTitle
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * 获取 市场价（冗余字段）
	 * 
	 * @return marketPrice
	 */
	public Double getMarketPrice() {
		return marketPrice;
	}

	/**
	 * 获取 指导价,默认为tiem的指导价
	 * 
	 * @return guidePrice
	 */
	public Double getGuidePrice() {
		return guidePrice;
	}

	/**
	 * 获取 特卖价
	 * 
	 * @return specialPrice
	 */
	public Double getSpecialPrice() {
		return specialPrice;
	}

	/**
	 * 获取 允许砍价金额，该值<=指导价减去特卖价
	 * 
	 * @return bargainAmount
	 */
	public Double getBargainAmount() {
		return bargainAmount;
	}

	/**
	 * 获取 砍价最大次数
	 * 
	 * @return bargainMaxTimes
	 */
	public Integer getBargainMaxTimes() {
		return bargainMaxTimes;
	}

	/**
	 * 获取 默认已参与人数
	 * 
	 * @return participationNum
	 */
	public Integer getParticipationNum() {
		return participationNum;
	}

	/**
	 * 获取 专题商品在专题排序值
	 * 
	 * @return sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 获取 专题商品是否上线：1-上线；0-下线
	 * 
	 * @return status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * 获取 特卖描述,关联商品属性表id,多个属性用逗号分隔
	 * 
	 * @return attributes
	 */
	public String getAttributes() {
		return attributes;
	}

	/**
	 * 获取 是否有人砍价成功：1-是；0-否
	 * 
	 * @return isSuccess
	 */
	public Boolean getIsSuccess() {
		return isSuccess;
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