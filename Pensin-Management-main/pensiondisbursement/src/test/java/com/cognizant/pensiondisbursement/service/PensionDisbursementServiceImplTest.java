package com.cognizant.pensiondisbursement.service;

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
import com.cognizant.pensiondisbursement.model.PensionerDetail;
import com.cognizant.pensiondisbursement.model.ProcessPensionInput;
import com.cognizant.pensiondisbursement.model.ProcessPensionResponse;
import com.cognizant.pensiondisbursement.restclients.PensionerDetailClient;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PensionDisbursementServiceImplTest {
	@InjectMocks
	private PensionDisbursementServiceImpl pensionDisbursementService;
	@Mock
	private PensionerDetailClient pensionerDetailClient;

	@Test
	public void testGetPensionDetail() throws PensionerDetailException {
		String token="demoToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerDetail pensionerDetail = new PensionerDetail(8802055682L, "om", dob, "LWDSW1141",18000.0, 111.21, "self", "Punjab National Bank", 010120120, "public");
		Mockito.lenient().when(pensionerDetailClient.getPensionerDetails(token, 8802055682L)).thenReturn(pensionerDetail);
	assertEquals(pensionerDetail,pensionDisbursementService.getPensionDetail(token, 8802055682L));
	}
	
	@Test
	public void testGetPensionDisbursementSuccess() throws PensionerDetailException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(10);

		PensionerDetail pensionerDetail = new PensionerDetail(546789641236L, "om", dob, "LWDSW1141", 15600.0, 111.21, "self", "Punjab National Bank", 010120120, "public");
	ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 13091.21, 500.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(processPensionResponse,pensionDisbursementService.getPensionDisbursement(token,ppi));
	}
	

	@Test
	public void testGetPensionDisbursementServiceChargeNotPaid() throws PensionerDetailException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(20);

		PensionerDetail pensionerDetail = new PensionerDetail(546789641236L, "om", dob, "LWDSW1141", 18000.0, 111.21, "self", "Punjab National Bank", 010120120, "public");
	ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 14511.21, 0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),processPensionResponse);
	}
	
	
	@Test
	public void testGetPensionDisbursementUnknownError() throws PensionerDetailException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(21);
		PensionerDetail pensionerDetail = new PensionerDetail(546789641236L, "om", dob, "LWDSW1141", 18000.0, 111.21, "self", "Punjab National Bank", 010120120, "public");

	ProcessPensionInput ppi = new ProcessPensionInput(546789641236L,14511.21, 900.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),processPensionResponse);
	}
	
//	@Test
//	public void testGetPensionDisbursementWrongAadhar() throws PensionerDetailException {
//		String token="dummyToken";
//		PensionerDetail pensionerDetail = new PensionerDetail();
//		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(0);
//
//	ProcessPensionInput ppi = new ProcessPensionInput(5467896416L, 15600.0, 900.0);
//	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
//	assertEquals(processPensionResponse,pensionDisbursementService.getPensionDisbursement(token,ppi));
//	}
	
	@Test
	public void testGetPensionDisbursementPrivateBankSuccess() throws PensionerDetailException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1995, 7, 10);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(10);

		PensionerDetail pensionerDetail = new PensionerDetail(546789641236L, "soni", dob, "LWDSW1141", 9200.0, 1121.21, "self", "Punjab National Bank", 29874651, "private");

	ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 9031.21, 550.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(processPensionResponse,pensionDisbursementService.getPensionDisbursement(token,ppi)); 
	}
	
	@Test
	public void testGetPensionDisbursementPrivateBankChargeNotPaid() throws PensionerDetailException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1995, 7, 10);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(20);

		PensionerDetail pensionerDetail = new PensionerDetail(546789641236L, "soni", dob, "LWDSW1141", 9200.0, 1121.21, "self", "Punjab National Bank", 29874651, "private");

	ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 8481.21, 0.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(processPensionResponse,pensionDisbursementService.getPensionDisbursement(token,ppi));
	}
	
	@Test
	public void testGetPensionDisbursementPrivateBankUnknownError() throws PensionerDetailException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1995, 7, 10);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(21);
		PensionerDetail pensionerDetail = new PensionerDetail(546789641236L, "soni", dob, "LWDSW1141", 16000.0, 1121.21, "self", "Punjab National Bank", 29874651, "private");

	ProcessPensionInput ppi = new ProcessPensionInput(264819375648L, 13921.21, 5250.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),processPensionResponse);
	}
	@Test
	public void testGetPensionDisbursementUnknownErrorWrongBankType() throws PensionerDetailException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1995, 7, 10);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(21);
		PensionerDetail pensionerDetail = new PensionerDetail(546789641236L, "soni", dob, "LWDSW1141", 16000.0, 1121.21, "self", "wrong Bank", 29874651, "private");

	ProcessPensionInput ppi = new ProcessPensionInput(264819375648L, 13921.21, 5250.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),processPensionResponse);
	}
	
}
