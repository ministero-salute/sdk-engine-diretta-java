/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.dir.parser.regole;

import it.mds.sdk.libreriaregole.regole.beans.Campo;
import it.mds.sdk.libreriaregole.regole.beans.Parametri;
import it.mds.sdk.libreriaregole.regole.beans.RegolaGenerica;
import it.mds.sdk.libreriaregole.regole.beans.RegoleFlusso;
import it.mds.sdk.libreriaregole.regole.catalogo.RegolaListaValoriAmmessi;
import it.mds.sdk.libreriaregole.regole.catalogo.RegolaListaValoriAmmessiCampoFacoltativo;
import it.mds.sdk.libreriaregole.regole.catalogo.RegolaRegex;
import it.mds.sdk.libreriaregole.regole.catalogo.RegolaRegexCampoFacoltativo;
import it.mds.sdk.libreriaregole.regole.catalogo.anagrafica.RegolaDominioValoriAnagrafica;
import it.mds.sdk.libreriaregole.regole.catalogo.crosscampo.RegolaDiversitaValoreCrossCampo;
import it.mds.sdk.libreriaregole.regole.catalogo.crosscampo.RegolaDiversitaValoreCrossCampoFacoltativo;
import it.mds.sdk.libreriaregole.regole.catalogo.crosscampo.RegolaEsistenzaDisuguaglianzaCrossCampo;
import it.mds.sdk.libreriaregole.regole.catalogo.crosscampo.RegolaOmissioneCrossCampo;
import it.mds.sdk.libreriaregole.regole.catalogo.lunghezza.RegolaLunghezzaCampoFacoltativo;
import it.mds.sdk.libreriaregole.regole.catalogo.lunghezza.RegolaLunghezzaCampoObbligatorio;
import it.mds.sdk.libreriaregole.regole.catalogo.lunghezza.RegolaMaxLunghezzaCampoFacoltativo;
import it.mds.sdk.libreriaregole.regole.catalogo.lunghezza.RegolaMaxLunghezzaCampoObbligatorio;
import it.mds.sdk.libreriaregole.regole.catalogo.obbligatorieta.RegolaObbligatorieta;
import it.mds.sdk.libreriaregole.regole.catalogo.obbligatorieta.RegolaObbligatorietaCondizionataValoreCampo;

import java.util.ArrayList;
import java.util.List;

public class CreazioneRegoleDir {
	
	public static RegoleFlusso creaRegoleDIR() {

	//Creo la Lista dei campi
			List<Campo> campi = new ArrayList<Campo>();
			
			//lista di regole per ogni campo
			List<RegolaGenerica> regoleRegioneErogante = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleAnnoRiferimento = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleMeseRiferimento = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCodiceAziendaSanitariaErogante = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTipoErogatore = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCodiceStrutturaErogante = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTipoStrutturaErogante = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleDataErogazione = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTipoErogazione = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCanaleErogazione = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTipoContatto = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleIdContatto = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCodicePrescrittore = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTipoPrescrittore = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleDataPrescrizione = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleIdentificativoAssistito = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleValiditaCodIdentificativo = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTipoCodiceAssistito = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCittadinanza = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleAslResidenza = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleStatoEsteroResidenza = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTipoEsenzione = new ArrayList<RegolaGenerica>();		
			List<RegolaGenerica> regoleCodiceEsenzione = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleImportoQuotaFissaAssistito = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCostoServizioRicetta = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleImportoQuotaPercentualeAssististo = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCostoServizio = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTipoMedicinale = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTargatura = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCostoAcquisto = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleQuantita = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleFattoreConversione = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleTipoOperazione = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCodiceIstituzioneCompetente = new ArrayList<RegolaGenerica>();
			List<RegolaGenerica> regoleCodiceMedicinale = new ArrayList<RegolaGenerica>();
	

			//creo regole per RegioneErogante
			Campo regioneErogante = creaRegoleRegioneErogante(regoleRegioneErogante,"regioneErogante");
			//creo regole AnnoRiferimento
			Campo annoRiferimento = creaRegoleAnnoRiferimento(regoleAnnoRiferimento,"annoDiRiferimento");
			//creo regole MeseRiferimento
			Campo meseRiferimento = creaRegoleMeseRiferimento(regoleMeseRiferimento,"meseDiRiferimento");
			//id CodiceAziendaSanitariaErogante
			Campo codiceAziendaSanitariaErogante = creaRegoleCodiceAziendaSanitariaErogante(regoleCodiceAziendaSanitariaErogante,"codiceAziendaSanitariaErogante");
			//TipoErogatore
			Campo tipoErogatore = creaRegoleTipoErogatore(regoleTipoErogazione,"tipoErogatore");
			//CodiceStrutturaErogante 
			Campo  codiceStrutturaErogante= creaRegoleCodiceStrutturaErogante(regoleCodiceStrutturaErogante, "codiceStrutturaErogante");
			
			Campo canaleErogazione = creaRegoleCanaleErogazione(regoleCanaleErogazione,"tipoCanale");
			
			Campo tipoStrutturaErogante = creaRegoleTipoStrutturaErogante(regoleTipoStrutturaErogante,"tipoStrutturaErogante");
			
			Campo dataErogazione = creaRegoleDataErogazione(regoleDataErogazione,"DataErogazione");
					
			Campo tipoErogazione = creaRegoleTipoErogazione(regoleTipoErogazione,"tipoErogazione");
			 					
			Campo tipoContatto = creaRegoleTipoContatto(regoleTipoContatto,"tipoContatto");
			
			Campo idContatto = creaRegoleIdContatto(regoleIdContatto,"idContatto");
			 				
			Campo codicePrescrittore = creaCodicePrescrittore(regoleCodicePrescrittore,"codicePrescrittore");
			
			Campo tipoPrescrittore= creaRegoleTipoPrescrittore(regoleTipoPrescrittore,"tipoPrescrittore");
			
			Campo dataPrescrizione= creaRegoleDataPrescrizione(regoleDataPrescrizione,"dataPrescrizione");
			 						
			Campo identificativoAssistito = creaRegoleIdentificativoAssistito(regoleIdentificativoAssistito,"identificativoAssistito");
			
			Campo validitaCodIdentificativo= creaRegoleValiditaCodIdentificativo (regoleValiditaCodIdentificativo,"validitaCodIdentAssistito");
			
			Campo tipoCodiceAssistito = creaRegoleTipoCodiceAssistito(regoleTipoCodiceAssistito,"tipologiaCodIdentAssistito");
				
			Campo cittadinanza = creaRegoleCittadinanza(regoleCittadinanza, "cittadinanza");
			 				
			Campo aslResidenza = creaRegoleAslResidenza(regoleAslResidenza, "aslAssistito");
					
			Campo statoEsteroResidenza = creaRegoleStatoEsteroResidenza(regoleStatoEsteroResidenza, "statoEsteroDiResidenza");
			 					
			Campo tipoEsenzione = creaRegoleTipoEsenzione(regoleTipoEsenzione, "tipoDiEsenzione");
			 			
			Campo codiceEsenzione = creaRegoleCodiceEsenzione(regoleCodiceEsenzione, "codiceEsenzione");
			
			Campo importoQuotaFissaAssistito = creaRegoleImportoQuotaFissaAssistito(regoleImportoQuotaFissaAssistito, "quotaFissaAssistito");
			
			Campo costoServizioRicetta = creaRegoleImportoCostoServizioRicetta(regoleCostoServizioRicetta, "costoServizioRicetta");
			
			Campo importoQuotaPercentualeAssististo = creaRegoleImportoQuotaPercentualeAssististo(regoleImportoQuotaPercentualeAssististo, "quotaPercentualeAssistito");
			
			Campo costoServizio = creaRegoleImportoQuotaCostoServizio(regoleCostoServizio, "costoServizio");
			
			Campo tipoMedicinale = creaRegoleTipoMedicinale(regoleTipoMedicinale, "tipoFarmaco");
			 					
			Campo targatura = creaRegoleTargatura(regoleTargatura, "targatura");
			 			
			Campo costoAcquisto = creaRegoleCostoAcquisto(regoleCostoAcquisto, "costoAcquisto");
			
			Campo quantita = creaRegoleQuantita(regoleQuantita, "quantita");
			
			Campo fattoreConversione = creaRegoleFattoreConversione(regoleFattoreConversione, "fattoreDiConversione");
			 					
			Campo tipoOperazione = creaRegoleTipoOperazione(regoleTipoOperazione, "tipoOperazione");

			Campo codiceIstituzioneCompetente = creaRegoleCodiceIstituzioneCompetente(regoleCodiceIstituzioneCompetente, "codiceIstituzioneCompetente");

			Campo codiceMedicinale = creaRegoleCodiceMedicinale(regoleCodiceMedicinale, "codiceFarmaco");
			 				
			 		
			//aggioungo il campo alla lista campi da validare
			campi.add(regioneErogante); 						
			campi.add(annoRiferimento);
			campi.add(meseRiferimento);
			campi.add(codiceAziendaSanitariaErogante); 			
			campi.add(tipoErogatore); 							
			campi.add(codiceStrutturaErogante);
			campi.add(canaleErogazione); 						
			//campi.add(tipoStrutturaErogante);
			campi.add(dataErogazione);
			campi.add(tipoErogazione);
			campi.add(tipoContatto);
			campi.add(idContatto);
			campi.add(codicePrescrittore);						
			campi.add(tipoPrescrittore);						
			campi.add(dataPrescrizione);
			campi.add(identificativoAssistito);
			campi.add(validitaCodIdentificativo);
			campi.add(tipoCodiceAssistito);
			campi.add(cittadinanza);
			campi.add(aslResidenza);
			//campi.add(statoEsteroResidenza);
			campi.add(tipoEsenzione);
			campi.add(codiceEsenzione);
			campi.add(importoQuotaFissaAssistito);
			campi.add(costoServizioRicetta);
			campi.add(importoQuotaPercentualeAssististo);
			campi.add(costoServizio);
			campi.add(tipoMedicinale);
			campi.add(targatura);
			campi.add(costoAcquisto); 							
			campi.add(quantita);
			campi.add(fattoreConversione);
			campi.add(tipoOperazione);
		    //campi.add(codiceIstituzioneCompetente);
		    campi.add(codiceMedicinale);


		RegoleFlusso regoleFlusso =  RegoleFlusso.builder()
						.withCampi(campi)
						.build();
			
		return regoleFlusso;

}
	// "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))" formato data "YYYY-MM-DD
	
	private static Campo creaRegoleRegioneErogante (List<RegolaGenerica>  regoleCampo, String nomeCampo) {

		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio" ,null);
		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("nomeTabella","Regioni");
		//RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","B01",parametri);
		// aggiungo le regole alla lista per campo
		regoleCampo.add(regolaObbligatorieta);
		//regoleCampo.add(regolaDominioValoriAnagrafica);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	private static Campo creaRegoleAnnoRiferimento (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
	RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("regex","[12]\\d{3}");
		RegolaRegex regolaRegex = new RegolaRegex("regolaRegex", "B20","Formato anno errato",parametri);


		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaRegex);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	private static Campo creaRegoleMeseRiferimento (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametri = new Parametri();
		//parametri.getParametriMap().put("regex","(0[1-9]|1[0-2])");
		parametri.getParametriMap().put("regex","^((?:0)[1-9]|(?:1)[0-2])$");
		RegolaRegex regolaRegex = new RegolaRegex("regolaRegex", "B20","Formato mese errato",parametri);


		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaRegex);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	private static Campo creaRegoleCodiceAziendaSanitariaErogante (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921", "Mancata valorizzazione di un campo obbligatorio",null);

		//TODO regola da scrivere
		//B42 Valori diversi da quelli ammessi: HSP11, per le altre indicare il codice del modello FLS11 (ASL, ESTAV).
		//Per il solo canale di erogazione “R – Rimborso Extra Tariffa” nel caso di rimborso effettuato direttamente dalla regione è possibile utilizzare il codice regione seguito da tre zeri
		Parametri parametriAnag = new Parametri();
		parametriAnag.getParametriMap().put("nomeTabella","ANAG_DIR_ASL");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","B42","Codice errato",parametriAnag);

		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaDominioValoriAnagrafica);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);

	}
	
	private static Campo creaRegoleTipoErogatore (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);


		/*Parametri parametriAnag = new Parametri();
		parametriAnag.getParametriMap().put("nomeTabella","?????");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","B44","Tipo di erogatore errato",parametriAnag);*/


		//aggiungo regole
		regoleCampo.add(regolaObbligatorieta);
		//regoleCampo.add(regolaDominioValoriAnagrafica);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	private static Campo creaRegoleCodiceStrutturaErogante (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921", "Mancata valorizzazione di un campo obbligatorio",null);

		//TODO aggiungere B43 I valori ammessi sono: HSP11, HSP11-bis, STS11, RIA11, FLS11

		//aggiungo regole
		regoleCampo.add(regolaObbligatorieta);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	private static Campo creaRegoleCanaleErogazione (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921", "Mancata valorizzazione di un campo obbligatorio",null);

		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("listaValoriAmmessi","D|OP|R");
		RegolaListaValoriAmmessi regolaListaValoriAmmessi = new RegolaListaValoriAmmessi("regolaListaValoriAmmessi", "8001","Codice non presente nel dominio di riferimento",parametri);

		//aggiungo regole
		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaListaValoriAmmessi);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	private static Campo creaRegoleTipoStrutturaErogante (List<RegolaGenerica>  regoleCampo, String nomeCampo) {

		//Parametri parametriAnag = new Parametri();
		//parametriAnag.getParametriMap().put("nomeTabella","Tipo_Struttura_Erogante");
		//RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","B36","Codice non presente nel dominio di riferimento",parametriAnag);

		//aggiungo regole
		//regoleCampo.add(regolaDominioValoriAnagrafica);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleDataErogazione (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);


		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("regex","([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
		RegolaRegex regolaRegex = new RegolaRegex("regolaRegex", "B20","Tipo di dato errato o formato data errato",parametri);


		//aggiungo regole
		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaRegex);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleTipoErogazione (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

/*
		Parametri parametriAnag = new Parametri();
		parametriAnag.getParametriMap().put("nomeTabella","????");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","D05","Codice non presente nel dominio di riferimento",parametriAnag);
*/
		//aggiungo regole
		regoleCampo.add(regolaObbligatorieta);
		//regoleCampo.add(regolaDominioValoriAnagrafica);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleTipoContatto (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921", "Mancata valorizzazione di un campo obbligatorio",null);

		Parametri parametriValoriAmm = new Parametri();
		parametriValoriAmm.getParametriMap().put("listaValoriAmmessi","1|2");
		RegolaListaValoriAmmessi regolaListaValoriAmmessi = new RegolaListaValoriAmmessi("regolaListaValoriAmmessiCampo", "D06","Codice non presente nel dominio di riferimento",parametriValoriAmm);

		//aggiungo regole
		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaListaValoriAmmessi);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleIdContatto (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921", "Mancata valorizzazione di un campo obbligatorio",null);

		//TODO regola D07 I valori ammessi sono: 0, SSN o Codice Regionale
		regoleCampo.add(regolaObbligatorieta);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaCodicePrescrittore (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
//Il codice prescrittore deve essere omesso se il codice tipo prescrittore è pari a 'Z’.
		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("campoDipendente","tipoPrescrittore");
		parametri.getParametriMap().put("valoreDipendente","Z");

		RegolaOmissioneCrossCampo regolaOmissioneCrossCampo = new RegolaOmissioneCrossCampo("regolaOmissioneCrossCampo","D17","Valorizzazione campo errato",parametri);

		regoleCampo.add(regolaOmissioneCrossCampo);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleTipoPrescrittore (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		/*Parametri parametriAnag = new Parametri();
		parametriAnag.getParametriMap().put("nomeTabella","??");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","D27","Codice non presente nel dominio di riferimento",parametriAnag);
*/
		regoleCampo.add(regolaObbligatorieta);
		//regoleCampo.add(regolaDominioValoriAnagrafica);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleDataPrescrizione (List<RegolaGenerica>  regoleCampo, String nomeCampo) {

		Parametri parametri= new Parametri();
		parametri.getParametriMap().put("regex","([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
		RegolaRegexCampoFacoltativo regolaRegexCampoFacoltativo = new RegolaRegexCampoFacoltativo("regolaRegexCampoFacoltativo","B20","Tipo di dato errato o formato data errato",parametri);

		regoleCampo.add(regolaRegexCampoFacoltativo);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleIdentificativoAssistito (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921", "Mancata valorizzazione di un campo obbligatorio",null);

		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("size","88");
		RegolaLunghezzaCampoObbligatorio regolaLunghezzaCampoObbligatorio = new RegolaLunghezzaCampoObbligatorio("regolaLunghezzaCampoObbligatorio","2043","Lunghezza diversa da quella attesa",parametri);

		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaLunghezzaCampoObbligatorio);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleValiditaCodIdentificativo (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametriValoriAmm = new Parametri();
		parametriValoriAmm.getParametriMap().put("listaValoriAmmessi","0|1");
		RegolaListaValoriAmmessi regolaListaValoriAmmessi = new RegolaListaValoriAmmessi("regolaListaValoriAmmessiCampo", "8001","Codice non presente nel dominio di riferimento",parametriValoriAmm);

		//aggiungo regole
		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaListaValoriAmmessi);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);

				
	}
	private static Campo creaRegoleTipoCodiceAssistito (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametriValoriAmm = new Parametri();
		parametriValoriAmm.getParametriMap().put("listaValoriAmmessi"," 0|1|2|3|4|97|98|99");
		RegolaListaValoriAmmessi regolaListaValoriAmmessi = new RegolaListaValoriAmmessi("regolaListaValoriAmmessiCampo", "8001","Codice non presente nel dominio di riferimento",parametriValoriAmm);

		//aggiungo regole
		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaListaValoriAmmessi);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleCittadinanza (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "2041", "Mancata valorizzazione di un campo obbligatorio",null);

		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("size","2");
		RegolaLunghezzaCampoObbligatorio regolaLunghezzaCampoObbligatorio = new RegolaLunghezzaCampoObbligatorio("regolaLunghezzaCampoObbligatorio","2043","Lunghezza diversa da quella attesa",parametri);

		/*Parametri parametriAnag = new Parametri();
		parametriAnag.getParametriMap().put("nomeTabella","???");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","D29","Codice non presente nel dominio di riferimento",parametriAnag);
*/
		Parametri parametriCross = new Parametri();
		parametriCross.getParametriMap().put("nomeCampoCoerente","tipologiaCodIdentAssistito");
		parametriCross.getParametriMap().put("listaValoriIncoerenti","1|2|3");

		RegolaEsistenzaDisuguaglianzaCrossCampo regolaEsistenzaDisuguaglianzaCrossCampo = new RegolaEsistenzaDisuguaglianzaCrossCampo("regolaEsistenzaDisuguaglianzaCrossCampo","2075","Cittadinanza incongruente con la Tipologia del codice identificativo assistito",parametriCross);

		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaLunghezzaCampoObbligatorio);
		//regoleCampo.add(regolaDominioValoriAnagrafica);
		regoleCampo.add(regolaEsistenzaDisuguaglianzaCrossCampo);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleAslResidenza (List<RegolaGenerica>  regoleCampo, String nomeCampo) {

		Parametri parametriLung = new Parametri();
		parametriLung.getParametriMap().put("size","6");
		RegolaLunghezzaCampoFacoltativo regolaLunghezzaCampoFacoltativo = new RegolaLunghezzaCampoFacoltativo("regolaLunghezzaCampoFacoltativo","1203","Lunghezza diversa da quella attesa",parametriLung);

		Parametri parametriAnag = new Parametri();
		parametriAnag.getParametriMap().put("nomeTabella","MRA");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","D30","Codice non presente nel dominio di riferimento",parametriAnag);

		Parametri parametriCross = new Parametri();
		parametriCross.getParametriMap().put("statoEsteroDiResidenza","IT");
		RegolaDiversitaValoreCrossCampoFacoltativo regolaDiversitaValoreCrossCampoFacoltativo = new RegolaDiversitaValoreCrossCampoFacoltativo("regolaDiversitaValoreCrossCampoFacoltativo","D30","Asl di Residenza incoerente con Stato Estero di Residenza",parametriCross);

		//TODO regola ASL Residenza	B30 mancante
		regoleCampo.add(regolaLunghezzaCampoFacoltativo);
		//regoleCampo.add(regolaDominioValoriAnagrafica);
		regoleCampo.add(regolaDiversitaValoreCrossCampoFacoltativo);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleStatoEsteroResidenza (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		Parametri parametri= new Parametri();
		parametri.getParametriMap().put("nomeTabella","???");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","B38","Codice non presente nel dominio di riferimento",parametri);

		regoleCampo.add(regolaDominioValoriAnagrafica);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleTipoEsenzione (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921", "Mancata valorizzazione di un campo obbligatorio",null);

		Parametri parametriValoriAmm = new Parametri();
		parametriValoriAmm.getParametriMap().put("nomeTabella","?????");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaListaValoriAmmessiCampo", "D23","Codice non presente nel dominio di riferimento",parametriValoriAmm);

		regoleCampo.add(regolaObbligatorieta);
		//regoleCampo.add(regolaDominioValoriAnagrafica);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	private static Campo creaRegoleCodiceEsenzione (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametri= new Parametri();
		parametri.getParametriMap().put("nomeTabella","???");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","D22","Codice non presente nel dominio di riferimento",parametri);

		regoleCampo.add(regolaObbligatorieta);
		//regoleCampo.add(regolaDominioValoriAnagrafica);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	private static Campo creaRegoleImportoQuotaFissaAssistito (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("size","5");
		RegolaLunghezzaCampoFacoltativo regolaLunghezzaCampoFacoltativo = new RegolaLunghezzaCampoFacoltativo("regolaLunghezzaFacoltativo", "2032","Lunghezza diversa da quella attesa", parametri);

		Parametri parametriReg= new Parametri();
		parametriReg.getParametriMap().put("regex","\\b\\d{1,3}\\.\\d{2}\\");
		RegolaRegexCampoFacoltativo regolaRegexCampoFacoltativo = new RegolaRegexCampoFacoltativo("regolaRegexCampoFacoltativo","3000","Tipo di dato errato o formato data errato",parametriReg);

		regoleCampo.add(regolaRegexCampoFacoltativo);
		regoleCampo.add(regolaLunghezzaCampoFacoltativo);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	
	private static Campo creaRegoleImportoCostoServizioRicetta (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("size","5");
		RegolaMaxLunghezzaCampoFacoltativo regolaMaxLunghezzaFacoltativo = new RegolaMaxLunghezzaCampoFacoltativo("regolaMaxLunghezzaFacoltativo", "2032","Lunghezza diversa da quella attesa", parametri);

		Parametri parametriReg= new Parametri();
		parametriReg.getParametriMap().put("regex","\\b\\d{1,3}\\.\\d{2}\\b");
		RegolaRegexCampoFacoltativo regolaRegexCampoFacoltativo = new RegolaRegexCampoFacoltativo("regolaRegexCampoFacoltativo","D38","Datatype errato",parametriReg);


		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaMaxLunghezzaFacoltativo);
		regoleCampo.add(regolaRegexCampoFacoltativo);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	
	private static Campo creaRegoleImportoQuotaPercentualeAssististo (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("size","5");
		RegolaMaxLunghezzaCampoFacoltativo regolaMaxLunghezzaFacoltativo = new RegolaMaxLunghezzaCampoFacoltativo("regolaMaxLunghezzaFacoltativo", "2032","Lunghezza diversa da quella attesa", parametri);

		Parametri parametriReg= new Parametri();
		parametriReg.getParametriMap().put("regex","\\b\\d{1,3}\\.\\d{2}\\b");
		RegolaRegexCampoFacoltativo regolaRegexCampoFacoltativo = new RegolaRegexCampoFacoltativo("regolaRegexCampoFacoltativo","3000","Datatype errato",parametriReg);

		regoleCampo.add(regolaMaxLunghezzaFacoltativo);
		regoleCampo.add(regolaRegexCampoFacoltativo);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	
	private static Campo creaRegoleImportoQuotaCostoServizio (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("size","7");
		RegolaMaxLunghezzaCampoFacoltativo regolaMaxLunghezzaFacoltativo = new RegolaMaxLunghezzaCampoFacoltativo("regolaMaxLunghezzaFacoltativo", "2032","Lunghezza diversa da quella attesa", parametri);

		Parametri parametriReg= new Parametri();
		parametriReg.getParametriMap().put("regex","\\b\\d{1,3}\\.\\d{2}\\b");
		RegolaRegexCampoFacoltativo regolaRegexCampoFacoltativo = new RegolaRegexCampoFacoltativo("regolaRegexCampoFacoltativo","B41","Datatype errato",parametriReg);


		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaMaxLunghezzaFacoltativo);
		regoleCampo.add(regolaRegexCampoFacoltativo);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	
	private static Campo creaRegoleTipoMedicinale (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);
		Parametri parametriValoriAmm = new Parametri();
		parametriValoriAmm.getParametriMap().put("listaValoriAmmessi"," 1|2|3|4|5|6");
		RegolaListaValoriAmmessi regolaListaValoriAmmessi = new RegolaListaValoriAmmessi("regolaListaValoriAmmessiCampo", "B14","Codice non presente nel dominio di riferimento",parametriValoriAmm);

		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaListaValoriAmmessi);


		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	
	private static Campo creaRegoleTargatura (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921", "\"Mancata valorizzazione di un campo obbligatorio\"",null);

		Parametri parametri= new Parametri();
		parametri.getParametriMap().put("nomeTabella","???");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","D41","Codice non presente nel dominio di riferimento",parametri);

		//regoleCampo.add(regolaDominioValoriAnagrafica);

		regoleCampo.add(regolaObbligatorieta);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	
	private static Campo creaRegoleCostoAcquisto (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("maxLunghezza","14");
		RegolaMaxLunghezzaCampoObbligatorio regolaLunghezza = new RegolaMaxLunghezzaCampoObbligatorio("regolaMaxLunghezzaCampoObbligatorio", "2032", "Lunghezza diversa da quella attesa",parametri);


		Parametri parametriReg = new Parametri();
		parametriReg.getParametriMap().put("regex","\\b\\d{1,8}\\.\\d{2,5}\\b");
		RegolaRegex regolaRegex = new RegolaRegex("regolaRegex", "B41","Tipo di dato errato o formato data errato",parametriReg);



		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaLunghezza);
		regoleCampo.add(regolaRegex);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	
	private static Campo creaRegoleQuantita (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);


		regoleCampo.add(regolaObbligatorieta);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	private static Campo creaRegoleFattoreConversione (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("maxLunghezza","6");
		RegolaMaxLunghezzaCampoObbligatorio regolaLunghezza = new RegolaMaxLunghezzaCampoObbligatorio("regolaMaxLunghezzaCampoObbligatorio", "2032", "Lunghezza diversa da quella attesa",parametri);


		Parametri parametriReg = new Parametri();
		parametriReg.getParametriMap().put("regex","\\b\\d{1,6}[\\.]*\\d{0,2}\\b");
		RegolaRegex regolaRegex = new RegolaRegex("regolaRegex", "3000","Tipo di dato errato o formato data errato",parametriReg);



		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaLunghezza);
		regoleCampo.add(regolaRegex);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}
	
	private static Campo creaRegoleTipoOperazione (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921", "Mancata valorizzazione di un campo obbligatorio",null);


		Parametri parametri = new Parametri();
		parametri.getParametriMap().put("listaValoriAmmessi","i,I,c,C,v,V");
		RegolaListaValoriAmmessi regolaListaValoriAmmessi = new RegolaListaValoriAmmessi("regolaListaValoriAmmessi","B05","Codice non presente nel dominio di riferimento",parametri);

		regoleCampo.add(regolaObbligatorieta);
		regoleCampo.add(regolaListaValoriAmmessi);

		// creo campo
		return new Campo(regoleCampo, nomeCampo);
				
	}

	private static Campo creaRegoleCodiceIstituzioneCompetente (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
	//TODO non trovo regole

		// creo campo
		return new Campo(regoleCampo, nomeCampo);

	}

	private static Campo creaRegoleCodiceMedicinale (List<RegolaGenerica>  regoleCampo, String nomeCampo) {
		RegolaObbligatorieta regolaObbligatorieta = new RegolaObbligatorieta("obbligatorieta", "1921","Mancata valorizzazione di un campo obbligatorio", null);

		Parametri parametri= new Parametri();
		parametri.getParametriMap().put("nomeTabella","???");
		RegolaDominioValoriAnagrafica regolaDominioValoriAnagrafica = new RegolaDominioValoriAnagrafica("regolaDominioValoriAnagrafica","D47","Codice non presente nel dominio di riferimento",parametri);


		regoleCampo.add(regolaObbligatorieta);
		//regoleCampo.add(regolaDominioValoriAnagrafica);
		// creo campo
		return new Campo(regoleCampo, nomeCampo);

	}
	

	
}
