package com.cognizant.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.PensionerDetailApplication;
import com.cognizant.dao.PensionerDetailDao;
import com.cognizant.model.PensionerDetail;
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PensionerDetailApplication.class)
public class PensionerDetailserviceImplTest {
	
	
	@InjectMocks
	PensionerDetailServiceImpl service;
	
	@Mock
	PensionerDetailDao dao;
	
	@Mock
     PensionerDetail pensiondetail;
	
	@Test
	public void getByIdTest() {
		
	         Optional<PensionerDetail> pensiondetail = Optional.of(new PensionerDetail(15625612L, "rohan",null,"hasuhiu", 200, 23440, "dhjfsd","hasjhsaj",2000, "hjjsadsa")); 
			 long aadharnumber=15625612L;
	         when(dao.findById(aadharnumber)).thenReturn(pensiondetail);
			 assertEquals(pensiondetail.orElse(null), service.getById(aadharnumber));
		}
	

	
	
		  
	}

