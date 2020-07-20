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

import ietf.params.xml.ns.icalendar.adapter.XmlAdapterLocalDateXCalDate;
import ietf.params.xml.ns.icalendar.adapter.XmlAdapterZonedDateTimeXCalDateTime;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.*;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Java class for DateDatetimePropertyType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>  &lt;complexType name="DateDatetimePropertyType"&gt; &lt;complexContent&gt;
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 * &lt;sequence&gt; &lt;choice&gt; &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date-time"/&gt; &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}date"/&gt; &lt;/choice&gt;
 * &lt;/sequence&gt; &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
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
   */
  @XmlElement(name = "date-time")
  @XmlJavaTypeAdapter(value = XmlAdapterZonedDateTimeXCalDateTime.class)
  protected ZonedDateTime dateTime;
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
  @XmlJavaTypeAdapter(type = LocalDate.class, value = XmlAdapterLocalDateXCalDate.class)
  protected LocalDate date;

  public DateDatetimePropertyType() {
  }

  /**
   * Default constructor.
   * <p>
   * Note: The provided dateTime parameter is normalized to UTC.
   *
   * @param dateTime the date time configuration
   */
  public DateDatetimePropertyType(ZonedDateTime dateTime) {
    /**
     * Call normalize to Normalize this instance to UTC.
     * <p>
     * 2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z
     * <p>
     * Implements W3C XML Schema Part 2, Section 3.2.7.3 (A).
     */
    this.dateTime = dateTime;
    this.date = dateTime.toLocalDate();
  }

  /**
   * Set the DateTime parameter with a DATE in the default UTC timezone.
   *
   * @param date a date
   */
  public DateDatetimePropertyType(LocalDate date) {
    this.date = date;
    this.dateTime = date.atStartOfDay(Clock.systemUTC().getZone());
  }

  /**
   * Gets the value of the dateTime property.
   *
   * @return possible object is {@link LocalDateTime }
   */
  public ZonedDateTime getDateTime() {
    return dateTime;
  }

  /**
   * Sets the value of the dateTime property.
   *
   * @param value allowed object is {@link LocalDateTime }
   */
  public void setDateTime(ZonedDateTime value) {
    this.dateTime = value;
  }

  public boolean isSetDateTime() {
    return (this.dateTime != null);
  }

  /**
   * Gets the value of the date property.
   *
   * @return possible object is {@link LocalDate }
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * Sets the value of the date property.
   *
   * @param value allowed object is {@link LocalDate }
   */
  public void setDate(LocalDate value) {
    this.date = value;
  }

  public boolean isSetDate() {
    return (this.date != null);
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
    return Objects.equals(this.date, other.date);
  }

  @Override
  public String toString() {
    return "DateDatetimePropertyType{" + "dateTime=" + dateTime + ", date=" + date + '}';
  }
}
