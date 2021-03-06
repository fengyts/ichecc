package com.ichecc.backend.constants;



 /**
  * 
  * <pre>
  * 
  * </pre>
  *
  * @author fengyts
  * @version $Id: BackendConstant.java, v 0.1 2016年8月10日 下午8:08:24 fengyts Exp $
  */
public interface BackendConstant {
	
	/** 视图根路径 */
	public static final String BACKEND_VIEW_PATH = "/backend/";
	
	public interface SessionKey{
		String USER = "user";
		String LOGIN = "loginSecurityCode";
		String REGISTER = "registerSecurityCode";
		String OTHER = "other.unSelect";
	}
	
	public interface Boolean {
		boolean True = true;
		boolean False = false;
	}
	
	public interface IsSuccess {
		Integer Success = 0;
		Integer Fail = 1;
	}
	
	public interface SysUser{
		/** 验证码错误 */
		final String KAPTCHAERROR = "kaptchaError";
		
		/** 验证码为空 */
		final String KAPTCHAEMPTY = "kaptchaEmpty";
		
		/** 踢出用户标识 */
		final String KICKOUT = "kickout";
		
	}
	
}
