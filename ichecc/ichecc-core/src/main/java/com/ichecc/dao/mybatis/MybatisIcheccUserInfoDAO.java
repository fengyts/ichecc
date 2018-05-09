package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.IcheccUserInfoDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.IcheccUserInfoDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="icheccUserInfoDAO")
public class MybatisIcheccUserInfoDAO extends MybatisBaseDAO implements IcheccUserInfoDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.IcheccUserInfoMapper.MybatisIcheccUserInfoDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(IcheccUserInfoDO icheccUserInfoDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), icheccUserInfoDO);
		if (i > 0) {
			return Long.valueOf(icheccUserInfoDO.getUserId());
		}
		return 0L;
	}

	@Override
	public Integer update(IcheccUserInfoDO icheccUserInfoDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), icheccUserInfoDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(IcheccUserInfoDO icheccUserInfoDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), icheccUserInfoDO);
	}

	@Override
	public IcheccUserInfoDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(IcheccUserInfoDO icheccUserInfoDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), icheccUserInfoDO);
	}

	@Override
	public List<IcheccUserInfoDO> selectDynamic(IcheccUserInfoDO icheccUserInfoDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), icheccUserInfoDO);
	}

	@Override
	public List<IcheccUserInfoDO> selectDynamicPageQuery(IcheccUserInfoDO icheccUserInfoDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), icheccUserInfoDO);
	}

}
