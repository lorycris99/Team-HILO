package com.hilo.model.adminmanagement;

import com.hilo.model.adminmanagement.entity.EmbeddedAfferire;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 EmbeddedAfferireTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEmbeddedAfferire {

    @Test
    @Order(1)
    public void equalsTest(){
        EmbeddedAfferire a=new EmbeddedAfferire();
        a.setIdStruttura(10);
        a.setCfPaziente("abc");

        EmbeddedAfferire b=new EmbeddedAfferire();
        b.setIdStruttura(10);
        b.setCfPaziente("abc");

        Assertions.assertEquals(true, a.equals(a));
        Assertions.assertEquals(true, a.equals(b));
        Assertions.assertEquals(false, a.equals(null));
        Assertions.assertEquals(false, a.equals(""));
        b.setIdStruttura(20);
        Assertions.assertEquals(false, a.equals(b));
        b.setIdStruttura(10);
        b.setCfPaziente("aaa");
        Assertions.assertEquals(false, a.equals(b));

    }
}
