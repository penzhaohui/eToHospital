package com.etohospital.wechat;

public class WechatUserInfo {

	private String _openId = "";
	private String _nickName = "";
	private String _sex = "";
	private String _province = "";	
	private String _city = "";
	private String _country = "";	
	private String _headingUrl = "";
	
	public String getOpenId() {
		return _openId;
	}
	public void setOpenId(String openId) {
		this._openId = openId;
	}
	public String getNickName() {
		return _nickName;
	}
	public void setNickName(String nickName) {
		this._nickName = nickName;
	}
	public String getSex() {
		return _sex;
	}
	public void setSex(String sex) {
		this._sex = sex;
	}
	public String getProvince() {
		return _province;
	}
	public void setProvince(String province) {
		this._province = province;
	}
	public String getCity() {
		return _city;
	}
	public void setCity(String city) {
		this._city = city;
	}
	public String getCountry() {
		return _country;
	}
	public void setCountry(String country) {
		this._country = country;
	}
	public String getHeadingUrl() {
		return _headingUrl;
	}
	public void setHeadingUrl(String headingurl) {
		this._headingUrl = headingurl;
	}
}
