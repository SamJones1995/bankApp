package com.revature.bankingApp;


import com.revature.bankingApp.core.views.LogReg;
import com.revature.bankingApp.repository.DBConnection;
import com.revature.bankingApp.repository.UserDao;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserDTO;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.services.LoginService;
import com.revature.bankingApp.services.models.User;


public class Driver {
	


	public static void main(String[] args) {
//		DBConnection connection = new DBConnection();
		
//		UserDao uDao = new UserDao();
//		UserDTO uDto = new UserDTO("bobo", "belboy", "asdf 11 D", "masstown",
//				"NJ", 22311, 123456712, "email@email.com");
//		uDao.createUser(uDto);
		
		
//		
	LogReg logReg = new LogReg();
		
	
		
		
	
	logReg.loginReg();
		
		
	}


}