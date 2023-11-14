package com.cognizant.portal.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.portal.exception.TokenInvalidException;
import com.cognizant.portal.model.PensionDetail;
import com.cognizant.portal.model.PensionerInput;
import com.cognizant.portal.model.ProcessPensionInput;
import com.cognizant.portal.model.ProcessPensionResponse;

@FeignClient(name = "process-pension", url = "${process-pension}")
public interface ProcessPensionClient {
	
	@PostMapping("/pensiondetail")
	public PensionDetail getPensionDetail(
			@RequestBody PensionerInput pensionerInput,@RequestHeader("Authorization") String token) throws TokenInvalidException;

	@PostMapping("/processpension")
	public ProcessPensionResponse getDisbursementCode(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput);

}
