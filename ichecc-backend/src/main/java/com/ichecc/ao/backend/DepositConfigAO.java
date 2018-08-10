package com.ichecc.ao.backend;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.VipDepositConfigDO;
import com.ichecc.service.VipDepositConfigService;
import com.ichecc.util.ResultMessage;
import com.ichecc.util.UserHandler;

import ng.bayue.common.Page;
import ng.bayue.util.StringUtils;

@Service
public class DepositConfigAO {

	@Autowired
	private VipDepositConfigService depositConfigService;

	public Page<VipDepositConfigDO> queryPage(VipDepositConfigDO configDO, Integer pageNo, Integer pageSize) {
		Page<VipDepositConfigDO> page = depositConfigService.queryPageListDynamicAndStartPageSize(configDO, pageNo,
				pageSize);
		return page;
	}

	public VipDepositConfigDO selectById(Long id) {
		if (null == id) {
			return null;
		}
		VipDepositConfigDO configDO = depositConfigService.selectById(id);
		return configDO;
	}

	public ResultMessage save(VipDepositConfigDO configDO) {
		if (null == configDO) {
			return ResultMessage.failure("参数不能为空");
		}
		Double originalAmount = configDO.getOriginalAmount();
		Double discount = configDO.getDiscount();
		Integer expiryDate = configDO.getExpiryDate();
		String expiryType = configDO.getExpiryType();
		if (null == originalAmount || originalAmount.doubleValue() <= 0d) {
			return ResultMessage.failure("充值金额不能为空");
		}
		if (null == discount || discount.doubleValue() > 1d || discount.doubleValue() <= 0d) {
			return ResultMessage.failure("充值折扣值必须大于0且小于等于1");
		}
		if (null == expiryDate || expiryDate <= 0) {
			return ResultMessage.failure("有效期必须大于0");
		}
		if (StringUtils.isBlank(expiryType)) {
			return ResultMessage.failure("期限类型不能为空");
		}

		synchronized (this) {
			VipDepositConfigDO check = new VipDepositConfigDO();
			check.setOriginalAmount(originalAmount);;
			check.setStatus(true);
			List<VipDepositConfigDO> list = depositConfigService.selectDynamic(check);
			if (CollectionUtils.isNotEmpty(list)) {
				return ResultMessage.failure("该金额配置已经存在");
			}

			Long userId = UserHandler.getUserId();
			Date now = new Date();
			configDO.setCreateTime(now);
			configDO.setModifyTime(now);
			configDO.setCreateUserId(userId);
			configDO.setModifyUserId(userId);

			depositConfigService.insert(configDO);
		}

		return ResultMessage.success();
	}

	public ResultMessage update(VipDepositConfigDO configDO) {
		if (null == configDO) {
			return ResultMessage.failure("参数为空");
		}
		Long id = configDO.getId();
		if (null == id) {
			return ResultMessage.failure("该配置不存在");
		}

		Double originalAmount = configDO.getOriginalAmount();
		Double discount = configDO.getDiscount();
		Integer expiryDate = configDO.getExpiryDate();
		String expiryType = configDO.getExpiryType();
		if (null == originalAmount || originalAmount.doubleValue() <= 0d) {
			return ResultMessage.failure("充值不能金额为空");
		}
		if (null == discount || discount.doubleValue() > 1d || discount.doubleValue() <= 0d) {
			return ResultMessage.failure("充值折扣值必须大于0且小于等于1");
		}
		if (null == expiryDate || expiryDate <= 0) {
			return ResultMessage.failure("有效期必须大于0");
		}
		if (StringUtils.isBlank(expiryType)) {
			return ResultMessage.failure("期限类型不能为空");
		}

		synchronized (this) {
			VipDepositConfigDO check = new VipDepositConfigDO();
			check.setOriginalAmount(originalAmount);
			check.setStatus(true);
			List<VipDepositConfigDO> list = depositConfigService.selectDynamic(check);
			if (CollectionUtils.isNotEmpty(list)) {
				if (id.longValue() != list.get(0).getId().longValue()) {
					return ResultMessage.failure("该金额配置已经存在");
				}
			}

			configDO.setModifyTime(new Date());
			configDO.setModifyUserId(UserHandler.getUserId());

			depositConfigService.update(configDO, false);
		}

		return ResultMessage.success();
	}

}
