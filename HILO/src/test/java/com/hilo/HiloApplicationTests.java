package com.hilo;

import com.hilo.model.patientmanagement.entity.TestPatientManager;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@SuiteClasses({TestPatientManager.class})
public class HiloApplicationTests {}
