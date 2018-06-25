package com.ichecc.dao;

import com.ichecc.domain.IcheccUserDO;
import com.ichecc.dto.ICheccUserDTO;

import ng.bayue.service.common.GeneralDAO;

/**
 * 用户 DAO
 *
 * @author fengyts 2018-05-09 09:29:19
 */
public interface IcheccUserDAO extends GeneralDAO<IcheccUserDO> {

	ICheccUserDTO selectByOpenid(String openid);

}
