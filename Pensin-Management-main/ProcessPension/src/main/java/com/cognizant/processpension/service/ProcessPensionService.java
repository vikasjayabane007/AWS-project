package com.cognizant.processpension.service;

import com.cognizant.processpension.exception.InvalidPensionerDetails;
import com.cognizant.processpension.model.PensionDetail;
import com.cognizant.processpension.model.PensionerDetailPojo;
import com.cognizant.processpension.model.PensionerInput;
import com.cognizant.processpension.model.ProcessPensionInput;
import com.cognizant.processpension.model.ProcessPensionResponse;

public interface ProcessPensionService {

	
	PensionDetail checkAndCalculate(PensionerInput pensionerInput, PensionerDetailPojo pensionerDetail) throws InvalidPensionerDetails;

	PensionDetail getPensionDetail(String header, PensionerInput pensionerInput) throws InvalidPensionerDetails;

	ProcessPensionResponse processPensionInput(String header, ProcessPensionInput pensionInput);
	
	
}
