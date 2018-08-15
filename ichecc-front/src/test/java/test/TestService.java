package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;
import com.ichecc.domain.VipDepositConfigDO;
import com.ichecc.domain.VipDepositOrderDO;
import com.ichecc.service.VipDepositConfigService;
import com.ichecc.service.VipDepositOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-context-checcshare.xml" })
public class TestService {
	
	@Autowired
	private VipDepositOrderService orderService;
	@Autowired
	private VipDepositConfigService configService;
	
	@Test
	public void test(){
//		VipDepositOrderDO order = orderService.selectLatestUnPaidOrder(2L);
//		System.out.println(123);
//		List<VipDepositConfigDO> list = configService.listAllConfig();
//		String str = JSONArray.toJSONString(list);
//		System.out.println(str);
		
		VipDepositOrderDO orderDO = new VipDepositOrderDO();
		orderDO.setId(3L);
		orderDO.setUserId(2L);
		orderDO.setConfigId(1L);
		orderDO.setOrderStatus("02");
		orderDO.setExpiryDate(1);
		orderDO.setExpiryType("01");
		orderDO.setRealAmount(0.01);
		orderDO.setOrderNo("882322197990003562");
		orderService.updateVipInfoByOrder(orderDO);
	}
	
	public static void main(String[] args) {
		System.out.println("草拟吗");
	}

}
