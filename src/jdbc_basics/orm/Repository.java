package jdbc_basics.orm;

import java.util.List;

public interface Repository<T, R> {
	T findOne(R id);
	List<T> findAll();
}
