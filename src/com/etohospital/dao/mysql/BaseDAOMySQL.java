package com.etohospital.dao.mysql;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etohospital.dao.BaseDAO;
import com.etohospital.dao.mapper.DbModelMapper;
import com.etohospital.dao.mapper.IDbModelAdapter;
import com.etohospital.dao.utils.DbConnectMgr;
import com.etohospital.dao.utils.DbInfo;
import com.etohospital.dao.utils.SQLConditionModel;
import com.etohospital.dao.utils.SQLConditionUtil;
import com.etohospital.dao.utils.SQLType;
import com.etohospital.utils.SystemConfig;

public abstract class BaseDAOMySQL<T> implements BaseDAO<T> {	
	
    public static final String DRIVER = SystemConfig.getProperty("db_driver");
    public static final String URL = SystemConfig.getProperty("db_url");
    public static final String USERNAME = SystemConfig.getProperty("db_user");
    public static final String PASSWORD = SystemConfig.getProperty("db_password");
    
    DbInfo dbInfo = null;
    DbConnectMgr dbConnectMgr = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    @Override
    public Connection getConnection() throws Exception {
    	    	
    	dbInfo = new DbInfo();
    	dbInfo.setDriver(DRIVER);
    	dbInfo.setName("MySQL");
    	dbInfo.setUrl(URL);
    	dbInfo.setUser(USERNAME);
    	dbInfo.setPassword(PASSWORD);
    	dbInfo.setMaxconn(10);
    	
    	dbConnectMgr =  DbConnectMgr.getInstance(dbInfo);
    	connection = dbConnectMgr.getConnection(dbInfo.getName());
    	
    	return connection;
    }
    
    @Override
    public ResultSet executeQuery(String sql) throws Exception {
    	
    	connection = this.getConnection();
    	preparedStatement = connection.prepareStatement(sql);
    	resultSet = preparedStatement.executeQuery();    	
    	
        return resultSet;        
    }
    
    @Override
    public ResultSet executeQuery(String sql, Object[] paramters) throws Exception {
    	
    	connection = this.getConnection();
    	preparedStatement = connection.prepareStatement(sql);
    	for(int i=0;i<paramters.length;i++){
    		preparedStatement.setObject(i+1, paramters[i]);
    	}
    	resultSet = preparedStatement.executeQuery();    	
    	
        return resultSet;        
    }
    
    @Override
    public int executeUpdate(String sql, Object[] paramters) throws Exception {
    	
    	int effectedRows = 0;
    	
    	connection = this.getConnection();
    	preparedStatement = connection.prepareStatement(sql);
    	for(int i =0;i<paramters.length;i++){
    		preparedStatement.setObject(i+1, paramters[i]);
    	}
    	effectedRows =  preparedStatement.executeUpdate();    	
        
        return effectedRows;
    }
    
    @Override
    public void closeAll() throws Exception {
        if(null != resultSet){
            resultSet.close();
        }
        if(null != preparedStatement){
            preparedStatement.close();
        }
        if(null != connection){        	
        	if(null != dbConnectMgr){
        		dbConnectMgr.freeConnection(dbInfo.getName(), connection);
        		dbConnectMgr.release();
        	}
        }
    }
    
	@Override
	public int setMaxKey(T instance, int userId) throws Exception {
	
		int maxKeyValue = 0;
    	
    	try
    	{
	    	SQLConditionModel sqlCondition = generateSQLConditionModel(SQLType.MaxKey, instance, userId);
	    	ResultSet rs = executeQuery(sqlCondition.getSQLStatement());
	    	while(rs.next())
	    	{
	    		maxKeyValue = rs.getInt(sqlCondition.getPrimaryKey());
	    		break;
	    	}
	    	
	    	SQLConditionUtil.setPropertyValue(instance, sqlCondition.getPrimaryKey(), maxKeyValue + 1);
    	} catch(Exception ex) {
    		System.err.println(ex);
    	} finally{
    		closeAll();
    	}
    	
    	return maxKeyValue;
    }

	@Override
	public int genericInsert(T instance, int userId) throws Exception {
		
		setMaxKey(instance, userId);
		SQLConditionModel sqlCondition = generateSQLConditionModel(SQLType.Insert, instance, userId);		
		return executeUpdate(sqlCondition.getSQLStatement(), sqlCondition.getParamterValues());
	}

	@Override
	public int genericUpdate(T instance, int userId) throws Exception {
		
		SQLConditionModel sqlCondition = generateSQLConditionModel(SQLType.Update, instance, userId);		
		return executeUpdate(sqlCondition.getSQLStatement(), sqlCondition.getParamterValues());
	}

	@Override
	public int genericDelete(T instance, int userId) throws Exception {
		
		SQLConditionModel sqlCondition = generateSQLConditionModel(SQLType.Delete, instance, userId);		
		return executeUpdate(sqlCondition.getSQLStatement(), sqlCondition.getParamterValues());
	}

	private static Map<String, IDbModelAdapter> DbModelAdapters = new HashMap<String, IDbModelAdapter>();
	
	@Override
	public List<T> genericQuery(T instance, int userId) throws Exception {
		
		List<T> instances = null;
		
		try
		{
			SQLConditionModel sqlCondition = generateSQLConditionModel(SQLType.Select, instance, userId);
			ResultSet rs = executeQuery(sqlCondition.getSQLStatement(), sqlCondition.getParamterValues());			

			String className = instance.getClass().getName();
			IDbModelAdapter<T> mapper = null;
			if(DbModelAdapters.containsKey(className) == false) {
				mapper = new DbModelMapper<T>();
				DbModelAdapters.put(className, mapper);
			}
			mapper = (IDbModelAdapter<T>)DbModelAdapters.get(className);
			
			instances = mapper.constuctModelListFromResultSet((Class<T>)instance.getClass(), rs);
			
		} catch(Exception ex) {
			System.err.println(ex);
		} finally {
			closeAll();
		}		
		
		return instances;
	}

	@Override
	public SQLConditionModel generateSQLConditionModel(SQLType type, T object, int userId) throws Exception {
		
		Class<? extends Object> classType = object.getClass();
    	Method method = null;
    	
    	//===========================================================================
    	if(type == SQLType.Insert || type == SQLType.Update)
    	{
    		// 以下几行代码意味着每一张数据表均必须具备四个字段
    		method = classType.getDeclaredMethod("setLastModifiedBy", int.class);
    		if(method != null) method.invoke(object, userId);
    		classType.getDeclaredMethods();
    		
    		method = classType.getDeclaredMethod("setLastModifiedDate", Date.class);
    		if(method != null) method.invoke(object, new Date());
    	}
    	
		if(type == SQLType.Insert)
		{
			method = classType.getDeclaredMethod("setCreatedBy", int.class);
			if(method != null) method.invoke(object, userId);
			method = classType.getDeclaredMethod("setCreatedDate", Date.class);
			if(method != null) method.invoke(object, new Date());	
		}
		//===========================================================================
    	
    	return SQLConditionUtil.GenerateSQLCondition(classType, object, type);
	}
}