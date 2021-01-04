package com.hilo.model.healthworkermanagement.repository;

import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HealthWorkerRepository extends JpaRepository<HealthWorker, String> {

  public HealthWorker findByUsername(String username);

  public List<HealthWorker> findByCognome(String cognome);

  public List<HealthWorker> findByIdstruttura(Integer id);

  public List<HealthWorker> findByRuolo(String ruolo);

  public HealthWorker findByMail(String mail);

  public List<HealthWorker> findByTelefono(String telefono);

  public HealthWorker findByUsernameAndPassword(String username, String password);

}
