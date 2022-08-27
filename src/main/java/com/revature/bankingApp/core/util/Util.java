package com.revature.bankingApp.core.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Util {
	
	public static Scanner scanner = new Scanner(System.in);
	
	 public static boolean isValidPass(String passwordReg)
	    {
		 	String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
	        IntStream passWee = passwordReg.chars();
//	        System.out.println(passWee.toString());
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(passwordReg);
	        return matcher.matches();
	    }
	 
	 public static boolean isValidUsername(String usernameReg)
	    {
		 	String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])$";
	        IntStream passWee = usernameReg.chars();
	       
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(usernameReg);
	        return matcher.matches();
	    }

}
