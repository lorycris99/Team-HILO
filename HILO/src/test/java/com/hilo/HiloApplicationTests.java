package com.hilo;

import com.hilo.controller.healthWorker.HealthWorkerTest;
import com.hilo.model.adminmanagement.*;
import com.hilo.model.healthworkermanagement.TestHealthWorker;
import com.hilo.model.healthworkermanagement.TestHealthWorkerManager;
import com.hilo.model.patientmanagement.entity.*;
import com.hilo.model.swabmanagement.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(JUnitPlatform.class)
@SelectClasses({TestPatient.class, TestPatientManager.class, TestSwab.class, 
    TestSwabManager.class, HealthWorkerTest.class, TestPagina.class, TestPaginaManager.class, 
    TestEffettuaAs.class, TestEffettuaAsManager.class, TestHealthWorker.class, 
    TestHealthWorkerManager.class, TestStruttura.class, TestStrutturaManager.class, 
    TestAfferire.class, TestAfferireManager.class, TestEffettuaP.class, TestEffettuaPManager.class,
    TestEmbeddedEffettuaP.class, TestEmbeddedAfferire.class, TestEmbeddedPagina.class,
    TestEmbeddedRadiografia.class,TestEmbeddedPaginaDiarioClinico.class,TestPaginaDiarioClinico.class,
    TestPaginaDiarioClinicoManager.class,TestRadiografiaManager.class,TestRadiografia.class})
public class HiloApplicationTests {}
