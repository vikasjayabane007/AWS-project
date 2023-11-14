package com.cognizant.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InvalidAdhaarNumberTest { 

	@InjectMocks
	private InvalidAdhaarNumber invalidAdhaar;

	@Test
	public void testAdhaarInvalid() {
		String reason = "The Adhaar Number is Invalid or Unregistered";
		assertEquals(reason, "The Adhaar Number is Invalid or Unregistered");
	}
	

}



