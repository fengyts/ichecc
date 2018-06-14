package com.ichecc.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.dao.ItemAttributeDAO;
import com.ichecc.domain.ItemAttributeDO;
import com.ichecc.service.ItemAttributeService;

import ng.bayue.common.Page;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;

@Service(value="itemAttributeService")
public class ItemAttributeServiceImpl  implements ItemAttributeService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private ItemAttributeDAO itemAttributeDAO;

	@Override
	public Long insert(ItemAttributeDO itemAttributeDO) throws CommonServiceException {
		try {
			return itemAttributeDAO.insert(itemAttributeDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(ItemAttributeDO itemAttributeDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) itemAttributeDAO.update(itemAttributeDO);
			}else{
				return (Integer) itemAttributeDAO.updateDynamic(itemAttributeDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) itemAttributeDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public ItemAttributeDO selectById(Long id) throws CommonServiceException {
		try {
			return itemAttributeDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(ItemAttributeDO itemAttributeDO) throws CommonServiceException {
		try {
			return itemAttributeDAO.selectCountDynamic(itemAttributeDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<ItemAttributeDO> selectDynamic(ItemAttributeDO itemAttributeDO) throws CommonServiceException {
		try {
			return itemAttributeDAO.selectDynamic(itemAttributeDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<ItemAttributeDO> selectDynamicPageQuery(ItemAttributeDO itemAttributeDO) throws CommonServiceException {
		try {
			return itemAttributeDAO.selectDynamicPageQuery(itemAttributeDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<ItemAttributeDO> queryPageListDynamic(ItemAttributeDO itemAttributeDO) throws CommonServiceException{
		if (itemAttributeDO != null) {
			Long totalCount = this.selectCountDynamic(itemAttributeDO);

			Page<ItemAttributeDO> page = new Page<ItemAttributeDO>();
			page.setPageNo(itemAttributeDO.getStartPage());
			page.setPageSize(itemAttributeDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<ItemAttributeDO> resultList = this.selectDynamicPageQuery(itemAttributeDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<ItemAttributeDO>();
	}
	
	@Override
	public Page<ItemAttributeDO> queryPageListDynamicAndStartPageSize(ItemAttributeDO itemAttributeDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (itemAttributeDO != null && startPage>0 && pageSize>0) {
			itemAttributeDO.setStartPage(startPage);
			itemAttributeDO.setPageSize(pageSize);
			return this.queryPageListDynamic(itemAttributeDO);
		}
		return new Page<ItemAttributeDO>();
	}


	@Override
	public List<ItemAttributeDO> selectByIds(List<Long> ids) {
		if(CollectionUtils.isEmpty(ids)){
			return Collections.emptyList();
		}
		return itemAttributeDAO.selectByIds(ids);
	}


	@Override
	public List<ItemAttributeDO> selectByIdsStr(String idsStr) {
		if(StringUtils.isBlank(idsStr)){
			return Collections.emptyList();
		}
		String[] idsStrArr = idsStr.split(",");
		List<Long> ids = new ArrayList<Long>();
		for(String id : idsStrArr){
			ids.add(Long.valueOf(id));
		}
		return this.selectByIds(ids);
	}
	
	
	
	
}
