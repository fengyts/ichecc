package com.ichecc.controller.backend;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.backend.ConstantsAO;
import com.ichecc.backend.constants.BackendConstant;
import com.ichecc.domain.IcheccConstantsDO;
import com.ichecc.util.ResultMessage;

import ng.bayue.common.Page;

@Controller
@RequestMapping("/constants")
public class ConstantsController {

	@Autowired
	private ConstantsAO constantsAO;

	@RequestMapping("list")
	public String list(Model model, IcheccConstantsDO constantsDO,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		Page<IcheccConstantsDO> page = constantsAO.queryPage(constantsDO, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("constantsDO", constantsDO);
		if (CollectionUtils.isEmpty(page.getList())) {
			model.addAttribute("noRecoders", "暂无数据");
		}
		return BackendConstant.BACKEND_VIEW_PATH + "constants/list";
	}

	@RequestMapping("edit")
	public String edit(Model model, String constKey) {
		IcheccConstantsDO constantsDO = constantsAO.selectByKey(constKey);
		model.addAttribute("constantsDO", constantsDO);
		return BackendConstant.BACKEND_VIEW_PATH + "constants/edit";
	}

	@RequestMapping("update")
	@ResponseBody
	public ResultMessage update(IcheccConstantsDO constantsDO) {
		return constantsAO.update(constantsDO);
	}

}
