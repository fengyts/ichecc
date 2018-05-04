package com.ichecc.dao;

import java.util.List;

import com.ichecc.domain.SysRoleDO;

import ng.bayue.exception.CommonDAOException;
import ng.bayue.service.common.GeneralDAO;

/**
 * 系统用户角色 DAO
 *
 * @author fengyts 2017-11-16 14:54:40
 */
public interface SysRoleDAO extends GeneralDAO<SysRoleDO> {
	
	List<SysRoleDO> selectByIds(List<Long> ids) throws CommonDAOException;
	
}
