package com.hilo.model.swabmanagement.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class SwabComparator implements Comparator<Swab> {

  @Override
  public int compare(Swab o1, Swab o2) {
    double proba1 = Double.MIN_VALUE;
    double proba2 = Double.MIN_VALUE;
    boolean interno1 = false;
    boolean interno2 = false;

    Ryan ryan = new Ryan();

    //se sono interni allora avro' una probabilita' di positivita'
    if (o1.getIsInterno()) {
      proba1 = ryan.getProba(o1);
      interno1 = true;
    }

    if (o2.getIsInterno()) {
      proba2 = ryan.getProba(o2);
      interno2 = true;
    }

    //se sono entrambi interni
    if (interno1 && interno2) {

      if (proba1 > proba2) {
        return 1;
      } else if (proba1 < proba2) {
        return -1;
      } else {
        return 0;
      }
    } else if (!interno1 && !interno2) { //se sono entrambi esterni devo gestire le date
      pMan = new EffettuapManager();
      asMan = new EffettuaAsManager();

      List<EffettuaAs> allAs = asMan.findAll();
      List<EffettuaP> allP = pMan.findAll();

      //estraggo le date dai tamponi
      String timestamp1 = null;
      String timestamp2 = null;
      for(int i = 0; i < allAs.size(); i++) {
        if (allAs.get(i).getIdTampone() == o1.getId()) {
          timestamp1 = allAs.get(i).getTimestamp();
        } else if (allAs.get(i).getIdTampone() == o2.getId()) {
          timestamp2 = allAs.get(i).getTimestamp();
        }//if
      }// for i

      //se non ho trovato uno dei due timestamp devo controllare anche l'altra lista
      if (timestamp1 == null || timestamp2 == null) {
        for (int i = 0; i < allP.size(); i++) {
          if (allP.get(i).getIdTampone() == o1.getId()) {
            timestamp1 = allP.get(i).getTimestamp();
          } else if (allP.get(i).getIdTampone() == o2.getId()) {
            timestamp2 = allP.get(i).getTimestamp();
          }//if
        }//for i
      }//if timestamp
      SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
      Date t1 = null;
      Date t2 = null;
      try {
        t1 = f.parse(timestamp1);
        t2 = f.parse(timestamp2);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      if (t1.after(t2)) {
        return -1;
      }else if (t1.before(t2)) {
        return 1;
      }else{
        return 0;
      }
    }//if main
    return 0;

  }

  private EffettuapManager pMan;
  private EffettuaAsManager asMan;
}
