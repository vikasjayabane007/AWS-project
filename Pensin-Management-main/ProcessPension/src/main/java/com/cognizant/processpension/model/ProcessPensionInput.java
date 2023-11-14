package com.cognizant.processpension.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProcessPensionInput {
	private Long aadharNumber;
	private double pensionAmount;
	private double bankCharge;
}
