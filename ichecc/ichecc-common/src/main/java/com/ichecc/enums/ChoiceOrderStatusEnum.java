package com.ichecc.enums;

public enum ChoiceOrderStatusEnum {

	ON_DISPOSE("01", "处理中"), HAS_DISPOSED("02", "已处理");

	public String code;
	public String desc;

	private ChoiceOrderStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDescByCOde(String code) {
		if (null == code) {
			return null;
		}
		for (ChoiceOrderStatusEnum e : ChoiceOrderStatusEnum.values()) {
			if (code.equals(e.code)) {
				return e.desc;
			}
		}
		return null;
	}

}
