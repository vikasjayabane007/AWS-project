package com.cognizant.pensiondisbursement.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class PensionerDetailTest {

	@Test
	public void gettersetterPensionerDetail() {
		PensionerDetail pensionerDetail = new PensionerDetail();
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		pensionerDetail.setAadharnumber(880205562);
		pensionerDetail.setAccountnumber(010120120);
        pensionerDetail.setAllowances(111.21);
        pensionerDetail.setBankname("Punjab National Bank");
        pensionerDetail.setDateofbirth(dob);
        pensionerDetail.setName("om");
        pensionerDetail.setPan("LWDSW1141");
        pensionerDetail.setPensiontype("self");
        pensionerDetail.setPublicorprivate("private");
        pensionerDetail.setSalaryearned(20500.3);
        assertEquals(880205562, pensionerDetail.getAadharnumber());
		assertEquals(010120120, pensionerDetail.getAccountnumber());
		assertEquals("Punjab National Bank", pensionerDetail.getBankname());
		assertEquals(dob, pensionerDetail.getDateofbirth());
		assertEquals("om", pensionerDetail.getName());
		assertEquals("LWDSW1141", pensionerDetail.getPan());
		assertEquals("self", pensionerDetail.getPensiontype());
		assertEquals("private", pensionerDetail.getPublicorprivate());
		assertEquals(111.21, pensionerDetail.getAllowances());
		assertEquals(20500.3, pensionerDetail.getSalaryearned());
		
	}
	
	@Test
	public void constructerPensionerDetailTest() {
		PensionerDetail pensionerDetail = new PensionerDetail();
		assertNotNull(pensionerDetail);
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerDetail pensionerDetailAlArgs = new PensionerDetail(880205562, "om", dob, "LWDSW1141", 2020.20, 111.21, "self", "Punjab National Bank", 010120120, "public");
		assertNotNull(pensionerDetailAlArgs);
	}
	
	
	
	@Test
	public void toStringPensionerDetailTest() {
		PensionerDetail pensionerDetail = new PensionerDetail();
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		pensionerDetail.setAadharnumber(880205562);
		pensionerDetail.setAccountnumber(010120120);
        pensionerDetail.setAllowances(111.21);
        pensionerDetail.setBankname("Punjab National Bank");
       pensionerDetail.setDateofbirth(dob);
        pensionerDetail.setName("om");
        pensionerDetail.setPan("LWDSW1141");
        pensionerDetail.setPensiontype("self");
        pensionerDetail.setPublicorprivate("private");
        pensionerDetail.setSalaryearned(20500.3);
		assertTrue(pensionerDetail.toString().startsWith(PensionerDetail.class.getSimpleName()));
		assertTrue(pensionerDetail.toString().endsWith("(aadharnumber=880205562, name=om, dateofbirth=Fri Jan 08 00:00:00 IST 1999, pan=LWDSW1141, salaryearned=20500.3, allowances=111.21, pensiontype=self, bankname=Punjab National Bank, accountnumber=2138192, publicorprivate=private)"));
	}

	
	
	
	
}
