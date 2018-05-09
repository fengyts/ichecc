package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.MemberDAO;
import com.ichecc.domain.MemberDO;
import com.ichecc.service.MemberService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="memberService")
public class MemberServiceImpl  implements MemberService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public Long insert(MemberDO memberDO) throws CommonServiceException {
		try {
			return memberDAO.insert(memberDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(MemberDO memberDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) memberDAO.update(memberDO);
			}else{
				return (Integer) memberDAO.updateDynamic(memberDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) memberDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	


	@Override
	public MemberDO selectById(Long id) throws CommonServiceException {
		try {
			return memberDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	@Override
	public Long selectCountDynamic(MemberDO memberDO) throws CommonServiceException {
		try {
			return memberDAO.selectCountDynamic(memberDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<MemberDO> selectDynamic(MemberDO memberDO) throws CommonServiceException {
		try {
			return memberDAO.selectDynamic(memberDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<MemberDO> selectDynamicPageQuery(MemberDO memberDO) throws CommonServiceException {
		try {
			return memberDAO.selectDynamicPageQuery(memberDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<MemberDO> queryPageListDynamic(MemberDO memberDO) throws CommonServiceException{
		if (memberDO != null) {
			Long totalCount = this.selectCountDynamic(memberDO);

			Page<MemberDO> page = new Page<MemberDO>();
			page.setPageNo(memberDO.getStartPage());
			page.setPageSize(memberDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<MemberDO> resultList = this.selectDynamicPageQuery(memberDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<MemberDO>();
	}
	
	@Override
	public Page<MemberDO> queryPageListDynamicAndStartPageSize(MemberDO memberDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (memberDO != null && startPage>0 && pageSize>0) {
			memberDO.setStartPage(startPage);
			memberDO.setPageSize(pageSize);
			return this.queryPageListDynamic(memberDO);
		}
		return new Page<MemberDO>();
	}
	
	
}
