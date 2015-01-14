package com.etohospital.wechat.pojo.button;

public class ViewButton extends Button
{
	private String _type;
	private String _url;

	public String getType()
	{
		return _type;
	}
	public void setType(String type)
	{
		this._type = type;
	}
	public String getUrl()
	{
		return _url;
	}
	public void setUrl(String url)
	{
		this._url = url;
	}
}
