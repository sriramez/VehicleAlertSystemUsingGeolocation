package com.alertSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alertSystem.Entity.Police;
import com.alertSystem.model.PoliceModel;
import com.alertSystem.services.PoliceServices;

@RestController
@RequestMapping("police")
public class PoliceController {

	
	@Autowired
	PoliceServices policeService;
	
	@PostMapping
	public Police createPolice(@RequestBody PoliceModel police)
	{
		return policeService.createPolice(police);
	}
	
	@PostMapping("trafficsignal")
	public Police mapPoliceToTrafficSignal(@RequestParam long policeId,@RequestParam long trafficSignal)
	{
		return policeService.mapPoliceToTrafficSignale(policeId, trafficSignal);
	}
	
	@GetMapping("all")
	public Iterable<Police> getAllPolice()
	{
		return policeService.getAllPolice();
	}
	
	@GetMapping
	public Police getPolice(@RequestParam long id)
	{
		return policeService.getPolice(id);
	}
}
