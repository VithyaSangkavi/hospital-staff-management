package com.oop.connection;

import java.sql.Connection;





import java.sql.DriverManager;
import java.sql.SQLException;


//singleton pattern

public class DBConnectionUtil extends CommonUtil{
	
	//static instance
	private static Connection connection;

	//private constructor to block multiple inheritance
	private DBConnectionUtil() {
	}

	//to get the only object available
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
		}
		return connection;
	}
}
