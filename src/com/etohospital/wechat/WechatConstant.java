package com.etohospital.wechat;

import java.net.URLEncoder;

import com.etohospital.utils.SystemConfig;

public class WechatConstant {

	// Server的Url
	public static String APP_URL = SystemConfig.getProperty("appurl");
	// 与开发模式接口配置信息中的Token保持一致
	public static String TOKEN = SystemConfig.getProperty("token");
	// 微信AppID
	public static String APP_ID = SystemConfig.getProperty("appid");
	// 微信AppSecret
	public static String APP_SECRECT = SystemConfig.getProperty("appsecret");
	// 公众号处理微信服务器请求的URL
	public static String OAUTH2_REDIRECT_URL = SystemConfig.getProperty("oauth2_redirect_url");
	
	// 微信App的Url
	public static String MOBILE_ROOT_URL =  APP_URL + "mobile/";
	
		
	// 获取access_token的接口(GET)
	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APP_SECRECT;
	
	// 用户授权微信 OAuth2 URL地址,不弹出授权页且直接跳转,只能获取用户openid
	public static String OAUTH2_AUTH_BASE_URL = "";
	// 用户授权微信 OAuth2 URL地址,用于获取用户信息 弹出授权页面,可以通过openid拿到昵称、性别、头像
	public static String OAUTH2_AUTH_URL = "";
	
	static 
	{
		try
		{
			OAUTH2_AUTH_BASE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + APP_ID + "&redirect_uri=" + URLEncoder.encode(OAUTH2_REDIRECT_URL, "utf-8") + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
			OAUTH2_AUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + APP_ID + "&redirect_uri=" + URLEncoder.encode(OAUTH2_REDIRECT_URL, "utf-8") + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		} catch(Exception ex)
		{			
		}
	}
	// 使用code换取access_token, 此access_token和openid可以获取到用户信息
	public static String OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APP_ID + "&secret=" + APP_SECRECT + "&code=CODE&grant_type=authorization_code";
	// 刷新用户授权access_token
	public static String OAUTH2_REFRESH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + APP_ID + "&grant_type=refresh_token&refresh_token=REFRESH_TOKEN" ;
	// 使用授权后的access_token值和openId 获取到用户的基本信息
	public static String OAUTH2_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
	
	// 菜单创建(POST)
	public static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 删除菜单(GET)
	public static String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	// 查询菜单(GET)
	public static String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
		
	public static void main(String[] args)
	{
		System.out.println("APP_URL: " + APP_URL);
		System.out.println("TOKEN: " + TOKEN);
		System.out.println("APP_ID: " + APP_ID);
		System.out.println("APP_SECRECT: " + APP_SECRECT);		
		System.out.println("OAUTH2_REDIRECT_URL: " + OAUTH2_REDIRECT_URL);
		System.out.println("MOBILE_ROOT_URL: " + MOBILE_ROOT_URL);
		
		System.out.println("ACCESS_TOKEN_URL: " + ACCESS_TOKEN_URL);
		System.out.println("OAUTH2_AUTH_BASE_URL: " + OAUTH2_AUTH_BASE_URL);
		System.out.println("OAUTH2_AUTH_URL: " + OAUTH2_AUTH_URL);
		System.out.println("OAUTH2_ACCESS_TOKEN_URL: " + OAUTH2_ACCESS_TOKEN_URL);
		System.out.println("OAUTH2_REFRESH_ACCESS_TOKEN_URL: " + OAUTH2_REFRESH_ACCESS_TOKEN_URL);
		System.out.println("OAUTH2_USER_INFO_URL: " + OAUTH2_USER_INFO_URL);
		
		System.out.println("MENU_CREATE_URL: " + MENU_CREATE_URL);
		System.out.println("MENU_CREATE_URL: " + MENU_CREATE_URL);
		System.out.println("MENU_GET_URL: " + MENU_GET_URL);
	}
}
