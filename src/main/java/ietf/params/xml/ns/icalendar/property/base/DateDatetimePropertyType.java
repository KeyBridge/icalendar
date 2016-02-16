/*
 * Copyright 2016 Key Bridge LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.adapter.XmlAdapterXCalDate;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for DateDatetimePropertyType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre> &lt;complexType name="DateDatetimePropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;choice> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date-time"/> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date"/> &lt;/choice>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p>
 * <p>
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

  /**
   * xsd:dateTime — Instant of time (Gregorian calendar)
   * <p>
   * This datatype describes instances identified by the combination of a date
   * and a time. Its value space is described as a combination of date and time
   * of day in Chapter 5.4 of ISO 8601. Its lexical space is the extended
   * format: <code>[-]CCYY-MM-DDThh:mm:ss[Z|(+|-)hh:mm]</code> The time zone may
   * be specified as Z (UTC) or (+|-)hh:mm. Time zones that aren't specified are
   * considered undetermined.
   * <p>
   * Restrictions
   * <p>
   * The basic format of ISO 8601 calendar datetimes, CCYYMMDDThhmmss, isn't
   * supported.
   * <p>
   * The other forms of date-times available in ISO 8601—ordinal dates defined
   * by the year, the number of the day in the year, dates identified by
   * calendar week, and day numbers—aren't supported.
   * <p>
   * As the value space is defined by reference to ISO 8601, there is no support
   * for any calendar system other than Gregorian. As the lexical space is also
   * defined in reference to ISO 8601, there is no support for any localization
   * such as different orders for date parts or named months.
   * <p>
   * The order relation between date-times with and without time zone is
   * partial: they can be compared only outside of a +/- 14 hours interval.
   * Example
   * <p>
   * Valid values for xsd:dateTime include: 2001-10-26T21:32:52,
   * 2001-10-26T21:32:52+02:00, 2001-10-26T19:32:52Z, 2001-10-26T19:32:52+00:00,
   * -2001-10-26T21:32:52, or 2001-10-26T21:32:52.12679.
   * <p>
   * The following values are invalid: 2001-10-26 (all the parts must be
   * specified), 2001-10-26T21:32 (all the parts must be specified),
   * 2001-10-26T25:32:52+02:00 (the hours part—25—is out of range), or
   * 01-10-26T21:32 (all the parts must be specified).
   *
   * @see <a
   * href="http://books.xmlschemata.org/relaxng/ch19-77049.html">xsd:dateTime</a>
   *
   */
  @XmlElement(name = "date-time")
//  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDateTime.class)
  protected XMLGregorianCalendar dateTime;
  /**
   * xsd:date — Gregorian calendar date
   * <p>
   * This datatype is modeled after the calendar dates defined in Chapter 5.2.1
   * of ISO (International Organization for Standardization) 8601. Its value
   * space is the set of Gregorian calendar dates as defined by this standard;
   * i.e., a one-day-long period of time. Its lexical space is the ISO 8601
   * extended format: <code>[-]CCYY-MM-DD[Z|(+|-)hh:mm]</code> with an optional
   * time zone. Time zones that aren't specified are considered undetermined.
   * <p>
   * Restrictions
   * <p>
   * The basic format of ISO 8601 calendar dates, CCYYMMDD, isn't supported.
   * <p>
   * The other forms of dates available in ISO 8601 aren't supported: ordinal
   * dates defined by the year, the number of the day in the year, dates
   * identified by calendar week, and day numbers.
   * <p>
   * As the value space is defined by reference to ISO 8601, there is no support
   * for any calendar system other than Gregorian. Because the lexical space is
   * also defined using a reference to ISO 8601, there is no support for any
   * localization such as different orders for date parts or named months.
   * <p>
   * The order relation between dates with and without time zone is partial:
   * they can be compared beyond a +/- 14 hour interval.
   * <p>
   * There is a difference between ISO 8601, which defines a day as a 24-hour
   * period of time, and the W3C XML Schema, which indicates that a date is a
   * "one-day-long, non-periodic instance ... independent of how many hours this
   * day has." Even though technically correct, some days don't last exactly 24
   * hours because of leap seconds; this definition doesn't concur with the
   * definition of xsd:duration that states that a day is always exactly 24
   * hours long. Example
   * <p>
   * Valid values include: 2001-10-26, 2001-10-26+02:00, 2001-10-26Z,
   * 2001-10-26+00:00, -2001-10-26, or -20000-04-01.
   * <p>
   * The following values would be invalid: 2001-10 (all the parts must be
   * specified), 2001-10-32 (the days part—32—is out of range), 2001-13-26+02:00
   * (the month part—13—is out of range), or 01-10-26 (the century part is
   * missing).
   *
   * @see <a
   * href="http://books.xmlschemata.org/relaxng/ch19-77041.html">xsd:date</a>
   */
  @XmlElement
  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDate.class)
  protected XMLGregorianCalendar date;

  public DateDatetimePropertyType() {
  }

  public DateDatetimePropertyType(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    /**
     * Call normalize to Normalize this instance to UTC.
     * <p>
     * 2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z
     * <p>
     * Implements W3C XML Schema Part 2, Section 3.2.7.3 (A).
     */
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
  }

  /**
   * Set the DateTime parameter with a DATE. Since java.util.Date has no notion
   * of TimeZone you must also provide the timezone for the DATE value.
   *
   * @param date     a date
   * @param timeZone the date timezone
   * @throws DatatypeConfigurationException if the date/timezone combination
   *                                        cannot be converted to an
   *                                        XMLGregorianCalendar
   */
  public DateDatetimePropertyType(Date date) throws DatatypeConfigurationException {
    Calendar cal = Calendar.getInstance(TIME_ZONE);
    cal.setTime(date);
    setDateTime((GregorianCalendar) cal);
  }

  /**
   * Gets the value of the dateTime property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getDateTime() {
    return dateTime;
  }

  /**
   * Sets the value of the dateTime property.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setDateTime(XMLGregorianCalendar value) {
    this.dateTime = value;
  }

  /**
   * Sets the value of the dateTime property from a normal java.util.Calendar.
   * The timezone of the input calendar is automatically normalized to UTC.
   *
   * @param dateTime a calendar instance.
   * @throws DatatypeConfigurationException if the calendar instance cannot be
   *                                        converted to an XMLGregorianCalendar
   */
  public final void setDateTime(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    /**
     * Call normalize to Normalize this instance to UTC.
     * <p>
     * 2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z
     * <p>
     * Implements W3C XML Schema Part 2, Section 3.2.7.3 (A).
     */
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
  }

  public boolean isSetDateTime() {
    return (this.dateTime != null);
  }

  /**
   * Gets the value of the date property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getDate() {
    return date;
  }

  /**
   * Sets the value of the date property.
   *
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
