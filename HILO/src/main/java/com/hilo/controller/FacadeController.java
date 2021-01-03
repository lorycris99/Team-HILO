package com.hilo.controller;

import com.google.gson.Gson;
import com.hilo.model.swabmanagement.entity.Swab;
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

  private static Gson gson = new Gson();

  @PostMapping("/patient/register")
  public String register(@RequestParam(name = "User") String user) throws JSONException {
    return gson.toJson(pc.registerPatient(user));
  }

  @GetMapping("/health_worker/all")
  public String getAllHealthWorker() {
    return gson.toJson(hc.getAll());
  }

  @GetMapping("/patient/all")
  public String getAllPatient() {
    return gson.toJson(pc.getAll());
  }

  @GetMapping("/patient/diarioClinico/all")
  public String getAllPagineDiarioClinico() {
    return gson.toJson(pc.getAllPagineDiarioClinico());
  }

  @GetMapping("/patient/diarioPaziente/all")
  public String getAllPagineDiarioPaziente() {
    return gson.toJson(pc.getAllPagineDiarioPaziente());
  }

  @GetMapping("/patient/diarioPaziente/byId")
  public String getPaginaByIds(@RequestParam(name = "cf") String cf,
                               @RequestParam(name = "numero") Integer numero) {
    return gson.toJson(pc.getPaginaByIds(cf, numero));
  }

  @GetMapping("/patient/diarioPaziente/byCF")
  public String getPaginaByCf(@RequestParam(name = "cf") String cf) {
    return gson.toJson(pc.getPaginaByCf(cf));
  }

  @GetMapping("/api/statistics/")
  public String getStatistiche() {
    return gson.toJson(sc.getStatistiche());
  }

  @GetMapping("/swab/inserisciRisultato")
  public String inserisciRisultato(@RequestParam(name = "idTampone") String id, 
                                 @RequestParam(name = "risultato") String risultato) {
    return gson.toJson(hc.inserisciRisultato(Integer.valueOf(id), risultato));
  }
}
