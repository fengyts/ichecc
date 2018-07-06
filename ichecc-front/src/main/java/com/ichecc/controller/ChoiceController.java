package com.ichecc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.annotation.Authority;
import com.ichecc.ao.ChoiceAO;
import com.ichecc.common.Constants;
import com.ichecc.common.ResultData;
import com.ichecc.front.dto.ChoiceSubmitDTO;

@Controller
@RequestMapping(Constants.API_BASE_PATH + "choice")
public class ChoiceController {

	@Autowired
	private ChoiceAO choiceAO;

	@RequestMapping("choiceConfig")
	@ResponseBody
	public ResultData getChoiceConfig() {
		return choiceAO.selectAllConfig();
	}

	@RequestMapping("choiceSubmit")
	@ResponseBody
	@Authority
	public ResultData choiceSubmit(ChoiceSubmitDTO dto) {
		return choiceAO.choiceOrderSubmit(dto);
	}
	
	/**
	 * 用户选车订单列表
	 * @param userId
	 * @return
	 */
	@RequestMapping("choiceOrderList")
	@ResponseBody
	@Authority
	public ResultData choiceOrderList(Long userId){
		return choiceAO.choiceOrderList(userId);
	}
	
	/**
	 * 选车订单详情
	 * @param orderId
	 * @return
	 */
	@RequestMapping("choiceOrderDetail")
	@ResponseBody
	@Authority
	public ResultData choiceOrderDetail(Long orderId){
		return choiceAO.choiceOrderDetail(orderId);
	}

}
