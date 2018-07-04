package com.ichecc.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 参与砍价页面数据模型
 * </pre>
 *
 * @author fengyts
 * @version $Id: HiggleVO.java, v 0.1 2018年7月1日 上午12:27:08 fengyts Exp $
 */
public class HiggleJoinVO extends BaseVO {

	private static final long serialVersionUID = -5787305086958542089L;

	/** 专题商品id */
	private Long tiId;
	/** 专题结束时间 */
	private Date endTime;
	/** 专题状态，根据专题时间来判断 */
	private String status;

	private String picture;
	/** 商品名称 */
	private String itemTitle;
	/** 商品副标题 */
	private String subTitle;
	private Double marketPrice;
	private Double guidePrice;
	private Double specialPrice;

	/** 砍价最大次数 */
	private Integer bargainMaxTimes;
	/** 剩余次数 */
	private Integer residueTimes;

	/** 已砍金额 */
	private BigDecimal alreadyBargainAmt;
	/** 还差金额 */
	private BigDecimal shortBargainAmt;

	/** 砍价规则 */
	private String bargainRules;

	/** 用户头像 */
	private String headimgurl;
	/** 用户昵称 */
	private String nickname;

	/** 砍价记录 */
	private HiggleRecordVO recordVO;
	
	/** 倒计时时间 */
	private Long countDownTime;

	public Long getTiId() {
		return tiId;
	}

	public void setTiId(Long tiId) {
		this.tiId = tiId;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
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

	public String getBargainRules() {
		return bargainRules;
	}

	public void setBargainRules(String bargainRules) {
		this.bargainRules = bargainRules;
	}

	public BigDecimal getAlreadyBargainAmt() {
		return alreadyBargainAmt;
	}

	public void setAlreadyBargainAmt(BigDecimal alreadyBargainAmt) {
		this.alreadyBargainAmt = alreadyBargainAmt;
	}

	public BigDecimal getShortBargainAmt() {
		return shortBargainAmt;
	}

	public void setShortBargainAmt(BigDecimal shortBargainAmt) {
		this.shortBargainAmt = shortBargainAmt;
	}

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

	public HiggleRecordVO getRecordVO() {
		return recordVO;
	}

	public void setRecordVO(HiggleRecordVO recordVO) {
		this.recordVO = recordVO;
	}

	public Long getCountDownTime() {
		return countDownTime;
	}

	public void setCountDownTime(Long countDownTime) {
		this.countDownTime = countDownTime;
	}
	

}
