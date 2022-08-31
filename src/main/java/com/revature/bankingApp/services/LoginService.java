package com.revature.bankingApp.services;

import com.revature.bankingApp.repository.UserDaoInterface;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.services.models.UserLogin;
import com.revature.bankingApp.services.models.UserLoginInterface;

public class LoginService implements UserLoginInterface{
	
	public UserDaoInterface userDao;
	
	public LoginService(UserDaoInterface userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public UserLoginDTO login(String username, String password) {
		
		
		UserLoginDao uDao = new UserLoginDao();
		UserLoginDTO uDto = new UserLoginDTO(username, password);
		UserLoginDTO uLogDto = new UserLoginDTO(username, password);
		
		
		
		UserLoginDTO uDtoDB = uDao.getUserLogin(username, password);
		
		if (uDtoDB.getUsername() == null) {
			return null;
		}
		
		if ((uDto.getUsername().equals(uDtoDB.getUsername())) && (uDto.getPassword().equals(uDtoDB.getPassword()))) {
			System.out.println("Login success");
			uLogDto.setUserLoginId(uDtoDB.getUserLoginId());
			uLogDto.setUserId(uDtoDB.getUserId());
			uLogDto.setUserTypeId(uDtoDB.getUserTypeId());
			
			return uLogDto;
		}
		
		if (!((uDto.getUsername().equals(uDtoDB.getUsername())) && (uDto.getPassword().equals(uDtoDB.getPassword())))) {
			System.out.println("Login failure");
			return null;
		}
		
		
		
		System.out.println(uLogDto.toString());
		
		
		return uLogDto;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser() {
		// TODO Auto-generated method stub
		return false;
	}

}
