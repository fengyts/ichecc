package com.ichecc.ao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.common.ResultCode;
import com.ichecc.common.ResultData;
import com.ichecc.common.thread.ChoiceOrderNoBuilder;
import com.ichecc.domain.ChoiceConfigDO;
import com.ichecc.domain.ChoiceOrderDO;
import com.ichecc.enums.ChoiceOrderStatusEnum;
import com.ichecc.front.dto.ChoiceSubmitDTO;
import com.ichecc.service.ChoiceConfigService;
import com.ichecc.service.ChoiceOrderService;
import com.ichecc.service.DepositRecordService;
import com.ichecc.vo.VipInfoVO;

@Service
public class ChoiceAO extends BaseAO {

	@Autowired
	private ChoiceConfigService choiceConfigService;
	@Autowired
	private DepositRecordService depositRecordService;
	@Autowired
	private ChoiceOrderService choiceOrderService;

	public ResultData selectAllConfig() {
		ChoiceConfigDO configDO = new ChoiceConfigDO();
		configDO.setStatus(true);
		List<ChoiceConfigDO> list = choiceConfigService.selectDynamic(configDO);

		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = null;
		List<Map<String, Object>> options = null;
		for (ChoiceConfigDO cfg : list) {
			int level = cfg.getLevel();
			if (2 == level) {
				continue;
			}
			long id = cfg.getId();
			options = new ArrayList<Map<String, Object>>();
			for (ChoiceConfigDO cfg1 : list) {
				if (1 == cfg1.getLevel()) {
					continue;
				}
				long parentId = cfg1.getParentId();
				map = new HashMap<String, Object>();
				if (id == parentId) {
					map.put("id", cfg1.getId());
					map.put("name", cfg1.getName());
					options.add(map);
				}
			}
			result.put(getAssociateKey(cfg.getName()), options);
		}
		return ResultData.success(result);
	}

	private String getAssociateKey(String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("品牌类型", "brand");
		map.put("能源类型", "energy");
		map.put("车辆类型", "type");
		map.put("座位数量", "seat");
		map.put("车型结构", "structure");
		map.put("变速箱类型", "gearbox");
		return (String) map.get(name);
	}

	public ResultData choiceOrderSubmit(ChoiceSubmitDTO dto) {
		Long userId = dto.getUserId();
		if (userId == null || userId.longValue() < 0) {
			return ResultData.failureMsg(ResultCode.Common.AUTHORIZE_FAILURE);
		}
		// 校验vip
		VipInfoVO vipVO = depositRecordService.getVipInfo(userId);
		if (!vipVO.getIsVip()) {
			return ResultData.failureMsg(ResultCode.Biz.IS_NOT_VIP);
		}

		ChoiceOrderDO coDO = new ChoiceOrderDO();
		try {
			BeanUtils.copyProperties(coDO, dto);
			coDO.setCreateTime(new Date());
			coDO.setStatus(ChoiceOrderStatusEnum.ON_DISPOSE.code);

			// 生成订单编号
			String orderNo = new ChoiceOrderNoBuilder().generateOrderNo();
			coDO.setOrderNo(orderNo);

			choiceOrderService.insert(coDO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("保存选车订单异常:{}", e);
			return ResultData.failureMsg(ResultCode.Common.ERROR);
		}
		return ResultData.success();
	}

}
