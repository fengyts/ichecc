package com.ichecc.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.dao.VipDepositOrderDAO;
import com.ichecc.domain.VipDepositOrderDO;
import com.ichecc.service.VipDepositOrderService;

import ng.bayue.common.Page;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.util.StringUtils;

@Service(value = "vipDepositOrderService")
public class VipDepositOrderServiceImpl implements VipDepositOrderService {

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private VipDepositOrderDAO vipDepositOrderDAO;

	@Override
	public Long insert(VipDepositOrderDO vipDepositOrderDO) throws CommonServiceException {
		try {
			return vipDepositOrderDAO.insert(vipDepositOrderDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public int update(VipDepositOrderDO vipDepositOrderDO, boolean isAllField) throws CommonServiceException {
		try {
			if (isAllField) {
				return (Integer) vipDepositOrderDAO.update(vipDepositOrderDO);
			} else {
				return (Integer) vipDepositOrderDAO.updateDynamic(vipDepositOrderDO);
			}
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) vipDepositOrderDAO.deleteById(id);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public VipDepositOrderDO selectById(Long id) throws CommonServiceException {
		try {
			return vipDepositOrderDAO.selectById(id);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public Long selectCountDynamic(VipDepositOrderDO vipDepositOrderDO) throws CommonServiceException {
		try {
			return vipDepositOrderDAO.selectCountDynamic(vipDepositOrderDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public List<VipDepositOrderDO> selectDynamic(VipDepositOrderDO vipDepositOrderDO) throws CommonServiceException {
		try {
			return vipDepositOrderDAO.selectDynamic(vipDepositOrderDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	private List<VipDepositOrderDO> selectDynamicPageQuery(VipDepositOrderDO vipDepositOrderDO)
			throws CommonServiceException {
		try {
			return vipDepositOrderDAO.selectDynamicPageQuery(vipDepositOrderDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public Page<VipDepositOrderDO> queryPageListDynamic(VipDepositOrderDO vipDepositOrderDO)
			throws CommonServiceException {
		if (vipDepositOrderDO != null) {
			Long totalCount = this.selectCountDynamic(vipDepositOrderDO);

			Page<VipDepositOrderDO> page = new Page<VipDepositOrderDO>();
			page.setPageNo(vipDepositOrderDO.getStartPage());
			page.setPageSize(vipDepositOrderDO.getPageSize());
			page.setTotalCount(totalCount.intValue());

			if (null != totalCount && totalCount.longValue() > 0) {
				List<VipDepositOrderDO> resultList = this.selectDynamicPageQuery(vipDepositOrderDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<VipDepositOrderDO>();
	}

	@Override
	public Page<VipDepositOrderDO> queryPageListDynamicAndStartPageSize(VipDepositOrderDO vipDepositOrderDO,
			Integer startPage, Integer pageSize) throws CommonServiceException {
		if (vipDepositOrderDO != null && startPage > 0 && pageSize > 0) {
			vipDepositOrderDO.setStartPage(startPage);
			vipDepositOrderDO.setPageSize(pageSize);
			return this.queryPageListDynamic(vipDepositOrderDO);
		}
		return new Page<VipDepositOrderDO>();
	}

	@Override
	public VipDepositOrderDO selectLatestUnPaidOrder(Long userId) {
		if (null == userId) {
			return null;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, -2);
		cal.add(Calendar.MINUTE, -5); // 为防止支付的时候订单已经过期, 这里查询距离当前时间1小时55分钟内的订单
		params.put("orderTime", cal.getTime());
		return vipDepositOrderDAO.selectLatestUnPaidOrder(params);
	}

	@Override
	public VipDepositOrderDO selectByOrderNo(String orderNo) {
		if (StringUtils.isBlank(orderNo)) {
			return null;
		}
		return vipDepositOrderDAO.selectByOrderNo(orderNo);
	}

	@Override
	public int updateByOrderNo(VipDepositOrderDO orderDO) throws CommonServiceException {
		try {
			String orderNo = orderDO.getOrderNo();
			if (StringUtils.isBlank(orderNo)) {
				logger.info("更新支付订单异常：订单编号参数为空");
				throw new CommonServiceException("");
			}
			return vipDepositOrderDAO.updateByOrderNo(orderDO);
		} catch (CommonDAOException e) {
			throw new CommonServiceException(e);
		}
	}

}
