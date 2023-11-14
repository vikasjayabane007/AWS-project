package com.cognizant.model;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthResponseTest {

		

		@Test
		public void gettersetterAuthResponseTest() {
			AuthResponse response = new AuthResponse();
		
			response.setUid("testuid");
			response.setValid(true);

			
			assertEquals("testuid", response.getUid());
			assertEquals(true, response.isValid());
		}

		@Test
		public void constructerAuthResponseTest() {
			AuthResponse responseNoArg = new AuthResponse();
			assertNotNull(responseNoArg);
			AuthResponse responseAllArg = new AuthResponse("testuid", true);
			assertNotNull(responseAllArg);
		}



		
	}


