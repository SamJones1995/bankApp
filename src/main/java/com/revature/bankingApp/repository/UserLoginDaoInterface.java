package com.revature.bankingApp.repository;

import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.services.models.UserLogin;

public interface UserLoginDaoInterface {
	
	UserLoginDTO createUserLogin(UserLoginDTO userLogDto);
		


	UserLoginDTO getUserLogin(UserLoginDTO userLogDto);


	
	
	



//	UserLoginDTO updateUserLogin(String username, String column, String value);
//
//
//
//	UserLoginDTO updateUserLogin(String username, String column, Integer value);



	boolean deleteUserLogin(String username);



	UserLoginDTO updateUserLogin(String username, String column, Integer value);



	UserLoginDTO updateUserLogin(String username, String column, String value);

}
