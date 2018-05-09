package com.ichecc.controller.backend;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.backend.TopicAO;
import com.ichecc.backend.constants.BackendConstant;
import com.ichecc.common.BaseController;
import com.ichecc.domain.TopicDO;
import com.ichecc.enums.TopicStatusEnum;
import com.ichecc.util.ResultMessage;

import ng.bayue.common.Page;

@Controller
@RequestMapping({ "/topic" })
public class TopicController extends BaseController {

	@Autowired
	private TopicAO topicAO;

	@RequestMapping({ "/list" })
	public String list(Model model, TopicDO topicDO, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		Page<TopicDO> page = topicAO.queryPageList(topicDO, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("topicStatus", TopicStatusEnum.values());

		if (CollectionUtils.isEmpty(page.getList())) {
			model.addAttribute("noRecoders", "暂无数据");
		}
		return BackendConstant.BACKEND_VIEW_PATH + "topic/list";
	}

	@RequestMapping({ "/add" })
	public String add(Model model) {
		model.addAttribute("topicStatus", TopicStatusEnum.values());
		return BackendConstant.BACKEND_VIEW_PATH + "topic/add";
	}

	@RequestMapping({ "/save" })
	@ResponseBody
	public ResultMessage save(TopicDO topicDO) {
		return topicAO.save(topicDO);
	}

	@RequestMapping({ "/edit" })
	public String edit(Model model, Long id) {
		model.addAttribute("topicDO", topicAO.selectById(id));
		model.addAttribute("topicStatus", TopicStatusEnum.values());

		return BackendConstant.BACKEND_VIEW_PATH + "topic/edit";
	}

	@RequestMapping({ "/update" })
	@ResponseBody
	public ResultMessage update(TopicDO topicDO) {
		return topicAO.update(topicDO);
	}

}
