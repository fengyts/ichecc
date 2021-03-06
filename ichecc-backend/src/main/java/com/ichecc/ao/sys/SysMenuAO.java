package com.ichecc.ao.sys;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.SysMenuDO;
import com.ichecc.enums.SysMenuTypeEnum;
import com.ichecc.service.SysMenuService;
import com.ichecc.util.Messages;
import com.ichecc.util.ResultMessage;
import com.ichecc.util.UserHandler;

import ng.bayue.common.Page;

@Service
public class SysMenuAO {
	
	@Autowired
	private SysMenuService sysMenuService;
	
	public Page<SysMenuDO> pageQueryList(SysMenuDO sysMenuDO,Integer pageNo,Integer pageSize){
		Page<SysMenuDO> page = sysMenuService.queryPageListDynamicAndStartPageSize(sysMenuDO, pageNo, pageSize);
		
		return page;
	}
	
	public List<SysMenuDO> selectDynamic(SysMenuDO sysMenuDO){
		List<SysMenuDO> list = sysMenuService.selectDynamic(sysMenuDO);
		return list;
	}
	
	public List<SysMenuDO> listAllMenus(){
		return selectDynamic(new SysMenuDO());
	}
	
	
	public SysMenuDO selectById(Long id){
		if(null == id){return null;}
		return sysMenuService.selectById(id);
	}
	
	/**
	 * <pre>
	 * 获取所有父级菜单(包括导航菜单和主菜单)
	 * </pre>
	 *
	 * @return
	 */
	public List<SysMenuDO> listBeforeTwoMenu(){
		SysMenuDO sysMenuDO = new SysMenuDO();
		sysMenuDO.setMenuType(SysMenuTypeEnum.NAVIGATION.getCode());
		List<SysMenuDO> plist = selectDynamic(sysMenuDO);
		List<SysMenuDO> list = sysMenuService.findListByParentIds(plist);
		plist.addAll(list);
		return plist;
	}
	
	public ResultMessage addSysMenu(SysMenuDO sysMenuDO){
		if(null == sysMenuDO){ return new ResultMessage(ResultMessage.Failure,Messages.ParameterError);}
		if(StringUtils.isEmpty(sysMenuDO.getName())){
			return new ResultMessage(ResultMessage.Failure,Messages.parameterErrMsgs("name"));
		}
		Date date = new Date();
		sysMenuDO.setCreateTime(date);
		sysMenuDO.setModifyTime(date);
		Long userId = UserHandler.getUser().getId();
		sysMenuDO.setCreateUserId(userId);
		sysMenuDO.setModifyUserId(userId);
		sysMenuDO = sysMenuService.save(sysMenuDO);
		return new ResultMessage(ResultMessage.Message,sysMenuDO);
	}
	
	public ResultMessage updateSysMenu(SysMenuDO sysMenuDO){
		if(null == sysMenuDO){ return new ResultMessage(ResultMessage.Failure,Messages.ParameterError);}
		sysMenuDO.setModifyTime(new Date());
		sysMenuDO.setModifyUserId(UserHandler.getUser().getId());
		int res = sysMenuService.update(sysMenuDO, false);
		if(1 == res){
			return new ResultMessage();
		}else{
			return new ResultMessage(ResultMessage.Failure,Messages.HandleFailure);
		}
	}

}
