package com.hilo.controller;

import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.healthworkermanagement.entity.HealthWorkerManager;
import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.patientmanagement.entity.PatientManager;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginController {
  @Autowired
  private PatientManager pm;

  @Autowired
  private HealthWorkerManager hwm;

  @Autowired
  private HttpSession session;

  public boolean doLogin(String user, String pass) {
    String username = user;
    String password = pass;
    Patient p = pm.findByUsernameAndPassword(username, password);
    if (p == null) {
      HealthWorker hw = hwm.findByUsernameAndPassword(username, password);
      if (hw == null) {
        return false;
      }
      session.setAttribute("username", username);
      if (hw.getRuolo().equalsIgnoreCase("admin")) {
        session.setAttribute("role", "admin");
        session.setAttribute("cf", hw.getCf());
        return true;
      }
      session.setAttribute("role", "healthworker");
      session.setAttribute("cf", hw.getCf());
      return true;
    }
    session.setAttribute("username", username);
    session.setAttribute("role", "patient");
    session.setAttribute("cf", p.getCf());
    return true;
  }

  public void doLogout() {
    session.invalidate();
  }
}
