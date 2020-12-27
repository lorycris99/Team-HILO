package com.hilo.model.healthworkermanagement.repository;

import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.patientmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HealthWorkerRepository extends JpaRepository<HealthWorker, String> {


}
