package com.cognizant.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.PensionerDetailApplication;
import com.cognizant.exception.InvalidAdhaarNumber;
import com.cognizant.exception.InvalidTokenException;
import com.cognizant.feign.FeignCommunicationWithAuth;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.PensionerDetail;
import com.cognizant.service.PensionerDetailServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PensionerDetailApplication.class)
public class PensionerDetailControllerTest {
	@Mock
	private FeignCommunicationWithAuth feignWithAuth;
	
	@Mock
	private PensionerDetailServiceImpl service;
	
	@InjectMocks
	private PensionerDetailController controller;
	
	@Mock
	private AuthResponse response;
	List<PensionerDetail> pensiondetail;
	ResponseEntity<AuthResponse> responseentity;
	
	@Before
	 public void setup()
	{   Date date=new Date();
		response = new AuthResponse("a@gmail.com",true);
		responseentity = new ResponseEntity<>(response,HttpStatus.OK);
		
		pensiondetail = new ArrayList<>();
		pensiondetail.add(new PensionerDetail(1238786L, "puja",date, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private"));
		pensiondetail.add(new PensionerDetail(1239786L, "ruja",date, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private"));
		
	}
	
	@Test
	public void testGetByIdNotNull() throws InvalidAdhaarNumber, InvalidTokenException {
		Date date=new Date();
		PensionerDetail pensiondetail= new PensionerDetail(1238786L, "puja",date, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private");
		when(feignWithAuth.validate("token")).thenReturn(responseentity);
		when(service.getById(1238786L)).thenReturn((pensiondetail));	
		PensionerDetail response = controller.findById("token",1238786L);
		assertNotNull(response);
	}
	
	@Test
	public void testGetByIdPass() throws InvalidAdhaarNumber, InvalidTokenException {
		Date date=new Date();
		PensionerDetail pensiondetail= new PensionerDetail(1238786L, "puja",date, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private");
		when(feignWithAuth.validate("token")).thenReturn(responseentity);
		when(service.getById(1238786L)).thenReturn((pensiondetail));	
		PensionerDetail response = controller.findById("token",1238786L);
		assertEquals(pensiondetail,response);
	}
	

	
	
	
	@Test
	public void getByIdNotFoundTest() throws InvalidAdhaarNumber, InvalidTokenException {
		when(feignWithAuth.validate("token")).thenReturn(responseentity);
		when(service.getById(1238786L)).thenReturn(null);
		
	Exception exception = assertThrows(InvalidAdhaarNumber.class, () -> {
		controller.findById("token",1238786L);
    });
 
    String expectedMessage = "The Adhaar Number is Invalid or Unregistered";
    String actualMessage = exception.getMessage();
 
    assertEquals(actualMessage,expectedMessage);
	}
     
	

}
