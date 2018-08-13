package com.ichecc.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ichecc.bean.VipCardNoGenerator;
import com.ichecc.constants.ICheccConstants;
import com.ichecc.dao.VipDepositOrderDAO;
import com.ichecc.dao.VipDepositRecordDAO;
import com.ichecc.dao.VipUserInfoDAO;
import com.ichecc.domain.VipDepositOrderDO;
import com.ichecc.domain.VipDepositRecordDO;
import com.ichecc.domain.VipUserInfoDO;
import com.ichecc.service.VipDepositOrderService;

import ng.bayue.common.Page;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.service.RedisCacheService;
import ng.bayue.util.DateUtils;
import ng.bayue.util.StringUtils;

@Service(value = "vipDepositOrderService")
public class VipDepositOrderServiceImpl implements VipDepositOrderService {

	private Log logger = LogFactory.getLog(this.getClass());
	
	@Resource(name = "redisCacheService1")
	private RedisCacheService redisCacheService;

	@Autowired
	private VipDepositOrderDAO vipDepositOrderDAO;
	@Autowired
	private VipDepositRecordDAO vipDepositRecordDAO;
	@Autowired
	private VipUserInfoDAO vipUserInfoDAO;

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
			logger.info("根据订单编号更新充值订单状态异常：{}", e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	@Transactional
	public int updateVipInfoByOrder(VipDepositOrderDO orderDO) throws CommonServiceException {
		try {
			if (null == orderDO) {
				return -1;
			}
			String orderNo = orderDO.getOrderNo();
			if (StringUtils.isBlank(orderNo)) {
				return -1;
			}
			Long userId = orderDO.getUserId();
			if (null == userId) {
				return -1;
			}
			String orderStatus = orderDO.getOrderStatus();
			if (!"02".equals(orderStatus)) {
				return -1;
			}

			final String REDIS_CACHE_KEY = ICheccConstants.ICheccRedisKeys.BASE_KEY + "vipDeposit_" + orderNo;
			try {
				boolean lock = redisCacheService.lock(REDIS_CACHE_KEY); // 获得锁
				if (!lock) { // 锁被占用,返回失败
					return -1;
				}
				VipDepositRecordDO param = new VipDepositRecordDO();
				param.setOrderNo(orderNo);
				List<VipDepositRecordDO> list = vipDepositRecordDAO.selectDynamic(param);
				if (CollectionUtils.isNotEmpty(list)) { // 已经更新过了
					return 1;
				}
				// 更新订单状态
				int res = this.update(orderDO, false);
				if (res <= 0) {
					throw new CommonServiceException("更新vip充值订单异常");
				}

				// 更新用户vip信息
				VipUserInfoDO info = vipUserInfoDAO.selectById(userId);
				Date startTime = new Date();

				// 计算会员截止日期
				Integer expiryDate = orderDO.getExpiryDate();
				String expiryType = orderDO.getExpiryType();
				Calendar cal = Calendar.getInstance();
				cal.setTime(startTime);
				Date endTime = null;
				if (null == info) { // 新用户首次充值
					info = new VipUserInfoDO();
					info.setUserId(userId);
					info.setIsNew(true);
					info.setStartTime(startTime);
					String vipCardNo = new VipCardNoGenerator().generateVipCardNo();
					info.setVipCardNo(vipCardNo);

					if ("01".equals(expiryType)) { // 有效期类型为按月天
						cal.add(Calendar.DAY_OF_MONTH, expiryDate);
					} else { // 有效期类型为按月
						cal.add(Calendar.MONTH, expiryDate);
					}
					endTime = DateUtils.getDayEnd(cal); // 截止日期为截止日23:59:59.999
					info.setEndTime(endTime);

					Long id = vipUserInfoDAO.insert(info);
					if (null == id || id <= 0) {
						throw new CommonServiceException("vip充值异常,插入vip会员异常");
					}
				} else {
					// 非首冲校验当前用户会员是否生效中，若有效则日期顺延。
					endTime = info.getEndTime();
					if (endTime.after(startTime)) { // 该会员当前有效, 顺延有效期
						cal.setTime(endTime);
					}
					if ("01".equals(expiryType)) { // 有效期类型为按月天
						cal.add(Calendar.DAY_OF_MONTH, expiryDate);
					} else { // 有效期类型为按月
						cal.add(Calendar.MONTH, expiryDate);
					}
					endTime = DateUtils.getDayEnd(cal); // 截止日期为截止日23:59:59.999

					info.setStartTime(startTime);
					info.setEndTime(endTime);
					info.setIsNew(false);

					res = vipUserInfoDAO.updateDynamic(info);
					if (res <= 0) {
						throw new CommonServiceException("更新vip充值订单异常");
					}
				}

				// 插入充值记录
				VipDepositRecordDO record = new VipDepositRecordDO();
				record.setUserId(userId);
				record.setOrderNo(orderNo);
				record.setCreateTime(startTime);
				record.setEndTime(endTime);
				record.setRealAmount(orderDO.getRealAmount());

				Long recordId = vipDepositRecordDAO.insert(record);
				if (null == recordId || recordId <= 0) {
					throw new CommonServiceException("vip充值异常,插入充值记录异常");
				}

				return 1;
			} catch (CommonServiceException e) {
				throw e;
			} finally {
				try {
					redisCacheService.unLock(REDIS_CACHE_KEY);
				} catch (CommonServiceException e) {
					logger.info("释放vip充值锁失败");
					throw e;
				}
			}
		} catch (CommonDAOException e) {
			logger.info("充值更新会员信息异常: {}", e);
			throw new CommonServiceException(e);
		}
	}
	
	

}
