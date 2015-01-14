package com.etohospital.dao;

import java.util.List;

import com.etohospital.model.UserModel;

public interface UserDAO {

	int insertUser(UserModel user, int userId) throws Exception;	
	int updateUser(UserModel user, int userId) throws Exception;
	int deleteUser(UserModel user, int userId) throws Exception;
	List<UserModel> getUser(UserModel user, int userId) throws Exception;
}
