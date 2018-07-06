package com.ichecc.ao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.common.ResultCode;
import com.ichecc.common.ResultData;
import com.ichecc.constants.ICheccConstants;
import com.ichecc.enums.VipUserCateEnum;
import com.ichecc.service.IcheccConstantsService;
import com.ichecc.service.VipUserInfoService;
import com.ichecc.vo.VipInfoDetailVO;
import com.ichecc.vo.VipInfoVO;

@Service
public class VipAO extends BaseAO {

	@Autowired
	private VipUserInfoService vipUserService;
	@Autowired
	private IcheccConstantsService constantsService;

	public ResultData getVipInfo(Long userId) {
		VipInfoVO vo = vipUserService.getVipInfo(userId);
		if (VipUserCateEnum.Never.code.equals(vo.getVipCate())) {
			return ResultData.failureMsg(ResultCode.Biz.IS_NOT_VIP);
		}
		return ResultData.success(vo);
	}

	public ResultData getVipInfoDetail(Long userId) {
		VipInfoVO vo = vipUserService.getVipInfo(userId);
		if (VipUserCateEnum.Never.code.equals(vo.getVipCate())) {
			return ResultData.failureMsg(ResultCode.Biz.IS_NOT_VIP);
		}
		VipInfoDetailVO detail = new VipInfoDetailVO();
		detail.setVipInfo(vo);
		detail.setVipBenefit(constantsService.getValueByKey(ICheccConstants.VIP_BENEFIT));
		detail.setVipNotice(constantsService.getValueByKey(ICheccConstants.VIP_NOTICE));
		
		return ResultData.success(detail);
	}

}
