package com.simplilearn.productdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
		
	private Connection connection;
		
	public DatabaseConfig(String driver,String url,String user,String password) throws ClassNotFoundException,SQLException
	{
		Class.forName(driver);
		this.connection= DriverManager.getConnection(url,user,password);
	}

	public Connection getConnection() {
		return connection;
	}
		
	public void closeConnection() throws SQLException
	{
		this.connection.close();
	}
}
