import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)

import warnings
warnings.filterwarnings('ignore')

from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Activation, Dropout, Flatten, Dense, Conv2D, MaxPooling2D
from tensorflow.keras.callbacks import EarlyStopping

from sklearn.metrics import confusion_matrix

# Ricerca directory
my_data_dir = 'Data/'
test_path = my_data_dir+'test/'
train_path = my_data_dir+'train/'

# Settaggio Pre-processing immagini, 
# image_shape = 100 pixel x 100pixel, 1 canale quindi in bianco e nero
"""
imageImageDataGenerator(rotation_range=20, 
                        width_shift_range=0.10, frazione della larghezza totale
                        height_shift_range=0.10, frazione dell'altezza totale
                        rescale=1/255, dopo tutte le trasformazioni i dati vengono moltiplicati per questo numero
                        shear_range=0.1, Angolo di taglio in senso antiorario in gradi
                        zoom_range=0.1, range per lo zoom random
                        horizontal_flip=True, randomicamente inverte le foto sull'asse orizzontale
                        fill_mode='nearest') I punti al di fuori dei confini dell'input vengono riempiti secondo la modalità data: 'nearest': aaaaaaaa|abcd|dddddddd
"""
image_shape = (100,100,1)
image_gen = ImageDataGenerator(rotation_range=20,
                               width_shift_range=0.10,
                               height_shift_range=0.10,
                               rescale=1/255,
                               shear_range=0.1,
                               zoom_range=0.1,
                               horizontal_flip=True, 
                               fill_mode='nearest')


# Settaggio del modello sequenziale appropriato per una semplice pila di livelli in cui ogni livello ha esattamente un tensore di input e un tensore di output.

# conv2d = La convoluzione 2D è un'operazione abbastanza semplice in fondo: si inizia con un kernel, che è semplicemente una piccola matrice di pesi. 
# Questo kernel "scorre" sui dati di input 2D, eseguendo una moltiplicazione incentrata sull'elemento con la parte dell'input su cui si trova attualmente, 
# e quindi sommando i risultati in un singolo pixel di output. Più informazioni: https://towardsdatascience.com/intuitively-understanding-convolutions-for-deep-learning-1f6f42faee1
# filters = dimensionalità dello spazio di output
# kernel size = dimensione del kernel
# activation = applica la funzione di attivazione rectified linear unit in questo caso

# maxpooling2d = campiona la rappresentazione dell'input prendendo il valore massimo all'interno della finestra definita da pool_size

# Flatten = appiattisce l'output senza modificare la batch size

# Dense = densely-connected NN layer di n unità con funzione di attivazione rectified linear unit o softmax (converte un reale vettore in un vettore di probabilità di categoria)

# Dropout = randomicamente setta unità di input a 0, con una frequenza settata da input, a ogni passo durante l'addestramento, questo previene l'overfitting. 
# Inputs non settati a 0 sono scalati di 1/(1 - rate) in modo da non variare la media di ogni input.

# model.compile (loss = funzione obiettivo, optimizer = Ottimizzatore che implementa l'algoritmo Adam, metrics = lista delle metriche da considerare durante l'addestramento 
model = Sequential()

model.add(Conv2D(filters=128, kernel_size=(3,3),input_shape=image_shape, activation='relu',))
model.add(MaxPooling2D(pool_size=(2, 2)))

model.add(Conv2D(filters=64, kernel_size=(3,3),input_shape=image_shape, activation='relu',))
model.add(MaxPooling2D(pool_size=(2, 2)))

model.add(Conv2D(filters=32, kernel_size=(3,3),input_shape=image_shape, activation='relu',))
model.add(MaxPooling2D(pool_size=(2, 2)))


model.add(Flatten())


model.add(Dense(64, activation = 'relu'))
model.add(Dropout(0.5))

model.add(Dense(3, activation = 'softmax'))
model.compile(loss='categorical_crossentropy',
              optimizer='adam',
              metrics=['accuracy'])
model.summary()

# Settaggio stop condition
# monitor = unità di misura da controllare
# patience = numero di epoche senza miglioramenti dopo la quale fermare il training
# verbose = verbosity mode (da documentazione ufficiale)
early_stop = EarlyStopping(monitor='val_loss',patience=3, verbose = 1)
batch_size = 64


#Conversione immagini training
train_image_gen = image_gen.flow_from_directory(train_path,
                                               target_size=(100,100),
                                                color_mode='grayscale',
                                               batch_size=batch_size,
                                               class_mode='categorical')


#Conversione immagini test
test_image_gen = image_gen.flow_from_directory(test_path,
                                               target_size=(100,100),
                                               color_mode='grayscale',
                                               batch_size=batch_size,
                                               class_mode='categorical',shuffle=False)

#Addestramento agente con validazione sui dati di test
results = model.fit(train_image_gen,epochs=30,
                              validation_data=test_image_gen,
                             callbacks=[early_stop])

#Salviamo il soldato Ryan
model.save('Ryan')

#Stampa dati addestramento
loss_df = pd.DataFrame(model.history.history)
print(loss_df)

#Inserisco predizioni in un array
predictions = np.argmax(model.predict(test_image_gen), axis = -1)

#Stampo confusion matrix
print(confusion_matrix(test_image_gen.classes,predictions))
