package com.cognizant.portal.service;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.cognizant.portal.clients.AuthServiceClient;
import com.cognizant.portal.clients.FeignWithPensionerDetail;
import com.cognizant.portal.clients.ProcessPensionClient;
import com.cognizant.portal.exception.TokenInvalidException;
import com.cognizant.portal.model.PensionDetail;
import com.cognizant.portal.model.PensionerInput;
import com.cognizant.portal.model.ProcessPensionInput;
import com.cognizant.portal.model.ProcessPensionResponse;
import com.cognizant.portal.model.UserLoginCredential;
import com.cognizant.portal.model.UserToken;
import com.cognizant.portal.repository.PensionTableRepository;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PortalService {

	@Autowired
	private AuthServiceClient authServiceClient;
	
	@Autowired
	private ProcessPensionResponse response;

	@Autowired
	private ProcessPensionClient processPensionClient;

	@Autowired
	private FeignWithPensionerDetail feignWithPensionerDetail;
	@Autowired
	private PensionTableRepository pensionTableRepository;
	

	public UserLoginCredential getPensionerPage(PensionerInput pensionerInput, UserLoginCredential login) {
		
		log.debug("getPensionerPage() method invoked. Inside Portalservice ");
		ResponseEntity<UserLoginCredential> response = null;
		try{
			response = authServiceClient.authenticateUserAndGetDetails(login);
			if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
				return response.getBody();	
			}
			}
		catch(FeignException e)
		{
			return null;
		}
		
		return null;
	}

	public String getToken(ResponseEntity<UserToken> response) {
		log.debug("Fetching Token from the returned user object ");
		return response.getBody().getToken();
	}

	public String submitPensionInput(PensionerInput pensionerInput, Model model,String token) throws TokenInvalidException {
		log.debug("submitPensionInput() method inside PortalService invoked");
			PensionDetail pensionDetail = null;
				pensionDetail = processPensionClient.getPensionDetail(pensionerInput,token );
				if (pensionDetail == null)
					{
					log.error("PensionerDetails Did not Match");
					model.addAttribute("invaliddetails", "Pensioner Details did not Match.");
					return "pensionerdetails";
					}
				else {
					log.debug("PensionerDetails Matched Successfully");
					model.addAttribute("pensionType", pensionDetail.getPensionType());
					model.addAttribute("aadharno", pensionDetail.getAadharNumber());	
					model.addAttribute("name", pensionDetail.getName());
					model.addAttribute("pan", pensionDetail.getPan());
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date dateobj = pensionDetail.getDateOfBirth();
					model.addAttribute("dob", df.format(dateobj));
					model.addAttribute("pensionAmount", pensionDetail.getPensionAmount());
					return "verified";
				}
				

	}

	public String disburseProcess(ProcessPensionInput processPensionInput, String token,Model model) {
		log.debug("disburseProcess() Method inside Portal Service invoked To Verify Disburse Form");	
		response = processPensionClient.getDisbursementCode(token, processPensionInput);
				int code = response.getProcessPensionStatusCode();
				if(code == 0)
				{
					model.addAttribute("message","Bank Service Charge Not Added : Code 0");
					return "message";
				}
				else if (code == 10) {
					model.addAttribute("message","Success with code : 10");
					return "message";
				}
				else if (code == 20) 
					{
					model.addAttribute("message","Bank Service Charge Not Added. Code : 20");
					return "message";
					}
					model.addAttribute("message","Bank Service Charge Incorrect : 21");
					return "message";
					
	}

	public String getBankCharge(Model model,String token, long aadhaar, double amount) {
		
		PensionDetail pensionDetail = null;
		pensionDetail = feignWithPensionerDetail.getPensionDetail(token, aadhaar);
		
		if(pensionDetail==null)
		{
			return "error";
		}
		
		if(pensionDetail.getPublicorprivate().equalsIgnoreCase("public"))
		{
			model.addAttribute("aadhaar", aadhaar);
			model.addAttribute("amount", amount);
			model.addAttribute("bankcharge", 500.0);
			return "evaluate";
		}
		else
		{
			model.addAttribute("aadhaar", aadhaar);
			model.addAttribute("amount", amount);
			model.addAttribute("bankcharge",550);	
			return "evaluate";
		}
		
	}

}
