package com.hilo.patient;

import com.hilo.patient.entity.Patient;
import com.hilo.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientRepository pr;

    @GetMapping("/patient/all")
    List<Patient> getAll(){
        for (Patient temp: pr.findAll()
             ) {

        }
        return pr.findAll();
    }
}
