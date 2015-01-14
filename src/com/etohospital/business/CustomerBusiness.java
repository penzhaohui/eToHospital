package com.etohospital.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etohospital.dao.CustomerDAO;
import com.etohospital.dao.mysql.CustomerDAOMySQL;
import com.etohospital.model.CustomerModel;
import com.etohospital.service.CustomerService;

public class CustomerBusiness implements CustomerService {

	private static Logger logger = LoggerFactory.getLogger(CustomerService.class);	
	private static CustomerDAO customerDAO = new CustomerDAOMySQL();
	
	// 以下代码确保客户端必须完全遵循接口中定义的方法
	private volatile static CustomerService singleton;
	private CustomerBusiness(){};
	public static CustomerService getSingleton() {
		if (singleton == null) {
			synchronized (CustomerBusiness.class) {
				if (singleton == null) {
					singleton = new CustomerBusiness();
				}
			}
		}		
		return singleton;
	}
	
	@Override
	public int insertCustomer(CustomerModel customer, int userId) throws Exception {
		
		if(customer.getCustomerID() > 0)
		{
			throw new IllegalArgumentException("Invalid customer id value.");
		}
		
		int effectedRows = customerDAO.insertCustomer(customer, userId);
		
		if(logger.isDebugEnabled())
		{
			List<String> sqlFields = new ArrayList<String>();
			sqlFields.add("CustomerId");
			List<CustomerModel> customers = customerDAO.getCustomer(customer, userId);
			logger.debug("Insert one customer, the customers id: " + customers.get(0).getCustomerID());
		}
		
		return effectedRows;
	}

	@Override
	public int updateCustomer(CustomerModel customer, int userId) throws Exception {
		
		if(customer.getCustomerID() < 1)
		{
			throw new IllegalArgumentException("Invalid customer id value.");
		}
		
		int effectedRows = customerDAO.updateCustomer(customer, userId);
		
		if(logger.isDebugEnabled())
		{
			logger.debug("Update one customer, the customers id: " + customer.getCustomerID());
		}
		
		return effectedRows;
	}

	@Override
	public int deleteCustomer(CustomerModel customer, int userId) throws Exception {
		
		if(customer.getCustomerID() < 1)
		{
			throw new IllegalArgumentException("Invalid customer id value.");
		}
		
		int effectedRows = customerDAO.deleteCustomer(customer, userId);
		
		if(logger.isDebugEnabled())
		{
			logger.debug("Delete one customer, the customers id: " + customer.getCustomerID());
		}
		
		return effectedRows;
	}

	@Override
	public List<CustomerModel> getCustomer(CustomerModel customer, int userId) throws Exception {
		
		List<CustomerModel> customers = customerDAO.getCustomer(customer, userId);
		
		if(logger.isDebugEnabled())
		{			
			if(customers == null)
			{
				logger.debug("No one customer found, the query customer model: " + customer.toString());
			}
			else
			{
				logger.debug(customers.size() + " customers found, the query customer model: " + customer.toString());
			}		
		}
		
		return customers;
	}

}
