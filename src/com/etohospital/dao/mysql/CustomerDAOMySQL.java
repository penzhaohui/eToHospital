package com.etohospital.dao.mysql;

import java.util.List;

import com.etohospital.dao.CustomerDAO;
import com.etohospital.model.CustomerModel;

public class CustomerDAOMySQL extends BaseDAOMySQL<CustomerModel> implements CustomerDAO {
	
	@Override
	public int insertCustomer(CustomerModel customer, int userId) throws Exception {
		
		return genericInsert(customer, userId);
	}

	@Override
	public int updateCustomer(CustomerModel customer, int userId) throws Exception {
		
		return genericUpdate(customer, userId);
	}

	@Override
	public int deleteCustomer(CustomerModel customer, int userId) throws Exception {		
		
		return genericDelete(customer, userId);
	}

	@Override
	public List<CustomerModel> getCustomer(CustomerModel customer, int userId) throws Exception {
		
		return genericQuery(customer, userId);
	}	
}
