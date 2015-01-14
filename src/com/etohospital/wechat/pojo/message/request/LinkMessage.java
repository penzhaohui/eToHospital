package com.etohospital.wechat.pojo.message.request;

public class LinkMessage extends BaseMessage
{
	private String _title;	
	private String _description;	
	private String _url;

	public String getTitle()
	{
		return _title;
	}
	public void setTitle(String title)
	{
		_title = title;
	}	
	public String getDescription()
	{
		return _description;
	}
	public void setDescription(String description)
	{
		_description = description;
	}
	public String getUrl()
	{
		return _url;
	}
	public void setUrl(String url)
	{
		_url = url;
	}
}
