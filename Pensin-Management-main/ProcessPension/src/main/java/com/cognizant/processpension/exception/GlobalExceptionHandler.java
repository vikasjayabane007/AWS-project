package com.cognizant.processpension.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidPensionerDetails.class)
		public ResponseEntity<String> invalidPensionerDetails(InvalidPensionerDetails ex)
		{
			return new ResponseEntity<>(ex.toString(),HttpStatus.NOT_ACCEPTABLE);
		}
	
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<String> invalidToken(InvalidTokenException ex)
	{
		return new ResponseEntity<>(ex.toString(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}
