package com.cognizant.processpension.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.processpension.model.AuthResponse;

@org.springframework.cloud.openfeign.FeignClient(name="GetValidation", url="${pension-auth}")
public interface FeignCommunicationWithAuth {

	@GetMapping("/validate")
	public ResponseEntity<AuthResponse> validate(@RequestHeader(name = "Authorization") String header);

}
