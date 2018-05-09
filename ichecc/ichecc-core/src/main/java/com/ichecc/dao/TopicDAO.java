package com.ichecc.dao;

import com.ichecc.domain.TopicDO;
import ng.bayue.service.common.GeneralDAO;

 /**
 * 专题 DAO
 *
 * @author fengyts 2018-05-09 09:29:15
 */
public interface TopicDAO extends GeneralDAO<TopicDO> {
	
	TopicDO selectLatested();

}
