package com.cognizant.processpension.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.processpension.exception.InvalidPensionerDetails;
import com.cognizant.processpension.exception.InvalidTokenException;
import com.cognizant.processpension.feign.FeignCommunicationWithAuth;
import com.cognizant.processpension.model.PensionDetail;
import com.cognizant.processpension.model.PensionerInput;
import com.cognizant.processpension.model.ProcessPensionInput;
import com.cognizant.processpension.model.ProcessPensionResponse;
import com.cognizant.processpension.service.ProcessPensionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j 
public class ProcessPensionController {

	@Autowired
	private FeignCommunicationWithAuth feignWithAuth;
	
	@Autowired
	private ProcessPensionService service;
	
	
	@GetMapping(path = "/health")
	public ResponseEntity<?> healthCheckup() {
		log.info("AWS Health Check ");
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	
	@PostMapping("/pensiondetail")
	public ResponseEntity<?> getPensionDetail(@RequestBody PensionerInput pensionerInput,@RequestHeader(name="Authorization") String header) throws  InvalidTokenException, InvalidPensionerDetails
	{
		log.info("Inside getPensionDetail() method of processPension Microservice");
		try{
			feignWithAuth.validate(header);
			}
		catch(Exception e)
			{	
				log.error("Validation Error");
				throw new InvalidTokenException("Invalid Token");
			}
		
		return new ResponseEntity<>(service.getPensionDetail(header,pensionerInput),HttpStatus.OK);
	
	}

	
	@PostMapping("/processpension")
	public ProcessPensionResponse processPension(@RequestHeader("Authorization") String header,@RequestBody ProcessPensionInput pensionInput ) throws InvalidTokenException, InvalidPensionerDetails
	{
		log.info("Inside getPensionDetail() method of processPension Microservice");
		
		
		try{
			feignWithAuth.validate(header);
			}
		catch(Exception e)
			{	
				log.error("Validation Error");
				throw new InvalidTokenException("Invalid Token");
			}
		log.info("Returning Status Code");
		return service.processPensionInput(header,pensionInput);			
	}
	
	
}