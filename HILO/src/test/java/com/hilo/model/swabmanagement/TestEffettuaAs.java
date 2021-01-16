package com.hilo.model.swabmanagement;

import com.hilo.model.patientmanagement.entity.Pagina;
import com.hilo.model.swabmanagement.entity.EffettuaAs;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 EffettuaAsTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEffettuaAs {
    EffettuaAs e=null;

    @Test
    @Order(1)
    public void equalsTest(){
        Pagina x=null;
        e=new EffettuaAs();
        EffettuaAs f=new EffettuaAs();
        f.setTimestamp("ok");
        f.setCfAs("test");
        f.setIdTampone(10);
        e.setCfAs("test");
        e.setIdTampone(10);
        e.setTimestamp("ok");
        Assertions.assertEquals(true, e.equals(e));
        Assertions.assertEquals(false,e.equals(x));
        Assertions.assertEquals(false, e.equals(""));
        Assertions.assertEquals(true, e.equals(f));
        e.setIdTampone(5);
        Assertions.assertEquals(false, e.equals(f));
        e.setIdTampone(10); e.setCfAs("test2");
        Assertions.assertEquals(false, e.equals(f));
        e.setCfAs("test"); e.setTimestamp("lol");
        Assertions.assertEquals(false, e.equals(f));





    }
}
