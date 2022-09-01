package com.revature.bankingApp;


import com.revature.bankingApp.core.views.LogReg;
import com.revature.bankingApp.repository.UserDao;
import com.revature.bankingApp.repository.DTO.UserDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;


public class Driver {
	


	public static void main(String[] args) throws UserNotFoundException {
		
//
//		UserDao uDao = new UserDao();
//		UserDTO uDto = new UserDTO("name", "name2", "111 addres rd", "", "citytown", "va", 24112, 111667788, "email@emaail.com");
//		uDao.createUser(uDto);
		
		
	
		LogReg.loginReg();
//		

		
	}


}