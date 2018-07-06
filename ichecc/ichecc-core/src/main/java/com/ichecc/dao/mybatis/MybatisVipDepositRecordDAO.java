package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.VipDepositRecordDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.VipDepositRecordDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="vipDepositRecordDAO")
public class MybatisVipDepositRecordDAO extends MybatisBaseDAO implements VipDepositRecordDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.VipDepositRecordMapper.MybatisVipDepositRecordDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(VipDepositRecordDO vipDepositRecordDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), vipDepositRecordDO);
		if (i > 0) {
			return Long.valueOf(vipDepositRecordDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(VipDepositRecordDO vipDepositRecordDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), vipDepositRecordDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(VipDepositRecordDO vipDepositRecordDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), vipDepositRecordDO);
	}

	@Override
	public VipDepositRecordDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(VipDepositRecordDO vipDepositRecordDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), vipDepositRecordDO);
	}

	@Override
	public List<VipDepositRecordDO> selectDynamic(VipDepositRecordDO vipDepositRecordDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), vipDepositRecordDO);
	}

	@Override
	public List<VipDepositRecordDO> selectDynamicPageQuery(VipDepositRecordDO vipDepositRecordDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), vipDepositRecordDO);
	}

}
