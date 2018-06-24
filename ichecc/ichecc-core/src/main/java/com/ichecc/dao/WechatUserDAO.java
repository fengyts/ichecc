package com.ichecc.dao;

import com.ichecc.domain.WechatUserDO;

import ng.bayue.service.common.GeneralDAO;

 /**
 * 微信用户授权 DAO
 *
 * @author fengyts 2018-05-09 09:29:15
 */
public interface WechatUserDAO extends GeneralDAO<WechatUserDO> {
	
	/**
	 * <pre>
	 * 根据openid获取微信用户信息
	 * </pre>
	 *
	 * @param openid
	 * @return
	 */
	WechatUserDO selectByOpenid(String openid);

}
