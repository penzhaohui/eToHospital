package com.etohospital.wechat;

import java.net.URLEncoder;

import com.etohospital.utils.SystemConfig;

public class WechatConstant {

	// Server��Url
	public static String APP_URL = SystemConfig.getProperty("appurl");
	// �뿪��ģʽ�ӿ�������Ϣ�е�Token����һ��
	public static String TOKEN = SystemConfig.getProperty("token");
	// ΢��AppID
	public static String APP_ID = SystemConfig.getProperty("appid");
	// ΢��AppSecret
	public static String APP_SECRECT = SystemConfig.getProperty("appsecret");
	// ���ںŴ���΢�ŷ����������URL
	public static String OAUTH2_REDIRECT_URL = SystemConfig.getProperty("oauth2_redirect_url");
	
	// ΢��App��Url
	public static String MOBILE_ROOT_URL =  APP_URL + "mobile/";
	
		
	// ��ȡaccess_token�Ľӿ�(GET)
	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APP_SECRECT;
	
	// �û���Ȩ΢�� OAuth2 URL��ַ,��������Ȩҳ��ֱ����ת,ֻ�ܻ�ȡ�û�openid
	public static String OAUTH2_AUTH_BASE_URL = "";
	// �û���Ȩ΢�� OAuth2 URL��ַ,���ڻ�ȡ�û���Ϣ ������Ȩҳ��,����ͨ��openid�õ��ǳơ��Ա�ͷ��
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
	// ʹ��code��ȡaccess_token, ��access_token��openid���Ի�ȡ���û���Ϣ
	public static String OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APP_ID + "&secret=" + APP_SECRECT + "&code=CODE&grant_type=authorization_code";
	// ˢ���û���Ȩaccess_token
	public static String OAUTH2_REFRESH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + APP_ID + "&grant_type=refresh_token&refresh_token=REFRESH_TOKEN" ;
	// ʹ����Ȩ���access_tokenֵ��openId ��ȡ���û��Ļ�����Ϣ
	public static String OAUTH2_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
	
	// �˵�����(POST)
	public static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// ɾ���˵�(GET)
	public static String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	// ��ѯ�˵�(GET)
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
