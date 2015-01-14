package com.etohospital.model;

import java.util.Date;

import com.etohospital.dao.utils.TablePrimaryKeyAnnotation;

@TablePrimaryKeyAnnotation(TableName="HealthConsultant", PrimaryKey="HealthConsultantID")
public class HealthConsultantModel {
	
	private int _healthConsultantID;
	private int	_userID;
	private String _firstName;
	private String _lastName;
	private String _fullName;
	private int _sex;
	private int _age;
	private String _province;
	private String _city;
	private String _mobilePhone;
	private String _QQ;
	private String _email;
	private String _weixin;
	private int _createdBy;
	private Date _createdDate = null;
	private int _lastModifiedBy;
	private Date _lastModifiedDate = null;
	private byte _status = 1;
	private byte _enabled = 1;
	
	public int getHealthConsultantID() {
		return _healthConsultantID;
	}
	public void setHealthConsultantID(int healthConsultantID) {
		_healthConsultantID = healthConsultantID;
	}
	public int getUserID() {
		return _userID;
	}
	public void setUserID(int userID) {
		_userID = userID;
	}
	public String getFirstName() {
		return _firstName;
	}
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}
	public String getLastName() {
		return _lastName;
	}
	public void setLastName(String lastName) {
		_lastName = lastName;
	}
	public String getFullName() {
		return _fullName;
	}
	public void setFullName(String fullName) {
		_fullName = fullName;
	}
	public int getSex() {
		return _sex;
	}
	public void setSex(int sex) {
		_sex = sex;
	}
	public int getAge() {
		return _age;
	}
	public void setAge(int age) {
		_age = age;
	}
	public String getProvince() {
		return _province;
	}
	public void setProvince(String province) {
		_province = province;
	}
	public String getCity() {
		return _city;
	}
	public void setCity(String city) {
		_city = city;
	}
	public String getMobilePhone() {
		return _mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}
	public String getQQ() {
		return _QQ;
	}
	public void setQQ(String qQ) {
		_QQ = qQ;
	}
	public String getEmail() {
		return _email;
	}
	public void setEmail(String email) {
		_email = email;
	}
	public String getWeixin() {
		return _weixin;
	}
	public void setWeixin(String weixin) {
		_weixin = weixin;
	}
	public int getCreatedBy() {
		return _createdBy;
	}
	public void setCreatedBy(int createdBy) {
		_createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return _createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}
	public int getLastModifiedBy() {
		return _lastModifiedBy;
	}
	public void setLastModifiedBy(int lastModifiedBy) {
		_lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		_lastModifiedDate = lastModifiedDate;
	}
	public byte getStatus() {
		return _status;
	}
	public void setStatus(byte status) {
		_status = status;
	}
	public byte getEnabled() {
		return _enabled;
	}
	public void setEnabled(byte enabled) {
		_enabled = enabled;
	}
}
