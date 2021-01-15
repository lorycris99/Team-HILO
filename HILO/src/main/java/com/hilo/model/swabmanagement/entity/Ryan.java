package com.hilo.model.swabmanagement.entity;

import java.io.IOException;
import java.io.Reader;
import java.util.Random;
import java.util.Scanner;

public class Ryan {

  public double getProba(Swab s) {
    Random gen = new Random();
    if (s.getIsInterno()) {
      return gen.nextDouble();
    }else {
//      throw new UnsupportedOperationException("Operazione ancora non implementata");
      try {
        System.out.println("DENTRO");
        Process p = Runtime.getRuntime().exec(new String[]{"python", "C:\\Users\\Lorenzo\\Desktop\\UniSa\\Lezioni Materiali\\Anno 3 - I Semestre\\Ingegneria del Software\\Team-HILO\\Modulo IA\\test.py"});
        Scanner in = new Scanner(p.getInputStream());
        while (p.isAlive()) {
        }

        System.out.println(in.nextLine());
        System.out.println(p.exitValue());
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
    return 0;
  }
}
