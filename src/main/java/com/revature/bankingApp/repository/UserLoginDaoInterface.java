package com.revature.bankingApp.repository;

import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.services.models.UserLogin;

public interface UserLoginDaoInterface {
	
	UserLoginDTO createUserLogin(UserLoginDTO userLogDto);
		


	UserLoginDTO getUserLogin(UserLoginDTO userLogDto);

	UserLoginDTO updateUserLogin(Integer ssn, String column, String value);
	
	
	
	boolean deleteUserLogin(UserLoginDTO uLogin);

}
