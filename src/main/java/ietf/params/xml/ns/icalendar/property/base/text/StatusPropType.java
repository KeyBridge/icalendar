package ietf.params.xml.ns.icalendar.property.base.text;

import ietf.params.xml.ns.icalendar.property.base.TextPropertyType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * status = "STATUS" statparam ":" statvalue CRLF
 * <p/>
 * statparam = *(";" other-param)
 * <p/>
 * statvalue = (statvalue-event / statvalue-todo / statvalue-jour)
 * <p/>
 * statvalue-event = "TENTATIVE" ;Indicates event is tentative. / "CONFIRMED"
 * ;Indicates event is definite. / "CANCELLED" ;Indicates event was cancelled.
 * ;Status values for a "VEVENT"
 * <p/>
 * statvalue-todo = "NEEDS-ACTION" ;Indicates to-do needs action. / "COMPLETED"
 * ;Indicates to-do completed. / "IN-PROCESS" ;Indicates to-do in process of. /
 * "CANCELLED" ;Indicates to-do was cancelled. ;Status values for "VTODO".
 * <p/>
 * statvalue-jour = "DRAFT" ;Indicates journal is draft. / "FINAL" ;Indicates
 * journal is final. / "CANCELLED" ;Indicates journal is removed. ;Status values
 * for "VJOURNAL".
 * <p/>
 *
 * Java class for StatusPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="StatusPropType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}TextPropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusPropType")
public class StatusPropType extends TextPropertyType {
}
