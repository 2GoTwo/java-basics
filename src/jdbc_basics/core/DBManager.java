package jdbc_basics.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import jdbc_basics.core.parser.ResultParser;

public class DBManager {
	private static volatile Connection conn;

	public DBManager(String url, String username, String password) throws SQLException {
		conn = DriverManager.getConnection(url, username, password);
	}

	public ResultSet executeQuery(String sql) {
		try (Statement stm = conn.createStatement();) {
			java.sql.ResultSet resultSet = stm.executeQuery(sql);
			return new ResultSet(resultSet, resultSet.getMetaData());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			DBManager dbManager = new DBManager("jdbc:postgresql://localhost:5433/orm", "postgres", "123456");
			jdbc_basics.core.ResultSet resultSet = dbManager.executeQuery("select name, dateBorn from animal where id = 0");
			Map<String, Object> str = ResultParser.parse(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
