package com.ichecc.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.constants.ICheccConstants;
import com.ichecc.dao.BargainRecordDAO;
import com.ichecc.dao.TopicItemDAO;
import com.ichecc.domain.BargainRecordDO;
import com.ichecc.domain.TopicItemDO;
import com.ichecc.dto.TopicItemDetailDTO;
import com.ichecc.enums.TopicItemProgressEnum;
import com.ichecc.enums.TopicStatusEnum;
import com.ichecc.front.dto.FrontTopicItemDTO;
import com.ichecc.service.IcheccConstantsService;
import com.ichecc.service.TopicItemService;
import com.ichecc.vo.HiggleJoinVO;

import ng.bayue.common.Page;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;

@Service(value = "topicItemService")
public class TopicItemServiceImpl implements TopicItemService {

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private TopicItemDAO topicItemDAO;
	@Autowired
	private IcheccConstantsService constantsService;
	@Autowired
	private BargainRecordDAO bargainRecordDAO;

	@Override
	public Long insert(TopicItemDO topicItemDO) throws CommonServiceException {
		try {
			return topicItemDAO.insert(topicItemDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public int update(TopicItemDO topicItemDO, boolean isAllField) throws CommonServiceException {
		try {
			if (isAllField) {
				return (Integer) topicItemDAO.update(topicItemDO);
			} else {
				return (Integer) topicItemDAO.updateDynamic(topicItemDO);
			}
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) topicItemDAO.deleteById(id);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public TopicItemDO selectById(Long id) throws CommonServiceException {
		try {
			return topicItemDAO.selectById(id);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public Long selectCountDynamic(TopicItemDO topicItemDO) throws CommonServiceException {
		try {
			return topicItemDAO.selectCountDynamic(topicItemDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public List<TopicItemDO> selectDynamic(TopicItemDO topicItemDO) throws CommonServiceException {
		try {
			return topicItemDAO.selectDynamic(topicItemDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	private List<TopicItemDO> selectDynamicPageQuery(TopicItemDO topicItemDO) throws CommonServiceException {
		try {
			return topicItemDAO.selectDynamicPageQuery(topicItemDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public Page<TopicItemDO> queryPageListDynamic(TopicItemDO topicItemDO) throws CommonServiceException {
		if (topicItemDO != null) {
			Long totalCount = this.selectCountDynamic(topicItemDO);

			Page<TopicItemDO> page = new Page<TopicItemDO>();
			page.setPageNo(topicItemDO.getStartPage());
			page.setPageSize(topicItemDO.getPageSize());
			page.setTotalCount(totalCount.intValue());

			if (null != totalCount && totalCount.longValue() > 0) {
				List<TopicItemDO> resultList = this.selectDynamicPageQuery(topicItemDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<TopicItemDO>();
	}

	@Override
	public Page<TopicItemDO> queryPageListDynamicAndStartPageSize(TopicItemDO topicItemDO, Integer startPage,
			Integer pageSize) throws CommonServiceException {
		if (topicItemDO != null && startPage > 0 && pageSize > 0) {
			topicItemDO.setStartPage(startPage);
			topicItemDO.setPageSize(pageSize);
			return this.queryPageListDynamic(topicItemDO);
		}
		return new Page<TopicItemDO>();
	}

	@Override
	public List<FrontTopicItemDTO> selectListFront(Long topicId) {
		if (null == topicId) {
			return Collections.emptyList();
		}
		return topicItemDAO.selectListFront(topicId);
	}

	@Override
	public TopicItemDetailDTO topicItemDetail(Long tiId) {
		if (null == tiId || tiId < 0) {
			return null;
		}
		return topicItemDAO.topicItemDetail(tiId);
	}

	@Override
	public HiggleJoinVO participationHiggle(Long userId, Long tiId) {
		try {
			if (null == userId || null == tiId) {
				return null;
			}
			HiggleJoinVO vo = topicItemDAO.participationHiggle(userId, tiId);
			vo.setBargainRules(constantsService.getValueByKey(ICheccConstants.BARGAIN_RULES));

			BargainRecordDO brDO = new BargainRecordDO();
			brDO.setTopicItemId(tiId);
			brDO.setUserId(userId);
			List<BargainRecordDO> brList = bargainRecordDAO.selectDynamic(brDO);
			Integer hasBargainTimes = 0;
			Double alreadyBargainAmt = 0d;
			if(CollectionUtils.isNotEmpty(brList)){
				hasBargainTimes = brList.size();
				for(BargainRecordDO r : brList){
					alreadyBargainAmt += r.getBargainAmount();
				}
			}
			vo.setAlreadyBargainAmt(new BigDecimal(alreadyBargainAmt));
			vo.setShortBargainAmt(new BigDecimal(vo.getBargainAmount() - alreadyBargainAmt));
			vo.setResidueTimes(vo.getBargainMaxTimes() - hasBargainTimes);
			
			Date now = new Date();
			Date endTime = vo.getEndTime();
			if (endTime != null) {
				if (endTime.after(now)) {
					vo.setStatus(TopicStatusEnum.InProgress.code);
				} else if (endTime.before(now)) {
					vo.setStatus(TopicStatusEnum.End.code);
				} else {
					vo.setStatus(TopicStatusEnum.NotStarted.code);
				}
			}

			long countDownTime = 0;
			String progress = TopicItemProgressEnum.End.code;
			if (null != vo) {
				if (vo.getIsSuccess()) { // 已经有人砍价成功
					progress = TopicItemProgressEnum.Bargain_Success.code;
				} else {
					if (vo.getEndTime().after(now)) { // 未砍价成功, 未到期
						progress = TopicItemProgressEnum.InProgress.code;
						countDownTime = vo.getEndTime().getTime() - now.getTime();
					} else { // 时间已到期, 已结束
						progress = TopicItemProgressEnum.End.code;
					}
				}
			}
			vo.setProgress(progress);
			vo.setCountDownTime(countDownTime);

			return vo;

		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

}
