package com.cognizant.processpension.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PensionerInputTest {

	@Autowired
	PensionerInput input;
	
	
	@Test
	public void testPensionerInputStringDateStringLongString() {
		Date date = new Date();
		input = new PensionerInput("James",date,"FHGDB123KG",867589764897L,"family");
		assertNotNull(input);
	}

	@Test
	public void testPensionerInput() {
		input = new PensionerInput();
		assertNotNull(input);
	}

	@Test
	public void testGettersAndSetters()
	{
		PensionerInput input = new PensionerInput();
		Date date = new Date();
		input.setName("Ronik");
		input.setAadharNumber(1246787534L);
		input.setDateOfBirth(date);
		input.setPan("FHGDB123KG");
		input.setPensionType("self");
		
		assertEquals("Ronik",input.getName());
		assertEquals(1246787534L,input.getAadharNumber());
		assertEquals("FHGDB123KG",input.getPan());
		assertEquals("self",input.getPensionType());	
	}
	
}
