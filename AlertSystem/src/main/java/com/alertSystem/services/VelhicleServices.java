package com.alertSystem.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alertSystem.Entity.AlertMessages;
import com.alertSystem.Entity.Police;
import com.alertSystem.Entity.TrafficSignal;
import com.alertSystem.Entity.Vehicle;
import com.alertSystem.repository.PoliceRepository;
import com.alertSystem.repository.TrafficSignalRepository;
import com.alertSystem.repository.VehicleRepository;

@Service
public class VelhicleServices {
	
	
	@Autowired
	GeolocationService geolocationService;
	
	@Autowired
	TrafficSignalRepository signalRepo;
	
	@Autowired
	VehicleRepository vehicleRepo;
	
	@Autowired
	PoliceRepository policeRepo;
	
	public String pushLocation(long vehicleId,double latitude,double longitude)
	{
		String city = geolocationService.getCityNameFromLatitudeAndLongitude(latitude, longitude);
		List<TrafficSignal> signals = signalRepo.findByCity(city);
		double distance = 0;
		TrafficSignal nearbySignal = null;
		for(TrafficSignal signal : signals)
		{
			double signalLatitude = signal.getLatitude();
			double signalLongitude = signal.getLongitude();
			if(distance==0)
			{
				//distance=Math.sqrt((signalLatitude-latitude)*(signalLatitude-latitude) + (signalLongitude-longitude)*(signalLongitude-longitude));
				distance = distance(signalLatitude, signalLongitude, latitude, longitude, 'K');
				nearbySignal = signal;
			}else
			{
				//double tempdistance = Math.sqrt((signalLatitude-latitude)*(signalLatitude-latitude) + (signalLongitude-longitude)*(signalLongitude-longitude)); 
				double tempdistance = distance(signalLatitude, signalLongitude, latitude, longitude, 'K');
				if(distance>tempdistance)
				{
					distance=tempdistance;
					nearbySignal = signal;
				}
			}
			
			
		}
		if(nearbySignal!=null && nearbySignal.getPolice()!=null&&(distance<0.500))
		{
			for(Police police : nearbySignal.getPolice())
			{
				 Vehicle vehicle =  vehicleRepo.findById(vehicleId).get();
				if(vehicle!=null)
				{
					JSONObject obj = new JSONObject();
					obj.put("vehicleNumber", vehicle.getVehicleNumber());
					obj.put("vehicle brand", vehicle.getVehicleBrand());
					obj.put("vehicle color", vehicle.getVehicleColor());
					obj.put("vehicle type", vehicle.getVehicleType());
					obj.put("vehicle violations", vehicle.getViolations());
					AlertMessages message = new AlertMessages();
					message.setMessage(obj.toString());
					if(police.getAlertMessages()==null)
					{
						List<AlertMessages> alertmessage = new ArrayList<>();
						police.setAlertMessages(alertmessage);
					}
					police.getAlertMessages().add(message);
					policeRepo.save(police);
				}
			}
		}
		return "request made successfully";
		
	}

	
	private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
		  double theta = lon1 - lon2;
		  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		  dist = Math.acos(dist);
		  dist = rad2deg(dist);
		  dist = dist * 60 * 1.1515;
		  if (unit == 'K') {
		    dist = dist * 1.609344;
		  } else if (unit == 'N') {
		  dist = dist * 0.8684;
		    }
		  return (dist);
		}
		
		private double deg2rad(double deg) {
		  return (deg * Math.PI / 180.0);
		}

		private double rad2deg(double rad) {
		  return (rad * 180.0 / Math.PI);
		}

	
	
}
