package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.VipUserInfoDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.VipUserInfoDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="vipUserInfoDAO")
public class MybatisVipUserInfoDAO extends MybatisBaseDAO implements VipUserInfoDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.VipUserInfoMapper.MybatisVipUserInfoDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(VipUserInfoDO vipUserInfoDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), vipUserInfoDO);
		if (i > 0) {
			return Long.valueOf(vipUserInfoDO.getUserId());
		}
		return 0L;
	}

	@Override
	public Integer update(VipUserInfoDO vipUserInfoDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), vipUserInfoDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(VipUserInfoDO vipUserInfoDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), vipUserInfoDO);
	}

	@Override
	public VipUserInfoDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(VipUserInfoDO vipUserInfoDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), vipUserInfoDO);
	}

	@Override
	public List<VipUserInfoDO> selectDynamic(VipUserInfoDO vipUserInfoDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), vipUserInfoDO);
	}

	@Override
	public List<VipUserInfoDO> selectDynamicPageQuery(VipUserInfoDO vipUserInfoDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), vipUserInfoDO);
	}

}
