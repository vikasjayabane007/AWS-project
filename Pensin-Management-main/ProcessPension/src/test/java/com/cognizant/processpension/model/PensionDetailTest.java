package com.cognizant.processpension.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;


class PensionDetailTest {

	@Test
	void testPensionDetailLongStringDateStringStringDouble() {

		PensionDetail pensiondetailAllArg = new PensionDetail(203456716542L, "puja",null, "CQEPB2341","self", 67645343);
		assertNotNull(pensiondetailAllArg);
	}

	@Test
	void testPensionDetail() {
		
		PensionDetail pensiondetailNoArg = new PensionDetail();
		assertNotNull(pensiondetailNoArg);
	}

	@Test
	void testGettersAndSetters() {
		
		Date date  = new Date();
		PensionDetail  pensiondetail = new PensionDetail();
		pensiondetail.setAadharNumber(203456716542L);
		pensiondetail.setName("puja");
		pensiondetail.setDateOfBirth(date);
		pensiondetail.setPan("CQEPB6781");
		pensiondetail.setPensionType("self");
		pensiondetail.setPensionAmount(4000);
		
		assertEquals(203456716542L,pensiondetail.getAadharNumber());
		assertEquals("puja",pensiondetail.getName());
		assertEquals(date,pensiondetail.getDateOfBirth());
		assertEquals("CQEPB6781",pensiondetail.getPan());
		assertEquals("self",pensiondetail.getPensionType());
		assertEquals(4000,pensiondetail.getPensionAmount());
		
		
	}

}
