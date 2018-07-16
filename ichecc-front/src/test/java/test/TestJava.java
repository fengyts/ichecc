package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ichecc.dao.IcheccUserDAO;
import com.ichecc.dao.TopicItemDAO;
import com.ichecc.dto.ICheccUserDTO;
import com.ichecc.vo.HiggleJoinVO;
import com.ichecc.wechat.component.ApiCommonConfig;
import com.ichecc.wechat.component.GlobalConfig;
import com.ichecc.wechat.component.InitConfigBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-pay.xml" })
public class TestJava {
	
//	@Autowired
//	private GlobalConfig config1 = new GlobalConfig();
	private InitConfigBean config = new InitConfigBean();

	@Test
	public void test() throws Exception {
//		String appid = GlobalConfig.appid;
		String appid = config.getAppid();
		System.out.println(appid);
	}
	

}
