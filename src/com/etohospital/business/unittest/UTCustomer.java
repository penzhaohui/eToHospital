package com.etohospital.business.unittest;

import java.util.Date;

import com.etohospital.business.CustomerBusiness;
import com.etohospital.model.CustomerModel;
import com.etohospital.service.CustomerService;

public class UTCustomer {
	
	public static void main(String[] args) {
		CustomerModel customer = new CustomerModel();
		int customerID = 5;
		int userID = 5;
		String firstName = "Peter";
		String lastName = "Peng";
		String fullName = "Peter.Peng";
		int sex = 1;
		int age = 30;
		String province = "Hunan";
		String city = "Xiangxiang";
		String mobilePhone = "18566751849";
		String QQ = "451127509";
		String email = "peter.peng@beyondsoft.com";
		String weixin = "pen_zhaohui";
		int createdBy = 1;
		Date createdDate = new Date();// ;
		createdDate.setYear(2014);
		createdDate.setMonth(1);
		createdDate.setMonth(1);
		int lastModifiedBy = 1;;
		Date lastModifiedDate = new Date();// ;
		lastModifiedDate.setYear(2014);
		lastModifiedDate.setMonth(1);
		lastModifiedDate.setMonth(1);
		boolean status = true;
		boolean enabled = true;
		
		//customer.setCustomerID(customerID);
		customer.setUserID(userID);			
		customer.setFirstName(firstName);		
		customer.setLastName(lastName);
		customer.setFullName(fullName);	
		customer.setSex(sex);
		customer.setAge(age);
		customer.setProvince(province);
		customer.setCity(city);
		customer.setMobilePhone(mobilePhone);
		customer.setQQ(QQ);
		customer.setEmail(email);
		customer.setWeixin(weixin);
		customer.setCreatedBy(createdBy);
		customer.setCreatedDate(createdDate);
		customer.setLastModifiedBy(lastModifiedBy);
		customer.setLastModifiedDate(lastModifiedDate);
		customer.setStatus(status);
		customer.setEnabled(enabled);
		
		CustomerService customerBusiness = CustomerBusiness.getSingleton();
		try {
			//customerBusiness.insertCustomer(customer, 1);
					
			//customer = new CustomerModel();
			//customer.setCustomerID(5);
			//customerBusiness.getCustomer(customer, 5);
			
			customer = new CustomerModel();
			customerBusiness.getCustomer(customer, 5);
			
			//customer = new CustomerModel();
			//customer.setFirstName(firstName);		
			//customer.setLastName(lastName);
			//customer.setFullName(fullName);	
			//customerBusiness.getCustomer(customer, 5);
			
			//customer = new CustomerModel();
			//customer.setCustomerID(5);
			//customer.setFullName("Tester");
			//customerBusiness.updateCustomer(customer, 2);
			
			//customer = new CustomerModel();
			//customerBusiness.updateCustomer(customer, 2);
			
			//customer = new CustomerModel();
			//customer.setCustomerID(5);
			//customerBusiness.deleteCustomer(customer, 2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
