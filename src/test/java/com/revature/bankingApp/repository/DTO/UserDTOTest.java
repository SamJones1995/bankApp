package com.revature.bankingApp.repository.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.revature.bankingApp.repository.UserDao;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class UserDTOTest {
	
	
	private static List<UserDTO> users;
	
	@BeforeAll
	
	public static void setUp() {
		users = new ArrayList<>(); {
			users.add(new UserDTO(9, "bobo", "TestFamilyName", "111 test rd", "Apt T", "Test town", "TD", 23112, 123456712, "email@test.com"));
			users.add(new UserDTO(2, "TestGirl", "TestFamilyName", "111 test rd", "Apt 12", "Test town", "TD", 23112, 222446699, "themail@test.com"));
		}
		
		
		UserDao uDao = new UserDao();
		

	}
	


   
    
    @Test
	public void getUser()  throws SQLException {
		
		assertEquals(UserDao.getUser((users.get(0).getSsn())).userId, UserDao.getUserById((users.get(0).getUserId())).userId);
		
	}
    
    
//	@Test
//	public void deleteUser() {
//		
//		assertEquals(false ,uDao.deleteUser(uDto)); 
//	}
//	@Test
//	public void createUser() {
//		UserDTO testDto = uDao.createUser(newUDto);
//		
//		
//		
//		assertEquals(newUDto, testDto);
//	}
//	

}
