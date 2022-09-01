package com.revature.bankingApp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.bankingApp.repository.DTO.UserDTO;

@TestInstance(Lifecycle.PER_CLASS)


public class UserDaoTest {
	
	protected static final Integer userId = 9;
	
	private static List<UserDTO> users;
	
	@BeforeClass
	public static void setUp() {
		users = new ArrayList<>(); {
			users.add(new UserDTO(1, "TestMan", "TestFamilyName", "111 test rd", "Apt T", "Test town", "TD", 23112, 222446688, "email@test.com"));
			users.add(new UserDTO(2, "TestGirl", "TestFamilyName", "111 test rd", "Apt 12", "Test town", "TD", 23112, 222446699, "themail@test.com"));
		}
	}
	

	
	@BeforeAll
	void setup() {
		
		MockitoAnnotations.openMocks(this);
		
		
		UserDTO uDto = new UserDTO(1, "TestMan", "TestFamilyName", "111 test rd", "Apt T", "Test town", "TD", 23112, 222446688, "email@test.com");
		
		UserDTO newUDto = new UserDTO("TestMan", "TestFamilyName", "111 test rd", "Apt T", "Test town", "TD", 23112, 222446688, "email@test.com");
	}
	
	@Mock
	UserDao uDao = new UserDao();
	UserDTO uDto = new UserDTO(1, "TestMan", "TestFamilyName", "111 test rd", "Apt T", "Test town", "TD", 23112, 222446688, "email@test.com");
	UserDTO newUDto = new UserDTO("TestMan", "TestFamilyName", "111 test rd", "Apt T", "Test town", "TD", 23112, 222446688, "email@test.com");
	
	
	@Test
	
//	public void getWithNullUserId() throws SQLException {
//		Mockito.when(UserDao.getUserById(null));
//	}
	
	public void getUserById()  throws SQLException {
		
		
//		assertEquals(UserDao.getUser(1), UserDao.getUserById(222446688));
		assertEquals(UserDao.getUser(123456712), UserDao.getUserById(userId));
		
	}
	@Test
	public void deleteUser() {
		
		assertEquals(false ,uDao.deleteUser(uDto)); 
	}
	@Test
	public void createUser() {
		UserDTO testDto = uDao.createUser(newUDto);
		
		
		
		assertEquals(newUDto, testDto);
	}
	

}
