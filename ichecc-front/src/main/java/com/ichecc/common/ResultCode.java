package com.ichecc.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResultCode implements Serializable {

	private static final long serialVersionUID = 5853595435891401534L;

	private static Map<String, Object> desc = new HashMap<String, Object>();
	
	static {
		desc.putAll(Common.desc);
	}
	
	public static String getDesc(String code){
		return (String) desc.get(code);
	}


	/**
	 * <pre>
	 * 通用错误代码
	 * </pre>
	 *
	 * @author fengyts
	 * @version $Id: ResultCode.java, v 0.1 2018年6月27日 下午9:32:40 fengyts Exp $
	 */
	public static class Common {
		/** 系统异常 */
		public static final String ERROR = "999999";
		/** 成功 */
		public static final String SUCCESS = "1";
		
		/** 参数错误 */
		public static final String PARAMS_ERROR = "999901";
		
		/** 授权失败 */
		public static final String AUTHORIZE_FAILURE = "100001";
		/** 用户信息为空 */
		public static final String USERINFO_EMPTY = "100002";
		
		
		public static Map<String, Object> desc = new HashMap<String, Object>();
		static {
			desc.put(SUCCESS, "success");
			desc.put(ERROR, "系统异常");
			desc.put(PARAMS_ERROR, "参数错误");
			desc.put(AUTHORIZE_FAILURE, "授权失败");
			desc.put(USERINFO_EMPTY, "用户信息为空");
		}
		
	}
	
	/**
	 * <pre>
	 * 业务错误码
	 * </pre>
	 *
	 * @author fengyts
	 * @version $Id: ResultCode.java, v 0.1 2018年6月27日 下午9:20:24 fengyts Exp $
	 */
	public static class Biz {
		/** 必须是vip */
		public static final String IS_NOT_VIP = "200001";
		public static final String WECHAT_PAY_CONFIG_ERROR = "200002";
		
		public static Map<String, Object> desc = new HashMap<String, Object>();
		static {
			desc.put(IS_NOT_VIP, "请开通vip");
			desc.put(WECHAT_PAY_CONFIG_ERROR, "微信jsapi接口配置信息错误");
		}
	}
	
	
	public static class Item {
		private String code;
		private String msg;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

	}

}
