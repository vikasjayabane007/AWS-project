package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="userlogin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginCredential {

	@Id
	@Column(name="uid" ,length=20)
	private String uid;
	@Column(name="password",length=20)
	private String password;
	
	private String token;

	
	
	
}
