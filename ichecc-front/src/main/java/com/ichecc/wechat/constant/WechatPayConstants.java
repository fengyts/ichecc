package com.ichecc.wechat.constant;

public final class WechatPayConstants {
	
	public static final String BODY = "爱车西西充值";
	
	public static final class SignType {
		// MD5, SHA1;
		/** 默认签名算法 */
		public static final String MD5_DEFAULT = "MD5";
		public static final String SHA1 = "SHA1";
	}
	
	/**
	 * 支付类型
	 * 
	 * @author lenovopc
	 *
	 */
	public static enum TradeType {
		/** 公众号支付 */
		JSAPI("JSAPI"),
		/** 扫码支付 */
		NATIVE("NATIVE"),
		/** APP支付 */
		APP("APP"),
		/** 刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口 */
		MICROPAY("MICROPAY");

		public String type;

		private TradeType(String type) {
			this.type = type;
		}
	}

}
