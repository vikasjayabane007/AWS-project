package com.cognizant.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandlerTest {

	@Test
	public void testInvalidPensionerDetails() {
		InvalidUserException  ex = new InvalidUserException("Invalid ");
		ResponseEntity<?> entity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		assertEquals(406, entity.getStatusCodeValue());
		
	}


	@Test
	public void testInvalidTokenDetails() {
		InvalidTokenException tokenNotFoundException = new InvalidTokenException("Invalid Token");
		
		ResponseEntity<?> entity = new ResponseEntity<>(tokenNotFoundException.getMessage(), HttpStatus.UNAUTHORIZED);
		assertEquals(401, entity.getStatusCodeValue());
	}

	
	
	
}
