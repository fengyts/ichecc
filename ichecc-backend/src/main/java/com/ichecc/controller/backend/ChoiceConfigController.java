package com.ichecc.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ichecc.ao.backend.ChoiceConfigAO;
import com.ichecc.backend.constants.BackendConstant;
import com.ichecc.domain.ChoiceConfigDO;
import com.ichecc.util.ResultMessage;

@Controller
@RequestMapping("/choiceConfig")
public class ChoiceConfigController {

	@Autowired
	private ChoiceConfigAO choiceConfigAO;

	@RequestMapping("list")
	public String list() {
		return BackendConstant.BACKEND_VIEW_PATH + "choiceConfig/list";
	}

	@RequestMapping("jsonData")
	@ResponseBody
	public JSONObject getJsonData() {
		JSONObject obj = choiceConfigAO.getJsonData();
		return obj;
	}
	
	@RequestMapping("add")
	public String add(Model model){
		model.addAttribute("listFirsts", choiceConfigAO.listFirstCate());
		return BackendConstant.BACKEND_VIEW_PATH + "choiceConfig/add";
	}
	
	@RequestMapping("save")
	@ResponseBody
	public ResultMessage save(ChoiceConfigDO configDO){
		ResultMessage msg = choiceConfigAO.save(configDO);
		return msg;
	}
	
	@RequestMapping("edit")
	public String edit(Model model, Long id){
		model.addAttribute("listFirsts", choiceConfigAO.listFirstCate());
		model.addAttribute("choiceConfigDO", choiceConfigAO.selectById(id));
		return BackendConstant.BACKEND_VIEW_PATH + "choiceConfig/edit";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultMessage update(ChoiceConfigDO configDO){
		ResultMessage msg = choiceConfigAO.update(configDO);
		return msg;
	}

}
