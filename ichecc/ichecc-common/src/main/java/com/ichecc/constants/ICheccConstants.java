package com.ichecc.constants;

/**
 * <pre>
 * 常量表key值
 * </pre>
 *
 * @author lenovopc
 * @version $Id: ICheccConstants.java, v 0.1 2018年5月8日 上午9:35:39 lenovopc Exp $
 */
public interface ICheccConstants {
	
	/**
	 * redis缓存key
	 * @author lenovopc
	 *
	 */
	interface ICheccRedisKeys {
		String BASE_KEY = "ichecc_";
		/** 微信授权access_token 缓存key */
		String WECHAT_ACCESS_TOKEN_AUTH = BASE_KEY + "access_token_auth_";
		/** 微信jssdk接口access_token缓存key */
		String WECHAT_ACCESS_TOKEN_JSSDK = BASE_KEY + "access_token_jssdk";
		/** 微信JS接口的临时票据ticket缓存key */
		String WECHAT_JSAPI_TICKET = BASE_KEY + "js_api_ticket";
	}
	
	/** VIP会员权益  */
	String VIP_BENEFIT = "vip_benefit";
	/** VIP会员注意事项  */
	String VIP_NOTICE = "vip_notice";
	
	/** 砍价规则说明 */
	String BARGAIN_RULES = "bargain_rules";
	

}
