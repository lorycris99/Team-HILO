package com.hilo.controller;

import com.hilo.model.patientmanagement.entity.*;

import java.util.List;

import net.bytebuddy.utility.RandomString;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientController {
  @Autowired
  private PaginaManager pm;

  @Autowired
  private PaginaDiarioClinicoManager pdcm;

  @Autowired
  private PatientManager patientManager;

  @PostMapping("/patient/register")
  public void registerPatient(@RequestParam(name = "User") String user) throws JSONException {
    JSONObject obj = new JSONObject(user);
    String cf = obj.getString("cf");
    String name = obj.getString("name");
    String surname = obj.getString("surname");
    String username = RandomString.make(10);
    String password = RandomString.make(10);
    String mail = obj.getString("mail");
    String telefono = obj.getString("telefono");
    Boolean isInterno = obj.getBoolean("isInterno");
    String indirizzo = obj.getString("indirizzo");
    Patient p = new Patient(cf, username, password, mail, telefono, isInterno, indirizzo, name, surname);
    patientManager.creaPaziente(p);
  }

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
