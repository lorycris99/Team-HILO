package com.hilo;

import com.hilo.controller.healthWorker.HealthWorkerTest;
import com.hilo.model.adminmanagement.TestAfferire;
import com.hilo.model.adminmanagement.TestAfferireManager;
import com.hilo.model.adminmanagement.TestStruttura;
import com.hilo.model.adminmanagement.TestStrutturaManager;
import com.hilo.model.healthworkermanagement.TestHealthWorker;
import com.hilo.model.healthworkermanagement.TestHealthWorkerManager;
import com.hilo.model.patientmanagement.entity.TestPagina;
import com.hilo.model.patientmanagement.entity.TestPaginaManager;
import com.hilo.model.patientmanagement.entity.TestPatient;
import com.hilo.model.patientmanagement.entity.TestPatientManager;
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
    TestAfferire.class, TestAfferireManager.class, TestEffettuaP.class, TestEffettuaPManager.class})
public class HiloApplicationTests {}
