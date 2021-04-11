package com.alertSystem.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Violation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	String violation;
	
	String violationType;
	
	@JsonIgnore
	@ManyToMany
	@Cascade(CascadeType.ALL)
	List<Vehicle> vehicles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getViolation() {
		return violation;
	}

	public void setViolation(String violation) {
		this.violation = violation;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	

}
