package com.hilo.model.HealthWorkerManagement.repository;

import com.hilo.model.HealthWorkerManagement.entity.HealthWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthWorkerRepository extends JpaRepository<HealthWorker, String> {


}
