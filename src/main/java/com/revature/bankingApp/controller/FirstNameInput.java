package com.revature.bankingApp.controller;

import java.util.Scanner;

import com.revature.bankingApp.core.Validation;
import com.revature.bankingApp.core.util.Util;

public class FirstNameInput {
	
	public static String firstNameInput(String firstName) {
		
		if (Validation.isValidName(firstName) == false) {
			System.out.println("invalid entry please try again");
			String newEntry = Util.scanner.nextLine();
			FirstNameInput.firstNameInput(newEntry);
		} else {
			
			return firstName;
		}
		return firstName;
	}	
}
