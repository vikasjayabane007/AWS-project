package com.cognizant.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.portal.exception.TokenInvalidException;
import com.cognizant.portal.model.PensionDetail;
import com.cognizant.portal.model.PensionerInput;
import com.cognizant.portal.model.ProcessPensionInput;
import com.cognizant.portal.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PensionProcessController {

	@Autowired
	private PortalService pensionProcessService;

	@PostMapping("/submitinfo")
	public String submitPensionerInfo(@ModelAttribute("pensionerInput") PensionerInput pensionerInput,Model model,HttpServletRequest request) throws TokenInvalidException {
		log.debug("Submitting Pensioner Details");
		String token = (String)	request.getSession().getAttribute("token");
		return pensionProcessService.submitPensionInput(pensionerInput,model,token);
	}

	@PostMapping("/disburse")
	public String processPensionInputpost(Model model,@RequestParam("aadhaar") long aadhaar,@RequestParam("amount") double amount,ProcessPensionInput input,HttpServletRequest request) {
		log.debug("Showing Disburse Form");
		String token = (String)	request.getSession().getAttribute("token");
		return pensionProcessService.getBankCharge(model,token,aadhaar,amount);
	}
	

	@PostMapping("/evaluate")
	public String disburseProcess(Model model,@RequestParam("aadhaar") long aadhaar,@RequestParam("amount") double amount,@RequestParam("bankcharge") double bankCharge,HttpServletRequest request) {
		log.debug("Evaluating The Disburse Form");
		String token = (String)	request.getSession().getAttribute("token");
		
		ProcessPensionInput input = new ProcessPensionInput(aadhaar,amount,bankCharge);
		return pensionProcessService.disburseProcess(input,token,model);
	}
	
	
	@GetMapping("/success")
	public String getSuccessPage(Model model) {
		log.debug("Returning Success Message ");
		model.addAttribute("message", "Success. Code Returned : 10");
		return "message";
	}

}
