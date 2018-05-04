package com.ichecc.ao.sys;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.SysRoleMenuDO;
import com.ichecc.service.SysRoleMenuService;

@Service
public class SysMenuRoleAO {

	@Autowired
	private SysRoleMenuService sysMenuRoleService;

	public String selectMenuIdsByRoleId(Long roleId) {
		List<SysRoleMenuDO> list = sysMenuRoleService.selectByRoleId(roleId);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		String menuIds = "";
		for (SysRoleMenuDO smr : list) {
			menuIds += smr.getMenuId() + ",";
		}
		return menuIds.substring(0, menuIds.length() - 1);
	}
	

}
