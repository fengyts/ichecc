package com.ichecc.ao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.TopicDO;
import com.ichecc.front.dto.FrontTopicItemDTO;
import com.ichecc.service.TopicItemService;
import com.ichecc.service.TopicService;

import ng.bayue.fastdfs.ImageUrlUtil;

@Service
public class TopicItemAO {
	
	@Autowired
	private ImageUrlUtil imageUrlUtil;
	@Autowired
	private TopicItemService topicItemService;
	@Autowired
	private TopicService topicService;
	
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
