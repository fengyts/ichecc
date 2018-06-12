package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.SpecGroupDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.SpecGroupDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="specGroupDAO")
public class MybatisSpecGroupDAO extends MybatisBaseDAO implements SpecGroupDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.SpecGroupMapper.MybatisSpecGroupDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(SpecGroupDO specGroupDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), specGroupDO);
		if (i > 0) {
			return Long.valueOf(specGroupDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(SpecGroupDO specGroupDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), specGroupDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(SpecGroupDO specGroupDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), specGroupDO);
	}

	@Override
	public SpecGroupDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(SpecGroupDO specGroupDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), specGroupDO);
	}

	@Override
	public List<SpecGroupDO> selectDynamic(SpecGroupDO specGroupDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), specGroupDO);
	}

	@Override
	public List<SpecGroupDO> selectDynamicPageQuery(SpecGroupDO specGroupDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), specGroupDO);
	}

}
