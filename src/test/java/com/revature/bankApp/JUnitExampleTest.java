package com.revature.bankApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.revature.bankingApp.Calculator;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class JUnitExampleTest {
	@Test 
	public void additionTest() {
		
		Calculator calculator = new Calculator();
		
		assertEquals(2, calculator.add(1,1));
	}
}
