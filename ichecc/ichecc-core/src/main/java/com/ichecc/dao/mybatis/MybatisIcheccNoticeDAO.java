package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.IcheccNoticeDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.IcheccNoticeDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="icheccNoticeDAO")
public class MybatisIcheccNoticeDAO extends MybatisBaseDAO implements IcheccNoticeDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.IcheccNoticeMapper.MybatisIcheccNoticeDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(IcheccNoticeDO icheccNoticeDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), icheccNoticeDO);
		if (i > 0) {
			return Long.valueOf(icheccNoticeDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(IcheccNoticeDO icheccNoticeDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), icheccNoticeDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(IcheccNoticeDO icheccNoticeDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), icheccNoticeDO);
	}

	@Override
	public IcheccNoticeDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(IcheccNoticeDO icheccNoticeDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), icheccNoticeDO);
	}

	@Override
	public List<IcheccNoticeDO> selectDynamic(IcheccNoticeDO icheccNoticeDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), icheccNoticeDO);
	}

	@Override
	public List<IcheccNoticeDO> selectDynamicPageQuery(IcheccNoticeDO icheccNoticeDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), icheccNoticeDO);
	}

}
