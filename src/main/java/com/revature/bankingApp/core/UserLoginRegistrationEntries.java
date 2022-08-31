package com.revature.bankingApp.core;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.bankingApp.core.views.PassSetup;
import com.revature.bankingApp.controller.ApplicationEntries;
import com.revature.bankingApp.core.util.Util;

public class UserLoginRegistrationEntries {
	
	
public static String usernameEntry() {
		
		System.out.println("Please enter username");	
		
		String username = Util.scanner.next();
		
		
		if (username.length() < 8 && username.length() > 20) {
			System.out.println("Do not exceed 12 characters");
			UserLoginRegistrationEntries.usernameEntry();
			return null;
		}
		if (username.matches(".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*")) {
			System.out.println("Please use only alphanumeric characters");
			UserLoginRegistrationEntries.usernameEntry();
			return null;
			
		} else {
//			writeUsernameToDB(username);
			System.out.println("Username accepted");
			
			
			
		}
		return username;
		
		
	
	}

public static String passwordEntry() {
	
	System.out.println("Please enter password");	
	
	
	
	
	System.out.println("Please enter password (Must include special character and be between 8 - 20 characters");
	String passwordReg = Util.scanner.next();
	
//	String invalid = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
	
	boolean validPassword = Util.isValidPass(passwordReg);
	System.out.println(validPassword);
	if (validPassword == true) {
		System.out.println("Confirm password");
		String passConfirm = Util.scanner.next();
			if (passConfirm.hashCode() == passwordReg.hashCode()) {
				System.out.println("password confirmed");
				
				
				// write password to DB
				
			} if (passConfirm.hashCode() != passwordReg.hashCode()) {
				System.out.println("Please confirm password");
				UserLoginRegistrationEntries.passwordEntry();
			}
	} if (validPassword == false) {
		System.out.println("Invalid password please try again");
		UserLoginRegistrationEntries.passwordEntry();
		return null;
	}
	return passwordReg;
	
	

}




}
