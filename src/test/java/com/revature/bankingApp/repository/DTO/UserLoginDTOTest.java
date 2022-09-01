package com.revature.bankingApp.repository.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserLoginDTOTest {
	
private static List<UserLoginDTO> userLogins;
	
	@BeforeAll
	
	public static void setUp() {
		userLogins = new ArrayList<>(); {
			userLogins.add(new UserLoginDTO(9, "username1", "password1", 1, 1));
			userLogins.add(new UserLoginDTO(2, "username2", "password2", 2, 1));
		}
		
	}
	
	@Test
	public void getUserLoginId() {
		
		assertEquals((userLogins.get(0).getUserLoginId()), 9);
	}
	
	@Test
	public void setUserLoginId(Integer userLoginId) {
		userLogins.get(0).setUserId(10);
		
		assertEquals(userLogins.get(0).getUserLoginId(), 10);
	}
	
	@Test
	public void getUsername() {
		assertEquals((userLogins.get(0).getUsername()), "username1");
	}
	
	@Test
	public void setUsername(String username) {
		userLogins.get(0).setUsername("usernameTest");
		
		assertEquals(userLogins.get(0).getUsername(), "usernameTest");
	}
	
	@Test
	public void getPassword() {
		assertEquals((userLogins.get(0).getPassword()), "password1");
	}
	
	@Test
	public void setPassword(String password) {
		userLogins.get(0).setPassword("passwordTest");
		
		assertEquals(userLogins.get(0).getPassword(), "passwordTest");
	}
	
	@Test
	public void getUserId() {
		assertEquals((userLogins.get(0).getUserId()), 1);
	}
	
	@Test
	public void setUserId() {
		userLogins.get(0).setUserId(4);
		
		assertEquals(userLogins.get(0).getUserId(),4);
	}
	
	@Test
	public void getUserTypeId() {
		assertEquals((userLogins.get(0).getUserTypeId()), 1);
	}
	
	@Test
	public void setUserTypeId(Integer userTypeId) {
		userLogins.get(0).setUserTypeId(2);
		
		assertEquals(userLogins.get(0).getUserTypeId(),2);
	}
	
		
	
	

}
