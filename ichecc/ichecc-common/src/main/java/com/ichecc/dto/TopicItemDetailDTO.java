package com.ichecc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ichecc.domain.ItemAttributeDO;

public class TopicItemDetailDTO implements Serializable {

	private static final long serialVersionUID = 243072924546589284L;

	/** topicItem 主键ID */
	private Long id;
	private Long topicId;
	/** 专题开始时间 */
	private Date startTime;
	/** 专题结束时间 */
	private Date endTime;
	/** 专题状态 */
	private String status;
	private String periodNo;

	private Long itemId;
	private String itemTitle;
	private String itemSubTitle;
	private Double marketPrice;
	private Double guidePrice;
	private Double specialPrice;
	/** 砍价最大次数 */
	private Integer bargainMaxTimes;
	private Integer residueTimes;
	private Boolean itemStatus;

	private String attributes;
	private List<ItemAttributeDO> attributeList;
	private String picture;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPeriodNo() {
		return periodNo;
	}

	public void setPeriodNo(String periodNo) {
		this.periodNo = periodNo;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemSubTitle() {
		return itemSubTitle;
	}

	public void setItemSubTitle(String itemSubTitle) {
		this.itemSubTitle = itemSubTitle;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(Double guidePrice) {
		this.guidePrice = guidePrice;
	}

	public Double getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}

	public Integer getBargainMaxTimes() {
		return bargainMaxTimes;
	}

	public void setBargainMaxTimes(Integer bargainMaxTimes) {
		this.bargainMaxTimes = bargainMaxTimes;
	}

	public Integer getResidueTimes() {
		return residueTimes;
	}

	public void setResidueTimes(Integer residueTimes) {
		this.residueTimes = residueTimes;
	}

	public Boolean getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Boolean itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public List<ItemAttributeDO> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<ItemAttributeDO> attributeList) {
		this.attributeList = attributeList;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
