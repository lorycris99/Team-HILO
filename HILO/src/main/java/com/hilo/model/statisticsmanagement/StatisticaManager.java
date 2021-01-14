package com.hilo.model.statisticsmanagement;

import com.google.gson.Gson;
import com.hilo.model.swabmanagement.entity.EffettuaAsManager;
import com.hilo.model.swabmanagement.entity.EffettuapManager;
import com.hilo.model.swabmanagement.entity.Swab;
import com.hilo.model.swabmanagement.entity.SwabManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticaManager {

  public StatisticaManager(){

  }

  //TODO: capire se fare lo storico
  /**
   * Serve per ottenere tutti i tamponi effettuati in un arco di tempo che va dall'ultimo richiamo
   * del metodo alla data in cui è richiamato nuovamente il metodo. Nel caso in cui viene
   * richiamato la prima volta e non è stata impostata una data di riferimento, il periodo
   * considerato è tra il giorno prima e il giorno in cui viene richiamato il metodo.
   *
   * @return tutti i tamponi effettuati, sia su pazienti che operatori sanitari, in un intervallo
   *     di tempo che va tra la data dell'ultimo richiamo del metodo e la data di chiamata del
   *     metodo
   *
   */
  public List<Swab> retreiveTamponi() {

    //TODO: cercare un modo più efficiente di fare questa operazione di filtering
    //recupero tutti i tamponi effettuati
    List<Swab> tempAll;
    tempAll = swab.findAll();

    /*
     * se è la prima volta che richiamo il metodo e quindi non esiste una data di fine
     * riferimento, imposto la data finale di riferimento a ieri
     */
    if (dataFineRiferimento == null) {
      dataFineRiferimento = new GregorianCalendar();
      dataFineRiferimento.set(GregorianCalendar.DAY_OF_MONTH,
              dataFineRiferimento.get(GregorianCalendar.DAY_OF_MONTH) - 1);
    }
    String anno = dataFineRiferimento.get(GregorianCalendar.YEAR) + "-";

    String mese;
    if ((dataFineRiferimento.get(GregorianCalendar.MONTH) + 1) < 10) {
      mese = "0" + (dataFineRiferimento.get(GregorianCalendar.MONTH) + 1) + "-";
    } else {
      mese = (dataFineRiferimento.get(GregorianCalendar.MONTH) + 1) + "-";
    }

    String giorno;
    if (dataFineRiferimento.get(GregorianCalendar.DAY_OF_MONTH) < 10) {
      giorno = "0" + dataFineRiferimento.get(GregorianCalendar.DAY_OF_MONTH);
    } else {
      giorno = "" + dataFineRiferimento.get(GregorianCalendar.DAY_OF_MONTH);
    }

    //prendo la data finale alla quale si riferivano le precedenti statistiche
    String t1;
    t1 = anno + mese + giorno;

    //prendo la data nella quale viene chiamato il metodo
    GregorianCalendar dataAttuale = new GregorianCalendar();

    anno = dataAttuale.get(GregorianCalendar.YEAR) + "-";

    if ((dataAttuale.get(GregorianCalendar.MONTH) + 1) < 10) {
      mese = "0" + (dataAttuale.get(GregorianCalendar.MONTH) + 1) + "-";
    } else {
      mese = (dataAttuale.get(GregorianCalendar.MONTH) + 1) + "-";
    }

    if (dataAttuale.get(GregorianCalendar.DAY_OF_MONTH) < 10) {
      giorno = "0" + dataAttuale.get(GregorianCalendar.DAY_OF_MONTH);
    } else {
      giorno = "" + dataAttuale.get(GregorianCalendar.DAY_OF_MONTH);
    }
    String t2 = anno + mese + giorno;

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

  public Map<String, Integer> getSommaEsiti(List<Swab> listaTamponi) {

    //inizializzo i dati per contare i vari esiti dei tamponi
    HashMap<String, Integer> elenco = new HashMap<>();
    elenco.put("Positivo", 0);
    elenco.put("Negativo", 0);
    elenco.put("Inconcludente", 0);

    //controllo per ogni tampone l'esito e sommo ogni volta il totale
    for (Swab s : listaTamponi) {

      if (s.getRisultato().equals("Positivo")) {

        elenco.put("Positivo", elenco.get("Positivo") + 1);

      } else if (s.getRisultato().equals("Negativo")) {

        elenco.put("Negativo", elenco.get("Negativo") + 1);

      } else {

        elenco.put("Inconcludente", elenco.get("Inconcludente") + 1);

      }

    }

    return elenco;

  }

  public boolean saveStats(Statistica stat) {

    File file = new File(FILE_PATH);
    Gson gson = new Gson();
    FileWriter out;

    try {
      out = new FileWriter(file);
      out.append(gson.toJson(stat));
      out.close();
      return true;

    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public Statistica readStats() {

    Statistica stat = null;
    File file = new File(FILE_PATH);
    Scanner in = null;

    try {
      in = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }

    String temp = "";
    Gson gson = new Gson();
    while (in.hasNext()) {
      temp += in.nextLine();
    }
    in.close();
    return gson.fromJson(temp, Statistica.class);
  }

  public Statistica getStatistiche(Map<String, Integer> esitiTamponi) {

    return new Statistica(esitiTamponi.get("Positivo"), esitiTamponi.get("Negativo"),
            esitiTamponi.get("Inconcludente"));
  }

  public GregorianCalendar getDataFineRiferimento() {
    return dataFineRiferimento;
  }

  public void setDataFineRiferimento(GregorianCalendar dataFineRiferimento) {
    this.dataFineRiferimento = dataFineRiferimento;
  }

  private GregorianCalendar dataFineRiferimento;
  @Autowired
  private EffettuaAsManager swabAs;
  @Autowired
  private EffettuapManager swabP;
  @Autowired
  private SwabManager swab;

  private static final String FILE_PATH = "stats.txt";
}
