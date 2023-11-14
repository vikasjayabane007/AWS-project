package com.cognizant.exception;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
public class GlobalExceptionHanddlerTest {
	
	@Mock
	private GlobalExceptionHandler customGlobalExceptionHandler;

	
	
	@Test
	public void invalidAdhaarNumberTest() {
		InvalidAdhaarNumber adhaarNotFoundException = new InvalidAdhaarNumber("The Adhaar Number is Invalid or Unregistered");
	
		ResponseEntity<?> entity = new ResponseEntity<>(adhaarNotFoundException.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		assertEquals(406, entity.getStatusCodeValue());
	}
	
	@Test
	public void invalidTokenExceptionTest() {
		InvalidTokenException tokenNotFoundException = new InvalidTokenException("Invalid Token");
		
		ResponseEntity<?> entity = new ResponseEntity<>(tokenNotFoundException.getMessage(), HttpStatus.UNAUTHORIZED);
		assertEquals(401, entity.getStatusCodeValue());
	}
	
	

}
