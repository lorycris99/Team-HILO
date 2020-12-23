package com.hilo.model.statisticsmanagement;

import com.hilo.model.swabmanagement.entity.EffettuaAsManager;
import com.hilo.model.swabmanagement.entity.EffettuapManager;
import com.hilo.model.swabmanagement.entity.Swab;
import com.hilo.model.swabmanagement.entity.SwabManager;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Statistica {

  public Statistica(){

  }

  public List<Swab> retreiveTamponi() {

    //TODO: cercare un modo più efficiente di fare questa operazione di filtering
    //recupero tutti i tamponi effettuati
    List<Swab> tempAll = swab.findAll();

    /*
     * se è la prima volta che richiamo il metodo e quindi non esiste una data di fine
     * riferimento, imposto la data finale di riferimento a ieri
     */
    if (dataFineRiferimento == null) {
      dataFineRiferimento = new GregorianCalendar();
      dataFineRiferimento.set(GregorianCalendar.DAY_OF_MONTH,
              dataFineRiferimento.get(GregorianCalendar.DAY_OF_MONTH) - 1);
    }

    //prendo la data finale alla quale si riferivano le precedenti statistiche
    String t1 = dataFineRiferimento.get(GregorianCalendar.YEAR) + "-"
            + (dataFineRiferimento.get(GregorianCalendar.MONTH) + 1) + "-"
            + dataFineRiferimento.get(GregorianCalendar.DAY_OF_MONTH);

    //prendo la data nella quale viene chiamato il metodo
    GregorianCalendar dataAttuale = new GregorianCalendar();

    String t2 = dataAttuale.get(GregorianCalendar.YEAR) + "-"
            + (dataAttuale.get(GregorianCalendar.MONTH) + 1) + "-"
            + dataAttuale.get(GregorianCalendar.DAY_OF_MONTH);

    /*
     * ottengo gli id dei tamponi effettuati nel periodo che va tra la fine del periodo precedente
     * e la data di oggi
     */
    List<Integer> swapPazienti = swabP.findTimestampBetween(t1, t2);
    List<Integer> swabOperatori = swabAs.findTimestampBetween(t1, t2);

    //salvo i tamponi che sono stati effettuati in questo periodo di riferimentp
    List<Swab> tamponiPeriodo = new ArrayList<>();
    for (Swab s : tempAll) {
      if (swabOperatori.contains(s.getId()) || swapPazienti.contains(s.getId())) {
        tamponiPeriodo.add(s);
      }
    }
    return tamponiPeriodo;
  }

  private List<Swab> listaTamponi;
  private GregorianCalendar dataFineRiferimento;
  private HashMap<String, Integer> medie;
  @Autowired
  private EffettuaAsManager swabAs;
  @Autowired
  private EffettuapManager swabP;
  @Autowired
  private SwabManager swab;
}
