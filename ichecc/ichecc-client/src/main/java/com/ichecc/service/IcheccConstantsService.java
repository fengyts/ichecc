package com.ichecc.service;

import ng.bayue.service.common.GeneralService;
import ng.bayue.exception.CommonServiceException;
import com.ichecc.domain.IcheccConstantsDO;

 /**
 * 常量 Service
 * @author fengyts 2018-08-16 14:34:19
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
	 * @throws CommonServiceException
	 */
	int deleteByPrimaryKey(String primaryKey);
	
	/**
	 * <pre>
	 * 根据主键动态更新
	 * </pre>
	 *
	 * @param constantDO
	 * @return int
	 * @throws CommonServiceException
	 */
	int updateByPrimaryKey(IcheccConstantsDO constantDO) throws CommonServiceException;
	
	
	/**
	 * 根据key值获取value
	 * @param key
	 * @return
	 */
	String getValueByKey(String key);
	
}
