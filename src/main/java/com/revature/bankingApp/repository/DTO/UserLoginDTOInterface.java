package com.revature.bankingApp.repository.DTO;

import com.revature.bankingApp.services.models.UserLogin;

public interface UserLoginDTOInterface {
	
	UserLogin login(UserLogin username, UserLogin password);
	
	UserLogin logout();
	

	


}
