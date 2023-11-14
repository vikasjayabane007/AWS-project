package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
