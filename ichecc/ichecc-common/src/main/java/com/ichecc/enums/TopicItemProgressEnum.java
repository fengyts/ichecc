package com.ichecc.enums;

public enum TopicItemProgressEnum {

	InProgress("01", "进行中"), Bargain_Success("02", "已竞拍成功"), End("03", "已结束");

	public String code;
	public String desc;

	private TopicItemProgressEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDescByCode(String code) {
		if (null == code || "".equals(code)) {
			return null;
		}
		for (TopicItemProgressEnum e : TopicItemProgressEnum.values()) {
			if (code.equals(e.code)) {
				return e.desc;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
