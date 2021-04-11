package com.alertSystem.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alertSystem.Entity.AlertMessages;
import com.alertSystem.Entity.Police;
import com.alertSystem.Entity.TrafficSignal;
import com.alertSystem.Entity.Vehicle;
import com.alertSystem.Entity.Violation;
import com.alertSystem.repository.PoliceRepository;
import com.alertSystem.repository.TrafficSignalRepository;
import com.alertSystem.repository.VehicleRepository;
import com.alertSystem.repository.ViolationRepository;
import com.alertSystem.services.GeolocationService;
import com.alertSystem.services.VelhicleServices;


@RestController
public class VehicleAndViolationController {

	@Autowired
	VehicleRepository vehicleRepo;
	
	@Autowired
	ViolationRepository violationRepo;
	
	@Autowired
	TrafficSignalRepository signalRepo;
	
	@Autowired
	GeolocationService geolocationService;
	
	@Autowired
	PoliceRepository policeRepo;
	
	@Autowired
	VelhicleServices vehicleService;
	
	@PostMapping("vehicle")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle)
	{
		return vehicleRepo.save(vehicle);
	}
	
	
	@GetMapping("vehicles")
	public Iterable<Vehicle> findAllVehicles()
	{
		return vehicleRepo.findAll();
	}
	
	@PostMapping("vehicle/position")
	public String pushLocation(@RequestParam long vehicleid,@RequestParam double latitude,@RequestParam double longitude)
	{
	
		return vehicleService.pushLocation(vehicleid, latitude, longitude);
		
	}
	
}
