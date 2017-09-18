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

import ietf.params.xml.ns.icalendar.adapter.XmlAdapterDurationXCalDateTime;
import ietf.params.xml.ns.icalendar.adapter.XmlAdapterLocalDateTimeXCalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import static ietf.params.xml.ns.icalendar.Constants.FORMATTER_RFC2245_DATE_TIME;

/**
 * Period of Time (RFC 5545, Section 3.3.9). This value type is used to identify
 * values that contain a precise period of time.
 * <p>
 * There are two forms of a period of time: First, a period of time is
 * identified by its start and its end. This format is based on the
 * [ISO.8601.2004] complete representation. Second, a period of time can also be
 * defined by a start and a positive duration of time. The format is based on
 * the [ISO.8601.2004] complete representation.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="PeriodType"> &lt;complexContent> &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}anyType"> &lt;sequence> &lt;element
 * name="start" type="{urn:ietf:params:xml:ns:icalendar-2.0}DateTimeType"/>
 * &lt;sequence> &lt;choice> &lt;element name="end"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DateTimeType"/> &lt;element
 * name="duration"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType"/> &lt;/choice>
 * &lt;/sequence> &lt;/sequence> &lt;/restriction> &lt;/complexContent>
 * &lt;/complexType>
 * </pre> Example: The period starting at 18:00:00 UTC, on January 1, 1997 and
 * ending at 07:00:00 UTC on January 2, 1997 would be:
 * <p>
 * 19970101T180000Z/19970102T070000Z
 * <p>
 * The period start at 18:00:00 on January 1, 1997 and lasting 5 hours and 30
 * minutes would be:
 * <p>
 * 19970101T180000Z/PT5H30M
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodType", propOrder = {
  "start",
  "end",
  "duration"
})

public final class PeriodType implements Comparable<PeriodType> {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(type = LocalDateTime.class, value = XmlAdapterLocalDateTimeXCalDateTime.class)
  protected LocalDateTime start;
  @XmlJavaTypeAdapter(type = LocalDateTime.class, value = XmlAdapterLocalDateTimeXCalDateTime.class)
  protected LocalDateTime end;
  @XmlJavaTypeAdapter(type = Duration.class, value = XmlAdapterDurationXCalDateTime.class)
  protected Duration duration;

  public PeriodType() {
  }

  public PeriodType(LocalDateTime start, LocalDateTime end) {
    this.start = start;
    this.end = end;
  }

  public PeriodType(LocalDateTime start, Duration duration) {
    this.start = start;
    setDuration(duration);
  }

  /**
   * Set the TIME (Hour, Minute and Second) values for the start (and end time
   * if set) to match the time (HMS) values of the given date value.
   *
   * @param time a calendar value - only the time values are extracted
   */
  public void setTime(LocalTime time) {
    /**
     * Set the START. Optionally set the END if it is configured. Note that the
     * DURATION does not need updating.
     */
    start = start.with(time);
    if (end != null) {
      end = end.with(time);
    }
  }

  /**
   * Gets the value of the start property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public LocalDateTime getStart() {
    return start;
  }

  /**
   * Sets the value of the start property.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setStart(LocalDateTime value) {
    start = value;
  }

  /**
   * Gets the value of the end property.
   * <p>
   * If the END property is null it is attempted to be calculated from the
   * DURATION property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   */
  public LocalDateTime getEnd() {
    if (end != null) {
      return end;
    } else if (duration != null) {
      return start.plus(duration);
    }
    return null;
  }

  /**
   * Sets the value of the end property. If the input value is not null then the
   * duration is set to null.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setEnd(LocalDateTime value) {
    if (value != null) {
      this.end = value;
      this.duration = null;
    } else {
      this.end = null;
    }
  }

  public boolean isSetEnd() {
    return (this.end != null);
  }

  /**
   * Obtain a new instance of a Duration specifying the Duration as its string
   * representation, "PnYnMnDTnHnMnS", as defined in XML Schema 1.0 section
   * 3.2.6.1.
   * <p>
   * XML Schema Part 2: Datatypes, 3.2.6 duration, defines duration as: duration
   * represents a duration of time. The value space of duration is a
   * six-dimensional space where the coordinates designate the Gregorian year,
   * month, day, hour, minute, and second components defined in Section 5.5.3.2
   * of [ISO 8601], respectively.
   * <p>
   * These components are ordered in their significance by their order of
   * appearance i.e. as year, month, day, hour, minute, and second. All six
   * values are set and available from the created Duration The XML Schema
   * specification states that values can be of an arbitrary size.
   * Implementations may chose not to or be incapable of supporting arbitrarily
   * large and/or small values.
   * <p>
   * An UnsupportedOperationException will be thrown with a message indicating
   * implementation limits if implementation capacities are exceeded.
   * Parameters: lexicalRepresentation - String representation of a Duration.
   * Returns: New Duration created from parsing the lexicalRepresentation.
   * Throws
   * <p>
   * If DURATION is null it is calculated from the END property.
   *
   * @return new Duration created from parsing the internal
   *         lexicalRepresentation.
   * @throws IllegalArgumentException       - If lexicalRepresentation is not a
   *                                        valid representation of a Duration.
   * @throws UnsupportedOperationException  - If implementation cannot support
   *                                        requested values.
   * @throws NullPointerException           - if lexicalRepresentation is null.
   */
  public Duration getDuration() {
    return duration != null ? duration : Duration.between(start, end);
  }

  /**
   * Sets the value of the duration property.
   * <p>
   * If the duration is non-null then the internal 'end' field is set to null.
   *
   * @param duration a duration instance
   */
  public final void setDuration(Duration duration) {
    this.duration = duration;
    if (duration != null) {
      end = null;
    }
  }

  /**
   * Set the internal duration field to a String representation of this Duration
   * Object.
   * <p>
   * The internal field is formatted according to the XML Schema 1.0 spec and
   * can be always parsed back later into the equivalent Duration Object by
   * DatatypeFactory.newDuration(String lexicalRepresentation).
   * <p>
   * If the duration is valid then the internal 'end' field is set to null.
   *
   * @param value allowed object is {@link String }
   * @throws DateTimeParseException in case the provided String cannot be parsed
   *                                as java.time.Duration
   */
  public void setDuration(String value) throws DateTimeParseException {
    duration = Duration.parse(value);
  }

  /**
   * Hash code is calculated from start, end and duration.
   *
   * @return the object hashcode
   */
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 47 * hash + Objects.hashCode(this.start);
    hash = 47 * hash + Objects.hashCode(this.end);
    hash = 47 * hash + Objects.hashCode(this.duration);
    return hash;
  }

  /**
   * Equals is calculated from start, end and duration.
   *
   * @param obj the other object
   * @return greater, less or equal [1, -1, 0]
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final PeriodType other = (PeriodType) obj;
    if (!Objects.equals(this.start, other.start)) {
      return false;
    }
    if (!Objects.equals(this.end, other.end)) {
      return false;
    }
    return Objects.equals(this.duration, other.duration);
  }

  @Override
  public int compareTo(PeriodType o) {
    /**
     * If the START is equal then compare the END or DURATION, else compare the
     * START.
     */
    int startComparison = start.compareTo(o.start);
    if (startComparison != 0) return startComparison;
    if (end == null) {
      return duration.compareTo(o.duration == null ? Duration.between(o.start, o.end) : o.duration);
    } else {
      return end.compareTo(o.end == null ? o.start.plus(o.duration) : o.end);
    }
  }

  /**
   * This value type is defined by the following notation:
   * <p>
   * period = period-explicit / period-start
   * <p>
   * period-explicit = date-time "/" date-time -OR-<br/>
   * period-start = date-time "/" dur-value
   *
   * @return Period of Time formatted as a string.
   */
  @Override
  public String toString() {
    return start.format(FORMATTER_RFC2245_DATE_TIME) + "/" + (end != null ? end.format(FORMATTER_RFC2245_DATE_TIME) : duration);
  }
}
