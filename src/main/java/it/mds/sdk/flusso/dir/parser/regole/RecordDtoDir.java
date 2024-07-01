/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.dir.parser.regole;

import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDtoDir extends RecordDtoGenerico {
    //cod_reg]-[anno]-[mese]-[cod_asl]-[tipo_er]-[tipo_str]-[id_er]-[id_ass]-[vld_id_ass]-[tip_id_ass]-[dat_nasc]-[sesso]-[cod_asl_ass]-[citt]-[stat_est]-[cod_ist_comp]-[tipo_op]-[tipo_canale]-[cod_esen]-[tipo_erog]-[tipo_esen]-[tipo_cont]-[id_cont]-[dat_erog]-[quota_fissa_ass]-[quota_perc_ass]-[dat_pres]-[costo_srv_ric]-[cod_pr]-[tipo_pr]-[tipo_f]-[cod_f]-[qta]-[fatt_conv]-[targatura]-[costo_acq]-[costo_srv

    @CsvBindByPosition(position = 0)
    private String regioneErogante;

    @CsvBindByPosition(position = 1)
    private String annoDiRiferimento;

    @CsvBindByPosition(position = 2)
    private String meseDiRiferimento;

    @CsvBindByPosition(position = 3)
    private String codiceAziendaSanitariaErogante;

    @CsvBindByPosition(position = 4)
    private String tipoErogatore;

    @CsvBindByPosition(position = 5)
    private String tipoStrutturaErogante;

    @CsvBindByPosition(position = 6)
    private String codiceStrutturaErogante;

    @CsvBindByPosition(position = 7)
    private String identificativoAssistito;

    @CsvBindByPosition(position = 8)
    private Integer validitaCodIdentAssistito;

    @CsvBindByPosition(position = 9)
    private Integer tipologiaCodIdentAssistito;

    @CsvBindByPosition(position = 10)
    private String dataNascitaAssistito;

    @CsvBindByPosition(position = 11)
    private String sessoAssistito;

    @CsvBindByPosition(position = 12)
    private String aslAssistito;

    @CsvBindByPosition(position = 13)
    private String cittadinanza;

    @CsvBindByPosition(position = 14)
    private String statoEsteroDiResidenza;

    @CsvBindByPosition(position = 15)
    private String codiceIstituzioneCompetente;

    @CsvBindByPosition(position = 16)
    private String tipoOperazione;

    @CsvBindByPosition(position = 17)
    private String tipoCanale;

    @CsvBindByPosition(position = 18)
    private String codiceEsenzione;

    @CsvBindByPosition(position = 19)
    private String tipoErogazione;

    @CsvBindByPosition(position = 20)
    private String tipoDiEsenzione;

    @CsvBindByPosition(position = 21)
    private String tipoContatto;

    @CsvBindByPosition(position = 22)
    private String idContatto;

    @CsvBindByPosition(position = 23)
    private String dataErogazione;

    @CsvBindByPosition(position = 24)
    private String quotaFissaAssistito;

    @CsvBindByPosition(position = 25)
    private String quotaPercentualeAssistito;

    @CsvBindByPosition(position = 26)
    private String dataPrescrizione;

    @CsvBindByPosition(position = 27)
    private String costoServizioRicetta;

    @CsvBindByPosition(position = 28)
    private String codicePrescrittore;

    @CsvBindByPosition(position = 29)
    private String tipoPrescrittore;

    @CsvBindByPosition(position = 30)
    private String tipoFarmaco;

    @CsvBindByPosition(position = 31)
    private String codiceFarmaco;

    @CsvBindByPosition(position = 32)
    private String quantita;

    @CsvBindByPosition(position = 33)
    private String fattoreDiConversione;

    @CsvBindByPosition(position = 34)
    private String targatura;

    @CsvBindByPosition(position = 35)
    private String costoAcquisto;

    @CsvBindByPosition(position = 36)
    private String costoServizio;

    //TODO cancellare questa parte utile solo per test di studio fattibilità
    public RecordDtoDir clone() {
        RecordDtoDir clone = new RecordDtoDir();
        clone.setCostoAcquisto(new String(costoAcquisto));
        clone.setCittadinanza(cittadinanza);
        clone.setTipoOperazione(tipoOperazione);
        clone.setAslAssistito(aslAssistito);
        clone.setCodiceEsenzione(codiceEsenzione);
        clone.setCodiceAziendaSanitariaErogante(codiceAziendaSanitariaErogante);
        clone.setCodicePrescrittore(codicePrescrittore);
        return clone;
    }


}
