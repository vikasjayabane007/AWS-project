package com.cognizant.model;

public class AuthResponse {
	
	private String uid;
	private boolean valid;
	public AuthResponse()
	{
		
	}
	public AuthResponse(String username, boolean b) {
		this.uid = username;
		this.valid = b;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
