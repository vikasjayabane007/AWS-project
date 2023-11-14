package com.cognizant.pensiondisbursement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pensiondisbursement.exception.PensionerDetailException;
import com.cognizant.pensiondisbursement.model.PensionerDetail;
import com.cognizant.pensiondisbursement.model.ProcessPensionInput;
import com.cognizant.pensiondisbursement.model.ProcessPensionResponse;
import com.cognizant.pensiondisbursement.restclients.PensionerDetailClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionDisbursementServiceImpl implements PensionDisbursementService {

	@Autowired
	private PensionerDetailClient pensionerDetailClient;

	private final static int SUCCESS = 10;
	private final static int PAYCREDIT = 20;
	private final static int UNKNOWN = 21;
	private final static int WRONGAADHAR = 0;
	private final static String PUBLIC = "public";
	private final static String PRIVATE = "private";

	@Override
	public ProcessPensionResponse getPensionDisbursement(String token, ProcessPensionInput processPensionInput) throws PensionerDetailException {
		log.debug("getPensionDisbursement() method invoked inside DisbursePension Microservice"); 
		PensionerDetail pensionDetail = null;
		
			pensionDetail = getPensionDetail(token, processPensionInput.getAadharNumber());
			
			double pensionAmountCheck=0;
	
		Double bankCharge = processPensionInput.getBankCharge();
		if(pensionDetail.getPensiontype().equalsIgnoreCase("self")) {
			pensionAmountCheck =  pensionDetail.getSalaryearned() * 0.8 ;
			pensionAmountCheck+=pensionDetail.getAllowances();
		} 
		else
		{
			pensionAmountCheck =  pensionDetail.getSalaryearned() * 0.5 ;
			pensionAmountCheck+=pensionDetail.getAllowances();
		}
		
		if(bankCharge == 0)
		{ 
			return new ProcessPensionResponse(PAYCREDIT);
		}
		else if ((bankCharge ==500 || bankCharge ==550)  && (processPensionInput.getPensionAmount()  ==pensionAmountCheck + bankCharge) )
		{
			return new ProcessPensionResponse(SUCCESS);// Pension disbursement Success
		}
		else if ((bankCharge ==500 || bankCharge ==550)  && (processPensionInput.getPensionAmount()  !=pensionAmountCheck + bankCharge) )
		{
			return new ProcessPensionResponse(UNKNOWN);// Pension disbursement Success
		}
		else
		{
			return new ProcessPensionResponse(UNKNOWN);
		}
	}

	public PensionerDetail getPensionDetail(String token, long aadharNumber) throws PensionerDetailException   {
		log.debug("Fetching PensionDetails of The Pensioner from PensionDetail Microservice");
		PensionerDetail obj =null;
		try {
			obj = pensionerDetailClient.getPensionerDetails(token, aadharNumber);
		}
		catch(Exception e)
		{
		throw new PensionerDetailException("Exception Occurred");
		}
		return obj;
	
	}
}
