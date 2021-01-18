package com.hilo;

import com.hilo.controller.healthworker.HealthWorkerTest;
import com.hilo.controller.healthworker.LoginControllerTest;
import com.hilo.controller.healthworker.PatientControllerTest;
import com.hilo.model.adminmanagement.TestAfferire;
import com.hilo.model.adminmanagement.TestAfferireManager;
import com.hilo.model.adminmanagement.TestEmbeddedAfferire;
import com.hilo.model.adminmanagement.TestStruttura;
import com.hilo.model.adminmanagement.TestStrutturaManager;
import com.hilo.model.healthworkermanagement.TestHealthWorker;
import com.hilo.model.healthworkermanagement.TestHealthWorkerManager;
import com.hilo.model.patientmanagement.entity.TestEmbeddedPagina;
import com.hilo.model.patientmanagement.entity.TestEmbeddedPaginaDiarioClinico;
import com.hilo.model.patientmanagement.entity.TestEmbeddedRadiografia;
import com.hilo.model.patientmanagement.entity.TestPagina;
import com.hilo.model.patientmanagement.entity.TestPaginaDiarioClinico;
import com.hilo.model.patientmanagement.entity.TestPaginaDiarioClinicoManager;
import com.hilo.model.patientmanagement.entity.TestPaginaManager;
import com.hilo.model.patientmanagement.entity.TestPatient;
import com.hilo.model.patientmanagement.entity.TestPatientManager;
import com.hilo.model.patientmanagement.entity.TestRadiografia;
import com.hilo.model.patientmanagement.entity.TestRadiografiaManager;
import com.hilo.model.swabmanagement.TestEffettuaAs;
import com.hilo.model.swabmanagement.TestEffettuaAsManager;
import com.hilo.model.swabmanagement.TestEffettuaP;
import com.hilo.model.swabmanagement.TestEffettuaPManager;
import com.hilo.model.swabmanagement.TestEmbeddedEffettuaP;
import com.hilo.model.swabmanagement.TestSwab;
import com.hilo.model.swabmanagement.TestSwabManager;
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
    TestEmbeddedRadiografia.class, TestEmbeddedPaginaDiarioClinico.class,
    TestPaginaDiarioClinico.class, TestPaginaDiarioClinicoManager.class, 
    TestRadiografiaManager.class, TestRadiografia.class, 
    LoginControllerTest.class, PatientControllerTest.class})
public class HiloApplicationTests {}
