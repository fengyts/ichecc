package com.ichecc.dao;

import com.ichecc.domain.IcheccConstantsDO;
import ng.bayue.service.common.GeneralDAO;
import ng.bayue.exception.CommonDAOException;

 /**
 * 常量 DAO
 *
 * @author fengyts 2018-08-16 14:34:19
 */
public interface IcheccConstantsDAO extends GeneralDAO<IcheccConstantsDO> {
	
	/**
	 * <pre>
	 * 根据主键查询
	 * </pre>
	 *
	 * @param primaryKey
	 * @return IcheccConstantsDO
	 * @throws CommonDAOException
	 */
	IcheccConstantsDO selectByPrimaryKey(String primaryKey) throws CommonDAOException;
	
	/**
	 * <pre>
	 * 根据主键删除
	 * </pre>
	 *
	 * @param primaryKey
	 * @return int
	 * @throws CommonDAOException
	 */
	int deleteByPrimaryKey(String primaryKey) throws CommonDAOException;
	
	/**
	 * <pre>
	 * 根据主键动态更新
	 * </pre>
	 *
	 * @param constantDO
	 * @return int
	 * @throws CommonDAOException
	 */
	int updateByPrimaryKey(IcheccConstantsDO constantDO) throws CommonDAOException;

}
