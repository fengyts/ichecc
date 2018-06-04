package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.SpecGroupLinkDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.SpecGroupLinkDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="specGroupLinkDAO")
public class MybatisSpecGroupLinkDAO extends MybatisBaseDAO implements SpecGroupLinkDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.SpecGroupLinkMapper.MybatisSpecGroupLinkDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(SpecGroupLinkDO specGroupLinkDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), specGroupLinkDO);
		if (i > 0) {
			return Long.valueOf(specGroupLinkDO.getSpecGroupId());
		}
		return 0L;
	}

	@Override
	public Integer update(SpecGroupLinkDO specGroupLinkDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), specGroupLinkDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(SpecGroupLinkDO specGroupLinkDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), specGroupLinkDO);
	}

	@Override
	public SpecGroupLinkDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(SpecGroupLinkDO specGroupLinkDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), specGroupLinkDO);
	}

	@Override
	public List<SpecGroupLinkDO> selectDynamic(SpecGroupLinkDO specGroupLinkDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), specGroupLinkDO);
	}

	@Override
	public List<SpecGroupLinkDO> selectDynamicPageQuery(SpecGroupLinkDO specGroupLinkDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), specGroupLinkDO);
	}

}
