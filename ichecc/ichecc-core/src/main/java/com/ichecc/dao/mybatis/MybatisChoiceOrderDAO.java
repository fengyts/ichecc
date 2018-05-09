package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.ChoiceOrderDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.ChoiceOrderDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="choiceOrderDAO")
public class MybatisChoiceOrderDAO extends MybatisBaseDAO implements ChoiceOrderDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.ChoiceOrderMapper.MybatisChoiceOrderDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(ChoiceOrderDO choiceOrderDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), choiceOrderDO);
		if (i > 0) {
			return Long.valueOf(choiceOrderDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(ChoiceOrderDO choiceOrderDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), choiceOrderDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(ChoiceOrderDO choiceOrderDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), choiceOrderDO);
	}

	@Override
	public ChoiceOrderDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(ChoiceOrderDO choiceOrderDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), choiceOrderDO);
	}

	@Override
	public List<ChoiceOrderDO> selectDynamic(ChoiceOrderDO choiceOrderDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), choiceOrderDO);
	}

	@Override
	public List<ChoiceOrderDO> selectDynamicPageQuery(ChoiceOrderDO choiceOrderDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), choiceOrderDO);
	}

}
