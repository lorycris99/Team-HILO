package com.hilo.HealthWorkerManagement.repository;

import com.hilo.HealthWorkerManagement.entity.HealthWorker;
import com.hilo.patient.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface HealthWorkerRepository extends JpaRepository<HealthWorker, String> {


}
