package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.SpecGroupLinkDAO;
import com.ichecc.domain.SpecGroupLinkDO;
import com.ichecc.service.SpecGroupLinkService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="specGroupLinkService")
public class SpecGroupLinkServiceImpl  implements SpecGroupLinkService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private SpecGroupLinkDAO specGroupLinkDAO;

	@Override
	public Long insert(SpecGroupLinkDO specGroupLinkDO) throws CommonServiceException {
		try {
			return specGroupLinkDAO.insert(specGroupLinkDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(SpecGroupLinkDO specGroupLinkDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) specGroupLinkDAO.update(specGroupLinkDO);
			}else{
				return (Integer) specGroupLinkDAO.updateDynamic(specGroupLinkDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) specGroupLinkDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public SpecGroupLinkDO selectById(Long id) throws CommonServiceException {
		try {
			return specGroupLinkDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(SpecGroupLinkDO specGroupLinkDO) throws CommonServiceException {
		try {
			return specGroupLinkDAO.selectCountDynamic(specGroupLinkDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<SpecGroupLinkDO> selectDynamic(SpecGroupLinkDO specGroupLinkDO) throws CommonServiceException {
		try {
			return specGroupLinkDAO.selectDynamic(specGroupLinkDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<SpecGroupLinkDO> selectDynamicPageQuery(SpecGroupLinkDO specGroupLinkDO) throws CommonServiceException {
		try {
			return specGroupLinkDAO.selectDynamicPageQuery(specGroupLinkDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<SpecGroupLinkDO> queryPageListDynamic(SpecGroupLinkDO specGroupLinkDO) throws CommonServiceException{
		if (specGroupLinkDO != null) {
			Long totalCount = this.selectCountDynamic(specGroupLinkDO);

			Page<SpecGroupLinkDO> page = new Page<SpecGroupLinkDO>();
			page.setPageNo(specGroupLinkDO.getStartPage());
			page.setPageSize(specGroupLinkDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<SpecGroupLinkDO> resultList = this.selectDynamicPageQuery(specGroupLinkDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<SpecGroupLinkDO>();
	}
	
	@Override
	public Page<SpecGroupLinkDO> queryPageListDynamicAndStartPageSize(SpecGroupLinkDO specGroupLinkDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (specGroupLinkDO != null && startPage>0 && pageSize>0) {
			specGroupLinkDO.setStartPage(startPage);
			specGroupLinkDO.setPageSize(pageSize);
			return this.queryPageListDynamic(specGroupLinkDO);
		}
		return new Page<SpecGroupLinkDO>();
	}
	
	
}
