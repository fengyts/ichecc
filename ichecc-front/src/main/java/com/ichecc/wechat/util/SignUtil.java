package com.ichecc.wechat.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

import com.ichecc.wechat.component.InitConfigBean;

import ng.bayue.constants.CharsetConstant;

public class SignUtil {
	
	private static final InitConfigBean config = new InitConfigBean();

	public static String createSign(Object paramBean) throws Exception {
		try {
			String sign = createSign(paramBean, config.getApiKey(), CharsetConstant.UTF8);
			return sign;
		} catch (Exception e) {
			throw e;
		}
	}

	public static String createSign(SortedMap<String, String> parameters) throws Exception {
		try {
			String sign = createSign(parameters, config.getApiKey(), CharsetConstant.UTF8);
			return sign;
		} catch (Exception e) {
			throw e;
		}
	}

	public static String createSign(Object paramBean, String secrectKey, String charset) throws Exception {
		try {
			SortedMap<String, Object> parameters = RequestUtil.sortBeanField(paramBean);
			String sign = createSign(parameters, secrectKey, charset);
			return sign;
		} catch (Exception e) {
			throw e;
		}
	}

	public static String createSign(SortedMap<String, Object> parameters, String secrectKey, String charset)
			throws Exception {
		try {
			StringBuffer sb = new StringBuffer();
			Set<Entry<String, Object>> es = parameters.entrySet();
			Iterator<Entry<String, Object>> it = es.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
				String k = entry.getKey();
				String v = String.valueOf(entry.getValue());
				if (null != v && !"".equals(v) && !"sign".equalsIgnoreCase(k) && !"key".equals(k)) {
					sb.append(k + "=" + v + "&");
				}
			}
			sb.append("key=" + secrectKey);
			String sign = MD5Util.MD5Encode(sb.toString(), charset).toUpperCase();
			System.out.println(sb.toString());
			System.out.println(sign);
			return sign;
		} catch (Exception e) {
			throw e;
		}
	}


	public static boolean checkSign(Object resBean) throws Exception {
		try {
			SortedMap<String, Object> parameters = RequestUtil.sortBeanField(resBean);
			return checkSign(parameters, config.getApiKey(), CharsetConstant.UTF8);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 * 
	 * @return boolean
	 */
	public static boolean checkSign(SortedMap<String, Object> packageParams, String secrectKey, String charset) {
		StringBuffer sb = new StringBuffer();
		Set<Entry<String, Object>> es = packageParams.entrySet();
		Iterator<Entry<String, Object>> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
			String k = entry.getKey();
			String v = String.valueOf(entry.getValue());
			if (!"sign".equals(k) && null != v && !"".equals(v)) {
				sb.append(k + "=" + v + "&");
			}
		}

		sb.append("key=" + secrectKey);

		// 算出摘要
		String mysign = MD5Util.MD5Encode(sb.toString(), charset).toUpperCase();
		String tenpaySign = ((String) packageParams.get("sign"));

		return tenpaySign.equalsIgnoreCase(mysign);
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
	public static String uuidString(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

}
