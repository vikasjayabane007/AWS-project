package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidUserException.class)
		public ResponseEntity<String> invalidPensionerDetails(InvalidUserException ex)
		{
			return new ResponseEntity<>(ex.toString(),HttpStatus.NOT_ACCEPTABLE);
		}
	
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<String> invalidTokenDetails(InvalidTokenException ex)
	{
		return new ResponseEntity<>(ex.toString(),HttpStatus.FORBIDDEN);
	}
}
