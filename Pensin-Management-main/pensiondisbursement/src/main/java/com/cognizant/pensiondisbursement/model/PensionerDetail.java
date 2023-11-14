package com.cognizant.pensiondisbursement.model;


import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

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
@ToString
public class PensionerDetail {
  private long aadharnumber;
  private String name;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateofbirth;
  private String pan;
  private double salaryearned ;
  private double  allowances ;
  private String pensiontype;
  private String bankname;
  private long accountnumber;
  private String publicorprivate;
  
 
}
