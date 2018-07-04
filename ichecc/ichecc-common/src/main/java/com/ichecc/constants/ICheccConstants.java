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
	
	interface ICheccRedisKeys {
		String BASE_KEY = "ichecc_";
		String WECHAT_AUTH_ACCESS_TOKEN = BASE_KEY + "access_token_";
	}
	
	/** VIP会员权益  */
	String VIP_BENEFIT = "vip_benefit";
	/** VIP会员注意事项  */
	String VIP_NOTICE = "vip_notice";
	
	/** 砍价规则说明 */
	String BARGAIN_RULES = "bargain_rules";
	

}
