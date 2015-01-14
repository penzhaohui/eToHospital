package com.etohospital.model;

import java.util.Date;

import com.etohospital.dao.utils.TablePrimaryKeyAnnotation;

@TablePrimaryKeyAnnotation(TableName="OrderPayment", PrimaryKey="OrderPaymentID")
public class OrderPaymentModel {
	
	private int _orderPaymentID;
	private int _orderID;
	private double _paymentAmount;
	private String _paymentStatus;
	private byte _status = 1;
	private int _createdBy;
	private Date _createdDate = null;
	private int _lastModifiedBy;
	private Date _lastModifiedDate = null;
	
	
	public int getOrderPaymentID() {
		return _orderPaymentID;
	}
	public void setOrderPaymentID(int _orderPaymentID) {
		this._orderPaymentID = _orderPaymentID;
	}
	public int getOrderID() {
		return _orderID;
	}
	public void setOrderID(int orderID) {
		_orderID = orderID;
	}
	public double getPaymentAmount() {
		return _paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		_paymentAmount = paymentAmount;
	}
	public String getPaymentStatus() {
		return _paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		_paymentStatus = paymentStatus;
	}
	public byte getStatus() {
		return _status;
	}
	public void setStatus(byte status) {
		_status = status;
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
}
