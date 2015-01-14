package com.etohospital.model;

import java.util.Date;

import com.etohospital.dao.utils.TablePrimaryKeyAnnotation;

@TablePrimaryKeyAnnotation(TableName="User", PrimaryKey="UserID")
public class UserModel {

	private int _userID;
	private String _userName;
	private String _mobilePhone;
	private String _weixin;
	private int _userType = -1;
	private String _password;
	private boolean _status;
	private int _createdBy;
	private Date _createdDate = null;
	private int _lastModifiedBy;
	private Date _lastModifiedDate = null;
	
	public int getUserID() {
		return _userID;
	}
	public void setUserID(int userID) {
		_userID = userID;
	}
	public String getUserName() {
		return _userName;
	}
	public void setUserName(String userName) {
		_userName = userName;
	}
	public String getMobilePhone() {
		return _mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}
	public String getWeixin() {
		return _weixin;
	}
	public void setWeixin(String weixin) {
		_weixin = weixin;
	}
	public int getUserType() {
		return _userType;
	}
	public void setUserType(int userType) {
		_userType = userType;
	}
	public String getPassword() {
		return _password;
	}
	public void setPassword(String password) {
		_password = password;
	}
	public boolean getStatus() {
		return _status;
	}
	public void setStatus(boolean status) {
		_status = status;
	}
	public int getCreatedBy() {
		return _createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this._createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return _createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this._createdDate = createdDate;
	}
	public int getLastModifiedBy() {
		return _lastModifiedBy;
	}
	public void setLastModifiedBy(int lastModifiedBy) {
		this._lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this._lastModifiedDate = lastModifiedDate;
	}
}
