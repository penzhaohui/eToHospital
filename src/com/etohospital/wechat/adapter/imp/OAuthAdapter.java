package com.etohospital.wechat.adapter.imp;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.etohospital.wechat.AccessToken;
import com.etohospital.wechat.WechatConstant;
import com.etohospital.wechat.WechatUserInfo;
import com.etohospital.wechat.adapter.IMessageAdapter;
import com.etohospital.wechat.adapter.IOAuthAdapter;

public class OAuthAdapter implements IOAuthAdapter {

	private static IMessageAdapter MessageAdapter = new MessageAdapter(); 
	
	/**
	 * 获取用户授权 access_token
	 * @param code 授权时获得code值
	 * @return
	 * @throws Exception 
	 */
	@Override
	public AccessToken getAuthAccessToken(String code) throws Exception {
		
		AccessToken accessToken = null;
		
		if(code == null)
		{
			throw new Exception("code is empty.");
		}
		
		String requestUrl = WechatConstant.OAUTH2_ACCESS_TOKEN_URL.replace("CODE", code);
		JSONObject jsonObject = MessageAdapter.httpRequest(requestUrl, "GET", null);
		if (null != jsonObject)
		{
			try
			{
				accessToken = new AccessToken();
				accessToken.setAccessToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInteger("expires_in"));
				accessToken.setRefreshToken(jsonObject.getString("refresh_token"));
				accessToken.setOpenId(jsonObject.getString("openid"));
				accessToken.setScope(jsonObject.getString("scope"));
			}
			catch (JSONException e)
			{
				accessToken = null;
			}
		}
		
		return accessToken;
	}

	/**
	 * 刷新用户授权access_token
	 * @param refreshToken 用户刷新access_token
	 * @return
	 */
	@Override
	public AccessToken refreshAuthToken(String refreshToken) {
		AccessToken accessToken = null;
		String requestUrl = WechatConstant.OAUTH2_REFRESH_ACCESS_TOKEN_URL.replace("REFRESH_TOKEN", refreshToken);
		
		JSONObject jsonObject = MessageAdapter.httpRequest(requestUrl, "GET", null);
		if (null != jsonObject)
		{
			try
			{
				accessToken = new AccessToken();
				accessToken.setAccessToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInteger("expires_in"));
				accessToken.setRefreshToken(jsonObject.getString("refresh_token"));
				accessToken.setOpenId(jsonObject.getString("openid"));
				accessToken.setScope(jsonObject.getString("scope"));
			}
			catch (JSONException e)
			{
				accessToken = null;
			}
		}
		
		return accessToken;	
	}

	@Override
	public WechatUserInfo getUserInfoByOAuth(String accessToken, String openId,
			String lang) {
		
		WechatUserInfo userInfo = null;
		String requestUrl = WechatConstant.OAUTH2_USER_INFO_URL;
		
		JSONObject jsonObject = MessageAdapter.httpRequest(requestUrl, "GET", null);
		if (null != jsonObject)
		{
			try
			{
				userInfo = new WechatUserInfo();
				userInfo.setOpenId(jsonObject.getString("openid"));
				userInfo.setNickName(jsonObject.getString("nickname"));
				userInfo.setSex(jsonObject.getString("sex"));
				userInfo.setProvince(jsonObject.getString("province"));
				userInfo.setCity(jsonObject.getString("city"));
				userInfo.setCountry(jsonObject.getString("country"));
				userInfo.setHeadingUrl(jsonObject.getString("headingurl"));
			}
			catch (JSONException e)
			{
				userInfo = null;
			}
		}
		
		return userInfo;
	}

}
