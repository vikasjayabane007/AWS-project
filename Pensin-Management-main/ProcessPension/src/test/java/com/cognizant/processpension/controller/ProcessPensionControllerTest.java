package com.cognizant.processpension.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.processpension.exception.InvalidPensionerDetails;
import com.cognizant.processpension.exception.InvalidTokenException;
import com.cognizant.processpension.feign.FeignCommunicationWithAuth;
import com.cognizant.processpension.model.AuthResponse;
import com.cognizant.processpension.model.PensionDetail;
import com.cognizant.processpension.model.PensionerInput;
import com.cognizant.processpension.model.ProcessPensionInput;
import com.cognizant.processpension.model.ProcessPensionResponse;
import com.cognizant.processpension.service.ProcessPensionService;
import com.cognizant.processpension.service.ProcessPensionServiceImpl;

/*
 import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;





@RunWith(SpringRunner.class)
 
 
 */

@SpringBootTest
@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)
class ProcessPensionControllerTest {

	@InjectMocks
	ProcessPensionController processPensionController;
	@Mock
	private ProcessPensionServiceImpl pensionDetailService;
	
	@Mock
	private FeignCommunicationWithAuth authClient;
	
	@Test
	public void testGetPensionDetail() throws InvalidPensionerDetails, InvalidTokenException {
		String token = "dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		AuthResponse authResponse =new AuthResponse("dummyuser",true);
		ResponseEntity<AuthResponse> auth=new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
		PensionerInput input = new PensionerInput("Sanjay Guleria", dob, "AAA12569CC", 546789641236L,"self");
		PensionDetail pensionDetail = new PensionDetail(546789641236L,"Sanjay Guleria", dob, "AAA12569CC", "self",15600.0);
	 
		 Mockito.lenient().when(authClient.validate(token)).thenReturn(auth);
		Mockito.lenient().when(pensionDetailService.getPensionDetail(token, input)).thenReturn(pensionDetail);
		
		
	assertNotNull(processPensionController.getPensionDetail(input,token));
//	assertEquals(processPensionController.getPensionDetail(input,token).getBody().getAadharNumber(), pensionDetail.getAadharNumber());
	

	}
	
	
	@Test
	public void testGetDisbursementCodeSuccess() throws InvalidPensionerDetails, InvalidTokenException {
		String token = "dummyToken";
		ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 550.0);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(10);
		Mockito.lenient().when(pensionDetailService.processPensionInput(token, ppi)).thenReturn(processPensionResponse);
		assertEquals(processPensionController.processPension(token, ppi), processPensionResponse);
	}
	

	@Test
	public void testGetDisbursementCodeServiceChargeNotPaid() throws InvalidPensionerDetails, InvalidTokenException {
		String token = "dummyToken";
		ProcessPensionInput ppi2 = new ProcessPensionInput(546789641236L, 15600.0, 0.0);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(20);

		Mockito.when(pensionDetailService.processPensionInput(token, ppi2)).thenReturn(processPensionResponse);
		assertEquals(processPensionController.processPension(token, ppi2), processPensionResponse);
	}
	
	@Test
	public void testGetDisbursementCodeUnknownError() throws InvalidPensionerDetails, InvalidTokenException {
		String token = "dummyToken";
		ProcessPensionInput ppi3 = new ProcessPensionInput(546789641236L, 15600.0, 500.0);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(21);

		Mockito.when(pensionDetailService.processPensionInput(token, ppi3)).thenReturn(processPensionResponse);
		assertEquals(processPensionController.processPension(token, ppi3), processPensionResponse);
	}


	

}
