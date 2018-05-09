package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.MemberDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.MemberDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="memberDAO")
public class MybatisMemberDAO extends MybatisBaseDAO implements MemberDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.MemberMapper.MybatisMemberDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(MemberDO memberDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), memberDO);
		if (i > 0) {
			return Long.valueOf(memberDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(MemberDO memberDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), memberDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	

	@Override
	public Integer updateDynamic(MemberDO memberDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), memberDO);
	}

	@Override
	public MemberDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	

	@Override
	public Long selectCountDynamic(MemberDO memberDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), memberDO);
	}

	@Override
	public List<MemberDO> selectDynamic(MemberDO memberDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), memberDO);
	}

	@Override
	public List<MemberDO> selectDynamicPageQuery(MemberDO memberDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), memberDO);
	}

}
