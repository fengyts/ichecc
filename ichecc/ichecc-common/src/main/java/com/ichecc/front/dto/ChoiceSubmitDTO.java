package com.ichecc.front.dto;

import ng.bayue.util.StringUtils;

public class ChoiceSubmitDTO extends AbstractDTO {

	private static final long serialVersionUID = -8933526099910779606L;

	private Long userId;
	/** 预算金额 */
	private String budget;
	/** 品牌 */
	private String brand;
	/** 能源类型 */
	private String energy;
	/** 车辆类型 */
	private String type;
	/** 座位类型 */
	private String seat;
	/** 车型结构 */
	private String structure;
	/** 变速箱 */
	private String gearbox;
	/** 其他需求 */
	private String otherRequirement;

	@Override
	public boolean validate() {
		if (null == userId || userId.longValue() < 0) {
			return false;
		}
		if (StringUtils.isBlank(budget) || StringUtils.isBlank(brand) || StringUtils.isBlank(energy)
				|| StringUtils.isBlank(type) || StringUtils.isBlank(seat) || StringUtils.isBlank(structure)
				|| StringUtils.isBlank(gearbox)) {
			return false;
		}
		return super.validate();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getGearbox() {
		return gearbox;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getOtherRequirement() {
		return otherRequirement;
	}

	public void setOtherRequirement(String otherRequirement) {
		this.otherRequirement = otherRequirement;
	}

}
