package com.revature.bankingApp.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ValidationTest {
	
	
	
	@Test
	public void isValidUsername() {
		boolean isVal = Validation.isValidUsername("123");
		
		assertFalse(isVal);
	}
	
	@Test
	public void isValidPassword() {
		boolean isVal = Validation.isValidPass("123");
		
		assertFalse(isVal);
	}
	
	@Test
	public void isValidName() {
		boolean isVal = Validation.isValidName("123");
		
		assertFalse(isVal);
	}
	
	@Test
	public void isValidAddress() {
		boolean isVal = Validation.isValidAddress("123");
		
		assertFalse(isVal);
	}
	
	@Test
	public void isValidState() {
		boolean isVal = Validation.isValidState("123");
	
		assertFalse(isVal);
	}
	
	@Test
	public void isValidZip() {
		boolean isVal = Validation.isValidZip("123");
	
		assertFalse(isVal);
	}
	
	@Test
	public void isValidSsn() {
		boolean isVal = Validation.isValidSsn("123");
	
		assertFalse(isVal);
	}
	
	@Test
	public void isValidEmail() {
		boolean isVal = Validation.isValidEmail("123");
	
		assertFalse(isVal);
	}
	

}
