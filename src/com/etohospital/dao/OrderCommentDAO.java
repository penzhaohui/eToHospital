package com.etohospital.dao;

import java.util.List;

import com.etohospital.model.OrderCommentModel;

public interface OrderCommentDAO {
	
	int insertOrderComment(OrderCommentModel orderComment, int userId) throws Exception;	
	int updateOrderComment(OrderCommentModel orderComment, int userId) throws Exception;
	int deleteOrderComment(OrderCommentModel orderComment, int userId) throws Exception;
	List<OrderCommentModel> getOrderComment(OrderCommentModel orderComment, int userId) throws Exception;
}
