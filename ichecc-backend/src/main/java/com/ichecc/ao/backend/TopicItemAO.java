package com.ichecc.ao.backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ichecc.domain.ItemDO;
import com.ichecc.domain.TopicDO;
import com.ichecc.domain.TopicItemDO;
import com.ichecc.dto.TopicItemDTO;
import com.ichecc.enums.TopicStatusEnum;
import com.ichecc.service.ItemService;
import com.ichecc.service.TopicItemService;
import com.ichecc.service.TopicService;
import com.ichecc.util.ResultMessage;
import com.ichecc.util.UserHandler;

import ng.bayue.common.Page;

@Service
public class TopicItemAO {

	@Autowired
	private TopicItemService topicItemService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ItemService itemService;

	private void topicStatus(TopicDO topicDO) {
		Date startTime = topicDO.getStartTime();
		Date endTime = topicDO.getEndTime();
		Date now = new Date();
		String status = TopicStatusEnum.InProgress.getCode();
		if (startTime.after(now)) {
			status = TopicStatusEnum.NotStarted.getCode();
		} else if (endTime.before(now)) {
			status = TopicStatusEnum.End.getCode();
		}
		topicDO.setStatus(status);
	}

	public Page<TopicItemDTO> queryPageList(Model model, TopicItemDO topicItemDO, Integer pageNo, Integer pageSize) {
		Page<TopicItemDTO> pageResult = new Page<TopicItemDTO>();
		Page<TopicItemDO> page = topicItemService.queryPageListDynamicAndStartPageSize(topicItemDO, pageNo, pageSize);
		List<TopicItemDO> list = page.getList();

		Long topicId = topicItemDO.getTopicId();
		TopicDO topicDO = topicService.selectById(topicId);

		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		pageResult.setTotalCount(page.getTotalCount());
		if (CollectionUtils.isEmpty(list)) {
			return pageResult;
		}

		topicStatus(topicDO);
		List<TopicItemDTO> listResult = new ArrayList<TopicItemDTO>();
		for (TopicItemDO item : list) {
			TopicItemDTO ti = new TopicItemDTO();
			ti.setId(item.getId());
			ti.setTopicId(topicId);
			ti.setStatus(topicDO.getStatus());
			ti.setStartTime(topicDO.getStartTime());
			ti.setEndTime(topicDO.getEndTime());

			ti.setItemId(item.getItemId());
			ti.setItemStatus(item.getStatus());
			ti.setItemTitle(item.getItemTitle());

			listResult.add(ti);
		}

		pageResult.setList(listResult);

		return pageResult;
	}

	public Page<ItemDO> queryPageItemList(ItemDO itemDO, Integer pageNo, Integer pageSize) {
		Page<ItemDO> page = itemService.queryPageListDynamicAndStartPageSize(itemDO, pageNo, pageSize);
		return page;
	}

	public ResultMessage save(TopicItemDO topicItemDO) {
		Long topicId = topicItemDO.getTopicId();
		if (null == topicId) {
			return ResultMessage.failure("服务器异常：获取专题id失败");
		}
		String itemTitle = topicItemDO.getItemTitle();
		Long itemId = topicItemDO.getItemId();
		if (StringUtils.isBlank(itemTitle) || null == itemId) {
			return ResultMessage.failure("请选择商品");
		}

		if (checkTopicItemExist(topicId, itemId)) {
			return ResultMessage.failure("该专题已经存在此商品");
		}

		Date date = new Date();
		Long userId = UserHandler.getUser().getId();

		topicItemDO.setCreateTime(date);
		topicItemDO.setCreateUserId(userId);
		topicItemDO.setModifyTime(date);
		topicItemDO.setModifyUserId(userId);

		Long tid = topicItemService.insert(topicItemDO);

		if (null == tid || tid.longValue() <= 0) {
			return ResultMessage.failure("关联专题商品失败");
		}

		return ResultMessage.success();
	}

	private synchronized Boolean checkTopicItemExist(Long topicId, Long itemId) {
		if (null == topicId || null == itemId) {
			return true;
		}
		TopicItemDO t = new TopicItemDO();
		t.setTopicId(topicId);
		t.setItemId(itemId);
		List<TopicItemDO> list = topicItemService.selectDynamic(t);

		return CollectionUtils.isNotEmpty(list);
	}

	public TopicItemDO selectById(Long id) {
		return topicItemService.selectById(id);
	}

	public ResultMessage update(TopicItemDO topicItemDO) {
		Long topicId = topicItemDO.getTopicId();
		if (null == topicId) {
			return ResultMessage.failure("服务器异常：获取专题id失败");
		}
		String itemTitle = topicItemDO.getItemTitle();
		Long itemId = topicItemDO.getItemId();
		if (StringUtils.isBlank(itemTitle) || null == itemId) {
			return ResultMessage.failure("请选择商品");
		}
		TopicDO topicDO = topicService.selectById(topicId);

		TopicItemDO t = new TopicItemDO();
		t.setTopicId(topicId);
		t.setItemId(itemId);
		List<TopicItemDO> list = topicItemService.selectDynamic(t);
		if (CollectionUtils.isNotEmpty(list)) {
			if (list.size() > 1) {
				return ResultMessage.failure("该专题已经存在此商品");
			}
			if (list.get(0).getId().longValue() != topicItemDO.getId().longValue()) {
				return ResultMessage.failure("该专题已经存在此商品");
			}
		}

		Date date = new Date();
		Long userId = UserHandler.getUser().getId();

		topicItemDO.setModifyTime(date);
		topicItemDO.setModifyUserId(userId);

		topicItemService.update(topicItemDO, false);

		return ResultMessage.success();
	}

}
