package ietf.params.xml.ns.icalendar.property.base.datedatetime;

import ietf.params.xml.ns.icalendar.property.base.DateDatetimePropertyType;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 * Java class for DtstartPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="DtstartPropType"> &lt;complexContent>
 * &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}DateDatetimePropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DtstartPropType")
public class DtstartPropType extends DateDatetimePropertyType {

  public DtstartPropType() {
  }

  public DtstartPropType(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    super(dateTime);
  }

  /**
   * Set the DateTime parameter with a DATE. Since java.util.Date has no notion
   * of TimeZone you must also provide the timezone for the DATE value.
   * <p>
   * @param date     a date
   * @param timeZone the date timezone
   * @throws DatatypeConfigurationException if the date/timezone combination
   *                                        cannot be converted to an
   *                                        XMLGregorianCalendar
   */
  public DtstartPropType(Date date) throws DatatypeConfigurationException {
    super(date);
  }

}
