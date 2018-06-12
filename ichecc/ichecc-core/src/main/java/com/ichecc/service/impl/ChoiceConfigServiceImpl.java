package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.ChoiceConfigDAO;
import com.ichecc.domain.ChoiceConfigDO;
import com.ichecc.service.ChoiceConfigService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="choiceConfigService")
public class ChoiceConfigServiceImpl  implements ChoiceConfigService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private ChoiceConfigDAO choiceConfigDAO;

	@Override
	public Long insert(ChoiceConfigDO choiceConfigDO) throws CommonServiceException {
		try {
			return choiceConfigDAO.insert(choiceConfigDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(ChoiceConfigDO choiceConfigDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) choiceConfigDAO.update(choiceConfigDO);
			}else{
				return (Integer) choiceConfigDAO.updateDynamic(choiceConfigDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) choiceConfigDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public ChoiceConfigDO selectById(Long id) throws CommonServiceException {
		try {
			return choiceConfigDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(ChoiceConfigDO choiceConfigDO) throws CommonServiceException {
		try {
			return choiceConfigDAO.selectCountDynamic(choiceConfigDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<ChoiceConfigDO> selectDynamic(ChoiceConfigDO choiceConfigDO) throws CommonServiceException {
		try {
			return choiceConfigDAO.selectDynamic(choiceConfigDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<ChoiceConfigDO> selectDynamicPageQuery(ChoiceConfigDO choiceConfigDO) throws CommonServiceException {
		try {
			return choiceConfigDAO.selectDynamicPageQuery(choiceConfigDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<ChoiceConfigDO> queryPageListDynamic(ChoiceConfigDO choiceConfigDO) throws CommonServiceException{
		if (choiceConfigDO != null) {
			Long totalCount = this.selectCountDynamic(choiceConfigDO);

			Page<ChoiceConfigDO> page = new Page<ChoiceConfigDO>();
			page.setPageNo(choiceConfigDO.getStartPage());
			page.setPageSize(choiceConfigDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<ChoiceConfigDO> resultList = this.selectDynamicPageQuery(choiceConfigDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<ChoiceConfigDO>();
	}
	
	@Override
	public Page<ChoiceConfigDO> queryPageListDynamicAndStartPageSize(ChoiceConfigDO choiceConfigDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (choiceConfigDO != null && startPage>0 && pageSize>0) {
			choiceConfigDO.setStartPage(startPage);
			choiceConfigDO.setPageSize(pageSize);
			return this.queryPageListDynamic(choiceConfigDO);
		}
		return new Page<ChoiceConfigDO>();
	}
	
	
}
