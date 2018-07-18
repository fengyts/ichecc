package com.ichecc.wechat.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.ichecc.wechat.dto.ApiUnifiedOrderDTO;

import ng.bayue.constants.CharsetConstant;
import ng.bayue.util.StringUtils;
import ng.bayue.util.net.SSLClient;

public class RequestUtil {

	/**
	 * 参数/返回 对象对象属性排序,用于签名
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static SortedMap<String, Object> sortBeanField(Object obj) throws Exception {
		try {
			SortedMap<String, Object> map = new TreeMap<String, Object>();
			Class<?> c = ApiUnifiedOrderDTO.class;

			Field[] fields = null;
			while (null != c) {
				fields = c.getDeclaredFields();
				for (Field f : fields) {
					f.setAccessible(true);
					// 过滤static 和 final字段 serialVersionUID
					int mod = f.getModifiers();
					if (Modifier.isFinal(mod) || Modifier.isStatic(mod)) {
						continue;
					}
					String name = f.getName();
					Object value = f.get(obj);
					if (null != value) {
						if (value instanceof String) {
							if (StringUtils.isBlank((String) value)) {
								continue;
							}
						}
						if (!map.containsKey(name)) {
							map.put(name, value);
						}
					}
				}
				c = c.getSuperclass();
			}
			return map;
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw e;
		}
	}

	public static String doRequest(String url) throws Exception {
		try {
			String res = doRequest(url, null);
			return res;
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			throw e;
		}
	}

	public static String doRequest(String url, String data) throws Exception {
		try {
			if (StringUtils.isBlank(url)) {
				throw new Exception("请求异常：url参数为空");
			}
			HttpClient client = SSLClient.registerSSL();
			HttpPost httpPost = new HttpPost(url);
			RequestConfig config = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(5000)
					.setConnectionRequestTimeout(5000).setExpectContinueEnabled(false).build();
			httpPost.setConfig(config);
			ContentType contentType = ContentType.create("text/plain", CharsetConstant.UTF8);
			StringEntity se = new StringEntity(data, contentType);
			httpPost.setEntity(se);
			HttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String res = EntityUtils.toString(entity, CharsetConstant.UTF8);
			if (StringUtils.isBlank(res)) {
				throw new Exception("请求异常：返回报文为空");
			}
			return res;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 发送xml报文请求，返回也是xml
	 * 
	 * @param url
	 * @param tc
	 * @return
	 * @throws Exception
	 */
	public static <T> T doRequestXml(String url, String paramXml, Class<T> tc) throws Exception {
		try {
			String res = doRequest(url, paramXml);
			T resObj = XmlUtil.parseXmlToBean(res, tc);
			return resObj;
		} catch (Exception e) {
			throw e;
		}
	}


	public String getIpAddr(HttpServletRequest request) {
		String ip = "127.0.0.1";
		if (null == request) {
			return ip;
		}
		ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if ("0:0:0:0:0:0:0:1".equals(ip)) {
			// ip = "127.0.0.1";
			return ip;
		}
		return ip;
	}

}
