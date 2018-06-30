package com.ichecc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.ichecc.annotation.Authority;
import com.ichecc.common.ResultCode;
import com.ichecc.common.ResultData;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthorityInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			if (null != method.getMethodAnnotation(Authority.class)
					|| null != method.getMethod().getDeclaringClass()
							.getAnnotation(Authority.class)) { // 需要权限验证
				Object o = request.getParameter("userId");
				if(null == o){
					return error(response); // 授权异常
				}
				Long userId = Long.valueOf((String) o);
				if (null != userId && userId.longValue() > 0) {
					return true;
				}
				return error(response); // 授权异常
			}
		}
		return true;
	}

	// 校验错误
	private boolean error(HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(
					JSONObject.toJSONString(ResultData
							.failureMsg(ResultCode.Common.USERINFO_EMPTY)));
		} catch (Exception e) {
			logger.error("返回响应结果时IO异常", e);
		}
		return false;
	}

}
