package com.hilo;

import com.hilo.model.patientmanagement.entity.TestPatientManager;
import com.hilo.model.swabmanagement.entity.SwabQueueProva;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@SuiteClasses({TestPatientManager.class, com.hilo.model.swab.SwabQueueProva.class})
public class HiloApplicationTests {}
