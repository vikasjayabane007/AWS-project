package com.cognizant.portal.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.portal.model.PensionDetail;
import com.cognizant.portal.model.PensionerInput;

@FeignClient(name = "pension-detail", url = "${pension.detail}")
public interface FeignWithPensionerDetail {

	@GetMapping("/pensionerdetailbyaadhaar/{aadharno}")
	public PensionDetail getPensionDetail(@RequestHeader("Authorization") String token,@PathVariable("aadharno") long aadharno);

}
