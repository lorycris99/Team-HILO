import numpy as np # linear algebra
import sys
import os
import numpy as np 
import warnings
import json
warnings.filterwarnings('ignore')
from tensorflow import keras
from tensorflow.keras.preprocessing import image
from tensorflow.keras.models import Sequential

for file in os.listdir("valuta/"):
  test_image = image.load_img('valuta/' + file, target_size=(100,100), color_mode='grayscale')
  test_image = image.img_to_array(test_image)
  test_image = np.expand_dims(test_image,axis=0)

  model = Sequential()
  model = keras.models.load_model('Ryan92,5')

  y = model.predict_proba(test_image, verbose=1)
  print("Predicted=%s" % (y[0]))
  f = open('result.json', 'w')
  f.write(json.dumps(y[0]))
