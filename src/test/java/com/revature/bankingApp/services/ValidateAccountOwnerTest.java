package com.revature.bankingApp.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ValidateAccountOwnerTest {
	
	@Test
	public void validateAccountOwnerTest() {
		assertTrue(ValidateAccountOwner.validateAccountOwner(15, 10));
	}
	
	

}
