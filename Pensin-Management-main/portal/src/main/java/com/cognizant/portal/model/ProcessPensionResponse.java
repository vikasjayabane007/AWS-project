package com.cognizant.portal.model;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
@Getter
@Setter
public class ProcessPensionResponse {
	private int processPensionStatusCode;
}
