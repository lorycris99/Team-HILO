package com.hilo;

import com.hilo.controller.healthWorker.HealthWorkerTest;
import com.hilo.model.patientmanagement.entity.TestPatient;
import com.hilo.model.patientmanagement.entity.TestPatientManager;
import com.hilo.model.swab.TestSwab;
import com.hilo.model.swab.TestSwabManager;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(JUnitPlatform.class)
@SelectClasses({TestPatient.class, TestPatientManager.class, TestSwab.class, TestSwabManager.class, HealthWorkerTest.class})
public class HiloApplicationTests {}
