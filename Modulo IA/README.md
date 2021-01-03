<h1>RyanAI</h1>
In questa cartella compressa sono presenti (quasi) tutti i file necessari per il funzionamento del modulo di IA:
	oracle.py: realizza effettivamente le predizioni data una radiografia in input
	Ryan92,5 è un file binario che contiene la rete neurale già addestrata (con un'accuratezza del 92,5%)
	evaluate.py: effettua il testing della rete addestrata
	train.py: realizza l'allenamento della rete.
N.B. - nella presente consegna non è stato possibile includere il dataset in quanto di dimensioni troppo elevate: per questo motivo non è possibile eseguire ulteriori sessioni di training o di test a partire da questa consegna. 


<h2>Esecuzione dell'agente</h2>
L'effettiva classificazione delle radiografie si effettua inserendo queste ultime nella cartella valuta/ e lanciando lo script "oracle.py" con il comando <code>$ python3 oracle.py</code>. (Nella cartella valuta/ sono presenti tre campioni appartenenti alle tre categorie possibili prese in esame (Covid, No Covid e Polmonite "standard" con assenza di Covid) per dimostrare il corretto funzionamento dell'agente)

Team Hilo "ristretto" :)
- Hermann Senatore - matricola 0512105743
- Ivan Carmine Adamo - matricola 0512105755
- Lorenzo Criscuolo - matricola 0512105737

