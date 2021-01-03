<h1>RyanAI</h1>
In questa cartella compressa sono presenti (quasi) tutti i file necessari per il funzionamento del modulo di IA:

<ul>
  <li>oracle.py: realizza effettivamente le predizioni data una radiografia in input</li>
  <li>Ryan92,5 è un file binario che contiene la rete neurale già addestrata (con un'accuratezza del 92,5%)</li>
  <li>evaluate.py: effettua il testing della rete addestrata</li>
  <li>train.py: realizza l'allenamento della rete.</li>
</ul>
N.B. - nella presente consegna non è stato possibile includere il dataset in quanto di dimensioni troppo elevate: per questo motivo non è possibile eseguire ulteriori sessioni di training o di test a partire da questa consegna. 

<h2>Risultati dei test sulla rete addestrata</h2>
<table class="tg">
<thead>
  <tr>
    <th class="tg-0pky"></th>
    <th class="tg-0pky"><span style="font-weight:bold">Covid</span></th>
    <th class="tg-0pky"><span style="font-weight:bold">Non Covid</span></th>
    <th class="tg-0pky"><span style="font-weight:bold">Polmonite</span></th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-0pky"><span style="font-weight:bold">Covid</span></td>
    <td class="tg-0pky">100</td>
    <td class="tg-0pky">4</td>
    <td class="tg-0pky">12</td>
  </tr>
  <tr>
    <td class="tg-0pky"><span style="font-weight:bold">Non Covid</span></td>
    <td class="tg-0pky">3</td>
    <td class="tg-0pky">280</td>
    <td class="tg-0pky">34</td>
  </tr>
  <tr>
    <td class="tg-0pky"><span style="font-weight:bold">Polmonite</span></td>
    <td class="tg-0pky">5</td>
    <td class="tg-0pky">60</td>
    <td class="tg-0pky">790</td>
  </tr>
</tbody>
</table>

<h2>Esecuzione dell'agente</h2>
L'effettiva classificazione delle radiografie si effettua inserendo queste ultime nella cartella valuta/ e lanciando lo script "oracle.py" con il comando <code>$ python3 oracle.py</code>. (Nella cartella valuta/ sono presenti tre campioni appartenenti alle tre categorie possibili prese in esame (Covid, No Covid e Polmonite "standard" con assenza di Covid) per dimostrare il corretto funzionamento dell'agente)

Team Hilo "ristretto" :)
<li>Hermann Senatore - matricola 0512105743</li>
<li>Ivan Carmine Adamo - matricola 0512105755</li>
<li>Lorenzo Criscuolo - matricola 0512105737</li>

