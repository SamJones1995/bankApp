package com.revature.bankingApp.controller;

import com.revature.bankingApp.services.models.UserLogin;

public interface LoginInterface {
	void login();
	
	UserLogin validateLogin(String username, String password);
	
}
