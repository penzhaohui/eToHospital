package com.etohospital.dao;

import java.util.List;

import com.etohospital.model.OrderModel;

public interface OrderDAO {

	int insertOrder(OrderModel order, int userId) throws Exception;	
	int updateOrder(OrderModel order, int userId) throws Exception;
	int deleteOrder(OrderModel order, int userId) throws Exception;
	List<OrderModel> getOrder(OrderModel order, int userId) throws Exception;
	
}
