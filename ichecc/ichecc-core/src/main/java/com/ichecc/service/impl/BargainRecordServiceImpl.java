package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.BargainRecordDAO;
import com.ichecc.domain.BargainRecordDO;
import com.ichecc.service.BargainRecordService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.util.StringUtils;
import ng.bayue.common.Page;

@Service(value="bargainRecordService")
public class BargainRecordServiceImpl  implements BargainRecordService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private BargainRecordDAO bargainRecordDAO;

	@Override
	public Long insert(BargainRecordDO bargainRecordDO) throws CommonServiceException {
		try {
			return bargainRecordDAO.insert(bargainRecordDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(BargainRecordDO bargainRecordDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) bargainRecordDAO.update(bargainRecordDO);
			}else{
				return (Integer) bargainRecordDAO.updateDynamic(bargainRecordDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) bargainRecordDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public BargainRecordDO selectById(Long id) throws CommonServiceException {
		try {
			return bargainRecordDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(BargainRecordDO bargainRecordDO) throws CommonServiceException {
		try {
			return bargainRecordDAO.selectCountDynamic(bargainRecordDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<BargainRecordDO> selectDynamic(BargainRecordDO bargainRecordDO) throws CommonServiceException {
		try {
			return bargainRecordDAO.selectDynamic(bargainRecordDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<BargainRecordDO> selectDynamicPageQuery(BargainRecordDO bargainRecordDO) throws CommonServiceException {
		try {
			return bargainRecordDAO.selectDynamicPageQuery(bargainRecordDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<BargainRecordDO> queryPageListDynamic(BargainRecordDO bargainRecordDO) throws CommonServiceException{
		if (bargainRecordDO != null) {
			Long totalCount = this.selectCountDynamic(bargainRecordDO);

			Page<BargainRecordDO> page = new Page<BargainRecordDO>();
			page.setPageNo(bargainRecordDO.getStartPage());
			page.setPageSize(bargainRecordDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<BargainRecordDO> resultList = this.selectDynamicPageQuery(bargainRecordDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<BargainRecordDO>();
	}
	
	@Override
	public Page<BargainRecordDO> queryPageListDynamicAndStartPageSize(BargainRecordDO bargainRecordDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (bargainRecordDO != null && startPage>0 && pageSize>0) {
			bargainRecordDO.setStartPage(startPage);
			bargainRecordDO.setPageSize(pageSize);
			return this.queryPageListDynamic(bargainRecordDO);
		}
		return new Page<BargainRecordDO>();
	}


	@Override
	public int countAreadyBargainTimes(Long userId, Long tiId, String bargainType) {
		if (null == userId || null == tiId) {
			return -1;
		}
		BargainRecordDO bargainRecordDO = new BargainRecordDO();
		bargainRecordDO.setUserId(userId);
		bargainRecordDO.setTopicItemId(tiId);
		if (StringUtils.isNotBlank(bargainType)) {
			bargainRecordDO.setBargainType(bargainType);
		}

		List<BargainRecordDO> list = selectDynamic(bargainRecordDO);
		return list.size();
	}
	
	
	
	
}
