package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ichecc.domain.VipDepositConfigDO;
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
		List<VipDepositConfigDO> list = configService.listAllConfig();
		String str = JSONArray.toJSONString(list);
		System.out.println(str);
	}

}
