//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.04.29 alle 04:34:35 PM CEST 
//


package it.mds.sdk.flusso.dir.tracciato.bean.output;

import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="REGIONE"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PERIODO"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ASL" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="EROGATORE" maxOccurs="unbounded"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="ASSISTITO" maxOccurs="unbounded"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
 *                                                             &lt;complexType&gt;
 *                                                               &lt;complexContent&gt;
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                   &lt;sequence&gt;
 *                                                                     &lt;element name="PRESCRIZIONE" maxOccurs="unbounded"&gt;
 *                                                                       &lt;complexType&gt;
 *                                                                         &lt;complexContent&gt;
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                             &lt;sequence&gt;
 *                                                                               &lt;element name="PRESCRITTORE"&gt;
 *                                                                                 &lt;complexType&gt;
 *                                                                                   &lt;complexContent&gt;
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                                       &lt;attribute name="tipo_pr"&gt;
 *                                                                                         &lt;simpleType&gt;
 *                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                             &lt;enumeration value="F"/&gt;
 *                                                                                             &lt;enumeration value="P"/&gt;
 *                                                                                             &lt;enumeration value="H"/&gt;
 *                                                                                             &lt;enumeration value="A"/&gt;
 *                                                                                             &lt;enumeration value="G"/&gt;
 *                                                                                             &lt;enumeration value="T"/&gt;
 *                                                                                             &lt;enumeration value="C"/&gt;
 *                                                                                             &lt;enumeration value="U"/&gt;
 *                                                                                             &lt;enumeration value="D"/&gt;
 *                                                                                             &lt;enumeration value="Z"/&gt;
 *                                                                                             &lt;enumeration value="I"/&gt;
 *                                                                                             &lt;enumeration value="X"/&gt;
 *                                                                                             &lt;enumeration value="B"/&gt;
 *                                                                                           &lt;/restriction&gt;
 *                                                                                         &lt;/simpleType&gt;
 *                                                                                       &lt;/attribute&gt;
 *                                                                                       &lt;attribute name="cod_pr"&gt;
 *                                                                                         &lt;simpleType&gt;
 *                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                             &lt;length value="16"/&gt;
 *                                                                                           &lt;/restriction&gt;
 *                                                                                         &lt;/simpleType&gt;
 *                                                                                       &lt;/attribute&gt;
 *                                                                                     &lt;/restriction&gt;
 *                                                                                   &lt;/complexContent&gt;
 *                                                                                 &lt;/complexType&gt;
 *                                                                               &lt;/element&gt;
 *                                                                               &lt;element name="FARMACO" maxOccurs="unbounded"&gt;
 *                                                                                 &lt;complexType&gt;
 *                                                                                   &lt;complexContent&gt;
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                                       &lt;attribute name="cod_f"&gt;
 *                                                                                         &lt;simpleType&gt;
 *                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                             &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
 *                                                                                           &lt;/restriction&gt;
 *                                                                                         &lt;/simpleType&gt;
 *                                                                                       &lt;/attribute&gt;
 *                                                                                       &lt;attribute name="tipo_f" use="required"&gt;
 *                                                                                         &lt;simpleType&gt;
 *                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                             &lt;enumeration value="1"/&gt;
 *                                                                                             &lt;enumeration value="2"/&gt;
 *                                                                                             &lt;enumeration value="3"/&gt;
 *                                                                                             &lt;enumeration value="4"/&gt;
 *                                                                                             &lt;enumeration value="5"/&gt;
 *                                                                                             &lt;enumeration value="6"/&gt;
 *                                                                                           &lt;/restriction&gt;
 *                                                                                         &lt;/simpleType&gt;
 *                                                                                       &lt;/attribute&gt;
 *                                                                                       &lt;attribute name="targatura"&gt;
 *                                                                                         &lt;simpleType&gt;
 *                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                             &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
 *                                                                                           &lt;/restriction&gt;
 *                                                                                         &lt;/simpleType&gt;
 *                                                                                       &lt;/attribute&gt;
 *                                                                                       &lt;attribute name="costo_acq" use="required"&gt;
 *                                                                                         &lt;simpleType&gt;
 *                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                             &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
 *                                                                                           &lt;/restriction&gt;
 *                                                                                         &lt;/simpleType&gt;
 *                                                                                       &lt;/attribute&gt;
 *                                                                                       &lt;attribute name="costo_srv"&gt;
 *                                                                                         &lt;simpleType&gt;
 *                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                             &lt;pattern value="-{0,1}[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
 *                                                                                           &lt;/restriction&gt;
 *                                                                                         &lt;/simpleType&gt;
 *                                                                                       &lt;/attribute&gt;
 *                                                                                       &lt;attribute name="qta" use="required"&gt;
 *                                                                                         &lt;simpleType&gt;
 *                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                             &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
 *                                                                                           &lt;/restriction&gt;
 *                                                                                         &lt;/simpleType&gt;
 *                                                                                       &lt;/attribute&gt;
 *                                                                                       &lt;attribute name="fatt_conv" use="required"&gt;
 *                                                                                         &lt;simpleType&gt;
 *                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                                                                             &lt;minInclusive value="1"/&gt;
 *                                                                                             &lt;maxInclusive value="999999"/&gt;
 *                                                                                           &lt;/restriction&gt;
 *                                                                                         &lt;/simpleType&gt;
 *                                                                                       &lt;/attribute&gt;
 *                                                                                     &lt;/restriction&gt;
 *                                                                                   &lt;/complexContent&gt;
 *                                                                                 &lt;/complexType&gt;
 *                                                                               &lt;/element&gt;
 *                                                                             &lt;/sequence&gt;
 *                                                                             &lt;attribute name="tipo_cont" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;pattern value="[1-2]{1}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="id_cont" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;maxLength value="20"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="dat_erog" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
 *                                                                                   &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="tipo_esen"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;enumeration value="0"/&gt;
 *                                                                                   &lt;enumeration value="1"/&gt;
 *                                                                                   &lt;enumeration value="2"/&gt;
 *                                                                                   &lt;enumeration value="3"/&gt;
 *                                                                                   &lt;enumeration value="4"/&gt;
 *                                                                                   &lt;enumeration value="5"/&gt;
 *                                                                                   &lt;enumeration value="9"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="tipo_erog" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;pattern value="[0-9]{2}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="tipo_canale" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;enumeration value="P"/&gt;
 *                                                                                   &lt;enumeration value="D"/&gt;
 *                                                                                   &lt;enumeration value="R"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="cod_esen"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;pattern value="[0-9A-Za-z]{1,6}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="quota_fissa_ass"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="quota_perc_ass"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="dat_pres"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
 *                                                                                   &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="costo_srv_ric"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;pattern value="[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/complexContent&gt;
 *                                                                       &lt;/complexType&gt;
 *                                                                     &lt;/element&gt;
 *                                                                   &lt;/sequence&gt;
 *                                                                   &lt;attribute name="tipo_op" use="required"&gt;
 *                                                                     &lt;simpleType&gt;
 *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                         &lt;enumeration value="I"/&gt;
 *                                                                         &lt;enumeration value="V"/&gt;
 *                                                                         &lt;enumeration value="C"/&gt;
 *                                                                       &lt;/restriction&gt;
 *                                                                     &lt;/simpleType&gt;
 *                                                                   &lt;/attribute&gt;
 *                                                                 &lt;/restriction&gt;
 *                                                               &lt;/complexContent&gt;
 *                                                             &lt;/complexType&gt;
 *                                                           &lt;/element&gt;
 *                                                         &lt;/sequence&gt;
 *                                                         &lt;attribute name="id_ass"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;length value="88"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                         &lt;attribute name="vld_id_ass"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;enumeration value="0"/&gt;
 *                                                               &lt;enumeration value="1"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                         &lt;attribute name="tip_id_ass"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;enumeration value="0"/&gt;
 *                                                               &lt;enumeration value="1"/&gt;
 *                                                               &lt;enumeration value="2"/&gt;
 *                                                               &lt;enumeration value="3"/&gt;
 *                                                               &lt;enumeration value="4"/&gt;
 *                                                               &lt;enumeration value="97"/&gt;
 *                                                               &lt;enumeration value="98"/&gt;
 *                                                               &lt;enumeration value="99"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                         &lt;attribute name="dat_nasc"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
 *                                                               &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                         &lt;attribute name="sesso"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;enumeration value="1"/&gt;
 *                                                               &lt;enumeration value="2"/&gt;
 *                                                               &lt;enumeration value="9"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                         &lt;attribute name="cod_asl_ass"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;pattern value="[0-9]{6}"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                         &lt;attribute name="citt"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;enumeration value="1"/&gt;
 *                                                               &lt;enumeration value="2"/&gt;
 *                                                               &lt;enumeration value="9"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                         &lt;attribute name="stat_est"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;pattern value="[a-zA-Z]{2}"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                         &lt;attribute name="cod_ist_comp"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;length value="28"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                               &lt;attribute name="tipo_er" use="required"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;pattern value="[0-9]{2}"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                               &lt;attribute name="tipo_str"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;pattern value="[0-9]{2}"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                               &lt;attribute name="id_er" use="required"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="cod_asl" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;pattern value="[0-9]{6}"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="mese" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;enumeration value="01"/&gt;
 *                                 &lt;enumeration value="02"/&gt;
 *                                 &lt;enumeration value="03"/&gt;
 *                                 &lt;enumeration value="04"/&gt;
 *                                 &lt;enumeration value="05"/&gt;
 *                                 &lt;enumeration value="06"/&gt;
 *                                 &lt;enumeration value="07"/&gt;
 *                                 &lt;enumeration value="08"/&gt;
 *                                 &lt;enumeration value="09"/&gt;
 *                                 &lt;enumeration value="10"/&gt;
 *                                 &lt;enumeration value="11"/&gt;
 *                                 &lt;enumeration value="12"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                           &lt;attribute name="anno" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;pattern value="[2][0][0-9]{2}"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="cod_reg" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;pattern value="[0-9]{3}"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CANCELLAZIONE_MASSIVA_DATI"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="REGIONE"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PERIODO"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ASL" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;attribute name="cod_asl" use="required"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;pattern value="[0-9]{6}"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="mese" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;enumeration value="01"/&gt;
 *                                           &lt;enumeration value="02"/&gt;
 *                                           &lt;enumeration value="03"/&gt;
 *                                           &lt;enumeration value="04"/&gt;
 *                                           &lt;enumeration value="05"/&gt;
 *                                           &lt;enumeration value="06"/&gt;
 *                                           &lt;enumeration value="07"/&gt;
 *                                           &lt;enumeration value="08"/&gt;
 *                                           &lt;enumeration value="09"/&gt;
 *                                           &lt;enumeration value="10"/&gt;
 *                                           &lt;enumeration value="11"/&gt;
 *                                           &lt;enumeration value="12"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                     &lt;attribute name="anno" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;pattern value="[2][0][0-9]{2}"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                     &lt;attribute name="tipo_canale"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;enumeration value="P"/&gt;
 *                                           &lt;enumeration value="D"/&gt;
 *                                           &lt;enumeration value="R"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="cod_reg" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;pattern value="[0-9]{3}"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "regione",
    "cancellazionemassivadati"
})
@XmlRootElement(name = "dataroot")
public class Dataroot {

    @XmlElement(name = "REGIONE")
    protected REGIONE regione;
    @XmlElement(name = "CANCELLAZIONE_MASSIVA_DATI")
    protected CANCELLAZIONEMASSIVADATI cancellazionemassivadati;

    /**
     * Recupera il valore della proprietà regione.
     * 
     * @return
     *     possible object is
     *     {@link REGIONE }
     *     
     */
    public REGIONE getREGIONE() {
        return regione;
    }

    /**
     * Imposta il valore della proprietà regione.
     * 
     * @param value
     *     allowed object is
     *     {@link REGIONE }
     *     
     */
    public void setREGIONE(REGIONE value) {
        this.regione = value;
    }

    /**
     * Recupera il valore della proprietà cancellazionemassivadati.
     * 
     * @return
     *     possible object is
     *     {@link CANCELLAZIONEMASSIVADATI }
     *     
     */
    public CANCELLAZIONEMASSIVADATI getCANCELLAZIONEMASSIVADATI() {
        return cancellazionemassivadati;
    }

    /**
     * Imposta il valore della proprietà cancellazionemassivadati.
     * 
     * @param value
     *     allowed object is
     *     {@link CANCELLAZIONEMASSIVADATI }
     *     
     */
    public void setCANCELLAZIONEMASSIVADATI(CANCELLAZIONEMASSIVADATI value) {
        this.cancellazionemassivadati = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="REGIONE"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PERIODO"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ASL" maxOccurs="unbounded" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;attribute name="cod_asl" use="required"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;pattern value="[0-9]{6}"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="mese" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;enumeration value="01"/&gt;
     *                                 &lt;enumeration value="02"/&gt;
     *                                 &lt;enumeration value="03"/&gt;
     *                                 &lt;enumeration value="04"/&gt;
     *                                 &lt;enumeration value="05"/&gt;
     *                                 &lt;enumeration value="06"/&gt;
     *                                 &lt;enumeration value="07"/&gt;
     *                                 &lt;enumeration value="08"/&gt;
     *                                 &lt;enumeration value="09"/&gt;
     *                                 &lt;enumeration value="10"/&gt;
     *                                 &lt;enumeration value="11"/&gt;
     *                                 &lt;enumeration value="12"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                           &lt;attribute name="anno" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;pattern value="[2][0][0-9]{2}"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                           &lt;attribute name="tipo_canale"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;enumeration value="P"/&gt;
     *                                 &lt;enumeration value="D"/&gt;
     *                                 &lt;enumeration value="R"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="cod_reg" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;pattern value="[0-9]{3}"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "regione"
    })
    public static class CANCELLAZIONEMASSIVADATI {

        @XmlElement(name = "REGIONE", required = true)
        protected REGIONE regione;

        /**
         * Recupera il valore della proprietà regione.
         * 
         * @return
         *     possible object is
         *     {@link REGIONE }
         *     
         */
        public REGIONE getREGIONE() {
            return regione;
        }

        /**
         * Imposta il valore della proprietà regione.
         * 
         * @param value
         *     allowed object is
         *     {@link REGIONE }
         *     
         */
        public void setREGIONE(REGIONE value) {
            this.regione = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="PERIODO"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ASL" maxOccurs="unbounded" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;attribute name="cod_asl" use="required"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;pattern value="[0-9]{6}"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="mese" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;enumeration value="01"/&gt;
         *                       &lt;enumeration value="02"/&gt;
         *                       &lt;enumeration value="03"/&gt;
         *                       &lt;enumeration value="04"/&gt;
         *                       &lt;enumeration value="05"/&gt;
         *                       &lt;enumeration value="06"/&gt;
         *                       &lt;enumeration value="07"/&gt;
         *                       &lt;enumeration value="08"/&gt;
         *                       &lt;enumeration value="09"/&gt;
         *                       &lt;enumeration value="10"/&gt;
         *                       &lt;enumeration value="11"/&gt;
         *                       &lt;enumeration value="12"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *                 &lt;attribute name="anno" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;pattern value="[2][0][0-9]{2}"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *                 &lt;attribute name="tipo_canale"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;enumeration value="P"/&gt;
         *                       &lt;enumeration value="D"/&gt;
         *                       &lt;enumeration value="R"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="cod_reg" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;pattern value="[0-9]{3}"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "periodo"
        })
        public static class REGIONE {

            @XmlElement(name = "PERIODO", required = true)
            protected PERIODO periodo;
            @XmlAttribute(name = "cod_reg", required = true)
            protected String codReg;

            /**
             * Recupera il valore della proprietà periodo.
             * 
             * @return
             *     possible object is
             *     {@link PERIODO }
             *     
             */
            public PERIODO getPERIODO() {
                return periodo;
            }

            /**
             * Imposta il valore della proprietà periodo.
             * 
             * @param value
             *     allowed object is
             *     {@link PERIODO }
             *     
             */
            public void setPERIODO(PERIODO value) {
                this.periodo = value;
            }

            /**
             * Recupera il valore della proprietà codReg.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodReg() {
                return codReg;
            }

            /**
             * Imposta il valore della proprietà codReg.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodReg(String value) {
                this.codReg = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="ASL" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;attribute name="cod_asl" use="required"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;pattern value="[0-9]{6}"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="mese" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;enumeration value="01"/&gt;
             *             &lt;enumeration value="02"/&gt;
             *             &lt;enumeration value="03"/&gt;
             *             &lt;enumeration value="04"/&gt;
             *             &lt;enumeration value="05"/&gt;
             *             &lt;enumeration value="06"/&gt;
             *             &lt;enumeration value="07"/&gt;
             *             &lt;enumeration value="08"/&gt;
             *             &lt;enumeration value="09"/&gt;
             *             &lt;enumeration value="10"/&gt;
             *             &lt;enumeration value="11"/&gt;
             *             &lt;enumeration value="12"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *       &lt;attribute name="anno" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;pattern value="[2][0][0-9]{2}"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *       &lt;attribute name="tipo_canale"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;enumeration value="P"/&gt;
             *             &lt;enumeration value="D"/&gt;
             *             &lt;enumeration value="R"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "asl"
            })
            public static class PERIODO {

                @XmlElement(name = "ASL")
                protected List<ASL> asl;
                @XmlAttribute(name = "mese", required = true)
                protected String mese;
                @XmlAttribute(name = "anno", required = true)
                protected String anno;
                @XmlAttribute(name = "tipo_canale")
                protected String tipoCanale;

                /**
                 * Gets the value of the asl property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the asl property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getASL().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ASL }
                 * 
                 * 
                 */
                public List<ASL> getASL() {
                    if (asl == null) {
                        asl = new ArrayList<ASL>();
                    }
                    return this.asl;
                }

                /**
                 * Recupera il valore della proprietà mese.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMese() {
                    return mese;
                }

                /**
                 * Imposta il valore della proprietà mese.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMese(String value) {
                    this.mese = value;
                }

                /**
                 * Recupera il valore della proprietà anno.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAnno() {
                    return anno;
                }

                /**
                 * Imposta il valore della proprietà anno.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAnno(String value) {
                    this.anno = value;
                }

                /**
                 * Recupera il valore della proprietà tipoCanale.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTipoCanale() {
                    return tipoCanale;
                }

                /**
                 * Imposta il valore della proprietà tipoCanale.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTipoCanale(String value) {
                    this.tipoCanale = value;
                }


                /**
                 * <p>Classe Java per anonymous complex type.
                 * 
                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;attribute name="cod_asl" use="required"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;pattern value="[0-9]{6}"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class ASL {

                    @XmlAttribute(name = "cod_asl", required = true)
                    protected String codAsl;

                    /**
                     * Recupera il valore della proprietà codAsl.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCodAsl() {
                        return codAsl;
                    }

                    /**
                     * Imposta il valore della proprietà codAsl.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCodAsl(String value) {
                        this.codAsl = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PERIODO"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ASL" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="EROGATORE" maxOccurs="unbounded"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="ASSISTITO" maxOccurs="unbounded"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
     *                                                   &lt;complexType&gt;
     *                                                     &lt;complexContent&gt;
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                         &lt;sequence&gt;
     *                                                           &lt;element name="PRESCRIZIONE" maxOccurs="unbounded"&gt;
     *                                                             &lt;complexType&gt;
     *                                                               &lt;complexContent&gt;
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                   &lt;sequence&gt;
     *                                                                     &lt;element name="PRESCRITTORE"&gt;
     *                                                                       &lt;complexType&gt;
     *                                                                         &lt;complexContent&gt;
     *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                             &lt;attribute name="tipo_pr"&gt;
     *                                                                               &lt;simpleType&gt;
     *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                                   &lt;enumeration value="F"/&gt;
     *                                                                                   &lt;enumeration value="P"/&gt;
     *                                                                                   &lt;enumeration value="H"/&gt;
     *                                                                                   &lt;enumeration value="A"/&gt;
     *                                                                                   &lt;enumeration value="G"/&gt;
     *                                                                                   &lt;enumeration value="T"/&gt;
     *                                                                                   &lt;enumeration value="C"/&gt;
     *                                                                                   &lt;enumeration value="U"/&gt;
     *                                                                                   &lt;enumeration value="D"/&gt;
     *                                                                                   &lt;enumeration value="Z"/&gt;
     *                                                                                   &lt;enumeration value="I"/&gt;
     *                                                                                   &lt;enumeration value="X"/&gt;
     *                                                                                   &lt;enumeration value="B"/&gt;
     *                                                                                 &lt;/restriction&gt;
     *                                                                               &lt;/simpleType&gt;
     *                                                                             &lt;/attribute&gt;
     *                                                                             &lt;attribute name="cod_pr"&gt;
     *                                                                               &lt;simpleType&gt;
     *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                                   &lt;length value="16"/&gt;
     *                                                                                 &lt;/restriction&gt;
     *                                                                               &lt;/simpleType&gt;
     *                                                                             &lt;/attribute&gt;
     *                                                                           &lt;/restriction&gt;
     *                                                                         &lt;/complexContent&gt;
     *                                                                       &lt;/complexType&gt;
     *                                                                     &lt;/element&gt;
     *                                                                     &lt;element name="FARMACO" maxOccurs="unbounded"&gt;
     *                                                                       &lt;complexType&gt;
     *                                                                         &lt;complexContent&gt;
     *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                             &lt;attribute name="cod_f"&gt;
     *                                                                               &lt;simpleType&gt;
     *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                                   &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
     *                                                                                 &lt;/restriction&gt;
     *                                                                               &lt;/simpleType&gt;
     *                                                                             &lt;/attribute&gt;
     *                                                                             &lt;attribute name="tipo_f" use="required"&gt;
     *                                                                               &lt;simpleType&gt;
     *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                                   &lt;enumeration value="1"/&gt;
     *                                                                                   &lt;enumeration value="2"/&gt;
     *                                                                                   &lt;enumeration value="3"/&gt;
     *                                                                                   &lt;enumeration value="4"/&gt;
     *                                                                                   &lt;enumeration value="5"/&gt;
     *                                                                                   &lt;enumeration value="6"/&gt;
     *                                                                                 &lt;/restriction&gt;
     *                                                                               &lt;/simpleType&gt;
     *                                                                             &lt;/attribute&gt;
     *                                                                             &lt;attribute name="targatura"&gt;
     *                                                                               &lt;simpleType&gt;
     *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                                   &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
     *                                                                                 &lt;/restriction&gt;
     *                                                                               &lt;/simpleType&gt;
     *                                                                             &lt;/attribute&gt;
     *                                                                             &lt;attribute name="costo_acq" use="required"&gt;
     *                                                                               &lt;simpleType&gt;
     *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                                   &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
     *                                                                                 &lt;/restriction&gt;
     *                                                                               &lt;/simpleType&gt;
     *                                                                             &lt;/attribute&gt;
     *                                                                             &lt;attribute name="costo_srv"&gt;
     *                                                                               &lt;simpleType&gt;
     *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                                   &lt;pattern value="-{0,1}[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
     *                                                                                 &lt;/restriction&gt;
     *                                                                               &lt;/simpleType&gt;
     *                                                                             &lt;/attribute&gt;
     *                                                                             &lt;attribute name="qta" use="required"&gt;
     *                                                                               &lt;simpleType&gt;
     *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                                   &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
     *                                                                                 &lt;/restriction&gt;
     *                                                                               &lt;/simpleType&gt;
     *                                                                             &lt;/attribute&gt;
     *                                                                             &lt;attribute name="fatt_conv" use="required"&gt;
     *                                                                               &lt;simpleType&gt;
     *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                                                                   &lt;minInclusive value="1"/&gt;
     *                                                                                   &lt;maxInclusive value="999999"/&gt;
     *                                                                                 &lt;/restriction&gt;
     *                                                                               &lt;/simpleType&gt;
     *                                                                             &lt;/attribute&gt;
     *                                                                           &lt;/restriction&gt;
     *                                                                         &lt;/complexContent&gt;
     *                                                                       &lt;/complexType&gt;
     *                                                                     &lt;/element&gt;
     *                                                                   &lt;/sequence&gt;
     *                                                                   &lt;attribute name="tipo_cont" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;pattern value="[1-2]{1}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="id_cont" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;maxLength value="20"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="dat_erog" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
     *                                                                         &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="tipo_esen"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;enumeration value="0"/&gt;
     *                                                                         &lt;enumeration value="1"/&gt;
     *                                                                         &lt;enumeration value="2"/&gt;
     *                                                                         &lt;enumeration value="3"/&gt;
     *                                                                         &lt;enumeration value="4"/&gt;
     *                                                                         &lt;enumeration value="5"/&gt;
     *                                                                         &lt;enumeration value="9"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="tipo_erog" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;pattern value="[0-9]{2}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="tipo_canale" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;enumeration value="P"/&gt;
     *                                                                         &lt;enumeration value="D"/&gt;
     *                                                                         &lt;enumeration value="R"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="cod_esen"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;pattern value="[0-9A-Za-z]{1,6}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="quota_fissa_ass"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="quota_perc_ass"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="dat_pres"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
     *                                                                         &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="costo_srv_ric"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;pattern value="[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/complexContent&gt;
     *                                                             &lt;/complexType&gt;
     *                                                           &lt;/element&gt;
     *                                                         &lt;/sequence&gt;
     *                                                         &lt;attribute name="tipo_op" use="required"&gt;
     *                                                           &lt;simpleType&gt;
     *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                               &lt;enumeration value="I"/&gt;
     *                                                               &lt;enumeration value="V"/&gt;
     *                                                               &lt;enumeration value="C"/&gt;
     *                                                             &lt;/restriction&gt;
     *                                                           &lt;/simpleType&gt;
     *                                                         &lt;/attribute&gt;
     *                                                       &lt;/restriction&gt;
     *                                                     &lt;/complexContent&gt;
     *                                                   &lt;/complexType&gt;
     *                                                 &lt;/element&gt;
     *                                               &lt;/sequence&gt;
     *                                               &lt;attribute name="id_ass"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;length value="88"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                               &lt;attribute name="vld_id_ass"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;enumeration value="0"/&gt;
     *                                                     &lt;enumeration value="1"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                               &lt;attribute name="tip_id_ass"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;enumeration value="0"/&gt;
     *                                                     &lt;enumeration value="1"/&gt;
     *                                                     &lt;enumeration value="2"/&gt;
     *                                                     &lt;enumeration value="3"/&gt;
     *                                                     &lt;enumeration value="4"/&gt;
     *                                                     &lt;enumeration value="97"/&gt;
     *                                                     &lt;enumeration value="98"/&gt;
     *                                                     &lt;enumeration value="99"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                               &lt;attribute name="dat_nasc"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
     *                                                     &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                               &lt;attribute name="sesso"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;enumeration value="1"/&gt;
     *                                                     &lt;enumeration value="2"/&gt;
     *                                                     &lt;enumeration value="9"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                               &lt;attribute name="cod_asl_ass"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;pattern value="[0-9]{6}"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                               &lt;attribute name="citt"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;enumeration value="1"/&gt;
     *                                                     &lt;enumeration value="2"/&gt;
     *                                                     &lt;enumeration value="9"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                               &lt;attribute name="stat_est"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;pattern value="[a-zA-Z]{2}"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                               &lt;attribute name="cod_ist_comp"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;length value="28"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                     &lt;attribute name="tipo_er" use="required"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;pattern value="[0-9]{2}"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                     &lt;attribute name="tipo_str"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;pattern value="[0-9]{2}"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                     &lt;attribute name="id_er" use="required"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="cod_asl" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;pattern value="[0-9]{6}"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="mese" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;enumeration value="01"/&gt;
     *                       &lt;enumeration value="02"/&gt;
     *                       &lt;enumeration value="03"/&gt;
     *                       &lt;enumeration value="04"/&gt;
     *                       &lt;enumeration value="05"/&gt;
     *                       &lt;enumeration value="06"/&gt;
     *                       &lt;enumeration value="07"/&gt;
     *                       &lt;enumeration value="08"/&gt;
     *                       &lt;enumeration value="09"/&gt;
     *                       &lt;enumeration value="10"/&gt;
     *                       &lt;enumeration value="11"/&gt;
     *                       &lt;enumeration value="12"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *                 &lt;attribute name="anno" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;pattern value="[2][0][0-9]{2}"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="cod_reg" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;pattern value="[0-9]{3}"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "periodo"
    })
    public static class REGIONE {

        @XmlElement(name = "PERIODO", required = true)
        protected PERIODO periodo;
        @XmlAttribute(name = "cod_reg", required = true)
        protected String codReg;

        /**
         * Recupera il valore della proprietà periodo.
         * 
         * @return
         *     possible object is
         *     {@link PERIODO }
         *     
         */
        public PERIODO getPERIODO() {
            return periodo;
        }

        /**
         * Imposta il valore della proprietà periodo.
         * 
         * @param value
         *     allowed object is
         *     {@link PERIODO }
         *     
         */
        public void setPERIODO(PERIODO value) {
            this.periodo = value;
        }

        /**
         * Recupera il valore della proprietà codReg.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodReg() {
            return codReg;
        }

        /**
         * Imposta il valore della proprietà codReg.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodReg(String value) {
            this.codReg = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ASL" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="EROGATORE" maxOccurs="unbounded"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="ASSISTITO" maxOccurs="unbounded"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;complexContent&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                               &lt;sequence&gt;
         *                                                 &lt;element name="PRESCRIZIONE" maxOccurs="unbounded"&gt;
         *                                                   &lt;complexType&gt;
         *                                                     &lt;complexContent&gt;
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                         &lt;sequence&gt;
         *                                                           &lt;element name="PRESCRITTORE"&gt;
         *                                                             &lt;complexType&gt;
         *                                                               &lt;complexContent&gt;
         *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                                   &lt;attribute name="tipo_pr"&gt;
         *                                                                     &lt;simpleType&gt;
         *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                                         &lt;enumeration value="F"/&gt;
         *                                                                         &lt;enumeration value="P"/&gt;
         *                                                                         &lt;enumeration value="H"/&gt;
         *                                                                         &lt;enumeration value="A"/&gt;
         *                                                                         &lt;enumeration value="G"/&gt;
         *                                                                         &lt;enumeration value="T"/&gt;
         *                                                                         &lt;enumeration value="C"/&gt;
         *                                                                         &lt;enumeration value="U"/&gt;
         *                                                                         &lt;enumeration value="D"/&gt;
         *                                                                         &lt;enumeration value="Z"/&gt;
         *                                                                         &lt;enumeration value="I"/&gt;
         *                                                                         &lt;enumeration value="X"/&gt;
         *                                                                         &lt;enumeration value="B"/&gt;
         *                                                                       &lt;/restriction&gt;
         *                                                                     &lt;/simpleType&gt;
         *                                                                   &lt;/attribute&gt;
         *                                                                   &lt;attribute name="cod_pr"&gt;
         *                                                                     &lt;simpleType&gt;
         *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                                         &lt;length value="16"/&gt;
         *                                                                       &lt;/restriction&gt;
         *                                                                     &lt;/simpleType&gt;
         *                                                                   &lt;/attribute&gt;
         *                                                                 &lt;/restriction&gt;
         *                                                               &lt;/complexContent&gt;
         *                                                             &lt;/complexType&gt;
         *                                                           &lt;/element&gt;
         *                                                           &lt;element name="FARMACO" maxOccurs="unbounded"&gt;
         *                                                             &lt;complexType&gt;
         *                                                               &lt;complexContent&gt;
         *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                                   &lt;attribute name="cod_f"&gt;
         *                                                                     &lt;simpleType&gt;
         *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                                         &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
         *                                                                       &lt;/restriction&gt;
         *                                                                     &lt;/simpleType&gt;
         *                                                                   &lt;/attribute&gt;
         *                                                                   &lt;attribute name="tipo_f" use="required"&gt;
         *                                                                     &lt;simpleType&gt;
         *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                                         &lt;enumeration value="1"/&gt;
         *                                                                         &lt;enumeration value="2"/&gt;
         *                                                                         &lt;enumeration value="3"/&gt;
         *                                                                         &lt;enumeration value="4"/&gt;
         *                                                                         &lt;enumeration value="5"/&gt;
         *                                                                         &lt;enumeration value="6"/&gt;
         *                                                                       &lt;/restriction&gt;
         *                                                                     &lt;/simpleType&gt;
         *                                                                   &lt;/attribute&gt;
         *                                                                   &lt;attribute name="targatura"&gt;
         *                                                                     &lt;simpleType&gt;
         *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                                         &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
         *                                                                       &lt;/restriction&gt;
         *                                                                     &lt;/simpleType&gt;
         *                                                                   &lt;/attribute&gt;
         *                                                                   &lt;attribute name="costo_acq" use="required"&gt;
         *                                                                     &lt;simpleType&gt;
         *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                                         &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
         *                                                                       &lt;/restriction&gt;
         *                                                                     &lt;/simpleType&gt;
         *                                                                   &lt;/attribute&gt;
         *                                                                   &lt;attribute name="costo_srv"&gt;
         *                                                                     &lt;simpleType&gt;
         *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                                         &lt;pattern value="-{0,1}[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
         *                                                                       &lt;/restriction&gt;
         *                                                                     &lt;/simpleType&gt;
         *                                                                   &lt;/attribute&gt;
         *                                                                   &lt;attribute name="qta" use="required"&gt;
         *                                                                     &lt;simpleType&gt;
         *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                                         &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
         *                                                                       &lt;/restriction&gt;
         *                                                                     &lt;/simpleType&gt;
         *                                                                   &lt;/attribute&gt;
         *                                                                   &lt;attribute name="fatt_conv" use="required"&gt;
         *                                                                     &lt;simpleType&gt;
         *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                                                                         &lt;minInclusive value="1"/&gt;
         *                                                                         &lt;maxInclusive value="999999"/&gt;
         *                                                                       &lt;/restriction&gt;
         *                                                                     &lt;/simpleType&gt;
         *                                                                   &lt;/attribute&gt;
         *                                                                 &lt;/restriction&gt;
         *                                                               &lt;/complexContent&gt;
         *                                                             &lt;/complexType&gt;
         *                                                           &lt;/element&gt;
         *                                                         &lt;/sequence&gt;
         *                                                         &lt;attribute name="tipo_cont" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;pattern value="[1-2]{1}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="id_cont" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;maxLength value="20"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="dat_erog" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
         *                                                               &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="tipo_esen"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;enumeration value="0"/&gt;
         *                                                               &lt;enumeration value="1"/&gt;
         *                                                               &lt;enumeration value="2"/&gt;
         *                                                               &lt;enumeration value="3"/&gt;
         *                                                               &lt;enumeration value="4"/&gt;
         *                                                               &lt;enumeration value="5"/&gt;
         *                                                               &lt;enumeration value="9"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="tipo_erog" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;pattern value="[0-9]{2}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="tipo_canale" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;enumeration value="P"/&gt;
         *                                                               &lt;enumeration value="D"/&gt;
         *                                                               &lt;enumeration value="R"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="cod_esen"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;pattern value="[0-9A-Za-z]{1,6}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="quota_fissa_ass"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="quota_perc_ass"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="dat_pres"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
         *                                                               &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="costo_srv_ric"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;pattern value="[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                       &lt;/restriction&gt;
         *                                                     &lt;/complexContent&gt;
         *                                                   &lt;/complexType&gt;
         *                                                 &lt;/element&gt;
         *                                               &lt;/sequence&gt;
         *                                               &lt;attribute name="tipo_op" use="required"&gt;
         *                                                 &lt;simpleType&gt;
         *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                     &lt;enumeration value="I"/&gt;
         *                                                     &lt;enumeration value="V"/&gt;
         *                                                     &lt;enumeration value="C"/&gt;
         *                                                   &lt;/restriction&gt;
         *                                                 &lt;/simpleType&gt;
         *                                               &lt;/attribute&gt;
         *                                             &lt;/restriction&gt;
         *                                           &lt;/complexContent&gt;
         *                                         &lt;/complexType&gt;
         *                                       &lt;/element&gt;
         *                                     &lt;/sequence&gt;
         *                                     &lt;attribute name="id_ass"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;length value="88"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                     &lt;attribute name="vld_id_ass"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;enumeration value="0"/&gt;
         *                                           &lt;enumeration value="1"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                     &lt;attribute name="tip_id_ass"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;enumeration value="0"/&gt;
         *                                           &lt;enumeration value="1"/&gt;
         *                                           &lt;enumeration value="2"/&gt;
         *                                           &lt;enumeration value="3"/&gt;
         *                                           &lt;enumeration value="4"/&gt;
         *                                           &lt;enumeration value="97"/&gt;
         *                                           &lt;enumeration value="98"/&gt;
         *                                           &lt;enumeration value="99"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                     &lt;attribute name="dat_nasc"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
         *                                           &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                     &lt;attribute name="sesso"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;enumeration value="1"/&gt;
         *                                           &lt;enumeration value="2"/&gt;
         *                                           &lt;enumeration value="9"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                     &lt;attribute name="cod_asl_ass"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;pattern value="[0-9]{6}"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                     &lt;attribute name="citt"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;enumeration value="1"/&gt;
         *                                           &lt;enumeration value="2"/&gt;
         *                                           &lt;enumeration value="9"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                     &lt;attribute name="stat_est"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;pattern value="[a-zA-Z]{2}"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                     &lt;attribute name="cod_ist_comp"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;length value="28"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                           &lt;attribute name="tipo_er" use="required"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;pattern value="[0-9]{2}"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                           &lt;attribute name="tipo_str"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;pattern value="[0-9]{2}"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                           &lt;attribute name="id_er" use="required"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="cod_asl" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;pattern value="[0-9]{6}"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="mese" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;enumeration value="01"/&gt;
         *             &lt;enumeration value="02"/&gt;
         *             &lt;enumeration value="03"/&gt;
         *             &lt;enumeration value="04"/&gt;
         *             &lt;enumeration value="05"/&gt;
         *             &lt;enumeration value="06"/&gt;
         *             &lt;enumeration value="07"/&gt;
         *             &lt;enumeration value="08"/&gt;
         *             &lt;enumeration value="09"/&gt;
         *             &lt;enumeration value="10"/&gt;
         *             &lt;enumeration value="11"/&gt;
         *             &lt;enumeration value="12"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *       &lt;attribute name="anno" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;pattern value="[2][0][0-9]{2}"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "asl"
        })
        public static class PERIODO {

            @XmlElement(name = "ASL", required = true)
            protected List<ASL> asl;
            @XmlAttribute(name = "mese", required = true)
            protected String mese;
            @XmlAttribute(name = "anno", required = true)
            protected String anno;

            /**
             * Gets the value of the asl property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the asl property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getASL().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ASL }
             * 
             * 
             */
            public List<ASL> getASL() {
                if (asl == null) {
                    asl = new ArrayList<ASL>();
                }
                return this.asl;
            }

            /**
             * Recupera il valore della proprietà mese.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMese() {
                return mese;
            }

            /**
             * Imposta il valore della proprietà mese.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMese(String value) {
                this.mese = value;
            }

            /**
             * Recupera il valore della proprietà anno.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAnno() {
                return anno;
            }

            /**
             * Imposta il valore della proprietà anno.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAnno(String value) {
                this.anno = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="EROGATORE" maxOccurs="unbounded"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="ASSISTITO" maxOccurs="unbounded"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
             *                               &lt;complexType&gt;
             *                                 &lt;complexContent&gt;
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                     &lt;sequence&gt;
             *                                       &lt;element name="PRESCRIZIONE" maxOccurs="unbounded"&gt;
             *                                         &lt;complexType&gt;
             *                                           &lt;complexContent&gt;
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                               &lt;sequence&gt;
             *                                                 &lt;element name="PRESCRITTORE"&gt;
             *                                                   &lt;complexType&gt;
             *                                                     &lt;complexContent&gt;
             *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                                         &lt;attribute name="tipo_pr"&gt;
             *                                                           &lt;simpleType&gt;
             *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                               &lt;enumeration value="F"/&gt;
             *                                                               &lt;enumeration value="P"/&gt;
             *                                                               &lt;enumeration value="H"/&gt;
             *                                                               &lt;enumeration value="A"/&gt;
             *                                                               &lt;enumeration value="G"/&gt;
             *                                                               &lt;enumeration value="T"/&gt;
             *                                                               &lt;enumeration value="C"/&gt;
             *                                                               &lt;enumeration value="U"/&gt;
             *                                                               &lt;enumeration value="D"/&gt;
             *                                                               &lt;enumeration value="Z"/&gt;
             *                                                               &lt;enumeration value="I"/&gt;
             *                                                               &lt;enumeration value="X"/&gt;
             *                                                               &lt;enumeration value="B"/&gt;
             *                                                             &lt;/restriction&gt;
             *                                                           &lt;/simpleType&gt;
             *                                                         &lt;/attribute&gt;
             *                                                         &lt;attribute name="cod_pr"&gt;
             *                                                           &lt;simpleType&gt;
             *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                               &lt;length value="16"/&gt;
             *                                                             &lt;/restriction&gt;
             *                                                           &lt;/simpleType&gt;
             *                                                         &lt;/attribute&gt;
             *                                                       &lt;/restriction&gt;
             *                                                     &lt;/complexContent&gt;
             *                                                   &lt;/complexType&gt;
             *                                                 &lt;/element&gt;
             *                                                 &lt;element name="FARMACO" maxOccurs="unbounded"&gt;
             *                                                   &lt;complexType&gt;
             *                                                     &lt;complexContent&gt;
             *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                                         &lt;attribute name="cod_f"&gt;
             *                                                           &lt;simpleType&gt;
             *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                               &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
             *                                                             &lt;/restriction&gt;
             *                                                           &lt;/simpleType&gt;
             *                                                         &lt;/attribute&gt;
             *                                                         &lt;attribute name="tipo_f" use="required"&gt;
             *                                                           &lt;simpleType&gt;
             *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                               &lt;enumeration value="1"/&gt;
             *                                                               &lt;enumeration value="2"/&gt;
             *                                                               &lt;enumeration value="3"/&gt;
             *                                                               &lt;enumeration value="4"/&gt;
             *                                                               &lt;enumeration value="5"/&gt;
             *                                                               &lt;enumeration value="6"/&gt;
             *                                                             &lt;/restriction&gt;
             *                                                           &lt;/simpleType&gt;
             *                                                         &lt;/attribute&gt;
             *                                                         &lt;attribute name="targatura"&gt;
             *                                                           &lt;simpleType&gt;
             *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                               &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
             *                                                             &lt;/restriction&gt;
             *                                                           &lt;/simpleType&gt;
             *                                                         &lt;/attribute&gt;
             *                                                         &lt;attribute name="costo_acq" use="required"&gt;
             *                                                           &lt;simpleType&gt;
             *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                               &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
             *                                                             &lt;/restriction&gt;
             *                                                           &lt;/simpleType&gt;
             *                                                         &lt;/attribute&gt;
             *                                                         &lt;attribute name="costo_srv"&gt;
             *                                                           &lt;simpleType&gt;
             *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                               &lt;pattern value="-{0,1}[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
             *                                                             &lt;/restriction&gt;
             *                                                           &lt;/simpleType&gt;
             *                                                         &lt;/attribute&gt;
             *                                                         &lt;attribute name="qta" use="required"&gt;
             *                                                           &lt;simpleType&gt;
             *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                               &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
             *                                                             &lt;/restriction&gt;
             *                                                           &lt;/simpleType&gt;
             *                                                         &lt;/attribute&gt;
             *                                                         &lt;attribute name="fatt_conv" use="required"&gt;
             *                                                           &lt;simpleType&gt;
             *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *                                                               &lt;minInclusive value="1"/&gt;
             *                                                               &lt;maxInclusive value="999999"/&gt;
             *                                                             &lt;/restriction&gt;
             *                                                           &lt;/simpleType&gt;
             *                                                         &lt;/attribute&gt;
             *                                                       &lt;/restriction&gt;
             *                                                     &lt;/complexContent&gt;
             *                                                   &lt;/complexType&gt;
             *                                                 &lt;/element&gt;
             *                                               &lt;/sequence&gt;
             *                                               &lt;attribute name="tipo_cont" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;pattern value="[1-2]{1}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="id_cont" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;maxLength value="20"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="dat_erog" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
             *                                                     &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="tipo_esen"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;enumeration value="0"/&gt;
             *                                                     &lt;enumeration value="1"/&gt;
             *                                                     &lt;enumeration value="2"/&gt;
             *                                                     &lt;enumeration value="3"/&gt;
             *                                                     &lt;enumeration value="4"/&gt;
             *                                                     &lt;enumeration value="5"/&gt;
             *                                                     &lt;enumeration value="9"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="tipo_erog" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;pattern value="[0-9]{2}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="tipo_canale" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;enumeration value="P"/&gt;
             *                                                     &lt;enumeration value="D"/&gt;
             *                                                     &lt;enumeration value="R"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="cod_esen"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;pattern value="[0-9A-Za-z]{1,6}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="quota_fissa_ass"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="quota_perc_ass"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="dat_pres"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
             *                                                     &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="costo_srv_ric"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;pattern value="[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                             &lt;/restriction&gt;
             *                                           &lt;/complexContent&gt;
             *                                         &lt;/complexType&gt;
             *                                       &lt;/element&gt;
             *                                     &lt;/sequence&gt;
             *                                     &lt;attribute name="tipo_op" use="required"&gt;
             *                                       &lt;simpleType&gt;
             *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                           &lt;enumeration value="I"/&gt;
             *                                           &lt;enumeration value="V"/&gt;
             *                                           &lt;enumeration value="C"/&gt;
             *                                         &lt;/restriction&gt;
             *                                       &lt;/simpleType&gt;
             *                                     &lt;/attribute&gt;
             *                                   &lt;/restriction&gt;
             *                                 &lt;/complexContent&gt;
             *                               &lt;/complexType&gt;
             *                             &lt;/element&gt;
             *                           &lt;/sequence&gt;
             *                           &lt;attribute name="id_ass"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;length value="88"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                           &lt;attribute name="vld_id_ass"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;enumeration value="0"/&gt;
             *                                 &lt;enumeration value="1"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                           &lt;attribute name="tip_id_ass"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;enumeration value="0"/&gt;
             *                                 &lt;enumeration value="1"/&gt;
             *                                 &lt;enumeration value="2"/&gt;
             *                                 &lt;enumeration value="3"/&gt;
             *                                 &lt;enumeration value="4"/&gt;
             *                                 &lt;enumeration value="97"/&gt;
             *                                 &lt;enumeration value="98"/&gt;
             *                                 &lt;enumeration value="99"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                           &lt;attribute name="dat_nasc"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
             *                                 &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                           &lt;attribute name="sesso"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;enumeration value="1"/&gt;
             *                                 &lt;enumeration value="2"/&gt;
             *                                 &lt;enumeration value="9"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                           &lt;attribute name="cod_asl_ass"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;pattern value="[0-9]{6}"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                           &lt;attribute name="citt"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;enumeration value="1"/&gt;
             *                                 &lt;enumeration value="2"/&gt;
             *                                 &lt;enumeration value="9"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                           &lt;attribute name="stat_est"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;pattern value="[a-zA-Z]{2}"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                           &lt;attribute name="cod_ist_comp"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;length value="28"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/complexContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *                 &lt;attribute name="tipo_er" use="required"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;pattern value="[0-9]{2}"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *                 &lt;attribute name="tipo_str"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;pattern value="[0-9]{2}"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *                 &lt;attribute name="id_er" use="required"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="cod_asl" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;pattern value="[0-9]{6}"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "erogatore"
            })
            public static class ASL {

                @XmlElement(name = "EROGATORE", required = true)
                protected List<EROGATORE> erogatore;
                @XmlAttribute(name = "cod_asl", required = true)
                protected String codAsl;

                /**
                 * Gets the value of the erogatore property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the erogatore property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getEROGATORE().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link EROGATORE }
                 * 
                 * 
                 */
                public List<EROGATORE> getEROGATORE() {
                    if (erogatore == null) {
                        erogatore = new ArrayList<EROGATORE>();
                    }
                    return this.erogatore;
                }

                /**
                 * Recupera il valore della proprietà codAsl.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodAsl() {
                    return codAsl;
                }

                /**
                 * Imposta il valore della proprietà codAsl.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodAsl(String value) {
                    this.codAsl = value;
                }


                /**
                 * <p>Classe Java per anonymous complex type.
                 * 
                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="ASSISTITO" maxOccurs="unbounded"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
                 *                     &lt;complexType&gt;
                 *                       &lt;complexContent&gt;
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                           &lt;sequence&gt;
                 *                             &lt;element name="PRESCRIZIONE" maxOccurs="unbounded"&gt;
                 *                               &lt;complexType&gt;
                 *                                 &lt;complexContent&gt;
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                     &lt;sequence&gt;
                 *                                       &lt;element name="PRESCRITTORE"&gt;
                 *                                         &lt;complexType&gt;
                 *                                           &lt;complexContent&gt;
                 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                               &lt;attribute name="tipo_pr"&gt;
                 *                                                 &lt;simpleType&gt;
                 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                                     &lt;enumeration value="F"/&gt;
                 *                                                     &lt;enumeration value="P"/&gt;
                 *                                                     &lt;enumeration value="H"/&gt;
                 *                                                     &lt;enumeration value="A"/&gt;
                 *                                                     &lt;enumeration value="G"/&gt;
                 *                                                     &lt;enumeration value="T"/&gt;
                 *                                                     &lt;enumeration value="C"/&gt;
                 *                                                     &lt;enumeration value="U"/&gt;
                 *                                                     &lt;enumeration value="D"/&gt;
                 *                                                     &lt;enumeration value="Z"/&gt;
                 *                                                     &lt;enumeration value="I"/&gt;
                 *                                                     &lt;enumeration value="X"/&gt;
                 *                                                     &lt;enumeration value="B"/&gt;
                 *                                                   &lt;/restriction&gt;
                 *                                                 &lt;/simpleType&gt;
                 *                                               &lt;/attribute&gt;
                 *                                               &lt;attribute name="cod_pr"&gt;
                 *                                                 &lt;simpleType&gt;
                 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                                     &lt;length value="16"/&gt;
                 *                                                   &lt;/restriction&gt;
                 *                                                 &lt;/simpleType&gt;
                 *                                               &lt;/attribute&gt;
                 *                                             &lt;/restriction&gt;
                 *                                           &lt;/complexContent&gt;
                 *                                         &lt;/complexType&gt;
                 *                                       &lt;/element&gt;
                 *                                       &lt;element name="FARMACO" maxOccurs="unbounded"&gt;
                 *                                         &lt;complexType&gt;
                 *                                           &lt;complexContent&gt;
                 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                               &lt;attribute name="cod_f"&gt;
                 *                                                 &lt;simpleType&gt;
                 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                                     &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
                 *                                                   &lt;/restriction&gt;
                 *                                                 &lt;/simpleType&gt;
                 *                                               &lt;/attribute&gt;
                 *                                               &lt;attribute name="tipo_f" use="required"&gt;
                 *                                                 &lt;simpleType&gt;
                 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                                     &lt;enumeration value="1"/&gt;
                 *                                                     &lt;enumeration value="2"/&gt;
                 *                                                     &lt;enumeration value="3"/&gt;
                 *                                                     &lt;enumeration value="4"/&gt;
                 *                                                     &lt;enumeration value="5"/&gt;
                 *                                                     &lt;enumeration value="6"/&gt;
                 *                                                   &lt;/restriction&gt;
                 *                                                 &lt;/simpleType&gt;
                 *                                               &lt;/attribute&gt;
                 *                                               &lt;attribute name="targatura"&gt;
                 *                                                 &lt;simpleType&gt;
                 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                                     &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                 *                                                   &lt;/restriction&gt;
                 *                                                 &lt;/simpleType&gt;
                 *                                               &lt;/attribute&gt;
                 *                                               &lt;attribute name="costo_acq" use="required"&gt;
                 *                                                 &lt;simpleType&gt;
                 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                                     &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
                 *                                                   &lt;/restriction&gt;
                 *                                                 &lt;/simpleType&gt;
                 *                                               &lt;/attribute&gt;
                 *                                               &lt;attribute name="costo_srv"&gt;
                 *                                                 &lt;simpleType&gt;
                 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                                     &lt;pattern value="-{0,1}[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
                 *                                                   &lt;/restriction&gt;
                 *                                                 &lt;/simpleType&gt;
                 *                                               &lt;/attribute&gt;
                 *                                               &lt;attribute name="qta" use="required"&gt;
                 *                                                 &lt;simpleType&gt;
                 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                                     &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
                 *                                                   &lt;/restriction&gt;
                 *                                                 &lt;/simpleType&gt;
                 *                                               &lt;/attribute&gt;
                 *                                               &lt;attribute name="fatt_conv" use="required"&gt;
                 *                                                 &lt;simpleType&gt;
                 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                 *                                                     &lt;minInclusive value="1"/&gt;
                 *                                                     &lt;maxInclusive value="999999"/&gt;
                 *                                                   &lt;/restriction&gt;
                 *                                                 &lt;/simpleType&gt;
                 *                                               &lt;/attribute&gt;
                 *                                             &lt;/restriction&gt;
                 *                                           &lt;/complexContent&gt;
                 *                                         &lt;/complexType&gt;
                 *                                       &lt;/element&gt;
                 *                                     &lt;/sequence&gt;
                 *                                     &lt;attribute name="tipo_cont" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;pattern value="[1-2]{1}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="id_cont" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;maxLength value="20"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="dat_erog" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                 *                                           &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="tipo_esen"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;enumeration value="0"/&gt;
                 *                                           &lt;enumeration value="1"/&gt;
                 *                                           &lt;enumeration value="2"/&gt;
                 *                                           &lt;enumeration value="3"/&gt;
                 *                                           &lt;enumeration value="4"/&gt;
                 *                                           &lt;enumeration value="5"/&gt;
                 *                                           &lt;enumeration value="9"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="tipo_erog" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;pattern value="[0-9]{2}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="tipo_canale" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;enumeration value="P"/&gt;
                 *                                           &lt;enumeration value="D"/&gt;
                 *                                           &lt;enumeration value="R"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="cod_esen"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;pattern value="[0-9A-Za-z]{1,6}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="quota_fissa_ass"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="quota_perc_ass"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="dat_pres"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                 *                                           &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="costo_srv_ric"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;pattern value="[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                   &lt;/restriction&gt;
                 *                                 &lt;/complexContent&gt;
                 *                               &lt;/complexType&gt;
                 *                             &lt;/element&gt;
                 *                           &lt;/sequence&gt;
                 *                           &lt;attribute name="tipo_op" use="required"&gt;
                 *                             &lt;simpleType&gt;
                 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                 &lt;enumeration value="I"/&gt;
                 *                                 &lt;enumeration value="V"/&gt;
                 *                                 &lt;enumeration value="C"/&gt;
                 *                               &lt;/restriction&gt;
                 *                             &lt;/simpleType&gt;
                 *                           &lt;/attribute&gt;
                 *                         &lt;/restriction&gt;
                 *                       &lt;/complexContent&gt;
                 *                     &lt;/complexType&gt;
                 *                   &lt;/element&gt;
                 *                 &lt;/sequence&gt;
                 *                 &lt;attribute name="id_ass"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;length value="88"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *                 &lt;attribute name="vld_id_ass"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;enumeration value="0"/&gt;
                 *                       &lt;enumeration value="1"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *                 &lt;attribute name="tip_id_ass"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;enumeration value="0"/&gt;
                 *                       &lt;enumeration value="1"/&gt;
                 *                       &lt;enumeration value="2"/&gt;
                 *                       &lt;enumeration value="3"/&gt;
                 *                       &lt;enumeration value="4"/&gt;
                 *                       &lt;enumeration value="97"/&gt;
                 *                       &lt;enumeration value="98"/&gt;
                 *                       &lt;enumeration value="99"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *                 &lt;attribute name="dat_nasc"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                 *                       &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *                 &lt;attribute name="sesso"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;enumeration value="1"/&gt;
                 *                       &lt;enumeration value="2"/&gt;
                 *                       &lt;enumeration value="9"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *                 &lt;attribute name="cod_asl_ass"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;pattern value="[0-9]{6}"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *                 &lt;attribute name="citt"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;enumeration value="1"/&gt;
                 *                       &lt;enumeration value="2"/&gt;
                 *                       &lt;enumeration value="9"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *                 &lt;attribute name="stat_est"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;pattern value="[a-zA-Z]{2}"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *                 &lt;attribute name="cod_ist_comp"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;length value="28"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *       &lt;attribute name="tipo_er" use="required"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;pattern value="[0-9]{2}"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *       &lt;attribute name="tipo_str"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;pattern value="[0-9]{2}"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *       &lt;attribute name="id_er" use="required"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "assistito"
                })
                public static class EROGATORE {

                    @XmlElement(name = "ASSISTITO", required = true)
                    protected List<ASSISTITO> assistito;
                    @XmlAttribute(name = "tipo_er", required = true)
                    protected String tipoEr;
                    @XmlAttribute(name = "tipo_str")
                    protected String tipoStr;
                    @XmlAttribute(name = "id_er", required = true)
                    protected String idEr;

                    /**
                     * Gets the value of the assistito property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the Jakarta XML Binding object.
                     * This is why there is not a <CODE>set</CODE> method for the assistito property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getASSISTITO().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ASSISTITO }
                     * 
                     * 
                     */
                    public List<ASSISTITO> getASSISTITO() {
                        if (assistito == null) {
                            assistito = new ArrayList<ASSISTITO>();
                        }
                        return this.assistito;
                    }

                    /**
                     * Recupera il valore della proprietà tipoEr.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTipoEr() {
                        return tipoEr;
                    }

                    /**
                     * Imposta il valore della proprietà tipoEr.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTipoEr(String value) {
                        this.tipoEr = value;
                    }

                    /**
                     * Recupera il valore della proprietà tipoStr.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTipoStr() {
                        return tipoStr;
                    }

                    /**
                     * Imposta il valore della proprietà tipoStr.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTipoStr(String value) {
                        this.tipoStr = value;
                    }

                    /**
                     * Recupera il valore della proprietà idEr.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getIdEr() {
                        return idEr;
                    }

                    /**
                     * Imposta il valore della proprietà idEr.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setIdEr(String value) {
                        this.idEr = value;
                    }


                    /**
                     * <p>Classe Java per anonymous complex type.
                     * 
                     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;complexContent&gt;
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *       &lt;sequence&gt;
                     *         &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
                     *           &lt;complexType&gt;
                     *             &lt;complexContent&gt;
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                 &lt;sequence&gt;
                     *                   &lt;element name="PRESCRIZIONE" maxOccurs="unbounded"&gt;
                     *                     &lt;complexType&gt;
                     *                       &lt;complexContent&gt;
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                           &lt;sequence&gt;
                     *                             &lt;element name="PRESCRITTORE"&gt;
                     *                               &lt;complexType&gt;
                     *                                 &lt;complexContent&gt;
                     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                                     &lt;attribute name="tipo_pr"&gt;
                     *                                       &lt;simpleType&gt;
                     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                           &lt;enumeration value="F"/&gt;
                     *                                           &lt;enumeration value="P"/&gt;
                     *                                           &lt;enumeration value="H"/&gt;
                     *                                           &lt;enumeration value="A"/&gt;
                     *                                           &lt;enumeration value="G"/&gt;
                     *                                           &lt;enumeration value="T"/&gt;
                     *                                           &lt;enumeration value="C"/&gt;
                     *                                           &lt;enumeration value="U"/&gt;
                     *                                           &lt;enumeration value="D"/&gt;
                     *                                           &lt;enumeration value="Z"/&gt;
                     *                                           &lt;enumeration value="I"/&gt;
                     *                                           &lt;enumeration value="X"/&gt;
                     *                                           &lt;enumeration value="B"/&gt;
                     *                                         &lt;/restriction&gt;
                     *                                       &lt;/simpleType&gt;
                     *                                     &lt;/attribute&gt;
                     *                                     &lt;attribute name="cod_pr"&gt;
                     *                                       &lt;simpleType&gt;
                     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                           &lt;length value="16"/&gt;
                     *                                         &lt;/restriction&gt;
                     *                                       &lt;/simpleType&gt;
                     *                                     &lt;/attribute&gt;
                     *                                   &lt;/restriction&gt;
                     *                                 &lt;/complexContent&gt;
                     *                               &lt;/complexType&gt;
                     *                             &lt;/element&gt;
                     *                             &lt;element name="FARMACO" maxOccurs="unbounded"&gt;
                     *                               &lt;complexType&gt;
                     *                                 &lt;complexContent&gt;
                     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                                     &lt;attribute name="cod_f"&gt;
                     *                                       &lt;simpleType&gt;
                     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                           &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
                     *                                         &lt;/restriction&gt;
                     *                                       &lt;/simpleType&gt;
                     *                                     &lt;/attribute&gt;
                     *                                     &lt;attribute name="tipo_f" use="required"&gt;
                     *                                       &lt;simpleType&gt;
                     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                           &lt;enumeration value="1"/&gt;
                     *                                           &lt;enumeration value="2"/&gt;
                     *                                           &lt;enumeration value="3"/&gt;
                     *                                           &lt;enumeration value="4"/&gt;
                     *                                           &lt;enumeration value="5"/&gt;
                     *                                           &lt;enumeration value="6"/&gt;
                     *                                         &lt;/restriction&gt;
                     *                                       &lt;/simpleType&gt;
                     *                                     &lt;/attribute&gt;
                     *                                     &lt;attribute name="targatura"&gt;
                     *                                       &lt;simpleType&gt;
                     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                           &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                     *                                         &lt;/restriction&gt;
                     *                                       &lt;/simpleType&gt;
                     *                                     &lt;/attribute&gt;
                     *                                     &lt;attribute name="costo_acq" use="required"&gt;
                     *                                       &lt;simpleType&gt;
                     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                           &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
                     *                                         &lt;/restriction&gt;
                     *                                       &lt;/simpleType&gt;
                     *                                     &lt;/attribute&gt;
                     *                                     &lt;attribute name="costo_srv"&gt;
                     *                                       &lt;simpleType&gt;
                     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                           &lt;pattern value="-{0,1}[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
                     *                                         &lt;/restriction&gt;
                     *                                       &lt;/simpleType&gt;
                     *                                     &lt;/attribute&gt;
                     *                                     &lt;attribute name="qta" use="required"&gt;
                     *                                       &lt;simpleType&gt;
                     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                           &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
                     *                                         &lt;/restriction&gt;
                     *                                       &lt;/simpleType&gt;
                     *                                     &lt;/attribute&gt;
                     *                                     &lt;attribute name="fatt_conv" use="required"&gt;
                     *                                       &lt;simpleType&gt;
                     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                     *                                           &lt;minInclusive value="1"/&gt;
                     *                                           &lt;maxInclusive value="999999"/&gt;
                     *                                         &lt;/restriction&gt;
                     *                                       &lt;/simpleType&gt;
                     *                                     &lt;/attribute&gt;
                     *                                   &lt;/restriction&gt;
                     *                                 &lt;/complexContent&gt;
                     *                               &lt;/complexType&gt;
                     *                             &lt;/element&gt;
                     *                           &lt;/sequence&gt;
                     *                           &lt;attribute name="tipo_cont" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;pattern value="[1-2]{1}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="id_cont" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;maxLength value="20"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="dat_erog" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                     *                                 &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="tipo_esen"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;enumeration value="0"/&gt;
                     *                                 &lt;enumeration value="1"/&gt;
                     *                                 &lt;enumeration value="2"/&gt;
                     *                                 &lt;enumeration value="3"/&gt;
                     *                                 &lt;enumeration value="4"/&gt;
                     *                                 &lt;enumeration value="5"/&gt;
                     *                                 &lt;enumeration value="9"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="tipo_erog" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;pattern value="[0-9]{2}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="tipo_canale" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;enumeration value="P"/&gt;
                     *                                 &lt;enumeration value="D"/&gt;
                     *                                 &lt;enumeration value="R"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="cod_esen"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;pattern value="[0-9A-Za-z]{1,6}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="quota_fissa_ass"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="quota_perc_ass"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="dat_pres"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                     *                                 &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="costo_srv_ric"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;pattern value="[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                         &lt;/restriction&gt;
                     *                       &lt;/complexContent&gt;
                     *                     &lt;/complexType&gt;
                     *                   &lt;/element&gt;
                     *                 &lt;/sequence&gt;
                     *                 &lt;attribute name="tipo_op" use="required"&gt;
                     *                   &lt;simpleType&gt;
                     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                       &lt;enumeration value="I"/&gt;
                     *                       &lt;enumeration value="V"/&gt;
                     *                       &lt;enumeration value="C"/&gt;
                     *                     &lt;/restriction&gt;
                     *                   &lt;/simpleType&gt;
                     *                 &lt;/attribute&gt;
                     *               &lt;/restriction&gt;
                     *             &lt;/complexContent&gt;
                     *           &lt;/complexType&gt;
                     *         &lt;/element&gt;
                     *       &lt;/sequence&gt;
                     *       &lt;attribute name="id_ass"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;length value="88"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *       &lt;attribute name="vld_id_ass"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;enumeration value="0"/&gt;
                     *             &lt;enumeration value="1"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *       &lt;attribute name="tip_id_ass"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;enumeration value="0"/&gt;
                     *             &lt;enumeration value="1"/&gt;
                     *             &lt;enumeration value="2"/&gt;
                     *             &lt;enumeration value="3"/&gt;
                     *             &lt;enumeration value="4"/&gt;
                     *             &lt;enumeration value="97"/&gt;
                     *             &lt;enumeration value="98"/&gt;
                     *             &lt;enumeration value="99"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *       &lt;attribute name="dat_nasc"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                     *             &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *       &lt;attribute name="sesso"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;enumeration value="1"/&gt;
                     *             &lt;enumeration value="2"/&gt;
                     *             &lt;enumeration value="9"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *       &lt;attribute name="cod_asl_ass"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;pattern value="[0-9]{6}"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *       &lt;attribute name="citt"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;enumeration value="1"/&gt;
                     *             &lt;enumeration value="2"/&gt;
                     *             &lt;enumeration value="9"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *       &lt;attribute name="stat_est"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;pattern value="[a-zA-Z]{2}"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *       &lt;attribute name="cod_ist_comp"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;length value="28"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/complexContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "operazione"
                    })
                    public static class ASSISTITO {

                        @XmlElement(name = "OPERAZIONE", required = true)
                        protected List<OPERAZIONE> operazione;
                        @XmlAttribute(name = "id_ass")
                        protected String idAss;
                        @XmlAttribute(name = "vld_id_ass")
                        protected String vldIdAss;
                        @XmlAttribute(name = "tip_id_ass")
                        protected String tipIdAss;
                        @XmlAttribute(name = "dat_nasc")
                        protected XMLGregorianCalendar datNasc;
                        @XmlAttribute(name = "sesso")
                        protected String sesso;
                        @XmlAttribute(name = "cod_asl_ass")
                        protected String codAslAss;
                        @XmlAttribute(name = "citt")
                        protected String citt;
                        @XmlAttribute(name = "stat_est")
                        protected String statEst;
                        @XmlAttribute(name = "cod_ist_comp")
                        protected String codIstComp;

                        /**
                         * Gets the value of the operazione property.
                         * 
                         * <p>
                         * This accessor method returns a reference to the live list,
                         * not a snapshot. Therefore any modification you make to the
                         * returned list will be present inside the Jakarta XML Binding object.
                         * This is why there is not a <CODE>set</CODE> method for the operazione property.
                         * 
                         * <p>
                         * For example, to add a new item, do as follows:
                         * <pre>
                         *    getOPERAZIONE().add(newItem);
                         * </pre>
                         * 
                         * 
                         * <p>
                         * Objects of the following type(s) are allowed in the list
                         * {@link OPERAZIONE }
                         * 
                         * 
                         */
                        public List<OPERAZIONE> getOPERAZIONE() {
                            if (operazione == null) {
                                operazione = new ArrayList<OPERAZIONE>();
                            }
                            return this.operazione;
                        }

                        /**
                         * Recupera il valore della proprietà idAss.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getIdAss() {
                            return idAss;
                        }

                        /**
                         * Imposta il valore della proprietà idAss.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setIdAss(String value) {
                            this.idAss = value;
                        }

                        /**
                         * Recupera il valore della proprietà vldIdAss.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getVldIdAss() {
                            return vldIdAss;
                        }

                        /**
                         * Imposta il valore della proprietà vldIdAss.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setVldIdAss(String value) {
                            this.vldIdAss = value;
                        }

                        /**
                         * Recupera il valore della proprietà tipIdAss.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getTipIdAss() {
                            return tipIdAss;
                        }

                        /**
                         * Imposta il valore della proprietà tipIdAss.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setTipIdAss(String value) {
                            this.tipIdAss = value;
                        }

                        /**
                         * Recupera il valore della proprietà datNasc.
                         * 
                         * @return
                         *     possible object is
                         *     {@link XMLGregorianCalendar }
                         *     
                         */
                        public XMLGregorianCalendar getDatNasc() {
                            return datNasc;
                        }

                        /**
                         * Imposta il valore della proprietà datNasc.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link XMLGregorianCalendar }
                         *     
                         */
                        public void setDatNasc(XMLGregorianCalendar value) {
                            this.datNasc = value;
                        }

                        /**
                         * Recupera il valore della proprietà sesso.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getSesso() {
                            return sesso;
                        }

                        /**
                         * Imposta il valore della proprietà sesso.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setSesso(String value) {
                            this.sesso = value;
                        }

                        /**
                         * Recupera il valore della proprietà codAslAss.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCodAslAss() {
                            return codAslAss;
                        }

                        /**
                         * Imposta il valore della proprietà codAslAss.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCodAslAss(String value) {
                            this.codAslAss = value;
                        }

                        /**
                         * Recupera il valore della proprietà citt.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCitt() {
                            return citt;
                        }

                        /**
                         * Imposta il valore della proprietà citt.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCitt(String value) {
                            this.citt = value;
                        }

                        /**
                         * Recupera il valore della proprietà statEst.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getStatEst() {
                            return statEst;
                        }

                        /**
                         * Imposta il valore della proprietà statEst.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setStatEst(String value) {
                            this.statEst = value;
                        }

                        /**
                         * Recupera il valore della proprietà codIstComp.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCodIstComp() {
                            return codIstComp;
                        }

                        /**
                         * Imposta il valore della proprietà codIstComp.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCodIstComp(String value) {
                            this.codIstComp = value;
                        }


                        /**
                         * <p>Classe Java per anonymous complex type.
                         * 
                         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                         * 
                         * <pre>
                         * &lt;complexType&gt;
                         *   &lt;complexContent&gt;
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *       &lt;sequence&gt;
                         *         &lt;element name="PRESCRIZIONE" maxOccurs="unbounded"&gt;
                         *           &lt;complexType&gt;
                         *             &lt;complexContent&gt;
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                 &lt;sequence&gt;
                         *                   &lt;element name="PRESCRITTORE"&gt;
                         *                     &lt;complexType&gt;
                         *                       &lt;complexContent&gt;
                         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                           &lt;attribute name="tipo_pr"&gt;
                         *                             &lt;simpleType&gt;
                         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                                 &lt;enumeration value="F"/&gt;
                         *                                 &lt;enumeration value="P"/&gt;
                         *                                 &lt;enumeration value="H"/&gt;
                         *                                 &lt;enumeration value="A"/&gt;
                         *                                 &lt;enumeration value="G"/&gt;
                         *                                 &lt;enumeration value="T"/&gt;
                         *                                 &lt;enumeration value="C"/&gt;
                         *                                 &lt;enumeration value="U"/&gt;
                         *                                 &lt;enumeration value="D"/&gt;
                         *                                 &lt;enumeration value="Z"/&gt;
                         *                                 &lt;enumeration value="I"/&gt;
                         *                                 &lt;enumeration value="X"/&gt;
                         *                                 &lt;enumeration value="B"/&gt;
                         *                               &lt;/restriction&gt;
                         *                             &lt;/simpleType&gt;
                         *                           &lt;/attribute&gt;
                         *                           &lt;attribute name="cod_pr"&gt;
                         *                             &lt;simpleType&gt;
                         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                                 &lt;length value="16"/&gt;
                         *                               &lt;/restriction&gt;
                         *                             &lt;/simpleType&gt;
                         *                           &lt;/attribute&gt;
                         *                         &lt;/restriction&gt;
                         *                       &lt;/complexContent&gt;
                         *                     &lt;/complexType&gt;
                         *                   &lt;/element&gt;
                         *                   &lt;element name="FARMACO" maxOccurs="unbounded"&gt;
                         *                     &lt;complexType&gt;
                         *                       &lt;complexContent&gt;
                         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                           &lt;attribute name="cod_f"&gt;
                         *                             &lt;simpleType&gt;
                         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                                 &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
                         *                               &lt;/restriction&gt;
                         *                             &lt;/simpleType&gt;
                         *                           &lt;/attribute&gt;
                         *                           &lt;attribute name="tipo_f" use="required"&gt;
                         *                             &lt;simpleType&gt;
                         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                                 &lt;enumeration value="1"/&gt;
                         *                                 &lt;enumeration value="2"/&gt;
                         *                                 &lt;enumeration value="3"/&gt;
                         *                                 &lt;enumeration value="4"/&gt;
                         *                                 &lt;enumeration value="5"/&gt;
                         *                                 &lt;enumeration value="6"/&gt;
                         *                               &lt;/restriction&gt;
                         *                             &lt;/simpleType&gt;
                         *                           &lt;/attribute&gt;
                         *                           &lt;attribute name="targatura"&gt;
                         *                             &lt;simpleType&gt;
                         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                                 &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                         *                               &lt;/restriction&gt;
                         *                             &lt;/simpleType&gt;
                         *                           &lt;/attribute&gt;
                         *                           &lt;attribute name="costo_acq" use="required"&gt;
                         *                             &lt;simpleType&gt;
                         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                                 &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
                         *                               &lt;/restriction&gt;
                         *                             &lt;/simpleType&gt;
                         *                           &lt;/attribute&gt;
                         *                           &lt;attribute name="costo_srv"&gt;
                         *                             &lt;simpleType&gt;
                         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                                 &lt;pattern value="-{0,1}[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
                         *                               &lt;/restriction&gt;
                         *                             &lt;/simpleType&gt;
                         *                           &lt;/attribute&gt;
                         *                           &lt;attribute name="qta" use="required"&gt;
                         *                             &lt;simpleType&gt;
                         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                                 &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
                         *                               &lt;/restriction&gt;
                         *                             &lt;/simpleType&gt;
                         *                           &lt;/attribute&gt;
                         *                           &lt;attribute name="fatt_conv" use="required"&gt;
                         *                             &lt;simpleType&gt;
                         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                         *                                 &lt;minInclusive value="1"/&gt;
                         *                                 &lt;maxInclusive value="999999"/&gt;
                         *                               &lt;/restriction&gt;
                         *                             &lt;/simpleType&gt;
                         *                           &lt;/attribute&gt;
                         *                         &lt;/restriction&gt;
                         *                       &lt;/complexContent&gt;
                         *                     &lt;/complexType&gt;
                         *                   &lt;/element&gt;
                         *                 &lt;/sequence&gt;
                         *                 &lt;attribute name="tipo_cont" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;pattern value="[1-2]{1}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="id_cont" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;maxLength value="20"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="dat_erog" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                         *                       &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="tipo_esen"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;enumeration value="0"/&gt;
                         *                       &lt;enumeration value="1"/&gt;
                         *                       &lt;enumeration value="2"/&gt;
                         *                       &lt;enumeration value="3"/&gt;
                         *                       &lt;enumeration value="4"/&gt;
                         *                       &lt;enumeration value="5"/&gt;
                         *                       &lt;enumeration value="9"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="tipo_erog" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;pattern value="[0-9]{2}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="tipo_canale" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;enumeration value="P"/&gt;
                         *                       &lt;enumeration value="D"/&gt;
                         *                       &lt;enumeration value="R"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="cod_esen"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;pattern value="[0-9A-Za-z]{1,6}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="quota_fissa_ass"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="quota_perc_ass"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="dat_pres"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                         *                       &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="costo_srv_ric"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;pattern value="[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *               &lt;/restriction&gt;
                         *             &lt;/complexContent&gt;
                         *           &lt;/complexType&gt;
                         *         &lt;/element&gt;
                         *       &lt;/sequence&gt;
                         *       &lt;attribute name="tipo_op" use="required"&gt;
                         *         &lt;simpleType&gt;
                         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *             &lt;enumeration value="I"/&gt;
                         *             &lt;enumeration value="V"/&gt;
                         *             &lt;enumeration value="C"/&gt;
                         *           &lt;/restriction&gt;
                         *         &lt;/simpleType&gt;
                         *       &lt;/attribute&gt;
                         *     &lt;/restriction&gt;
                         *   &lt;/complexContent&gt;
                         * &lt;/complexType&gt;
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "prescrizione"
                        })
                        public static class OPERAZIONE {

                            @XmlElement(name = "PRESCRIZIONE", required = true)
                            protected List<PRESCRIZIONE> prescrizione;
                            @XmlAttribute(name = "tipo_op", required = true)
                            protected String tipoOp;

                            /**
                             * Gets the value of the prescrizione property.
                             * 
                             * <p>
                             * This accessor method returns a reference to the live list,
                             * not a snapshot. Therefore any modification you make to the
                             * returned list will be present inside the Jakarta XML Binding object.
                             * This is why there is not a <CODE>set</CODE> method for the prescrizione property.
                             * 
                             * <p>
                             * For example, to add a new item, do as follows:
                             * <pre>
                             *    getPRESCRIZIONE().add(newItem);
                             * </pre>
                             * 
                             * 
                             * <p>
                             * Objects of the following type(s) are allowed in the list
                             * {@link PRESCRIZIONE }
                             * 
                             * 
                             */
                            public List<PRESCRIZIONE> getPRESCRIZIONE() {
                                if (prescrizione == null) {
                                    prescrizione = new ArrayList<PRESCRIZIONE>();
                                }
                                return this.prescrizione;
                            }

                            /**
                             * Recupera il valore della proprietà tipoOp.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getTipoOp() {
                                return tipoOp;
                            }

                            /**
                             * Imposta il valore della proprietà tipoOp.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setTipoOp(String value) {
                                this.tipoOp = value;
                            }


                            /**
                             * <p>Classe Java per anonymous complex type.
                             * 
                             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                             * 
                             * <pre>
                             * &lt;complexType&gt;
                             *   &lt;complexContent&gt;
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *       &lt;sequence&gt;
                             *         &lt;element name="PRESCRITTORE"&gt;
                             *           &lt;complexType&gt;
                             *             &lt;complexContent&gt;
                             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *                 &lt;attribute name="tipo_pr"&gt;
                             *                   &lt;simpleType&gt;
                             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *                       &lt;enumeration value="F"/&gt;
                             *                       &lt;enumeration value="P"/&gt;
                             *                       &lt;enumeration value="H"/&gt;
                             *                       &lt;enumeration value="A"/&gt;
                             *                       &lt;enumeration value="G"/&gt;
                             *                       &lt;enumeration value="T"/&gt;
                             *                       &lt;enumeration value="C"/&gt;
                             *                       &lt;enumeration value="U"/&gt;
                             *                       &lt;enumeration value="D"/&gt;
                             *                       &lt;enumeration value="Z"/&gt;
                             *                       &lt;enumeration value="I"/&gt;
                             *                       &lt;enumeration value="X"/&gt;
                             *                       &lt;enumeration value="B"/&gt;
                             *                     &lt;/restriction&gt;
                             *                   &lt;/simpleType&gt;
                             *                 &lt;/attribute&gt;
                             *                 &lt;attribute name="cod_pr"&gt;
                             *                   &lt;simpleType&gt;
                             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *                       &lt;length value="16"/&gt;
                             *                     &lt;/restriction&gt;
                             *                   &lt;/simpleType&gt;
                             *                 &lt;/attribute&gt;
                             *               &lt;/restriction&gt;
                             *             &lt;/complexContent&gt;
                             *           &lt;/complexType&gt;
                             *         &lt;/element&gt;
                             *         &lt;element name="FARMACO" maxOccurs="unbounded"&gt;
                             *           &lt;complexType&gt;
                             *             &lt;complexContent&gt;
                             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *                 &lt;attribute name="cod_f"&gt;
                             *                   &lt;simpleType&gt;
                             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *                       &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
                             *                     &lt;/restriction&gt;
                             *                   &lt;/simpleType&gt;
                             *                 &lt;/attribute&gt;
                             *                 &lt;attribute name="tipo_f" use="required"&gt;
                             *                   &lt;simpleType&gt;
                             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *                       &lt;enumeration value="1"/&gt;
                             *                       &lt;enumeration value="2"/&gt;
                             *                       &lt;enumeration value="3"/&gt;
                             *                       &lt;enumeration value="4"/&gt;
                             *                       &lt;enumeration value="5"/&gt;
                             *                       &lt;enumeration value="6"/&gt;
                             *                     &lt;/restriction&gt;
                             *                   &lt;/simpleType&gt;
                             *                 &lt;/attribute&gt;
                             *                 &lt;attribute name="targatura"&gt;
                             *                   &lt;simpleType&gt;
                             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *                       &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                             *                     &lt;/restriction&gt;
                             *                   &lt;/simpleType&gt;
                             *                 &lt;/attribute&gt;
                             *                 &lt;attribute name="costo_acq" use="required"&gt;
                             *                   &lt;simpleType&gt;
                             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *                       &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
                             *                     &lt;/restriction&gt;
                             *                   &lt;/simpleType&gt;
                             *                 &lt;/attribute&gt;
                             *                 &lt;attribute name="costo_srv"&gt;
                             *                   &lt;simpleType&gt;
                             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *                       &lt;pattern value="-{0,1}[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
                             *                     &lt;/restriction&gt;
                             *                   &lt;/simpleType&gt;
                             *                 &lt;/attribute&gt;
                             *                 &lt;attribute name="qta" use="required"&gt;
                             *                   &lt;simpleType&gt;
                             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *                       &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
                             *                     &lt;/restriction&gt;
                             *                   &lt;/simpleType&gt;
                             *                 &lt;/attribute&gt;
                             *                 &lt;attribute name="fatt_conv" use="required"&gt;
                             *                   &lt;simpleType&gt;
                             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                             *                       &lt;minInclusive value="1"/&gt;
                             *                       &lt;maxInclusive value="999999"/&gt;
                             *                     &lt;/restriction&gt;
                             *                   &lt;/simpleType&gt;
                             *                 &lt;/attribute&gt;
                             *               &lt;/restriction&gt;
                             *             &lt;/complexContent&gt;
                             *           &lt;/complexType&gt;
                             *         &lt;/element&gt;
                             *       &lt;/sequence&gt;
                             *       &lt;attribute name="tipo_cont" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;pattern value="[1-2]{1}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="id_cont" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;maxLength value="20"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="dat_erog" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                             *             &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="tipo_esen"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;enumeration value="0"/&gt;
                             *             &lt;enumeration value="1"/&gt;
                             *             &lt;enumeration value="2"/&gt;
                             *             &lt;enumeration value="3"/&gt;
                             *             &lt;enumeration value="4"/&gt;
                             *             &lt;enumeration value="5"/&gt;
                             *             &lt;enumeration value="9"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="tipo_erog" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;pattern value="[0-9]{2}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="tipo_canale" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;enumeration value="P"/&gt;
                             *             &lt;enumeration value="D"/&gt;
                             *             &lt;enumeration value="R"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="cod_esen"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;pattern value="[0-9A-Za-z]{1,6}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="quota_fissa_ass"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="quota_perc_ass"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;pattern value="[0-9]{1,3}\.{1}[0-9]{2}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="dat_pres"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
                             *             &lt;pattern value="[0-9]{4}-[0-9]{2}-[0-9]{2}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="costo_srv_ric"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;pattern value="[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *     &lt;/restriction&gt;
                             *   &lt;/complexContent&gt;
                             * &lt;/complexType&gt;
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "prescrittore",
                                "farmaco"
                            })
                            public static class PRESCRIZIONE {

                                @XmlElement(name = "PRESCRITTORE", required = true)
                                protected PRESCRITTORE prescrittore;
                                @XmlElement(name = "FARMACO", required = true)
                                protected List<FARMACO> farmaco;
                                @XmlAttribute(name = "tipo_cont", required = true)
                                protected String tipoCont;
                                @XmlAttribute(name = "id_cont", required = true)
                                protected String idCont;
                                @XmlAttribute(name = "dat_erog", required = true)
                                protected XMLGregorianCalendar datErog;
                                @XmlAttribute(name = "tipo_esen")
                                protected String tipoEsen;
                                @XmlAttribute(name = "tipo_erog", required = true)
                                protected String tipoErog;
                                @XmlAttribute(name = "tipo_canale", required = true)
                                protected String tipoCanale;
                                @XmlAttribute(name = "cod_esen")
                                protected String codEsen;
                                @XmlAttribute(name = "quota_fissa_ass")
                                protected String quotaFissaAss;
                                @XmlAttribute(name = "quota_perc_ass")
                                protected String quotaPercAss;
                                @XmlAttribute(name = "dat_pres")
                                protected XMLGregorianCalendar datPres;
                                @XmlAttribute(name = "costo_srv_ric")
                                protected String costoSrvRic;

                                /**
                                 * Recupera il valore della proprietà prescrittore.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link PRESCRITTORE }
                                 *     
                                 */
                                public PRESCRITTORE getPRESCRITTORE() {
                                    return prescrittore;
                                }

                                /**
                                 * Imposta il valore della proprietà prescrittore.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link PRESCRITTORE }
                                 *     
                                 */
                                public void setPRESCRITTORE(PRESCRITTORE value) {
                                    this.prescrittore = value;
                                }

                                /**
                                 * Gets the value of the farmaco property.
                                 * 
                                 * <p>
                                 * This accessor method returns a reference to the live list,
                                 * not a snapshot. Therefore any modification you make to the
                                 * returned list will be present inside the Jakarta XML Binding object.
                                 * This is why there is not a <CODE>set</CODE> method for the farmaco property.
                                 * 
                                 * <p>
                                 * For example, to add a new item, do as follows:
                                 * <pre>
                                 *    getFARMACO().add(newItem);
                                 * </pre>
                                 * 
                                 * 
                                 * <p>
                                 * Objects of the following type(s) are allowed in the list
                                 * {@link FARMACO }
                                 * 
                                 * 
                                 */
                                public List<FARMACO> getFARMACO() {
                                    if (farmaco == null) {
                                        farmaco = new ArrayList<FARMACO>();
                                    }
                                    return this.farmaco;
                                }

                                /**
                                 * Recupera il valore della proprietà tipoCont.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTipoCont() {
                                    return tipoCont;
                                }

                                /**
                                 * Imposta il valore della proprietà tipoCont.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTipoCont(String value) {
                                    this.tipoCont = value;
                                }

                                /**
                                 * Recupera il valore della proprietà idCont.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getIdCont() {
                                    return idCont;
                                }

                                /**
                                 * Imposta il valore della proprietà idCont.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setIdCont(String value) {
                                    this.idCont = value;
                                }

                                /**
                                 * Recupera il valore della proprietà datErog.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link XMLGregorianCalendar }
                                 *     
                                 */
                                public XMLGregorianCalendar getDatErog() {
                                    return datErog;
                                }

                                /**
                                 * Imposta il valore della proprietà datErog.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link XMLGregorianCalendar }
                                 *     
                                 */
                                public void setDatErog(XMLGregorianCalendar value) {
                                    this.datErog = value;
                                }

                                /**
                                 * Recupera il valore della proprietà tipoEsen.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTipoEsen() {
                                    return tipoEsen;
                                }

                                /**
                                 * Imposta il valore della proprietà tipoEsen.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTipoEsen(String value) {
                                    this.tipoEsen = value;
                                }

                                /**
                                 * Recupera il valore della proprietà tipoErog.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTipoErog() {
                                    return tipoErog;
                                }

                                /**
                                 * Imposta il valore della proprietà tipoErog.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTipoErog(String value) {
                                    this.tipoErog = value;
                                }

                                /**
                                 * Recupera il valore della proprietà tipoCanale.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTipoCanale() {
                                    return tipoCanale;
                                }

                                /**
                                 * Imposta il valore della proprietà tipoCanale.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTipoCanale(String value) {
                                    this.tipoCanale = value;
                                }

                                /**
                                 * Recupera il valore della proprietà codEsen.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getCodEsen() {
                                    return codEsen;
                                }

                                /**
                                 * Imposta il valore della proprietà codEsen.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setCodEsen(String value) {
                                    this.codEsen = value;
                                }

                                /**
                                 * Recupera il valore della proprietà quotaFissaAss.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getQuotaFissaAss() {
                                    return quotaFissaAss;
                                }

                                /**
                                 * Imposta il valore della proprietà quotaFissaAss.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setQuotaFissaAss(String value) {
                                    this.quotaFissaAss = value;
                                }

                                /**
                                 * Recupera il valore della proprietà quotaPercAss.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getQuotaPercAss() {
                                    return quotaPercAss;
                                }

                                /**
                                 * Imposta il valore della proprietà quotaPercAss.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setQuotaPercAss(String value) {
                                    this.quotaPercAss = value;
                                }

                                /**
                                 * Recupera il valore della proprietà datPres.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link XMLGregorianCalendar }
                                 *     
                                 */
                                public XMLGregorianCalendar getDatPres() {
                                    return datPres;
                                }

                                /**
                                 * Imposta il valore della proprietà datPres.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link XMLGregorianCalendar }
                                 *     
                                 */
                                public void setDatPres(XMLGregorianCalendar value) {
                                    this.datPres = value;
                                }

                                /**
                                 * Recupera il valore della proprietà costoSrvRic.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getCostoSrvRic() {
                                    return costoSrvRic;
                                }

                                /**
                                 * Imposta il valore della proprietà costoSrvRic.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setCostoSrvRic(String value) {
                                    this.costoSrvRic = value;
                                }


                                /**
                                 * <p>Classe Java per anonymous complex type.
                                 * 
                                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                                 * 
                                 * <pre>
                                 * &lt;complexType&gt;
                                 *   &lt;complexContent&gt;
                                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                                 *       &lt;attribute name="cod_f"&gt;
                                 *         &lt;simpleType&gt;
                                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                                 *             &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
                                 *           &lt;/restriction&gt;
                                 *         &lt;/simpleType&gt;
                                 *       &lt;/attribute&gt;
                                 *       &lt;attribute name="tipo_f" use="required"&gt;
                                 *         &lt;simpleType&gt;
                                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                                 *             &lt;enumeration value="1"/&gt;
                                 *             &lt;enumeration value="2"/&gt;
                                 *             &lt;enumeration value="3"/&gt;
                                 *             &lt;enumeration value="4"/&gt;
                                 *             &lt;enumeration value="5"/&gt;
                                 *             &lt;enumeration value="6"/&gt;
                                 *           &lt;/restriction&gt;
                                 *         &lt;/simpleType&gt;
                                 *       &lt;/attribute&gt;
                                 *       &lt;attribute name="targatura"&gt;
                                 *         &lt;simpleType&gt;
                                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                                 *             &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                                 *           &lt;/restriction&gt;
                                 *         &lt;/simpleType&gt;
                                 *       &lt;/attribute&gt;
                                 *       &lt;attribute name="costo_acq" use="required"&gt;
                                 *         &lt;simpleType&gt;
                                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                                 *             &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
                                 *           &lt;/restriction&gt;
                                 *         &lt;/simpleType&gt;
                                 *       &lt;/attribute&gt;
                                 *       &lt;attribute name="costo_srv"&gt;
                                 *         &lt;simpleType&gt;
                                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                                 *             &lt;pattern value="-{0,1}[0-9]{1,4}\.{1}[0-9]{2}"/&gt;
                                 *           &lt;/restriction&gt;
                                 *         &lt;/simpleType&gt;
                                 *       &lt;/attribute&gt;
                                 *       &lt;attribute name="qta" use="required"&gt;
                                 *         &lt;simpleType&gt;
                                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                                 *             &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
                                 *           &lt;/restriction&gt;
                                 *         &lt;/simpleType&gt;
                                 *       &lt;/attribute&gt;
                                 *       &lt;attribute name="fatt_conv" use="required"&gt;
                                 *         &lt;simpleType&gt;
                                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                                 *             &lt;minInclusive value="1"/&gt;
                                 *             &lt;maxInclusive value="999999"/&gt;
                                 *           &lt;/restriction&gt;
                                 *         &lt;/simpleType&gt;
                                 *       &lt;/attribute&gt;
                                 *     &lt;/restriction&gt;
                                 *   &lt;/complexContent&gt;
                                 * &lt;/complexType&gt;
                                 * </pre>
                                 * 
                                 * 
                                 */
                                @XmlAccessorType(XmlAccessType.FIELD)
                                @XmlType(name = "")
                                public static class FARMACO {

                                    @XmlAttribute(name = "cod_f")
                                    protected String codF;
                                    @XmlAttribute(name = "tipo_f", required = true)
                                    protected String tipoF;
                                    @XmlAttribute(name = "targatura")
                                    protected String targatura;
                                    @XmlAttribute(name = "costo_acq", required = true)
                                    protected String costoAcq;
                                    @XmlAttribute(name = "costo_srv")
                                    protected String costoSrv;
                                    @XmlAttribute(name = "qta", required = true)
                                    protected String qta;
                                    @XmlAttribute(name = "fatt_conv", required = true)
                                    protected int fattConv;

                                    /**
                                     * Recupera il valore della proprietà codF.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getCodF() {
                                        return codF;
                                    }

                                    /**
                                     * Imposta il valore della proprietà codF.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setCodF(String value) {
                                        this.codF = value;
                                    }

                                    /**
                                     * Recupera il valore della proprietà tipoF.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getTipoF() {
                                        return tipoF;
                                    }

                                    /**
                                     * Imposta il valore della proprietà tipoF.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setTipoF(String value) {
                                        this.tipoF = value;
                                    }

                                    /**
                                     * Recupera il valore della proprietà targatura.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getTargatura() {
                                        return targatura;
                                    }

                                    /**
                                     * Imposta il valore della proprietà targatura.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setTargatura(String value) {
                                        this.targatura = value;
                                    }

                                    /**
                                     * Recupera il valore della proprietà costoAcq.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getCostoAcq() {
                                        return costoAcq;
                                    }

                                    /**
                                     * Imposta il valore della proprietà costoAcq.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setCostoAcq(String value) {
                                        this.costoAcq = value;
                                    }

                                    /**
                                     * Recupera il valore della proprietà costoSrv.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getCostoSrv() {
                                        return costoSrv;
                                    }

                                    /**
                                     * Imposta il valore della proprietà costoSrv.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setCostoSrv(String value) {
                                        this.costoSrv = value;
                                    }

                                    /**
                                     * Recupera il valore della proprietà qta.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getQta() {
                                        return qta;
                                    }

                                    /**
                                     * Imposta il valore della proprietà qta.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setQta(String value) {
                                        this.qta = value;
                                    }

                                    /**
                                     * Recupera il valore della proprietà fattConv.
                                     * 
                                     */
                                    public int getFattConv() {
                                        return fattConv;
                                    }

                                    /**
                                     * Imposta il valore della proprietà fattConv.
                                     * 
                                     */
                                    public void setFattConv(int value) {
                                        this.fattConv = value;
                                    }

                                }


                                /**
                                 * <p>Classe Java per anonymous complex type.
                                 * 
                                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                                 * 
                                 * <pre>
                                 * &lt;complexType&gt;
                                 *   &lt;complexContent&gt;
                                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                                 *       &lt;attribute name="tipo_pr"&gt;
                                 *         &lt;simpleType&gt;
                                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                                 *             &lt;enumeration value="F"/&gt;
                                 *             &lt;enumeration value="P"/&gt;
                                 *             &lt;enumeration value="H"/&gt;
                                 *             &lt;enumeration value="A"/&gt;
                                 *             &lt;enumeration value="G"/&gt;
                                 *             &lt;enumeration value="T"/&gt;
                                 *             &lt;enumeration value="C"/&gt;
                                 *             &lt;enumeration value="U"/&gt;
                                 *             &lt;enumeration value="D"/&gt;
                                 *             &lt;enumeration value="Z"/&gt;
                                 *             &lt;enumeration value="I"/&gt;
                                 *             &lt;enumeration value="X"/&gt;
                                 *             &lt;enumeration value="B"/&gt;
                                 *           &lt;/restriction&gt;
                                 *         &lt;/simpleType&gt;
                                 *       &lt;/attribute&gt;
                                 *       &lt;attribute name="cod_pr"&gt;
                                 *         &lt;simpleType&gt;
                                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                                 *             &lt;length value="16"/&gt;
                                 *           &lt;/restriction&gt;
                                 *         &lt;/simpleType&gt;
                                 *       &lt;/attribute&gt;
                                 *     &lt;/restriction&gt;
                                 *   &lt;/complexContent&gt;
                                 * &lt;/complexType&gt;
                                 * </pre>
                                 * 
                                 * 
                                 */
                                @XmlAccessorType(XmlAccessType.FIELD)
                                @XmlType(name = "")
                                public static class PRESCRITTORE {

                                    @XmlAttribute(name = "tipo_pr")
                                    protected String tipoPr;
                                    @XmlAttribute(name = "cod_pr")
                                    protected String codPr;

                                    /**
                                     * Recupera il valore della proprietà tipoPr.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getTipoPr() {
                                        return tipoPr;
                                    }

                                    /**
                                     * Imposta il valore della proprietà tipoPr.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setTipoPr(String value) {
                                        this.tipoPr = value;
                                    }

                                    /**
                                     * Recupera il valore della proprietà codPr.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getCodPr() {
                                        return codPr;
                                    }

                                    /**
                                     * Imposta il valore della proprietà codPr.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setCodPr(String value) {
                                        this.codPr = value;
                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

    }

}
