package com.etohospital.wechat.pojo.message.request;

public class BaseMessage
{
	private String _toUserName;	
	private String _fromUserName;	
	private long _createTime;	
	private String _msgType;	
	private long _msgId;

	public String getToUserName()
	{
		return _toUserName;
	}
	public void setToUserName(String toUserName)
	{
		_toUserName = toUserName;
	}
	public String getFromUserName()
	{
		return _fromUserName;
	}
	public void setFromUserName(String fromUserName)
	{
		_fromUserName = fromUserName;
	}
	public long getCreateTime()
	{
		return _createTime;
	}
	public void setCreateTime(long createTime)
	{
		_createTime = createTime;
	}
	public String getMsgType()
	{
		return _msgType;
	}
	public void setMsgType(String msgType)
	{
		_msgType = msgType;
	}
	public long getMsgId()
	{
		return _msgId;
	}
	public void setMsgId(long msgId)
	{
		_msgId = msgId;
	}
}
