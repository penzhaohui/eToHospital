package com.etohospital.wechat.utils;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.etohospital.utils.EmptyUtil;

import com.etohospital.wechat.AccessToken;
import com.etohospital.wechat.WechatConstant;
import com.etohospital.wechat.adapter.IMessageAdapter;
import com.etohospital.wechat.adapter.imp.MessageAdapter;

public class WechatUtil {

	private static IMessageAdapter MessageAdapter = new MessageAdapter(); 
	
	public static AccessToken getAccessToken() {
		
		AccessToken accessToken = null;

		JSONObject jsonObject = MessageAdapter.httpRequest(WechatConstant.ACCESS_TOKEN_URL, "GET", null);

		if (null != jsonObject)
		{
			try
			{
				accessToken = new AccessToken();
				accessToken.setAccessToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInteger("expires_in"));
			}
			catch (JSONException e)
			{
				accessToken = null;
			}
		}
		
		return accessToken;
	}

	public static String urlEncodeUTF8(String url) {
		
		String result = url;
		try
		{
			result = java.net.URLEncoder.encode(url, "utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public static String getFullURL(String root, String path) {
		
		String url = root;		
		if(path.indexOf("?") == -1)
		{
			url += path + "?ramdom=" + new Date().getTime();
		}
		else
		{
			url += path + "&ramdom=" + new Date().getTime();
		}
		
		return url;
	}

	public static boolean checkSignature(String signature, String timestamp,
			String nonce) {
		
		String[] stnArray = new String[] {WechatConstant.TOKEN, timestamp, nonce};
		Arrays.sort(stnArray);

		String stn = stnArray[0].concat(stnArray[1]).concat(stnArray[2]);

		String result = null;

		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			result = byteToString(md.digest(stn.getBytes()));

		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}

		return EmptyUtil.isNotEmpty(result) ? result.equals(signature.toUpperCase()) : false;
	}
	
	private static String byteToString(byte[] byteArray)
	{
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++)
		{
			str.append(byteToHexString(byteArray[i]));
		}
		return str.toString();
	}

	private static String byteToHexString(byte mByte)
	{
		char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

		char[] tempArray = new char[2];

		tempArray[0] = digit[(mByte >>> 4) & 0X0F];
		tempArray[1] = digit[mByte & 0X0F];

		return new String(tempArray);
	}
}
