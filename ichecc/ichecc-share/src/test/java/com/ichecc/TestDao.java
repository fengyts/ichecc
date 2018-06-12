package com.ichecc;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ichecc.dao.ItemAttributeDAO;
import com.ichecc.dao.TopicItemDAO;
import com.ichecc.domain.ItemAttributeDO;
import com.ichecc.front.dto.FrontTopicItemDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-context-checcshare.xml" })
public class TestDao {

	@Autowired
	private TopicItemDAO tiDAO;

	@Test
	public void test() throws Exception {
		List<FrontTopicItemDTO> list = tiDAO.selectListFront(2L);
		System.out.println(list.size());
	}
	

}
