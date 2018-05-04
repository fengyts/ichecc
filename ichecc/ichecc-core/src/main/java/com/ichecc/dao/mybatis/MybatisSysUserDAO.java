package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ichecc.dao.SysUserDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.SysUserDO;
import com.ichecc.vo.SysUserVO;

import ng.bayue.exception.CommonDAOException;

@Component(value="sysUserDAO")
public class MybatisSysUserDAO extends MybatisBaseDAO implements SysUserDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.SysUserMapper.MybatisSysUserDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(SysUserDO sysUserDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), sysUserDO);
		if (i > 0) {
			return Long.valueOf(sysUserDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(SysUserDO sysUserDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), sysUserDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}

	@Override
	public Integer updateDynamic(SysUserDO sysUserDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), sysUserDO);
	}

	@Override
	public SysUserDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}

	@Override
	public Long selectCountDynamic(SysUserDO sysUserDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), sysUserDO);
	}

	@Override
	public List<SysUserDO> selectDynamic(SysUserDO sysUserDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), sysUserDO);
	}

	@Override
	public List<SysUserDO> selectDynamicPageQuery(SysUserDO sysUserDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), sysUserDO);
	}

	@Override
	public SysUserVO nestedList(String param){
		return getSqlSession().selectOne(getStatement("select_sysUser_vo"), param);
	}

	@Override
	public SysUserDO findByLoginNameOrEmailOrMobile(String param) {
		return getSqlSession().selectOne(getStatement("select_by_loginNameOrMobileOrEmail"), param);
	}
	
	
}
