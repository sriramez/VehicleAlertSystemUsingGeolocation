package com.alertSystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alertSystem.Entity.Police;
import com.alertSystem.Entity.TrafficSignal;
import com.alertSystem.model.TrafficSignalModel;
import com.alertSystem.repository.TrafficSignalRepository;

@Service
public class TrafficSignalService {

	
	@Autowired
	TrafficSignalRepository trafficRepo;
	
	@Autowired
	GeolocationService locationService;
	
	public TrafficSignal createTraffic(TrafficSignalModel trafficSignal)
	{
		String cityName = locationService.getCityNameFromLatitudeAndLongitude(Double.valueOf(trafficSignal.getLatitude()),Double.valueOf(trafficSignal.getLongitude()));
		TrafficSignal trafficSignalEntity = new TrafficSignal(cityName,(double) Double.valueOf(trafficSignal.getLatitude()), (double)Double.valueOf(trafficSignal.getLongitude()), trafficSignal.getLandmark());
		List<Police> policeList = new ArrayList<>();
		trafficSignalEntity.setPolice(policeList);
		return trafficRepo.save(trafficSignalEntity);
	}
	
	public Iterable<TrafficSignal> getAllSignals()
	{
		return trafficRepo.findAll();
	}
}
