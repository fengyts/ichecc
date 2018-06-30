package com.ichecc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.ChoiceOrderDAO;
import com.ichecc.domain.ChoiceOrderDO;
import com.ichecc.enums.ChoiceOrderStatusEnum;
import com.ichecc.service.ChoiceOrderService;
import com.ichecc.vo.ChoiceOrderBaseVO;
import com.ichecc.vo.ChoiceOrderDetailVO;

import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;
import ng.bayue.constants.SymbolConstant;

@Service(value = "choiceOrderService")
public class ChoiceOrderServiceImpl implements ChoiceOrderService {

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private ChoiceOrderDAO choiceOrderDAO;

	@Override
	public Long insert(ChoiceOrderDO choiceOrderDO) throws CommonServiceException {
		try {
			return choiceOrderDAO.insert(choiceOrderDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public int update(ChoiceOrderDO choiceOrderDO, boolean isAllField)
			throws CommonServiceException {
		try {
			if (isAllField) {
				return (Integer) choiceOrderDAO.update(choiceOrderDO);
			} else {
				return (Integer) choiceOrderDAO.updateDynamic(choiceOrderDO);
			}
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) choiceOrderDAO.deleteById(id);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public ChoiceOrderDO selectById(Long id) throws CommonServiceException {
		try {
			return choiceOrderDAO.selectById(id);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public Long selectCountDynamic(ChoiceOrderDO choiceOrderDO) throws CommonServiceException {
		try {
			return choiceOrderDAO.selectCountDynamic(choiceOrderDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public List<ChoiceOrderDO> selectDynamic(ChoiceOrderDO choiceOrderDO)
			throws CommonServiceException {
		try {
			return choiceOrderDAO.selectDynamic(choiceOrderDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	private List<ChoiceOrderDO> selectDynamicPageQuery(ChoiceOrderDO choiceOrderDO)
			throws CommonServiceException {
		try {
			return choiceOrderDAO.selectDynamicPageQuery(choiceOrderDO);
		} catch (CommonDAOException e) {
			logger.error(e);
			throw new CommonServiceException(e);
		}
	}

	@Override
	public Page<ChoiceOrderDO> queryPageListDynamic(ChoiceOrderDO choiceOrderDO)
			throws CommonServiceException {
		if (choiceOrderDO != null) {
			Long totalCount = this.selectCountDynamic(choiceOrderDO);

			Page<ChoiceOrderDO> page = new Page<ChoiceOrderDO>();
			page.setPageNo(choiceOrderDO.getStartPage());
			page.setPageSize(choiceOrderDO.getPageSize());
			page.setTotalCount(totalCount.intValue());

			if (null != totalCount && totalCount.longValue() > 0) {
				List<ChoiceOrderDO> resultList = this.selectDynamicPageQuery(choiceOrderDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<ChoiceOrderDO>();
	}

	@Override
	public Page<ChoiceOrderDO> queryPageListDynamicAndStartPageSize(ChoiceOrderDO choiceOrderDO,
			Integer startPage, Integer pageSize) throws CommonServiceException {
		if (choiceOrderDO != null && startPage > 0 && pageSize > 0) {
			choiceOrderDO.setStartPage(startPage);
			choiceOrderDO.setPageSize(pageSize);
			return this.queryPageListDynamic(choiceOrderDO);
		}
		return new Page<ChoiceOrderDO>();
	}
	
	@Override
	public String requirementToString(ChoiceOrderDO choiceOrderDO) {
		StringBuilder res = new StringBuilder();
		res.append(choiceOrderDO.getBudget()).append("万元").append(SymbolConstant.COMMA)
				.append(choiceOrderDO.getBrand()).append(SymbolConstant.COMMA)
				.append(choiceOrderDO.getType()).append(SymbolConstant.COMMA)
				.append(choiceOrderDO.getSeat()).append(SymbolConstant.COMMA)
				.append(choiceOrderDO.getStructure()).append(SymbolConstant.COMMA)
				.append(choiceOrderDO.getGearbox()).append(SymbolConstant.COMMA)
				.append(choiceOrderDO.getStructure()).append(SymbolConstant.COMMA)
				.append(choiceOrderDO.getOtherRequirement());
		return res.toString();
	}

	@Override
	public List<ChoiceOrderBaseVO> selectOrderList(Long userId) {
		try {
			ChoiceOrderDO paramDto = new ChoiceOrderDO();
			paramDto.setUserId(userId);
			List<ChoiceOrderDO> list = choiceOrderDAO.selectDynamic(paramDto);
			List<ChoiceOrderBaseVO> results = new ArrayList<ChoiceOrderBaseVO>();
			for (ChoiceOrderDO co : list) {
				ChoiceOrderBaseVO vo = new ChoiceOrderBaseVO();
				vo.setOrderId(co.getId());
				vo.setChoiceOrderTime(co.getCreateTime());
				vo.setChoiceRequirement(requirementToString(co));
				vo.setOrderStatus(co.getStatus());
				vo.setOrderStatusDesc(ChoiceOrderStatusEnum.getDescByCode(co.getStatus()));

				results.add(vo);
			}

			return results;
		} catch (CommonDAOException e) {
			logger.error("", e);
			return null;
		}
	}

	@Override
	public ChoiceOrderDetailVO choiceOrderDetail(Long orderId) {
		try {
			ChoiceOrderDO orderDO = choiceOrderDAO.selectById(orderId);
			if (null == orderDO) {
				return null;
			}
			ChoiceOrderDetailVO vo = new ChoiceOrderDetailVO();
			vo.setChoiceOrderTime(orderDO.getCreateTime());
			vo.setChoiceRequirement(requirementToString(orderDO));
			vo.setHandleTime(orderDO.getModifyTime());
			vo.setOrderId(orderDO.getId());
			vo.setOrderStatus(orderDO.getStatus());
			vo.setOrderStatusDesc(ChoiceOrderStatusEnum.getDescByCode(orderDO.getStatus()));
			vo.setResult(orderDO.getResult());
			return vo;
		} catch (CommonDAOException e) {
			logger.error("", e);
			return null;
		}
	}

}
