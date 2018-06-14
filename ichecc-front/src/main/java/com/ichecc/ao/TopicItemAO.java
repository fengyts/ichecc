package com.ichecc.ao;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.common.ResultData;
import com.ichecc.domain.ItemAttributeDO;
import com.ichecc.domain.TopicDO;
import com.ichecc.dto.TopicItemDetailDTO;
import com.ichecc.enums.TopicStatusEnum;
import com.ichecc.front.dto.FrontTopicItemDTO;
import com.ichecc.service.ItemAttributeService;
import com.ichecc.service.TopicItemService;
import com.ichecc.service.TopicService;

import ng.bayue.fastdfs.ImageUrlUtil;
import ng.bayue.util.DateUtils;

@Service
public class TopicItemAO {

	private static Logger logger = LoggerFactory.getLogger(TopicItemAO.class);

	@Autowired
	private ImageUrlUtil imageUrlUtil;
	@Autowired
	private TopicItemService topicItemService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ItemAttributeService attributeService;

	public Map<String, Object> homeData() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<FrontTopicItemDTO> list = selectList();
		String periodNo = "";
		String startTime = "";
		String endTime = "";
		long countDownTime = 0l;
		Date now = new Date();
		if (CollectionUtils.isNotEmpty(list)) {
			FrontTopicItemDTO dto = list.get(0);
			periodNo = dto.getPeriodNo();
			startTime = DateUtils.formatDateTime(dto.getStartTime());
			endTime = DateUtils.formatDateTime(dto.getEndTime());
			if (dto.getEndTime().after(now)) {
				countDownTime = dto.getEndTime().getTime() - now.getTime();
			}
		}
		result.put("periodNo", periodNo);
		result.put("startTime", startTime);
		result.put("endTime", endTime);
		result.put("itemList", list);
		result.put("countDownTime", countDownTime);
		return result;
	}

	public List<FrontTopicItemDTO> selectList() {
		TopicDO latest = topicService.selectLatested();
		if (null == latest) {
			return Collections.emptyList();
		}
		List<FrontTopicItemDTO> list = topicItemService.selectListFront(latest.getId());
		for (FrontTopicItemDTO dto : list) {
			dto.setPicture(imageUrlUtil.getFileFullUrl(dto.getPicture()));
		}
		return list;
	}

	public Long getCountdownTime() {
		TopicDO latest = topicService.selectLatested();
		if (null == latest) {
			return 0L;
		}
		Date now = new Date();
		Date endTime = latest.getEndTime();
		if (endTime.before(now)) {
			return 0L;
		}

		return endTime.getTime() - now.getTime();
	}

	public ResultData topicItemDetail(Long tiId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			TopicItemDetailDTO detailDTO = topicItemService.topicItemDetail(tiId);
			if(null == detailDTO){
				return ResultData.failure("数据异常");
			}
			FrontTopicItemDTO dto = new FrontTopicItemDTO();
			BeanUtils.copyProperties(dto, detailDTO);
			dto.setTiId(detailDTO.getId());
			dto.setPicture(imageUrlUtil.getFileFullUrl(dto.getPicture()));
			
			String attributes = detailDTO.getAttributes();
			List<ItemAttributeDO> attrList = attributeService.selectByIdsStr(attributes);
			String[] attrArr = new String[attrList.size()];
			for (int i = 0; i < attrList.size(); i++) {
				attrArr[i] = attrList.get(i).getName() + "：" + attrList.get(i).getValue();
			}

			long countDownTime = 0;
			String status = TopicStatusEnum.End.code; // 02-进行中；03-已结束
			Date now = new Date();
			if (dto.getEndTime().after(now)) {
				status = TopicStatusEnum.InProgress.code;
				countDownTime = dto.getEndTime().getTime() - now.getTime();
			}
			dto.setStatus(status);
			result.put("countDownTime", countDownTime);
			result.put("attrs", attrArr);
			result.put("detail", dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.info("获取专题商品详情异常");
		}
		return ResultData.success(result);
	}

}
