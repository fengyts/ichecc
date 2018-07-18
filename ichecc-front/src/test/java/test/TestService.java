package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ichecc.domain.VipDepositOrderDO;
import com.ichecc.service.VipDepositOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-context-checcshare.xml" })
public class TestService {
	
	@Autowired
	private VipDepositOrderService orderService;
	
	@Test
	public void test(){
		VipDepositOrderDO order = orderService.selectLatestUnPaidOrder(2L);
		System.out.println(123);
	}

}
