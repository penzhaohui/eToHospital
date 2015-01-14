package com.etohospital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.etohospital.dao.utils.SQLConditionModel;
import com.etohospital.dao.utils.SQLType;

public interface BaseDAO<T> {
	
	Connection getConnection() throws Exception;
	ResultSet executeQuery(String sql) throws Exception;
	ResultSet executeQuery(String sql, Object[] paramters) throws Exception;
	int executeUpdate(String sql, Object[] paramters) throws Exception;
	void closeAll() throws Exception;
	
	int setMaxKey(T instance, int userId) throws Exception;
	int genericInsert(T instance, int userId) throws Exception;
	int genericUpdate(T instance, int userId) throws Exception;
	int genericDelete(T instance, int userId) throws Exception;
	List<T> genericQuery(T instance, int userId) throws Exception;
	SQLConditionModel generateSQLConditionModel(SQLType type, T object,	int userId) throws Exception;
	
}
