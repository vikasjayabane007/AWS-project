package com.cognizant.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PensionTable")
public class ProcessPensionInput {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aadharNumber;
	private double pensionAmount;
	private double bankCharge;
}
