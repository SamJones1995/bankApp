package com.revature.bankingApp.core.views;


import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.UserDao;
import com.revature.bankingApp.repository.UserDaoInterface;

import com.revature.bankingApp.services.LoginService;
import com.revature.bankingApp.services.models.User;

import java.util.Scanner;

import com.revature.bankingApp.Driver;
import com.revature.bankingApp.controller.UserController;
import com.revature.bankingApp.core.UserSetup;


public class LogReg {
	
	public static void loginReg() {
		
		
		
		System.out.println("Thank you for using RevBank if you do not have an account please enter REGISTER or enter LOGIN");
		
		
			
		
			
			String input = Util.scanner.next();
			
			
			
			
		
		
		if (input.equals("LOGIN")) {
			
			
			UserDaoInterface uDao = new UserDao();
			LoginService loginService = new LoginService(uDao);
			UserController userController = new UserController(new Scanner(System.in), loginService);
			userController.login();
			
		}
		if (input.equals("REGISTER")){
			System.out.println("Please enter Username do not exceed 12 characters");
			UserSetup newUser = new UserSetup();
			String username = Util.scanner.next();
			
//			
//			if (newUser.userNameSetup(username) == true);
			
			ApplyAccount apply = new ApplyAccount();
			apply.applyAccount();
			
		
			
		} else if (!(input.equals("REGISTER")) || !(input.equals("LOGIN"))) {
			System.out.println("Please enter REGISTER or LOGIN");
			Driver.main(null);
		}
//			
			}
}
