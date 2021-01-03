package com.hilo.controller;

import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.patientmanagement.entity.Pagina;
import com.hilo.model.patientmanagement.entity.PaginaDiarioClinico;
import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.statisticsmanagement.Statistica;
import com.hilo.model.swabmanagement.entity.Swab;
import java.util.List;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class FacadeController implements RequestController {
  @Autowired
  private PatientController pc;

  @Autowired
  private HealthController hc;

  @Autowired
  private StatisticsController sc;

  @PostMapping("/patient/register")
  public void register(@RequestParam(name = "User") String user) throws JSONException {
    pc.registerPatient(user);
  }

  @GetMapping("/health_worker/all")
  public List<HealthWorker> getAllHealthWorker() {
    return hc.getAll();
  }

  @GetMapping("/patient/all")
  public List<Patient> getAllPatient() {
    return pc.getAll();
  }

  @GetMapping("/patient/diarioClinico/all")
  public List<PaginaDiarioClinico> getAllPagineDiarioClinico() {
    return pc.getAllPagineDiarioClinico();
  }

  @GetMapping("/patient/diarioPaziente/all")
  public List<Pagina> getAllPagineDiarioPaziente() {
    return pc.getAllPagineDiarioPaziente();
  }

  @GetMapping("/patient/diarioPaziente/byId")
  public Pagina getPaginaByIds(@RequestParam(name = "cf") String cf,
                               @RequestParam(name = "numero") Integer numero) {
    return pc.getPaginaByIds(cf, numero);
  }

  @GetMapping("/patient/diarioPaziente/byCF")
  public List<Pagina> getPaginaByCf(@RequestParam(name = "cf") String cf) {
    return pc.getPaginaByCf(cf);
  }

  @GetMapping("/api/statistics/")
  public Statistica getStatistiche() {
    return sc.getStatistiche();
  }

  @GetMapping("/swab/inserisciRisultato")
  public Swab inserisciRisultato(@RequestParam(name = "idTampone") String id, 
                                 @RequestParam(name = "risultato") String risultato) {
    return hc.inserisciRisultato(Integer.valueOf(id), risultato);
  }
}
