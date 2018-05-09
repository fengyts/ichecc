package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.BargainRecordDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.BargainRecordDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="bargainRecordDAO")
public class MybatisBargainRecordDAO extends MybatisBaseDAO implements BargainRecordDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.BargainRecordMapper.MybatisBargainRecordDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(BargainRecordDO bargainRecordDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), bargainRecordDO);
		if (i > 0) {
			return Long.valueOf(bargainRecordDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(BargainRecordDO bargainRecordDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), bargainRecordDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(BargainRecordDO bargainRecordDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), bargainRecordDO);
	}

	@Override
	public BargainRecordDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(BargainRecordDO bargainRecordDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), bargainRecordDO);
	}

	@Override
	public List<BargainRecordDO> selectDynamic(BargainRecordDO bargainRecordDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), bargainRecordDO);
	}

	@Override
	public List<BargainRecordDO> selectDynamicPageQuery(BargainRecordDO bargainRecordDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), bargainRecordDO);
	}

}
