package com.ichecc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.DepositConfigAO;
import com.ichecc.common.Constants;
import com.ichecc.common.ResultData;
import com.ichecc.vo.VipDepositConfigVO;

@Controller
@RequestMapping(Constants.API_BASE_PATH + "depositConfig")
public class DepositConfigController {

	@Autowired
	private DepositConfigAO configAO;

	@RequestMapping("listConfig")
	@ResponseBody
	public ResultData getConfigList() {
		List<VipDepositConfigVO> datas = configAO.listAllConfig();
		return ResultData.success(datas);
	}

}
