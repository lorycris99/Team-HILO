package com.hilo.controller;

import com.hilo.model.adminmanagement.entity.Struttura;
import com.hilo.model.adminmanagement.entity.StrutturaManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminController {
  @Autowired
  private StrutturaManager sm;

  public Struttura aggiungiStruttura(String strutturaJson) throws JSONException {
    JSONObject jsonObject = new JSONObject(strutturaJson);
    
    Boolean isanalisis = jsonObject.getBoolean("isanalisis");
    String regione = jsonObject.getString("regione");
    String nome = jsonObject.getString("nome");
    String indirizzo = jsonObject.getString("indirizzo");

    Struttura s = new Struttura();
    s.setIsanalisis(isanalisis);
    s.setNome(nome);
    s.setIndirizzo(indirizzo);
    s.setRegione(regione);

    sm.createStruttura(s);
    return s;
  }

  public Boolean removeStruttura(Integer id) {
    sm.deleteStruttura(sm.findById(id));
    return true;
  }

  public Struttura getById(Integer id) {
    return sm.findById(id);
  }

  public List<Struttura> getAll() {
    return sm.findAll();
  }
}
