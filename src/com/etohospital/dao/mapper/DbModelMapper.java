package com.etohospital.dao.mapper;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DbModelMapper<T> implements IDbModelAdapter<T> {

	@Override
	public List<T> constuctModelListFromResultSet(Class<T> classType, ResultSet rs)
			throws Exception {
		
		List<T> results = new ArrayList<T>();
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		
    	Method method = null;
    	String propertyName = "";
    	T instance = null;
		
		// 从前往后的移动结果集指针，处理每条记录
		while (rs.next()){
			
			instance = classType.newInstance();
			
			// 每条记录都包含columnCount个列
			for (int i=1; i < columnCount; i++){
				// 由于不知道该列的类型，所以用getObject方法获取值
				propertyName = md.getColumnName(i);
				method = classType.getDeclaredMethod("get" + propertyName, null);				
				method = classType.getDeclaredMethod("set" + propertyName, method.getReturnType());					
				method.invoke(instance, rs.getObject(i));
			}
			
			results.add(instance);
		}
		
		return results;
	}

}
