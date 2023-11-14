package com.cognizant.pensiondisbursement.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ProcessPensionResponseTest {

	@Test
	public void gettersetterProcessPensionResponseTest() {

		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();

		processPensionResponse.setProcessPensionStatusCode(10);

		assertEquals(10, processPensionResponse.getProcessPensionStatusCode());

	}
	
	@Test
	public void constructerProcessPensionResponseTest() {
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		assertNotNull(processPensionResponse);
		ProcessPensionResponse processPensionResponseAllArg=new ProcessPensionResponse(10);
		assertNotNull(processPensionResponseAllArg);
	}
	
	

			@Test
			public void toStringProcessPensionResponseTest() {
				ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();

				processPensionResponse.setProcessPensionStatusCode(10);

				
				assertTrue(processPensionResponse.toString().startsWith(ProcessPensionResponse.class.getSimpleName()));
				assertTrue(processPensionResponse.toString().endsWith("(processPensionStatusCode=10)"));
			}

}
