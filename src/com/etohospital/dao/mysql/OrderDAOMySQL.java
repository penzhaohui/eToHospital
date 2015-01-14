package com.etohospital.dao.mysql;

import java.util.List;

import com.etohospital.dao.OrderDAO;
import com.etohospital.model.OrderModel;

public class OrderDAOMySQL extends BaseDAOMySQL<OrderModel> implements OrderDAO{
	
	@Override
	public int insertOrder(OrderModel order, int userId) throws Exception {
		
		return genericInsert(order, userId);
	}

	@Override
	public int updateOrder(OrderModel order, int userId) throws Exception {
		
		return genericUpdate(order, userId);
	}

	@Override
	public int deleteOrder(OrderModel order, int userId) throws Exception {
		
		return genericDelete(order, userId);
	}

	@Override
	public List<OrderModel> getOrder(OrderModel order, int userId) throws Exception {
		
		return genericQuery(order, userId);
	}
}
