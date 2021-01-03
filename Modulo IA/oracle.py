import numpy as np # linear algebra
import sys
import numpy as np 
import warnings
warnings.filterwarnings('ignore')
from tensorflow import keras
from tensorflow.keras.preprocessing import image
from tensorflow.keras.models import Sequential

test_image = image.load_img('valuta/' + sys.argv[1], target_size=(100,100), color_mode='grayscale') #l'argomento da riga di comando rappresenta la radiografia da analizzare
test_image = image.img_to_array(test_image)
test_image = np.expand_dims(test_image,axis=0)

model = Sequential()
model = keras.models.load_model('Ryan92,5')

y = model.predict_proba(test_image, verbose=1)
print("Predicted=%s" % (y[0]))
