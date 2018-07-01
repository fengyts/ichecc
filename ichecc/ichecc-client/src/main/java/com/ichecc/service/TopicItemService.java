package com.ichecc.service;

import java.util.List;

import com.ichecc.domain.TopicItemDO;
import com.ichecc.dto.TopicItemDetailDTO;
import com.ichecc.front.dto.FrontTopicItemDTO;
import com.ichecc.vo.HiggleJoinVO;

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
	
	/**
	 * 根据专题商品id-tiId获取该商品详情信息
	 * @param tiId
	 * @return
	 */
	TopicItemDetailDTO topicItemDetail(Long tiId);
	
	/**
	 * <pre>
	 * 参与砍价详情数据
	 * </pre>
	 *
	 * @param userId
	 * @param tiId
	 * @return
	 */
	HiggleJoinVO participationHiggle(Long userId, Long tiId);

}
