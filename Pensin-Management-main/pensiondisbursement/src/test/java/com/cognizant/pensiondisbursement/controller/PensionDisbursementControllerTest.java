package com.cognizant.pensiondisbursement.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.pensiondisbursement.exception.PensionerDetailException;
import com.cognizant.pensiondisbursement.exception.TokenInvalidException;
import com.cognizant.pensiondisbursement.model.PensionerDetail;
import com.cognizant.pensiondisbursement.model.ProcessPensionInput;
import com.cognizant.pensiondisbursement.model.ProcessPensionResponse;
import com.cognizant.pensiondisbursement.restclients.PensionerDetailClient;
import com.cognizant.pensiondisbursement.service.PensionDisbursementService;
import com.cognizant.pensiondisbursement.service.PensionDisbursementServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PensionDisbursementControllerTest {

	@InjectMocks
	private PensionDisbursementController pensionDisbursementController;
	@Mock
	private PensionDisbursementServiceImpl pensionDisbursementService;
	@Mock
	private PensionerDetailClient pensionerDetailClient;

	@Test
	public void testGetPensionDisbursementSuccess() throws  TokenInvalidException, PensionerDetailException {
		String token = "dummyToken";
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(10);
		ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 550.0);
		Mockito.when(pensionDisbursementService.getPensionDisbursement(token, ppi)).thenReturn(processPensionResponse);
		assertEquals(pensionDisbursementController.getPensionDisbursement(token, ppi), processPensionResponse);
	
		
	}

	@Test
	public void testGetPensionDisbursementServiceChargeNotPaid()
			throws  TokenInvalidException, PensionerDetailException {
		String token = "dummyToken";
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(20);

		ProcessPensionInput ppi2 = new ProcessPensionInput(546789641236L, 15600.0, 0.0);
		Mockito.when(pensionDisbursementService.getPensionDisbursement(token, ppi2)).thenReturn(processPensionResponse);
		assertEquals(pensionDisbursementController.getPensionDisbursement(token, ppi2), processPensionResponse);
	}
	
	@Test
	public void testGetPensionDisbursementUnkownError() throws  TokenInvalidException, PensionerDetailException {
		String token = "dummyToken";
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(21);

		ProcessPensionInput ppi3 = new ProcessPensionInput(546789641236L, 15600.0, 500.0);
		Mockito.when(pensionDisbursementService.getPensionDisbursement(token, ppi3)).thenReturn(processPensionResponse);
		assertEquals(pensionDisbursementController.getPensionDisbursement(token, ppi3), processPensionResponse);
	}
}
