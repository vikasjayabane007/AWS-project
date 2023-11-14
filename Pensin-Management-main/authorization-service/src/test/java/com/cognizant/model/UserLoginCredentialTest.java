package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginCredentialTest 
{
	UserLoginCredential userHospital=new UserLoginCredential();
	
	@Test
	public void testUserHospitalAllConstructor()
	{
		UserLoginCredential hospital=new UserLoginCredential("ab", "ab", null);
		assertEquals(hospital.getUid(), "ab");
	}
	
	@Test
	public void testUserid()
	{
		userHospital.setUid("abc");
		assertEquals(userHospital.getUid(), "abc");
	}
	
	@Test
	public void testUserPassword()
	{
		userHospital.setPassword("abc");
		assertEquals(userHospital.getPassword(), "abc");
	}
	
	@Test
	public void testAuthToken()
	{
		userHospital.setToken("abc");
		assertEquals(userHospital.getToken(),"abc");
	}
	
	@Test
	public void testoString() {
		String string = userHospital.toString();
		assertEquals(userHospital.toString(),string);
	}
}
