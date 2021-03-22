package jdbc_basics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CrudOperations<T> {

	public T executeQuery(String sql) {
		String dbUrl = "";
		String dbName = "";
		try (Connection connection = DriverManager.getConnection(dbUrl + dbName)) {
			Statement stm = connection.createStatement();
			ResultSet resultSet = stm.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
