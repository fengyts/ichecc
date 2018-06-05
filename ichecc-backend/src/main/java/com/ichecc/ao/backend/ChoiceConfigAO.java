package com.ichecc.ao.backend;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ichecc.domain.ChoiceConfigDO;
import com.ichecc.service.ChoiceConfigService;
import com.ichecc.util.ResultMessage;
import com.ichecc.util.UserHandler;

import ng.bayue.util.StringUtils;

@Service
public class ChoiceConfigAO {

	@Autowired
	private ChoiceConfigService choiceConfigService;

	public JSONObject getJsonData() {
		List<ChoiceConfigDO> list = choiceConfigService.selectDynamic(new ChoiceConfigDO());
		JSONArray rows = new JSONArray();
		for (ChoiceConfigDO config : list) {
			if (1 != config.getLevel()) {
				continue;
			}
			long id = config.getId();
			JSONObject row = insertRowJson(config);
			JSONArray seconds = new JSONArray();
			for (ChoiceConfigDO second : list) {
				if (2 != second.getLevel()) {
					continue;
				}
				long parentId = second.getParentId();
				if (parentId == id) {
					JSONObject rowSecond = insertRowJson(second);
					rowSecond.put("isLeaf", true);
					seconds.add(rowSecond);
				}
			}
			row.put("isLeaf", seconds.isEmpty());
			rows.add(row);
			rows.addAll(seconds);
		}

		JSONObject obj = new JSONObject();
		obj.put("rows", rows);
		obj.put("records", rows.size());
		obj.put("page", 1);
		obj.put("total", 1);
		return obj;
	}

	private JSONObject insertRowJson(ChoiceConfigDO configDO) {
		// 注意：parentId的值必须要加上双引号才行(即必须是字符串形式),否则expanded
		// 会无效,比如格式必须这样："parentId":"1",而不能这样："parentId":1
		String str = "{\"parentId\":\"" + configDO.getParentId() + "\"}";
		JSONObject o = JSONObject.parseObject(str);
		o.put("id", configDO.getId());
		o.put("name", configDO.getName());
		o.put("level", configDO.getLevel());
		o.put("status", configDO.getStatus());
		// o.put("parentId", configDO.getParentId());
		o.put("remark", configDO.getRemark());
		o.put("expanded", true);
		return o;
	}

	public List<ChoiceConfigDO> listFirstCate() {
		ChoiceConfigDO configDO = new ChoiceConfigDO();
		configDO.setLevel(1);
		List<ChoiceConfigDO> list = choiceConfigService.selectDynamic(configDO);
		return list;
	}

	public ResultMessage save(ChoiceConfigDO configDO) {
		if (StringUtils.isBlank(configDO.getName())) {
			return ResultMessage.failure("名称不能为空");
		}
		List<ChoiceConfigDO> list = choiceConfigService.selectDynamic(configDO);
		if (CollectionUtils.isNotEmpty(list)) {
			return ResultMessage.failure("名称已经存在");
		}
		Date now = new Date();
		Long userId = UserHandler.getUserId();
		configDO.setCreateTime(now);
		configDO.setCreateUserId(userId);
		configDO.setModifyTime(now);
		configDO.setModifyUserId(userId);
		choiceConfigService.insert(configDO);
		return ResultMessage.success();
	}

	public ChoiceConfigDO selectById(Long id) {
		if (null == id || id < 0) {
			return null;
		}
		return choiceConfigService.selectById(id);
	}

	public ResultMessage update(ChoiceConfigDO configDO) {
		if (StringUtils.isBlank(configDO.getName())) {
			return ResultMessage.failure("名称不能为空");
		}
		List<ChoiceConfigDO> list = choiceConfigService.selectDynamic(configDO);
		if (CollectionUtils.isNotEmpty(list) && list.get(0).getId() != configDO.getId()) {
			return ResultMessage.failure("名称已经存在");
		}
		Long userId = UserHandler.getUserId();
		configDO.setModifyTime(new Date());
		configDO.setModifyUserId(userId);
		choiceConfigService.update(configDO, false);
		return ResultMessage.success();
	}

}
