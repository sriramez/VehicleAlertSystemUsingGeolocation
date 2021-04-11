package com.alertSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alertSystem.Entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long>{

}
