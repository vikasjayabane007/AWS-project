package com.cognizant.processpension.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class PensionerDetailPojoTest {

 
	@Autowired
	PensionerDetailPojo pension;
	
	@Test
	public void constructerMenuItemTest()
		{
		PensionerDetailPojo pensiondetailNoArg = new PensionerDetailPojo();
		assertNotNull(pensiondetailNoArg);
		PensionerDetailPojo pensiondetailAllArg = new PensionerDetailPojo(203456716542L, "puja",null, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private");
		assertNotNull(pensiondetailAllArg);
		}
		
		
	@Test
	public void gettersetterPensionerDetailTest() {
		Date date = new Date();
		 
		PensionerDetailPojo  pensiondetail = new PensionerDetailPojo();
		pensiondetail.setAadharnumber(203456716542L);
		pensiondetail.setName("puja");
		pensiondetail.setDateofbirth(date);
		pensiondetail.setPan("CQEPB6781");
		pensiondetail.setSalaryearned(78900.10);
		pensiondetail.setAllowances(9870);
		pensiondetail.setPensiontype("self");
		pensiondetail.setBankname("HDFC Bank");
		pensiondetail.setAccountnumber(206535211);
		pensiondetail.setPublicorprivate("private");
		assertEquals(203456716542L,pensiondetail.getAadharnumber());
		assertEquals("puja",pensiondetail.getName());
		assertEquals(date,pensiondetail.getDateofbirth());
		assertEquals("CQEPB6781",pensiondetail.getPan());
		assertEquals(78900.10,pensiondetail.getSalaryearned());
		assertEquals(9870,pensiondetail.getAllowances());
		assertEquals("self",pensiondetail.getPensiontype());
		assertEquals("HDFC Bank",pensiondetail.getBankname());
		assertEquals(206535211,pensiondetail.getAccountnumber());
		assertEquals("private",pensiondetail.getPublicorprivate());
		
		
	}
		
		
		



	

 
	
	

}
