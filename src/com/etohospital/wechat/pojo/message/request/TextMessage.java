package com.etohospital.wechat.pojo.message.request;


public class TextMessage extends BaseMessage
{
	private String _content;

	public String getContent()
	{
		return _content;
	}
	public void setContent(String content)
	{
		_content = content;
	}
}
