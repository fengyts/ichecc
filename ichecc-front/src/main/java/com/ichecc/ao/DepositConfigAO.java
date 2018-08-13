package com.ichecc.ao;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.domain.VipDepositConfigDO;
import com.ichecc.service.VipDepositConfigService;
import com.ichecc.vo.VipDepositConfigVO;

@Service
public class DepositConfigAO {
	
	@Autowired
	private VipDepositConfigService configService;
	
	public List<VipDepositConfigVO> listAllConfig(){
		List<VipDepositConfigVO> datas = new ArrayList<VipDepositConfigVO>();
		List<VipDepositConfigDO> list = configService.listAllConfig();
		if(CollectionUtils.isEmpty(list)){
			return datas;
		}
		VipDepositConfigVO vo = null;
		Double amount = null;
		for(VipDepositConfigDO configDO : list){
			vo = new VipDepositConfigVO();
			vo.setId(configDO.getId());
			amount = configDO.getOriginalAmount();
			amount = amount.doubleValue() * configDO.getDiscount(); // 实际充值金额
			vo.setAmount(amount);
			vo.setExpiryDate(configDO.getExpiryDate());
			vo.setExpiryType(configDO.getExpiryType());
			vo.setAttractDesc(configDO.getAttractDesc());
			
			datas.add(vo);
		}
		
		return datas;
	}

}
