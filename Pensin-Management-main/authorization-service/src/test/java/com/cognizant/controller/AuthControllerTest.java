package com.cognizant.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.exception.InvalidUserException;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.UserLoginCredential;
import com.cognizant.repository.UserRepository;
import com.cognizant.service.CustomerDetailsService;
import com.cognizant.service.JwtUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthControllerTest {
	@InjectMocks
	AuthController authController;

	AuthResponse authResponse;

	UserDetails userdetails;

	@Mock
	JwtUtil jwtutil;

	@Mock
	CustomerDetailsService custdetailservice;

	@Mock
	UserRepository userservice;
	
	@Test
	public void healthTest() {
		ResponseEntity<?> health=authController.healthCheckup();
		assertEquals(health.getStatusCodeValue(), 200);
	}

	@Test
	public void loginTest() throws InvalidUserException {

		UserLoginCredential user = new UserLoginCredential("admin", "admin", null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUid(), user.getPassword(), new ArrayList<>());
		
		when(custdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		
		ResponseEntity<?> login = authController.login(user);
		assertEquals(login.getStatusCodeValue(), 200);
	}

	@Test
	public void loginTestFailed() throws InvalidUserException {

		UserLoginCredential user = new UserLoginCredential("admin", "admin", null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUid(), "admin11", new ArrayList<>());
		
		when(custdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		
		ResponseEntity<?> login = null;
		try {	
			login = authController.login(user);
		
		}
		catch(InvalidUserException e)
		{
			assertEquals("Invalid Username/Password",e.getMessage());
		}
	}

	@Test
	public void validateTestValidtoken() {
		when(jwtutil.validateToken("token")).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("admin");
		
		UserLoginCredential user1 = new UserLoginCredential("admin", "admin", null);
		Optional<UserLoginCredential> data = Optional.of(user1);
		when(userservice.findById("admin")).thenReturn(data);
		
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals(validity.getBody().toString().contains("true"), false);

	}

	@Test
	public void validateTestInValidtoken() {
		when(jwtutil.validateToken("token")).thenReturn(false);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals(validity.getBody().toString().contains("false"), false);
	}

}
