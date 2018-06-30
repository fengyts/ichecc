package com.ichecc.service;

import java.util.List;

import ng.bayue.service.common.GeneralService;

import com.ichecc.domain.ChoiceOrderDO;
import com.ichecc.vo.ChoiceOrderBaseVO;
import com.ichecc.vo.ChoiceOrderDetailVO;

 /**
 * 选车订单 Service
 * @author fengyts 2018-05-09 09:29:19
 */
public interface ChoiceOrderService extends GeneralService<ChoiceOrderDO, ChoiceOrderDO> {
	
	/**
	 * <pre>
	 * 获取用户选车订单列表
	 * </pre>
	 *
	 * @param userId
	 * @return
	 */
	List<ChoiceOrderBaseVO> selectOrderList(Long userId);

	/**
	 * <pre>
	 * 获取用户选车订单详情
	 * </pre>
	 *
	 * @param orderId
	 * @return
	 */
	ChoiceOrderDetailVO choiceOrderDetail(Long orderId);
	
	/**
	 * <pre>
	 * 选车需求拼接为字符串
	 * </pre>
	 *
	 * @param orderDO
	 * @return
	 */
	String requirementToString(ChoiceOrderDO orderDO);
	
}
