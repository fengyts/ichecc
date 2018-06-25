package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.IcheccUserDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.IcheccUserDO;
import com.ichecc.dto.ICheccUserDTO;

import ng.bayue.exception.CommonDAOException;

@Component(value="icheccUserDAO")
public class MybatisIcheccUserDAO extends MybatisBaseDAO implements IcheccUserDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.IcheccUserMapper.MybatisIcheccUserDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(IcheccUserDO icheccUserDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), icheccUserDO);
		if (i > 0) {
			return Long.valueOf(icheccUserDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(IcheccUserDO icheccUserDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), icheccUserDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(IcheccUserDO icheccUserDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), icheccUserDO);
	}

	@Override
	public IcheccUserDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(IcheccUserDO icheccUserDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), icheccUserDO);
	}

	@Override
	public List<IcheccUserDO> selectDynamic(IcheccUserDO icheccUserDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), icheccUserDO);
	}

	@Override
	public List<IcheccUserDO> selectDynamicPageQuery(IcheccUserDO icheccUserDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), icheccUserDO);
	}

	@Override
	public ICheccUserDTO selectByOpenid(String openid) {
		return getSqlSession().selectOne(getStatement("select_by_openid"), openid);
	}
	
	
	

}
