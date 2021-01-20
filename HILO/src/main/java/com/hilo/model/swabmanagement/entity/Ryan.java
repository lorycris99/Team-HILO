package com.hilo.model.swabmanagement.entity;


import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.patientmanagement.entity.Radiografia;
import com.hilo.model.patientmanagement.entity.RadiografiaManager;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;
import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Questa classe è l'implementazione del modulo di Intelligenza Artificiale.
 */
@Component
public class Ryan {
  @Autowired
  EffettuapManager ep;
  @Autowired
  RadiografiaManager rm;

  /**
   * Questo metodo fornisce la probabilita' di positivita' al Covid di un paziente
   * data la sua radiografia.
   *
   * @param s Il tampone al quale associare la probabilita'
   *
   * @param p Il paziente che ha effettuato il tampone
   *
   * @return la probabilita' di positivita' al covid
   */
  public double getProba(Swab s, Patient p) {
    List<Radiografia> list = rm.findByCfPaziente(p.getCf());
    Radiografia rad = list.get(list.size() - 1);
    double prediction = 12;
    File f = null;
    try {
      BufferedImage imageT = ImageIO.read(new ByteArrayInputStream(rad.getImg()));
      ImageIO.write(imageT, "JPG", new File("temp.jpg"));
      f = new File("temp.jpg");
      NativeImageLoader loader = new NativeImageLoader(100, 100, 1);

      INDArray image = loader.asMatrix(f, false);

      DataNormalization scalar = new ImagePreProcessingScaler(0, 1);

      scalar.transform(image);

      InputStream inputStream = new FileInputStream("Ryan92,5");
      MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(inputStream);

      prediction = model.output(image).getDouble(0);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      f.delete();
    }
    return prediction;
  }

}
