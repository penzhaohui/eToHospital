package com.etohospital.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etohospital.dao.OrderPaymentDAO;
import com.etohospital.dao.mysql.OrderPaymentDAOMySQL;
import com.etohospital.model.OrderPaymentModel;
import com.etohospital.service.OrderPaymentService;

public class OrderPaymentBusiness implements OrderPaymentService {

	private static Logger logger = LoggerFactory.getLogger(OrderPaymentService.class);
	private static OrderPaymentDAO orderPaymentDAO = new OrderPaymentDAOMySQL();
	
	// 以下代码确保客户端必须完全遵循接口中定义的方法
	private volatile static OrderPaymentService singleton;
	private OrderPaymentBusiness(){};
	public static OrderPaymentService getSingleton() {
		if (singleton == null) {
			synchronized (OrderPaymentBusiness.class) {
				if (singleton == null) {
					singleton = new OrderPaymentBusiness();
				}
			}
		}		
		return singleton;
	}
	
	@Override
	public int insertOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception {

		if(orderPayment.getOrderPaymentID() > 0)
		{
			throw new IllegalArgumentException("Invalid order payment id value.");
		}
		
		int effectedRows = orderPaymentDAO.insertOrderPayment(orderPayment, userId);
		
		if(logger.isDebugEnabled())
		{
			List<OrderPaymentModel> orderPayments = orderPaymentDAO.getOrderPayment(orderPayment, userId);
			logger.debug("Insert one order payment, the order payment id: " + orderPayments.get(0).getOrderPaymentID());
		}
		
		return effectedRows;
	}

	@Override
	public int updateOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception {

		if(orderPayment.getOrderPaymentID() < 1)
		{
			throw new IllegalArgumentException("Invalid order payment id value.");
		}
		
		int effectedRows = orderPaymentDAO.updateOrderPayment(orderPayment, userId);
		
		if(logger.isDebugEnabled())
		{			
			logger.debug("Update one order payment, the order payment id: " + orderPayment.getOrderPaymentID());
		}
		
		return effectedRows;
	}

	@Override
	public int deleteOrderPayment(OrderPaymentModel orderPayment, int userId) throws Exception {

		if(orderPayment.getOrderPaymentID() < 1)
		{
			throw new IllegalArgumentException("Invalid order payment id value.");
		}
		
		int effectedRows = orderPaymentDAO.deleteOrderPayment(orderPayment, userId);
		
		if(logger.isDebugEnabled())
		{			
			logger.debug("Delete one order payment, the order payment id: " + orderPayment.getOrderPaymentID());
		}
		
		return effectedRows;
	}

	@Override
	public List<OrderPaymentModel> getOrderPayment(
			OrderPaymentModel orderPayment, int userId) throws Exception {
		
		List<OrderPaymentModel> orderPayments = orderPaymentDAO.getOrderPayment(orderPayment, userId);
		
		if(logger.isDebugEnabled())
		{			
			if(orderPayments == null)
			{
				logger.debug("No one order payment found, the query order payment model: " + orderPayment.toString());
			}
			else
			{
				logger.debug(orderPayments.size() + " order payments found, the query order payment model: " + orderPayment.toString());
			}		
		}
		
		return orderPayments;
	}

}
