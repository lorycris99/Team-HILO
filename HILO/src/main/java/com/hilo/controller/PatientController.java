package com.hilo.controller;


import com.hilo.model.patientmanagement.email.InterceptorMailRegister;
import com.hilo.model.patientmanagement.entity.Pagina;
import com.hilo.model.patientmanagement.entity.PaginaDiarioClinico;
import com.hilo.model.patientmanagement.entity.PaginaDiarioClinicoManager;
import com.hilo.model.patientmanagement.entity.PaginaManager;
import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.patientmanagement.entity.PatientManager;
import java.util.List;
import net.bytebuddy.utility.RandomString;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientController {
  @Autowired
  private PaginaManager pm;

  @Autowired
  private PaginaDiarioClinicoManager pdcm;

  @Autowired
  private PatientManager patientManager;

  @Autowired
  private ErrorController ec;

  @Autowired
  private InterceptorMailRegister interceptor;
  
  public Patient registerPatient(String cft, String namet, String surnamet,
                                 String mailt, String telefonot, boolean isInternot, String indirizzot) {
    String cf = cft;
    String name = namet;
    String surname = surnamet;
    String username = RandomString.make(10);
    String password = RandomString.make(10);
    String mail = mailt;
    String telefono = telefonot;
    Boolean isInterno = isInternot;
    String indirizzo = indirizzot;
    Patient p = new Patient(cf, username, password, mail, telefono, isInterno,
        indirizzo, name, surname);
    patientManager.createPatient(p);
    interceptor.sendRegisteredMail(p);
    return p;
  }


  public List<Patient> getAll() {

    return patientManager.findAll();
  }


  public List<PaginaDiarioClinico> getAllPagineDiarioClinico() {
    return pdcm.findAll();
  }


  public List<Pagina> getAllPagineDiarioPaziente() {
    return pm.findAll();
  }


  public Pagina getPaginaByIds(String cf, Integer numero) {
    return pm.findById(numero, cf);
  }


  public List<Pagina> getPaginaByCf(String cf) {
    return pm.findByCf(cf);
  }

  public Patient getPazienteByCF(String cf) {
    return patientManager.findById(cf);
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
