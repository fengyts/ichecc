package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ichecc.dao.WechatUserDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.WechatUserDO;

import ng.bayue.exception.CommonDAOException;

@Component(value="wechatUserDAO")
public class MybatisWechatUserDAO extends MybatisBaseDAO implements WechatUserDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.WechatUserMapper.MybatisWechatUserDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(WechatUserDO wechatUserDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), wechatUserDO);
		if (i > 0) {
			return Long.valueOf(wechatUserDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(WechatUserDO wechatUserDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), wechatUserDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(WechatUserDO wechatUserDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), wechatUserDO);
	}

	@Override
	public WechatUserDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(WechatUserDO wechatUserDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), wechatUserDO);
	}

	@Override
	public List<WechatUserDO> selectDynamic(WechatUserDO wechatUserDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), wechatUserDO);
	}

	@Override
	public List<WechatUserDO> selectDynamicPageQuery(WechatUserDO wechatUserDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), wechatUserDO);
	}

	@Override
	public WechatUserDO selectByOpenid(String openid) {
		return getSqlSession().selectOne(getStatement("select_by_openid"), openid);
	}
	
	

}
