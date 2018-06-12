package com.ichecc.ao;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.TopicDO;
import com.ichecc.front.dto.FrontTopicItemDTO;
import com.ichecc.service.TopicItemService;
import com.ichecc.service.TopicService;

import ng.bayue.fastdfs.ImageUrlUtil;
import ng.bayue.util.DateUtils;

@Service
public class TopicItemAO {
	
	@Autowired
	private ImageUrlUtil imageUrlUtil;
	@Autowired
	private TopicItemService topicItemService;
	@Autowired
	private TopicService topicService;
	
	public Map<String, Object> homeData (){
		Map<String, Object> result = new HashMap<String, Object>();
		List<FrontTopicItemDTO> list = selectList();
		String periodNo = "";
		String startTime = "";
		String endTime = "";
		long countDownTime = 0l;
		Date now = new Date();
		if(CollectionUtils.isNotEmpty(list)){
			FrontTopicItemDTO dto = list.get(0);
			periodNo = dto.getPeriodNo();
			startTime = DateUtils.formatDateTime(dto.getStartTime());
			endTime = DateUtils.formatDateTime(dto.getEndTime());
			if(dto.getEndTime().after(now)){
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
	
	public List<FrontTopicItemDTO> selectList(){
		TopicDO latest = topicService.selectLatested();
		if(null == latest){
			return Collections.emptyList();
		}
		List<FrontTopicItemDTO> list = topicItemService.selectListFront(latest.getId());
		for(FrontTopicItemDTO dto : list){
			dto.setPicture(imageUrlUtil.getFileFullUrl(dto.getPicture()));
		}
		return list;
	}
	
	public Long getCountdownTime(){
		TopicDO latest = topicService.selectLatested();
		if(null == latest){
			return 0L;
		}
		Date now = new Date();
		Date endTime = latest.getEndTime();
		if(endTime.before(now)){
			return 0L;
		}
		
		return endTime.getTime() - now.getTime();
		
	}

}
