package ietf.params.xml.ns.icalendar.parameter.base.text;

import ietf.params.xml.ns.icalendar.parameter.base.TextParameterType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * trigrelparam = "RELATED" "=" ("START" ; Trigger off of start / "END") ;
 * Trigger off of end
 * <p/>
 *
 * Java class for RelatedParamType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="RelatedParamType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}TextParameterType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelatedParamType")
public class RelatedParamType extends TextParameterType {
}
