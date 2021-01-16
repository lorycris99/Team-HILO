package com.hilo.controller;

import com.google.gson.Gson;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
  public void doLogout() {
    lc.doLogout();
  }

  @PostMapping("/login")
  public String doLogin(@RequestParam(name = "username") String user,
                        @RequestParam(name = "password") String pass) throws JSONException {
    System.out.println(lc.doLogin(user, pass));
    return "redirect:/";
  }

  @PostMapping("/patient/register")
  public String register(@RequestParam(name = "User") String user) throws JSONException {
    String role = (String) session.getAttribute("role");
    if (!role.equalsIgnoreCase("healthworker")) {
      return "Accesso negato";
    }
    return gson.toJson(pc.registerPatient(user));
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
    System.out.println(session.getAttribute("role"));
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
