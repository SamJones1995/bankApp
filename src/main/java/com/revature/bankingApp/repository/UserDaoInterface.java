package com.revature.bankingApp.repository;

import com.revature.bankingApp.repository.DTO.UserDTO;
import com.revature.bankingApp.services.models.User;
import com.revature.bankingApp.services.models.UserLogin;

public interface UserDaoInterface {



//	UserDTO getUser(UserDTO uDto);

	

	boolean deleteUser(UserDTO uDto);

	

	UserDTO createUser(UserDTO uDto);

	UserDTO getUser(Integer ssn);

	UserDTO updateUser(Integer ssn, String column, String value);
	
	UserDTO updateUser(Integer ssn, String column, Integer value);

}
