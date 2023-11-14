package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.InvalidTokenException;
import com.cognizant.exception.InvalidUserException;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.UserLoginCredential;
import com.cognizant.service.CustomerDetailsService;
import com.cognizant.service.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomerDetailsService custdetailservice;
	

	@GetMapping(path = "/health")
	public ResponseEntity<?> healthCheckup() {
		log.info("AWS Health Check ");
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<UserLoginCredential> login(@RequestBody UserLoginCredential userlogincredentials) throws InvalidUserException {
		log.debug("Start : {}", "login");
		
		try{
			
		final UserDetails userdetails = custdetailservice.loadUserByUsername(userlogincredentials.getUid());
		if (userdetails.getPassword().equals(userlogincredentials.getPassword())) {
			log.debug("End : {}", "login");
			return new ResponseEntity<>(new UserLoginCredential(userlogincredentials.getUid(),null,jwtutil.generateToken(userdetails)),HttpStatus.OK ); 
		} else {
			log.debug("Access Denied : {}", "login");
			throw new InvalidUserException("Invalid Username/Password");
//			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		}
		catch(Exception e)
		{
			throw new InvalidUserException("Invalid Username/Password");
		}
	}

	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String header) {
		log.debug("Start : {}", "getValidity");
		String token = header.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token)) {
			res.setUid(jwtutil.extractUsername(token));
			res.setValid(true);
		} else
			{
			res.setValid(false);
			}
		log.debug("End : {}", "getValidity");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
