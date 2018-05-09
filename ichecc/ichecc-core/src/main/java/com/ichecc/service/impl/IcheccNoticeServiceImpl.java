package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.IcheccNoticeDAO;
import com.ichecc.domain.IcheccNoticeDO;
import com.ichecc.service.IcheccNoticeService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="icheccNoticeService")
public class IcheccNoticeServiceImpl  implements IcheccNoticeService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private IcheccNoticeDAO icheccNoticeDAO;

	@Override
	public Long insert(IcheccNoticeDO icheccNoticeDO) throws CommonServiceException {
		try {
			return icheccNoticeDAO.insert(icheccNoticeDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(IcheccNoticeDO icheccNoticeDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) icheccNoticeDAO.update(icheccNoticeDO);
			}else{
				return (Integer) icheccNoticeDAO.updateDynamic(icheccNoticeDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) icheccNoticeDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public IcheccNoticeDO selectById(Long id) throws CommonServiceException {
		try {
			return icheccNoticeDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(IcheccNoticeDO icheccNoticeDO) throws CommonServiceException {
		try {
			return icheccNoticeDAO.selectCountDynamic(icheccNoticeDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<IcheccNoticeDO> selectDynamic(IcheccNoticeDO icheccNoticeDO) throws CommonServiceException {
		try {
			return icheccNoticeDAO.selectDynamic(icheccNoticeDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<IcheccNoticeDO> selectDynamicPageQuery(IcheccNoticeDO icheccNoticeDO) throws CommonServiceException {
		try {
			return icheccNoticeDAO.selectDynamicPageQuery(icheccNoticeDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<IcheccNoticeDO> queryPageListDynamic(IcheccNoticeDO icheccNoticeDO) throws CommonServiceException{
		if (icheccNoticeDO != null) {
			Long totalCount = this.selectCountDynamic(icheccNoticeDO);

			Page<IcheccNoticeDO> page = new Page<IcheccNoticeDO>();
			page.setPageNo(icheccNoticeDO.getStartPage());
			page.setPageSize(icheccNoticeDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<IcheccNoticeDO> resultList = this.selectDynamicPageQuery(icheccNoticeDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<IcheccNoticeDO>();
	}
	
	@Override
	public Page<IcheccNoticeDO> queryPageListDynamicAndStartPageSize(IcheccNoticeDO icheccNoticeDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (icheccNoticeDO != null && startPage>0 && pageSize>0) {
			icheccNoticeDO.setStartPage(startPage);
			icheccNoticeDO.setPageSize(pageSize);
			return this.queryPageListDynamic(icheccNoticeDO);
		}
		return new Page<IcheccNoticeDO>();
	}
	
	
}
