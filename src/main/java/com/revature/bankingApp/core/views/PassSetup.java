package com.revature.bankingApp.core.views;

import java.util.Scanner;
import com.revature.bankingApp.core.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PassSetup {
	
	private String passwordReg;
	private String passConfirm;

	public void passSetup() {
		System.out.println("Please enter password (Must include special character and be between 8 - 20 characters");
		passwordReg = Util.scanner.next();
		
//		String invalid = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		
		boolean validPassword = Util.isValidPass(passwordReg);
		System.out.println(validPassword);
		if (validPassword == true) {
			System.out.println("Confirm password");
			passConfirm = Util.scanner.next();
				if (passConfirm.hashCode() == passwordReg.hashCode()) {
					System.out.println("password confirmed");
					
					
					// write password to DB
					
				} if (passConfirm.hashCode() != passwordReg.hashCode()) {
					System.out.println("Please confirm password");
					passSetup();
				}
		} if (validPassword == false) {
			passSetup();
		}
		
		
	}
	
	public Boolean userNameSetup(String username) {
		boolean isValid = false;
		
		while (isValid == false) {
			
			if (username.length() > 12) {
				System.out.println("Do not exceed 12 characters");
				break;
			}
			if (username.matches(".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*")) {
				System.out.println("Please use only alphanumeric characters");
				break;
			} else {
	//			writeUsernameToDB(username);
				System.out.println("Username accepted");
				isValid = true;
				
				
			}
		
		}
		return isValid;
		
	}

}
