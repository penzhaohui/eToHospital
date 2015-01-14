package com.etohospital.wechat.adapter;

import com.etohospital.wechat.AccessToken;
import com.etohospital.wechat.WechatUserInfo;

public interface IOAuthAdapter {
	
	AccessToken getAuthAccessToken(String code) throws Exception;
	AccessToken refreshAuthToken(String refreshToken);
	WechatUserInfo getUserInfoByOAuth(String accessToken, String openId, String lang);
}
