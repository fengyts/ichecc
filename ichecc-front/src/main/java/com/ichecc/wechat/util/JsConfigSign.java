package com.ichecc.wechat.util;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ichecc.wechat.dto.WechatJsConfigDTO;

import ng.bayue.util.SecurityUtil;

public class JsConfigSign {

	private static final Logger logger = LoggerFactory.getLogger(JsConfigSign.class);

	public static WechatJsConfigDTO sign(String jsapi_ticket, String url) throws Exception {
		try {
			// Map<String, String> ret = new HashMap<String, String>();
			final String nonce_str = UUID.randomUUID().toString().replace("-", "");
			final String timestamp = Long.toString(System.currentTimeMillis() / 1000);

			// 注意这里参数名必须全部小写，且必须有序
			final String string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp
					+ "&url=" + url;

//			String signature = SecurityUtil.encryptMD5(string1);
			String signature = SecurityUtil.encryptSHA1(string1);

			WechatJsConfigDTO config = new WechatJsConfigDTO();
			config.setNonceStr(nonce_str);
			config.setTimestamp(timestamp);
			config.setSignature(signature);
			return config;
		} catch (Exception e) {
			logger.info("微信获取jsapi 签名异常：{}", e);
			throw e;
		}
	}


}
