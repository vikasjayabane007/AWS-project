	package com.cognizant.pensiondisbursement.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.pensiondisbursement.model.PensionerDetail;

@FeignClient(name = "pensionerdetailmodule-service", url = "${pension-detail}")
public interface PensionerDetailClient {


	@GetMapping("/pensionerdetailbyaadhaar/{aadharno}")
	PensionerDetail getPensionerDetails(@RequestHeader("Authorization") String token,
			@PathVariable("aadharno") long aadharno);
	
	
}
