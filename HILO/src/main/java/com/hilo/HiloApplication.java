package com.hilo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HiloApplication {

  public static void main(String[] args) {
    SpringApplication.run(HiloApplication.class, args);
  }

}
