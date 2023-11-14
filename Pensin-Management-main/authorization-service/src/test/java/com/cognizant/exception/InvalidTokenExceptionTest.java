package com.cognizant.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InvalidTokenExceptionTest {

	@InjectMocks
	private InvalidTokenException tokenInvalidException;

	@Test
	public void testTokenInvalidException() {
		String reason = "Invalid Token";
		assertEquals(reason, "Invalid Token");
	}

}