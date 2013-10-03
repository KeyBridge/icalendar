package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.DtendPropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.DtstartPropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.DuePropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.ExdatePropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.RdatePropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.RecurrenceIdPropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.XBedeworkRegistrationEndPropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.XBedeworkRegistrationStartPropType;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for DateDatetimePropertyType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="DateDatetimePropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;choice> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date-time"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date"/> &lt;/choice>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateDatetimePropertyType", propOrder = {
  "dateTime",
  "date"
})
@XmlSeeAlso({
  DtendPropType.class,
  DtstartPropType.class,
  DuePropType.class,
  ExdatePropType.class,
  RdatePropType.class,
  RecurrenceIdPropType.class,
  XBedeworkRegistrationEndPropType.class,
  XBedeworkRegistrationStartPropType.class
})
public class DateDatetimePropertyType extends BasePropertyType {

  @XmlElement(name = "date-time")
  protected XMLGregorianCalendar dateTime;
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar date;

  public DateDatetimePropertyType() {
  }

  public DateDatetimePropertyType(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    /**
     * Call normalize to Normalize this instance to UTC.
     * <p/>
     * 2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z
     * <p/>
     * Implements W3C XML Schema Part 2, Section 3.2.7.3 (A).
     */
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
  }

  /**
   * Gets the value of the dateTime property.
   * <p/>
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getDateTime() {
    return dateTime;
  }

  /**
   * Sets the value of the dateTime property.
   * <p/>
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setDateTime(XMLGregorianCalendar value) {
    this.dateTime = value;
  }

  public void setDateTime(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    /**
     * Call normalize to Normalize this instance to UTC.
     * <p/>
     * 2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z
     * <p/>
     * Implements W3C XML Schema Part 2, Section 3.2.7.3 (A).
     */
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
  }

  public boolean isSetDateTime() {
    return (this.dateTime != null);
  }

  /**
   * Gets the value of the date property.
   * <p/>
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getDate() {
    return date;
  }

  /**
   * Sets the value of the date property.
   * <p/>
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setDate(XMLGregorianCalendar value) {
    this.date = value;
  }

  public boolean isSetDate() {
    return (this.date != null);
  }

  public Calendar getCalendar() {
    if (dateTime != null) {
      return dateTime.toGregorianCalendar(TIME_ZONE, Locale.ENGLISH, null);
    }
    return null;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 79 * hash + Objects.hashCode(this.dateTime);
    hash = 79 * hash + Objects.hashCode(this.date);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final DateDatetimePropertyType other = (DateDatetimePropertyType) obj;
    if (!Objects.equals(this.dateTime, other.dateTime)) {
      return false;
    }
    if (!Objects.equals(this.date, other.date)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "DateDatetimePropertyType"
      + " dateTime [" + dateTime
      + "] date [" + date
      + ']';
  }
}
