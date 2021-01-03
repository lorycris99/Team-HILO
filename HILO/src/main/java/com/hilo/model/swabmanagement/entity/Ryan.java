package com.hilo.model.swabmanagement.entity;

import java.util.Random;

public class Ryan {

  public double getProba(Swab s) {
    Random gen = new Random();
    if (s.getIsInterno()) {
      return gen.nextDouble();
    }else {
      throw new UnsupportedOperationException("Operazione ancora non implementata");
    }
  }
}
