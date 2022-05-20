package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.ds.PGConnectionPoolDataSource;
import org.postgresql.ds.PGPoolingDataSource;

public class ConnectionFactory {
	
	//Is going to control our connection to our database. 
	// It will deal with all the configuration details, and simply return a Connection. 
	
	private static String URL = System.getenv("db_url");
	private static String USERNAME = System.getenv("db_username");
	private static String PASSWORD = System.getenv("db_password");
	
	private static Connection connection;
	
	public static Connection getConnection() {
		
		try {
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static Connection getConnectionThroughDataSource() {
		
		//Create a Data source 
		// Data soruces can be better, you can set up something called connection pooling. 
		// Connection pooling recycles connections! So we create less
		// DriverManager doesn't support it, so we create a brand new connection every time. 
		
		PGPoolingDataSource dataSource = new PGPoolingDataSource();
		
		dataSource.setDatabaseName("postgres");
		dataSource.setServerName("database-1.cm90uslbuknf.us-east-1.rds.amazonaws.com");
		dataSource.setUser(USERNAME);
		dataSource.setPassword(PASSWORD);
//		
	
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	

}
