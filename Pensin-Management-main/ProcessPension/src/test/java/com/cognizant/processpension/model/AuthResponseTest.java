package com.cognizant.processpension.model;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;





//@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AuthResponseTest 
{
	AuthResponse authResponse=new AuthResponse();
	
	@Test
	public void testAuthResponseConstructor()
	{
		AuthResponse response=new AuthResponse("abc", true);
		assertEquals(response.getUid(), "abc");
	}
	
	@Test
	public void testUid()
	{
		authResponse.setUid("abc");
		authResponse.setValid(true);
		assertEquals(authResponse.getUid(), "abc");
	}  

	@Test
	public void testIsValid()
	{
		authResponse.setValid(true);
		assertEquals(authResponse.isValid(), true);
	}
	
	@Test
	public void testtoString() 
	{
        String s = authResponse.toString();
        assertEquals(authResponse.toString(), s);
    }
	
}
