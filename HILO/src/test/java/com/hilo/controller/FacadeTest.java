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
    String page = facade.doLogin("admin", "admin");
    Assertions.assertEquals("admin-homepage", page);
    session.invalidate();
//    Mockito.when(session.getAttribute("role")).thenReturn(null);
    Assertions.assertEquals("operatore-homepage", facade.doLogin("prova", "prova"));
//    Mockito.when(session.getAttribute("role")).thenReturn("healthworker");
    Assertions.assertEquals("HomePage", facade.doLogin("prova", "prova"));
    Mockito.verify(session, Mockito.times(6)).getAttribute("role");
  }


}
