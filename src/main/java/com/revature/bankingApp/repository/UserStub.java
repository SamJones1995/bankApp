package com.revature.bankingApp.repository;

//import java.util.HashMap;
//import java.util.Map;
//
//import com.revature.bankingApp.services.models.Customer;
//import com.revature.bankingApp.services.models.UserLogin;
//
//public class UserStub implements UserDaoInterface {
//	
//	public Map<String, UserLogin> userData;
//	
//
//	public UserStub() {
//		
//		userData = new HashMap<String, UserLogin>();
//		userData.put("user1", new Customer("user1", "pass1", "email1@email.com"));
//		userData.put("user2", new Customer("user2", "pass2", "email2@email.com"));
//		userData.put("user3", new Customer("user3", "pass3", "email3@email.com"));
//		userData.put("user4", new Customer("user4", "pass4", "email4@email.com"));
//	}
//
//	@Override
//	public UserLogin createUser(UserLogin newUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public UserLogin getUser(String username, String password) {
//		
//		if (userData.containsKey(username) && userData.get(username).getPassword().equals(password)) {
//			return userData.get(username);
//		}
//		
//		return null;
//	}
//
//	@Override
//	public UserLogin updateUser(UserLogin updatedUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean deleteUser(UserLogin user) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//
//}
