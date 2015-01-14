package com.etohospital.service;

import java.util.List;

import com.etohospital.model.OrderPaymentModel;

public interface OrderPaymentService {

	int insertOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception;	
	int updateOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception;
	int deleteOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception;
	List<OrderPaymentModel> getOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception;
}
