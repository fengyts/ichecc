package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.VipDepositConfigDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.VipDepositConfigDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="vipDepositConfigDAO")
public class MybatisVipDepositConfigDAO extends MybatisBaseDAO implements VipDepositConfigDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.VipDepositConfigMapper.MybatisVipDepositConfigDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(VipDepositConfigDO vipDepositConfigDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), vipDepositConfigDO);
		if (i > 0) {
			return Long.valueOf(vipDepositConfigDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(VipDepositConfigDO vipDepositConfigDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), vipDepositConfigDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(VipDepositConfigDO vipDepositConfigDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), vipDepositConfigDO);
	}

	@Override
	public VipDepositConfigDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(VipDepositConfigDO vipDepositConfigDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), vipDepositConfigDO);
	}

	@Override
	public List<VipDepositConfigDO> selectDynamic(VipDepositConfigDO vipDepositConfigDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), vipDepositConfigDO);
	}

	@Override
	public List<VipDepositConfigDO> selectDynamicPageQuery(VipDepositConfigDO vipDepositConfigDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), vipDepositConfigDO);
	}

}
