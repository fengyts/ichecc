package com.ichecc.dao;

import java.util.List;

import com.ichecc.domain.TopicItemDO;
import com.ichecc.dto.TopicItemDetailDTO;
import com.ichecc.front.dto.FrontTopicItemDTO;
import com.ichecc.vo.HiggleJoinVO;

import ng.bayue.service.common.GeneralDAO;

 /**
 * 专题商品 DAO
 *
 * @author fengyts 2018-05-09 09:29:17
 */
public interface TopicItemDAO extends GeneralDAO<TopicItemDO> {
	/**
	 * <pre>
	 * 根据商品id更新专题商品冗余字段
	 * </pre>
	 *
	 * @param topicItemDO
	 * @return
	 */
	public int updateItemRedundance(TopicItemDO topicItemDO);
	
	/**
	 * 获取专题商品
	 * @param topicId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<FrontTopicItemDTO> selectListFront(Long topicId);
	
	/**
	 * 根据专题商品id-tiId获取商品详细信息
	 * @param tiId
	 * @return
	 */
	TopicItemDetailDTO topicItemDetail(Long tiId);
	
	/**
	 * 获取参与砍价详情数据
	 * @param userId
	 * @param tiId
	 * @return
	 */
	HiggleJoinVO participationHiggle(Long userId, Long tiId);

}
