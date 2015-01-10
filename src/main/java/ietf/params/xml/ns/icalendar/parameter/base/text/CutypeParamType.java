package ietf.params.xml.ns.icalendar.parameter.base.text;

import ietf.params.xml.ns.icalendar.parameter.base.TextParameterType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * cutypeparam = "CUTYPE" "=" ("INDIVIDUAL" ; An individual / "GROUP" ; A group
 * of individuals / "RESOURCE" ; A physical resource / "ROOM" ; A room resource
 * / "UNKNOWN" ; Otherwise not known / x-name ; Experimental type / iana-token)
 * ; Other IANA-registered ; type ; Default is INDIVIDUAL
 * <p/>
 *
 * Java class for CutypeParamType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="CutypeParamType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}TextParameterType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CutypeParamType")
public class CutypeParamType extends TextParameterType {
}
