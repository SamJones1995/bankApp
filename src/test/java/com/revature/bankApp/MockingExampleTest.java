package com.revature.bankApp;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MockingExampleTest {
	
	@Mock
	List<String> mockedLis;
	
	@BeforeAll
	void init() {
		MockitoAnnotations.openMocks(this);
	}

}
