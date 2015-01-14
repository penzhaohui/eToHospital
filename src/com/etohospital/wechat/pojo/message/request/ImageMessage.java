package com.etohospital.wechat.pojo.message.request;

public class ImageMessage extends BaseMessage
{
	private String _picUrl;

	public String getPicUrl()
	{
		return _picUrl;
	}
	public void setPicUrl(String picUrl)
	{
		_picUrl = picUrl;
	}
}
