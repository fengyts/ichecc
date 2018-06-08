package com.ichecc.service;

import java.util.List;

import com.ichecc.domain.TopicItemDO;
import com.ichecc.front.dto.FrontTopicItemDTO;

import ng.bayue.service.common.GeneralService;

/**
 * 专题商品 Service
 * 
 * @author fengyts 2018-05-09 09:29:17
 */
public interface TopicItemService extends GeneralService<TopicItemDO, TopicItemDO> {


	/**
	 * 前端api 商品列表页查询
	 * 
	 * @return
	 */
	List<FrontTopicItemDTO> selectListFront(Long topicId);

}
