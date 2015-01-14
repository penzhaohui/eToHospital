package com.etohospital.wechat.adapter;

import com.alibaba.fastjson.JSONObject;

public interface IMessageAdapter {

	JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr);
	String httpRequest(String requestUrl);
}
