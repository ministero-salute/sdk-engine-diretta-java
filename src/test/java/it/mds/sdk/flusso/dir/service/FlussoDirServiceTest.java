/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.dir.service;

import it.mds.sdk.connettoremds.ConnettoreMds;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import it.mds.sdk.connettoremds.gaf.webservices.bean.ArrayOfUploadEsito;
import it.mds.sdk.connettoremds.gaf.webservices.bean.ResponseUploadFile;
import it.mds.sdk.flusso.dir.parser.regole.ParserTracciatoImpl;
import it.mds.sdk.flusso.dir.parser.regole.RecordDtoDir;
import it.mds.sdk.flusso.dir.parser.regole.conf.ConfigurazioneFlussoDir;
import it.mds.sdk.flusso.dir.service.FlussoDirService;

import it.mds.sdk.flusso.dir.tracciato.TracciatoSplitterImpl;
import it.mds.sdk.flusso.dir.tracciato.bean.output.Dataroot;
import it.mds.sdk.gestoreesiti.GestoreRunLog;
import it.mds.sdk.gestoreesiti.modelli.Esito;
import it.mds.sdk.gestoreesiti.modelli.InfoRun;
import it.mds.sdk.gestoreesiti.modelli.ModalitaOperativa;
import it.mds.sdk.gestorefile.GestoreFile;

import it.mds.sdk.gestorefile.exception.XSDNonSupportedException;
import it.mds.sdk.gestorefile.factory.GestoreFileFactory;
import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import it.mds.sdk.libreriaregole.gestorevalidazione.BloccoValidazione;
import it.mds.sdk.libreriaregole.gestorevalidazione.GestoreValidazione;
import it.mds.sdk.libreriaregole.regole.beans.Campo;
import it.mds.sdk.libreriaregole.regole.beans.Parametri;
import it.mds.sdk.libreriaregole.regole.beans.RegolaGenerica;
import it.mds.sdk.libreriaregole.regole.beans.RegoleFlusso;
import it.mds.sdk.libreriaregole.regole.catalogo.input.RegolaCheckCampiInput;
import it.mds.sdk.libreriaregole.validator.ValidationEngine;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.InputStream;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class FlussoDirServiceTest {

    @Autowired
    ConfigurazioneFlussoDir configurazioneFlusso;

    ParserTracciatoImpl parser = Mockito.mock(ParserTracciatoImpl.class);;
    @InjectMocks
    @Spy
    private FlussoDirService flussoDirService;
    @Mock
    private RegoleFlusso regoleFlusso;
    @Spy
    private ConfigurazioneFlussoDir conf;

    private TracciatoSplitterImpl tracciatoSplitter = Mockito.mock(TracciatoSplitterImpl.class);


    private GestoreFile gestoreFileInt2 = Mockito.mock(GestoreFile.class);

    private GestoreFile gestoreFileInt = Mockito.mock(GestoreFile.class);

    private ConnettoreMds connettoreMds = Mockito.mock(ConnettoreMds.class);
  //  private GestoreRunLog gestoreRunLog;

    private GestoreRunLog grl = Mockito.mock(GestoreRunLog.class);
//    @Mock
    private ValidationEngine validationEngine = Mockito.mock(ValidationEngine.class);;

    private GestoreValidazione  gestoreValidazione = Mockito.mock(GestoreValidazione.class);

    private String idRun = "928";
    private final String OSP_ACN_CSV = "OSP_ACN.csv";
    private final int dimensioneBlocco = 250000;
    private final String idClient = "";
    private final String periodoRiferimento = "13";
    private final String annoRfierimento = "2022";
    private final String codiceRegione = "080";
    private BloccoValidazione bloccoValidazione;
    File file;

    RecordDtoDir recordDtoDir;

    ConfigurazioneFlussoDir configurazioneFlussoDir;

    MockedStatic<GestoreFileFactory> utilities;

    InfoRun infoRun;

    /*
      TODO:
       **************** ATTENZIONE ******************
       Prima di lanciare i test assicurarsi
       di aver settato correttamente i parametri
       nel file di properties.
       **********************************************
     */

    @BeforeEach
    void init() {
        log.warn("\n*** ATTENZIONE ***\n" +
                "ATTENZIONE: I test runnati necessitano di proprietà settate nel file di properties.\n " +
                "Non settare le proprietà potrebbe causare il fallimento di alcuni test.\n" +
                "******************\n"
        );
        MockitoAnnotations.openMocks(this);
        // Create Parametri

        Properties prop = loadPropertiesFromFile("config-flusso-dir-test.properties");
        this.idRun = prop.getProperty("test.idrun");

        Map<String, String> parametriMap = new HashMap<>();
        parametriMap.put("parametroInput", "codiceRegioneInput");
        Parametri parametri = new Parametri();
        parametri.setParametriMap(parametriMap);
        // Create RegolaGenerica
        RegolaGenerica regolaGenerica = new RegolaCheckCampiInput();
        regolaGenerica.setCodErrore("B01");
        regolaGenerica.setDesErrore("Non appartenenza al dominio di riferimento");
        regolaGenerica.setParametri(parametri);
        // Create Campo
        Campo campo = new Campo(List.of(regolaGenerica), "codiceRegione");
        // Creazione RegoleFlusso
        regoleFlusso = new RegoleFlusso(List.of(campo));
    //    gestoreRunLog = new GestoreRunLog(new GestoreFileCSVImpl(), Progressivo.creaProgressivo(Progressivo.Fonte.FILE));

        recordDtoDir = new RecordDtoDir();

        bloccoValidazione = new BloccoValidazione();
        bloccoValidazione.setNumeroRecord(2);
        bloccoValidazione.setScartati(1);

        file = new File(conf.getFlusso().getPercorso() + "OSP_ACN.csv");

        configurazioneFlussoDir = new ConfigurazioneFlussoDir();

        infoRun = new InfoRun(
                null, null, null, null, null,
                null, null, null, null, null, null,
                1, 1, 1, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null
        );
    }

    @Test
    void validazioneBlocchiTestModalitaT_KO() {

        when(spy(conf.getFlusso())).thenReturn(configurazioneFlusso.getFlusso());
        when(conf.getXmlOutput()).thenReturn(configurazioneFlusso.getXmlOutput());
        List<RecordDtoGenerico> list = List.of(recordDtoDir);
        given(parser.parseTracciatoBlocco(any(), anyInt(), anyInt())).willReturn(list);
        Dataroot dataroot = new Dataroot();
        Dataroot.REGIONE regione = new Dataroot.REGIONE();
        regione.setCodReg(codiceRegione);
        dataroot.setREGIONE(regione);
        given(tracciatoSplitter.creaDataroot(any(), any())).willReturn(dataroot);

        //doThrow(new XSDNonSupportedException()).when(gestoreFile).scriviDtoFragment(eq(null), any(), any());

        willThrow(new XSDNonSupportedException()).given(gestoreFileInt).scriviDtoFragment(any(), any(), any());
        //  given(gestoreFile.scriviDtoFragment(eq(null), any(), any()).
       // given(grl.cambiaStatoRun(any(), any())).willReturn(infoRun);
        bloccoValidazione.setRecordList(List.of(recordDtoDir));

        given(validationEngine.startValidaFlussoBlocco(anyList(), any(), anyString(), any(), anyInt())).willReturn(bloccoValidazione);
        given(validationEngine.formatJsonEsiti(any(), any())).willReturn(true);
        //  given(validationEngine.puliziaFile(any(), any(), any())).willReturn("mocked_filename");
        given(validationEngine.formatXmlOutput(any(), any(), any())).willReturn(false);

        given(grl.getRun(any())).willReturn(infoRun);
        given(grl.cambiaStatoRun(any(), any())).willReturn(infoRun);
        given(grl.updateRun(any())).willReturn(infoRun);


        this.flussoDirService.validazioneBlocchi(
                        dimensioneBlocco,
                        OSP_ACN_CSV,
                        regoleFlusso,
                        idRun,
                        idClient,
                        ModalitaOperativa.T,
                        periodoRiferimento,
                        annoRfierimento,
                        codiceRegione,
                        grl
        );
    }

    @Test
    void validazioneBlocchiTestModalitaT_OK() {

        ConfigurazioneFlussoDir configurazioneFlussoDir = new ConfigurazioneFlussoDir();
        when(spy(conf.getFlusso())).thenReturn(configurazioneFlusso.getFlusso());
        when(conf.getXmlOutput()).thenReturn(configurazioneFlussoDir.getXmlOutput());
        List<RecordDtoGenerico> list = List.of(recordDtoDir);
        given(parser.parseTracciatoBlocco(any(), anyInt(), anyInt())).willReturn(list);

        bloccoValidazione.setRecordList(Collections.emptyList());

        given(validationEngine.startValidaFlussoBlocco(anyList(), any(), anyString(), any(), anyInt())).willReturn(bloccoValidazione);
        given(validationEngine.formatJsonEsiti(any(), any())).willReturn(true);
        given(validationEngine.puliziaFileDataroot(any(), any(), any())).willReturn("mocked_filename");

        given(grl.getRun(any())).willReturn(infoRun);
        given(grl.cambiaStatoRun(any(), any())).willReturn(infoRun);
        given(grl.updateRun(any())).willReturn(infoRun);
      //  doReturn(infoRun).when(gestoreRunLog).updateRun(any());

        this.flussoDirService.validazioneBlocchi(
                dimensioneBlocco,
                OSP_ACN_CSV,
                regoleFlusso,
                idRun,
                idClient,
                ModalitaOperativa.T,
                periodoRiferimento,
                annoRfierimento,
                codiceRegione,
                grl
        );
    }

    @Test
    void inviaTracciatoMdsTest_KOMinistero() throws ConnettoreMdsException {
        String nomeFileXml = conf.getXmlOutput().getPercorso() + "SDK_DIR_IF3_" + periodoRiferimento + "_" + idRun +
                ".xml";
        given(grl.getRun(any())).willReturn(infoRun);
        ResponseUploadFile responseUploadFile = new ResponseUploadFile();
        responseUploadFile.setErrorCode("x");
        given(connettoreMds.invioTracciati(any(), any(), any(), any(), any())).willReturn(responseUploadFile);
        given(grl.cambiaStatoRun(any(), any())).willReturn(infoRun);
        flussoDirService.inviaTracciatoMds(
                idRun,
                nomeFileXml,
                grl,
                periodoRiferimento,
                annoRfierimento
        );
    }
    @Test
    void inviaTracciatoMdsTest_ErrorCodeNull() throws ConnettoreMdsException {
        String nomeFileXml = conf.getXmlOutput().getPercorso() + "SDK_DIR_IF3_" + periodoRiferimento + "_" + idRun +
                ".xml";
        given(grl.getRun(any())).willReturn(infoRun);
        ResponseUploadFile responseUploadFile = new ResponseUploadFile();
        responseUploadFile.setErrorCode(null);
        given(connettoreMds.invioTracciati(any(), any(), any(), any(), any())).willReturn(responseUploadFile);
        given(grl.cambiaStatoRun(any(), any())).willReturn(infoRun);
        flussoDirService.inviaTracciatoMds(
                idRun,
                nomeFileXml,
                grl,
                periodoRiferimento,
                annoRfierimento
        );
    }

    @Test
    void inviaTracciatoMdsTest_ListaEsitiNotNull() throws ConnettoreMdsException {
        String nomeFileXml = conf.getXmlOutput().getPercorso() + "SDK_DIR_IF3_" + periodoRiferimento + "_" + idRun +
                ".xml";
        given(grl.getRun(any())).willReturn(infoRun);
        ResponseUploadFile responseUploadFile = new ResponseUploadFile();
        ArrayOfUploadEsito arr = Mockito.mock(ArrayOfUploadEsito.class);

        responseUploadFile.setListaEsitiUpload(arr);
        responseUploadFile.setErrorCode(null);
        given(connettoreMds.invioTracciati(any(), any(), any(), any(), any())).willReturn(responseUploadFile);
        given(grl.cambiaStatoRun(any(), any())).willReturn(infoRun);
        flussoDirService.inviaTracciatoMds(
                idRun,
                nomeFileXml,
                grl,
                periodoRiferimento,
                annoRfierimento
        );
    }

    @Test
    void startValidaRecordTestOK(){
        List<Esito> esitiList = new ArrayList<>();
        given(gestoreValidazione.gestioneValidazioneRecord(any(), any(), any())).willReturn(esitiList);
        Assertions.assertEquals(flussoDirService.startValidaRecord(
                recordDtoDir,
                regoleFlusso,
                idRun,
                idClient,
                ModalitaOperativa.P
        ), esitiList);
    }

    @Test
    void validazioneBlocchiTestModalitaP_OK() {

        ConfigurazioneFlussoDir configurazioneFlussoDir = new ConfigurazioneFlussoDir();
        when(spy(conf.getFlusso())).thenReturn(configurazioneFlusso.getFlusso());
        when(conf.getXmlOutput()).thenReturn(configurazioneFlussoDir.getXmlOutput());
        List<RecordDtoGenerico> list = List.of(recordDtoDir);
        given(parser.parseTracciatoBlocco(any(), anyInt(), anyInt())).willReturn(list);

        bloccoValidazione.setRecordList(List.of(recordDtoDir));

        given(validationEngine.startValidaFlussoBlocco(anyList(), any(), anyString(), any(), anyInt())).willReturn(bloccoValidazione);
        given(validationEngine.formatJsonEsiti(any(), any())).willReturn(true);
        given(validationEngine.puliziaFileDataroot(any(), any(), any())).willReturn("mocked_filename");

        willDoNothing().given(flussoDirService).inviaTracciatoMds(any(), any(), any(), any(), any());

        Dataroot dataroot = new Dataroot();
        Dataroot.REGIONE regione = new Dataroot.REGIONE();
        regione.setCodReg(codiceRegione);
        dataroot.setREGIONE(regione);
        utilities = mockStatic(GestoreFileFactory.class);

        given(tracciatoSplitter.creaDataroot(any(), any())).willReturn(dataroot);
        utilities.when(()->GestoreFileFactory.getGestoreFile("XML")).thenReturn(gestoreFileInt2);

        willDoNothing().given(gestoreFileInt2).scriviDtoFragment(eq(dataroot), any(), any());

        given(grl.getRun(any())).willReturn(infoRun);
        given(grl.cambiaStatoRun(any(), any())).willReturn(infoRun);
        given(grl.updateRun(any())).willReturn(infoRun);

        this.flussoDirService.validazioneBlocchi(
                dimensioneBlocco,
                OSP_ACN_CSV,
                regoleFlusso,
                idRun,
                idClient,
                ModalitaOperativa.P,
                periodoRiferimento,
                annoRfierimento,
                codiceRegione,
                grl
        );
    }

    private Properties loadPropertiesFromFile(String fileName) {
        Properties prop = new Properties();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream(fileName);
            prop.load(stream);
            stream.close();
        } catch (Exception e) {
            String msg = String.format("Failed to load file '%s' - %s - %s", fileName, e.getClass().getName(),
                    e.getMessage());
            System.out.println(msg);
        }
        return prop;
    }
}
