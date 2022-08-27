package com.revature.bankingApp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public String url;
	
	public Connection connection;
	
	private int port = 5432;
	
	private String databaseName = System.getenv("db_Name");
	
	private String databaseUser = System.getenv("db_User");
	
	private String databasePassword = System.getenv("db_Password");
	
	private String host = System.getenv("db_Host");
	
	public DBConnection() {
		try {
			url = "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
			
			connection = DriverManager.getConnection(url, databaseUser, databasePassword);
			
			System.out.println("Connection Success");
		} catch (SQLException e) {
			System.out.println("Connection Failure" + url);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
