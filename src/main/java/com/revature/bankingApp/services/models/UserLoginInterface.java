package com.revature.bankingApp.services.models;

import com.revature.bankingApp.repository.DTO.UserLoginDTO;

public interface UserLoginInterface {
	UserLoginDTO login(String username, String password);
	
	boolean logout();
	boolean deleteUser();
	
	boolean updateUser();
}
