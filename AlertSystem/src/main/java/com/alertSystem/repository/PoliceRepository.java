package com.alertSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alertSystem.Entity.Police;

@Repository
public interface PoliceRepository extends CrudRepository<Police, Long>{

}
