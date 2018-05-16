package com.ichecc.dto;

import java.io.Serializable;
import java.util.Date;

public class TopicItemDTO implements Serializable {

	private static final long serialVersionUID = -4998297441365163831L;

	/** topicItem 主键ID */
	private Long id;
	private Long topicId;
	/** 专题类型 */
	private String topicType;
	/** 专题开始时间 */
	private Date startTime;
	/** 专题结束时间 */
	private Date endTime;
	/** 专题状态 */
	private String status;

	private Long itemId;
	private String itemTitle;
	private Double marketPrice;
	private Double guidePrice;
	private Double specialPrice;
	private Integer bargainMaxTimes;
	private Integer residueTimes;
	private Boolean itemStatus;

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

	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
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

}
