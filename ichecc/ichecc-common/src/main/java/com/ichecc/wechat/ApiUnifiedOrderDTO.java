package com.ichecc.wechat;

/**
 * 微信支付统一下单接口参数
 * 
 * @author lenovopc
 *
 */
public class ApiUnifiedOrderDTO extends ApiCommonDTO {

	private static final long serialVersionUID = -2737337776319054570L;

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

	/** 【选填】 自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB" */
	private String device_info = "WEB";
	/** 【必填】商品简单描述，该字段请按照规范传递，具体请见参数规定 */
	private String body;
	/** 【选填】 商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明” */
	private String detail;
	/** 【选填】 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。 */
	private String attach;
	/** 【必填】商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。详见商户订单号 */
	private String out_trade_no;
	/** 【选填】符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型 */
	private String fee_type = "CNY";
	/** 【必填】订单总金额，单位为分，详见支付金额 */
	private Integer total_fee;
	/** 【必填】APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。 */
	private String spbill_create_ip;
	/**
	 * 【选填】订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
	 * 其他详见时间规则
	 */
	private String time_start;
	/**
	 * 【选填】订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	 * 订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，
	 * 所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id。 其他详见时间规则 建议：最短失效时间间隔大于1分钟
	 */
	private String time_expire;
	/** 【选填】 订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠 */
	private String goods_tag;
	/** 【必填】 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。 */
	private String notify_url;
	/**
	 * 【必填】 JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，统一下单接口trade_type的传参可参考这里
	 * MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口 说明详见参数规定
	 */
	private String trade_type;
	/**
	 * 【选填】 trade_type=NATIVE时（即扫码支付），此参数必传。 此参数为二维码中包含的商品ID，商户自行定义。
	 */
	private String product_id;
	/** 【选填】 上传此参数no_credit--可限制用户不能使用信用卡支付 */
	private String limit_pay;
	/**
	 * 【选填】 trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。
	 * openid如何获取，可参考【获取openid】。
	 * 企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
	 */
	private String openid;
	/**
	 * 【选填】 该字段用于上报场景信息，目前支持上报实际门店信息。 该字段为JSON对象数据，对象格式为 {"store_info":{"id":
	 * "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，
	 * 字段详细说明请点击行前的+展开
	 */
	private String scene_info;

	public boolean validate() {
		// 基础参数校验
		if (!super.validate()) {
			return false;
		}
		// 必传参数校验
		if (isBlank(body) || isBlank(out_trade_no) || null == total_fee || total_fee < 1 || isBlank(spbill_create_ip)
				|| isBlank(notify_url) || isBlank(trade_type)) {
			return false;
		}
		// 特殊场景必填参数校验
		// trade_type=NATIVE时（即扫码支付），product_id必传
		if (trade_type.equalsIgnoreCase(TradeType.NATIVE.type)) {
			if (isBlank(product_id)) {
				return false;
			}
		}
		// trade_type=JSAPI时（即公众号支付），openid必传
		if (trade_type.equalsIgnoreCase(TradeType.JSAPI.type)) {
			if (isBlank(openid)) {
				return false;
			}
		}

		return true;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScene_info() {
		return scene_info;
	}

	public void setScene_info(String scene_info) {
		this.scene_info = scene_info;
	}

}
