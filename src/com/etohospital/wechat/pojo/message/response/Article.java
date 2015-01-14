package com.etohospital.wechat.pojo.message.response;

public class Article {

	private String _title;	
	private String _description;	
	private String _picUrl;	
	private String _url;

	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		_title = title;
	}
	public String getDescription() {
		return null == _description ? "" : _description;
	}
	public void setDescription(String description) {
		_description = description;
	}
	public String getPicUrl() {
		return null == _picUrl ? "" : _picUrl;
	}
	public void setPicUrl(String picUrl) {
		_picUrl = picUrl;
	}
	public String getUrl() {
		return null == _url ? "" : _url;
	}
	public void setUrl(String url) {
		_url = url;
	}
}
