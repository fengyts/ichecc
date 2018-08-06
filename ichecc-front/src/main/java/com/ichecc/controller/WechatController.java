package com.ichecc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichecc.ao.WechatAO;
import com.ichecc.common.Constants;
import com.ichecc.common.ResultData;
import com.ichecc.wechat.constant.WechatPayConstants;
import com.ichecc.wechat.dto.UnifiedOrderInputDTO;
import com.ichecc.wechat.util.RequestUtil;

@Controller
@RequestMapping(Constants.API_BASE_PATH + "wechat")
public class WechatController extends BaseController {

	@Autowired
	private WechatAO wechatAO;

	@RequestMapping("authorize")
	@ResponseBody
	public ResultData authorize(String code) {
		try {
			return wechatAO.authorize(code);
		} catch (Exception e) {
			return ResultData.failure("服务器异常");
		}
	}

	@RequestMapping("jsApiConfig")
	@ResponseBody
	public ResultData getWechatJSConfig(String url) {
		return wechatAO.getWechatJSConfig(url);
	}

	@RequestMapping("payOrder")
	@ResponseBody
	public ResultData getWXPayOrder(HttpServletRequest request, UnifiedOrderInputDTO inputDto) {
		String ip = RequestUtil.getIpAddr(request);
		inputDto.setIp(ip);
		inputDto.setBody(WechatPayConstants.BODY);
		return wechatAO.getPayOrder(inputDto);
	}

}
