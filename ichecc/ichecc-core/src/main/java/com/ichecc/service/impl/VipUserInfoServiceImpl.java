package com.ichecc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.dao.VipUserInfoDAO;
import com.ichecc.domain.VipUserInfoDO;
import com.ichecc.enums.VipUserCateEnum;
import com.ichecc.service.VipUserInfoService;
import com.ichecc.vo.VipInfoVO;

import ng.bayue.common.Page;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.util.DateUtils;

@Service(value="vipUserInfoService")
public class VipUserInfoServiceImpl  implements VipUserInfoService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private VipUserInfoDAO vipUserInfoDAO;

	@Override
	public Long insert(VipUserInfoDO vipUserInfoDO) throws CommonServiceException {
		try {
			return vipUserInfoDAO.insert(vipUserInfoDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(VipUserInfoDO vipUserInfoDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) vipUserInfoDAO.update(vipUserInfoDO);
			}else{
				return (Integer) vipUserInfoDAO.updateDynamic(vipUserInfoDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) vipUserInfoDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public VipUserInfoDO selectById(Long id) throws CommonServiceException {
		try {
			return vipUserInfoDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(VipUserInfoDO vipUserInfoDO) throws CommonServiceException {
		try {
			return vipUserInfoDAO.selectCountDynamic(vipUserInfoDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<VipUserInfoDO> selectDynamic(VipUserInfoDO vipUserInfoDO) throws CommonServiceException {
		try {
			return vipUserInfoDAO.selectDynamic(vipUserInfoDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<VipUserInfoDO> selectDynamicPageQuery(VipUserInfoDO vipUserInfoDO) throws CommonServiceException {
		try {
			return vipUserInfoDAO.selectDynamicPageQuery(vipUserInfoDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<VipUserInfoDO> queryPageListDynamic(VipUserInfoDO vipUserInfoDO) throws CommonServiceException{
		if (vipUserInfoDO != null) {
			Long totalCount = this.selectCountDynamic(vipUserInfoDO);

			Page<VipUserInfoDO> page = new Page<VipUserInfoDO>();
			page.setPageNo(vipUserInfoDO.getStartPage());
			page.setPageSize(vipUserInfoDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<VipUserInfoDO> resultList = this.selectDynamicPageQuery(vipUserInfoDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<VipUserInfoDO>();
	}
	
	@Override
	public Page<VipUserInfoDO> queryPageListDynamicAndStartPageSize(VipUserInfoDO vipUserInfoDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (vipUserInfoDO != null && startPage>0 && pageSize>0) {
			vipUserInfoDO.setStartPage(startPage);
			vipUserInfoDO.setPageSize(pageSize);
			return this.queryPageListDynamic(vipUserInfoDO);
		}
		return new Page<VipUserInfoDO>();
	}
	

	@Override
	public VipInfoVO getVipInfo(Long userId) {
		try {
			if (null == userId || userId.longValue() < 0) {
				return new VipInfoVO();
			}
			VipInfoVO vo = new VipInfoVO();
			vo.setUserId(userId);
			VipUserInfoDO vi = selectById(userId);
			if (null == vi) {
				vo.setVipCate(VipUserCateEnum.Never.code);
				return vo;
			}
			vo.setVipCate(vi.getIsNew() ? VipUserCateEnum.IsNew.code : VipUserCateEnum.MoreThenOnce.code);
			vo.setVipCardNo(vi.getVipCardNo());
			vo.setStartTime(vi.getStartTime());
			Date endTime = vi.getEndTime();
			vo.setEndTime(endTime);
			Date now = new Date();
			boolean isVip = now.before(endTime); // 是vip
			if (isVip) {
				int days = DateUtils.getDistanceOfTwoDate(new Date(), endTime).intValue();
				vo.setExpiryDate(days);
			}
			vo.setIsVip(isVip);
			return vo;
		} catch (CommonServiceException e) {
			logger.info(e);
			throw e;
		}
	}
	
	
	
}
