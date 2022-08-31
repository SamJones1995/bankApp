package com.revature.bankingApp.core.views;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.revature.bankingApp.core.util.Util;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class UserDetailsEntryTest {
	
	@Test 
	public void firstNameVal() {
		
		assertEquals(true, Util.isValidPass("password1!"));
		
	}

}
