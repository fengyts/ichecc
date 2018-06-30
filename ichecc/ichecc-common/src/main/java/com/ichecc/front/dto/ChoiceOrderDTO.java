package com.ichecc.front.dto;

import com.ichecc.domain.ChoiceOrderDO;

public class ChoiceOrderDTO extends ChoiceOrderDO {

	private static final long serialVersionUID = 4545754510462066957L;

	private String choiceRequirement;

	public String getChoiceRequirement() {
		return choiceRequirement;
	}

	public void setChoiceRequirement(String choiceRequirement) {
		this.choiceRequirement = choiceRequirement;
	}

}
