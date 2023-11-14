package com.cognizant.pensiondisbursement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pensiondisbursement.exception.PensionerDetailException;
import com.cognizant.pensiondisbursement.exception.TokenInvalidException;
import com.cognizant.pensiondisbursement.model.ProcessPensionInput;
import com.cognizant.pensiondisbursement.model.ProcessPensionResponse;
import com.cognizant.pensiondisbursement.service.PensionDisbursementServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PensionDisbursementController {
	@Autowired
	private PensionDisbursementServiceImpl pensionDisbursementService;

	
	@GetMapping(path = "/health")
	public ResponseEntity<?> healthCheckup() {
		log.info("AWS Health Check ");
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	@PostMapping("/disbursepension")
	public ProcessPensionResponse getPensionDisbursement(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) throws TokenInvalidException, PensionerDetailException
	{
		log.debug("DisbursePension Microservice Called To Evaluate Details ");
		return  pensionDisbursementService.getPensionDisbursement(token, processPensionInput);
		
	}


}
