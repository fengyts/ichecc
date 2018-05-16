package com.ichecc.ao.backend;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.ItemDO;
import com.ichecc.domain.ItemDescDO;
import com.ichecc.domain.ItemPictureDO;
import com.ichecc.dto.ItemDTO;
import com.ichecc.service.ItemDescService;
import com.ichecc.service.ItemPictureService;
import com.ichecc.service.ItemService;
import com.ichecc.util.ResultMessage;
import com.ichecc.util.UserHandler;

import ng.bayue.common.Page;
import ng.bayue.constants.CommonConstant;
import ng.bayue.fastdfs.ImageUrlUtil;

@Service
public class ItemAO {

	@Autowired
	private ImageUrlUtil imageUrlUtil;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemDescService descService;
	@Autowired
	private ItemPictureService pictureService;

	public Page<ItemDO> queryPageList(ItemDO itemDO, Integer pageNo, Integer pageSize) {
		Page<ItemDO> page = itemService.queryPageListDynamicAndStartPageSize(itemDO, pageNo, pageSize);
		return page;
	}
	
	public ResultMessage saveItem(ItemDTO itemDTO){
		itemDTO.setCreateUserId(UserHandler.getUser().getId());
		itemDTO.setModifyUserId(UserHandler.getUser().getId());
		itemDTO.setCreateTime(new Date());
		itemDTO.setModifyTime(new Date());
		itemService.saveItem(itemDTO);
		return new ResultMessage();
	}
	
	public ItemDTO selectByItemId(Long itemId){
		ItemDO itemDO = itemService.selectById(itemId);
		ItemDescDO descDOParam = new ItemDescDO();
		descDOParam.setItemId(itemId);
		ItemDescDO descDO = descService.selectDynamic(descDOParam).get(0);
		ItemPictureDO pictureParam = new ItemPictureDO();
		pictureParam.setItemId(itemId);
		pictureParam.setStatus(CommonConstant.STATUS.TRUE);
		List<ItemPictureDO> listPics = pictureService.selectDynamic(pictureParam);
		for(ItemPictureDO pic : listPics){
			pic.setPicture(imageUrlUtil.getFileFullUrl(pic.getPicture()));
		}
		
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(itemId);
		itemDTO.setItemTitle(itemDO.getItemTitle());
		itemDTO.setSubTitle(itemDO.getSubTitle());
		itemDTO.setStatus(itemDO.getStatus());
		itemDTO.setRemark(itemDO.getRemark());
		itemDTO.setDescription(descDO.getDescription());
		itemDTO.setListPictures(listPics);
		itemDTO.setMarketPrice(itemDO.getMarketPrice());
		itemDTO.setGuidePrice(itemDO.getGuidePrice());
		
		return itemDTO;
	}
	
	public ResultMessage updateItem(ItemDTO itemDTO){
		itemDTO.setModifyUserId(UserHandler.getUser().getId());
		itemDTO.setModifyTime(new Date());
		itemService.updateItem(itemDTO);
		return new ResultMessage();
	}

}
