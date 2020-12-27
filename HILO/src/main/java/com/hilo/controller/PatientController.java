package com.hilo.controller;

import com.hilo.model.patientmanagement.entity.Pagina;
import com.hilo.model.patientmanagement.entity.PaginaDiarioClinico;
import com.hilo.model.patientmanagement.entity.PaginaDiarioClinicoManager;
import com.hilo.model.patientmanagement.entity.PaginaManager;
import com.hilo.model.patientmanagement.entity.Patient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientController {
  @Autowired
  private PaginaManager pm;

  @Autowired
  private PaginaDiarioClinicoManager pdcm;

  @Autowired

  @GetMapping("/patient/all")
  public List<Patient> getAll() {
    return null;
  }

  @GetMapping("/patient/diarioClinico/all")
  public List<PaginaDiarioClinico> getAllPagineDiarioClinico() {
    return pdcm.findAll();
  }

  @GetMapping("/patient/diarioPaziente/all")
  public List<Pagina> getAllPagineDiarioPaziente() {
    return pm.findAll();
  }

  @GetMapping("/patient/diarioPaziente/byId")
  public Pagina getPaginaByIds(@RequestParam(name = "cf") String cf, 
                              @RequestParam(name = "numero") Integer numero) {
    return pm.findById(numero, cf);
  }

  @GetMapping("/patient/diarioPaziente/byCF")
  public List<Pagina> getPaginaByCf(@RequestParam(name = "cf") String cf) {
    return pm.findByCf(cf);
  }


  /* @GetMapping("/patient/xray")
  List<Radiografia> getAllXray() {
    for (Radiografia temp : rr.findAll()
    ) {
      System.out.println(temp.toString());
    }
    return rr.findAll();
  } */
}
