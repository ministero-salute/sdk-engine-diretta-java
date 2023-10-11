package it.mds.sdk.flusso.dir.tracciato;

import it.mds.sdk.flusso.dir.parser.regole.RecordDtoDir;
import it.mds.sdk.flusso.dir.parser.regole.conf.ConfigurazioneFlussoDir;
import it.mds.sdk.flusso.dir.tracciato.bean.output.Dataroot;
import it.mds.sdk.gestorefile.GestoreFile;
import it.mds.sdk.gestorefile.factory.GestoreFileFactory;
import it.mds.sdk.libreriaregole.tracciato.TracciatoSplitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URL;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component("tracciatoSplitter")
public class TracciatoSplitterImpl implements TracciatoSplitter<RecordDtoDir> {

    private static final String XML_FILENAME_TEMPLATE = "SDK_DIR_IF3_%s_%s.xml" ;
    @Override
    //TODO probabilmente va eliminato
    public List<Path> dividiTracciato(Path tracciato) {
        return Collections.emptyList();
    }

    @Override
    public List<Path> dividiTracciato(List<RecordDtoDir> records, String idRun) {

        ConfigurazioneFlussoDir conf = new ConfigurazioneFlussoDir();
        String fileName = String.format(XML_FILENAME_TEMPLATE,records.get(0).getCampiInput().getPeriodoRiferimentoInput(), idRun);
        Path xml = Path.of(conf.getXmlOutput().getPercorso(),fileName);

        try {
            Dataroot dataRoot = new Dataroot();
            //imposto la regione che è unica per il file
            Dataroot.REGIONE regione = creaRegione(records.get(0).getRegioneErogante());
            //imposto il periodo che è unico per il file
            Dataroot.REGIONE.PERIODO periodo = creaPeriodo(records.get(0).getAnnoDiRiferimento(), records.get(0).getMeseDiRiferimento());
            regione.setPERIODO(periodo);
            dataRoot.setREGIONE(regione);
            for (RecordDtoDir r : records) {
                Dataroot.REGIONE.PERIODO.ASL currentAsl = dataRoot.getREGIONE().getPERIODO().getASL()
                        .stream()
                        .filter(asl -> r.getCodiceAziendaSanitariaErogante().equalsIgnoreCase(asl.getCodAsl()))
                        .findFirst()
                        .orElse(null);
                if (currentAsl == null) {
                    currentAsl = creaAsl(r.getCodiceAziendaSanitariaErogante());
                    dataRoot.getREGIONE().getPERIODO().getASL().add(currentAsl);

                }

                //controllo erogatore
                Dataroot.REGIONE.PERIODO.ASL.EROGATORE currentErogatore = currentAsl.getEROGATORE()
                        .stream()
                        .filter(er -> r.getCodiceStrutturaErogante().equalsIgnoreCase(er.getIdEr()) &&
                                r.getTipoErogatore().equalsIgnoreCase(er.getTipoEr()) &&
                                ((r.getTipoStrutturaErogante() == null && er.getTipoStr() == null) || (r.getTipoStrutturaErogante() != null && r.getTipoStrutturaErogante().equalsIgnoreCase(er.getTipoStr())))
                        )
                        .findFirst()
                        .orElse(null);
                if (currentErogatore == null) {
                    currentErogatore = creaErogatore(r.getCodiceStrutturaErogante(), r.getTipoErogatore(), r.getTipoStrutturaErogante());
                    currentAsl.getEROGATORE().add(currentErogatore);
                }
                //controllo Assistito
                Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO currentAssistito = currentErogatore.getASSISTITO()
                        .stream()
                        .filter(idAss -> r.getIdentificativoAssistito().equalsIgnoreCase(idAss.getIdAss()) &&
                                (idAss.getVldIdAss() == null || (r.getValiditaCodIdentAssistito() != null && String.valueOf(r.getValiditaCodIdentAssistito()).equalsIgnoreCase(idAss.getVldIdAss()))) &&
                                (idAss.getTipIdAss() == null || (r.getTipologiaCodIdentAssistito() != null && String.valueOf(r.getTipologiaCodIdentAssistito()).equalsIgnoreCase(idAss.getTipIdAss()))) &&
                                (idAss.getDatNasc() == null || (r.getDataNascitaAssistito() != null && r.getDataNascitaAssistito().equalsIgnoreCase(String.valueOf(idAss.getDatNasc())))) &&
                                (idAss.getSesso() == null || (r.getSessoAssistito() != null && r.getSessoAssistito().equalsIgnoreCase(idAss.getSesso()))) &&
                                (idAss.getCodAslAss() == null || (r.getAslAssistito() != null && r.getAslAssistito().equalsIgnoreCase(idAss.getCodAslAss()))) &&
                                (idAss.getCitt() == null || (r.getCittadinanza() != null && r.getCittadinanza().equalsIgnoreCase(idAss.getCitt()))))
                        .findFirst()
                        .orElse(null);
                if (currentAssistito == null) {
                    currentAssistito = creaAssistito(r);
                    currentErogatore.getASSISTITO().add(currentAssistito);
                }

                //controllo operazione
                Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE currentOperazione = currentAssistito.getOPERAZIONE()
                        .stream()
                        .filter(op -> r.getTipoOperazione().equalsIgnoreCase(op.getTipoOp()))
                        .findFirst()
                        .orElse(null);
                if (currentOperazione == null) {
                    currentOperazione = creaOperazione(r);
                    currentAssistito.getOPERAZIONE().add(currentOperazione);
                }

                //controllo prescrizione
                Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE currentPrescrizione = currentOperazione.getPRESCRIZIONE()
                        .stream()
                        .filter(pr -> r.getIdContatto().trim().equalsIgnoreCase(pr.getIdCont().trim()) &&
                                r.getTipoContatto().equalsIgnoreCase(pr.getTipoCont()) &&
                                r.getDataErogazione().equalsIgnoreCase(String.valueOf(pr.getDatErog())) &&
                                (pr.getTipoEsen() == null || (r.getTipoDiEsenzione().equalsIgnoreCase(pr.getTipoEsen()))) &&
                                r.getTipoErogazione().equalsIgnoreCase(pr.getTipoErog()) &&
                                r.getTipoCanale().equalsIgnoreCase(pr.getTipoCanale()) &&
                                (pr.getQuotaFissaAss() == null || (r.getQuotaFissaAssistito().equalsIgnoreCase(pr.getQuotaFissaAss()))) &&
                                (pr.getQuotaPercAss() == null || (r.getQuotaPercentualeAssistito().equalsIgnoreCase(pr.getQuotaPercAss()))) &&
                                (pr.getDatPres() == null || (r.getDataPrescrizione().equalsIgnoreCase(String.valueOf(pr.getDatPres())))) &&
                                (pr.getCostoSrvRic() == null || (r.getCostoServizioRicetta().equalsIgnoreCase(pr.getCostoSrvRic()))))
                        .findFirst()
                        .orElse(null);
                if (currentPrescrizione == null) {
                    currentPrescrizione = creaPrescrizione(r);
                    currentOperazione.getPRESCRIZIONE().add(currentPrescrizione);
                }
                //prescrittore 1 occorrenza sempre per prescrizione
                //la creo e la aggiungo
                Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE.PRESCRITTORE currentPrescrittore = creaPrescrittore(r);
                currentPrescrizione.setPRESCRITTORE(currentPrescrittore);

                //Farmaco
                currentPrescrizione.getFARMACO().add(creaFarmaco(r));
            }

            GestoreFile gestoreFile = GestoreFileFactory.getGestoreFile("XML");
            URL urlXsd = this.getClass().getClassLoader().getResource("diretta.xsd");
            log.debug("URL dell'XSD per la validazione idrun {} : {}", idRun, urlXsd);

            //gestoreFile.scriviDto(dataRoot,
                    //conf.getXmlOutput().getPercorso() + "SDK_DIR_IF3_" + records.get(0).getCampiInput()
            // .getPeriodoRiferimentoInput() + "_" + idRun + ".xml", urlXsd);
            return List.of(xml);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            log.error("[{}].dividiTracciato  - records[{}]  - idRun[{}] -" + e.getMessage(),
                    this.getClass().getName(),
                    e
            );
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Impossibile validare il csv in ingresso. message: " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private Dataroot.REGIONE creaRegione(String codiceRegione) {
        Dataroot.REGIONE regioneEr = new Dataroot.REGIONE();
        regioneEr.setCodReg(codiceRegione);
        return regioneEr;
    }

    private Dataroot.REGIONE.PERIODO creaPeriodo(String anno, String mese) {
        Dataroot.REGIONE.PERIODO periodo = new Dataroot.REGIONE.PERIODO();
        periodo.setAnno(anno);
        periodo.setMese(mese);
        return periodo;
    }

    private Dataroot.REGIONE.PERIODO.ASL creaAsl(String codAsl) {
        Dataroot.REGIONE.PERIODO.ASL asl = new Dataroot.REGIONE.PERIODO.ASL();
        asl.setCodAsl(codAsl);
        return asl;
    }

    private Dataroot.REGIONE.PERIODO.ASL.EROGATORE creaErogatore(String idEr, String tipoEr, String tipo_str) {
        Dataroot.REGIONE.PERIODO.ASL.EROGATORE erogatore = new Dataroot.REGIONE.PERIODO.ASL.EROGATORE();
        erogatore.setIdEr(idEr);
        erogatore.setTipoEr(tipoEr);
        erogatore.setTipoStr(tipo_str);
        return erogatore;
    }

    private Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO creaAssistito(RecordDtoDir recordDtoDir) {
        Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO assistito = new Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO();
        try {
            assistito.setIdAss(recordDtoDir.getIdentificativoAssistito());
            assistito.setCitt(recordDtoDir.getCittadinanza());
            assistito.setStatEst(recordDtoDir.getStatoEsteroDiResidenza());
            assistito.setCodIstComp(recordDtoDir.getCodiceIstituzioneCompetente());
            assistito.setCodAslAss(recordDtoDir.getAslAssistito());
            assistito.setSesso(recordDtoDir.getSessoAssistito());
            XMLGregorianCalendar dataNascXml = recordDtoDir.getDataNascitaAssistito() != null ? DatatypeFactory.newInstance().newXMLGregorianCalendar(recordDtoDir.getDataNascitaAssistito()) : null;
            assistito.setDatNasc(dataNascXml);
            assistito.setTipIdAss(String.valueOf(recordDtoDir.getTipologiaCodIdentAssistito()));
            assistito.setVldIdAss(String.valueOf(recordDtoDir.getValiditaCodIdentAssistito()));
        } catch (DatatypeConfigurationException e) {
            log.debug(e.getMessage(), e);
        }
        return assistito;
    }

    private Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE creaOperazione(RecordDtoDir recordDtoDir) {
        Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE operazione = new Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE();
        operazione.setTipoOp(recordDtoDir.getTipoOperazione());
        return operazione;
    }

    private Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE creaPrescrizione(RecordDtoDir recordDtoDir) {
        Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE prescrizione = new Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE();
        try {
            prescrizione.setCostoSrvRic(recordDtoDir.getCostoServizioRicetta());
            XMLGregorianCalendar datPresXMl = recordDtoDir.getDataPrescrizione() != null ? DatatypeFactory.newInstance().newXMLGregorianCalendar(recordDtoDir.getDataPrescrizione()) : null;
            prescrizione.setDatPres(datPresXMl);
            prescrizione.setTipoCanale(recordDtoDir.getTipoCanale());
            prescrizione.setCodEsen(recordDtoDir.getCodiceEsenzione());
            prescrizione.setTipoErog(recordDtoDir.getTipoErogazione());
            prescrizione.setTipoEsen(recordDtoDir.getTipoDiEsenzione());
            XMLGregorianCalendar datErogXMl = recordDtoDir.getDataErogazione() != null ? DatatypeFactory.newInstance().newXMLGregorianCalendar(recordDtoDir.getDataErogazione()) : null;
            prescrizione.setDatErog(datErogXMl);
            prescrizione.setIdCont(recordDtoDir.getIdContatto());
            prescrizione.setTipoCont(recordDtoDir.getTipoContatto());
            prescrizione.setQuotaFissaAss(recordDtoDir.getQuotaFissaAssistito());
            prescrizione.setQuotaPercAss(recordDtoDir.getQuotaPercentualeAssistito());
        } catch (DatatypeConfigurationException e) {
            log.debug(e.getMessage(), e);
        }
        return prescrizione;
    }

    private Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE.PRESCRITTORE creaPrescrittore(RecordDtoDir recordDtoDir) {
        Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE.PRESCRITTORE prescrittore = new Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE.PRESCRITTORE();
        prescrittore.setCodPr(recordDtoDir.getCodicePrescrittore());
        prescrittore.setTipoPr(recordDtoDir.getTipoPrescrittore());
        return prescrittore;
    }

    private Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE.FARMACO creaFarmaco(RecordDtoDir recordDtoDir) {
        Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE.FARMACO farmaco = new Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE.FARMACO();
        farmaco.setCodF(recordDtoDir.getCodiceFarmaco());
        farmaco.setTipoF(recordDtoDir.getTipoFarmaco());
        farmaco.setTargatura(recordDtoDir.getTargatura());
        farmaco.setCostoAcq(recordDtoDir.getCostoAcquisto());
        farmaco.setQta(recordDtoDir.getQuantita());
        farmaco.setFattConv(Integer.parseInt(recordDtoDir.getFattoreDiConversione()));
        farmaco.setCostoSrv(recordDtoDir.getCostoServizio());
        return farmaco;
    }

    public Dataroot creaDataroot(List<RecordDtoDir> records, Dataroot dataRoot) {
        if (dataRoot == null) {
            dataRoot = new Dataroot();
            //imposto la regione che è unica per il file
            Dataroot.REGIONE regione = creaRegione(records.get(0).getRegioneErogante());
            //imposto il periodo che è unico per il file
            Dataroot.REGIONE.PERIODO periodo = creaPeriodo(records.get(0).getAnnoDiRiferimento(), records.get(0).getMeseDiRiferimento());
            regione.setPERIODO(periodo);
            dataRoot.setREGIONE(regione);
        }
        for (RecordDtoDir r : records) {
            Dataroot.REGIONE.PERIODO.ASL currentAsl = dataRoot.getREGIONE().getPERIODO().getASL()
                    .stream()
                    .filter(asl -> r.getCodiceAziendaSanitariaErogante().equalsIgnoreCase(asl.getCodAsl()))
                    .findFirst()
                    .orElse(null);
            if (currentAsl == null) {
                currentAsl = creaAsl(r.getCodiceAziendaSanitariaErogante());
                dataRoot.getREGIONE().getPERIODO().getASL().add(currentAsl);

            }

            //controllo erogatore
            Dataroot.REGIONE.PERIODO.ASL.EROGATORE currentErogatore = currentAsl.getEROGATORE()
                    .stream()
                    .filter(er -> r.getCodiceStrutturaErogante().equalsIgnoreCase(er.getIdEr()) &&
                            r.getTipoErogatore().equalsIgnoreCase(er.getTipoEr()) &&
                            ((r.getTipoStrutturaErogante() == null && er.getTipoStr() == null) || (r.getTipoStrutturaErogante() != null && r.getTipoStrutturaErogante().equalsIgnoreCase(er.getTipoStr())))
                    )
                    .findFirst()
                    .orElse(null);
            if (currentErogatore == null) {
                currentErogatore = creaErogatore(r.getCodiceStrutturaErogante(), r.getTipoErogatore(), r.getTipoStrutturaErogante());
                currentAsl.getEROGATORE().add(currentErogatore);
            }
            //controllo Assistito
            Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO currentAssistito = currentErogatore.getASSISTITO()
                    .stream()
                    .filter(idAss -> r.getIdentificativoAssistito().equalsIgnoreCase(idAss.getIdAss()) &&
                            (idAss.getVldIdAss() == null || (r.getValiditaCodIdentAssistito() != null && String.valueOf(r.getValiditaCodIdentAssistito()).equalsIgnoreCase(idAss.getVldIdAss()))) &&
                            (idAss.getTipIdAss() == null || (r.getTipologiaCodIdentAssistito() != null && String.valueOf(r.getTipologiaCodIdentAssistito()).equalsIgnoreCase(idAss.getTipIdAss()))) &&
                            (idAss.getDatNasc() == null || (r.getDataNascitaAssistito() != null && r.getDataNascitaAssistito().equalsIgnoreCase(String.valueOf(idAss.getDatNasc())))) &&
                            (idAss.getSesso() == null || (r.getSessoAssistito() != null && r.getSessoAssistito().equalsIgnoreCase(idAss.getSesso()))) &&
                            (idAss.getCodAslAss() == null || (r.getAslAssistito() != null && r.getAslAssistito().equalsIgnoreCase(idAss.getCodAslAss()))) &&
                            (idAss.getCitt() == null || (r.getCittadinanza() != null && r.getCittadinanza().equalsIgnoreCase(idAss.getCitt()))))
                    .findFirst()
                    .orElse(null);
            if (currentAssistito == null) {
                currentAssistito = creaAssistito(r);
                currentErogatore.getASSISTITO().add(currentAssistito);
            }

            //controllo operazione
            Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE currentOperazione = currentAssistito.getOPERAZIONE()
                    .stream()
                    .filter(op -> r.getTipoOperazione().equalsIgnoreCase(op.getTipoOp()))
                    .findFirst()
                    .orElse(null);
            if (currentOperazione == null) {
                currentOperazione = creaOperazione(r);
                currentAssistito.getOPERAZIONE().add(currentOperazione);
            }

            //controllo prescrizione
            Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE currentPrescrizione = currentOperazione.getPRESCRIZIONE()
                    .stream()
                    .filter(pr -> r.getIdContatto().trim().equalsIgnoreCase(pr.getIdCont().trim()) &&
                            r.getTipoContatto().equalsIgnoreCase(pr.getTipoCont()) &&
                            r.getDataErogazione().equalsIgnoreCase(String.valueOf(pr.getDatErog())) &&
                            (pr.getTipoEsen() == null || (r.getTipoDiEsenzione().equalsIgnoreCase(pr.getTipoEsen()))) &&
                            r.getTipoErogazione().equalsIgnoreCase(pr.getTipoErog()) &&
                            r.getTipoCanale().equalsIgnoreCase(pr.getTipoCanale()) &&
                            (pr.getQuotaFissaAss() == null || (r.getQuotaFissaAssistito().equalsIgnoreCase(pr.getQuotaFissaAss()))) &&
                            (pr.getQuotaPercAss() == null || (r.getQuotaPercentualeAssistito().equalsIgnoreCase(pr.getQuotaPercAss()))) &&
                            (pr.getDatPres() == null || (r.getDataPrescrizione().equalsIgnoreCase(String.valueOf(pr.getDatPres())))) &&
                            (pr.getCostoSrvRic() == null || (r.getCostoServizioRicetta().equalsIgnoreCase(pr.getCostoSrvRic()))))
                    .findFirst()
                    .orElse(null);
            if (currentPrescrizione == null) {
                currentPrescrizione = creaPrescrizione(r);
                currentOperazione.getPRESCRIZIONE().add(currentPrescrizione);
            }
            //prescrittore 1 occorrenza sempre per prescrizione
            //la creo e la aggiungo
            Dataroot.REGIONE.PERIODO.ASL.EROGATORE.ASSISTITO.OPERAZIONE.PRESCRIZIONE.PRESCRITTORE currentPrescrittore = creaPrescrittore(r);
            currentPrescrizione.setPRESCRITTORE(currentPrescrittore);

            //Farmaco
            currentPrescrizione.getFARMACO().add(creaFarmaco(r));
        }
        return dataRoot;
    }
}
