package com.hilo.model.patientmanagement.email;

import com.hilo.controller.ErrorController;
import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.patientmanagement.entity.PatientManager;
import com.hilo.model.swabmanagement.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterceptorMailRegister {
  @Autowired
  private PatientManager patientManager;
  @Autowired
  private ErrorController ec;
  @Autowired
  private EmailServiceImpl sender;
  public boolean sendRegisteredMail(Patient p){
    boolean result;
    try {
      patientManager.createPatient(p);
      result = true;
    } catch (IllegalStateException e) {
      ec.manageError(e);
      result = false;
    }
    String to = p.getMail();
    String subject = "Credenziali per Hilo " + p.getNome() + " " + p.getCognome();
    String text = "Le credenziali di accesso per il portale Hilo sono:\n" + "Username = " + p.getUsername() + "\nPassword = " + p.getPassword() + "\nPuoi cambiare la password dopo aver effettuato l'accesso.";

    sender.sendSimpleMessage(to, subject, text);

    return result;
  }
}
