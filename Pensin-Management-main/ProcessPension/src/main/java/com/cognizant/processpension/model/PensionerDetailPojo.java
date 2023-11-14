package com.cognizant.processpension.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class PensionerDetailPojo {

	private long aadharnumber;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	private String pan;
	private double salaryearned;
	private double allowances;
	private String pensiontype;
	private String bankname;
	private long accountnumber;
	private String publicorprivate;
	
}
