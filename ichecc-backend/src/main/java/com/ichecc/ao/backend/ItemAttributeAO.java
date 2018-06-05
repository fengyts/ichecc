package com.ichecc.ao.backend;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.ItemAttributeDO;
import com.ichecc.service.ItemAttributeService;
import com.ichecc.util.ResultMessage;
import com.ichecc.util.UserHandler;

import ng.bayue.common.Page;
import ng.bayue.util.StringUtils;

@Service
public class ItemAttributeAO {

	@Autowired
	private ItemAttributeService itemAttributeService;

	public Page<ItemAttributeDO> queryPageList(ItemAttributeDO attributeDO, Integer pageNo, Integer pageSize) {
		Page<ItemAttributeDO> page = itemAttributeService.queryPageListDynamicAndStartPageSize(attributeDO, pageNo,
				pageSize);
		return page;
	}

	public ItemAttributeDO selectById(Long id) {
		if (null == id || id < 0) {
			return null;
		}
		return itemAttributeService.selectById(id);
	}

	public ResultMessage save(ItemAttributeDO attributeDO) {
		if (StringUtils.isBlank(attributeDO.getName()) || StringUtils.isBlank(attributeDO.getValue())) {
			return ResultMessage.failure("名称 或值不能为空");
		}
		ItemAttributeDO attr = new ItemAttributeDO();
		attr.setName(attributeDO.getName());
		List<ItemAttributeDO> list = itemAttributeService.selectDynamic(attr);
		if (CollectionUtils.isNotEmpty(list)) {
			return ResultMessage.failure("属性名称已经存在");
		}

		Long userId = UserHandler.getUserId();
		Date now = new Date();
		attributeDO.setCreateTime(now);
		attributeDO.setCreateUserId(userId);
		attributeDO.setModifyTime(now);
		attributeDO.setModifyUserId(userId);

		itemAttributeService.insert(attributeDO);

		return ResultMessage.success();
	}

	public ResultMessage update(ItemAttributeDO attributeDO) {
		if (StringUtils.isBlank(attributeDO.getName()) || StringUtils.isBlank(attributeDO.getValue())) {
			return ResultMessage.failure("名称 或值不能为空");
		}
		ItemAttributeDO attr = new ItemAttributeDO();
		attr.setName(attributeDO.getName());
		List<ItemAttributeDO> list = itemAttributeService.selectDynamic(attr);
		if (CollectionUtils.isNotEmpty(list) && list.get(0).getId() != attributeDO.getId()) {
			return ResultMessage.failure("属性名称已经存在");
		}

		attributeDO.setModifyTime(new Date());
		attributeDO.setModifyUserId(UserHandler.getUserId());

		itemAttributeService.update(attributeDO, false);

		return ResultMessage.success();
	}

}
