package com.ichecc.service;

import java.util.List;

import com.ichecc.domain.ItemAttributeDO;

import ng.bayue.service.common.GeneralService;

 /**
 * 商品属性 Service
 * @author fengyts 2018-06-04 14:08:04
 */
public interface ItemAttributeService extends GeneralService<ItemAttributeDO, ItemAttributeDO> {
	
	public List<ItemAttributeDO> selectByIds(List<Long> ids);
	
}
