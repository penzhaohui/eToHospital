package com.etohospital.wechat;

public class AccessToken {

	private String _accessToken = "";	
	private int _expiresIn = 0;	
	private String _refreshToken = "";		
	private String _openId = "";	
	private String _scope = "";
	
	public String getAccessToken() {
		return _accessToken;
	}
	public void setAccessToken(String accessToken) {
		this._accessToken = accessToken;
	}
	public int getExpiresIn() {
		return _expiresIn;
	}
	public void setExpiresIn(int _expiresIn) {
		this._expiresIn = _expiresIn;
	}
	public String getRefreshToken() {
		return _refreshToken;
	}
	public void setRefreshToken(String _refreshToken) {
		this._refreshToken = _refreshToken;
	}
	public String getOpenId() {
		return _openId;
	}
	public void setOpenId(String _openId) {
		this._openId = _openId;
	}
	public String getScope() {
		return _scope;
	}
	public void setScope(String _scope) {
		this._scope = _scope;
	}
	
}
