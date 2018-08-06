package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ichecc.ao.WechatAO;
import com.ichecc.common.ResultData;
import com.ichecc.domain.VipDepositOrderDO;
import com.ichecc.wechat.constant.WechatPayConstants;
import com.ichecc.wechat.dto.ApiUnifiedOrderDTO;
import com.ichecc.wechat.dto.JsApiWXPayDTO;
import com.ichecc.wechat.dto.UnifiedOrderInputDTO;
import com.ichecc.wechat.payment.WechatPayService;

import ng.bayue.common.CommonResultMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-context-checcshare.xml","classpath*:spring/spring-pay.xml" })
public class TestWechatPay {

	@Autowired
	private WechatPayService payService;
//	@Autowired
//	private WechatAO wechatAo;

	/**
	 * 测试支付下单
	 * @throws Exception
	 */
	@Test
	public void unifiedOrder() throws Exception {
//		ApiUnifiedOrderDTO query = new ApiUnifiedOrderDTO();
//		query.setBody("测试支付下单");
//		query.setTotal_fee(100);
//		query.setOut_trade_no("180718001");
//		query.setTrade_type(WechatPayConstants.TradeType.JSAPI.name());
//		query.setSpbill_create_ip("127.0.0.1");
//		query.setAttach("");
////		query.setOpenid("oEUxH0sS0BGO3bNb_rIRv-5xs5Ts");
//		query.setOpenid("o8qMy0zIbp3UxBGDa__Aqc5ks92o");
//		
//		VipDepositOrderDO orderQuery = new VipDepositOrderDO();
//		orderQuery.setUserId(2L);
//		orderQuery.setAmount(0.01);
		
		UnifiedOrderInputDTO inputDto = new UnifiedOrderInputDTO();
		inputDto.setBody("测试支付下单");
		inputDto.setUserId(2L);
		inputDto.setDepositAmount(0.01);
		inputDto.setIp("127.0.0.1");
		CommonResultMessage crm = payService.unifiedOrder(inputDto);
		System.out.println(crm);
//		ResultData rd = wechatAo.getPayOrder(inputDto);
//		System.out.println(rd);
		System.out.println(123);
		
		
//		String sign = SignUtil.createSign(query);
//		query.setSign(sign);
//		String xmlData = XmlUtil.packageParamsToXmlStr(query);
//		System.out.println(xmlData);
		
//		SortedMap<String, Object> parameters = RequestUtil.sortBeanField(query);
//		System.out.println(parameters);
	}
	
	/**
	 * 测试支付结果通知
	 */
	@Test
	public void callbackTest(){
		String paramsXmlStr = "<xml>"
				+ "<appid><![CDATA[wxeec85623859fc30e]]></appid>"
				+ "<attach><![CDATA[1]]></attach>"
				+ "<bank_type><![CDATA[CFT]]></bank_type>"
				+ "<cash_fee><![CDATA[1]]></cash_fee>"
				+ "<fee_type><![CDATA[CNY]]></fee_type>"
				+ "<is_subscribe><![CDATA[Y]]></is_subscribe>"
				+ "<mch_id><![CDATA[1490875382]]></mch_id>"
				+ "<nonce_str><![CDATA[c97e73dbdeb14d80921c75159720f0f5]]></nonce_str>"
				+ "<openid><![CDATA[o8qMy0zIbp3UxBGDa__Aqc5ks92o]]></openid>"
				+ "<out_trade_no><![CDATA[881044589630001283]]></out_trade_no>"
				+ "<result_code><![CDATA[SUCCESS]]></result_code>"
				+ "<return_code><![CDATA[SUCCESS]]></return_code>"
//				+ "<return_msg><![CDATA[OK]]></return_msg>"
				+ "<sign><![CDATA[77A6E89D74A98CB07B217893C97422C3]]></sign>"
				+ "<time_end><![CDATA[20171231205531]]></time_end>"
				+ "<total_fee>1</total_fee>"
				+ "<trade_type><![CDATA[NATIVE]]></trade_type>"
				+ "<transaction_id><![CDATA[4200000038201712315439426986]]></transaction_id>"
				+ "</xml>";
		try {
			CommonResultMessage crm = payService.callback(paramsXmlStr);
			System.out.println(crm.getMessage());
			System.out.println(123);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testConfigLoader(){
		JsApiWXPayDTO pay = new JsApiWXPayDTO();
		System.out.println(pay.getAppid());
	}

}
