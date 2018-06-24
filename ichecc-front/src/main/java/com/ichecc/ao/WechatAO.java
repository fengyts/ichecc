package com.ichecc.ao;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import ng.bayue.constants.CharsetConstant;
import ng.bayue.service.RedisCacheService;
import ng.bayue.util.StringUtils;
import ng.bayue.util.crypto.AESUtils;
import ng.bayue.util.net.SSLClient;

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
import com.ichecc.common.ResultData;
import com.ichecc.constants.ICheccConstants;
import com.ichecc.domain.WechatUserDO;
import com.ichecc.dto.ICheccUserDTO;
import com.ichecc.service.IcheccUserService;
import com.ichecc.service.WechatUserService;
import com.ichecc.wechat.AccessTokenDTO;
import com.ichecc.wechat.WechatApiErrorDTO;

@Service
public class WechatAO extends BaseAO {

	// @Value("#{metaf['appid']}")
	// private String appid;
	// @Value("#{metaf['secret']}")
	// private String secret;

	private static String appid;
	private static String secret;

	@Value("#{metaf['appid']}")
	private void setAppid(String appid) {
		WechatAO.appid = appid;
	}

	@Value("#{metaf['secret']}")
	private void setSecret(String secret) {
		WechatAO.secret = secret;
	}

	@Resource(name = "redisCacheService1")
	private RedisCacheService redisCacheService;
	@Autowired
	private WechatUserService wechatUserService;
	@Autowired
	private IcheccUserService icheccUserService;

	// 通过code换取网页授权access_token
//	private String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid="
//			+ appid + "&secret=" + secret + "&grant_type=authorization_code&code=";

	// https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
//	private static String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN&";

	public ResultData authorize(String code) {
		try {
			if (StringUtils.isBlank(code)) {
				logger.info("获取微信授权异常: code获取为空");
				return ResultData.failure("获取微信授权异常: code获取为空");
			}
			AESUtils aes = new AESUtils();
			code = aes.decrypt(code);
			// 换取access_token同时获取openid
			AccessTokenDTO tokenDTO = getAccessToken(null, code);
			if (null == tokenDTO) {
				logger.info("微信服务器授权异常：获取access_token失败");
				return ResultData.failure("微信服务器授权异常：获取access_token失败");
			}
			WechatUserDO wechatUserDO = null;
			String openid = tokenDTO.getOpenid();

			// 校验用户是否已经授权注册
			if (StringUtils.isNotBlank(openid)) {
				wechatUserDO = selectWechatUser(openid);
			}
			if (null != wechatUserDO) {
				return ResultData.success(wechatUserDO);
			}
			// 尚未授权注册，则获取用户信息
			String accessToken = tokenDTO.getAccess_token();
			wechatUserDO = getUserInfoStr(openid, accessToken);

			ICheccUserDTO dto = wechatUserService.saveWechatUser(wechatUserDO);
			return ResultData.success(dto);
		} catch (Exception e) {
			logger.info("微信授权异常：服务器异常{}", e);
			return ResultData.failure("微信授权异常：服务器异常");
		}
	}

	private WechatUserDO selectWechatUser(String openid) {
		if (StringUtils.isBlank(openid)) {
			return null;
		}
		WechatUserDO wechatUserDO = wechatUserService.selectByOpenid(openid);
		return wechatUserDO;
	}

	private AccessTokenDTO getAccessToken(String openid, String code) throws Exception {
		try {
			logger.info("微信授权-获取access_token, openid:{}, code:{}", openid, code);
			AccessTokenDTO accessToken = null;
			if (StringUtils.isNotBlank(openid)) {
				accessToken = (AccessTokenDTO) redisCacheService.getRedisCache(openid);
			}
			if (null != accessToken) {
				return accessToken;
			}
			if (StringUtils.isBlank(code)) {
				logger.info("微信授权获取access_token异常：code为空");
				throw new Exception("微信授权获取access_token异常：code为空");
			}

			String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid="
					+ appid + "&secret=" + secret + "&grant_type=authorization_code&code=";
			String url = accessTokenUrl + code;
			String jsonStr = doRequest(url);
			JSONObject json = JSONObject.parseObject(jsonStr);
			// 接口返回错误信息
			checkError(json);

			logger.info("微信授权-获取access_token, access_token json:{}", json);
			accessToken = JSONObject.toJavaObject(json, AccessTokenDTO.class);
			redisCacheService.setRedisCache(
					ICheccConstants.ICheccRedisKeys.WECHAT_AUTH_ACCESS_TOKEN, accessToken,
					accessToken.getExpires_in());
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
			String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN&";
			String url = userInfoUrl + "openid=" + openid + "&access_token=" + accessToken;
			String jsonStr = doRequest(url);
			JSONObject json = JSONObject.parseObject(jsonStr);
			// 接口返回错误信息
			checkError(json);
			logger.info("微信授权-获取用户信息, userinfo json:{}", jsonStr);
			WechatUserDO wechatUserDO = JSONObject.parseObject(jsonStr, WechatUserDO.class);
			return wechatUserDO;
		} catch (Exception e) {
			throw e;
		}
	}

	private WechatApiErrorDTO checkError(JSONObject json) throws Exception {
		try {
			WechatApiErrorDTO err = null;
			String errcode = json.getString("errcode");
			if (StringUtils.isNotBlank(errcode)) {
				err = JSONObject.toJavaObject(json, WechatApiErrorDTO.class);
				logger.info("微信授权异常,请求微信接口失败,错误信息：code:{},msg:{}", err.getErrcode(),
						err.getErrmsg());
				throw new Exception("微信授权异常,请求微信接口失败,错误信息：" + json.toJSONString());
			}
			return err;
		} catch (Exception e) {
			// logger.info("微信授权异常,请求微信接口失败,错误信息：", e);
			throw e;
		}
	}

	private String doRequest(String url) throws Exception {
		try {
			HttpClient client = SSLClient.registerSSL();
			HttpPost httpPost = new HttpPost(url);
			RequestConfig config = RequestConfig.custom().setSocketTimeout(10000)
					.setConnectTimeout(5000).setConnectionRequestTimeout(5000)
					.setExpectContinueEnabled(false).build();
			httpPost.setConfig(config);
			ContentType contentType = ContentType.create("text/plain", CharsetConstant.UTF8);
			StringEntity se = new StringEntity(CharsetConstant.UTF8, contentType);
			httpPost.setEntity(se);
			HttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String res = EntityUtils.toString(entity, CharsetConstant.UTF8);
			if (StringUtils.isBlank(res)) {
				logger.error("获取微信授权异常：网络请求异常");
				throw new Exception("网络请求异常：获取数据为空");
			}
			return res;
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			logger.error("获取微信授权异常：网络请求异常", e);
			throw e;
		}
		// return null;
	}

}
