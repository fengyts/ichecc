package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ichecc.wechat.ApiUnifiedOrderDTO;
import com.ichecc.wechat.UnifiedOrderResponseDTO;
import com.ichecc.wechat.payment.WechatPayService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-pay.xml" })
public class TestWechatPay {
	
	@Autowired
	private WechatPayService payService;

	@Test
	public void test() throws Exception {
		ApiUnifiedOrderDTO query = new ApiUnifiedOrderDTO();
		query.setBody("测试支付下单");
		query.setTotal_fee(100);
		query.setOut_trade_no("180718001");
		query.setTrade_type(ApiUnifiedOrderDTO.TradeType.JSAPI.name());
		query.setSpbill_create_ip("127.0.0.1");
		query.setAttach("");
		query.setOpenid("oEUxH0sS0BGO3bNb_rIRv-5xs5Ts");
		UnifiedOrderResponseDTO order = payService.unifiedOrder(query);
		System.out.println(order);
		System.out.println(123);
		
		
//		String sign = SignUtil.createSign(query);
//		query.setSign(sign);
//		String xmlData = XmlUtil.packageParamsToXmlStr(query);
//		System.out.println(xmlData);
		
//		SortedMap<String, Object> parameters = RequestUtil.sortBeanField(query);
//		System.out.println(parameters);
	}
	
	

}
