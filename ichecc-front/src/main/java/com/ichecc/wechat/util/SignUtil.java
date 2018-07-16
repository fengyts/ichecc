package com.ichecc.wechat.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.ichecc.wechat.ApiUnifiedOrderDTO;
import com.ichecc.wechat.component.GlobalConfig;

import ng.bayue.constants.CharsetConstant;

public class SignUtil {

	/**
	 * 签名对象属性排序
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static SortedMap<String, Object> signBeanFieldSort(Object obj) throws Exception {
		try {
			SortedMap<String, Object> map = new TreeMap<String, Object>();
			Class<?> c = ApiUnifiedOrderDTO.class;

			Field[] fields = null;
			while (null != c) {
				fields = c.getDeclaredFields();
				for (Field f : fields) {
					f.setAccessible(true);
					// 过滤static 和 final字段
					int mod = f.getModifiers();
					if (Modifier.isFinal(mod) || Modifier.isStatic(mod)) {
						continue;
					}
					String name = f.getName();
					// if ("serialVersionUID".equals(name)) {
					// continue;
					// }
					Object value = f.get(c.newInstance());
					if (null == value) {
						continue;
					}
					map.put(name, value);
				}
				c = c.getSuperclass();
			}
			return map;
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException | InstantiationException e) {
			throw e;
		}
	}

	public static String createSign(Object paramBean) throws Exception {
		try {
			String sign = createSign(paramBean, GlobalConfig.secrectKey, CharsetConstant.UTF8);
			return sign;
		} catch (Exception e) {
			throw e;
		}
	}

	public static String createSign(SortedMap<String, String> parameters) throws Exception {
		try {
			String sign = createSign(parameters, GlobalConfig.secrectKey, CharsetConstant.UTF8);
			return sign;
		} catch (Exception e) {
			throw e;
		}
	}

	public static String createSign(Object paramBean, String secrectKey, String charset) throws Exception {
		try {
			SortedMap<String, Object> parameters = signBeanFieldSort(paramBean);
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
				String v = (String) entry.getValue();
				if (null != v && !"".equals(v) && !"sign".equalsIgnoreCase(k) && !"key".equals(k)) {
					sb.append(k + "=" + v + "&");
				}
			}
			sb.append("key=" + secrectKey);
			String sign = MD5Util.MD5Encode(sb.toString(), charset).toUpperCase();
			return sign;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @author
	 * @date 2016-4-22
	 * @Description：将请求参数转换为xml格式的string
	 * @param parameters
	 *            请求参数
	 * @return
	 */
	public static String packageParamsToXmlStr(SortedMap<String, String> parameters) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set<Entry<String, String>> es = parameters.entrySet();
		Iterator<Entry<String, String>> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			String k = entry.getKey();
			String v = entry.getValue();
			if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
				sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
			} else {
				// sb.append("<" + k + ">" + v + "</" + k + ">");
				sb.append(String.format("<%s>%s</%s>", k, v, k));
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * 
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	public static String packageParamsToXmlStr(Object paramBean) throws Exception {
		try {
			SortedMap<String, Object> parameters = signBeanFieldSort(paramBean);
			String xmlStr = packageParamsToXmlStr(parameters);
			return xmlStr;
		} catch (Exception e) {
			throw e;
		}
	}

	public static boolean checkSign(Object resBean) {

		return true;
	}

	/**
	 * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 * 
	 * @return boolean
	 */
	public static boolean checkSign(SortedMap<String, String> packageParams, String secrectKey, String charset) {
		StringBuffer sb = new StringBuffer();
		Set<Entry<String, String>> es = packageParams.entrySet();
		Iterator<Entry<String, String>> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			String k = entry.getKey();
			String v = entry.getValue();
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
