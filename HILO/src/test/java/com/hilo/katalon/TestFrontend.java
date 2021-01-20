package com.hilo.katalon;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.patientmanagement.entity.PatientManager;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 katalonTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFrontend {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Autowired
  private PatientManager pm;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\ivanc\\Desktop\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  @Order(1)
  public void testTC101() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    new Select(driver.findElement(By.id("isInterno"))).selectByVisibleText("Esterno");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(2)
  public void testTC102() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("testTestTest");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(3)
  public void testTC103() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(4)
  public void testTC104() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail#provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(5)
  public void testTC105() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(6)
  public void testTC106() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Rom@");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(7)
  public void testTC107() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(8)
  public void testTC108() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("1-");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(9)
  public void testTC109() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(10)
  public void testTC110() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("333333333-");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(11)
  public void testTC111() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("33333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(12)
  public void testTC112() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(13)
  public void testTC113() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mari@");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(14)
  public void testTC114() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(15)
  public void testTC115() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Ross#");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(16)
  public void testTC116() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(17)
  public void testTC117() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Mil#n@");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(18)
  public void testTC118() throws Exception {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Paziente")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@provider.it");
    driver.findElement(By.name("via")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Corso");
    driver.findElement(By.name("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Roma");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("12");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("3333333333");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("button")).click();
    assertFalse(isAlertPresent());
  }

  //Inizio Test TC 2

  @Test
  @Order(19)
  public void testTC201() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(20)
  public void testTC202() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("qualsiasiValoreACaso");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(21)
  public void testTC203() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(22)
  public void testTC204() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(23)
  public void testTC205() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mail@ministerodellasalute.it");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(24)
  public void testTC206() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("44444444-");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(25)
  public void testTC207() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("44444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(26)
  public void testTC208() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(27)
  public void testTC209() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("G14c0m0");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(28)
  public void testTC210() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(29)
  public void testTC211() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("P0r3tt1");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(30)
  public void testTC212() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(31)
  public void testTC213() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("M#l£nà");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(32)
  public void testTC214() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(33)
  public void testTC215() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("mil@n%");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(34)
  public void testTC216() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(35)
  public void testTC217() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("centoventisei");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(36)
  public void testTC218() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(37)
  public void testTC219() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("dieci");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(38)
  public void testTC220() throws Exception {
    driver.get("http://localhost:8080/logout");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Operatore")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("PRTGMN56D26B301S");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("mailOS@ministerodellasalute.it");
    driver.findElement(By.id("telefono")).click();
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("444444444");
    driver.findElement(By.id("ruolo")).click();
    new Select(driver.findElement(By.id("ruolo"))).selectByVisibleText("Analista");
    driver.findElement(By.id("ruolo")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giacomo");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Poretti");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).clear();
    driver.findElement(By.id("citta")).sendKeys("Milano");
    driver.findElement(By.id("via")).click();
    new Select(driver.findElement(By.id("via"))).selectByVisibleText("Viale");
    driver.findElement(By.id("via")).click();
    driver.findElement(By.id("strada")).click();
    driver.findElement(By.id("strada")).clear();
    driver.findElement(By.id("strada")).sendKeys("Milano");
    driver.findElement(By.id("civico")).click();
    driver.findElement(By.id("civico")).clear();
    driver.findElement(By.id("civico")).sendKeys("126");
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertFalse(isAlertPresent());
  }

//Inzio TC3

  @Test
  @Order(39)
  public void test301() throws Exception {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Tampone")).click();
    driver.findElement(By.id("isInterno")).click();
    new Select(driver.findElement(By.id("isInterno"))).selectByVisibleText("Esterno");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("cfacaso");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(40)
  public void test302() throws Exception {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Tampone")).click();
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("quarantadue");
    driver.findElement(By.id("isInterno")).click();
    new Select(driver.findElement(By.id("isInterno"))).selectByVisibleText("Esterno");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("cfacaso");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(41)
  public void test303() throws Exception {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Tampone")).click();
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.id("isInterno")).click();
    new Select(driver.findElement(By.id("isInterno"))).selectByVisibleText("Esterno");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(42)
  public void test304() throws Exception {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Tampone")).click();
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.id("isInterno")).click();
    new Select(driver.findElement(By.id("isInterno"))).selectByVisibleText("Esterno");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U#");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Non Funziona", closeAlertAndGetItsText());
  }

  @Test
  @Order(43)
  public void test305() throws Exception {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("prova");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("prova");
    driver.findElement(By.id("button")).click();
    driver.findElement(By.linkText("Inserisci Tampone")).click();
    driver.findElement(By.id("idStruttura")).click();
    driver.findElement(By.id("idStruttura")).clear();
    driver.findElement(By.id("idStruttura")).sendKeys("1");
    driver.findElement(By.id("isInterno")).click();
    new Select(driver.findElement(By.id("isInterno"))).selectByVisibleText("Esterno");
    driver.findElement(By.id("isInterno")).click();
    driver.findElement(By.id("cf")).click();
    driver.findElement(By.id("cf")).clear();
    driver.findElement(By.id("cf")).sendKeys("RSSMRA80A01H501U");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertFalse(isAlertPresent());
  }



  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

