package jdbc_basics.orm.mapper;

import java.util.Map;

public interface Mapper<T> {


	T map(Map<String, String> stringObject);

	T map(Map<String, String> stringObject, Class<T> clazz) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
}

