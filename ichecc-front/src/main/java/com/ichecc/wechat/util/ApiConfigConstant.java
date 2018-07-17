package com.ichecc.wechat.util;

public class ApiConfigConstant {

	// 微信统一下单接口地址
	public final static String UFDODER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	/** 支付仿真测试地址 */
	public final static String UFDODER_URL_TEST = "https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder";
	// 微信支付订单查询接口地址
	public final static String ORDER_QUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	// 企业向个人账号付款的URL
	public final static String SEND_EED_PACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
	
	
	public final static String CREATE_IP = "192.168.0.107";// 发起支付ip（改为自己实际的）

	// 微信下单接口body参数值(商品描述 或者 网站title值)
	public final static String BODY = "车西西-充值";
	
}
