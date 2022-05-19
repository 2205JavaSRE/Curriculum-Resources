package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDriver {
	
	/*
	 * JDBC - Java Database Connection 
	 * 
	 * JDBC API handles database connection for me, and provides useful methods
	 * 	to manipulate the database through Java.
	 * 
	 * Important interfaces in JDBC: 
	 * 		DriverManager
	 * 		Connection 
	 * 		Statement 
	 * 		PreparedStatement
	 * 		ResultSet
	 * 
	 * What do I need to connect to a database?
	 * 		Username 
	 * 		Password 
	 * 		Endpoint 
	 */

	public static void main(String[] args) {

		//final String URL = jdbc:postgresql://{host}[:{port}]/[{database}]
		final String URL = "jdbc:postgresql://database-1.cm90uslbuknf.us-east-1.rds.amazonaws.com:5432/postgres";
		final String USERNAME = "java_login";
		final String PASSWORD = "p4ssw0rd";
		
		Connection connection;
		
		try {
			//FIRST we connect to our database
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("I'm connected!");
			
			//SECOND we try to insert something in!
			String insertSQL = "INSERT INTO planets (planet_name,has_rings) values ('from Java',true)";
			
			//We instantiate a statement from the connection
			Statement statement = connection.createStatement();

			//execute the string by passing it to the statement

			statement.execute(insertSQL);
			
			
			//NOW we try to retrieve the data back!
			String selectSql = "SELECT * FROM planets";
			
			statement = connection.createStatement();
			
			//Create an object to collect all the records we receive!
			ResultSet rs = statement.executeQuery(selectSql);
			
			while(rs.next()) { //keep looping until the resultSet is empty 
				System.out.println(rs.getInt("planet_id"));
				System.out.println(rs.getString("planet_name"));
				System.out.println(rs.getBoolean("has_rings"));
				System.out.println("");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
