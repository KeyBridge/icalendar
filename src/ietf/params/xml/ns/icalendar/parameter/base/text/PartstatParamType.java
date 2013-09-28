package ietf.params.xml.ns.icalendar.parameter.base.text;

import ietf.params.xml.ns.icalendar.parameter.base.TextParameterType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * partstat-event = ("NEEDS-ACTION" ; Event needs action / "ACCEPTED" ; Event
 * accepted / "DECLINED" ; Event declined / "TENTATIVE" ; Event tentatively ;
 * accepted / "DELEGATED" ; Event delegated / x-name ; Experimental status /
 * iana-token) ; Other IANA-registered ; status ; These are the participation
 * statuses for a "VEVENT". ; Default is NEEDS-ACTION.
 * <p/>
 * partstat-todo = ("NEEDS-ACTION" ; To-do needs action / "ACCEPTED" ; To-do
 * accepted / "DECLINED" ; To-do declined / "TENTATIVE" ; To-do tentatively ;
 * accepted / "DELEGATED" ; To-do delegated / "COMPLETED" ; To-do completed ;
 * COMPLETED property has ; DATE-TIME completed / "IN-PROCESS" ; To-do in
 * process of ; being completed / x-name ; Experimental status / iana-token) ;
 * Other IANA-registered ; status ; These are the participation statuses for a
 * "VTODO". ; Default is NEEDS-ACTION.
 * <p/>
 * partstat-jour = ("NEEDS-ACTION" ; Journal needs action / "ACCEPTED" ; Journal
 * accepted / "DECLINED" ; Journal declined / x-name ; Experimental status /
 * iana-token) ; Other IANA-registered ; status ; These are the participation
 * statuses for a "VJOURNAL". ; Default is NEEDS-ACTION.
 * <p/>
 *
 * Java class for PartstatParamType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="PartstatParamType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}TextParameterType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartstatParamType")
public class PartstatParamType extends TextParameterType {
}
