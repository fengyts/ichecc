package com.ichecc.service;

import com.ichecc.domain.ItemDO;
import com.ichecc.dto.ItemDTO;

import ng.bayue.exception.CommonServiceException;
import ng.bayue.service.common.GeneralService;

/**
 * 商品 Service
 * 
 * @author fengyts 2018-05-09 09:29:18
 */
public interface ItemService extends GeneralService<ItemDO, ItemDO> {

	int saveItem(ItemDTO itemDTO) throws CommonServiceException;

	int updateItem(ItemDTO itemDTO) throws CommonServiceException;
	
}
