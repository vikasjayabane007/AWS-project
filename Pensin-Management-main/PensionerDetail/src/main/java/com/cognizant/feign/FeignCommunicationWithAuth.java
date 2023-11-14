package com.cognizant.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.AuthResponse;

@org.springframework.cloud.openfeign.FeignClient(name="GetValidation", url="${auth.valid}")
public interface FeignCommunicationWithAuth {

	@GetMapping("/validate")
	public ResponseEntity<AuthResponse> validate(@RequestHeader(name="Authorization") String header);

}
