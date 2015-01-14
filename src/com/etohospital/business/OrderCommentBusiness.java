package com.etohospital.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etohospital.dao.OrderCommentDAO;
import com.etohospital.dao.mysql.OrderCommentDAOMySQL;
import com.etohospital.model.OrderCommentModel;
import com.etohospital.service.OrderCommentService;

public class OrderCommentBusiness implements OrderCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(OrderCommentService.class);
	private static OrderCommentDAO orderCommentDAO = new OrderCommentDAOMySQL();
	
	// 以下代码确保客户端必须完全遵循接口中定义的方法
	private volatile static OrderCommentService singleton;
	private OrderCommentBusiness(){};
	public static OrderCommentService getSingleton() {
		if (singleton == null) {
			synchronized (OrderCommentBusiness.class) {
				if (singleton == null) {
					singleton = new OrderCommentBusiness();
				}
			}
		}		
		return singleton;
	}
	
	@Override
	public int insertOrderComment(OrderCommentModel orderComment, int userId) throws Exception {

		if(orderComment.getOrderCommentID() > 0)
		{
			throw new IllegalArgumentException("Invalid order comment id value.");
		}
		
		int effectedRows = orderCommentDAO.insertOrderComment(orderComment, userId);
		
		if(logger.isDebugEnabled())
		{
			List<OrderCommentModel> orderComments = orderCommentDAO.getOrderComment(orderComment, userId);
			logger.debug("Insert one order comment, the order comment id: " + orderComments.get(0).getOrderCommentID());
		}
		
		return effectedRows;
	}

	@Override
	public int updateOrderComment(OrderCommentModel orderComment, int userId) throws Exception {
		
		if(orderComment.getOrderCommentID() < 1)
		{
			throw new IllegalArgumentException("Invalid order comment id value.");
		}
		
		int effectedRows = orderCommentDAO.updateOrderComment(orderComment, userId);
		
		if(logger.isDebugEnabled())
		{			
			logger.debug("Update one order comment, the order comment id: " + orderComment.getOrderCommentID());
		}
		
		return effectedRows;
	}

	@Override
	public int deleteOrderComment(OrderCommentModel orderComment, int userId) throws Exception {

		if(orderComment.getOrderCommentID() < 1)
		{
			throw new IllegalArgumentException("Invalid order comment id value.");
		}
		
		int effectedRows = orderCommentDAO.deleteOrderComment(orderComment, userId);
		
		if(logger.isDebugEnabled())
		{			
			logger.debug("Delete one order comment, the order comment id: " + orderComment.getOrderCommentID());
		}
		
		return effectedRows;
	}

	@Override
	public List<OrderCommentModel> getOrderComment (
			OrderCommentModel orderComment, int userId)  throws Exception {
		
		List<OrderCommentModel> orderComments = orderCommentDAO.getOrderComment(orderComment, userId);
		
		if(logger.isDebugEnabled())
		{			
			if(orderComments == null)
			{
				logger.debug("No one order comment found, the query order comment model: " + orderComment.toString());
			}
			else
			{
				logger.debug(orderComments.size() + " order comments found, the query order comment model: " + orderComment.toString());
			}		
		}
		
		return orderComments;
	}

}
