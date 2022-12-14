package com.revature.bankingApp.controller;

import java.util.Scanner;

import com.revature.bankingApp.core.views.UserMenu;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;
import com.revature.bankingApp.services.LoginService;

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
		System.out.println("Please input username");
		String username = getUserInput();
		System.out.println("Please input password");
		String password = getUserInput();
		
		try {
		UserLoginDTO userLogin = validateLogin(username, password);
		
		if (userLogin != null) {
			System.out.println("Successful login");
			UserMenu.Menu(userLogin.getUserLoginId());	
		} else {
			System.out.println("failed login");
		}
		
		} catch (NullPointerException | UserNotFoundException e ) {
			System.out.println("Invalid login");
		}
		
	}
}
