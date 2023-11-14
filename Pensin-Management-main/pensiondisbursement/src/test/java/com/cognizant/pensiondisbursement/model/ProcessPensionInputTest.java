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
class ProcessPensionInputTest {

	

	@Test
	public void gettersetterProcessPensionInputTest() {
		
		ProcessPensionInput processPensionInput=new ProcessPensionInput();
	    
		processPensionInput.setAadharNumber((long) 880205562);
		processPensionInput.setBankCharge(550.00);
		processPensionInput.setPensionAmount(25500.00);
	
		assertEquals(880205562, processPensionInput.getAadharNumber());
		assertEquals(550.00, processPensionInput.getBankCharge());
		assertEquals(25500.00, processPensionInput.getPensionAmount());
		
		
	}
	
	
	
	@Test
	public void constructerProcessPensionInputTest() {
		ProcessPensionInput processPensionInput=new ProcessPensionInput();	
		assertNotNull(processPensionInput);
		ProcessPensionInput processPensionInputAllAgr=new ProcessPensionInput((long)880205562, 550.00, 25500.00);
		assertNotNull(processPensionInputAllAgr);
	}
	
	
	
	@Test
	public void toStringProcessPensionInputTest() {
	ProcessPensionInput processPensionInput=new ProcessPensionInput();
	    
		processPensionInput.setAadharNumber((long) 880205562);
		processPensionInput.setBankCharge(550.00);
		processPensionInput.setPensionAmount(25500.00);
		assertTrue(processPensionInput.toString().startsWith(ProcessPensionInput.class.getSimpleName()));
		assertTrue(processPensionInput.toString().endsWith("(aadharNumber=880205562, pensionAmount=25500.0, bankCharge=550.0)"));
	}

}
