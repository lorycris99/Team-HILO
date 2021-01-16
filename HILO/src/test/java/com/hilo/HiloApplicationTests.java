package com.hilo;

import com.hilo.controller.healthWorker.HealthWorkerTest;
import com.hilo.model.patientmanagement.entity.TestPagina;
import com.hilo.model.patientmanagement.entity.TestPaginaManager;
import com.hilo.model.patientmanagement.entity.TestPatient;
import com.hilo.model.patientmanagement.entity.TestPatientManager;
import com.hilo.model.swabmanagement.TestEffettuaAs;
import com.hilo.model.swabmanagement.TestEffettuaAsManager;
import com.hilo.model.swabmanagement.TestSwab;
import com.hilo.model.swabmanagement.TestSwabManager;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(JUnitPlatform.class)
@SelectClasses({TestPatient.class, TestPatientManager.class, TestSwab.class, TestSwabManager.class, HealthWorkerTest.class, TestPagina.class, TestPaginaManager.class, TestEffettuaAs.class, TestEffettuaAsManager.class})
public class HiloApplicationTests {}
