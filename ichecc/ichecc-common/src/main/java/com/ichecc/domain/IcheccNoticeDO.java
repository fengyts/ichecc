package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
 * 常见问题&注意事项&公告等
 * 
 * @author fengyts Wed May 09 09:29:20 CST 2018
 */

public class IcheccNoticeDO extends BaseDO {

	/**  */
	private static final long serialVersionUID = 3575571665051717839L;

	/** 主键 */
	private Long id;

	/** 类型：01-其他；02-常见问题；03-规则说明；04-用户服务协议；05-隐私条款 */
	private String type;

	/** 标题 */
	private String title;

	/** 内容 */
	private String content;

	/** 链接地址 */
	private String linkUrl;

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
	 * 设置 类型：01-其他；02-常见问题；03-规则说明；04-用户服务协议；05-隐私条款
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 设置 标题
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 设置 内容
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 设置 链接地址
	 * 
	 * @param linkUrl
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
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
	 * 获取 类型：01-其他；02-常见问题；03-规则说明；04-用户服务协议；05-隐私条款
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 获取 标题
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 获取 内容
	 * 
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 获取 链接地址
	 * 
	 * @return linkUrl
	 */
	public String getLinkUrl() {
		return linkUrl;
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