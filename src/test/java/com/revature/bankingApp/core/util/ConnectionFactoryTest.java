package com.revature.bankingApp.core.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ConnectionFactoryTest {
	
	private String url;
	
	private String databaseUser;
	
	private String databasePassword;
	
	@BeforeAll
	void setup() {
		MockitoAnnotations.openMocks(this);
		
		String url = "null";
		
		String databaseUser = "null";
		
		String databasePassword = "null";
		
	}
	
	@Test 
	public void getConnection() throws SQLException {
		
//		Mockito.when(DriverManager.getConnection(url, databaseUser, databasePassword));
		assertThrows(SQLException.class, () -> DriverManager.getConnection(url, databaseUser, databasePassword));
	
	}
	

}
