package com.etohospital.wechat.pojo.message.request;

public class VoiceMessage extends BaseMessage
{
	private String _mediaId;	
	private String _format;

	public String getMediaId()
	{
		return _mediaId;
	}
	public void setMediaId(String mediaId)
	{
		_mediaId = mediaId;
	}
	public String getFormat()
	{
		return _format;
	}
	public void setFormat(String format)
	{
		_format = format;
	}
}
