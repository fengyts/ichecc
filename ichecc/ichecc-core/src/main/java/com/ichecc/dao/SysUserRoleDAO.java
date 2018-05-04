package com.ichecc.dao;

import java.util.List;

import com.ichecc.domain.SysUserRoleDO;

import ng.bayue.exception.CommonDAOException;
import ng.bayue.service.common.GeneralDAO;

/**
 * 系统用户角色 DAO
 *
 * @author fengyts 2017-11-16 14:54:40
 */
public interface SysUserRoleDAO extends GeneralDAO<SysUserRoleDO> {
	/**
	 * <pre>
	 * 批量插入用户角色关系
	 * </pre>
	 *
	 * @param list
	 * @throws DAOException
	 */
	void insertBatch(List<SysUserRoleDO> list) throws CommonDAOException;

	List<SysUserRoleDO> selectByUserIds(List<Long> userIds);
}
