package com.etohospital.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etohospital.dao.OrderDAO;
import com.etohospital.dao.mysql.OrderDAOMySQL;
import com.etohospital.model.OrderModel;
import com.etohospital.service.OrderService;

public class OrderBusiness implements OrderService {

	private static Logger logger = LoggerFactory.getLogger(OrderService.class);
	private static OrderDAO orderDAO = new OrderDAOMySQL();
	
	// 以下代码确保客户端必须完全遵循接口中定义的方法
	private volatile static OrderService singleton;
	private OrderBusiness(){};
	public static OrderService getSingleton() {
		if (singleton == null) {
			synchronized (OrderBusiness.class) {
				if (singleton == null) {
					singleton = new OrderBusiness();
				}
			}
		}		
		return singleton;
	}
	
	@Override
	public int insertOrder(OrderModel order, int userId) throws Exception {
		
		if(order.getOrderID() > 1)
		{
			throw new IllegalArgumentException("Invalid order id value.");
		}
		
		int effectedRows = orderDAO.insertOrder(order, userId);
		
		if(logger.isDebugEnabled())
		{
			List<OrderModel> orders = orderDAO.getOrder(order, userId);
			logger.debug("Insert one order, the order id: " + orders.get(0).getOrderID());
		}
		
		return effectedRows;
	}

	@Override
	public int updateOrder(OrderModel order, int userId) throws Exception {
		
		if(order.getOrderID() < 1)
		{
			throw new IllegalArgumentException("Invalid order id value.");
		}
		
		int effectedRows = orderDAO.updateOrder(order, userId);
		
		if(logger.isDebugEnabled())
		{
			logger.debug("Update one order, the order id: " + order.getOrderID());
		}
		
		return effectedRows;
	}

	@Override
	public int deleteOrder(OrderModel order, int userId) throws Exception {
		
		if(order.getOrderID() < 1)
		{
			throw new IllegalArgumentException("Invalid order id value.");
		}
		
		int effectedRows = orderDAO.deleteOrder(order, userId);
		
		if(logger.isDebugEnabled())
		{
			logger.debug("Delete one order, the order id: " + order.getOrderID());
		}
		
		return effectedRows;
	}

	@Override
	public List<OrderModel> getOrder(OrderModel order, int userId) throws Exception {
		
		List<OrderModel> orders = orderDAO.getOrder(order, userId);
		
		if(logger.isDebugEnabled())
		{			
			if(orders == null)
			{
				logger.debug("No one order found, the query order model: " + order.toString());
			}
			else
			{
				logger.debug(orders.size() + " orders found, the query order model: " + order.toString());
			}		
		}
		
		return orders;
	}

}
