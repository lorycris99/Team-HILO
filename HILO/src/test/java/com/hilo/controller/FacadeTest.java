package com.hilo.controller;


import com.google.gson.Gson;
import com.hilo.model.patientmanagement.entity.Pagina;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@SpringBootTest
@DisplayName("JUnit 5 FacadeTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FacadeTest {

  @InjectMocks
  private FacadeController facade;

  @Mock
  private HttpSession session;

  @Mock
  private PatientController pc;

  @Mock
  private LoginController lc;

  private Gson gson;

  private Model m;

  @Test
  public void testAddHealthWorker() {
    Mockito.when(session.getAttribute("role")).thenReturn("admin");
    String val = facade.requestAddHealthWorker();
    Mockito.verify(session, Mockito.times(2)).getAttribute("role");
    Assertions.assertEquals("aggiungi-operatore", val);
  }

  @Test
  public void testGetPaginaByIds() {
    gson = new Gson();
    Pagina p = gson.fromJson(facade.getPaginaByIds("DMAVCR00A10F912V", 1), Pagina.class);
    Mockito.verify(pc, Mockito.times(1)).getPaginaByIds("DMAVCR00A10F912V", 1);
  }

  @Test
  public void testDoLogin() {
//    Mockito.when(session.getAttribute("role")).thenReturn(null);
    Mockito.when(session.getAttribute("role")).thenReturn(null).thenReturn("admin");
    String page = facade.doLogin("admin", "admin");
    Assertions.assertEquals("admin-homepage", page);
    Mockito.verify(session, Mockito.times(4)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn(null).thenReturn("healthworker");
    Assertions.assertEquals("operatore-homepage", facade.doLogin("prova", "prova"));
    Mockito.verify(session, Mockito.times(3)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("healthworker");
    Assertions.assertEquals("HomePage", facade.doLogin("prova", "prova"));
    Mockito.verify(session, Mockito.times(1)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn(null).thenReturn("patient");
    Assertions.assertEquals("HomePage", facade.doLogin("sdvsvse", "efwegy"));
    Mockito.verify(session, Mockito.times(4)).getAttribute("role");
  }

  @Test
  public void testDoLogout() {
    Assertions.assertEquals("HomePage", facade.doLogout());
    Mockito.verify(lc, Mockito.times(1)).doLogout();
  }

  @Test
  public void testRequestAddSwab() {
    Mockito.when(session.getAttribute("role")).thenReturn(null).thenReturn("null");
    Assertions.assertEquals("HomePage", facade.requestAddSwab());
    Mockito.verify(session,Mockito.times(2)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("healthworker");
    Assertions.assertEquals("aggiungi-tampone", facade.requestAddSwab());
    Mockito.verify(session,Mockito.times(2)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("admin");
    Assertions.assertEquals("aggiungi-tampone", facade.requestAddSwab());
    Mockito.verify(session,Mockito.times(3)).getAttribute("role");
  }

  @Test
  public void testRequestAddHealthWorker() {
    Mockito.when(session.getAttribute("role")).thenReturn(null).thenReturn("null");
    Assertions.assertEquals("HomePage", facade.requestAddHealthWorker());
    Mockito.verify(session,Mockito.times(1)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("admin");
    Assertions.assertEquals("aggiungi-operatore", facade.requestAddHealthWorker());
    Mockito.verify(session,Mockito.times(2)).getAttribute("role");
  }

  @Test
  public void testRequestPatientAdd() {
    Mockito.when(session.getAttribute("role")).thenReturn(null).thenReturn("null");
    Assertions.assertEquals("HomePage", facade.requestPatientAdd());
    Mockito.verify(session,Mockito.times(2)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("healthworker");
    Assertions.assertEquals("aggiungi-paziente", facade.requestPatientAdd());
    Mockito.verify(session,Mockito.times(3)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("admin");
    Assertions.assertEquals("aggiungi-paziente", facade.requestPatientAdd());
    Mockito.verify(session,Mockito.times(2)).getAttribute("role");
  }

  /*@Test
  public void testFindSwabByPatient() {
    m = new ConcurrentModel();
    Mockito.when(session.getAttribute("role")).thenReturn(null);
    Assertions.assertEquals("HomePage", facade.findSwabByPatient(m, ""));
    Mockito.verify(session,Mockito.times(2)).getAttribute("role");
    Mockito.reset(session);
  }*/

  @Test
  public void testRequestHealthWorkerHomepage() {
    Mockito.when(session.getAttribute("role")).thenReturn(null).thenReturn("null");
    Assertions.assertEquals("HomePage", facade.requestHealthWorkerHomepage());
    Mockito.verify(session,Mockito.times(1)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("healthworker");
    Assertions.assertEquals("operatore-homepage", facade.requestHealthWorkerHomepage());
    Mockito.verify(session,Mockito.times(2)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("admin");
    Assertions.assertEquals("operatore-homepage", facade.requestHealthWorkerHomepage());
    Mockito.verify(session,Mockito.times(3)).getAttribute("role");
  }

  @Test
  public void testLoadRadiography() {
    m = new ConcurrentModel();
    Mockito.when(session.getAttribute("role")).thenReturn(null).thenReturn("null");
    Assertions.assertEquals("HomePage", facade.loadRadiography(m));
    Mockito.verify(session,Mockito.times(1)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("healthworker");
    Assertions.assertEquals("aggiungi-radiografia", facade.loadRadiography(m));
    Mockito.verify(session,Mockito.times(3)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("admin");
    Assertions.assertEquals("aggiungi-radiografia", facade.loadRadiography(m));
    Mockito.verify(session,Mockito.times(2)).getAttribute("role");
  }

  @Test
  public void testAddSwab() {
    Mockito.when(session.getAttribute("role")).thenReturn(null);
    Assertions.assertEquals("HomePage", facade.addSwab("", "",""));
    Mockito.verify(session,Mockito.times(1)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("admin");
    Assertions.assertEquals("HomePage", facade.addSwab("", "", ""));
    Mockito.verify(session,Mockito.times(2)).getAttribute("role");
  }

  @Test
  public void testShowLogin() {
    Mockito.when(session.getAttribute("role")).thenReturn(null);
    Assertions.assertEquals("Login", facade.showLogin());
    Mockito.verify(session,Mockito.times(1)).getAttribute("role");
    Mockito.reset(session);
    Mockito.when(session.getAttribute("role")).thenReturn("admin");
    Assertions.assertEquals("HomePage", facade.showLogin());
    Mockito.verify(session,Mockito.times(1)).getAttribute("role");
  }

}
