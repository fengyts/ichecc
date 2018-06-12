package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.ItemAttributeDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.ItemAttributeDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="itemAttributeDAO")
public class MybatisItemAttributeDAO extends MybatisBaseDAO implements ItemAttributeDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.ItemAttributeMapper.MybatisItemAttributeDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(ItemAttributeDO itemAttributeDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), itemAttributeDO);
		if (i > 0) {
			return Long.valueOf(itemAttributeDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(ItemAttributeDO itemAttributeDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), itemAttributeDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(ItemAttributeDO itemAttributeDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), itemAttributeDO);
	}

	@Override
	public ItemAttributeDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(ItemAttributeDO itemAttributeDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), itemAttributeDO);
	}

	@Override
	public List<ItemAttributeDO> selectDynamic(ItemAttributeDO itemAttributeDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), itemAttributeDO);
	}

	@Override
	public List<ItemAttributeDO> selectDynamicPageQuery(ItemAttributeDO itemAttributeDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), itemAttributeDO);
	}

	@Override
	public List<ItemAttributeDO> selectByIds(List<Long> ids) {
		return getSqlSession().selectList(getStatement("select_by_ids"), ids);
	}
	
	

}
