package ietf.params.xml.ns.icalendar;

import ietf.params.xml.ns.icalendar.adapter.XmlAdapterXCalDateTime;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

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

  /**
   * [ISO.8601.2004] International Organization for Standardization, "Data
   * elements and interchange formats -- Information interchange --
   * Representation of dates and times", 2004.
   * <p>
   * yyyyMMdd'T'HHmmss'Z' - the default date time formatting pattern
   */
  public static final String UTC_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
  private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDateTime.class)
  protected XMLGregorianCalendar start;
  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDateTime.class)
  protected XMLGregorianCalendar end;
  protected String duration;

  public PeriodType() {
  }

  public PeriodType(XMLGregorianCalendar start, XMLGregorianCalendar end) {
    this.start = start;
    this.end = end;
  }

  public PeriodType(XMLGregorianCalendar start, Duration duration) {
    this.start = start;
    setDuration(duration);
  }

  public PeriodType(GregorianCalendar start, GregorianCalendar end) throws DatatypeConfigurationException {
    setStart(start);
    setEnd(end);
  }

  public PeriodType(GregorianCalendar start, Duration duration) throws DatatypeConfigurationException {
    setStart(start);
    setDuration(duration);
  }

  public PeriodType(Date start, GregorianCalendar end) throws DatatypeConfigurationException {
    Calendar calStart = Calendar.getInstance(TIMEZONE_UTC);
    calStart.setTime(start);
    setStart((GregorianCalendar) calStart);
    setEnd(end);
  }

  public PeriodType(Date start, Duration duration) throws DatatypeConfigurationException {
    Calendar calStart = Calendar.getInstance(TIMEZONE_UTC);
    calStart.setTime(start);
    setStart((GregorianCalendar) calStart);
    setDuration(duration);
  }

  /**
   * Set the TIME (Hour, Minute and Second) values for the start (and end time
   * if set) to match the time (HMS) values of the given date value.
   * <p>
   * @param time a date value - only the time values are extracted
   * @throws DatatypeConfigurationException if the start date fails to set
   */
  public void setTime(Date time) throws DatatypeConfigurationException {
    Calendar timeCal = Calendar.getInstance(TIMEZONE_UTC);
    timeCal.setTime(time);
    setTime(timeCal);
  }

  /**
   * Set the TIME (Hour, Minute and Second) values for the start (and end time
   * if set) to match the time (HMS) values of the given date value.
   * <p>
   * @param time a calendar value - only the time values are extracted
   * @throws DatatypeConfigurationException if the start date fails to set
   */
  public void setTime(Calendar time) throws DatatypeConfigurationException {
    Calendar dateStart = getStart();
    /**
     * Set the START. Optionally set the END if it is configured. Note that the
     * DURATION does not need updating.
     */
    Calendar dateEnd = end != null ? getEnd() : null;
    for (int calendarField : new int[]{Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND}) {
      dateStart.set(calendarField, time.get(calendarField));
      if (dateEnd != null) {
        dateEnd.set(calendarField, time.get(calendarField));
      }
    }
    setStart((GregorianCalendar) dateStart);
    if (dateEnd != null) {
      setEnd((GregorianCalendar) dateEnd);
    }
  }

  /**
   * Gets the value of the start property.
   * <p/>
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public GregorianCalendar getStart() {
//    return start;
    return start.toGregorianCalendar(TIMEZONE_UTC, Locale.ENGLISH, null);
  }

  /**
   * Sets the value of the start property.
   * <p/>
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setStart(XMLGregorianCalendar value) {
    this.start = value;
  }

  public void setStart(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    this.start = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
  }

  public boolean isSetStart() {
    return (this.start != null);
  }

  /**
   * Gets the value of the end property.
   * <p>
   * If the END property is null it is attempted to be calculated from the
   * DURATION property.
   * <p/>
   * @return possible object is {@link XMLGregorianCalendar }
   */
  public GregorianCalendar getEnd() {
    if (end != null) {
      return end.toGregorianCalendar(TIMEZONE_UTC, Locale.ENGLISH, null);
    } else if (duration != null) {
      try {
        GregorianCalendar endTemp = (GregorianCalendar) getStart().clone();
        endTemp.add(Calendar.MILLISECOND, (int) getDuration().getTimeInMillis(getStart()));
        return endTemp;
      } catch (DatatypeConfigurationException datatypeConfigurationException) {
        System.err.println("PeriodType getEnd calculating error: " + datatypeConfigurationException.getMessage());
      }
    }
    return null;
//    return end;
  }

  /**
   * Sets the value of the end property. If the input value is not null then the
   * duration is set to null.
   * <p/>
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setEnd(XMLGregorianCalendar value) {
    if (value != null) {
      this.end = value;
      this.duration = null;
    } else {
      this.end = null;
    }
  }

  public void setEnd(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    setEnd(DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize());
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
   * <p>
   * @return new Duration created from parsing the internal
   *         lexicalRepresentation.
   * @throws DatatypeConfigurationException - if the XML datatype cannot be
   *                                        generated
   * @throws IllegalArgumentException       - If lexicalRepresentation is not a
   *                                        valid representation of a Duration.
   * @throws UnsupportedOperationException  - If implementation cannot support
   *                                        requested values.
   * @throws NullPointerException           - if lexicalRepresentation is null.
   */
  public Duration getDuration() throws DatatypeConfigurationException {
    if (duration != null) {
      return DatatypeFactory.newInstance().newDuration(duration);
    } else if (end != null) {
      return DatatypeFactory.newInstance().newDuration(getEnd().getTimeInMillis() - getStart().getTimeInMillis());
    } else {
      return null;
    }
//    return duration;
  }

  /**
   * Sets the value of the duration property.
   * <p>
   * If the duration is valid then the internal 'end' field is set to null.
   * <p/>
   * @param value allowed object is {@link String }
   * @throws DatatypeConfigurationException if the string cannot be converted to
   *                                        an XML Duration datatype
   */
  public void setDuration(String value) throws DatatypeConfigurationException {
    setDuration(DatatypeFactory.newInstance().newDuration(value));
  }

  /**
   * Set the internal duration field to a String representation of this Duration
   * Object.
   * <p>
   * The internal field is formatted according to the XML Schema 1.0 spec and
   * can be always parsed back later into the equivalent Duration Object by
   * DatatypeFactory.newDuration(String lexicalRepresentation).
   * <p>
   * @param value a duration instance
   */
  public final void setDuration(Duration value) {
    if (value != null) {
      this.duration = value.toString();
      this.end = null;
    } else {
      this.duration = null;
    }
  }

  public boolean isSetDuration() {
    return (this.duration != null);
  }

  /**
   * Hash code is calculated from start, end and duration.
   * <p>
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
   * <p>
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
    if (this.start.compare(o.start) == 0) {
      try {
        return this.end != null
          ? this.end.compare(o.end)
          : this.getDuration().compare(o.getDuration());
      } catch (DatatypeConfigurationException ex) {
//        Logger.getLogger(PeriodType.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return this.start.compare(o.start);
  }

  /**
   * This value type is defined by the following notation:
   * <p>
   * period = period-explicit / period-start
   * <p>
   * period-explicit = date-time "/" date-time -OR-<br/>
   * period-start = date-time "/" dur-value
   * <p>
   * @return Period of Time formatted as a string.
   */
  @Override
  public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat(UTC_PATTERN);
    sdf.setTimeZone(TIMEZONE_UTC);
    return sdf.format(getStart().getTime()) + "/" + (end != null
      ? sdf.format(getEnd().getTime())
      : duration);
  }
}
