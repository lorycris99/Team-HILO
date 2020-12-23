package com.hilo.model.healthworkermanagement.repository;

import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HealthWorkerRepository extends JpaRepository<HealthWorker, String> {


}
