package com.cognizant.processpension.feign;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.processpension.model.ProcessPensionInput;
import com.cognizant.processpension.model.ProcessPensionResponse;

@org.springframework.cloud.openfeign.FeignClient(name="Disbursement", url="${pension-disbursement}")
public interface FeignCommunicationPensionDisbursement {

	@PostMapping("/disbursepension")
	public ProcessPensionResponse evaluation(@RequestHeader(name="Authorization") String header, ProcessPensionInput processPensionInput);

	
}
