package com.ichecc.service;

import ng.bayue.service.common.GeneralService;
import ng.bayue.exception.CommonServiceException;
import com.ichecc.domain.IcheccConstantsDO;

 /**
 * 常量 Service
 * @author fengyts 2018-05-09 09:29:18
 */
public interface IcheccConstantsService extends GeneralService<IcheccConstantsDO, IcheccConstantsDO> {
	
	/**
	 * <pre>
	 * 根据主键查询
	 * </pre>
	 *
	 * @param primaryKey
	 * @return IcheccConstantsDO
	 * @throws CommonServiceException
	 */
	IcheccConstantsDO selectByPrimaryKey(String primaryKey);
	
	/**
	 * <pre>
	 * 根据主键删除
	 * </pre>
	 *
	 * @param primaryKey
	 * @return int
	 * @throws CommonDAOException
	 */
	int deleteByPrimaryKey(String primaryKey);
	
}
