package com.revature.bankingApp.controller;



import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.core.views.LogReg;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;
import com.revature.bankingApp.services.Validation;

public class UserLoginRegistration {
	
	private static String username;
	
	private static String password;
	
	
	public static void userLoginRegistration() throws UserNotFoundException {
		System.out.println("Please enter username");
		
		
		username = Util.scanner.next();
		
		while (!Validation.isValidUsername(username)) {
			System.out.println("Please use between 8 and 20 alphanumeric characters");
			username = Util.scanner.next();
		}
		
		System.out.println("Username confirmed");
		
		
		System.out.println("Please enter password");
		
		password = Util.scanner.next();
		
		while (!Validation.isValidPass(password)) {
			System.out.println("Invalid password please try again");
			password = Util.scanner.next();
		}
		
		System.out.println("Confirm password");
		String passConfirm = Util.scanner.next();
		
		
		while (!passConfirm.equals(password)) {
				
				System.out.println("Please confirm password");
				passConfirm = Util.scanner.next();
			}
		System.out.println("Password confirmed");
				
		
		
		UserLoginDTO uDto = new UserLoginDTO(username, password);
		uDto.setUserTypeId(1);
		UserLoginDao uDao = new UserLoginDao();
		
		uDao.createUserLogin(uDto);
		
		LogReg.loginReg();
	}

}
