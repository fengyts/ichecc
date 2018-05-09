package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.IcheccUserInfoDAO;
import com.ichecc.domain.IcheccUserInfoDO;
import com.ichecc.service.IcheccUserInfoService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="icheccUserInfoService")
public class IcheccUserInfoServiceImpl  implements IcheccUserInfoService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private IcheccUserInfoDAO icheccUserInfoDAO;

	@Override
	public Long insert(IcheccUserInfoDO icheccUserInfoDO) throws CommonServiceException {
		try {
			return icheccUserInfoDAO.insert(icheccUserInfoDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(IcheccUserInfoDO icheccUserInfoDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) icheccUserInfoDAO.update(icheccUserInfoDO);
			}else{
				return (Integer) icheccUserInfoDAO.updateDynamic(icheccUserInfoDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) icheccUserInfoDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public IcheccUserInfoDO selectById(Long id) throws CommonServiceException {
		try {
			return icheccUserInfoDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(IcheccUserInfoDO icheccUserInfoDO) throws CommonServiceException {
		try {
			return icheccUserInfoDAO.selectCountDynamic(icheccUserInfoDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<IcheccUserInfoDO> selectDynamic(IcheccUserInfoDO icheccUserInfoDO) throws CommonServiceException {
		try {
			return icheccUserInfoDAO.selectDynamic(icheccUserInfoDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<IcheccUserInfoDO> selectDynamicPageQuery(IcheccUserInfoDO icheccUserInfoDO) throws CommonServiceException {
		try {
			return icheccUserInfoDAO.selectDynamicPageQuery(icheccUserInfoDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<IcheccUserInfoDO> queryPageListDynamic(IcheccUserInfoDO icheccUserInfoDO) throws CommonServiceException{
		if (icheccUserInfoDO != null) {
			Long totalCount = this.selectCountDynamic(icheccUserInfoDO);

			Page<IcheccUserInfoDO> page = new Page<IcheccUserInfoDO>();
			page.setPageNo(icheccUserInfoDO.getStartPage());
			page.setPageSize(icheccUserInfoDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<IcheccUserInfoDO> resultList = this.selectDynamicPageQuery(icheccUserInfoDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<IcheccUserInfoDO>();
	}
	
	@Override
	public Page<IcheccUserInfoDO> queryPageListDynamicAndStartPageSize(IcheccUserInfoDO icheccUserInfoDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (icheccUserInfoDO != null && startPage>0 && pageSize>0) {
			icheccUserInfoDO.setStartPage(startPage);
			icheccUserInfoDO.setPageSize(pageSize);
			return this.queryPageListDynamic(icheccUserInfoDO);
		}
		return new Page<IcheccUserInfoDO>();
	}
	
	
}
