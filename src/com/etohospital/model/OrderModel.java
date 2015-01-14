package com.etohospital.model;

import java.util.Date;

import com.etohospital.dao.utils.TablePrimaryKeyAnnotation;

@TablePrimaryKeyAnnotation(TableName="Order", PrimaryKey="OrderID")
public class OrderModel {

	private int _orderID;
	private int _customerID;
	private int _healthConsultantID;
	private int _doctorID;
	private String _illnessName;
	private String _illnessDescription;
	private Date _expectedDate = null;
	private String _customerProvince;
	private String _customerCity;
	private String _customerAddress;
	private Date _bookedDate = null;
	private String _bookedHospitalName;
	private String _bookedHospitalAddress;
	private double _guarantyFee;
	private int _createdBy;
	private Date _createdDate = null;
	private int _lastModifiedBy;
	private Date _lastModifiedDate = null;
	private String _orderStatus;
	private byte _enabled = 1;
	
	
	public int getOrderID() {
		return _orderID;
	}
	public void setOrderID(int orderID) {
		_orderID = orderID;
	}
	public int getCustomerID() {
		return _customerID;
	}
	public void setCustomerID(int customerID) {
		_customerID = customerID;
	}
	public int getHealthConsultantID() {
		return _healthConsultantID;
	}
	public void setHealthConsultantID(int healthConsultantID) {
		_healthConsultantID = healthConsultantID;
	}
	public int getDoctorID() {
		return _doctorID;
	}
	public void setDoctorID(int doctorID) {
		_doctorID = doctorID;
	}
	public String getIllnessName() {
		return _illnessName;
	}
	public void setIllnessName(String illnessName) {
		_illnessName = illnessName;
	}
	public String getIllnessDescription() {
		return _illnessDescription;
	}
	public void setIllnessDescription(String illnessDescription) {
		_illnessDescription = illnessDescription;
	}
	public Date getExpectedDate() {
		return _expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		_expectedDate = expectedDate;
	}
	public String getCustomerProvince() {
		return _customerProvince;
	}
	public void setCustomerProvince(String customerProvince) {
		_customerProvince = customerProvince;
	}
	public String getCustomerCity() {
		return _customerCity;
	}
	public void setCustomerCity(String customerCity) {
		_customerCity = customerCity;
	}
	public String getCustomerAddress() {
		return _customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		_customerAddress = customerAddress;
	}
	public Date getBookedDate() {
		return _bookedDate;
	}
	public void setBookedDate(Date bookedDate) {
		_bookedDate = bookedDate;
	}
	public String getBookedHospitalName() {
		return _bookedHospitalName;
	}
	public void setBookedHospitalName(String bookedHospitalName) {
		_bookedHospitalName = bookedHospitalName;
	}
	public String getBookedHospitalAddress() {
		return _bookedHospitalAddress;
	}
	public void setBookedHospitalAddress(String bookedHospitalAddress) {
		_bookedHospitalAddress = bookedHospitalAddress;
	}
	public double getGuarantyFee() {
		return _guarantyFee;
	}
	public void setGuarantyFee(double guarantyFee) {
		_guarantyFee = guarantyFee;
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
	public String getOrderStatus() {
		return _orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		_orderStatus = orderStatus;
	}
	public byte getEnabled() {
		return _enabled;
	}
	public void setEnabled(byte enabled) {
		_enabled = enabled;
	}
	
}
