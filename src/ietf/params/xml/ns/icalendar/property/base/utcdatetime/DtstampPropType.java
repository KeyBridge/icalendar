//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.04.12 at 11:58:52 AM EDT
//
package ietf.params.xml.ns.icalendar.property.base.utcdatetime;

import ietf.params.xml.ns.icalendar.property.base.UtcDatetimePropertyType;
import java.util.GregorianCalendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 * Java class for DtstampPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained
 * within this class.
 * <p/>
 * <
 * pre> &lt;complexType name="DtstampPropType"> &lt;complexContent>
 * &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}UtcDatetimePropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtstampPropType")
public class DtstampPropType extends UtcDatetimePropertyType {

  public DtstampPropType() {
  }

  public DtstampPropType(GregorianCalendar calendar) throws DatatypeConfigurationException {
    super(calendar);
  }
}
