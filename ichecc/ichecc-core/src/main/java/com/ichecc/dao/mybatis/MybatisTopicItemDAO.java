package com.ichecc.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ng.bayue.exception.CommonDAOException;

import org.springframework.stereotype.Component;

import com.ichecc.dao.TopicItemDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.TopicItemDO;
import com.ichecc.dto.TopicItemDetailDTO;
import com.ichecc.front.dto.FrontTopicItemDTO;
import com.ichecc.vo.HiggleJoinVO;

@Component(value="topicItemDAO")
public class MybatisTopicItemDAO extends MybatisBaseDAO implements TopicItemDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.TopicItemMapper.MybatisTopicItemDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(TopicItemDO topicItemDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), topicItemDO);
		if (i > 0) {
			return Long.valueOf(topicItemDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(TopicItemDO topicItemDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), topicItemDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(TopicItemDO topicItemDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), topicItemDO);
	}

	@Override
	public TopicItemDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(TopicItemDO topicItemDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), topicItemDO);
	}

	@Override
	public List<TopicItemDO> selectDynamic(TopicItemDO topicItemDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), topicItemDO);
	}

	@Override
	public List<TopicItemDO> selectDynamicPageQuery(TopicItemDO topicItemDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), topicItemDO);
	}
	
	@Override
	public int updateItemRedundance(TopicItemDO topicItemDO) {
		return getSqlSession().update(getStatement("update_item_redundance"), topicItemDO);
	}

	@Override
	public List<FrontTopicItemDTO> selectListFront(Long topicId) {
		return getSqlSession().selectList(getStatement("select_list_front"), topicId);
	}

	@Override
	public TopicItemDetailDTO topicItemDetail(Long tiId) {
		return getSqlSession().selectOne(getStatement("select_detail_by_tiId"), tiId);
	}

	@Override
	public HiggleJoinVO participationHiggle(Long userId, Long tiId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("tiId", tiId);
		return getSqlSession().selectOne(getStatement("participation_higgle"), params);
	}
	
	

}
