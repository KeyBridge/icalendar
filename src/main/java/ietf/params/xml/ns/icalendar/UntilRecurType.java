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
package ietf.params.xml.ns.icalendar;

import static ietf.params.xml.ns.icalendar.Constants.*;
import ietf.params.xml.ns.icalendar.adapter.XmlAdapterLocalDateTimeXCalDateTime;
import ietf.params.xml.ns.icalendar.adapter.XmlAdapterLocalDateXCalDate;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 * Java class for UntilRecurType complex type.
 * <p>
 * The UNTIL rule part defines a DATE or DATE-TIME value that bounds the
 * recurrence rule in an inclusive manner.
 * <p>
 * If the value specified by UNTIL is synchronized with the specified
 * recurrence, this DATE or DATE-TIME becomes the last instance of the
 * recurrence.
 * <p>
 * <strong>The value of the UNTIL rule part MUST have the same value type as the
 * "DTSTART" property.</strong>
 * <p>
 * Furthermore, if the "DTSTART" property is specified as a date with local
 * time, then the UNTIL rule part MUST also be specified as a date with local
 * time. If the "DTSTART" property is specified as a date with UTC time or a
 * date with local time and time zone reference, then the UNTIL rule part MUST
 * be specified as a date with UTC time.
 * <p>
 * In the case of the "STANDARD" and "DAYLIGHT" sub-components the UNTIL rule
 * part MUST always be specified as a date with UTC time. If specified as a
 * DATE-TIME value, then it MUST be specified in a UTC time format.
 * <p>
 * Developer note: In this implementation all values are recorded as DATE-TIME.
 * This implementation has therefore been modified to only support DATE-TIME.
 * The DATE getter and setter methods read and write java.time.LocalDate values,
 * but the internal storage is always DATE-TIME.
 * <p>
 * The internal DATE field getter and setter methods have been renamed with a
 * 'Xml' suffix.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UntilRecurType", propOrder = {
  "date",
  "dateTime"
})
@XmlRootElement
public class UntilRecurType implements Serializable {

  private static final long serialVersionUID = 1L;
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
  @XmlElement(name = "date")
  @XmlJavaTypeAdapter(type = LocalDate.class, value = XmlAdapterLocalDateXCalDate.class)
  protected LocalDate date;
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
  @XmlJavaTypeAdapter(type = LocalDateTime.class, value = XmlAdapterLocalDateTimeXCalDateTime.class)
  protected LocalDateTime dateTime;

  /**
   * Developer note: A parameter-less constructor should not set field values
   * because this potentially leads to an invalid state when unmarshalling from
   * XML.
   */
  public UntilRecurType() {
  }

  public static UntilRecurType getInstance() {
    UntilRecurType urt = new UntilRecurType();
    urt.setDate(LocalDate.now());
    return urt;
  }

  public UntilRecurType(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public UntilRecurType(LocalDate date) {
    this.date = date;
  }

  /**
   * Construct an UntilRecurType from a string. Three formats are supported: RFC
   * 2445 UTC standard "yyyyMMdd'T'HHmmss'Z'", RFC 5545 DATE-TIME
   * "yyyy-MM-dd'T'HH:mm:ss'Z'" or RFC 5545 DATE "yyyyMMdd"
   *
   * @param untilDateTimeString an encoded date time string
   * @throws DatatypeConfigurationException if the parsed date is not valid.
   * @throws ParseException                 if the string cannot be parsed into
   *                                        a Date
   */
  public UntilRecurType(String untilDateTimeString) throws DatatypeConfigurationException, ParseException {
    if (untilDateTimeString == null || untilDateTimeString.isEmpty()) {
      throw new IllegalArgumentException("Cannot parse a null or empty string.");
    }
    if (PATTERN_RFC6321_DATE_TIME.length() - 4 == untilDateTimeString.length()) {
      setDateTime(LocalDateTime.parse(untilDateTimeString, FORMATTER_RFC2245_DATE_TIME));
    } else if (PATTERN_RFC5545_DATE.length() == untilDateTimeString.length()) {
      setDate(LocalDate.parse(untilDateTimeString, FORMATTER_RFC5545_DATE));
    } else if (PATTERN_RFC5545_DATE_TIME.length() - 4 == untilDateTimeString.length()) {
      setDateTime(LocalDateTime.parse(untilDateTimeString, FORMATTER_RFC5545_DATE_TIME));
    } else {
      throw new ParseException("Failed to parse UNTIL date string: " + untilDateTimeString, 0);
    }
  }

  /**
   * Gets the value of the dateTime property. If the dateTime field is null a
   * new Calendar instance is created and returned, but the internal field will
   * remain unset.
   *
   * @return a non-null Calendar instance.
   */
  public LocalDateTime getDateTime() {
    return dateTime;
  }

  /**
   * Sets the value of the dateTime property.
   *
   * @param dateTime the calendar value
   */
  public final void setDateTime(LocalDateTime dateTime) throws DatatypeConfigurationException {
    this.dateTime = dateTime;
    this.date = null;
  }

  public boolean isSetDateTime() {
    return (this.dateTime != null);
  }

  /**
   * Get the DATE field as a java.time.LocalDate instance.
   *
   * @return a DATE value
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * Set the DATE field with a java.time.LocalDate instance.
   *
   * @param date a DATE value
   */
  public final void setDate(LocalDate date) {
    this.date = date;
    this.dateTime = null;
  }

  public boolean isSetDate() {
    return (this.date != null);
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
    return Objects.equals(this.dateTime, other.dateTime);
  }

  /**
   * Returns whether this Calendar represents a time before the time represented
   * by the specified Object. This method is equivalent to:
   *
   * @param when the Object to be compared
   * @return true if the time of this Calendar is before the time represented by
   *         when; false otherwise.
   */
  public boolean before(LocalDateTime when) {
    return date != null ? getDate().isBefore(when.toLocalDate()) : getDateTime().isBefore(when);
  }

  /**
   * Returns whether this Calendar represents a time after the time represented
   * by the specified Object.
   *
   * @param when the Object to be compared
   * @return true if the time of this Calendar is after the time represented by
   *         when; false otherwise.
   */
  public boolean after(LocalDateTime when) {
    return date != null ? getDate().isAfter(when.toLocalDate()) : getDateTime().isAfter(when);
  }

  /**
   * Print both the dateTime and date fields.
   *
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
    if (dateTime != null) {
      return dateTime.format(FORMATTER_RFC5545_DATE_TIME);
    } else if (date != null) {
      return date.format(FORMATTER_RFC5545_DATE);
    } else {
      return null;
    }
  }
}
