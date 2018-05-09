package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.WechatUserDAO;
import com.ichecc.domain.WechatUserDO;
import com.ichecc.service.WechatUserService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="wechatUserService")
public class WechatUserServiceImpl  implements WechatUserService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private WechatUserDAO wechatUserDAO;

	@Override
	public Long insert(WechatUserDO wechatUserDO) throws CommonServiceException {
		try {
			return wechatUserDAO.insert(wechatUserDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(WechatUserDO wechatUserDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) wechatUserDAO.update(wechatUserDO);
			}else{
				return (Integer) wechatUserDAO.updateDynamic(wechatUserDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) wechatUserDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public WechatUserDO selectById(Long id) throws CommonServiceException {
		try {
			return wechatUserDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(WechatUserDO wechatUserDO) throws CommonServiceException {
		try {
			return wechatUserDAO.selectCountDynamic(wechatUserDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<WechatUserDO> selectDynamic(WechatUserDO wechatUserDO) throws CommonServiceException {
		try {
			return wechatUserDAO.selectDynamic(wechatUserDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<WechatUserDO> selectDynamicPageQuery(WechatUserDO wechatUserDO) throws CommonServiceException {
		try {
			return wechatUserDAO.selectDynamicPageQuery(wechatUserDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<WechatUserDO> queryPageListDynamic(WechatUserDO wechatUserDO) throws CommonServiceException{
		if (wechatUserDO != null) {
			Long totalCount = this.selectCountDynamic(wechatUserDO);

			Page<WechatUserDO> page = new Page<WechatUserDO>();
			page.setPageNo(wechatUserDO.getStartPage());
			page.setPageSize(wechatUserDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<WechatUserDO> resultList = this.selectDynamicPageQuery(wechatUserDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<WechatUserDO>();
	}
	
	@Override
	public Page<WechatUserDO> queryPageListDynamicAndStartPageSize(WechatUserDO wechatUserDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (wechatUserDO != null && startPage>0 && pageSize>0) {
			wechatUserDO.setStartPage(startPage);
			wechatUserDO.setPageSize(pageSize);
			return this.queryPageListDynamic(wechatUserDO);
		}
		return new Page<WechatUserDO>();
	}
	
	
}
