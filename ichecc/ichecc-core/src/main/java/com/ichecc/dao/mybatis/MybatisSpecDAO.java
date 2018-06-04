package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.SpecDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.SpecDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="specDAO")
public class MybatisSpecDAO extends MybatisBaseDAO implements SpecDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.SpecMapper.MybatisSpecDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(SpecDO specDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), specDO);
		if (i > 0) {
			return Long.valueOf(specDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(SpecDO specDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), specDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(SpecDO specDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), specDO);
	}

	@Override
	public SpecDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(SpecDO specDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), specDO);
	}

	@Override
	public List<SpecDO> selectDynamic(SpecDO specDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), specDO);
	}

	@Override
	public List<SpecDO> selectDynamicPageQuery(SpecDO specDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), specDO);
	}

}
