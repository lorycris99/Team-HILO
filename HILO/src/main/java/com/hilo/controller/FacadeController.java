package com.hilo.controller;

import com.google.gson.Gson;
import javax.servlet.http.HttpSession;

import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.swabmanagement.entity.Swab;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/")
public class FacadeController implements RequestController {
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
                        @RequestParam(name = "password") String pass) throws JSONException {
    System.out.println(lc.doLogin(user, pass));
    System.out.println(session.getAttribute("role"));
    if(session.getAttribute("role").equals("healthworker")) {
      return "operatore-homepage";
    }
    return "HomePage";
  }

  @GetMapping("/forgot")
  public String requestForgot() {
    return "recover";
  }

  @GetMapping("/view/swab/add")
  public String requestAddSwab() {
    return "aggiungi-tampone";
  }

  @GetMapping("/view/healthworker/add")
  public String requestAddSwabHealthWorker() {
    return "aggiungi-operatore";
  }

  @GetMapping("/view/patient/add")
  public String requestPatientAdd() {
    return "aggiungi-paziente";
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
    return gson.toJson(list);
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

  @GetMapping("/patient/loadradiography")
  public @ResponseBody String loadRadiography(Model m) {
    return "Da implementare";
  }

  @PostMapping("/swab/add")
  public String addSwab(@RequestParam(name = "cf") String cf,
                        @RequestParam(name = "idStruttura") String idStruttura,
                        @RequestParam(name = "isInterno") String isInterno) {
    Patient p = pc.getPazienteByCF(cf);
    Swab s = new Swab();
    s.setIsInterno(Boolean.parseBoolean(isInterno));
    s.setRisultato("");
    s.setIdStruttura(Integer.parseInt(idStruttura));
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
  public String requestAddHealthWorker(@RequestParam(name = "cf") String cf,
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
    String indirizzo = via + " " + strada + " " + civico + ", " + citta;
    pc.registerPatient(cf, nome, cognome, email, telefono, Boolean.parseBoolean(isInterno), indirizzo);
    return "aggiungi-paziente";
  }

  @PostMapping("healthworker/add")
  public void requestAddSwabHealthWorker(@RequestParam(name = "cf") String cf,
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
    HealthWorker hw = new HealthWorker(cf, "", "", email,
            telefono, ruolo, cognome, nome, indirizzo, Integer.parseInt(idStruttura));
    hc.insertHealthWorker(hw);
  }

  @GetMapping("/patient/diarioPaziente/byCF")
  public String getPaginaByCf(@RequestParam(name = "cf") String cf) {
    return gson.toJson(pc.getPaginaByCf(cf));
  }

  @GetMapping("/api/statistics/")
  public String getStatistiche() {
    return gson.toJson(sc.getStatistiche());
  }

  @GetMapping("/swab/inserisciRisultato")
  public String inserisciRisultato(@RequestParam(name = "idTampone") String id, 
                                 @RequestParam(name = "risultato") String risultato) {
    return gson.toJson(hc.inserisciRisultato(Integer.valueOf(id), risultato));
  }

  @GetMapping("/admin/inserisciStruttura")
  public String inserisciStruttura(@RequestParam(name = "struttura") String strutturaJson) 
                                  throws JSONException {
    return gson.toJson(ac.aggiungiStruttura(strutturaJson));
  }

  @GetMapping("/admin/rimuoviStruttura")
  public String rimuoviStruttura(@RequestParam(name = "idStruttura") Integer idStruttura) {
    return gson.toJson(ac.removeStruttura(idStruttura));
  }

  @GetMapping("/admin/getStrutturaById")
  public String getById(@RequestParam(name = "idStruttura") Integer id) {
    return gson.toJson(ac.getById(id));
  }

  @GetMapping("/admin/getAll")
  public String getAll() {
    return gson.toJson(ac.getAll());
  }

  @GetMapping("/")
  public String getView(Model m) {
    return "HomePage";
  }

  @GetMapping("/statistics")
  public String getViewStatistics(Model m) {
    m.addAttribute("statistics", gson.toJson(sc.getStatistiche()));
    return "Statistiche";
  }

  @GetMapping("/view/landing")
  public String showLogin() {
    return "Login";
  }

  @GetMapping("/view/about")
  public String showAboutUs() {
    return "Su-di-noi";
  }

}
