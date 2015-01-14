package com.etohospital.wechat.pojo.message.request;

public class VideoMessage extends BaseMessage
{
	private String _mediaId;
	private String _thumbMediaId;

	public String getMediaId()
	{
		return _mediaId;
	}
	public void setMediaId(String mediaId)
	{
		_mediaId = mediaId;
	}
	public String getThumbMediaId()
	{
		return _thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId)
	{
		_thumbMediaId = thumbMediaId;
	}

}
