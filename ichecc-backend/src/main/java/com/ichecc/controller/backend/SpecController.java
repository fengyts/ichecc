package com.ichecc.controller.backend;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.backend.SpecAO;
import com.ichecc.backend.constants.BackendConstant;
import com.ichecc.domain.SpecDO;
import com.ichecc.util.ResultMessage;

import ng.bayue.common.Page;

@Controller
@RequestMapping("/spec/")
public class SpecController {

	@Autowired
	private SpecAO specAO;

	@RequestMapping("list")
	public String list(Model model, SpecDO specDO, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		Page<SpecDO> page = specAO.queryPageList(specDO, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("specDO", specDO);
		if (CollectionUtils.isEmpty(page.getList())) {
			model.addAttribute("noRecoders", "暂无数据");
		}
		return BackendConstant.BACKEND_VIEW_PATH + "spec/list";
	}

	@RequestMapping("add")
	public String add() {
		return BackendConstant.BACKEND_VIEW_PATH + "spec/add";
	}

	@RequestMapping("save")
	@ResponseBody
	public ResultMessage save(SpecDO specDO) {
		ResultMessage msg = specAO.save(specDO);
		return msg;
	}

	@RequestMapping("edit")
	public String edit(Model model, Long id) {
		model.addAttribute("specDO", specAO.selectById(id));
		return BackendConstant.BACKEND_VIEW_PATH + "spec/edit";
	}

	@RequestMapping("update")
	@ResponseBody
	public ResultMessage update(SpecDO specDO) {
		ResultMessage msg = specAO.update(specDO);
		return msg;
	}

}
