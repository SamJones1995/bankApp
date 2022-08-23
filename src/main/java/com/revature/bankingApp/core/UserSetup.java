package com.revature.bankingApp.core;

import java.util.Scanner;

import com.revature.bankingApp.core.views.PassSetup;
import com.revature.bankingApp.core.util.Util;

public class UserSetup {
	
	private String username;
	
	public void userSetup() {
		
		
		username = Util.scanner.next();
		if (username.length() > 12) {
			System.out.println("Do not exceed 12 characters");
		}
		if (username.matches(".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*")) {
			System.out.println("Please use only alphanumeric characters");
		} else {
//			writeUsernameToDB(username);
			System.out.println("Username accepted");
			PassSetup pass = new PassSetup();
			pass.passSetup();
		}
		
		
	}
}
