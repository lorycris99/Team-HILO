In questa cartella compressa sono presenti tutti i file necessari per il funzionamento del modulo di IA:

- oracle.py: realizza effettivamente le predizioni data una radiografia in input
- Ryan92,5 è un file bianrio che contiene la rete neurale già addestrata (con un'accuratezza del 92,5%)
- evaluate.py: effettua il testing della rete addestrata
- train.py: realizza l'allenamento della rete.

N.B. - nella presente consegna non è stato possibile includere il dataset in quanto di dimensioni troppo elevate: per questo motivo non è possibile eseguire ulteriori sessioni di training o di test a partire da questa consegna. 
La classificazione di una radiografia si effettua inserendo quest'ultima nella cartella valuta/ e lanciando lo script "oracle.py" (Nella cartella valuta sono presenti tre campioni appartenenti alle tre categorie possibili prese in esame (Covid, No Covid e Polmonite "standard" senza presenza di Covid) per dimostrarne il corretto funzionamento.)

Team Hilo "ristretto" :)
- Hermann Senatore - matricola 0512105743
- Ivan Carmine Adamo - matricola 0512105755
- Lorenzo Criscuolo - matricola 0512105737
