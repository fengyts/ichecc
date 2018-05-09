package com.ichecc.service;

import ng.bayue.service.common.GeneralService;
import com.ichecc.domain.TopicDO;

 /**
 * 专题 Service
 * @author fengyts 2018-05-09 09:29:15
 */
public interface TopicService extends GeneralService<TopicDO, TopicDO> {
	
	/**
	 * <pre>
	 * 获取最新一期专题
	 * </pre>
	 *
	 * @return
	 */
	TopicDO selectLatested();
	
}
