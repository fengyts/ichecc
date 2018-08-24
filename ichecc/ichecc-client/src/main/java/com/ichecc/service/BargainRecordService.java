package com.ichecc.service;

import ng.bayue.service.common.GeneralService;

import com.ichecc.domain.BargainRecordDO;

 /**
 * 砍价记录 Service
 * @author fengyts 2018-05-09 09:29:17
 */
public interface BargainRecordService extends GeneralService<BargainRecordDO, BargainRecordDO> {
	
	/**
	 * 获取某商品某用户已砍价次数
	 * @param userId
	 * @param tiId
	 * @param bargainType: 01-本人砍价；02-好友帮砍
	 * @return
	 */
	int countAreadyBargainTimes(Long userId, Long tiId, String bargainType);
	
}
