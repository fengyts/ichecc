package com.ichecc.dao;

import com.ichecc.domain.ItemDescDO;

import ng.bayue.exception.CommonDAOException;
import ng.bayue.service.common.GeneralDAO;

 /**
 * 商品详情描述和规则 DAO
 *
 * @author fengyts 2018-05-09 09:29:16
 */
public interface ItemDescDAO extends GeneralDAO<ItemDescDO> {
	
	int updateByItemId(ItemDescDO itemDescDO) throws CommonDAOException;
	
}
