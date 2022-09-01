package com.revature.bankingApp.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static String url;
	
	public static Connection connection;
	
	private static int port = 5432;
	
	private static String databaseName = System.getenv("db_Name");
	
	private static String databaseUser = System.getenv("db_User");
	
	private static String databasePassword = System.getenv("db_Password");
	
	private static String host = System.getenv("db_Host");
	
	public static Connection getConnection() throws SQLException {
		
		try {
			url = "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
			
			connection = DriverManager.getConnection(url, databaseUser, databasePassword);
			
//			System.out.println("Connection Success");
		} catch (SQLException e) {
			System.out.println("Connection Failure" + url);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return DriverManager.getConnection(
//				System.getenv("db_Host"),
//				System.getenv("db_User"),
//				System.getenv("db_Password"));
		return connection;
				
	}
}
