package com.etohospital.wechat;

public class MessageConstant {
	
	/** 响应消息类型 **/
	// 文本
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	// 音乐
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	// 图文
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	// 语音
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	// 视频
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	// :图片
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";

	/** 请求消息类型 **/
	// 文本
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	// 图片
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	// 链接
	public static final String REQ_MESSAGE_TYPE_LINK = "link";
	// 地理位置
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	// 音频
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	// 视频
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	// 事件推�?
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/** 事件类型 **/
	// 订阅
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	// 取消订阅
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	// 上报地理信息
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	// 自定义菜单点击事�?
	public static final String EVENT_TYPE_CLICK = "CLICK";

	public static final String EVENT_TYPE_QRCODE_PREFIX = "qrscene_";
}
