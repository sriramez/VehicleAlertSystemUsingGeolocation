package com.alertSystem.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Police {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	long id;
	
	String policeName;
	
	long RegisterNumber;
	
	String city;
	
	boolean isMapped;
	
	String emailid;
	
	Police()
	{
		
	}
	
	public Police(String policeName, long registerNumber, String city, boolean isMapped) {
		super();
		this.policeName = policeName;
		RegisterNumber = registerNumber;
		this.city = city;
		this.isMapped = isMapped;
	}

	@JsonManagedReference
	@Cascade(CascadeType.ALL)
	@ManyToOne
	TrafficSignal signal;

	
	
	@OneToMany(cascade = javax.persistence.CascadeType.ALL)
	List<AlertMessages> alertMessages;
	
	public List<AlertMessages> getAlertMessages() {
		return alertMessages;
	}

	public void setAlertMessages(List<AlertMessages> alertMessages) {
		this.alertMessages = alertMessages;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public TrafficSignal getSignal() {
		return signal;
	}

	public void setSignal(TrafficSignal signal) {
		this.signal = signal;
	}

	public boolean isMapped() {
		return isMapped;
	}

	public void setMapped(boolean isMapped) {
		this.isMapped = isMapped;
	}
	
	
	
}
