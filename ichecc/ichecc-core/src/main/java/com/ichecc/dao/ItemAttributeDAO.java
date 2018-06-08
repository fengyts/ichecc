package com.ichecc.dao;

import java.util.List;

import com.ichecc.domain.ItemAttributeDO;

import ng.bayue.service.common.GeneralDAO;

 /**
 * 商品属性 DAO
 *
 * @author fengyts 2018-06-04 14:08:04
 */
public interface ItemAttributeDAO extends GeneralDAO<ItemAttributeDO> {
	
	List<ItemAttributeDO> selectByIds(List<Long> ids);
	
}
