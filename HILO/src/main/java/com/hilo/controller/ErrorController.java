package com.hilo.controller;

import org.springframework.stereotype.Component;

@Component
public class ErrorController {

  public void manageError(Throwable t) {
    if (t instanceof IllegalStateException) {
      return;
    }
  }
}
