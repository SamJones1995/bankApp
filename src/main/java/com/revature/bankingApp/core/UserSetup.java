package com.revature.bankingApp.core;

import java.util.Scanner;

import com.revature.bankingApp.core.views.PassSetup;
import com.revature.bankingApp.core.util.Util;

public class UserSetup {
	
	
	
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
		return true;
		
	}
}
