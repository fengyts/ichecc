package com.ichecc.controller.backend;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.backend.DepositConfigAO;
import com.ichecc.backend.constants.BackendConstant;
import com.ichecc.domain.VipDepositConfigDO;
import com.ichecc.util.ResultMessage;

import ng.bayue.common.Page;

@Controller
@RequestMapping("/depositConfig")
public class DepositConfigController {

	@Autowired
	private DepositConfigAO configAO;

	@RequestMapping("list")
	public String list(Model model, VipDepositConfigDO configDO,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		Page<VipDepositConfigDO> page = configAO.queryPage(configDO, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("configDO", configDO);
		if (CollectionUtils.isEmpty(page.getList())) {
			model.addAttribute("noRecoders", "暂无数据");
		}
		return BackendConstant.BACKEND_VIEW_PATH + "depositConfig/list";
	}

	@RequestMapping("add")
	public String add() {
		return BackendConstant.BACKEND_VIEW_PATH + "depositConfig/add";
	}

	@RequestMapping("save")
	@ResponseBody
	public ResultMessage save(VipDepositConfigDO configDO) {
		ResultMessage rm = configAO.save(configDO);
		return rm;
	}

	@RequestMapping("edit")
	public String edit(Model model, Long id) {
		VipDepositConfigDO configDO = configAO.selectById(id);
		model.addAttribute("configDO", configDO);
		return BackendConstant.BACKEND_VIEW_PATH + "depositConfig/edit";
	}

	@RequestMapping("update")
	@ResponseBody
	public ResultMessage update(VipDepositConfigDO configDO) {
		ResultMessage rm = configAO.update(configDO);
		return rm;
	}

}
