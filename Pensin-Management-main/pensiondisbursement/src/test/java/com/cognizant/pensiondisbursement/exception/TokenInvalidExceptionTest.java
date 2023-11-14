package com.cognizant.pensiondisbursement.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TokenInvalidExceptionTest {

	@InjectMocks
	private TokenInvalidException tokenInvalidException;

	@Test
	public void testTokenInvalidException() {
		String reason = "Invalid token..";
		assertEquals(reason, "Invalid token..");
	}

}
