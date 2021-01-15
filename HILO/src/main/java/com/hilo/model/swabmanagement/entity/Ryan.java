package com.hilo.model.swabmanagement.entity;

import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Ryan {

  public double getProba(Swab s) {
    double prediction = 12;
    try {
      File f=new File("valuta\\test.jpg");

      //Use the nativeImageLoader to convert to numerical matrix
      NativeImageLoader loader = new NativeImageLoader(100, 100, 1);

      //put image into INDArray
      INDArray image = loader.asMatrix(f, false);

      //values need to be scaled
      DataNormalization scalar = new ImagePreProcessingScaler(0, 1);

      //then call that scalar on the image dataset
      scalar.transform(image);



      InputStream inputStream = new FileInputStream("Ryan92,5");
      MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(inputStream);

      prediction = model.output(image).getDouble(0);

    } catch (Exception e){
      e.printStackTrace();
    }
    return prediction;
  }

}
