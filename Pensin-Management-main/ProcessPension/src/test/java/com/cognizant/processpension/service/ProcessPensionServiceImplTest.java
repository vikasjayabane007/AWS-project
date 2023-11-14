package com.cognizant.processpension.service;

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


import com.cognizant.processpension.exception.InvalidPensionerDetails;
import com.cognizant.processpension.exception.InvalidTokenException;
import com.cognizant.processpension.feign.FeignCommunicationPensionDisbursement;
import com.cognizant.processpension.feign.FeignCommunicationPensionerDetail;
import com.cognizant.processpension.feign.FeignCommunicationWithAuth;
import com.cognizant.processpension.model.PensionDetail;
import com.cognizant.processpension.model.PensionerDetailPojo;
import com.cognizant.processpension.model.PensionerInput;
import com.cognizant.processpension.model.ProcessPensionInput;
import com.cognizant.processpension.model.ProcessPensionResponse;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProcessPensionServiceImplTest {
	
	@InjectMocks
	private ProcessPensionServiceImpl pensionDetailService;
	@Mock
	private FeignCommunicationPensionerDetail pensionerDetailClient;
	@Mock
	private FeignCommunicationPensionDisbursement pensionDisbursementClient;
	
	@Test
	public void testCalculatePensionAmountIsSelfPension() throws InvalidPensionerDetails {
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerInput pensionerInput = new PensionerInput("om", dob, "LWDSW1141", 546789641236L,"self");
		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "self", "Punjab National Bank", 010120120, "public");
		PensionDetail pensionDetail = new PensionDetail(546789641236L,"om", dob, "LWDSW1141", "self",15600.0);


		assertEquals(pensionDetailService.checkAndCalculate(pensionerInput,pensionerDetail).getAadharNumber(), pensionDetail.getAadharNumber());
	}

	@Test
	public void testCalculatePensionAmountIsFamilyPension() throws InvalidPensionerDetails {
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerInput pensionerInput = new PensionerInput("om", dob, "LWDSW1141", 546789641236L,"family");
		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
		PensionDetail pensionDetail = new PensionDetail(546789641236L,"om", dob, "LWDSW1141", "self",15600.0);


		assertEquals(pensionDetailService.checkAndCalculate(pensionerInput,pensionerDetail).getAadharNumber(), pensionDetail.getAadharNumber());
	}

	@Test
	public void testGetPensionDetail() throws InvalidPensionerDetails, InvalidTokenException {
		String token = "dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();

		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");

		PensionerInput pensionerInput = new PensionerInput("om", dob, "LWDSW1141", 546789641236L,"family");

		Mockito.when(pensionerDetailClient.getDetails(token, pensionerInput.getAadharNumber()))
				.thenReturn(pensionerDetail);
		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput).getAadharNumber(), pensionerDetail.getAadharnumber());
	}

	
//	@Test
//	public void testGetPensionDetailNullCheck() throws InvalidPensionerDetails, InvalidTokenException  {
//		String token = "dummyToken";
//		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
//		Date dob = myCalendar.getTime();
//
//		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
//		PensionerInput pensionerInput = new PensionerInput();
//
//		Mockito.when(pensionerDetailClient.getDetails(token, 1212L)).thenReturn(null);
//		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput), null);
//	}
	
	@Test
	public void testGetPensionDetailValidInput() throws InvalidPensionerDetails {
		String token = "dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();

		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");

		PensionerInput pensionerInput = new PensionerInput("om", dob, "LWDSW1141", 546789641236L,"family");
		assertEquals(pensionerInput.getName(), pensionerDetail.getName());
		assertEquals(pensionerInput.getDateOfBirth(), pensionerDetail.getDateofbirth());
		assertEquals(pensionerInput.getPan(), pensionerDetail.getPan());
		assertEquals(pensionerInput.getPensionType(), pensionerDetail.getPensiontype());
	}
	
	@Test
	public void testGetPensionDetailInValidInput() throws InvalidPensionerDetails, InvalidTokenException {
		String token = "dummyToken";
		
		Calendar myCalendar1 = new GregorianCalendar(1988, 12, 8);
		Date dob1 = myCalendar1.getTime();
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");

		PensionerInput pensionerInput = new PensionerInput("soni", dob1, "LWDSW18441", 956789641236L,"self");
		assertNotEquals(pensionerInput.getName(), pensionerDetail.getName());
		assertNotEquals(pensionerInput.getDateOfBirth(), pensionerDetail.getDateofbirth());
		assertNotEquals(pensionerInput.getPan(), pensionerDetail.getPan());
		assertNotEquals(pensionerInput.getPensionType(), pensionerDetail.getPensiontype());
	}
	
	// PensionerDisbursementService
//		@Test
//		public void testGetDisbursementCodeSucess() throws InvalidPensionerDetails {
//			String token = "dummyToken";
//			ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 550.0);
//			ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(10);
//			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
//			Date dob = myCalendar.getTime();
//			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
//
//			Mockito.lenient().when(pensionerDetailClient.getDetails(token, pensionerDetail.getAadharnumber())).thenReturn(pensionerDetail);
//
//			Mockito.lenient().when(pensionDisbursementClient.evaluation(token, ppi)).thenReturn(processPensionResponse);
//			assertEquals(processPensionResponse,pensionDetailService.processPensionInput(token, ppi));
//		
//		}
//
//		@Test
//		public void testGetDisbursementCodeNotPaid() throws InvalidPensionerDetails {
//			String token = "dummyToken";
//			ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 550.0);
//			ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(20);
//
//			Mockito.lenient().when(pensionDisbursementClient.evaluation(token, ppi)).thenReturn(processPensionResponse);
//			assertEquals(pensionDetailService.processPensionInput(token, ppi), processPensionResponse);
//		}
//
//		@Test
//		public void testGetDisbursementCodeUnknownError() throws InvalidPensionerDetails {
//			String token = "dummyToken";
//			ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 550.0);
//			ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(21);
//
//			Mockito.lenient().when(pensionDisbursementClient.evaluation(token, ppi)).thenReturn(processPensionResponse);
//			assertEquals(pensionDetailService.processPensionInput(token, ppi), processPensionResponse);
//		}
		@Test
		public void testGetPensionDetailInValidInputName() throws InvalidPensionerDetails, InvalidTokenException {
			String token = "dummyToken";
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1978, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("Sanjay Guleria", dob1, "AAA12569CC", 546789641236L,"family");
			assertNotEquals(pensionerDetail.getName(), input.getName());
			
		}
		@Test
		public void testGetPensionDetailValidInputName() throws InvalidPensionerDetails {
			String token = "dummyToken";
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertEquals(pensionerDetail.getName(), input.getName());
			assertEquals(pensionerDetail.getPensiontype(), input.getPensionType());
		}
		@Test
		public void testGetPensionDetailInValidInputDob() throws InvalidPensionerDetails, InvalidTokenException {
			String token = "dummyToken";
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1978, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertNotEquals(pensionerDetail.getDateofbirth(), input.getDateOfBirth());
		}
		@Test
		public void testGetPensionDetailValidInputDob() throws InvalidPensionerDetails {
			String token = "dummyToken";
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertEquals(pensionerDetail.getDateofbirth(), input.getDateOfBirth());
			assertEquals(pensionerDetail.getPensiontype(), input.getPensionType());
		}
		@Test
		public void testGetPensionDetailInValidInputPan() throws InvalidPensionerDetails, InvalidTokenException {
			String token = "dummyToken";
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "MKWDSW1141", 546789641236L,"family");
			assertNotEquals(input.getPan(), pensionerDetail.getPan());
		
		}
		@Test
		public void testGetPensionDetailValidInputPan() throws InvalidPensionerDetails {
			String token = "dummyToken";
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertEquals(input.getPan(), pensionerDetail.getPan());
		}
		@Test
		public void testGetPensionDetailInValidInputisSelf() throws InvalidPensionerDetails, InvalidTokenException {
			String token = "dummyToken";
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "self", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertNotEquals(input.getPensionType(), pensionerDetail.getPensiontype());
		
		}
		@Test
		public void testGetPensionDetailValidInputSelf() throws InvalidPensionerDetails {
			String token = "dummyToken";
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertEquals(input.getPensionType(), pensionerDetail.getPensiontype());
		}

}                                             

