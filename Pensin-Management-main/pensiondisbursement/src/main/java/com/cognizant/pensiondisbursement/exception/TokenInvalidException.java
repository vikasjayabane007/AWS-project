package com.cognizant.pensiondisbursement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
public class TokenInvalidException extends Exception {
	
    public TokenInvalidException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TokenInvalidException(String msg) {
        super(msg);
    }
}
