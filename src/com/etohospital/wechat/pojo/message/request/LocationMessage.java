package com.etohospital.wechat.pojo.message.request;

public class LocationMessage extends BaseMessage
{
	private String _locationX;	
	private String _locationY;	
	private String _scale;	
	private String _label;

	public String getLocationX()
	{
		return _locationX;
	}
	public void setLocationX(String locationX)
	{
		_locationX = locationX;
	}
	public String getLocationY()
	{
		return _locationY;
	}
	public void setLocationY(String locationY)
	{
		_locationY = locationY;
	}
	public String getScale()
	{
		return _scale;
	}
	public void setScale(String scale)
	{
		_scale = scale;
	}
	public String getLabel()
	{
		return _label;
	}
	public void setLabel(String label)
	{
		_label = label;
	}
}
