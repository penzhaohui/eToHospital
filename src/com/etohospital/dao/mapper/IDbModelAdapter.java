package com.etohospital.dao.mapper;

import java.sql.ResultSet;
import java.util.List;

//Java�еķ��ͷ��� : http://www.cnblogs.com/iyangyuan/archive/2013/04/09/3011274.html
public interface IDbModelAdapter<T> {
	List<T> constuctModelListFromResultSet(Class<T> classType, ResultSet rs) throws Exception;
}
