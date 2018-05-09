package com.ichecc.controller.backend;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.backend.TopicItemAO;
import com.ichecc.backend.constants.BackendConstant;
import com.ichecc.domain.ItemDO;
import com.ichecc.domain.TopicItemDO;
import com.ichecc.dto.TopicItemDTO;
import com.ichecc.enums.ItemStatusEnum;
import com.ichecc.enums.TopicStatusEnum;
import com.ichecc.util.ResultMessage;

import ng.bayue.common.Page;

@Controller
@RequestMapping({"/topicItem"})
public class TopicItemController {
	
	@Autowired
	private TopicItemAO topicItemAO;
	
	
	@RequestMapping({"/list"})
	public String list(Model model, TopicItemDO topicItemDO, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, String periodNo) {
		Page<TopicItemDTO> page = topicItemAO.queryPageList(model, topicItemDO, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("topicItemDO", topicItemDO);
		model.addAttribute("topicStatus", TopicStatusEnum.values());
		model.addAttribute("periodNo", periodNo);

		if (CollectionUtils.isEmpty(page.getList())) {
			model.addAttribute("noRecoders", "暂无数据");
		}
		return BackendConstant.BACKEND_VIEW_PATH + "topicItem/list";
	}
	
	@RequestMapping({"/itemList"})
	public String itemList(Model model, ItemDO itemDO, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
		itemDO.setStatus(ItemStatusEnum.ON_SALES.getCode());
		Page<ItemDO> page = topicItemAO.queryPageItemList(itemDO, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("itemDO", itemDO);
		return BackendConstant.BACKEND_VIEW_PATH + "topicItem/itemList";
	}
	
	
	@RequestMapping({"/add"})
	public String add(Model model, Long topicId){
		model.addAttribute("topicId", topicId);
		return BackendConstant.BACKEND_VIEW_PATH + "topicItem/add";
	}
	
	@RequestMapping({"/save"})
	@ResponseBody
	public ResultMessage save(TopicItemDO topicItemDO){
		
		return topicItemAO.save(topicItemDO);
	}
	
	@RequestMapping({"/edit"})
	public String edit(Model model, Long id){
		TopicItemDO topicItemDO = topicItemAO.selectById(id);
		model.addAttribute("topicItemDO", topicItemDO);
		
		return BackendConstant.BACKEND_VIEW_PATH + "topicItem/edit";
	}
	
	@RequestMapping({"/update"})
	@ResponseBody
	public ResultMessage update(TopicItemDO topicItemDO){
		
		return topicItemAO.update(topicItemDO);
	}

}
