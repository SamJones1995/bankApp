package com.revature.bankingApp.services;

import com.revature.bankingApp.repository.UserDaoInterface;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;

public class LoginService {
	
	public UserDaoInterface userDao;
	
	public LoginService(UserDaoInterface userDao) {
		super();
		this.userDao = userDao;
	}

	
	public UserLoginDTO login(String username, String password) {
		
		
		UserLoginDao uDao = new UserLoginDao();
		UserLoginDTO uDto = new UserLoginDTO(username, password);
		UserLoginDTO uLogDto = new UserLoginDTO(username, password);
		
		
		
		UserLoginDTO uDtoDB = UserLoginDao.getUserLogin(username, password);
		
		if (uDtoDB.getUsername() == null) {
			return null;
		}
		
		if ((uDto.getUsername().equals(uDtoDB.getUsername())) && (uDto.getPassword().equals(uDtoDB.getPassword()))) {
			
			uLogDto.setUserLoginId(uDtoDB.getUserLoginId());
			uLogDto.setUserId(uDtoDB.getUserId());
			uLogDto.setUserTypeId(uDtoDB.getUserTypeId());
			
			return uLogDto;
		}
		
		if (!((uDto.getUsername().equals(uDtoDB.getUsername())) && (uDto.getPassword().equals(uDtoDB.getPassword())))) {
			
			return null;
		}
		
		
		
		
		
		
		return uLogDto;
	}





}
