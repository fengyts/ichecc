package com.ichecc.ao;

import java.util.Collections;
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
		if(CollectionUtils.isNotEmpty(list)){
			periodNo = list.get(0).getPeriodNo();
			startTime = DateUtils.formatDateTime(list.get(0).getStartTime());
			endTime = DateUtils.formatDateTime(list.get(0).getEndTime());
		}
		result.put("periodNo", periodNo);
		result.put("startTime", startTime);
		result.put("endTime", endTime);
		result.put("itemList", list);
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

}
