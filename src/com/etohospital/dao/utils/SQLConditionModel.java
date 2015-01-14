package com.etohospital.dao.utils;

import java.util.ArrayList;
import java.util.List;

public class SQLConditionModel {

	private String _tableName;
	private String _primaryKey;
	private SQLType _sqlType;
	private List<String> _allPropertyNames;
	private List<String> _propertyNames;
	private List<Object> _propertyValues;
	@SuppressWarnings("rawtypes")
	private List<Class> _returnTypes;
	private String _sqlStatement = null;
	private Object[] _paramterValues = null;
	
	@SuppressWarnings("rawtypes")
	public SQLConditionModel(String tableName, String primaryKey, SQLType sqlType)
	{
		setTableName(tableName);
		setPrimaryKey(primaryKey);
		setSqlType(sqlType);
		setAllPropertyNames(new ArrayList<String>());
		setPropertyNames(new ArrayList<String>());
		setPropertyValues(new ArrayList<Object>());
		setReturnTypes(new ArrayList<Class>());
	}
	
	public void GenerateSQL()
	{
		// Java 枚举7常见种用法: http://www.iteye.com/topic/1116193
		switch(_sqlType)
		{
			case Insert:
				GenerateInsertSQL();
				break;
			case Update:
				GenerateUpdateSQL();
				break;
			case Delete:
				GenerateDeleteSQL();
				break;
			case Select:
				GenerateSelectSQL();
				break;
			case MaxKey:
				GenerateMaxKeySQL();
				break;
		}
	}
	
	private void GenerateInsertSQL()
	{		
		String insertFields = "";
		String insertValues = "";
		List<Object> tempPropertyValues = new ArrayList<Object>();
		
		int size = _propertyNames.size();
		Object propertyValue;
		String propertyName;
		for(int index = 0; index < size; index++)
		{
			propertyValue = _propertyValues.get(index);
			propertyName = _propertyNames.get(index);
			
			if(propertyValue == null)
			{
				continue;
			}
						
			insertFields += propertyName + ", ";
			insertValues += "?, ";
			tempPropertyValues.add(propertyValue);
		}
		
		if(insertFields.endsWith(", "))
		{
			insertFields = insertFields.substring(0, insertFields.length() - 2);
		}
		
		if(insertValues.endsWith(", "))
		{
			insertValues = insertValues.substring(0, insertValues.length() - 2);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT ");
		sb.append(_tableName);
		sb.append(" ( ");
		sb.append(insertFields);
		sb.append(") Values (");
		sb.append(insertValues);
		sb.append(")");
		
		_sqlStatement = sb.toString();
		_paramterValues = tempPropertyValues.toArray();		
	}
	
	private void GenerateUpdateSQL()
	{		
		String updateFields = "";
		List<Object> tempPropertyValues = new ArrayList<Object>();
		
		int size = _propertyNames.size();
		String propertyName;
		Object propertyValue;		
		String primaryKeyFieldName = "";
		Object primaryKeyFieldValue = "";
		
		for(int index = 0; index < size; index++)
		{
			propertyValue = _propertyValues.get(index);
			propertyName = _propertyNames.get(index);
			
			if(propertyValue == null)
			{
				continue;
			}
			
			if(_primaryKey.equalsIgnoreCase(propertyName))
			{
				primaryKeyFieldName = propertyName;
				primaryKeyFieldValue = propertyValue;
				continue;
			}
			
			updateFields += propertyName + " = ? , ";
			tempPropertyValues.add(propertyValue);
		}
		
		if(updateFields.endsWith(", "))
		{
			updateFields = updateFields.substring(0, updateFields.length() - 2);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(_tableName);
		sb.append(" SET ");
		sb.append(updateFields);
		sb.append(" WHERE ");
		sb.append(primaryKeyFieldName);
		sb.append(" = ? ");
		tempPropertyValues.add(primaryKeyFieldValue);
		
		_sqlStatement = sb.toString();
		_paramterValues = tempPropertyValues.toArray();		
	}
	
	private void GenerateDeleteSQL()
	{		
		List<Object> tempPropertyValues = new ArrayList<Object>();
		
		int size = _propertyNames.size();
		String propertyName;
		Object propertyValue;		
		String primaryKeyFieldName = "";
		Object primaryKeyFieldValue = "";
				
		for(int index = 0; index < size; index++)
		{
			propertyValue = _propertyValues.get(index);
			propertyName = _propertyNames.get(index);
			
			if(propertyValue == null)
			{
				continue;
			}
			
			if(_primaryKey.equalsIgnoreCase(propertyName))
			{
				primaryKeyFieldName = propertyName;
				primaryKeyFieldValue = propertyValue;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(_tableName);
		
		sb.append(" WHERE ");
		sb.append(primaryKeyFieldName);
		sb.append(" = ? ");
		tempPropertyValues.add(primaryKeyFieldValue);		
		
		_sqlStatement = sb.toString();
		_paramterValues = tempPropertyValues.toArray();			
	}
	
	private void GenerateSelectSQL()
	{
		String selectFields = "";
		String whereFields = "";
		List<Object> tempPropertyValues = new ArrayList<Object>();
		
		for(String propertyName : _allPropertyNames){
			selectFields += propertyName + ", ";
		}
		
		if(selectFields.endsWith(", "))
		{
			selectFields = selectFields.substring(0, selectFields.length() - 2);
		}
		
		int size = _propertyNames.size();
		Object propertyValue;
		String propertyName;
		for(int index = 0; index < size; index++)
		{
			propertyValue = _propertyValues.get(index);
			propertyName = _propertyNames.get(index);			
			
			if(propertyValue == null)
			{
				continue;
			}
						
			whereFields += propertyName + " = ? AND ";
			tempPropertyValues.add(propertyValue);
		}
		
		if(whereFields.endsWith("AND "))
		{
			whereFields = whereFields.substring(0, whereFields.length() - 4);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(selectFields);
		sb.append(" FROM ");
		sb.append(_tableName);
		if(size > 0)
		{
			sb.append(" WHERE ");
			sb.append(whereFields);
		}
		
		_sqlStatement = sb.toString();
		_paramterValues = tempPropertyValues.toArray();	
	}
	
	private void GenerateMaxKeySQL()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT MAX(");
		sb.append(_primaryKey);
		sb.append(") as ");
		sb.append(_primaryKey);
		sb.append(" FROM ");
		sb.append(_tableName);
		
		_sqlStatement = sb.toString();
	}
	
	public String getTableName() {
		return _tableName;
	}
	public void setTableName(String tableName) {
		this._tableName = tableName;
	}
	public String getPrimaryKey() {
		return _primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this._primaryKey = primaryKey;
	}
	public SQLType getSqlType() {
		return _sqlType;
	}
	public void setSqlType(SQLType sqlType) {
		this._sqlType = sqlType;
	}
	public List<String> getAllPropertyNames() {
		return _allPropertyNames;
	}
	public void setAllPropertyNames(List<String> allPropertyNames) {
		_allPropertyNames = allPropertyNames;
	}
	public List<String> getPropertyNames() {
		return _propertyNames;
	}
	public void setPropertyNames(List<String> propertyNames) {
		this._propertyNames = propertyNames;
	}
	public List<Object> getPropertyValues() {
		return _propertyValues;
	}
	public void setPropertyValues(List<Object> propertyValues) {
		this._propertyValues = propertyValues;
	}
	@SuppressWarnings("rawtypes")
	public List<Class> getReturnTypes() {
		return _returnTypes;
	}
	@SuppressWarnings("rawtypes")
	public void setReturnTypes(List<Class> returnTypes) {
		this._returnTypes = returnTypes;
	}
	public String getSQLStatement() {
		return _sqlStatement;
	}
	public void setSQLStatement(String sqlStatement) {
		_sqlStatement = sqlStatement;
	}
	public Object[] getParamterValues() {
		return _paramterValues;
	}
	public void setParamterValues(Object[] paramterValues) {
		_paramterValues = paramterValues;
	}		
}
