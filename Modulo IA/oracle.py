import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)
import sys

import os
for dirname, _, filenames in os.walk('/kaggle/input'):
    for filename in filenames:
        print(os.path.join(dirname, filename))

import pandas as pd
import numpy as np 
import seaborn as sns
import matplotlib.pyplot as plt 
import warnings
warnings.filterwarnings('ignore')

from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Activation, Dropout, Flatten, Dense, Conv2D, MaxPooling2D
from tensorflow.keras.callbacks import EarlyStopping

from tensorflow import keras

from sklearn.metrics import classification_report, confusion_matrix

from tensorflow.keras.preprocessing import image

test_image = image.load_img('valuta/' + sys.argv[0], target_size=(100,100), color_mode='grayscale')
test_image = image.img_to_array(test_image)
test_image = np.expand_dims(test_image,axis=0)

model = Sequential()

model = keras.models.load_model('Ryan92,5')

y = model.predict_proba(test_image, verbose=1)
print("Predicted=%s" % (y[0]))
