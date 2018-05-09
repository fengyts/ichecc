package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 砍价记录
 * 
 * @author fengyts Wed May 09 09:29:17 CST 2018
 */

public class BargainRecordDO extends BaseDO {

	private static final long serialVersionUID = 3448322815677179624L;

	/** 主键 */
	private Long id;

	/** 专题商品id */
	private Long topicItemId;

	/** 砍价人(本人) */
	private Long userId;

	/** 砍价金额 */
	private Double bargainAmount;

	/** 砍价类型：01-本人砍价；02-好友帮砍 */
	private String bargainType;

	/** 微信好友id */
	private Long wechatUserId;

	/** 砍价时间 */
	private Date createTime;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 专题商品id
	 * 
	 * @param topicItemId
	 */
	public void setTopicItemId(Long topicItemId) {
		this.topicItemId = topicItemId;
	}

	/**
	 * 设置 砍价人(本人)
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置 砍价金额
	 * 
	 * @param bargainAmount
	 */
	public void setBargainAmount(Double bargainAmount) {
		this.bargainAmount = bargainAmount;
	}

	/**
	 * 设置 砍价类型：01-本人砍价；02-好友帮砍
	 * 
	 * @param bargainType
	 */
	public void setBargainType(String bargainType) {
		this.bargainType = bargainType;
	}

	/**
	 * 设置 微信好友id
	 * 
	 * @param wechatUserId
	 */
	public void setWechatUserId(Long wechatUserId) {
		this.wechatUserId = wechatUserId;
	}

	/**
	 * 设置 砍价时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	 * 获取 专题商品id
	 * 
	 * @return topicItemId
	 */
	public Long getTopicItemId() {
		return topicItemId;
	}

	/**
	 * 获取 砍价人(本人)
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 获取 砍价金额
	 * 
	 * @return bargainAmount
	 */
	public Double getBargainAmount() {
		return bargainAmount;
	}

	/**
	 * 获取 砍价类型：01-本人砍价；02-好友帮砍
	 * 
	 * @return bargainType
	 */
	public String getBargainType() {
		return bargainType;
	}

	/**
	 * 获取 微信好友id
	 * 
	 * @return wechatUserId
	 */
	public Long getWechatUserId() {
		return wechatUserId;
	}

	/**
	 * 获取 砍价时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

}