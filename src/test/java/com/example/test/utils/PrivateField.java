package com.example.test.utils;

import java.lang.reflect.Field;

public class PrivateField {
	public static Object get(Object obj, String field) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field cmd = obj.getClass().getDeclaredField(field);
		cmd.setAccessible(true);
		return cmd.get(obj);
	}
	public static void set(Object obj, String field, Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field cmd = obj.getClass().getDeclaredField(field);
		cmd.setAccessible(true);
		cmd.set(obj, value);
	}
}
