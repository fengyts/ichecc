package com.ichecc.vo;

import java.util.Date;

/**
 * <pre>
 * 砍价记录列表数据
 * </pre>
 *
 * @author fengyts
 * @version $Id: HiggleListVO.java, v 0.1 2018年7月1日 上午12:33:51 fengyts Exp $
 */
public class HiggleListVO extends BaseVO {

	private static final long serialVersionUID = -1232626429278634271L;

	/** 用户头像，使用微信头像 */
	private String headimgurl;
	/** 用户名称，使用微信昵称 */
	private String nickname;
	/** 砍价金额 */
	private Double bargainAmount;
	/** 砍价类型：01-本人砍价；02-好友帮砍 */
	private String bargainType;
	/** 砍价时间 */
	private Date bargainTime;

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Double getBargainAmount() {
		return bargainAmount;
	}

	public void setBargainAmount(Double bargainAmount) {
		this.bargainAmount = bargainAmount;
	}

	public String getBargainType() {
		return bargainType;
	}

	public void setBargainType(String bargainType) {
		this.bargainType = bargainType;
	}

	public Date getBargainTime() {
		return bargainTime;
	}

	public void setBargainTime(Date bargainTime) {
		this.bargainTime = bargainTime;
	}

}
