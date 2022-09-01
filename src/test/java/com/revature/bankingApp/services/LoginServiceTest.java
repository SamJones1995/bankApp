package com.revature.bankingApp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class LoginServiceTest {
	
	private String username = "uniqueuser";
	
	private String password = "$K8erboy";
	
	@Test
	public void login(String username, String password) {
		LoginService lServ = new LoginService(null);
		
		UserLoginDTO uLogDto = lServ.login(username, password);
		
		assertEquals(uLogDto.getUsername(), username);
		
		
	}
	
	@Test
	public void inValidLogin() {
		LoginService lServ = new LoginService(null);
		
		
		
		assertThrows(UserNotFoundException.class, () -> lServ.login("invalid username", "invalid password"));
		
		
	}
	
	

}
