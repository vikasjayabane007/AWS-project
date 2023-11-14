package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.InvalidAdhaarNumber;
import com.cognizant.exception.InvalidTokenException;
import com.cognizant.feign.FeignCommunicationWithAuth;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.PensionerDetail;
import com.cognizant.service.PensionerDetailService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class PensionerDetailController {
	
	@Autowired
	private PensionerDetailService service;
	
	@Autowired 
	private FeignCommunicationWithAuth feignWithAuth;

	
	
	@GetMapping(path = "/health")
	public ResponseEntity<?> healthCheckup() {
		log.info("AWS Health Check ");
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	
	
	@GetMapping("/pensionerdetailbyaadhaar/{aadharnumber}")
	public PensionerDetail findById(@RequestHeader(name="Authorization") String header ,@PathVariable("aadharnumber") long aadharnumber) throws InvalidTokenException , InvalidAdhaarNumber {
		log.debug("findById() invoked to fetch Pensioner Details by Aadhaar Number"); 
//		AuthResponse res = null; 
		try{
			feignWithAuth.validate(header);
			}
		catch(Exception e)
			{	
				log.error("Validation Error");
				throw new InvalidTokenException("Invalid Token");
			}
		PensionerDetail obj =  service.getById(aadharnumber);
		if(obj == null)
		{	log.warn("Adhaar Number is not valid");
		    throw new InvalidAdhaarNumber("The Adhaar Number is Invalid or Unregistered");
		}
		else 
			return obj;	
	}
	
}
