package com.revature.bankingApp.controller;

import java.util.Scanner;

import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.services.LoginService;
import com.revature.bankingApp.services.models.UserLogin;

public class UserController implements UserInputInterface{
	
	private Scanner sc;
	private LoginService loginService;

	
	public UserController(Scanner sc, LoginService loginService) {
		super();
		this.sc = sc;
		this.loginService = loginService;
	}
	
	public UserLoginDTO validateLogin(String username, String password) {
		if(username == null && password == null) {
			return null;
		}
		
		UserLoginDTO user = loginService.login(username, password);
		return user;
	}


	@Override
	public String getUserInput() {
		
		return sc.nextLine();
	}
	
	public void login() {
		System.out.println("Please login with username and password \n");
		String username = getUserInput();
		String password = getUserInput();
		UserLoginDTO user = validateLogin(username, password);
		
		if (user != null) {
			System.out.println("Successful login");
			System.out.println(user.toString());
		} else {
			System.out.println("failed login");
		}
	}

}
