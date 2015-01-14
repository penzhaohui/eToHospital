package com.etohospital.wechat.adapter.imp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.alibaba.fastjson.JSONObject;
import com.etohospital.wechat.adapter.IMessageAdapter;
import com.etohospital.wechat.utils.TrustAnyX509TrustManager;

public class MessageAdapter implements IMessageAdapter {

	@Override
	public JSONObject httpRequest(String requestUrl, String requestMethod,
			String outputStr) {
		
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try
		{
			TrustManager[] tm = {new TrustAnyX509TrustManager()};
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());

			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlCon = (HttpsURLConnection) url.openConnection();
			httpUrlCon.setSSLSocketFactory(ssf);

			httpUrlCon.setDoOutput(true);
			httpUrlCon.setDoInput(true);
			httpUrlCon.setUseCaches(false);

			httpUrlCon.setRequestMethod(requestMethod);

			System.setProperty("jsse.enableSNIExtension", "false");

			if ("GET".equalsIgnoreCase(requestMethod))
			{
				httpUrlCon.connect();
			}

			if (null != outputStr)
			{
				OutputStream outputStream = httpUrlCon.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			InputStream inputStream = httpUrlCon.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null)
			{
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlCon.disconnect();

			jsonObject = JSONObject.parseObject(buffer.toString());
		}
		catch (ConnectException ce)
		{
			ce.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return jsonObject;
	}

	@Override
	public String httpRequest(String requestUrl) {
		
		StringBuffer buffer = null;
		try
		{
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();

			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null)
			{
				buffer.append(str);
			}

			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
		}
		catch (Exception e)
		{
		}
		
		return buffer.toString();
	}


}
