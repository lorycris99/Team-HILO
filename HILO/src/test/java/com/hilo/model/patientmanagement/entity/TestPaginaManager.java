package com.hilo.model.patientmanagement.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 PaginaManagerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPaginaManager {
    @Autowired
    private PaginaManager manager;
    @Autowired
    private PatientManager pm;

    @Test
    @Order(1)
    public void findByIdTest(){
        List<Pagina> lista=manager.findAll();
        Pagina temp=null;
        for(int i=0;i<lista.size();i++){
            if((lista.get(i).getCfPaziente().equals("DMAVCR00A10F912V")) && lista.get(i).getNumero()==1){
                 temp=lista.get(i);
            }
        }
        Assertions.assertEquals(manager.findById(1,"DMAVCR00A10F912V"),temp);
        Assertions.assertEquals(manager.findById(666,"abc"),null);

    }

    @Test
    @Order(2)
    public void findByCfTest(){
        List<Pagina>lista=manager.findAll();
        List<Pagina>temp=new ArrayList<Pagina>();
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getCfPaziente().equals("DMAVCR00A10F912V")){
                temp.add(lista.get(i));
            }
        }
        Assertions.assertEquals(manager.findByCf("DMAVCR00A10F912V"),temp);
    }

    @Test
    @Order(3)
    void createTest(){
        Pagina p=new Pagina();
        p.setCfPaziente("DMAVCR00A10F912V"); p.setNumero(10); p.setTemperatura(40.3); p.setSintomi("no"); p.setNote("niente");
        manager.createPagina(p);
        Assertions.assertEquals(manager.findById(10,"DMAVCR00A10F912V"),p);

    }
    @Test
    @Order(4)
    public void deleteTest() {
        manager.deletePagina(manager.findById(10,"DMAVCR00A10F912V"));
        Assertions.assertNull(manager.findById(10,"DMAVCR00A10F912V"));
    }


}
