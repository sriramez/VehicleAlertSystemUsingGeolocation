package com.alertSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alertSystem.Entity.TrafficSignal;

@Repository
public interface TrafficSignalRepository extends CrudRepository<TrafficSignal, Long>{

	List<TrafficSignal> findByCity(String cityName);
}
