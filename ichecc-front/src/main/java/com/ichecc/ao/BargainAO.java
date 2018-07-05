package com.ichecc.ao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.common.ResultCode;
import com.ichecc.common.ResultData;
import com.ichecc.service.BargainRecordService;
import com.ichecc.service.TopicItemService;
import com.ichecc.vo.HiggleJoinVO;

import ng.bayue.fastdfs.ImageUrlUtil;

@Service
public class BargainAO {

	@Autowired
	private TopicItemService topicItemService;
	@Autowired
	private BargainRecordService bargainRecordService;
	@Autowired
	private ImageUrlUtil imageUrlUtil;

	public ResultData participationHiggle(Long userId, Long tiId) {
		if (null == userId || null == tiId) {
			return ResultData.failureMsg(ResultCode.Common.PARAMS_ERROR);
		}
		HiggleJoinVO vo = topicItemService.participationHiggle(userId, tiId);
		vo.setPicture(imageUrlUtil.getFileFullUrl(vo.getPicture()));

		long countDownTime = 0;
		Date now = new Date();
		if (null != vo) {
			if (vo.getEndTime().after(now)) {
				countDownTime = vo.getEndTime().getTime() - now.getTime();
			}
		}
		vo.setCountDownTime(countDownTime);
		return ResultData.success(vo);
	}

}
