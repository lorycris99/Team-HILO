package com.hilo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.hilo.model.PatientManagement.entity.Patient;
import com.hilo.model.PatientManagement.entity.Radiografia;
import com.hilo.model.PatientManagement.repository.PatientRepository;
import com.hilo.model.PatientManagement.repository.RadiografiaRepository;

@RestController
public class PatientController {
    @Autowired
    PatientRepository pr;

    @Autowired
    RadiografiaRepository rr;

    @GetMapping("/patient/all")
    List<Patient> getAll(){
        return pr.findAll();
    }

    @GetMapping("/patient/xray")
    List<Radiografia> getAllXray(){
        for (Radiografia temp: rr.findAll()
             ) {
            System.out.println(temp.toString());
        }
        return rr.findAll();
    }
}
