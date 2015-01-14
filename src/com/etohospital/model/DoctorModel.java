package com.etohospital.model;

import java.util.Date;

import com.etohospital.dao.utils.TablePrimaryKeyAnnotation;

@TablePrimaryKeyAnnotation(TableName="Doctor", PrimaryKey="DoctorID")
public class DoctorModel {
	
	private int _doctorID;
	private int _userID;
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
	private String _hospital;
	private String _hospitalAddress;
	private String _illnessCategory;
	private String _sSkillRank;
	private String _resume;
	private int _createdBy;
	private Date _createdDate = null;
	private int _lastModifiedBy;
	private Date _lastModifiedDate = null;
	private int _status;
	private byte _enabled = 1;
	
	public int getDoctorID() {
		return _doctorID;
	}
	public void setDoctorID(int doctorID) {
		_doctorID = doctorID;
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
	public String getHospital() {
		return _hospital;
	}
	public void setHospital(String hospital) {
		_hospital = hospital;
	}
	public String getHospitalAddress() {
		return _hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		_hospitalAddress = hospitalAddress;
	}
	public String getIllnessCategory() {
		return _illnessCategory;
	}
	public void setIllnessCategory(String illnessCategory) {
		_illnessCategory = illnessCategory;
	}
	public String getSkillRank() {
		return _sSkillRank;
	}
	public void setSkillRank(String skillRank) {
		_sSkillRank = skillRank;
	}
	public String getResume() {
		return _resume;
	}
	public void setResume(String resume) {
		_resume = resume;
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
	public int getStatus() {
		return _status;
	}
	public void setStatus(int status) {
		_status = status;
	}
	public byte getEnabled() {
		return _enabled;
	}
	public void setEnabled(byte enabled) {
		_enabled = enabled;
	}		
}
