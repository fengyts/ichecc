package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.SpecGroupDAO;
import com.ichecc.domain.SpecGroupDO;
import com.ichecc.service.SpecGroupService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="specGroupService")
public class SpecGroupServiceImpl  implements SpecGroupService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private SpecGroupDAO specGroupDAO;

	@Override
	public Long insert(SpecGroupDO specGroupDO) throws CommonServiceException {
		try {
			return specGroupDAO.insert(specGroupDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(SpecGroupDO specGroupDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) specGroupDAO.update(specGroupDO);
			}else{
				return (Integer) specGroupDAO.updateDynamic(specGroupDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) specGroupDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public SpecGroupDO selectById(Long id) throws CommonServiceException {
		try {
			return specGroupDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(SpecGroupDO specGroupDO) throws CommonServiceException {
		try {
			return specGroupDAO.selectCountDynamic(specGroupDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<SpecGroupDO> selectDynamic(SpecGroupDO specGroupDO) throws CommonServiceException {
		try {
			return specGroupDAO.selectDynamic(specGroupDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<SpecGroupDO> selectDynamicPageQuery(SpecGroupDO specGroupDO) throws CommonServiceException {
		try {
			return specGroupDAO.selectDynamicPageQuery(specGroupDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<SpecGroupDO> queryPageListDynamic(SpecGroupDO specGroupDO) throws CommonServiceException{
		if (specGroupDO != null) {
			Long totalCount = this.selectCountDynamic(specGroupDO);

			Page<SpecGroupDO> page = new Page<SpecGroupDO>();
			page.setPageNo(specGroupDO.getStartPage());
			page.setPageSize(specGroupDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<SpecGroupDO> resultList = this.selectDynamicPageQuery(specGroupDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<SpecGroupDO>();
	}
	
	@Override
	public Page<SpecGroupDO> queryPageListDynamicAndStartPageSize(SpecGroupDO specGroupDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (specGroupDO != null && startPage>0 && pageSize>0) {
			specGroupDO.setStartPage(startPage);
			specGroupDO.setPageSize(pageSize);
			return this.queryPageListDynamic(specGroupDO);
		}
		return new Page<SpecGroupDO>();
	}
	
	
}
