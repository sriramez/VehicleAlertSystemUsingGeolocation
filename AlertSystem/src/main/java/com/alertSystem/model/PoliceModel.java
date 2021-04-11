package com.alertSystem.model;

public class PoliceModel {

	String policeName;
	
	long RegisterNumber;
	
	String city;
	
	String emailid;

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPoliceName() {
		return policeName;
	}

	public void setPoliceName(String policeName) {
		this.policeName = policeName;
	}

	public long getRegisterNumber() {
		return RegisterNumber;
	}

	public void setRegisterNumber(long registerNumber) {
		RegisterNumber = registerNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
}
