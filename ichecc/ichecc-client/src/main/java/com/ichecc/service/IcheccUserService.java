package com.ichecc.service;

import ng.bayue.service.common.GeneralService;
import com.ichecc.domain.IcheccUserDO;
import com.ichecc.dto.ICheccUserDTO;

/**
 * 用户 Service
 * 
 * @author fengyts 2018-05-09 09:29:19
 */
public interface IcheccUserService extends GeneralService<IcheccUserDO, IcheccUserDO> {

	ICheccUserDTO selectUserInfoByOpenid(String openid);

}
