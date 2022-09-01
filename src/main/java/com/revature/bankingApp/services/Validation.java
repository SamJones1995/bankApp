package com.revature.bankingApp.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation {
	
	static String regexUsername = ".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*";

	static String regexPassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
	
	static String regexName = "^[A-Za-z]{1,15}$";

	static String regexAddress = "^[a-zA-Z0-9\\\\s]*{10,25}$";

	static String regexState = "^[A-Za-z]{1,2}$";

	static String regexZip = "^[0-9]{5}$";

	static String regexSsn = "^[0-9]{9}$";

	static String regexEmail = "^[A-Za-z0-9]{1,25}$";
	
	
	public static boolean isValidUsername(String username) {
		if (((username.matches(regexUsername)) || (username.length() < 8 && username.length() > 20))) {
			
			return false;
		} else {
			return true;
		}
		
	}		
	
	
	 public static boolean isValidPass(String password)
	    {
		 	
	        Pattern pattern = Pattern.compile(regexPassword);
	        Matcher matcher = pattern.matcher(password);
	        return matcher.find();
	    }


	public static boolean isValidName(String name) {

		Pattern pattern = Pattern.compile(regexName);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public static boolean isValidAddress(String address) {
		Pattern pattern = Pattern.compile(regexAddress, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(address);
		return matcher.find();
	}

	public static boolean isValidCity(String city) {
		Pattern pattern = Pattern.compile(regexName, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(city);
		return matcher.matches();
	}

	public static boolean isValidState(String state) {

		Pattern pattern = Pattern.compile(regexState);
		Matcher matcher = pattern.matcher(state);
		return matcher.matches();
	}

	public static boolean isValidZip(String zip) {
		Pattern pattern = Pattern.compile(regexZip);
		Matcher matcher = pattern.matcher(zip);
		return matcher.find();
	}

	public static boolean isValidSsn(String ssn) {
		Pattern pattern = Pattern.compile(regexSsn);
		Matcher matcher = pattern.matcher(ssn);
		return matcher.find();
	}

	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(regexEmail);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}

}
//		
