package com.etohospital.wechat.pojo.button;

public class ClickButton extends Button
{
	private String _type;
	private String _key;

	public String getType()
	{
		return _type;
	}
	public void setType(String type)
	{
		this._type = type;
	}
	public String getKey()
	{
		return _key;
	}
	public void setKey(String key)
	{
		this._key = key;
	}
}
