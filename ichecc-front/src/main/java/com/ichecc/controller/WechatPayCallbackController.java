package com.ichecc.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichecc.wechat.dto.ReturnWechatCallbackData;
import com.ichecc.wechat.payment.WechatPayService;

import ng.bayue.common.CommonResultMessage;

@Controller
@RequestMapping("/pay/wechat/")
public class WechatPayCallbackController extends BaseController {

	@Autowired
	private WechatPayService wechatPayService;

	@RequestMapping("payCallback")
	public void wechatPayCallback(HttpServletRequest request, HttpServletResponse response) {
		logger.info("wechat pay callback controller start...");
		String returnCallbackXmlStr = ""; // 返回微信支付结果通知的报文
		String callbackXmlStr = ""; // 支付结果通知参数串
		InputStream is = null;
		BufferedReader br = null;
		try {
			is = request.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			StringBuilder temp = new StringBuilder();
			while (null != (line = br.readLine())) {
				temp.append(line);
			}
			callbackXmlStr = temp.toString();
			logger.info("wechat pay callback notify params: {}", callbackXmlStr);

			CommonResultMessage crm = wechatPayService.callback(callbackXmlStr);
			if (CommonResultMessage.Success == crm.getResult()) {
				logger.info("微信支付回调通知成功");
				returnCallbackXmlStr = ReturnWechatCallbackData.successData();
				packageReturnData(response, returnCallbackXmlStr);
				return;
			} else {
				logger.info("微信支付回调通知失败-info: {}", crm.getMessage());
				returnCallbackXmlStr = ReturnWechatCallbackData.failureData(crm.getMessage());
				packageReturnData(response, returnCallbackXmlStr);
				return;
			}
		} catch (Exception e) {
			logger.info("微信支付回调通知获取参数流异常：{}", e);
			returnCallbackXmlStr = ReturnWechatCallbackData.failureData("支付结果通知报文异常");
			packageReturnData(response, returnCallbackXmlStr);
			return;
		} finally {
			try {
				if (null != is)
					is.close();
				if (null != br)
					br.close();
			} catch (IOException e) {
				logger.info("微信支付回调通知异常, 关闭流异常", e);
			}
		}
//		logger.error("微信支付回调通知获取参数流异常：未知错误(wechat pay callback failure: unknown error)");
//		returnCallbackXmlStr = ReturnWechatCallbackData.failureData(null);
//		packageReturnData(response, returnCallbackXmlStr);
	}

	private void packageReturnData(HttpServletResponse response, String resultXml) {
		BufferedOutputStream out;
		try {
			out = new BufferedOutputStream(response.getOutputStream());
			out.write(resultXml.getBytes());
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.error("", e);
		}
	}

}
