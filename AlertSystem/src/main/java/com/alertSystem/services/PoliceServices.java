package com.alertSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alertSystem.Entity.Police;
import com.alertSystem.Entity.TrafficSignal;
import com.alertSystem.model.PoliceModel;
import com.alertSystem.repository.PoliceRepository;
import com.alertSystem.repository.TrafficSignalRepository;

@Service
public class PoliceServices {

	@Autowired
	PoliceRepository policeRepo;
	
	@Autowired
	TrafficSignalRepository trafficRepo;
	
	public Police createPolice(PoliceModel police)
	{
		Police policeEntity = new Police(police.getPoliceName(), police.getRegisterNumber(), police.getCity(), false);
		policeEntity.setEmailid(police.getEmailid());
		return policeRepo.save(policeEntity);
	}
	
	public Police mapPoliceToTrafficSignale(long policeId,long trafficSignalid)
	{
		Police policeEntity = policeRepo.findById(policeId).get();
		TrafficSignal trafficSignal = trafficRepo.findById(trafficSignalid).get();
		policeEntity.setSignal(trafficSignal);
		trafficSignal.getPolice().add(policeEntity);
		return policeRepo.save(policeEntity);
	}
	
	public Iterable<Police> getAllPolice()
	{
		return policeRepo.findAll();
	}
	
	public Police getPolice(long id)
	{
		return policeRepo.findById(id).get();
	}
	}
