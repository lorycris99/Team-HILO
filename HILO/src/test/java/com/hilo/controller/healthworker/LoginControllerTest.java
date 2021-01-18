package com.hilo.controller.healthworker;

import com.hilo.controller.LoginController;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 LoginControllerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginControllerTest {

  @Autowired
  private HttpSession session;

  @Autowired
  private LoginController controller;
  
  @Test
  @Order(1)
  public void doLoginTest() {
    String username = "admin";
    String password = "admin";

    boolean result = controller.doLogin(username, password);
    Assertions.assertTrue(result);
    Assertions.assertEquals("admin", session.getAttribute("role"));
    Assertions.assertEquals(username, session.getAttribute("username"));
    
    username = "sdvsvse";
    password = "efwegy";
    result = controller.doLogin(username, password);
    Assertions.assertTrue(result);
    Assertions.assertEquals("patient", session.getAttribute("role"));
    Assertions.assertEquals(username, session.getAttribute("username"));

    username = "g.conte1";
    password = "BonusBicicletta";
    result = controller.doLogin(username, password);
    Assertions.assertTrue(result);
    Assertions.assertEquals("healthworker", session.getAttribute("role"));
    Assertions.assertEquals(username, session.getAttribute("username"));

    session.invalidate();

    username = "proprioNessuno";
    password = "decisamenteNessuno";
    result = controller.doLogin(username, password);
    Assertions.assertFalse(result);
    Assertions.assertEquals(null, session.getAttribute("role"));
    Assertions.assertEquals(null, session.getAttribute("username"));

  }

  
}