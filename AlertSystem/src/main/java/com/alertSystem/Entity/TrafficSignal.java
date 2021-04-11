package com.alertSystem.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class TrafficSignal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	String city;
	
	double latitude;
	
	double longitude;
	
	String landmark;
	
	public TrafficSignal() {
		// TODO Auto-generated constructor stub
	}
	
	public TrafficSignal(String city, double latitude, double longitude, String landmark) {
		super();
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.landmark = landmark;
	}

	@JsonBackReference
	@OneToMany(cascade = javax.persistence.CascadeType.ALL)
	List<Police> police;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public List<Police> getPolice() {
		return police;
	}

	public void setPolice(List<Police> police) {
		this.police = police;
	}
	
	
	
	
	
}
