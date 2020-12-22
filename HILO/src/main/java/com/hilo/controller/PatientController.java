package com.hilo.controller;

import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.patientmanagement.entity.Radiografia;
import com.hilo.model.patientmanagement.repository.PatientRepository;
import com.hilo.model.patientmanagement.repository.RadiografiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientController {
  @Autowired
  private PatientRepository pr;

  @Autowired
  private RadiografiaRepository rr;

  @GetMapping("/patient/all")
  List<Patient> getAll() {
    return pr.findAll();
  }

  @GetMapping("/patient/xray")
  List<Radiografia> getAllXray() {
    for (Radiografia temp : rr.findAll()
    ) {
      System.out.println(temp.toString());
    }
    return rr.findAll();
  }
}
