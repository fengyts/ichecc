package com.ichecc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ichecc.dao.IcheccUserDAO;
import com.ichecc.dao.TopicItemDAO;
import com.ichecc.vo.HiggleJoinVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-context-checcshare.xml" })
public class TestDao {

	@Autowired
	private IcheccUserDAO userDao;
	@Autowired
	private TopicItemDAO tiDao;

	@Test
	public void test() throws Exception {
//		String openid = "oEUxH0sS0BGO3bNb_rIRv-5xs5Ts";
//		ICheccUserDTO dto = userDao.selectByOpenid(openid);
//		
//		System.out.println(dto.getIsCertification());
//		DepositRecordDO d = drDao.selectLatestDepositRecord(1L);
//		System.out.println(d);
		HiggleJoinVO higgle = tiDao.participationHiggle(1L, 1L);
		System.out.println(higgle);
		
	}
	

}
