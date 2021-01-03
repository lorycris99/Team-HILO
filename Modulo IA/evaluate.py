import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)

import warnings
warnings.filterwarnings('ignore')

from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.models import Sequential
from tensorflow import keras
from sklearn.metrics import confusion_matrix

my_data_dir = 'Data/'
test_path = my_data_dir+'test/'

image_shape = (100,100,1)
image_gen = ImageDataGenerator(rotation_range=20,
                               width_shift_range=0.10,
                               height_shift_range=0.10,
                               rescale=1/255,
                               shear_range=0.1,
                               zoom_range=0.1,
                               horizontal_flip=True, 
                               fill_mode='nearest')

model = Sequential()

model = keras.models.load_model('Ryan92,5')

test_image_gen = image_gen.flow_from_directory(test_path,
                                               target_size=(100,100),
                                               color_mode='grayscale',
                                               batch_size=64,
                                               class_mode='categorical',shuffle=False)


model.evaluate(test_image_gen)
print(test_image_gen.class_indices)

# Inseriemnto delle predizioni in un array di numpy
predictions = np.argmax(model.predict(test_image_gen), axis = -1)

# Stampa del confusion matrix
print(confusion_matrix(test_image_gen.classes,predictions))