package jdbc_basics.core.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MapperImpl<T> {

	private static <T> void invokeSetter(Field field, Object value, T object) {
		String fieldName = field.getName();
		String methodName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
		try {
			Method method = object.getClass().getDeclaredMethod(methodName, field.getType());
			field.setAccessible(true);
			try {
				method.invoke(object, value);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T map(Object[] params, Class<?> clazz) {
		Object instance = null;
		try {
			instance = clazz.getDeclaredConstructor().newInstance();
			int i = 0;
			for (Field field : clazz.getDeclaredFields()) {
				invokeSetter(field, params[i], instance);
				i++;
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return (T) instance;
	}
}
