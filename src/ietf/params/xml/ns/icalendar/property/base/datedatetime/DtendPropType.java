package ietf.params.xml.ns.icalendar.property.base.datedatetime;

import ietf.params.xml.ns.icalendar.property.base.DateDatetimePropertyType;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 * Java class for DtendPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="DtendPropType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}DateDatetimePropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtendPropType")
public class DtendPropType extends DateDatetimePropertyType {

  public DtendPropType() {
  }

  public DtendPropType(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    super(dateTime);
  }

  public DtendPropType(Date date, TimeZone timeZone) throws DatatypeConfigurationException {
    super(date, timeZone);
  }

}
