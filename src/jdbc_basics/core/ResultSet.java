package jdbc_basics.core;

import java.sql.ResultSetMetaData;

public class ResultSet {
	private java.sql.ResultSet resultSet;
	private java.sql.ResultSetMetaData metaData;
	public java.sql.ResultSetMetaData getMetaData() {
		return metaData;
	}
	
	public ResultSet(java.sql.ResultSet resultSet, ResultSetMetaData metaData) {
		super();
		this.resultSet = resultSet;
		this.metaData = metaData;
	}


	public void setMetaData(java.sql.ResultSetMetaData metaData) {
		this.metaData = metaData;
	}
	public java.sql.ResultSet getResultSet() {
		return resultSet;
	}
	public void setResultSet(java.sql.ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
}
