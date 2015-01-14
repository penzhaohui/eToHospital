package com.etohospital.service;

import java.util.List;

import com.etohospital.model.UserModel;

public interface UserService {
	
	int insertUser(UserModel user, int userId) throws Exception;	
	int updateUser(UserModel user, int userId) throws Exception;
	int deleteUser(UserModel user, int userId) throws Exception;
	List<UserModel> getUser(UserModel user, int userId) throws Exception;
	
	/**
	 * �û���½
	 * @param user
	 * @return �����û�����ϸ��Ϣ
	 * @throws Exception
	 */
	UserModel login(UserModel user) throws Exception;
	
	/**
	 * ����û��Ƿ��Ѿ���Ȩ
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	boolean auth(int userId) throws Exception;
	
	/**
	 * �û��˳�
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean logout(UserModel user) throws Exception;
	
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean register(UserModel user) throws Exception;
}
