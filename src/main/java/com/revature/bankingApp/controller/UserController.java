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
		System.out.println("Please input username \n");
		String username = getUserInput();
		System.out.println("Please input password \n");
		String password = getUserInput();
		UserLoginDTO user = validateLogin(username, password);
		
		
		if (user != null) {
			System.out.println("Successful login");
			UserMenu.Menu(user.getUserId());	
		} else {
			System.out.println("failed login");
		}
	}

}
