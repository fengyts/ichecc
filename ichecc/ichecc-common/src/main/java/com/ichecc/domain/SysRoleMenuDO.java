package com.ichecc.domain;

import ng.bayue.common.BaseDO;

/**
 * 系统角色菜单
 * 
 * @author fengyts Thu Nov 16 14:54:40 CST 2017
 */

public class SysRoleMenuDO extends BaseDO {

	private static final long serialVersionUID = -2766464914028872108L;

	/** 主键 */
	private Long menuId;

	/** 主键 */
	private Long roleId;

	/**
	 * 设置 主键
	 * 
	 * @param menuId
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * 设置 主键
	 * 
	 * @param roleId
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取 主键
	 * 
	 * @return menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * 获取 主键
	 * 
	 * @return roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

}