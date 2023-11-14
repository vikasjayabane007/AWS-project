package com.cognizant.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InvalidUserExceptionTest {

	@Test
	public void testInvalidUserException() {

		InvalidUserException  ex = new InvalidUserException("Invalid ");
		ResponseEntity<?> entity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		assertEquals(406, entity.getStatusCodeValue());
		
		
	}

}
