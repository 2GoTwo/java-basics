package jdbc_basics.core.parser;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jdbc_basics.core.ResultSet;

public class ResultParser {
	
	public static  Map<String, Object> parse(ResultSet resultSet) {
		Map<String, Object> m = new HashMap<String, Object>();
		int count;
		try {
			count = resultSet.getMetaData().getColumnCount();
			for (int i = 0; i < count; i++) {
				m.put(resultSet.getMetaData().getColumnName(i), resultSet.getResultSet().getObject(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
}
