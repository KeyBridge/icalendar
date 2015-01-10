package ietf.params.xml.ns.icalendar.parameter.base.text;

import ietf.params.xml.ns.icalendar.parameter.base.TextParameterType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * fbtypeparam = "FBTYPE" "=" ("FREE" / "BUSY" / "BUSY-UNAVAILABLE" /
 * "BUSY-TENTATIVE" / x-name ; Some experimental iCalendar free/busy type. /
 * iana-token) ; Some other IANA-registered iCalendar free/busy type. ; Default
 * is BUSY
 * <p/>
 *
 * Java class for FbtypeParamType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="FbtypeParamType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}TextParameterType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FbtypeParamType")
public class FbtypeParamType extends TextParameterType {
}
