package com.hilo.controller;

import com.google.gson.Gson;
import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.swabmanagement.entity.Swab;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/")
public class FacadeController {
  @Autowired
  private PatientController pc;

  @Autowired
  private HealthController hc;

  @Autowired
  private StatisticsController sc;

  @Autowired
  private AdminController ac;

  @Autowired
  private LoginController lc;

  @Autowired
  private HttpSession session;


  private static Gson gson = new Gson();

  @GetMapping("/logout")
  public String doLogout() {
    lc.doLogout();
    return "HomePage";
  }

  @PostMapping("/login")
  public String doLogin(@RequestParam(name = "username") String user,
                        @RequestParam(name = "password") String pass) {
    if (session.getAttribute("role") != null) {
      return "HomePage";
    }
    System.out.println(lc.doLogin(user, pass));
    System.out.println(session.getAttribute("role"));
    if (session.getAttribute("role").equals("healthworker")) {
      return "operatore-homepage";
    } else if (session.getAttribute("role").equals("admin")) {
      return "admin-homepage";
    }
    return "HomePage";
  }

  @GetMapping("/forgot")
  public String requestForgot() {
    return "recover";
  }

  @GetMapping("/view/swab/add")
  public String requestAddSwab() {
    if (session.getAttribute("role") != null 
        && session.getAttribute("role").equals("healthworker")
            || session.getAttribute("role").equals("admin")) {
      return "aggiungi-tampone";
    }
    return "HomePage";
  }

  @GetMapping("/view/healthworker/add")
  public String requestAddHealthWorker() {
    if (session.getAttribute("role") != null 
        && session.getAttribute("role").equals("admin")) {
      return "aggiungi-operatore";
    }
    return "HomePage";
  }

  @GetMapping("/view/patient/add")
  public String requestPatientAdd() {
    if (session.getAttribute("role") != null 
        && session.getAttribute("role").equals("admin")
        || session.getAttribute("role").equals("healthworker")) {
      return "aggiungi-paziente";
    }
    return "HomePage";
  }

  @GetMapping("/view/swab/find")
  public String requestFindSwab(Model m) {
    return "ricerca-tampone-utente";
  }

  @GetMapping("/view/patient/find")
  public @ResponseBody String requestFindPatient() {
    return "Not implemented yet";
  }

  @GetMapping("/swab/gettop")
  public @ResponseBody String requestGetTop() {
    return "Not implemented yet";
  }

  @GetMapping("/view/page/find")
  public @ResponseBody String requestFindPage() {
    return "Not implemented yet";
  }

  @GetMapping("/view/pagediary")
  public @ResponseBody String requestFindPageDiary() {
    return "Not implemented yet";
  }

  @PostMapping("/swab/bypatient")
  public @ResponseBody String findSwabByPatient(Model m, @RequestParam(name = "cf") String cf) {
    List<Swab> list = hc.findSwabByCF(cf);
    if (session.getAttribute("role") == null) {
      return "HomePage";
    }
    if (session.getAttribute("role").equals("admin")
            || session.getAttribute("role").equals("healthworker")) {
      return gson.toJson(list);
    }
    if (session.getAttribute("role").equals("patient")
            && session.getAttribute("cf").equals("cf")) {
      return gson.toJson(list);
    }
    return "HomePage";
  }

  @GetMapping("/view/healthworker")
  public String requestHealthWorkerHomepage() {
    if (session.getAttribute("role") != null 
        && (session.getAttribute("role").equals("healthworker") 
        || session.getAttribute("role").equals("admin"))) {
      return "operatore-homepage";
    } else {
      return "HomePage";
    }
  }

  @GetMapping("/view/loadradiography")
  public String loadRadiography(Model m) {
    if (session.getAttribute("role") != null && (session.getAttribute("role").equals("admin") 
        || session.getAttribute("role").equals("healthworker"))) {
      return "aggiungi-radiografia";
    }
    return "HomePage";
  }

  @PostMapping("/swab/add")
  public String addSwab(@RequestParam(name = "cf") String cf,
                        @RequestParam(name = "idStruttura") String idStruttura,
                        @RequestParam(name = "isInterno") String isInterno) {
    if (session.getAttribute("role") == null 
        || !session.getAttribute("role").equals("healthworker")) {
      return "HomePage";
    }
    Swab s = new Swab();
    s.setIsInterno(Boolean.parseBoolean(isInterno));
    s.setRisultato("");
    s.setIdStruttura(Integer.parseInt(idStruttura));
    Patient p = pc.getPazienteByCf(cf);
    hc.insertSwab(s, p, "10-01-2000 09:00");
    return "aggiungi-tampone";
  }

  @GetMapping("/health_worker/all")
  public String getAllHealthWorker() {
    return gson.toJson(hc.getAll());
  }

  @GetMapping("/patient/all")
  public String getAllPatient() {
    return gson.toJson(pc.getAll());
  }

  @GetMapping("/patient/diarioClinico/all")
  public String getAllPagineDiarioClinico() {
    return gson.toJson(pc.getAllPagineDiarioClinico());
  }

  @GetMapping("/patient/diarioPaziente/all")
  public String getAllPagineDiarioPaziente() {
    return gson.toJson(pc.getAllPagineDiarioPaziente());
  }

  @GetMapping("/patient/diarioPaziente/byId")
  public String getPaginaByIds(@RequestParam(name = "cf") String cf,
                               @RequestParam(name = "numero") Integer numero) {
    return gson.toJson(pc.getPaginaByIds(cf, numero));
  }

  @PostMapping("/patient/add")
  public String requestAddPatient(@RequestParam(name = "cf") String cf,
                                       @RequestParam(name = "email") String email,
                                       @RequestParam(name = "telefono") String telefono,
                                       @RequestParam(name = "nome") String nome,
                                       @RequestParam(name = "cognome") String cognome,
                                       @RequestParam(name = "citta") String citta,
                                       @RequestParam(name = "strada") String strada,
                                       @RequestParam(name = "civico") String civico,
                                       @RequestParam(name = "via") String via,
                                       @RequestParam(name = "isInterno") String isInterno
  ) {
    if (session.getAttribute("role") == null || (!session.getAttribute("role").equals("admin") 
        && !session.getAttribute("role").equals("healthworker"))) {
      return "HomePage";
    }
    String indirizzo = via + " " + strada + " " + civico + ", " + citta;
    pc.registerPatient(cf, nome, cognome, email, telefono, 
        Boolean.parseBoolean(isInterno), indirizzo);
    return "aggiungi-paziente";
  }

  @PostMapping("/healthworker/add")
  public String addHealthWorker(@RequestParam(name = "cf") String cf,
                                           @RequestParam(name = "email") String email,
                                           @RequestParam(name = "telefono") String telefono,
                                           @RequestParam(name = "nome") String nome,
                                           @RequestParam(name = "cognome") String cognome,
                                           @RequestParam(name = "citta") String citta,
                                           @RequestParam(name = "strada") String strada,
                                           @RequestParam(name = "civico") String civico,
                                           @RequestParam(name = "idStruttura") String idStruttura,
                                           @RequestParam(name = "via") String via,
                                           @RequestParam(name = "ruolo") String ruolo) {
    String indirizzo = via + " " + strada + " " + civico + ", " + citta;
    if (session.getAttribute("role") == null || session.getAttribute("role").equals("admin")) {
      return "HomePage";
    }
    HealthWorker hw = new HealthWorker(cf, "", "", email,
            telefono, ruolo, cognome, nome, indirizzo, Integer.parseInt(idStruttura));
    hc.insertHealthWorker(hw);
    return "operatore-homepage";
  }

  @GetMapping("/patient/diarioPaziente/byCF")
  public String getPaginaByCf(@RequestParam(name = "cf") String cf) {
    if (session.getAttribute("role") != null && session.getAttribute("role").equals("patient") 
        && session.getAttribute("cf").equals(cf)) {
      return gson.toJson(pc.getPaginaByCf(cf));
    }
    return null;
  }

  @GetMapping("/api/statistics/")
  public String getStatistiche() {
    return gson.toJson(sc.getStatistiche());
  }

  @GetMapping("/swab/inserisciRisultato")
  public @ResponseBody String inserisciRisultato(@RequestParam(name = "idTampone") String id, 
                                 @RequestParam(name = "risultato") String risultato) {
    if (session.getAttribute("role") != null 
        && session.getAttribute("role").equals("admin")) {
      return gson.toJson(hc.inserisciRisultato(Integer.valueOf(id), risultato));
    }
    return null;
  }

  @GetMapping("/view/swab/addresult")
  public String showAddResult() {
    return "aggiungi-tampone-risultato";
  }

  @GetMapping("/admin/inserisciStruttura")
  public @ResponseBody String inserisciStruttura(
                                  @RequestParam(name = "struttura") String strutturaJson) 
                                  throws JSONException {
    if (session.getAttribute("role") != null 
        && session.getAttribute("role").equals("admin")) {                               
      return gson.toJson(ac.aggiungiStruttura(strutturaJson));
    }
    return null;
  }

  @GetMapping("/view/structure/add")
  public String showAddStructure() {
    return "aggiungi-struttura";
  }

  @GetMapping("/view/admin")
  public String showAdmin() {
    return "admin-homepage";
  }

  @GetMapping("/admin/rimuoviStruttura")
  public @ResponseBody String rimuoviStruttura(@RequestParam(name = "idStruttura") 
                                              Integer idStruttura) {
    if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
      return gson.toJson(ac.removeStruttura(idStruttura));
    }

    return null;
  }

  @GetMapping("/admin/getStrutturaById")
  public @ResponseBody String getById(@RequestParam(name = "idStruttura") Integer id) {
    if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
      return gson.toJson(ac.getById(id));
    }
    return null;
  }

  @GetMapping("/admin/getAll")
  public @ResponseBody String getAll() {
    if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
      return gson.toJson(ac.getAll());
    }
    return null;
  }

  @GetMapping("/")
  public String getView() {
    return "HomePage";
  }

  @GetMapping("/statistics")
  public String getViewStatistics(Model m) {
    m.addAttribute("statistics", gson.toJson(sc.getStatistiche()));
    return "Statistiche";
  }

  @GetMapping("/view/landing")
  public String showLogin() {
    if (session.getAttribute("role") != null) {
      return "HomePage";
    }
    return "Login";
  }

  @GetMapping("/view/about")
  public String showAboutUs() {
    return "Su-di-noi";
  }

  @PostMapping("/patient/loadradiography")
  public @ResponseBody String radiograhyAdded() {
    return "Not implemented yet";
  }

}
