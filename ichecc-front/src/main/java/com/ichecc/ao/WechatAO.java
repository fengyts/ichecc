package com.ichecc.ao;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ichecc.common.ResultCode;
import com.ichecc.common.ResultData;
import com.ichecc.constants.ICheccConstants;
import com.ichecc.domain.WechatUserDO;
import com.ichecc.dto.ICheccUserDTO;
import com.ichecc.service.IcheccUserService;
import com.ichecc.service.WechatUserService;
import com.ichecc.wechat.dto.AccessTokenDTO;
import com.ichecc.wechat.dto.AuthAccessTokenDTO;
import com.ichecc.wechat.dto.JSApiTicketDTO;
import com.ichecc.wechat.dto.UnifiedOrderInputDTO;
import com.ichecc.wechat.dto.WechatApiErrorDTO;
import com.ichecc.wechat.dto.WechatJsConfigDTO;
import com.ichecc.wechat.payment.WechatPayService;
import com.ichecc.wechat.util.JsConfigSign;

import ng.bayue.common.CommonResultMessage;
import ng.bayue.constants.CharsetConstant;
import ng.bayue.service.RedisCacheService;
import ng.bayue.util.StringUtils;
import ng.bayue.util.crypto.AESUtils;
import ng.bayue.util.net.SSLClient;

@Service
public class WechatAO extends BaseAO {

	// @Value("#{metaf['appid']}")
	// private String appid;
	// @Value("#{metaf['secret']}")
	// private String secret;

	private static String appid;
	private static String secret;
	/** 微信支付debug模式 */
	private static Boolean debug;

	@Value("#{metaf['wechatpay.appid']}")
	private void setAppid(String appid) {
		WechatAO.appid = appid;
	}

	@Value("#{metaf['wechatpay.secrectKey']}")
	private void setSecret(String secret) {
		WechatAO.secret = secret;
	}

	@Value("#{metaf['wechat_jsapi_config_debug']}")
	private void setDebug(Boolean debug) {
		WechatAO.debug = debug;
	}

	@Resource(name = "redisCacheService1")
	private RedisCacheService redisCacheService;
	@Autowired
	private WechatUserService wechatUserService;
	@Autowired
	private IcheccUserService icheccUserService;
	@Autowired
	private WechatPayService wechatPayService;

	public ResultData authorize(String code) {
		try {
			if (StringUtils.isBlank(code)) {
				logger.info("获取微信授权异常: code获取为空");
				return ResultData.failure("获取微信授权异常: code获取为空");
			}
			AESUtils aes = new AESUtils();
			code = aes.decrypt(code);

			// 换取access_token同时获取openid
			AuthAccessTokenDTO tokenDTO = getAccessTokenAuth(null, code);
			if (null == tokenDTO) {
				logger.info("微信服务器授权异常：获取access_token失败");
				return ResultData.failure("微信服务器授权异常：获取access_token失败");
			}
			String openid = tokenDTO.getOpenid();

			ICheccUserDTO userDO = null;
			// 校验用户是否已经授权注册
			if (StringUtils.isNotBlank(openid)) {
				userDO = selectWechatUser(openid);
				if (null != userDO) {
					return ResultData.success(userDO);
				}
			} else {
				logger.info("wechat server error: get openid is null");
				return ResultData.failure("wechat server error: get openid is null");
			}

			// 尚未授权注册，则获取用户信息
			String accessToken = tokenDTO.getAccess_token();
			WechatUserDO wechatUserDO = getUserInfoStr(openid, accessToken);

			ICheccUserDTO dto = wechatUserService.saveWechatUser(wechatUserDO);
			return ResultData.success(dto);
		} catch (Exception e) {
			logger.info("微信授权异常：服务器异常{}", e);
			return ResultData.failure("微信授权异常：服务器异常");
		}
	}

	private ICheccUserDTO selectWechatUser(String openid) {
		if (StringUtils.isBlank(openid)) {
			return null;
		}
		ICheccUserDTO userDO = icheccUserService.selectUserInfoByOpenid(openid);
		return userDO;
	}

	/**
	 * 获取授权access_token
	 * 
	 * @param openid
	 * @param code
	 * @return
	 * @throws Exception
	 */
	private AuthAccessTokenDTO getAccessTokenAuth(String openid, String code) throws Exception {
		try {
			String redisKey = ICheccConstants.ICheccRedisKeys.WECHAT_ACCESS_TOKEN_AUTH;
			logger.info("微信授权-获取access_token, openid:{}, code:{}", openid, code);
			AuthAccessTokenDTO accessToken = null;
			if (StringUtils.isNotBlank(openid)) {
				redisKey += openid;
				accessToken = (AuthAccessTokenDTO) redisCacheService.getRedisCache(openid);
			}
			if (null != accessToken) {
				return accessToken;
			}
			if (StringUtils.isBlank(code)) {
				logger.info("微信授权获取access_token异常：code为空");
				throw new Exception("微信授权获取access_token异常：code为空");
			}

			final String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + appid
					+ "&secret=" + secret + "&grant_type=authorization_code&code=" + code;
			String jsonStr = doRequest(accessTokenUrl);
			JSONObject json = JSONObject.parseObject(jsonStr);
			// 接口返回错误信息
//			checkError(json);

			logger.info("微信授权-获取access_token, access_token json:{}", json);
			accessToken = JSONObject.toJavaObject(json, AuthAccessTokenDTO.class);
			redisKey += accessToken.getOpenid();
			redisCacheService.setRedisCache(redisKey, accessToken, accessToken.getExpires_in());
			return accessToken;
		} catch (Exception e) {
			throw e;
		}
	}

	private WechatUserDO getUserInfoStr(String openid, String accessToken) throws Exception {
		try {
			logger.info("微信授权-获取用户信息, openid:{}, accessToken:{}", openid, accessToken);
			if (StringUtils.isBlank(openid) || StringUtils.isBlank(accessToken)) {
				return null;
			}
			final String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN&" + "openid=" + openid
					+ "&access_token=" + accessToken;
			String jsonStr = doRequest(userInfoUrl);
			JSONObject json = JSONObject.parseObject(jsonStr);
			// 接口返回错误信息
			checkError(json);
			logger.info("微信授权-获取用户信息, userinfo json:{}", jsonStr);
			WechatUserDO wechatUserDO = JSONObject.parseObject(jsonStr, WechatUserDO.class);
			return wechatUserDO;
		} catch (Exception e) {
			logger.info("微信获取授权access_token异常：{}", e);
			throw e;
		}
	}

	private WechatApiErrorDTO checkError(JSONObject json) throws Exception {
		try {
			WechatApiErrorDTO err = null;
			String errcode = json.getString("errcode");
			if (StringUtils.isNotBlank(errcode) || !"0".equals(errcode)) {
				err = JSONObject.toJavaObject(json, WechatApiErrorDTO.class);
				logger.info("请求微信接口失败,错误信息：code:{},msg:{}", err.getErrcode(), err.getErrmsg());
				throw new Exception("请求微信接口失败,错误信息：" + json.toJSONString());
			}
			return err;
		} catch (Exception e) {
			throw e;
		}
	}

	private String doRequest(String url) throws Exception {
		try {
			HttpClient client = SSLClient.registerSSL();
			HttpPost httpPost = new HttpPost(url);
			RequestConfig config = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(5000)
					.setConnectionRequestTimeout(5000).setExpectContinueEnabled(false).build();
			httpPost.setConfig(config);
			ContentType contentType = ContentType.create("text/plain", CharsetConstant.UTF8);
			StringEntity se = new StringEntity(CharsetConstant.UTF8, contentType);
			httpPost.setEntity(se);
			HttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String res = EntityUtils.toString(entity, CharsetConstant.UTF8);
			if (StringUtils.isBlank(res)) {
				logger.error("请求微信服务器异常：网络请求异常");
				throw new Exception("网络请求异常：获取数据为空");
			}
			return res;
			// String res = RequestUtil.doRequest(url);
			// return res;
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			logger.error("请求微信服务器异常：网络请求异常", e);
			throw e;
		}
	}

	/**
	 * 获取微信基础接口access_token
	 * 
	 * @return
	 * @throws Exception
	 */
	private AccessTokenDTO getAccessTokenJsApi() throws Exception {
		try {
			final String redisKey = ICheccConstants.ICheccRedisKeys.WECHAT_ACCESS_TOKEN_JSSDK;
			AccessTokenDTO accessToken = (AccessTokenDTO) redisCacheService.getRedisCache(redisKey);
			if (null != accessToken) {
				return accessToken;
			}
			final String jsAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
					+ appid + "&secret=" + secret;
			String jsonStr = doRequest(jsAccessTokenUrl);
			JSONObject json = JSONObject.parseObject(jsonStr);
			// 接口返回错误信息
//			checkError(json);

			logger.info("微信jssdk-获取access_token, access_token json:{}", json);
			accessToken = JSONObject.toJavaObject(json, AccessTokenDTO.class);

			redisCacheService.setRedisCache(redisKey, accessToken, accessToken.getExpires_in());

			return accessToken;
		} catch (Exception e) {
			logger.info("微信获取jssdk access_token异常：{}", e);
			throw e;
		}
	}

	private JSApiTicketDTO getJsApiTicket() throws Exception {
		try {
			final String redisKey = ICheccConstants.ICheccRedisKeys.WECHAT_JSAPI_TICKET;
			JSApiTicketDTO ticket = (JSApiTicketDTO) redisCacheService.getRedisCache(redisKey);
			if (null != ticket) {
				return ticket;
			}

			AccessTokenDTO accessTokenDTO = getAccessTokenJsApi();
			String accessToken = accessTokenDTO.getAccess_token();
			final String ticketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token="
					+ accessToken;

			String jsonStr = doRequest(ticketUrl);
			JSONObject json = JSONObject.parseObject(jsonStr);
			// 接口返回错误信息
//			checkError(json);
			String errcode = json.getString("errcode");
			if (!"0".equals(errcode)) {
				logger.info("微信获取jsapi ticket票据异常：返回ticket失败");
				throw new Exception("微信获取jsapi ticket票据异常");
			}

			logger.info("微信jssdk-获取api_ticket, api_ticket json:{}", json);
			ticket = JSONObject.toJavaObject(json, JSApiTicketDTO.class);

			redisCacheService.setRedisCache(redisKey, ticket, ticket.getExpires_in());

			return ticket;
		} catch (Exception e) {
			logger.info("微信获取jsapi ticket票据异常：{}", e);
			throw e;
		}
	}

	public ResultData getWechatJSConfig(String url) {
		try {
			if (StringUtils.isBlank(url)) {
				return ResultData.failureMsg(ResultCode.Common.PARAMS_ERROR);
			}
			JSApiTicketDTO ticketDto = getJsApiTicket();
			String jsapi_ticket = ticketDto.getTicket();
			WechatJsConfigDTO config = JsConfigSign.sign(jsapi_ticket, url);
			config.setAppid(appid);
			config.setDebug(debug);

			logger.info("微信jsapi获取config: {}", JSONObject.toJSONString(config));
			
//			List<VipDepositConfigVO> depositConfigs = configAO.listAllConfig();
//			
//			Map<String, Object> data = new HashMap<String, Object>();
//			data.put("jsApiConfig", config);
//			data.put("depositConfig", depositConfigs);
			
			return ResultData.success(config);
		} catch (Exception e) {
			logger.info("微信jsapi获取配置异常: {}", e);
			return ResultData.failureMsg(ResultCode.Biz.WECHAT_PAY_CONFIG_ERROR);
		}
	}

	public ResultData getPayOrder(UnifiedOrderInputDTO inputDto) {
		try {
			CommonResultMessage crm = wechatPayService.unifiedOrder(inputDto);
			if (CommonResultMessage.Failure == crm.getResult()) {
				logger.info("微信支付下单异常：{}", crm.getMessage());
				throw new Exception("微信支付下单异常");
			}
			return ResultData.success(crm.getData());
		} catch (Exception e) {
			logger.info("微信支付下单异常", e);
			return ResultData.failure("微信支付异常");
		}
	}

}
