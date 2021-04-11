package com.alertSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alertSystem.Entity.Violation;

@Repository
public interface ViolationRepository extends CrudRepository<Violation, Long>{

}
