package com.hilo.model.patientmanagement.entity;

import com.hilo.model.swabmanagement.entity.SwabManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 PatientTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestPatient {
    @Autowired
    SwabManager man;
    Patient p;
    @Test
    @Order(1)
    public void CfTest(){
        p=new Patient();
        p.setCf("999999");
        Assertions.assertEquals(p.getCf(),"999999");
    }

    @Test
    @Order(2)
    public void usernameTest(){
        p=new Patient();
        p.setUsername("test");
        Assertions.assertEquals(p.getUsername(),"test");
    }

    @Test
    @Order(3)
    public void passwordTest(){
        p=new Patient();
        p.setPassword("pass");
        Assertions.assertEquals(p.getPassword(),"pass");
    }

    @Test
    @Order(4)
    public void mailTest(){
        p=new Patient();
        p.setMail("mail");
        Assertions.assertEquals(p.getMail(),"mail");
    }

    @Test
    @Order(5)
    public void telefonoTest(){
        p=new Patient();
        p.setTelefono("tell");
        Assertions.assertEquals(p.getTelefono(),"tell");
    }

    @Test
    @Order(6)
    public void internoTest(){
        p=new Patient();
        p.setIsInterno(true);
        Assertions.assertEquals(p.getIsInterno(),true);
    }

    @Test
    @Order(7)
    public void indirizzoTest(){
        p=new Patient();
        p.setIndirizzo("indirizzo");
        Assertions.assertEquals(p.getIndirizzo(),"indirizzo");
    }

    @Test
    @Order(8)
    public void nomeTest(){
        p=new Patient();
        p.setNome("nome");
        Assertions.assertEquals(p.getNome(),"nome");
    }

    @Test
    @Order(9)
    public void cognomeTest(){
        p=new Patient();
        p.setCognome("cognome");
        Assertions.assertEquals(p.getCognome(),"cognome");
    }

    @Test
    @Order(10)
    public void equalsTest(){
        Patient a=new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
        Patient b=new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
        Assertions.assertEquals(true,a.equals(b));
        Assertions.assertEquals(true,a.equals(a));
        Assertions.assertEquals(false,a.equals(null));
        Assertions.assertEquals(false,a.equals(""));
        Patient c=new Patient("4321", "user2", "pass", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
        Patient d=new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
        Assertions.assertEquals(false,c.equals(d));
        Patient e=new Patient("4321", "user2", "pass2", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
        Patient f=new Patient("4321", "user2", "pass", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
        Assertions.assertEquals(false,e.equals(f));
        Patient g=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
        Patient h=new Patient("4321", "user2", "pass2", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
        Assertions.assertEquals(false,g.equals(h));
        Patient i=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", false, "via kek 24", "lmao", "yeah");
        Patient l=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
        Assertions.assertEquals(false,i.equals(l));
        Patient m=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", true, "via kek 24", "lmao", "yeah");
        Patient n=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", false, "via kek 24", "lmao", "yeah");
        Assertions.assertEquals(false,m.equals(n));
        Patient o=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", true, "via kek 244", "lmao", "yeah");
        Patient p=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", true, "via kek 24", "lmao", "yeah");
        Assertions.assertEquals(false,o.equals(p));
        Patient q=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", true, "via kek 244", "lmapo", "yeah");
        Patient r=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", true, "via kek 244", "lmao", "yeah");
        Assertions.assertEquals(false,q.equals(r));
        Patient s=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", true, "via kek 244", "lmapo", "yeahg");
        Patient t=new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", true, "via kek 244", "lmapo", "yeah");
        Assertions.assertEquals(false,s.equals(t));






    }




}
