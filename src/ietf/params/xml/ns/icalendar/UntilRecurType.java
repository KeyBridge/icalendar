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

  /**
   * RFC5545 3.3.4. DATE
   * <p/>
   * Purpose: This value type is used to identify values that contain a calendar
   * date.
   * <p/>
   * Format Definition: This value type is defined by the following notation:
   * <pre>
   * date               = date-value
   * date-value         = date-fullyear date-month date-mday
   * date-fullyear      = 4DIGIT
   * date-month         = 2DIGIT        ;01-12
   * date-mday          = 2DIGIT        ;01-28, 01-29, 01-30, 01-31
   *                                    ;based on month/year
   * </pre> Description: If the property permits, multiple "date" values are
   * specified as a COMMA-separated list of values. The format for the value
   * type is based on the [ISO.8601.2004] complete representation, basic format
   * for a calendar date. The textual format specifies a four-digit year,
   * two-digit month, and two-digit day of the month. There are no separator
   * characters between the year, month, and day component text.
   * <p/>
   * No additional content value encoding (i.e., BACKSLASH character encoding,
   * see Section 3.3.11) is defined for this value type.
   * <p/>
   * Example: The following represents July 14, 1997: 19970714
   * <p/>
   * @see <a href="http://tools.ietf.org/html/rfc5545#section-3.3.4">Date</a>
   */
  private static final String PATTERN_DATE = "yyyyMMdd";
  /**
   * RFC 5545 3.3.5. DATE-TIME
   * <p/>
   * Purpose: This value type is used to identify values that specify a precise
   * calendar date and time of day.
   * <p/>
   * Format Definition: This value type is defined by the following notation:
   * <pre>
   * date-time  = date "T" time ;As specified in the DATE and TIME
   *                            ;value definitions
   * </pre> Description: If the property permits, multiple "DATE-TIME" values
   * are specified as a COMMA-separated list of values. No additional content
   * value encoding (i.e., BACKSLASH character encoding, see Section 3.3.11) is
   * defined for this value type.
   * <p/>
   * The "DATE-TIME" value type is used to identify values that contain a
   * precise calendar date and time of day. The format is based on the
   * [ISO.8601.2004] complete representation, basic format for a calendar date
   * and time of day. The text format is a concatenation of the "date", followed
   * by the LATIN CAPITAL LETTER T character, the time designator, followed by
   * the "time" format.
   * <p/>
   * The "DATE-TIME" value type expresses time values in three forms:
   * <p/>
   * The form of date and time with UTC offset MUST NOT be used. For example,
   * the following is not valid for a DATE-TIME value:
   * <p/>
   * 19980119T230000-0800 ;Invalid time format
   * <p/>
   * FORM #1: DATE WITH LOCAL TIME <em>NOT SUPPORTED</em>
   * <p/>
   * FORM #2: DATE WITH UTC TIME
   * <p/>
   * The date with UTC time, or absolute time, is identified by a LATIN CAPITAL
   * LETTER Z suffix character, the UTC designator, appended to the time value.
   * For example, the following represents January 19, 1998, at 0700 UTC:
   * <code>19980119T070000Z</code>
   * <p/>
   * The "TZID" property parameter MUST NOT be applied to DATE-TIME properties
   * whose time values are specified in UTC.
   * <p/>
   * FORM #3: DATE WITH LOCAL TIME AND TIME ZONE REFERENCE <em>NOT
   * SUPPORTED</em>
   * <p/>
   * @see <a
   * href="http://tools.ietf.org/html/rfc5545#section-3.3.5">Date-Time</a>
   */
  private static final String PATTERN_DATE_TIME = "yyyyMMdd'T'HHmmss'Z'";
  @XmlTransient
  protected static final TimeZone TIME_ZONE = TimeZone.getTimeZone("UTC");
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar date;
  @XmlElement(name = "date-time")
  protected XMLGregorianCalendar dateTime;

  public UntilRecurType() {
  }

  public UntilRecurType(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
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
    setDateTime(new SimpleDateFormat(PATTERN_DATE).parse(dateTime));
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
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
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
    DateFormat sdf;
    if (dateTime != null) {
      sdf = new SimpleDateFormat(PATTERN_DATE_TIME);
      return getCalendar() != null ? sdf.format(getCalendar().getTime()) : null;
    } else if (date != null) {
      sdf = new SimpleDateFormat(PATTERN_DATE);
      return getCalendar() != null ? sdf.format(getCalendar().getTime()) : null;
    } else {
      return null;
    }
  }
}
