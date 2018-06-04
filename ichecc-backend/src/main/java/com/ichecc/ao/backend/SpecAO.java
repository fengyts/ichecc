package com.ichecc.ao.backend;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.SpecDO;
import com.ichecc.service.SpecService;
import com.ichecc.util.ResultMessage;
import com.ichecc.util.UserHandler;

import ng.bayue.common.Page;

@Service
public class SpecAO {

	@Autowired
	private SpecService specService;

	public Page<SpecDO> queryPageList(SpecDO specDO, Integer pageNo, Integer pageSize) {
		Page<SpecDO> page = specService.queryPageListDynamicAndStartPageSize(specDO, pageNo, pageSize);
		return page;
	}

	public ResultMessage save(SpecDO specDO) {
		if (StringUtils.isBlank(specDO.getSpecValue())) {
			return ResultMessage.failure("规格不能为空");
		}
		if (isExists(specDO.getSpecValue())) {
			return ResultMessage.failure("规格已经存在");
		}
		Integer sort = specDO.getSort() == null || specDO.getSort() < 0 ? 0 : specDO.getSort();
		specDO.setSort(sort);
		Long userId = UserHandler.getUserId();
		Date now = new Date();
		specDO.setCreateUserId(userId);
		specDO.setCreateTime(now);
		specDO.setModifyTime(now);
		specDO.setModifyUserId(userId);

		specService.insert(specDO);

		return ResultMessage.success();

	}

	public SpecDO selectById(Long id) {
		if (null == id || id < 0) {
			return null;
		}
		return specService.selectById(id);
	}

	public ResultMessage update(SpecDO specDO) {
		if (StringUtils.isBlank(specDO.getSpecValue())) {
			return ResultMessage.failure("规格不能为空");
		}

		SpecDO specDOV = new SpecDO();
		specDOV.setSpecValue(specDO.getSpecValue());
		List<SpecDO> list = specService.selectDynamic(specDOV);
		if (CollectionUtils.isNotEmpty(list)) {
			if (specDO.getId().longValue() != list.get(0).getId().longValue()) {
				if (specDO.getSpecValue().equals(list.get(0).getSpecValue())) {
					return ResultMessage.failure("规格已经存在");
				}
			}
		}
		specDO.setModifyTime(new Date());
		specDO.setModifyUserId(UserHandler.getUserId());
		specService.update(specDO, false);
		return ResultMessage.success();
	}

	private boolean isExists(String specValue) {
		SpecDO specDO = new SpecDO();
		specDO.setSpecValue(specValue);
		List<SpecDO> list = specService.selectDynamic(specDO);
		return CollectionUtils.isNotEmpty(list);
	}

}
