package com.ichecc.dao;

import java.util.List;

import com.ichecc.domain.TopicItemDO;
import com.ichecc.front.dto.FrontTopicItemDTO;

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

}
