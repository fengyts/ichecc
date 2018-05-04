package com.ichecc.dao;

import com.ichecc.domain.SysUserDO;
import com.ichecc.vo.SysUserVO;

import ng.bayue.service.common.GeneralDAO;

/**
 * 后台系统用户 DAO
 *
 * @author fengyts 2017-11-16 14:54:40
 */
public interface SysUserDAO extends GeneralDAO<SysUserDO> {
	/**
	 * <pre>
	 * 结果集包含list的嵌套查询
	 * </pre>
	 *
	 * @param sysUserDO
	 * @return
	 */
	SysUserVO nestedList(String param);

	SysUserDO findByLoginNameOrEmailOrMobile(String param);
}
