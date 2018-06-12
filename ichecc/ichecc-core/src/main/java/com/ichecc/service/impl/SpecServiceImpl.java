package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.SpecDAO;
import com.ichecc.domain.SpecDO;
import com.ichecc.service.SpecService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="specService")
public class SpecServiceImpl  implements SpecService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private SpecDAO specDAO;

	@Override
	public Long insert(SpecDO specDO) throws CommonServiceException {
		try {
			return specDAO.insert(specDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(SpecDO specDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) specDAO.update(specDO);
			}else{
				return (Integer) specDAO.updateDynamic(specDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) specDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public SpecDO selectById(Long id) throws CommonServiceException {
		try {
			return specDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(SpecDO specDO) throws CommonServiceException {
		try {
			return specDAO.selectCountDynamic(specDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<SpecDO> selectDynamic(SpecDO specDO) throws CommonServiceException {
		try {
			return specDAO.selectDynamic(specDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<SpecDO> selectDynamicPageQuery(SpecDO specDO) throws CommonServiceException {
		try {
			return specDAO.selectDynamicPageQuery(specDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<SpecDO> queryPageListDynamic(SpecDO specDO) throws CommonServiceException{
		if (specDO != null) {
			Long totalCount = this.selectCountDynamic(specDO);

			Page<SpecDO> page = new Page<SpecDO>();
			page.setPageNo(specDO.getStartPage());
			page.setPageSize(specDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<SpecDO> resultList = this.selectDynamicPageQuery(specDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<SpecDO>();
	}
	
	@Override
	public Page<SpecDO> queryPageListDynamicAndStartPageSize(SpecDO specDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (specDO != null && startPage>0 && pageSize>0) {
			specDO.setStartPage(startPage);
			specDO.setPageSize(pageSize);
			return this.queryPageListDynamic(specDO);
		}
		return new Page<SpecDO>();
	}
	
	
}
