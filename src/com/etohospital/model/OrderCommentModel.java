package com.etohospital.model;

import java.util.Date;

import com.etohospital.dao.utils.TablePrimaryKeyAnnotation;

@TablePrimaryKeyAnnotation(TableName="OrderComment", PrimaryKey="OrderCommentID")
public class OrderCommentModel {
	
	private int _orderCommentID;
	private int _orderID;
	private int _star;
	private String _comment;
	private int _createdBy;
	private Date _createdDate = null;
	
	public int getOrderCommentID() {
		return _orderCommentID;
	}
	public void getOrderCommentID(int _orderCommentID) {
		this._orderCommentID = _orderCommentID;
	}
	public int getOrderID() {
		return _orderID;
	}
	public void setOrderID(int orderID) {
		_orderID = orderID;
	}
	public int getStar() {
		return _star;
	}
	public void setStar(int star) {
		_star = star;
	}
	public String getComment() {
		return _comment;
	}
	public void setComment(String comment) {
		_comment = comment;
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
}
