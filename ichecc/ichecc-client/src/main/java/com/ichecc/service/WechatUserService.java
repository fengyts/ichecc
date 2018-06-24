package com.ichecc.service;

import ng.bayue.exception.CommonServiceException;
import ng.bayue.service.common.GeneralService;

import com.ichecc.domain.WechatUserDO;
import com.ichecc.dto.ICheccUserDTO;

/**
 * 微信用户授权 Service
 * 
 * @author fengyts 2018-05-09 09:29:15
 */
public interface WechatUserService extends GeneralService<WechatUserDO, WechatUserDO> {

	/**
	 * <pre>
	 * 根据openid获取微信用户信息
	 * </pre>
	 *
	 * @param openid
	 * @return
	 */
	WechatUserDO selectByOpenid(String openid);
	
	/**
	 * <pre>
	 * 保存微信用户信息
	 * </pre>
	 *
	 * @param wechatUserDO
	 * @return
	 */
	ICheccUserDTO saveWechatUser(WechatUserDO wechatUserDO) throws CommonServiceException;

}
