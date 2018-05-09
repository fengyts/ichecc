package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.IcheccUserDAO;
import com.ichecc.domain.IcheccUserDO;
import com.ichecc.service.IcheccUserService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="icheccUserService")
public class IcheccUserServiceImpl  implements IcheccUserService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private IcheccUserDAO icheccUserDAO;

	@Override
	public Long insert(IcheccUserDO icheccUserDO) throws CommonServiceException {
		try {
			return icheccUserDAO.insert(icheccUserDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(IcheccUserDO icheccUserDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) icheccUserDAO.update(icheccUserDO);
			}else{
				return (Integer) icheccUserDAO.updateDynamic(icheccUserDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) icheccUserDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public IcheccUserDO selectById(Long id) throws CommonServiceException {
		try {
			return icheccUserDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(IcheccUserDO icheccUserDO) throws CommonServiceException {
		try {
			return icheccUserDAO.selectCountDynamic(icheccUserDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<IcheccUserDO> selectDynamic(IcheccUserDO icheccUserDO) throws CommonServiceException {
		try {
			return icheccUserDAO.selectDynamic(icheccUserDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<IcheccUserDO> selectDynamicPageQuery(IcheccUserDO icheccUserDO) throws CommonServiceException {
		try {
			return icheccUserDAO.selectDynamicPageQuery(icheccUserDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<IcheccUserDO> queryPageListDynamic(IcheccUserDO icheccUserDO) throws CommonServiceException{
		if (icheccUserDO != null) {
			Long totalCount = this.selectCountDynamic(icheccUserDO);

			Page<IcheccUserDO> page = new Page<IcheccUserDO>();
			page.setPageNo(icheccUserDO.getStartPage());
			page.setPageSize(icheccUserDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<IcheccUserDO> resultList = this.selectDynamicPageQuery(icheccUserDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<IcheccUserDO>();
	}
	
	@Override
	public Page<IcheccUserDO> queryPageListDynamicAndStartPageSize(IcheccUserDO icheccUserDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (icheccUserDO != null && startPage>0 && pageSize>0) {
			icheccUserDO.setStartPage(startPage);
			icheccUserDO.setPageSize(pageSize);
			return this.queryPageListDynamic(icheccUserDO);
		}
		return new Page<IcheccUserDO>();
	}
	
	
}
