package com.etohospital.dao;

import java.util.List;

import com.etohospital.model.CustomerModel;

public interface CustomerDAO {
	
	int insertCustomer(CustomerModel customer, int userId) throws Exception;	
	int updateCustomer(CustomerModel customer, int userId) throws Exception;
	int deleteCustomer(CustomerModel customer, int userId) throws Exception;
	List<CustomerModel> getCustomer(CustomerModel customer, int userId) throws Exception;
}
