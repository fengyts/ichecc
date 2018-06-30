package com.ichecc.ao.backend;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ng.bayue.common.Page;
import ng.bayue.util.StringUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.ChoiceOrderDO;
import com.ichecc.enums.ChoiceOrderStatusEnum;
import com.ichecc.front.dto.ChoiceOrderDTO;
import com.ichecc.service.ChoiceOrderService;
import com.ichecc.util.ResultMessage;

@Service
public class ChoiceOrderAO {

	private Logger logger = LoggerFactory.getLogger(ChoiceOrderAO.class);

	@Autowired
	private ChoiceOrderService choiceOrderService;

	public Page<ChoiceOrderDTO> queryPageList(ChoiceOrderDO orderDO, Integer pageNo,
			Integer pageSize) {
		Page<ChoiceOrderDO> page = choiceOrderService.queryPageListDynamicAndStartPageSize(orderDO,
				pageNo, pageSize);
		Page<ChoiceOrderDTO> resultPage = new Page<ChoiceOrderDTO>();

		List<ChoiceOrderDO> list = page.getList();
		List<ChoiceOrderDTO> resultList = new ArrayList<ChoiceOrderDTO>();
		for (ChoiceOrderDO co : list) {
			try {
				ChoiceOrderDTO dto = new ChoiceOrderDTO();
				BeanUtils.copyProperties(dto, co);
				dto.setChoiceRequirement(choiceOrderService.requirementToString(co));
				resultList.add(dto);
			} catch (IllegalAccessException | InvocationTargetException e) {
				logger.info("", e);
				return resultPage;
			}
		}

		resultPage.setList(resultList);
		resultPage.setPageNo(page.getPageNo());
		resultPage.setPageSize(page.getPageSize());
		resultPage.setTotalCount(page.getTotalCount());
		return resultPage;
	}

	public ChoiceOrderDO selectById(Long orderId) {
		if (null == orderId || orderId < 0) {
			return null;
		}
		return choiceOrderService.selectById(orderId);
	}

	public ResultMessage handleOrder(Long orderId, String result) {
		if (null == orderId || orderId < 0) {
			return ResultMessage.failure("参数错误:订单id不存在");
		}
		if (StringUtils.isBlank(result)) {
			return ResultMessage.failure("处理结果不能为空");
		}

		ChoiceOrderDO orderDO = new ChoiceOrderDO();
		orderDO.setId(orderId);
		orderDO.setResult(result);
		orderDO.setStatus(ChoiceOrderStatusEnum.HAS_DISPOSED.code);
		orderDO.setModifyTime(new Date());

		choiceOrderService.update(orderDO, false);
		return ResultMessage.success();
	}

}
