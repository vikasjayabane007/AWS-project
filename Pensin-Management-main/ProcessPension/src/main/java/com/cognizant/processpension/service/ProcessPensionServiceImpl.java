package com.cognizant.processpension.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.processpension.dao.ProcessPensionDao;
import com.cognizant.processpension.exception.InvalidPensionerDetails;
import com.cognizant.processpension.feign.FeignCommunicationPensionDisbursement;
import com.cognizant.processpension.feign.FeignCommunicationPensionerDetail;
import com.cognizant.processpension.model.PensionDetail;
import com.cognizant.processpension.model.PensionerDetailPojo;
import com.cognizant.processpension.model.PensionerInput;
import com.cognizant.processpension.model.ProcessPensionInput;
import com.cognizant.processpension.model.ProcessPensionResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessPensionServiceImpl implements ProcessPensionService{

	@Autowired 
	ProcessPensionDao repo;
	
	@Autowired
	private FeignCommunicationPensionerDetail feignWithPensionerDetail;
	
	@Autowired
	private PensionerDetailPojo pensionerDetail;
	@Autowired
	private FeignCommunicationPensionDisbursement feignWithDisbursement;
	
	
	@Override
	public PensionDetail checkAndCalculate(PensionerInput obj1, PensionerDetailPojo obj2) throws InvalidPensionerDetails {
		
		double pensionAmount = 0;
		if (obj1.getName().equalsIgnoreCase(obj2.getName()) && obj1.getDateOfBirth().compareTo(obj2.getDateofbirth())==0  && obj1.getPan().equals(obj2.getPan()) && obj1.getPensionType().equals(obj2.getPensiontype()))
		{
			log.debug("Calculating Pension Amount");
			if(obj2.getPensiontype().equalsIgnoreCase("self"))
					pensionAmount = (obj2.getSalaryearned() * 0.8)  + obj2.getAllowances();
			else
				pensionAmount = ( obj2.getSalaryearned() * 0.5 ) + obj2.getAllowances();
			
			if(obj2.getPublicorprivate().equalsIgnoreCase("private"))
				pensionAmount+=550;
			else
				pensionAmount+=500;
			
			return new PensionDetail(obj2.getAadharnumber(),obj2.getName(),
					obj2.getDateofbirth(),obj2.getPan(),obj2.getPensiontype(),pensionAmount);
		}
		else {
			log.error("Validation Error");
//			throw new InvalidPensionerDetails("Invalid pensioner detail provided, please provide valid detail.");
			return  null;
		}
		
	}

	@Override
	public PensionDetail getPensionDetail(String header,PensionerInput pensionerInput) throws InvalidPensionerDetails {
		 
		pensionerDetail = null;
		PensionDetail pensionDetail = null;
		 try {
		 pensionerDetail = feignWithPensionerDetail.getDetails(header,pensionerInput.getAadharNumber());
		 log.error("Checking.... ");
		 pensionDetail=checkAndCalculate(pensionerInput,pensionerDetail);
		 }
		 catch(Exception e)
		 {
			 log.error("Details Incorrect");
			 return null;
		 }
		return pensionDetail; 
	}

	@Override
	public ProcessPensionResponse processPensionInput(String header, ProcessPensionInput pensionInput) {
		ProcessPensionResponse responsecode=null;
		responsecode = feignWithDisbursement.evaluation(header,pensionInput);
		
		if(responsecode==null)
			return responsecode;
		if(responsecode.getProcessPensionStatusCode()==10)
		{
			//Save User To DB
			PensionDetail pensionDetail = new PensionDetail(pensionerDetail.getAadharnumber(),pensionerDetail.getName(),pensionerDetail.getDateofbirth(),
					pensionerDetail.getPan(),pensionerDetail.getPensiontype(),pensionInput.getPensionAmount());
			repo.save(pensionDetail);
			return responsecode;
		}
		return responsecode;
		
	}

}
