package com.revature.bankingApp.controller;

import com.revature.bankingApp.core.UserLoginRegistrationEntries;
import com.revature.bankingApp.core.views.LogReg;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;

public class UserLoginRegistration {
	
	
	public static void userLoginRegistration() {
		System.out.println("Please enter username");
		String username = UserLoginRegistrationEntries.usernameEntry();
		
		String password = UserLoginRegistrationEntries.passwordEntry();
		
		UserLoginDTO uDto = new UserLoginDTO(username, password);
		uDto.setUserTypeId(1);
		UserLoginDao uDao = new UserLoginDao();
		
		uDao.createUserLogin(uDto);
		
		LogReg.loginReg();
	}

}
