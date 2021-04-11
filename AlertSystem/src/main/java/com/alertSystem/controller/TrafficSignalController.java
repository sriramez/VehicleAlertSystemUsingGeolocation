package com.alertSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alertSystem.Entity.TrafficSignal;
import com.alertSystem.model.TrafficSignalModel;
import com.alertSystem.services.TrafficSignalService;

@RestController
@RequestMapping("traffic")
public class TrafficSignalController {

	@Autowired
	TrafficSignalService trafficeService;
	
	@PostMapping
	public TrafficSignal createTraffic(@RequestBody TrafficSignalModel trafficSignal)
	{
		return trafficeService.createTraffic(trafficSignal);
	}
	
	@GetMapping
	public Iterable<TrafficSignal> getallTrafficSignals()
	{
		return trafficeService.getAllSignals();
	}
	
}
