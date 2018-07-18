package com.ichecc.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.ichecc.dao.VipDepositOrderDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.VipDepositOrderDO;
import ng.bayue.exception.CommonDAOException;

@Component(value = "vipDepositOrderDAO")
public class MybatisVipDepositOrderDAO extends MybatisBaseDAO implements VipDepositOrderDAO {

	private static final String NAMESPACE = "com.ichecc.domain.VipDepositOrderMapper.MybatisVipDepositOrderDAO_";

	private static String getStatement(String operation) {
		return NAMESPACE + operation;
	}

	public Long insert(VipDepositOrderDO vipDepositOrderDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), vipDepositOrderDO);
		if (i > 0) {
			return Long.valueOf(vipDepositOrderDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(VipDepositOrderDO vipDepositOrderDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), vipDepositOrderDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}

	@Override
	public Integer updateDynamic(VipDepositOrderDO vipDepositOrderDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), vipDepositOrderDO);
	}

	@Override
	public VipDepositOrderDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}

	@Override
	public Long selectCountDynamic(VipDepositOrderDO vipDepositOrderDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), vipDepositOrderDO);
	}

	@Override
	public List<VipDepositOrderDO> selectDynamic(VipDepositOrderDO vipDepositOrderDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), vipDepositOrderDO);
	}

	@Override
	public List<VipDepositOrderDO> selectDynamicPageQuery(VipDepositOrderDO vipDepositOrderDO)
			throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), vipDepositOrderDO);
	}

	@Override
	public VipDepositOrderDO selectLatestUnPaidOrder(Map<String, Object> params) {
		return getSqlSession().selectOne(getStatement("select_latest_unpaid"), params);
	}

	@Override
	public VipDepositOrderDO selectByOrderNo(String orderNo) {
		return getSqlSession().selectOne(getStatement("select_order_by_orderno"), orderNo);
	}

	@Override
	public int updateByOrderNo(VipDepositOrderDO orderDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_order_by_orderno"), orderDO);
	}

}
