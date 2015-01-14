package com.etohospital.dao.mysql;

import java.util.List;

import com.etohospital.dao.OrderCommentDAO;
import com.etohospital.model.OrderCommentModel;

public class OrderCommentDAOMySQL extends BaseDAOMySQL<OrderCommentModel> implements OrderCommentDAO{
	
	@Override
	public int insertOrderComment(OrderCommentModel orderComment, int userId) throws Exception {
		
		return genericInsert(orderComment, userId);
	}

	@Override
	public int updateOrderComment(OrderCommentModel orderComment, int userId) throws Exception {
		
		return genericUpdate(orderComment, userId);
	}

	@Override
	public int deleteOrderComment(OrderCommentModel orderComment, int userId) throws Exception {
		
		return genericDelete(orderComment, userId);
	}

	@Override
	public List<OrderCommentModel> getOrderComment(
			OrderCommentModel orderComment, int userId) throws Exception {
		
		return genericQuery(orderComment, userId);
	}
}
