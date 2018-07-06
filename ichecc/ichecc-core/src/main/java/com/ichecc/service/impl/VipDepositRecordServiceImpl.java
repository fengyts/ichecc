package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.dao.VipDepositRecordDAO;
import com.ichecc.domain.VipDepositRecordDO;
import com.ichecc.service.VipDepositRecordService;

import ng.bayue.common.Page;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;

@Service(value="vipDepositRecordService")
public class VipDepositRecordServiceImpl  implements VipDepositRecordService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private VipDepositRecordDAO vipDepositRecordDAO;

	@Override
	public Long insert(VipDepositRecordDO vipDepositRecordDO) throws CommonServiceException {
		try {
			return vipDepositRecordDAO.insert(vipDepositRecordDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(VipDepositRecordDO vipDepositRecordDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) vipDepositRecordDAO.update(vipDepositRecordDO);
			}else{
				return (Integer) vipDepositRecordDAO.updateDynamic(vipDepositRecordDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) vipDepositRecordDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public VipDepositRecordDO selectById(Long id) throws CommonServiceException {
		try {
			return vipDepositRecordDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(VipDepositRecordDO vipDepositRecordDO) throws CommonServiceException {
		try {
			return vipDepositRecordDAO.selectCountDynamic(vipDepositRecordDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<VipDepositRecordDO> selectDynamic(VipDepositRecordDO vipDepositRecordDO) throws CommonServiceException {
		try {
			return vipDepositRecordDAO.selectDynamic(vipDepositRecordDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<VipDepositRecordDO> selectDynamicPageQuery(VipDepositRecordDO vipDepositRecordDO) throws CommonServiceException {
		try {
			return vipDepositRecordDAO.selectDynamicPageQuery(vipDepositRecordDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<VipDepositRecordDO> queryPageListDynamic(VipDepositRecordDO vipDepositRecordDO) throws CommonServiceException{
		if (vipDepositRecordDO != null) {
			Long totalCount = this.selectCountDynamic(vipDepositRecordDO);

			Page<VipDepositRecordDO> page = new Page<VipDepositRecordDO>();
			page.setPageNo(vipDepositRecordDO.getStartPage());
			page.setPageSize(vipDepositRecordDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<VipDepositRecordDO> resultList = this.selectDynamicPageQuery(vipDepositRecordDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<VipDepositRecordDO>();
	}
	
	@Override
	public Page<VipDepositRecordDO> queryPageListDynamicAndStartPageSize(VipDepositRecordDO vipDepositRecordDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (vipDepositRecordDO != null && startPage>0 && pageSize>0) {
			vipDepositRecordDO.setStartPage(startPage);
			vipDepositRecordDO.setPageSize(pageSize);
			return this.queryPageListDynamic(vipDepositRecordDO);
		}
		return new Page<VipDepositRecordDO>();
	}

	
	
	
}
