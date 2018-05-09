package com.ichecc.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import ng.bayue.common.Page;

public abstract class BaseController {

	public static final String BASE_VIEW_PATH = "/backend/";
	
	@InitBinder
	public void bindData(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"), true));
	}
	
	public <T> void noRecords(Model model,Page<T> page){
		if (CollectionUtils.isEmpty(page.getList())) {
			model.addAttribute("noRecords", "暂无数据");
		}
	}

}
