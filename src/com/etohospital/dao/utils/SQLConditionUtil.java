package com.etohospital.dao.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SQLConditionUtil {

	private static Logger logger = LoggerFactory.getLogger(SQLConditionUtil.class);
	
	public static <T> SQLConditionModel GenerateSQLCondition(Class<T> T, final Object object, final SQLType type) throws Exception
	{
		Class<? extends Object> classType = object.getClass();
		String tableName = "";
		String primaryKey = "";
		if(classType.isAnnotationPresent(TablePrimaryKeyAnnotation.class))
		{
			TablePrimaryKeyAnnotation annotation = (TablePrimaryKeyAnnotation)classType.getAnnotation(TablePrimaryKeyAnnotation.class);
			tableName = annotation.TableName();
			primaryKey = annotation.PrimaryKey();
		}
		else
		{
			throw new Exception("Invalid Model");
		}		
		
		SQLConditionModel sqlCondition = new SQLConditionModel(tableName, primaryKey, type);
		
		if(type == SQLType.MaxKey)
		{
			
		}
		else
		{		
			List<String> allPropertyNames = sqlCondition.getAllPropertyNames();
			List<String> propertyNames =  sqlCondition.getPropertyNames();
			List<Object> propertyValues = sqlCondition.getPropertyValues();
			List<Class> returnTypes = sqlCondition.getReturnTypes();
					
			
			//T instance = (T) Class.forName(T.getName());
			T instance = T.newInstance();
			
			String fieldName = "";
			String propertyName = "";
			Object propertyValue1 = null;
			Object propertyValue2 = null;
			Class<?> returnType = null;
			Method method = null;
			
			boolean hasPrimaryKeyValue = false;
			if(type == SQLType.Delete || type == SQLType.Select)
			{
				try
				{
					propertyName = primaryKey;
					method = classType.getDeclaredMethod("get"+propertyName, null);
					propertyValue1 = method.invoke(object, null);
					propertyValue2 = method.invoke(instance, null);	
				}
				catch(Exception ex)
				{
					logger.error("One critical error occurs when retriving property values of " + classType.getName());
					throw new Exception();
				}
				
				if(propertyValue1 != null && !propertyValue1.equals(propertyValue2))
				{
					propertyNames.add(propertyName);
					propertyValues.add(propertyValue1);
					returnTypes.add(propertyValue1.getClass());
					hasPrimaryKeyValue = true;
					
					Field[] fields = classType.getDeclaredFields();			
					for(Field field : fields)
					{
						fieldName = field.getName();
						returnType = field.getType();
						propertyName = getPropertyName(fieldName);
						
						allPropertyNames.add(propertyName);
					}
				}			
			}
			
			if(hasPrimaryKeyValue == false)
			{		
				Field[] fields = classType.getDeclaredFields();			
				for(Field field : fields)
				{
					fieldName = field.getName();
					returnType = field.getType();
					propertyName = getPropertyName(fieldName);
					
					allPropertyNames.add(propertyName);
					
					try
					{
						method = classType.getDeclaredMethod("get"+propertyName, null);
						propertyValue1 = method.invoke(object, null);
						method = T.getDeclaredMethod("get"+propertyName, null);
						propertyValue2 = method.invoke(instance, null);	
					}
					catch(Exception ex)
					{
						logger.error("One critical error occurs when retriving property values of " + classType.getName());
						throw new Exception();
					}
					
					if(propertyValue1 == null || propertyValue1.equals(propertyValue2))
					{
						continue;
					}
					
					propertyNames.add(propertyName);
					propertyValues.add(propertyValue1);
					returnTypes.add(returnType);
				}
			}
		}
		
		sqlCondition.GenerateSQL();
		
		return sqlCondition;
	}
	
	//public static List<?> retriveObjectFromResultset(Class<? extends Object> classType, ResultSet rs) throws Exception
	public static List<?> retriveObjectFromResultset(Object instance, ResultSet rs) throws Exception
	{
		Class<? extends Object> classType = instance.getClass();
		List<Object> results = new ArrayList<Object>();
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();

    	Method method = null;
    	String propertyName = "";
    	Object object = null;
		
		// 从前往后的移动结果集指针，处理每条记录
		while (rs.next()){
			
			instance = classType.forName(classType.getName());
			
			// 每条记录都包含columnCount个列
			for (int i=1; i < columnCount; i++){
				// 由于不知道该列的类型，所以用getObject方法获取值
				propertyName = md.getColumnName(i);
				method = classType.getDeclaredMethod("get" + propertyName, null);				
				method = classType.getDeclaredMethod("set" + propertyName, method.getReturnType());			
				method.invoke(instance, 1);
				method.invoke(instance, rs.getObject(i));
			}
			
			results.add(object);
		}
		
		return results;
	}
	
	/**
	 * Get the property name, such as CustomerId
	 * 
	 * @param fieldName its pattern like "_customerId"
	 * @return
	 */
	private static String getPropertyName(String fieldName)
	{
		String propertyName = "";
		
		char[] temp = fieldName.toCharArray();
		
		if(temp[1] >= 'a' && temp[1] <= 'z')
		{
			temp[1] -= 32;
		}
		
		propertyName = String.valueOf(temp, 1, temp.length - 1);
		
		return propertyName;
	}
	
	public static void setPropertyValue(Object instance, String propertyName, int propertyValue) throws Exception
	{
		Class<? extends Object> classType = instance.getClass();
		Method method = classType.getDeclaredMethod("set"+propertyName, int.class);
		method.invoke(instance, propertyValue);
	}
}

