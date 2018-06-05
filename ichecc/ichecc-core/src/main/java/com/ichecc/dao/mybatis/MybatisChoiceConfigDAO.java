package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.ChoiceConfigDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.ChoiceConfigDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="choiceConfigDAO")
public class MybatisChoiceConfigDAO extends MybatisBaseDAO implements ChoiceConfigDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.ChoiceConfigMapper.MybatisChoiceConfigDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(ChoiceConfigDO choiceConfigDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), choiceConfigDO);
		if (i > 0) {
			return Long.valueOf(choiceConfigDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(ChoiceConfigDO choiceConfigDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), choiceConfigDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(ChoiceConfigDO choiceConfigDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), choiceConfigDO);
	}

	@Override
	public ChoiceConfigDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(ChoiceConfigDO choiceConfigDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), choiceConfigDO);
	}

	@Override
	public List<ChoiceConfigDO> selectDynamic(ChoiceConfigDO choiceConfigDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), choiceConfigDO);
	}

	@Override
	public List<ChoiceConfigDO> selectDynamicPageQuery(ChoiceConfigDO choiceConfigDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), choiceConfigDO);
	}

}
