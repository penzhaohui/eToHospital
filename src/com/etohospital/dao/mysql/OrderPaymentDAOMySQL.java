package com.etohospital.dao.mysql;

import java.util.List;

import com.etohospital.dao.OrderPaymentDAO;
import com.etohospital.model.OrderPaymentModel;

public class OrderPaymentDAOMySQL extends BaseDAOMySQL<OrderPaymentModel> implements OrderPaymentDAO {
	
	@Override
	public int insertOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception {
		
		return genericInsert(orderPayment, userId);
	}

	@Override
	public int updateOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception {
		
		return genericUpdate(orderPayment, userId);
	}

	@Override
	public int deleteOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception {
		
		return genericDelete(orderPayment, userId);
	}

	@Override
	public List<OrderPaymentModel> getOrderPayment(
			OrderPaymentModel orderPayment, int userId) throws Exception {
		
		return genericQuery(orderPayment, userId);
	}
}
