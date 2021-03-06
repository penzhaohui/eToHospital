package com.etohospital.utils;

import java.util.Collection;
import java.util.Map;

public class EmptyUtil {

	public static boolean isEmpty(Collection<?> collection)
	{
		return isNull(collection) || collection.size() < 1;
	}

	public static boolean isEmpty(Map<?, ?> map)
	{
		return isNull(map) || map.size() < 1;
	}

	public static boolean isEmpty(Object object)
	{
		if (object instanceof Collection)
		{
			return isEmpty((Collection<?>) object);
		}
		else if (object instanceof Map)
		{
			return isEmpty((Map<?, ?>) object);
		}
		return isNull(object) || "".equals(object);
	}

	public static boolean isEmpty(Object[] object)
	{
		return isNull(object) || object.length < 1;
	}

	public static boolean isEmpty(String text)
	{
		return isNull(text) || text.length() < 1;
	}

	public static boolean isNotEmpty(Collection<?> collection)
	{
		return !isEmpty(collection);
	}

	public static boolean isNotEmpty(Map<?, ?> map)
	{
		return !isEmpty(map);
	}

	public static boolean isNotEmpty(Object object)
	{
		return !isEmpty(object);
	}

	public static boolean isNotEmpty(Object[] object)
	{
		return !isEmpty(object);
	}

	public static boolean isNotEmpty(String text)
	{
		return !isEmpty(text);
	}
	
	private static boolean isNull(Object object)
	{
		return object == null;
	}
}
