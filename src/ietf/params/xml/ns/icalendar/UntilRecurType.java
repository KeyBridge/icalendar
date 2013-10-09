package ietf.params.xml.ns.icalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for UntilRecurType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="UntilRecurType"> &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence> &lt;choice> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date-time"/> &lt;/choice>
 * &lt;/sequence> &lt;/restriction> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UntilRecurType", propOrder = {
  "date",
  "dateTime"
})
public class UntilRecurType {

  private static final String UTC_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
  @XmlTransient
  protected static final TimeZone TIME_ZONE = TimeZone.getTimeZone("UTC");
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar date;
  @XmlElement(name = "date-time")
  protected XMLGregorianCalendar dateTime;

  public UntilRecurType() {
  }

  public UntilRecurType(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime);
  }

  public UntilRecurType(Calendar dateTime) throws DatatypeConfigurationException {
    setDateTime((GregorianCalendar) dateTime);
  }

  public UntilRecurType(java.util.Date dateTime) throws DatatypeConfigurationException {
    setDateTime(dateTime);
  }

  /**
   * Construct an UntilRecurType from a string.
   * <p/>
   * @param dateTime an encoded date time string of the format
   *                 'yyyyMMdd'T'HHmmss'Z''
   * @throws DatatypeConfigurationException if the parsed date is not valid.
   * @throws ParseException                 if the string cannot be parsed into
   *                                        a Date
   */
  public UntilRecurType(String dateTime) throws DatatypeConfigurationException, ParseException {
    setDateTime(new SimpleDateFormat(UTC_PATTERN).parse(dateTime));
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

  public final void setDateTime(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime);
  }

  public final void setDateTime(java.util.Date dateTime) throws DatatypeConfigurationException {
    if (dateTime != null) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(dateTime);
      setDateTime((GregorianCalendar) calendar);
    }
  }

  public boolean isSetDateTime() {
    return (this.dateTime != null);
  }

  /**
   * Return the dateTime or date fields converted to a java.util.Calendar.
   * <p/>
   * @return
   */
  public Calendar getCalendar() {
    if (dateTime != null) {
      return dateTime.toGregorianCalendar(TIME_ZONE, Locale.ENGLISH, null);
    } else if (date != null) {
      return date.toGregorianCalendar(TIME_ZONE, Locale.ENGLISH, null);
    }
    return null;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + Objects.hashCode(this.date);
    hash = 67 * hash + Objects.hashCode(this.dateTime);
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
    final UntilRecurType other = (UntilRecurType) obj;
    if (!Objects.equals(this.date, other.date)) {
      return false;
    }
    if (!Objects.equals(this.dateTime, other.dateTime)) {
      return false;
    }
    return true;
  }

  /**
   * Print both the dateTime and date fields.
   * <p/>
   * @return
   */
  public String toStringFull() {
    return "UntilRecurType"
      + " dateTime [" + dateTime
      + "] date [" + date
      + ']';
  }

  /**
   * @return an encoded date time string of the format 'yyyyMMdd'T'HHmmss'Z''
   */
  @Override
  public String toString() {
    DateFormat sdf = new SimpleDateFormat(UTC_PATTERN);
    return getCalendar() != null ? sdf.format(getCalendar().getTime()) : null;
  }
}
