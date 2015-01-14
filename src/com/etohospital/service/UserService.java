package com.etohospital.service;

import java.util.List;

import com.etohospital.model.UserModel;

public interface UserService {
	
	int insertUser(UserModel user, int userId) throws Exception;	
	int updateUser(UserModel user, int userId) throws Exception;
	int deleteUser(UserModel user, int userId) throws Exception;
	List<UserModel> getUser(UserModel user, int userId) throws Exception;
	
	/**
	 * 用户登陆
	 * @param user
	 * @return 返回用户的详细信息
	 * @throws Exception
	 */
	UserModel login(UserModel user) throws Exception;
	
	/**
	 * 检查用户是否已经授权
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	boolean auth(int userId) throws Exception;
	
	/**
	 * 用户退出
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean logout(UserModel user) throws Exception;
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean register(UserModel user) throws Exception;
}
