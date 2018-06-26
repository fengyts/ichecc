package com.ichecc.ao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichecc.common.ResultData;
import com.ichecc.domain.ChoiceConfigDO;
import com.ichecc.service.ChoiceConfigService;

@Service
public class ChoiceAO {
	
	@Autowired
	private ChoiceConfigService choiceConfigService;
	
	public ResultData selectAllConfig(){
		ChoiceConfigDO configDO = new ChoiceConfigDO();
		configDO.setStatus(true);
		List<ChoiceConfigDO> list = choiceConfigService.selectDynamic(configDO);
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = null;
		List<Map<String, Object>> options = null;
		for(ChoiceConfigDO cfg : list){
			int level = cfg.getLevel();
			if(2 == level){continue;}
			long id = cfg.getId();
			options = new ArrayList<Map<String, Object>>();
			for(ChoiceConfigDO cfg1 : list){
				if(1 == cfg1.getLevel()){continue;}
				long parentId = cfg1.getParentId();
				map = new HashMap<String, Object>();
				if(id == parentId){
					map.put("id", cfg1.getId());
					map.put("name", cfg1.getName());
					options.add(map);
				}
			}
			result.put(getAssociateKey(cfg.getName()), options);
		}
		return ResultData.success(result);
	}
	
	private String getAssociateKey(String name){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("品牌类型", "brand");
		map.put("能源类型", "energy");
		map.put("车辆类型", "type");
		map.put("座位数量", "seat");
		map.put("车型结构", "structure");
		map.put("变速箱类型", "gearbox");
		return (String) map.get(name);
	}
	
}
