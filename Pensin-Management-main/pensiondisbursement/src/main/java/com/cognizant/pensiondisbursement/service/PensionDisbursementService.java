package com.cognizant.pensiondisbursement.service;


import com.cognizant.pensiondisbursement.exception.PensionerDetailException;
import com.cognizant.pensiondisbursement.model.ProcessPensionInput;
import com.cognizant.pensiondisbursement.model.ProcessPensionResponse;

public interface PensionDisbursementService {
	public ProcessPensionResponse getPensionDisbursement(String token, ProcessPensionInput processPensionInput) throws PensionerDetailException ;
}
