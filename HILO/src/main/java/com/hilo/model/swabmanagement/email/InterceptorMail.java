package com.hilo.model.swabmanagement.email;

import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.patientmanagement.entity.PatientManager;
import com.hilo.model.swabmanagement.entity.EffettuaAs;
import com.hilo.model.swabmanagement.entity.EffettuaAsManager;
import com.hilo.model.swabmanagement.entity.EffettuaP;
import com.hilo.model.swabmanagement.entity.EffettuapManager;
import com.hilo.model.swabmanagement.entity.Swab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InterceptorMail {
  @Autowired
  private EffettuaAsManager eam;
  @Autowired
  private EffettuapManager epm;
  @Autowired
  private PatientManager pm;
  @Autowired
  private EmailServiceImpl sender;

  public void sendMail(Swab s) {
    String cf = "";
    Patient destinatario;
    EffettuaP temp = epm.findByIdTampone(s.getId());
    if (temp == null) {
      EffettuaAs tempAs = eam.findByIdTampone(s.getId());
      cf = tempAs.getCfAs();
      destinatario = pm.findById(cf);
      String to = destinatario.getMail();
      String subject = "Risultato tampone svolto il: " + tempAs.getTimestamp();
      String message = "Comunicazione risultato tampone effettuato da " + destinatario.getNome()
              + destinatario.getCognome() + " il " + tempAs.getTimestamp() + " è "
              + s.getRisultato();
      sender.sendSimpleMessage(to, subject, message);
    }
    cf = temp.getCfP();
    destinatario = pm.findById(cf);
    String to = destinatario.getMail();
    String subject = "Risultato tampone svolto il: " + temp.getTimestamp();
    String message = "Comunicazione risultato tampone effettuato da " + destinatario.getNome()
            + destinatario.getCognome() + " il " + temp.getTimestamp() + " è "
            + s.getRisultato();
    sender.sendSimpleMessage(to, subject, message);
  }
}
