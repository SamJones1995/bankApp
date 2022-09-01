package com.revature.bankingApp.core.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.revature.bankingApp.services.Validation;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class UtilTest {

	
	@Test 
	public void passwordTest() {
		
		
		
		assertEquals(true, Validation.isValidPass("password1!"));
	}
	
	

}
