package com.ichecc.dao;

import com.ichecc.domain.TopicItemDO;
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

}
