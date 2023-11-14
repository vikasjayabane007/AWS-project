package com.cognizant.processpension.feign;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.processpension.exception.InvalidPensionerDetails;
import com.cognizant.processpension.model.PensionerDetailPojo;

@org.springframework.cloud.openfeign.FeignClient(name="GetPensionerDetails", url="${pension-detail}")
public interface FeignCommunicationPensionerDetail {

	@GetMapping("/pensionerdetailbyaadhaar/{aadharno}")
	public PensionerDetailPojo getDetails(@RequestHeader(name="Authorization")String header,@PathVariable("aadharno") long aadharno) throws InvalidPensionerDetails ;
}