package com.ichecc.enums;

/**
 * vip会员类型
 * 
 * @author lenovopc
 *
 */
public enum VipUserCateEnum {

	/** vip类型：01-从没充值过，不是会员；02-第一次充值，新会员；03-至少一次充值过，老会员 */
	Never("01"), IsNew("02"), MoreThenOnce("03");

	public String code;

	VipUserCateEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
