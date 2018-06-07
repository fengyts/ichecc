package com.ichecc.controller.backend;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.backend.ItemAttributeAO;
import com.ichecc.backend.constants.BackendConstant;
import com.ichecc.domain.ItemAttributeDO;
import com.ichecc.util.ResultMessage;

import ng.bayue.common.Page;

@Controller
@RequestMapping("/itemAttribute")
public class ItemAttributeController {

	@Autowired
	private ItemAttributeAO attributeAO;

	@RequestMapping("list")
	public String list(Model model, ItemAttributeDO attributeDO,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		Page<ItemAttributeDO> page = attributeAO.queryPageList(attributeDO, pageNo, pageSize);
		model.addAttribute("page", page);
		if (CollectionUtils.isEmpty(page.getList())) {
			model.addAttribute("noRecoders", "暂无数据");
		}
		return BackendConstant.BACKEND_VIEW_PATH + "itemAttribute/list";
	}

	@RequestMapping("add")
	public String add() {
		return BackendConstant.BACKEND_VIEW_PATH + "itemAttribute/add";
	}

	@RequestMapping("save")
	@ResponseBody
	public ResultMessage save(ItemAttributeDO attributeDO) {
		ResultMessage msg = attributeAO.save(attributeDO);
		return msg;
	}

	@RequestMapping("edit")
	public String add(Model model, Long id) {
		model.addAttribute("attributeDO", attributeAO.selectById(id));
		return BackendConstant.BACKEND_VIEW_PATH + "itemAttribute/edit";
	}

	@RequestMapping("update")
	@ResponseBody
	public ResultMessage update(ItemAttributeDO attributeDO) {
		ResultMessage msg = attributeAO.update(attributeDO);
		return msg;
	}

}
