package com.hilo.patient;

import com.hilo.patient.entity.Patient;
import com.hilo.patient.entity.Radiografia;
import com.hilo.patient.repository.PatientRepository;
import com.hilo.patient.repository.RadiografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
