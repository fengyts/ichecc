package com.ichecc.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.VipDepositConfigDAO;
import com.ichecc.domain.VipDepositConfigDO;
import com.ichecc.service.VipDepositConfigService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="vipDepositConfigService")
public class VipDepositConfigServiceImpl  implements VipDepositConfigService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private VipDepositConfigDAO vipDepositConfigDAO;

	@Override
	public Long insert(VipDepositConfigDO vipDepositConfigDO) throws CommonServiceException {
		try {
			return vipDepositConfigDAO.insert(vipDepositConfigDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(VipDepositConfigDO vipDepositConfigDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) vipDepositConfigDAO.update(vipDepositConfigDO);
			}else{
				return (Integer) vipDepositConfigDAO.updateDynamic(vipDepositConfigDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) vipDepositConfigDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public VipDepositConfigDO selectById(Long id) throws CommonServiceException {
		try {
			return vipDepositConfigDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(VipDepositConfigDO vipDepositConfigDO) throws CommonServiceException {
		try {
			return vipDepositConfigDAO.selectCountDynamic(vipDepositConfigDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<VipDepositConfigDO> selectDynamic(VipDepositConfigDO vipDepositConfigDO) throws CommonServiceException {
		try {
			return vipDepositConfigDAO.selectDynamic(vipDepositConfigDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<VipDepositConfigDO> selectDynamicPageQuery(VipDepositConfigDO vipDepositConfigDO) throws CommonServiceException {
		try {
			return vipDepositConfigDAO.selectDynamicPageQuery(vipDepositConfigDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<VipDepositConfigDO> queryPageListDynamic(VipDepositConfigDO vipDepositConfigDO) throws CommonServiceException{
		if (vipDepositConfigDO != null) {
			Long totalCount = this.selectCountDynamic(vipDepositConfigDO);

			Page<VipDepositConfigDO> page = new Page<VipDepositConfigDO>();
			page.setPageNo(vipDepositConfigDO.getStartPage());
			page.setPageSize(vipDepositConfigDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<VipDepositConfigDO> resultList = this.selectDynamicPageQuery(vipDepositConfigDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<VipDepositConfigDO>();
	}
	
	@Override
	public Page<VipDepositConfigDO> queryPageListDynamicAndStartPageSize(VipDepositConfigDO vipDepositConfigDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (vipDepositConfigDO != null && startPage>0 && pageSize>0) {
			vipDepositConfigDO.setStartPage(startPage);
			vipDepositConfigDO.setPageSize(pageSize);
			return this.queryPageListDynamic(vipDepositConfigDO);
		}
		return new Page<VipDepositConfigDO>();
	}


	@Override
	public List<VipDepositConfigDO> listAllConfig() {
		VipDepositConfigDO param = new VipDepositConfigDO();
		param.setStatus(true);
		List<VipDepositConfigDO> list = this.selectDynamic(param);

		Collections.sort(list, new Comparator<VipDepositConfigDO>() {
			@Override
			public int compare(VipDepositConfigDO o1, VipDepositConfigDO o2) {
				double amt1 = o1.getOriginalAmount(), amt2 = o2.getOriginalAmount();
				String expiryType1 = o1.getExpiryType(), expiryType2 = o2.getExpiryType();
//				//优先按照金额升序，再按照类型升序
//				if (amt1 > amt2) {
//					return 1;
//				}
//				if (amt1 == amt2) {
//					if ("01".equals(expiryType1)) {
//						return 1;
//					}
//					if ("01".equals(expiryType2)) {
//						return -1;
//					}
//					return 0;
//				}
//				return -1;
				
				// 下面排序是优先按照类型，'01'排最前，然后按照金额升序
				if ("01".equals(expiryType1)) {
					if("01".equals(expiryType2)){
						if (amt1 > amt2) {
							return 1;
						}
						if(amt1 == amt2){
							return 0;
						}
						return -1;
					}
					return -1;
				}
//				if ("02".equals(expiryType1)){
//					return -1;
//				}
				return 0;
			}
		});

		return list;
	}
	
	
	
}
