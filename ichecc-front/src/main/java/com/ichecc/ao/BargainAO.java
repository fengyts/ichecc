package com.ichecc.ao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.common.ResultCode;
import com.ichecc.common.ResultData;
import com.ichecc.service.BargainRecordService;
import com.ichecc.vo.HiggleJoinVO;

@Service
public class BargainAO {
	
	@Autowired
	private BargainRecordService bargainRecordService;
	
	
	public ResultData participationHiggle(Long userId, Long tiId){
		if(null == userId || null == tiId){
			return ResultData.failureMsg(ResultCode.Common.PARAMS_ERROR);
		}
		HiggleJoinVO vo = new HiggleJoinVO();
		
		return ResultData.success(vo);
	}

}
