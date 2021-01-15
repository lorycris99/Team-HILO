package com.hilo;

import com.hilo.model.patientmanagement.entity.TestPatientManager;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(JUnitPlatform.class)
@SelectClasses({TestPatientManager.class})
public class HiloApplicationTests {}
