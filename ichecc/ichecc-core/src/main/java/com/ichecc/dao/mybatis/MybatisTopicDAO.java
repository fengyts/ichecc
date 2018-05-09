package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.TopicDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.TopicDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="topicDAO")
public class MybatisTopicDAO extends MybatisBaseDAO implements TopicDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.TopicMapper.MybatisTopicDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(TopicDO topicDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), topicDO);
		if (i > 0) {
			return Long.valueOf(topicDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(TopicDO topicDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), topicDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(TopicDO topicDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), topicDO);
	}

	@Override
	public TopicDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(TopicDO topicDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), topicDO);
	}

	@Override
	public List<TopicDO> selectDynamic(TopicDO topicDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), topicDO);
	}

	@Override
	public List<TopicDO> selectDynamicPageQuery(TopicDO topicDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), topicDO);
	}

	@Override
	public TopicDO selectLatested() {
		return getSqlSession().selectOne(getStatement("select_latested"));
	}

}
