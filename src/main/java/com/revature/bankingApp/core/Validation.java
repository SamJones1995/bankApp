package com.revature.bankingApp.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.core.views.UserDetailsEntry;
import com.revature.bankingApp.core.views.PassSetup;

public class Validation {

	public void validate(String passwordUsr) {
		if (passwordUsr.equals("LOGIN")) {
			System.out.println("you're ready to log in");
			
			// LOGIN instructions
		}
		if (passwordUsr.equals("REGISTER")){
			System.out.println("Please enter Username do not exceed 12 characters");
		
			
		}
//			
			}
	
//	public static String nameValidate() {
//		String name = Util.scanner.next();
//		
//		boolean isValid = true;
//		
//		if (name.length() > 15) {
//			System.out.println("Do not exceed 15 characters");
//			isValid = false;
//			nameValidate();			
//			
//		} 
//		
//		if (name.matches(".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*")) {
//			System.out.println("Please use only alphanumeric characters");
//			isValid = false; 
//			nameValidate();
//			
//			
//		}
//		
//		if (isValid == true) {
//			return name; }
//		else {
//			nameValidate();	
//			return "";
//		}
//		
//		
//	}
	
	public static boolean isValidName(String name)
    {
		String regexName = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        
//        System.out.println(passWee.toString());
        Pattern pattern = Pattern.compile(regexName);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
	
	public static boolean isValidAddress(String address)
    {
		if ((address.length() > 12) ||(address.matches(".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*"))) {
			System.out.println("Do not exceed 12 characters, alphanumerical only");
			return false;
		} else {
//			writeUsernameToDB(username);
			return true;
		}
//		String regexName = "^[A-Z](?=.{1,49}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
//        IntStream nameChars = name.chars();
////        System.out.println(passWee.toString());
//        Pattern pattern = Pattern.compile(regexName);
//        Matcher matcher = pattern.matcher(name);
//        return matcher.matches();
    }
//		
	}
	