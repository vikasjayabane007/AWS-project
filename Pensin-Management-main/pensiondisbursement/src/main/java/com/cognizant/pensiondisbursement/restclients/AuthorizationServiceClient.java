package com.cognizant.pensiondisbursement.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.pensiondisbursement.exception.TokenInvalidException;

@FeignClient(name = "authorization-service", url = "${auth-valid}")
public interface AuthorizationServiceClient {

	@PostMapping("/validate")
	public boolean validateAndReturnUser(@RequestHeader("Authorization") String token) throws TokenInvalidException;

}