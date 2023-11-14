package com.cognizant.model;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PensionerDetailTest {
		
	@Autowired
	PensionerDetail pension;
	
	@Test
	public void constructerMenuItemTest()
		{
		PensionerDetail pensiondetailNoArg = new PensionerDetail();
		assertNotNull(pensiondetailNoArg);
		PensionerDetail pensiondetailAllArg = new PensionerDetail(203456716542L, "puja",null, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private");
		assertNotNull(pensiondetailAllArg);
		}
		
		
	@Test
	public void gettersetterPensionerDetailTest() {
		Date date = new Date();
		 
		PensionerDetail  pensiondetail = new PensionerDetail();
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
