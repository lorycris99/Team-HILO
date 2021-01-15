package com.hilo.controller;

import org.springframework.stereotype.Component;

@Component
public class ErrorController {

  public void manageError(Throwable t) {
    if (t instanceof IllegalStateException) {
      System.out.println("Stato non consistente: ");
      t.printStackTrace();

    } else if (t instanceof IllegalArgumentException) {
      System.out.println("Argomento Sbagliato: ");
      t.printStackTrace();

    } else {
      System.out.println("Errore Generico: ");
      t.printStackTrace();
    }
  }
}
