package com.ichecc.controller.backend;

import ng.bayue.common.Page;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.backend.ChoiceOrderAO;
import com.ichecc.backend.constants.BackendConstant;
import com.ichecc.domain.ChoiceOrderDO;
import com.ichecc.enums.ChoiceOrderStatusEnum;
import com.ichecc.front.dto.ChoiceOrderDTO;
import com.ichecc.util.ResultMessage;

@Controller
@RequestMapping("/choiceOrder/")
public class ChoiceOrderController {

	@Autowired
	private ChoiceOrderAO choiceOrderAO;

	@RequestMapping("list")
	public String choiceOrderList(Model model, ChoiceOrderDO orderDO,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		Page<ChoiceOrderDTO> page = choiceOrderAO.queryPageList(orderDO, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("orderStatus", ChoiceOrderStatusEnum.values());
		model.addAttribute("orderDO", orderDO);
		if (CollectionUtils.isEmpty(page.getList())) {
			model.addAttribute("noRecoders", "暂无数据");
		}
		return BackendConstant.BACKEND_VIEW_PATH + "choiceOrder/list";
	}

	@RequestMapping("edit")
	public String choiceOrderDetail(Model model, Long orderId) {
		model.addAttribute("choiceOrderDO", choiceOrderAO.selectById(orderId));
		return BackendConstant.BACKEND_VIEW_PATH + "choiceOrder/edit";
	}

	@RequestMapping("handleOrder")
	@ResponseBody
	public ResultMessage handleOrder(Long orderId, String result) {
		return choiceOrderAO.handleOrder(orderId, result);
	}

}
