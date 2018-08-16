package com.ichecc.ao.backend;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.IcheccConstantsDO;
import com.ichecc.service.IcheccConstantsService;
import com.ichecc.util.ResultMessage;
import com.ichecc.util.UserHandler;

import ng.bayue.common.Page;

@Service
public class ConstantsAO {

	@Autowired
	IcheccConstantsService constantsService;

	public Page<IcheccConstantsDO> queryPage(IcheccConstantsDO constantDO, Integer pageNo, Integer pageSize) {
		Page<IcheccConstantsDO> page = constantsService.queryPageListDynamicAndStartPageSize(constantDO, pageNo,
				pageSize);
		return page;
	}

	public IcheccConstantsDO selectByKey(String key) {
		IcheccConstantsDO constantsDO = constantsService.selectByPrimaryKey(key);
		return constantsDO;
	}

	public ResultMessage update(IcheccConstantsDO constantsDO) {
		constantsDO.setModifyTime(new Date());
		constantsDO.setModifyUserId(UserHandler.getUserId());
		constantsService.updateByPrimaryKey(constantsDO);
		return ResultMessage.success();
	}

}
