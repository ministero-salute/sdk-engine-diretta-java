﻿
# **1 Introduzione**

## ***1.1 Obiettivi del documento***

Il Ministero della Salute (MdS) metterà a disposizione degli Enti, da cui riceve dati, applicazioni SDK specifiche per flusso logico e tecnologie applicative (Java, PHP e C#) per verifica preventiva (in casa Ente) della qualità del dato prodotto.

![](img/Aspose.Words.170a4eb6-cbfd-45c0-bf6a-10cff7e4b2ac.002.png)

Nel presente documento sono fornite la struttura e la sintassi dei tracciati previsti dalla soluzione SDK per avviare il proprio processo elaborativo, nonché i relativi schemi xsd di convalida e i controlli di merito sulla qualità, completezza e coerenza dei dati.

Gli obiettivi del documento sono:

- fornire una descrizione funzionale chiara e consistente dei tracciati di input a SDK;
- fornire le regole funzionali per la verifica di qualità, completezza e coerenza dei dati;

In generale, la soluzione SDK è costituita da 2 diversi moduli applicativi (Access Layer e Validation Engine) per abilitare

- l’interoperabilità con il contesto tecnologico dell’Ente in cui la soluzione sarà installata;
- la validazione del dato ed il suo successivo invio verso il MdS.

La figura che segue descrive la soluzione funzionale ed i relativi benefici attesi.

![](img/Aspose.Words.170a4eb6-cbfd-45c0-bf6a-10cff7e4b2ac.003.png)

## ***1.2 Acronimi***

Nella tabella riportata di seguito sono elencati tutti gli acronimi e le definizioni adottate nel presente documento.


|**#**|**Acronimo / Riferimento**|**Definizione**|
| - | - | - |
|1|NSIS|Nuovo Sistema Informativo Sanitario|
|2|SDK|Software Development Kit|
|3|DIR|Anagrafe Diretta Ospedaliera|
|4|SSN|Sistema Sanitario Nazionale|
|5|CI|Codice Identificativo|
|6|AIC|Autorizzazione alla Immissione in Commercio della confezione rilasciata dall’Agenzia Italiana del Farmaco|

# **2 Architettura SDK**

## ***2.1 Architettura funzionale***

Di seguito una rappresentazione architetturale del processo di gestione e trasferimento dei flussi dall’ente verso l’area MdS attraverso l’utilizzo dell’applicativo SDK e il corrispondente diagramma di sequenza.

![](img/Aspose.Words.170a4eb6-cbfd-45c0-bf6a-10cff7e4b2ac.004.jpeg)

1. L’utente dell’ente caricherà in una apposita directory (es. /sdk/input/) il flusso sorgente.  L’utente avvierà l’SDK passando in input una serie di parametri descritti in dettaglio al paragrafo 3.1
1. La compenente Access Layer estrae dalla chiamata dell’ente i parametri utilizzati per lanciare l’SDK,  genera un identificativo ID\_RUN, e un file chiamato “{ID\_RUN}.json” in cui memorizza le informazioni dell’esecuzione.
1. I record del flusso verranno sottoposti alle logiche di validazione e controllo definite nel Validation Engine. Nel processare il dato, il Validation Engine acquisirà da MdS eventuali anagrafiche di validazione del dato stesso.
1. Generazione del file degli scarti contenente tutti i record in scarto con evidenza degli errori riscontrati. I file di scarto saranno memorizzati in cartelle ad hoc (es. /sdk/esiti).
1. Tutti i record che passeranno i controlli verranno inseriti in un file xml copiato in apposita cartella (es /sdk/xml\_output), il quale verrà eventualmente trasferito a MdS utilizzando la procedura “invioFlussi” esposta da GAF WS (tramite PDI). A fronte di un’acquisizione, il MdS fornirà a SDK un identificativo (ID\_UPLOAD) che sarà usato da SDK sia per fini di logging che di recupero del File Unico degli Scarti.
1. A conclusione del processo di verifica dei flussi, il Validation Engine eseguirà le seguenti azioni:

 a. Aggiornamento file contentente il riepilogo dell’esito dell’elaborazione del Validation Engine e del ritorno dell’esito da parte di MdS. I file contenente l’esito dell’elaborazione saranno memorizzati in cartelle ad hoc (es. /sdk/run).

 b. Consolidamento del file di log applicativo dell’elaborazione dell’SDK in cui sono disponibili una serie di informazioni tecniche (Es. StackTrace di eventuali errori).

 c. Copia del file generato al punto 5, se correttamente inviato al MdS, in apposita cartella (es. /sdk/sent).

Ad ogni step del precedente elenco e a partire dal punto 2, l’SDK aggiornerà di volta in volta il file contenente l’esito dell’elaborazione.

**Nota: l’SDK elaborerà un solo file di input per esecuzione.**

In generale, le classi di controllo previste su Validation Engine sono:

- Controlli FORMALI (es. correttezza dei formati e struttura record)
- Controlli SINTATTICI (es. check correttezza del Codice Fiscale)
- Controlli di OBBLIGATORIETÀ DEL DATO (es. Codice Prestazione su flusso…)
- Controlli STRUTTURE FILE (es. header/footer ove applicabile)
- Controlli di COERENZA CROSS RECORD
- Controlli di corrispondenza dei dati trasmessi con le anagrafiche di riferimento
- Controlli di esistenza di chiavi duplicate nel file trasmesso rispetto alle chiavi logiche individuate per ogni tracciato.

Si sottolinea che la soluzione SDK non implementa controlli che prevedono la congruità del dato input con la base date storica (es: non viene verificato se, per un nuovo inserimento, la chiave del record non sia già presente sulla struttura dati MdS).

## ***2.2 Architettura di integrazione***

La figura sottostante mostra l’architettura di integrazione della soluzione SDK con il MdS. Si evidenzia in particolare che:

- Tutti i dati scambiati fra SDK e MdS saranno veicolati tramite Porta di Interoperabilità (PDI);
- Il MdS esporrà servizi (API) per il download di dati anagrafici;
- SDK provvederà ad inviare vs MdS l’output (record validati) delle proprie elaborazioni. A fronte di tale invio, il MdS provvederà a generare un identificativo di avvenuta acquisizione del dato (ID\_UPLOAD) che SDK memorizzerà a fini di logging.


![](img/Aspose.Words.170a4eb6-cbfd-45c0-bf6a-10cff7e4b2ac.006.png)


# **3 Funzionamento della soluzione SDK**

In questa sezione sono descritte le specifiche di funzionamento del flusso informativo per le **Prestazioni farmaceutiche in distribuzione diretta**.

Il flusso informativo raccoglie le informazioni relative al singolo evento distributivo effettuato per consentire diverse e articolate forme di aggregazione e di analisi dei dati.

Ogni esecuzione del SDK sarà associata ad un progressivo (ID\_RUN) a fini di logging.


## ***3.1 Input SDK***

In fase di caricamento del file verrano impostati i seguenti parametri che andranno in input al SDK in fase di processamento del file:


|**NOME PARAMETRO**|**DESCRIZIONE**|**LUNGHEZZA**|**DOMINIO VALORI**|
| :- | :- | :- | :- |
|ID CLIENT|Identificativo univoco della transazione che fa richiesta all'SDK|100|Non definito|
|NOME FILE INPUT|Nome del file per il quale si richiede il processamento lato SDK|256|Non definito|
|ANNO RIFERIMENTO|Stringa numerica rappresentante l’anno di riferimento per cui si intende inviare la fornitura|4|Anno (Es. 2022)|
|PERIODO RIFERIMENTO|Stringa alfanumerica rappresentante il periodo per il quale si intende inviare la fornitura; |3|**13** (rappresenta un alias per il quale MDS usa come data di competenza l’anno e il mese di riferimento del record piuttosto che il parametro periodo di riferimento passato in input alla procedura InvioFlussi)|
|TIPO TRASMISSIONE |Indica se la trassmissione dei dati verso MDS avverrà il modalità full (F) o record per record (R). Per questo flusso la valorizzazione del parametro sarà impostata di default a F|1|F/R|
|FINALITA’ ELABORAZIONE|Indica se i flussi in output prodotti dal SDK verranno inviati verso MDS (Produzione) oppure se rimarranno all’interno del SDK e il processamento vale solo come test del flusso (Test)|1|Produzione/Test|
|CODICE REGIONE|<p>Individua la Regione a cui afferisce la struttura. Il codice da utilizzare è quello a tre caratteri definito con DM 17 settembre 1986, pubblicato nella Gazzetta Ufficiale n.240 del 15 ottobre 1986, e successive modifiche, utilizzato anche nei modelli per le rilevazioni delle attività gestionali ed economiche delle Aziende unità sanitarie locali.</p><p></p>|3|Es. 010|


## ***3.2 Tracciato input a SDK***


Il flusso di input avrà formato **csv** posizionale e una naming convention libera a discrezione dell’utente che carica il flusso senza alcun vincolo di nomenclatura specifica (es nome_file.csv).
Il separatore per il file csv sarà il carattere tra doppi apici: **“~“**.

Nella tabella successiva sono indicati i dettagli dei campi di business del tracciato di input atteso da SDK in cui è presente la colonna **Posizione nel file** la quale rappresenta l’ordinamento delle colonne del tracciato di input da caricare all’SDK.

Di seguito la tabella in cui è riportata la specifica del tracciato di input per il flusso in oggetto:


|**Posizione nel File**|**Nome campo**|**Key**|**Descrizione**|**Tipo** |**Obbligatorietà XSD**|**Informazioni di Dominio**|**Lunghezza campo**|**Tracciato di Output**|**XPATH Tracciato output**|
| :-: | :- | :- | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|0|Regione Erogante|KEY|Codice regione erogante|AN|OBB|Valori di riferimento riportati nell’Allegato A - Regioni|3|Distribuzione|/dataroot/REGIONE/COD\_REG|
|1|Anno di riferimento|KEY|Indica l’anno di erogazione dei medicinali.|AN|OBB|Stringa|4|Distribuzione|/dataroot/REGIONE/PERIODO/ANNO|
|2|Mese di riferimento|KEY|Indica il mese di erogazione dei medicinali.|AN|OBB|Stringa|2|Distribuzione|/dataroot/REGIONE/PERIODO/MESE|
|3|Codice Azienda Sanitaria Erogante|KEY|Codice dell’ azienda sanitaria erogante,costituito dall’unione tra codice Regione e codice dell’ azienda sanitaria.|AN|OBB|Per le AO, IRCCS e AOU indicare il codice del modello HSP11, per le altre indicare il codice del modello FLS11 (ASL, ESTAV).<br>Per il solo canale di erogazione “R – Rimborso Extra Tariffa” nel caso di rimborso effettuato direttamente dalla regione è possibile utilizzare il codice regione seguito da tre zeri|6|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/COD\_ASL|
|4|Tipo Erogatore|KEY|Codice tipo erogatore (struttura di ricovero, farmacia, ecc.). I tipi erogatori ammessi dipendono dal canale di erogazione.|N|OBB|Valori di riferimento nell’Allegato B - Tipo Erogatore|2|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/TIPO\_ER|
|5|Tipo Struttura Erogante|KEY|Indica la tipologia di struttura erogante nel caso di Tipo erogatore 02| |OBB|Valori di riferimento nell’Allegato G - Tipo Struttura Erogante|2|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/TIPO\_STR|
|6|Codice Struttura Erogante|KEY|Codice della struttura erogante<br>o dispensatrice| |OBB|I valori ammessi sono: HSP11, HSP11-bis, STS11, RIA11, FLS11|8|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ID\_ER|
|7|Identificativo assistito| |Codice anonimo dell’assistito (CUNI)|AN|FAC|Campo cifrato|88|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/ID\_ASS|
|8|Validità del codice Identificativo dell'assistito| |Informazione relativa alla validità del codice identificativo dell'assistito recuperata a seguito della chiamata al servizio di validazione esposto dal sistema TS del MEF|N|FAC|Valori ammessi: 0, 1|1|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/VLD\_ID\_ASS|
|9|Tipologia del codice Identificativo dell'assistito| |Informazione relativa alla tipologia del codice identificativo dell'assistito recuperata a seguito della chiamata al servizio di validazione esposto dal sistema TS del MEF|N|FAC|Valori ammessi: 0, 1, 2, 3, 4, 97, 98, 99|2|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/TIP\_ID\_ASS|
|10|Data di Nascita| |Data di nascita dell’assistito a cui è stata erogata la prestazione|D|FAC|Formato: AAAA-MM-GGA partire dai dati di competenzaOTTOBRE 2012, il mese e il giorno dovranno sempre assumere il valore “01” (es.: 1996-01-01), ad eccezione degli assistiti anonimi, per cui è già prevista la data “9999-12-31”|10|Anagrafica|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/DAT\_NASC|
|11|Genere| |Sesso dell’assistito a cui è stata erogata la prestazione. |N|FAC|Valori ammessi: 1 = maschio ; 2 = femmina ;  9= non noto/non risulta|1|Anagrafica|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/SESSO|
|12|ASL Residenza| |Codice della ASL di residenza o della ASL che ha in carico l’assistito costituito dall’unione tra codice Regione e codice ASL.| |FAC|Valori ammessi FLS11| |Anagrafica, Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/COD\_ASL\_ASS|
|13|Cittadinanza| |Cittadinanza dell’assistito a cui è stata erogata la prestazione|N|FAC|Valori ammessi: 1, 2, 9|1|Anagrafica, Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/CITT|
|14|Stato estero di residenza| |Codice dello stato estero di residenza dell’assistito a cui è stata erogata la prestazione|AN|FAC|Valori di riferimento nell’Allegato F - Codice Paese ISO (da 2 e da 3)|2|Anagrafica, Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/STAT\_EST|
|15|Codice Istituzione Competente| |Codice di identificazione assegnato a livello nazionale alla istituzione di assicurazione o di residenza competente ai sensi degli allegati 2 e 3 e del regolamento 574/72. Necessario per attribuire la spesa all’istituzione estera| |FAC| |28|Anagrafica, Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/COD_IST_COMP|
|16|Tipo operazione| |Campo tecnico utilizzato per distinguere la trasmissione di informazioni nuove, modificate o eventualmente annullate|A|OBB|Valori ammessi: I, i, C, c, V, v|1|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/TIPO\_OP|
|17|Canale di erogazione| |Indica il canale di erogazione della distribuzione diretta dei medicinali:|AN|OBB|Valori ammessi: D, OP, R|1|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/TIPO\_CANALE|
|18|Codice esenzione| |Per alcune tipologie di esenzione, codice di esenzione delle condizioni di esenzione dalla partecipazione alla spesa|AN|FAC|Valori di riferimento nell’Allegato H - TRASMISSIONE DEI DATI RELATIVI ALLE CODIFICHE DELLE ESENZIONI|6|Anagrafica, Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/COD_ESEN|
|19|Tipo erogazione| |Indica il tipo di erogazione diretta|N|OBB|Valori di riferimento nell’Allegato C - Tipologia di erogazione|2|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/TIPO\_EROG|
|20|Tipo di esenzione| |Codice indicante il tipo di esenzione dell’assistito|N|FAC|Valori di riferimento nell’Allegato E - Tipologia di esenzione|1|Anagrafica, Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/TIPO\_ESEN|
|21|Tipo Contatto|KEY|Indica la tipologia di contatto utile al controllo dell’Id Contatto.|N|OBB|Valori ammessi: 1, 2|1|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/TIPO\_CONT|
|22|Id Contatto|KEY|In caso di tipo contatto ricetta SSN, contiene il numero di ricetta. Negli altri casi, il campo indica il numero progressivo dell'episodio di erogazione/contatto, univoco per anno di riferimento e Regione/AS| |OBB|Valori ammessi: 0, SSN, Codice Regionale|20|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/ID\_CONT|
|23|Data Erogazione|KEY|Data di erogazione dei medicinali|D|OBB|Formato: AAAA-MM-GG|10|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/DAT\_EROG|
|24|Importo quota fissa assistito| |Eventuale quota fissa pagata dal cittadino per la singola prestazione. Nel caso di cittadino esente, l'importo sarà a 0|AN|FAC|Range numerici in stringhe da 0.00 a 999.99|6|Distribuzione|[/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/QUOTA_FISSA_ASS](mailto:/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/@quota_fissa_ass)|
|25|Importo quota percentuale a carico assistito| |Eventuale quota fissa pagata dal cittadino per la singola prestazione. Nel caso di cittadino esente, l'importo sarà a 0|AN|FAC|Range numerici in stringhe da 0.00 a 999.99|6|Anagrafica, Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/QUOTA\_PERC\_ASS|
|26|Data Prescrizione| |Data di prescrizione|D|FAC|Formato: AAAA-MM-GG|10|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/DAT\_PRES|
|27|Costo del servizio per ricetta| |Costo totale del servizio per la prescrizione.|AN|OBB|Range numerici in stringhe da 0.00 a 999.99|9|Anagrafica, Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/COSTO\_SRV\_RIC|
|28|Codice Prescrittore| |Indica il codice utilizzato in ambito regionale per l’individuazione del prescrittore.|AN|FAC| |16|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/PRESCRITTORE/COD\_PR|
|29|Tipo Prescrittore| |Indica il ruolo del prescrittore|A|FAC|Valori di riferimento nell’Allegato D - Tipologia prescrittore|1|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/PRESCRITTORE/TIPO\_PR|
|30|Tipo medicinale|KEY|Codice che indica la tipologia di medicinale|N|OBB|Valori ammessi: 1, 2, 3, 4, 5, 6|1|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/FARMACO/TIPO\_F|
|31|Codice medicinale|KEY|Codice che identifica il medicinale|AN|OBB|Valori ammessi: AIC, V03AN01, V03AN, “V03AN02”, “V03AN03”, “V03AN04” , “N01AX13”, ”V08DA05”,A06AX02, V03AN05,R07AX01 oppure valori dalle tabelle “DIR\_OSP\_004 Anagrafi medicinali Esteri” e/o “DIR\_OSP\_005 Anagrafe formule magistrali e officinali”|9|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/FARMACO/COD\_F|
|32|Quantità| |Numero di pezzi, numero di litri per l’ossigeno e gli altri gas medicinali non dotati di AIC (al netto dei resi)|AN|OBB|Range numerici in stringhe da 0.00 a 999999999999.99|15|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/FARMACO/QTA|
|33|Fattore di conversione| |Se la quantità è espressa in unità posologiche, il fattore di conversione indica il numero di unità posologiche della confezione|N|OBB|Range numerici ammessi da 1 a 999999|6|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/FARMACO/FATT\_CONV|
|34|Targatura|KEY|Numerazione progressiva del bollino della singola confezione inclusiva del codice di controllo|AN|OBB|Codice Numerico<br>(D.M. 2 agosto 2001<br>“Numerazione progressiva dei<br>bollini apposti sulle confezioni<br>dei medicinali erogabili dal<br>Servizio sanitario nazionale”)<br>Nel caso in cui il dato non sia<br>disponibile inserire il valore<br>“0”.<br>Va indicato anche il codice di<br>controllo (check digit).<br>Il codice di controllo può essere<br>impostato ad “A” se la lettura<br>automatica non è andata a buon<br>fine oppure ad “X” se non è<br>ancora stata prevista la gestione<br>dello stesso.|10|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/TARGATURA|
|35|Costo d’acquisto| |Indica il costo sostenuto per l’acquisto dei medicinali, comprensivo di IVA.|AN|OBB|Range numerici in stringhe da 0.00 a 99999999.99999|14|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/FARMACO/COSTO\_ACQ|
|36|Costo del servizio| |Costo sostenuto per il servizio di distribuzione diretta, riferito al medicinale prescritto|AN|OBB|Range numerici in stringhe da 0.00 a 9999.99|7|Distribuzione|/dataroot/REGIONE/PERIODO/ASL/EROGATORE/ASSISTITO/OPERAZIONE/PRESCRIZIONE/FARMACO/COSTO\_SRV|


## ***3.3 Controlli di validazione del dato (business rules)***

Di seguito sono indicati i controlli da configurare sulla componente di Validation Engine e rispettivi error code associati riscontrabili sui dati di input per il flusso **DIR**.

Gli errori sono solo di tipo scarti (mancato invio del record).

Al verificarsi anche di un solo errore di scarto, tra quelli descritti, il record oggetto di controllo sarà inserito tra i record scartati.

Business Rule non implementabili lato SDK:

- Storiche (Business Rule che effettuano controlli su dati già acquisiti/consolidati che non facciano parte del dato anagrafico)
- Transazionali (Business Rule che effettuano controlli su record, i quali rappresentano transazioni su cui andrebbe garantito l’ACID (Atomicità-Consistenza-Isolamento-Durabilità))
- Controllo d’integrità (cross flusso) (Business Rule che effettuano controlli sui record utilizzando informazioni estratte da record di altri flussi)

Di seguito le BR per il flusso in oggetto:


|**CAMPO**|**CODICE ERRORE**|**DESCRIZIONE ERRORE**|**DESCRIZIONE MDS**|**DESCRIZIONE ALGORITMO**|**TABELLA ANAGRAFICA**|**CAMPI DI COERENZA**|**SCARTI/ANOMALIE**|**TIPOLOGIA BR**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|Codice Regione|B01|Non appartenenza al dominio di riferimento|Il parametro Codice Regione passato in input all'SDK non coincide con il campo RegCode e presente nel dominio|Il parametro Codice Regione passato in input all'SDK non coincide con il campo **cod\_reg** del tracciato di input. Inoltre il valore del campo **cod\_reg** del tracciato di input deve essere presente nella colonna **COD\_REG** della query Anagrafica Regioni |Regioni|Non Definito|Scarti|Anagrafica|
|Anno di riferimento; Mese di riferimento|B02|Errore periodo di riferimento|Il periodo inviato è fuori dalla finestra temporale d’invio consentita. Questo errore viene restituito <br>quando il periodo cui si <br>riferiscono i dati è già stato <br>consolidato.|il periodo (**anno**-**mese**) di riferimento nel tracciato non deve essere inferiore al [periodo di esecuzione **anno**/**mese** - (operazione) 2 mesi]|Non Definito|Non Definito|Scarti|Basic|
|Codice Farmaco|B11|Errore codice medicinale|Il codice medicinale è obbligatorio per il tipo medicinale indicato. Questo errore viene restituito <br>quando, valorizzando come tipo <br>farmaco 1, per il record indicato, <br>si omette il codice farmaco.|Se il valore del campo **tipo\_f** del tracciato di input è uguale a 1, 4,5 **or** 6 allora il campo **cod\_f** del tracciato di input** è obbligatorio (presente e diverso da blanks)|Non Definito|Tipo Farmaco|Scarti|Basic|
|Identificativo assistito; Tipologia del <br>codice Identificativo dell'assistito; Validità del <br>codice Identificativo dell'assistito|B16|Errore coerenza dati assistito|I campi relativi al CUNI (id\_ass, tip\_id\_ass e vld\_id\_ass) non sono valorizzati coerentemente. Questo errore viene restituito  quando almeno uno dei campi id\_ass, tip\_id\_ass e vld\_id\_ass è valorizzato mentre gli altri non <br>lo sono.|Se uno dei tre campi **id\_ass, tip\_id\_ass e vld\_id\_ass** del tracciato di input è valorizzato (presente e diverso da blanks) allora anche gli altri due devono essere valorizzati|Non Definito|Identificativo assistito; Tipologia del <br>codice Identificativo dell'assistito; Validità del <br>codice Identificativo dell'assistito|Scarti|Basic|
|Tipologia Id Assistito; Validità Id Assistito|B17|Errore valorizzazione Validità Assistito|Per i casi di Anonimato è necessario valorizzare i <br>campi relativi all’Id Assistito (id\_ass, <br>tip\_id\_ass, vld\_id\_ass) <br>secondo le specifiche. Questo errore viene restituito  quando il campi id\_ass è relativo <br>al CUNI anonimo e i campi  vld\_id\_ass e tip\_id\_ass non sono valorizzati correttamente secondo le specifiche.|se il valore del campo **id\_ass** del tracciato di input è uguale alla stringa **TGIN+o+fB0m+hf4iyd2fYF6kjRqEpa6+TPiiNfAvE0M=9wmFXLxmSeuWHV0HIMjYtoyCAOT+<br>Dms+s2mz2P3x90Y=** allora il campo **tip\_id\_ass** del tracciato di input deve essere valorizzato con 98 **and** il campo **vld\_id\_ass** del tracciato di input deve essere valorizzato con 0|Non Definito|Identificativo assistito; |Scarti|Basic|
|Codice Tipo Erogatore|D21|Errore tipo erogatore|Il codice tipo erogatore non è presente in anagrafica. Questo errore viene restituito <br>quando, il codice tipo erogatore <br>non è presente in anagrafica.|se il campo **tipo\_er** del tracciato di input è valorizzato (presente e diverso da blanks) allora può assumere solo uno dei seguenti valori: 01, 02, 03, 04, 05 **or** 06. <br>(vedi definizione codice 2 sheet BR - Definizioni)|Non Definito|Non Definito|Scarti|Basic|
|Data Prescrizione|B23|Errore data prescrizione|La data prescrizione è maggiore della data erogazione. Questo errore viene restituito quando la data di prescrizione è maggiore della data di erogazione.|il valore del campo (data) **data\_pres** del tracciato di input deve essere minore o uguale al valore (data) del campo **data\_erog** del tracciato di input|Non Definito|Data Erogazione|Scarti|Basic|
|Stato estero di residenza; ASL Residenza|B28|Associazione Stato Estero - ASL assistito errata.|In base alla struttura erogante indicata, deve essere valorizzato o lo stato estero o l'ASL di residenza. Questo errore si presenta quando <br>all'interno del file inviato per il record indicato, per i tipi erogatori 05 o per tipo erogatore <br>02 e tipo struttura diversa da 04, non sono stati valorizzati né lo stato estero né l'ASL di residenza|Se il record non rispetta l'**anonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) e non rispetta l'**anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni) allora almeno uno dei due campi **cod\_asl\_ass** e **stat\_est** deve essere valorizzato (presente e diverso da blanks)|Non Definito|Tipo Erogatore; Tipo Struttura <br>Erogante; Codice Struttura Erogante; ASL Residenza; Stato Estero di Residenza|Scarti|Basic|
|Fattore di conversione; Tipo Medicinale|B31|Errore fattore di conversione|In base alla targatura inviata, il fattore di conversione deve essere pari a 1. Questo errore viene restituito quando, valorizzando la targatura, il fattore di conversione viene trasmesso con un valore diverso da 1.|Se il campo **tipo\_f** del tracciato di input  è in (4,5,6) allora il campo **fatt\_conv** del tracciato di input non può assumere valori diversi da 1|Non Definito|Non Definito|Scarti|Basic|
|Tipo Struttura Erogante|B36|Errore tipo struttura erogante|Non è ammessa la valorizzazione del tipo struttura erogante per tipo erogatore diverso da '02'. Questo errore viene restituito quando per un tipo erogatore diverso da 02, viene valorizzato <br>il tipo struttura erogante|Se il valore del campo **tipo\_er** del tracciato di input è diverso da 02 allora il campo **tipo\_str** del tracciato di input NON deve essere valorizzato (valore nullo)|Non Definito|Tipo Erogatore|Scarti|Basic|
|Tipo Contatto; Id Contatto|D16|Errore codice tipo contatto|Il codice tipo contatto e l'id contatto possono essere entrambi valorizzati oppure entrambi non valorizzati. Questo errore viene restituito <br>quando viene valorizzato uno dei <br>campi interessati e l'altro non <br>viene valorizzato.|se uno dei due campi **tipo\_cont** e **id\_cont** del tracciato di input è valorizzato (presente e diverso da blanks) allora anche l'altro lo deve essere . <br>(vedi definizione codice 2 sheet BR - Definizioni)|Non Definito|Tipo Contatto; Id Contatto|Scarti|Basic|
|Data di nascita|D15|Errore data di nascita dell'assistito|In base alla struttura erogante indicata, la data di nascita dell'assistito è obbligatoria.Questo errore viene restituito <br>quando per un tipo struttura <br>erogante 02 e tipo struttura 04 <br>oppure il tipo erogatore diverso <br>da 02 o diverso da 05, non venga <br>valorizzato la data di nascita <br>dell'assistito.|Se il record non rispetta l'**anonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) e non rispetta l'**anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni) allora il valore del campo **data\_nasc** è obbligatorio (presente e diverso da blanks)|Non Definito|Tipo Erogatore; Tipo Struttura <br>Erogante; Codice Struttura Erogante; ASL Residenza; Stato Estero di Residenza|Scarti|Basic|
|Id Contatto|D07|Errore codice contatto|In base alla struttura erogante indicata, l'id contatto è obbligatorio. Questo errore viene restituito <br>quando per un tipo erogante 02 e <br>tipo struttura 04, oppure il tipo <br>erogatore diverso da 02 o diverso <br>da 05, non venga valorizzato l'id <br>contatto|Se il record non rispetta l'**anonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) e non rispetta l'**anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni) allora il valore del campo **id\_cont** è obbligatorio e **non può essere composto da soli 0**|Non Definito|Tipo Erogatore; Tipo Struttura <br>Erogante; Codice Struttura Erogante; ASL Residenza; Stato Estero di Residenza|Scarti|Basic|
|Tipo Erogazione|D24|Errore codice tipo erogazione|Il codice tipo erogazione non è presente in anagrafica. Questo errore viene restituito <br>quando viene valorizzato un <br>codice erogazione diverso da <br>quelli presenti nelle specifiche <br>pubblicate sul portale del <br>ministero (Allegato C.)|se il campo **tipo\_erog** del tracciato di input è valorizzato (presente e diverso da blanks) allora può assumere solo uno dei seguenti valori: 01, 02, 03, 04, 05 **or** 06. <br>(vedi definizione codice 2 sheet BR - Definizioni)|Non Definito|Non Definito|Scarti|Basic|
|Codice Struttura Erogante|D40|Errore struttura erogante|Il codice della struttura erogante non è verificabile a causa dell'errore sul tipo erogatore.Questo errore viene restituito quando, Il codice della Struttura Erogante non è verificabile a causa della valorizzazione errata del campo Tipo Erogatore, per il quale non è stato trovato un valore ammesso|se tipo\_er = 02 allora tipo\_er # cod\_asl # id\_er  deve esistere in anagrafica;<br>se tipo\_er = 01, 03, 04, 05, 06 allora tipo\_er # id\_er  deve esistere in anagrafica;<br>Le anagrafiche devono essere filtrate sulla condizione:  <br>il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT\_INI\_VLD, DAT\_END\_VLD\_EFT della query. |Elenco completo delle strutture eroganti (cfr: D20 / D90)|Non Definito|Scarti|Anagrafica|
|Codice tipo Contatto|D26|Errore codice tipo contatto|Il codice tipo contatto non è presente in anagrafica. Questo errore viene restituito <br>quando è valorizzato un codice<br>tipo contatto diverso da quelli<br>presenti nelle specifiche <br>pubblicate sul portale del <br>ministero. |se il campo **tipo\_cont** del tracciato di input è valorizzato (presente e diverso da blanks) allora può assumere solo uno dei seguenti valori: 1, 2. <br>(vedi definizione codice 2 sheet BR - Definizioni)|Non Definito|Non Definito|Scarti|Basic|
|Tipo Prescrittore|D27|Errore codice tipo prescrittore|In base alla struttura erogante indicata, il codice tipo prescrittore è obbligatorio. Questo errore viene restituito <br>quando, per un tipo erogatore<br>diverso da 02 o diverso da 05 <br>oppure per un tipo erogatore 02 e <br>tipo struttura 04, non venga <br>valorizzato il tipo prescrittore.|Se il record non rispetta l'**anonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) e non rispetta l'**anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni) allora il campo **tipo\_pr** è obbligatorio (presente e diverso da blanks)|Non Definito|Tipo Erogatore; Tipo Struttura <br>Erogante; Codice Struttura Erogante; ASL Residenza; Stato Estero di Residenza|Scarti|Basic|
|Data Erogazione|B20|Errore data di erogazione|La data di erogazione dei medicinali deve essere contenuta nell'arco annuale che precede il periodo di riferimento.Questo errore viene restituito quando la data di erogazione, <br>non rientra nella finestra temporale di un anno che precede il periodo di riferimento.|La data di erogazione (data\_erog) deve essere compresa nella finestra temporale definita dai seguenti estremi:<br><br>- primo giorno del mese del periodo di riferimento (anno/mese) - 12 mesi (Alias: A)<br>- ultimo giorno del mese del periodo di riferimento (anno/mese) (Alias: B)<br><br>Diremo che il record non va in scarto se e solo se: <br><br>**A <= Data Erogazione <= B**<br><br>**Esempio**:<br><br>Campi record Input:<br><br>Anno = 2022 <br>Mese = 05 <br><br>**Valorizzazione della relazione:**<br><br>2021-05-01 <= data\_erog <= 2022-05-31)|Non Definito|Non Definito|Scarti|Basic|
|Cittadinanza|D29|Errore cittadinanza dell'assistito|In base alla struttura erogante indicata, il codice relativo alla cittadinanza dell'assistito è obbligatorio. Questo errore viene restituito <br>quando, per un tipo erogatore <br>diverso da 02 oppure diverso da <br>05 o per un tipo erogatore 02 e <br>tipo struttura 04, non venga <br>valorizzato la cittadinanza del <br>cittadino.|Se il record non rispetta l'**anonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) e non rispetta l'**anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni) allora il campo **citt** è obbligatorio (presente e diverso da blanks)|Non Definito|Tipo Erogatore; Tipo Struttura <br>Erogante; Codice Struttura Erogante; ASL Residenza; Stato Estero di Residenza|Scarti|Basic|
|ASL Residenza|D30|Errore ASL di residenza dell'assistito|Il codice dell’ASL di residenza dell'assistito non è presente in anagrafica. Questo errore viene restituito <br>quando il codice ASL di <br>residenza dell'assistito, non è <br>presente in anagrafica.|se Il campo **cod\_asl\_ass** del tracciato di input è valorizzato (presente e diverso da blanks) allora deve essere presente all'interno della colonna COD\_ASL della query Anagrafica FLS11 filtrata sulla condizione:  il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT\_INI\_VLD, DAT\_END\_VLD\_EFT della query. <br>(vedi definizione codice 2 sheet BR - Definizioni)  |Anagrafiche: FLS11|Anno di Riferimento; Mese di Riferimento|Scarti|Anagrafica|
|Tipo Erogatore|D90|Errore di dominio Struttura Erogante|La struttura Erogante relativamente al Tipo Erogatore trasmesso non è un codice valido per il Modello FLS11. Dal 15 febbraio 2012, per tipo <br>erogatore “06” il codice della Struttura Erogante deve corrispondere ad una ASL.|se Il valore del campo **tipo\_er** del tracciato di input è uguale a 06  allora il valore del campo **id\_er** deve essere presente all'interno della colonna COD\_ASL della query Anagrafica FLS11 filtrata sulla condizione:  il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT\_INI\_VLD, DAT\_END\_VLD\_EFT della query. <br>(vedi definizione codice 2 sheet BR - Definizioni)  |Anagrafiche: FLS11|Anno di Riferimento; Mese di Riferimento|Scarti|Anagrafica|
|Stato Estero di residenza|D31|Errore stato estero dell'assistito|Il codice identificativo dello stato estero di residenza dell'assistito non è presente in anagrafica. Questo errore viene restituito <br>quando il codice identificativo <br>dello stato estero, non è presente <br>in anagrafica|se Il campo **stat\_est** del tracciato di input è valorizzato  (presente e diverso da blanks) allora deve essere presente all'interno della colonna COD\_NAZ della query Anagrafica Codifica nazioni ISO-Alpha2 filtrata sulla condizione:  il periodo (anno-mese) di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT\_INI\_VLD, DAT\_END\_VLD della query.<br>(vedi definizione codice 2 sheet BR - Definizioni)  |Codifica nazioni ISO-Alpha2|Anno di Riferimento; Mese di Riferimento|Scarti|Anagrafica|
|Tipo Medicinale|D32|Errore codice tipo medicinale|Il codice tipo medicinale non è presente in anagrafica. Questo errore viene restituito <br>quando il tipo medicinale <br>valorizzato non è presente in <br>anagrafica.<br>Si consiglia di consultare le <br>specifiche sul portale del <br>ministero|se il campo **tipo\_f** del tracciato di input è valorizzato (presente  diverso da blanks) allora può assumere solo uno dei seguenti valori: 1,2,3,4,5 **or** 6.<br>(vedi definizione codice 2 sheet BR - Definizioni)|Non Definito|Non Definito|Scarti|Basic|
|Tipo Struttura Erogante|D36|Errore tipo struttura erogante|Il tipo struttura erogante non è presente in anagrafica. Questo errore viene restituito <br>quando il tipo struttura erogante <br>non è presente in anagrafica.<br>Si consiglia di consultare le <br>specifiche pubblicate sul portale <br>del ministero. |se il campo **tipo\_er** del tracciato di input è valorizzato con "02" allora il campo **tipo\_str del tracciato di imput** deve assumere uno dei seguenti valori: 01,02,03,04 **or** 05.<br>(vedi definizione codice 2 sheet BR - Definizioni)|Non Definito|Non Definito|Scarti|Basic|
|Identificativo assistito|D37|Errore id assistito|In base alla struttura erogante indicata, l'id assistito è obbligatorio. Questo errore viene restituito <br>quando, per un tipo erogatore <br>diverso da 02 oppure diverso da <br>05 o per un tipo erogatore 02 e <br>tipo struttura 04 , non venga <br>valorizzato l'id dell'assistito|Se il record non rispetta l'anonimato implicito (vedi definizione codice 1 sheet BR - Definizioni) e non rispetta l'anonimato esplicito (vedi definizione codice 1 sheet BR - Definizioni) allora il campo **id\_ass** è obbligatorio (presente e diverso da blanks)|Non Definito|Tipo Erogatore; Tipo Struttura <br>Erogante; Codice Struttura Erogante; ASL Residenza; Stato Estero di Residenza|Scarti|Basic|
|Stato estero di residenza; ASL Residenza|B38|Associazione Stato Estero - ASL assistito errata|È errato valorizzare sia lo Stato Estero di residenza che l'ASL di residenza.Questo errore si presenta quando all'interno del file inviato per il record indicato, siano stati valorizzati sia lo stato estero che l'ASL di residenza.|I campi **stat\_est** e **cod\_asl\_ass** del tracciato di input non possono essere entrambi valorizzati (presente e diverso da blanks)|Non Definito|stato estero di Residenza; ASL di residenza|Scarti|Basic|
|Codice esenzione|D39|Errore codice esenzione|In base alla struttura erogante indicata, il codice esenzione è obbligatorio. Questo errore viene restituito quando, per un tipo erogatore diverso da 02 oppure diverso da 05 o per un tipo erogatore 02 e tipo struttura 04, non venga <br>valorizzato il codice esenzione|Se il record non rispetta l'**anonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) e non rispetta l'**anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni) e se il **tipo\_esen** è diverso da (0,1,9,null)  allora il campo **cod\_esen** è obbligatorio (presente e diverso da blanks)|Non Definito|Tipo Erogatore; Tipo Struttura <br>Erogante; Codice Struttura Erogante; ASL Residenza; Stato Estero di Residenza|Scarti|Basic|
|Tipo Erogatore|B44|Errore Tipo Erogatore|Il tipo erogatore non è ammesso per Canale di <br>Erogazione “R – Rimborso Extra Tariffa”. (le Tipologie ammesse sono: 01 - Struttura di ricovero, 02 - Altra struttura sanitaria, 03 - Istituto o centro di riabilitazione, 06 <br>- ASL). Per il canale “R – Rimborso Extra Tariffa” è prevista la possibilità di inviare solamente strutture non direttamente gestite dal SSN, appartenenti alle tipologie: 01 - Struttura di ricovero, 02 - Altra struttura sanitaria, 03 - Istituto o centro di riabilitazione, 06 - ASL|se il valore del campo **tipo\_canale** del tracciato di input è uguale al carattere R allora gli unici valori ammessi per il campo **tipo\_er** del tracciato di input sono i seguenti: 01, 02, 03 e 06|Non Definito|Canale di erogazione|Scarti|Basic|
|Errore codice prescrittore|D17|Valorizzazione campo errato|Il codice prescrittore deve essere omesso se il codice tipo prescrittore è pari a 'Z’. Questo errore viene restituito se <br>il codice prescrittore risulta <br>essere valorizzato e il codice tipo <br>prescrittore è 'Z’.|Il campo **cod\_pr** del tracciato di input non deve essere presente (non presente o blanks) se il campo **tipo\_pr** del tracciato di input è valorizzato con il carattere Z|Non Definito|Tipo Prescrittore|Scarti|Basic|
|Costo del servizio per ricetta; Costo del servizio|D38|Errore costo del servizio per ricetta|Il costo del servizio per ricetta e il costo del servizio previsto a livello di medicinale prescritto non possono essere mai entrambi non valorizzati. Questo errore viene restituito <br>quando sia costo del servizio per <br>ricetta che il costo del servizio <br>previsto a livello di medicinale <br>prescritto non sono stati <br>valorizzati.|i campi **costo\_srv\_ric**, **costo\_srv** del tracciato di input non possono essere entrambi non valorizzati (presente e diverso da blank); almeno uno dei due deve essere valorizzato|Non Definito|Non Definito|Scarti|Basic|
|Costo d'acquisto; Costo del servizio|B41|Errore Costo di Acquisto|Il costo di acquisto ed il costo del servizio devono essere dello stesso segno della quantità quando l'id contatto è diverso 0. Questo errore viene restituito <br>quando per id contatto uguale a <br>zero, non risultano valorizzati i <br>campi "costo di acquisto" e <br>"costo del servizio".|Se il valore del campo **id\_cont** del tracciato di input NON è costituito solo da n caratteri uguali a 0 allora i segni dei campi **cost\_srv** e **cost\_acq** del tracciato di input devono essere uguali|Non Definito|Id Contatto|Scarti|Basic|
|Codice medicinale|B14|Errore codice medicinale|Per i dati relativi ai periodi a partire da Maggio 2012, il codice medicinale è obbligatorio per il tipo medicinale indicato; Questo errore si verifica quando per i tipi medicinali 2,3 a partire da Maggio 2012, il codice medicinale non è valorizzato;|se il valore del campo **tipo\_f** del tracciato di input è valorizzato con 2 **or** 3 allora il campo **cod\_f** del tracciato di input è obbligatorio (presente e diverso da blank)|Non Definito|Tipo Medicinale|Scarti|Basic|
|Sesso|D28|Errore sesso dell'assistito|In base alla struttura erogante indicata, il sesso dell'assistito è obbligatorio. Questo errore viene restituito <br>quando, per un tipo erogatore <br>diverso da 02 oppure diverso da <br>05 o per un tipo erogatore 02 e <br>tipo struttura 04, non venga <br>valorizzato il sesso dell'assistito.|Se il record non rispetta l'**anonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) e non rispetta l'**anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni) allora il campo **sesso** è obbligatorio (presente e diverso da blanks)|Non Definito|Tipo Erogatore; Tipo Struttura <br>Erogante; Codice Struttura Erogante; ASL Residenza; Stato Estero di Residenza|Scarti|Basic|
|Tipo di esenzione|D23|Errore codice tipo esenzione|In base alla struttura erogante indicata, il codice tipo esenzione è obbligatorio. Questo errore viene restituito <br>quando per un tipo erogatore 02 <br>e tipo struttura 04 oppure il tipo <br>erogatore diverso da 02 o diverso <br>da 05 non venga valorizzato il <br>tipo esenzione.|Se il record non rispetta l'**anonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) e non rispetta l'**anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni) allora il valore del campo **tipo\_esen** è obbligatorio (presente e diverso da blanks)|Non Definito|Tipo Erogatore; Tipo Struttura <br>Erogante; Codice Struttura Erogante; ASL Residenza; Stato Estero di Residenza|Scarti|Basic|
|Targatura|D41|Errore Codice Targatura|Il Codice Targatura del tipo medicinale 2, 3, 4, 5, 6 può essere solo pari a '0' o a '000000000'. Questo errore viene restituito quando <br>per il tipo medicinale 2, 3, 4, 5, 6<br>Si valorizza un codice targatura <br>diverso da '0' o a '000000000'|se il valore del campo **tipo\_f** è uguale a 2,3,4,5 **or** 6 del tracciato di input allora il campo **targatura** del tracciato di input può contenere solo 0 |Non Definito|Tipo Medicinale|Scarti|Basic|
|Data Nascita Assistito|D89|Errore Data Nascita Assistito|La Data di Nascita dell'assistito non è corretta. L’errore può essere causato da <br>un Data di Nascita Assistito maggiore della Data di Erogazione oppure da una Data di Nascita Assistito molto inferiore alla Data di Erogazione <br>(range accettato: 0 <= Data nascita Assistito > 150 anni). |Se il record rispetta l'**anonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) o rispetta l'**anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni) è ammessa la valorizzazione del campo **data\_nasc** del tracciato di input con 9999-12-31.<br><br>Se il record **non** rispetta l'a**nonimato implicito** (vedi definizione codice 1 sheet BR - Definizioni) e **non** rispetta **l'anonimato esplicito** (vedi definizione codice 1 sheet BR - Definizioni)  oppure il campo **data\_nasc** del tracciato di input è diverso da 9999-12-31deve valere la relazione [0<= **data\_erog** (solo anno) - **data\_nasc** (solo anno) <= 150] allora scarto (attivazione D89)|Non Definito|Data Erogazione|Scarti|Basic|
|Quantità; Fattore di Conversione|B13|Errore Quantità|In caso di valorizzazione della Targatura, il rapporto tra la quantità trasmessa e il fattore di conversione deve essere unitario. Questo errore viene restituito quando, valorizzando come tipo <br>farmaco 1, per il record indicato, si omette il codice farmaco.|se il valore del campo **targatura** del tracciato di input NON è valorizzato con solo 0 (0, 00, 000, ….) oppure NON è NULL allora il rapporto tra i campi **qta** e **fatt\_conv** del tracciato di input deve essere 1|Non Definito|Targatura|Scarti|Basic|
|Codice medicinale|D33|Errore codice tipo esenzione|Il codice ATC inviato non esiste. Questo errore viene restituito <br>quando, valorizzando come tipo <br>farmaco 2 o 3, il codice ATC <br>inviato non è presente in <br>anagrafica|Se il campo **tipo\_f** del tracciato di input è uguale a 2 **or** 3 allora il campo **cod\_f** del tracciato in input deve essere presente all'interno della colonna COD\_ATC della query anagrafica ATC Farmaci filtrata sulla condizione: <br>-il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT\_INI\_VLD, DAT\_END\_VLD della query. <br>Se il campo **tipo\_f** del tracciato di input è uguale a 4 **or** 5 allora il campo **cod\_f** del tracciato in input deve essere uguale a V03AN01.<br>Se il campo **tipo\_f** del tracciato di input è uguale a 6 allora il campo **cod\_f** deve essere presente nella colonna ATC della query anagrafica COD ATC 06. <br>(vedi definizione codice 2 sheet BR - Definizioni)  |COD ATC 06; ATC Farmaci|Tipo Medicinale|Scarti|Anagrafica|
|Codice esenzione|D22|Errore Codice esenzione|Errore Codice esenzione Il codice esenzione non è presente in anagrafica. DI3, DT3 Questo errore viene restituito quando, il codice esenzione non è presente in anagrafica. Correggere il campo "codice esenzione" e ritrasmettere il file.|Se il valore del campo **cod\_esen**  del tracciato di input è valorizzato (presente e diverso da blanks) allora deve essere presente all'interno della colonna cod\_esz\_mef della query anagrafica. <br>(vedi definizione codice 2 sheet BR - Definizioni)  |Codici esenzione|Non Definito|Scarti|Anagrafica|
|Tipo Erogatore; Codice Struttura Erogante|D20|Errore struttura erogante|Il codice della struttura erogante non è presente in anagrafica per la tipologia inviata. Questo errore viene restituito <br>quando la struttura erogante non <br>è presente nelle anagrafiche <br>oppure quando la struttura esiste <br>ma è stato valorizzato un tipo <br>struttura errato.|se tipo\_er = 02 allora tipo\_er # cod\_asl # id\_er  deve esistere in anagrafica;<br>se tipo\_er = 01, 03, 04, 05, 06 allora tipo\_er # id\_er  deve esistere in anagrafica;<br>Le anagrafiche devono essere filtrate sulla condizione:  <br>il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT\_INI\_VLD, DAT\_END\_VLD\_EFT della query. |Elenco completo delle strutture eroganti (cfr: D20 / D90)|Tipologia Erogatore|Scarti|Anagrafica|
|Codice medicinale|D03|Errore di dominio codice medicinale|Il codice AIC inviato non esiste. Questo errore viene restituito <br>quando, il codice AIC inviato <br>non esiste in anagrafica.|Se il valore del campo **tipo\_f**  del tracciato di input è uguale a 1 allora il valore del campo **cod\_f** del tracciato di input deve essere presente all'interno della colonna COD\_AIC dell'anagrafica. (vedi definizione codice 2 sheet BR - Definizioni)  |Anagrafiche: AIFA (MEDICINALI)|Tipo Medicinale|Scarti|Anagrafica|
| |D01|Errore di dominio codice ASL|Il codice azienda non esiste per la regione inviata. Questo errore viene restituito <br>quando, il codice ASL inviato <br>non è presente in anagrafica.|Se il valore del campo tipo\_canale del tracciato di input è uguale al carattere P **or** D allora il valore del campo **cod\_asl** del tracciato di input deve essere presente all'interno della colonna COD\_ASL dell'anagrafica ASL (per canali P e D) altrimenti se il valore del campo **tipo\_canale** del tracciato di input è uguale al carattere R allora il campo **cod\_asl** del tracciato di input deve essere presente all'interno della colonna COD\_ASL della query Anagrafica ASL (per canali R). <br>(vedi definizione codice 2 sheet BR - Definizioni)  |ASL (per canali P e D); ASL (per canali R)|Canale di erogazione|Scarti|Anagrafica|
|Codice <br>Struttura <br>Erogante; Tipo Struttura <br>Erogante|B43|Errore struttura erogante|Errore struttura erogante Il codice della struttura erogante non è valido per il Canale di Erogazione “R – Rimborso Extra Tariffa”. Le strutture ammesse sono solamente quelle non direttamente gestite dal SSN. DI3, DT3 Per il canale “R – Rimborso Extra Tariffa” è prevista la possibilità di inviare solamente strutture non direttamente gestite dal SSN Verificare che il codice struttura erogante appartenga alle strutture non direttamente gestite dal Servizio Sanitario Nazionale|Se il valore del campo **tipo\_canale** del tracciato di input è uguale al carattere R allora i valori dei campi **tipo\_str** e **id\_er** del tracciato di input devono essere presenti rispettivamente sul primo e secondo valore della colonna **VALUE** della query anagrafica filtratra sulla seguente condizione:<br>il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT\_INI\_VLD, DAT\_END\_VLD della query. |Anagrafe strutture eroganti abilitate ed utilizzabili con il canale "R" (cfr: B43 / D90)|Canale di erogazione|Scarti|Anagrafica|
|Codice ASL|B42|Errore di dominio codice AS|` `L'AZIENDA SANITARIA indicata nel tracciato non è ammesso per il Canale di Erogazione trasmesso. L’errore viene restituito qualora si stia utilizzando un codice di un azienda sanitaria associandolo ad un canale di erogazione incompatibile. Ad esempio i codici relativi alla “Gestione Sanitaria Centralizzata” non possono essere utilizzati per i canali delle Diretta e della Per Conto Verificare la corretta valorizzazione del codice Azienda Sanitaria per il canale di erogazione trasemesso|Se il campo **cod\_asl** del tracciato di input non è presente all'interno della colonna COD\_ASL (2 campo nella concatenazione del campo **VALUE**) della query  filtrata sulla condizione:  <br>- cod\_reg del tracciato di input = COD\_REG query (1 campo nella concatenazione del campo **VALUE**)<br>- tipo\_canale del tracciato di input = CANALE della query (3 campo nella concatenazione del campo **VALUE**)<br>-il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT\_INI\_VLD, DAT\_END\_VLD della query. **and** il valore del campo **cod\_asl** del tracciato di input termina con 000 allora scarto|Anagrafe: ASL abilitate a trasmettere (cfr: B30/B42)|Codice Regione,Canale Erogazione, Anno di Riferimento, Mese di Riferimento|Scarti|Anagrafica|
|Codice Asl|B30|Errore codice ASL trasmessa|Il codice inviato si riferisce ad una ASL non abilitata alla trasmissione per il canale di erogazione indicato. Questo errore si presenta quando il codice ASL trasmesso, appartiene ad un ASL non abilitata alla trasmissione. Controllare la correttezza del codice ASL trasmesso. Correggere il file e ritrasmetterlo|se Il campo **cod\_asl** del tracciato di input è valorizzato (presente e diverso da blanks) allora deve essere presente all'interno della colonna COD\_ASL (2 campo nella concatenazione del campo **VALUE**) della query  filtrata sulla condizione:  <br>- cod\_reg del tracciato di input = COD\_REG query (1 campo nella concatenazione del campo **VALUE**)<br>- tipo\_canale del tracciato di input = CANALE della query (3 campo nella concatenazione del campo **VALUE**)<br>-il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT\_INI\_VLD, DAT\_END\_VLD della query. <br>(vedi definizione codice 2 sheet BR - Definizioni)  |Anagrafe: ASL abilitate a trasmettere (cfr: B30/B42)|Codice Regione,Canale Erogazione, Anno di Riferimento, Mese di Riferimento|Scarti|Anagrafica|
|Non Definito|B03|Errore periodo di riferimento|La data d’invio del file deve essere successiva al periodo di riferimento. Questo errore viene restituito <br>quando il periodo cui si <br>riferiscono i dati all’interno del <br>file è successivo alla data d’invio <br>del file|la data di esecuzione dell'SDK deve essere maggiore rispetto all'ultimo giorno del periodo (**anno**-**mese**) di riferimento nel tracciato di input |Non Definito|Anno di Riferimento; Mese di Riferimento|Scarti|Basic|
|Tipo Esenzione|B29|Errore codice esenzione |Non è ammessa la <br>valorizzazione del codice <br>esenzione per il tipo <br>esenzione scelto. Questo errore si presenta quando <br>per il tipo esenzione, è stato <br>valorizzato in codice esenzione <br>errato, o per il codice esenzione <br>scelto, è errato il tipo esenzione|Se il valore del campo **code\_esen** del tracciato di input è valorizzato (presente e diverso da blanks) allora il valore del campo **tipo\_esen** del tracciato di input deve essere diverso da 1 9 e null. Diverso da null significa presente e diverso da blanks|Non Definito|Codice Esenzione|Scarti|Basic|
|targatura (nomenclatura tracciato di input)|B100 (ex XSD\_35)|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0]{1}|[0-9]{9}[0-9AX]{0,1}<br><br>Ovvero, i valori ammessi sono:<br>a) 0 oppure 000000000<br>b) nnnnnnnnnA<br>c) nnnnnnnnnX<br>d) nnnnnnnnnn<br>dove n=numero intero da 0 a 9|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|Targatura|B101|Errore check-digit della targatura|Se **targatura** è composto da dieci caratteri numerici (e quindi non ricade negli altri casi definiti nella regola D100), allora:<br>a) sia **t** i primi nove caratteri (numerici) del valore del campo targatura a partire da sinistra;<br>b) iniziando dall'ultima cifra signicativa di **t** (quindi da destra), assegnare a ciascuna cifra, procedendo verso sinistra, alternativamente i valori 3,1,3,1,...;<br>c) sia **s** la somma dei prodotti tra ciascuna cifra ed il valore rispettivamente assegnato;<br>d) il check-digit è uguale a **(10 - (s mod 10)) mod 10**<br>e) il record è valido se il campo targatura ha come numero più a destra (quindi il decimo carattere) il valore del check-digit calcolato al punto precedente.<br><br>Esempio: supponiamo per semplificare che la targatura sia composta da 6 cifre e non da 10, ovvero "473651"<br>a) t="47365";<br>b) valori: "31313":<br>c) s = (3 x 5) + (1 x 6) + (3 x 3) + (1 x 7) + (3 x 4) = 49<br>d) check-digit = 10 - (49 mod 10) = 10 - 9 = 1<br>e) in questo caso, il valore targatura è corretto dato che la cifra più a destra è 1, che è il valore del check-digit calcolato al punto precedente.<br>NB: nell'esempio consideriamo solo per semplificare che la targatura sia a 6 cifre. In realtà, è a 10 cifre.|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|cod\_reg (nomenclatura tracciato di input)|XSD\_1|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo: [0-9]{3}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|anno (nomenclatura tracciato di input)|XSD\_2|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo: [2][0][0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|mese (nomenclatura tracciato di input)|XSD\_3|Coerenza dominio valori|Unici valori ammessi per il campo:"01","02","03","04","05","06","07","08","09","10","11","12"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|cod\_asl (nomenclatura tracciato di input)|XSD\_4|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex: [0-9]{6}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tipo\_er (nomenclatura tracciato di input)|XSD\_5|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tipo\_str (nomenclatura tracciato di input)|XSD\_6|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|id\_er (nomenclatura tracciato di input)|XSD\_7|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9a-zA-Z\-]{1,8}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|id\_ass (nomenclatura tracciato di input)|XSD\_8|Coerenza dimensionale|il valore del campo deve contenere 88 caratteri|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|vld\_id\_ass (nomenclatura tracciato di input)|XSD\_9|Coerenza dominio valori|Unici valori ammessi per il campo: "0","1"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tip\_id\_ass (nomenclatura tracciato di input)|XSD\_10|Coerenza dominio valori|Unici valori ammessi per il campo:"0","1","2","3","4","97","98","99"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|dat\_nasc (nomenclatura tracciato di input)|XSD\_11|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{4}-[0-9]{2}-[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|sesso (nomenclatura tracciato di input)|XSD\_12|Coerenza dominio valori|Unici valori ammessi per il campo: "1","2","9"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|cod\_asl\_ass (nomenclatura tracciato di input)|XSD\_13|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{6}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|citt (nomenclatura tracciato di input)|XSD\_14|Coerenza dominio valori|Unici valori ammessi per il campo: "1","2","9"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|stat\_est (nomenclatura tracciato di input)|XSD\_15|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[a-zA-Z]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|cod\_ist\_comp (nomenclatura tracciato di input)|XSD\_16|Coerenza dimensionale|il valore del campo deve contenere 28 caratteri|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tipo\_op (nomenclatura tracciato di input)|XSD\_17|Coerenza dominio valori|Unici valori ammessi per il campo: "I","V","C"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tipo\_canale (nomenclatura tracciato di input)|XSD\_18|Coerenza dominio valori|Unici valori ammessi per il campo: "P","D","R"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|cod\_esen (nomenclatura tracciato di input)|XSD\_19|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9A-Za-z]{1,6}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tipo\_erog (nomenclatura tracciato di input)|XSD\_20|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tipo\_esen (nomenclatura tracciato di input)|XSD\_21|Coerenza dominio valori|Unici valori ammessi per il campo: "0","1","2","3","4","5","9"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tipo\_cont (nomenclatura tracciato di input)|XSD\_22|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[1-2]{1}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|id\_cont (nomenclatura tracciato di input)|XSD\_23|Coerenza dimensionale|lunghezza massima prevista è di 20 caratteri|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|dat\_erog (nomenclatura tracciato di input)|XSD\_24|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{4}-[0-9]{2}-[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|quota\_fissa\_ass (nomenclatura tracciato di input)|XSD\_25|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{1,3}\.{1}[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|quota\_perc\_ass (nomenclatura tracciato di input)|XSD\_26|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{1,3}\.{1}[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|dat\_pres (nomenclatura tracciato di input)|XSD\_27|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{4}-[0-9]{2}-[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|costo\_srv\_ric (nomenclatura tracciato di input)|XSD\_28|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9]{1,4}\.{1}[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|cod\_pr (nomenclatura tracciato di input)|XSD\_29|Coerenza dimensionale|il valore del campo deve contenere 16|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tipo\_pr (nomenclatura tracciato di input)|XSD\_30|Coerenza dominio valori|Unici valori ammessi per il campo:"F","P","H","A","G","T","C","U","D","Z","I","X","B"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|tipo\_f (nomenclatura tracciato di input)|XSD\_31|Coerenza dominio valori|Unici valori ammessi per il campo: "1","2","3","4","5","6"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|cod\_f (nomenclatura tracciato di input)|XSD\_32|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0-9a-zA-Z]{1,9}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|qta (nomenclatura tracciato di input)|XSD\_33|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|fatt\_conv (nomenclatura tracciato di input)|XSD\_34|Coerenza dimensionale|è previsto un valoreMinimo = 1 ed un valoreMassimo="999999"|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|costo\_acq (nomenclatura tracciato di input)|XSD\_36|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}|Non Definito|Non Definito|Non Definito|Scarti|Basic|
|costo\_srv ( nomenclatura tracciato di input)|XSD\_37|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex-{0,1}[0-9]{1,4}\.{1}[0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|



## ***3.4 Accesso alle anagrafiche***

I controlli applicativi saranno implementati a partire dall’acquisizione dei seguenti dati anagrafici disponibili in ambito MdS e recuperati con servizi ad hoc (Service Layer mediante PDI):

- Regioni
- Anagrafiche: FLS11
- Codifica nazioni ISO-Alpha2
- COD ATC 06
- ATC Farmaci
- Codici esenzione
- Elenco completo delle strutture eroganti (cfr: D20 se tipo\_er in 01,02,03,04,05 / D90 se tipo\_er in 06)
- Anagrafiche: AIFA (MEDICINALI)
- ASL (per canali P e D)
- ASL (per canali R)
- Anagrafe strutture eroganti abilitate ed utilizzabili con il canale "R" (cfr: B43 / D90)
- Anagrafe: ASL abilitate a trasmettere (cfr: B30/B42)

Il dato anagrafico sarà presente sottoforma di tabella composta da tre colonne:

- Valore (in cui è riportato il dato, nel caso di più valori, sarà usato il carattere # come separatore)

- Data inizio validità (rappresenta la data di inizio validità del campo Valore)

 - Formato: AAAA-MM-DD
 - Notazione inizio validità permanente: **1900-01-01**


- Data Fine Validità (rappresenta la data di fine validità del campo Valore)

  - Formato: AAAA-MM-DD
  - Notazione fine validità permanente: **9999-12-31**


Affinchè le Business Rule che usano il dato anagrafico per effettuare controlli, siano correttamente funzionanti occorre sempre controllare che la data di competenza (**Anno**, **Mese di riferimento** i quali rappresentano anno e mese di erogazione del farmaco) del record su cui si effettua il controllo, sia compresa tra le data di validità.  

Di seguito viene mostrato un caso limite di anagrafica DIRETTA in cui sono presenti delle sovrapposizioni temporali e contraddizioni di validità permanente/specifico range:


|ID|VALUE|VALID\_FROM|VALID\_TO|
| - | - | - | - |
|1|VALORE 1|1900-01-01|9999-12-31|
|2|VALORE 1|2015-01-01|2015-12-31|
|3|VALORE 1|2018-01-01|2023-12-31|
|4|VALORE 1|2022-01-01|2024-12-31|


Diremo che il dato presente sul tracciato di input è valido se e solo se:

∃ VALUE\_R = VALUE\_A “tale che” VALID\_FROM(senza giorno)<= DATA\_COMPETENZA <= VALID\_TO(senza giorno)

(Esiste almeno un valore compreso tra le date di validità)

Dove:

- VALUE\_R (rappresenta i campi del tracciato di input coinvolti nei controlli della specifica BR)

- VALUE\_A (rappresenta i campi dell’anagrafica coinvolti nei controlli della specifica BR)

- VALID\_FROM/VALID\_TO (rapresentano le colonne dell’anagrafica)


## ***3.5 Flussi di Output per alimentazione MdS***

### **3.5.1 Invio Flussi**

A valle delle verifiche effettuate dal Validation Engine, qualora il caricamento sia stato effettuato con il parametro Finalità Elaborazione impostato a Produzione, verranno inviati verso MdS tutti i record corretti secondo le regole di validazione impostate.

Verrà richiamata la procedura invioFlussi di GAF WS (tramite PDI) alla quale verranno passati in input i seguenti parametri:


|**NOME PARAMETRO**|**VALORIZZAZIONE**|
| :- | :- |
|ANNO RIFERIMENTO|Parametro ANNO RIFERIMENTO in input a SDK|
|PERIODO RIFERIMENTO|Parametro PERIODO RIFERIMENTO in input a SDK |
|CATEGORIA FLUSSI|DIR|
|NOME FLUSSO|IF3|
|NOME FILE|Parametro popolato dall’SDK in fase di invio flusso con il nome file generato dal Validation Engine in fase di produzione file.|

### **3.5.2 Flussi di Output per alimentazione MdS**

Il flusso generato dall’SDK sarà presente sotto la cartella /sdk/xml\_output e dovrà essere salvato e inviato verso MdS rispettando la seguente nomenclatura:

- **SDK\_DIR\_IF3\_{Periodo di riferimento}\_{ID\_RUN}.xml**

Dove :

- Periodo di Riferimento rappresenta il periodo con il quale viene lanciato l’SDK;
- ID\_RUN rappresenta l’identificativo univoco.

A valle della presa in carico del dato da parte di MdS, SDK riceverà una response contenente le seguenti informazioni:

1. **codiceFornitura**: stringa numerica indicante l’identificativo univoco della fornitura inviata al GAF
1. **errorCode**: stringa alfanumerica di 256 caratteri rappresentante il codice identificativo dell’errore eventualmente riscontrato
1. **errorText**: stringa alfanumerica di 256 caratteri rappresentante il descrittivo dell’errore eventualmente riscontrato
1. Insieme delle seguenti triple, una per ogni file inviato:

 a. **idUpload**: stringa numerica indicante l’identificativo univoco del singolo file ricevuto ed accettato dal MdS, e corrispondente al file inviato con la denominazione riportata nell’elemento “nomeFile” che segue

 b. **esito**: stringa alfanumerica di 4 caratteri rappresentante l’esito dell’operazione (Vedi tabella sotto)

 c. **nomeFile**: stringa alfanumerica di 256 caratteri rappresentante il nome dei file inviati.


Di seguito la tabella di riepilogo dei codici degli esiti possibili dell’invio del file:

|**ESITO**|**DESCRIZIONE**|
| :- | :- |
|AE00|Errore di autenticazione al servizio|
|IF00|Operazione completata con successo|
|IF01|Incongruenza tra CF utente firmatario e cf utente inviante|
|IF02|Firma digitale non valida|
|IF03|Firma digitale scaduta|
|IF04|Estensione non ammessa|
|IF05|Utente non abilitato all’invio per la Categoria Flusso indicata|
|IF06|Utente non abilitato all’invio per il Flusso indicata|
|IF07|Periodo non congurente con la Categoria Flusso indicata|
|IF08|Il file inviato è vuoto|
|IF09|Errore interno al servizio nella ricezione del file|
|IF10|Il numero di allegati segnalati nel body non corrisponde al numero di allegati riscontrati nella request|
|IF11|Il nome dell’allegato riportato nel body non è presente tra gli allegati della request (content-id)|
|IF12|Presenza di nomi file duplicati|
|IF13|Errore interno al servizio nella ricezione del file|
|IF14|Errore interno al servizio nella ricezione del file|
|IF15|Errore interno al servizio nella ricezione del file|
|IF99|Errore generico dell’operation|

Copia dei file inviati verso MdS il cui esito è positivo (ovvero risposta della procedura Invio Flussi con IF00) saranno trasferiti e memorizzati in una cartella ad hoc di SDK (es. /sdk/sent) rispettando la stessa naming descritta per i flussi di output.

## ***3.6  Scarti di processamento***

In una cartella dedicata (es. /sdk/esiti) verrà creato un file json contenente il dettaglio degli scarti riscontrati ad ogni esecuzione del processo SDK.

Il naming del file sarà:  ESITO\_{ID\_RUN}.json

Dove:

- ID\_RUN rappresenta l’identificativo univoco dell’elaborazione

Di seguito il tracciato del record da produrre.


|**CAMPO**|**DESCRIZIONE**|
| :- | :- |
|NUMERO RECORD|Numero del record del flusso input|
|RECORD PROCESSATO|Campi esterni rispetto al tracciato, che sono necessari per la validazione dello stesso.</p><p>Record su cui si è verificato uno scarto, riportato in maniera strutturata (nome\_campo-valore).|
|LISTA ESITI|<p>Lista di oggetti contenente l’esito di validazione per ciascun campo:</p><p>- Campo: nome campo su cui si è verificato uno scarto</p><p>- Valore Scarto: valore del campo su cui si è verificato uno scarto</p><p>- Valore Esito: esito di validazione del particolare campo</p><p>- Errori Validazione: contiene i campi Codice (della Business Rule) e Descrizione (della Business Rule)</p>|

## ***3.7 Informazioni dell’esecuzione***

In una cartella dedicata (es. /sdk/run) verrà creato un file contenente il dettaglio degli esiti riscontrati ad ogni esecuzione del processo SDK.

Il naming del file sarà:  

{ID\_RUN}.json

Dove:

- ID\_RUN rappresenta l’identificativo univoco dell’elaborazione

Di seguito il tracciato del record da produrre.



|**CAMPO**|**DESCRIZIONE**|
| :- | :- |
|ID RUN (chiave)|Identificativo univoco di ogni esecuzione del SDK|
|ID\_CLIENT|Identificativo Univoco della trasazione sorgente che richiede processamento lato SDK|
|ID UPLOAD (chiave)|Identificativo di caricamento fornito da MdS|
|TIPO ELABORAZIONE|F (full)/R (per singolo record) - Impostato di default a F|
|MODALITA’ OPERATIVA|P (=produzione) /T (=test)|
|DATA INIZIO ESECUZIONE|Timestamp dell’ inizio del processamento|
|DATA FINE ESECUZIONE|Timestamp di completamento del processamento|
|STATO ESECUZIONE |<p>Esito dell’esecuzione dell’ SDK. </p><p>Possibili valori: </p><p>- IN ELABORAZIONE: Sdk in esecuzione;</p><p>- ELABORATA: Esecuzione completata con successo;</p><p>- KO: Esecuzione fallita: </p><p>- KO SPECIFICO: Esecuzione fallita per una fase/componente più rilevante della soluzione (es. ko\_gestione\_file, ko\_gestione\_validazione, ko\_invio\_ministero, etc.); </p><p>- KO GENERICO: un errore generico non controllato.</p>|
|FILE ASSOCIATI RUN|nome del file di input elaborato dall’SDK|
|NOME FLUSSO|{DIRETTA}, valore fisso che identifica lo specifico SDK in termini di categoria e nome flusso|
|NUMERO RECORD |Numero di record del flusso input|
|NUMERO RECORD ACCETTATI|Numero validi|
|NUMERO RECORD SCARTATI|Numero scarti|
|VERSION|Versione del SDK (Access Layer e Validation Engine)|
|TIMESTAMP CREAZIONE|Timestamp creazione della info run|
|API (\*DPM)|Rappresenta L’API utilizzata per il flusso DPM (non valorizzata per gli altri flussi)|
|IDENTIFICATIVO SOGGETTO ALIMENTANTE (\*DPM)|Chiave flusso DPM (non valorizzata per gli altri flussi)|
|TIPO ATTO (\*DPM)|Chiave flusso DPM (non valorizzata per gli altri flussi)|
|NUMERO ATTO (\*DPM)|Chiave flusso DPM (non valorizzata per gli altri flussi)|
|TIPO ESITO MDS (\*DPM)|Esito della response dell’API 2 (non valorizzata per gli altri flussi) |
|DATA RICEVUTA MDS (\*DPM)|Data della response dell’API 3 (non valorizzata per gli altri flussi)|
|CODICE REGIONE|Codice Regione del Mittente|
|ANNO RIFERIMENTO|Anno cui si riferiscono i dati del flusso|
|PERIODO DI RIFERIMENTO|Rappresenta il mese di riferimento dei dati del flusso (es. 12)|
|DESCRIZIONE STATO ESECUZIONE |Specifica il messaggio breve dell’errore, maggiori informazioni saranno presenti all’interno del log applicativo|
|NOME FILE OUTPUT MDS|Nome dei file di output inviati verso MdS|
|ESITO ACQUISIZIONE FLUSSO|Codice dell’esito del processo di acquisizione del flusso su MdS. Tale campo riflette la proprietà invioFlussiReturn/listaEsitiUpload/item/esito della response della procedura **invioFlussi**. (Es IF00)|
|CODICE ERRORE INVIO FLUSSI|Codice d’errore della procedura di invio. Tale campo riflette la proprietà InvioFlussiReturn/errorCode della response della procedura **invioFlussi**|
|TESTO ERRORE INVIO FLUSSI|Descrizione codice d’errore della procedura.Tale campo riflette la proprietà InvioFlussiReturn/ errorText della response della procedura **invioFlussi**|


Inoltre, a supporto dell’entità che rappresenta lo stato dell’esecuzione, sotto la cartella /sdk/log, saranno presenti anche i file di log applicativi (aggregati giornalmente) non strutturati, nei quali saranno presenti informazioni aggiuntive, ad esempio lo StackTrace (in caso di errori).

Il naming del file, se non modificata la politica di rolling (impostazioni) sarà:

**SDK \_DIR\_IF3.log**

## mantainer:
 Accenture SpA until January 2026
