package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.adapter.XmlAdapterXCalDateTime;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for TriggerPropType complex type. This is embedded within an
 * AlarmComponent.
 * <p>
 * The "TRIGGER" property specifies when the alarm will be triggered. The
 * "TRIGGER" property specifies a duration prior to the start of an event or a
 * to-do. The "TRIGGER" edge may be explicitly set to be relative to the "START"
 * or "END" of the event or to-do with the "RELATED" parameter of the "TRIGGER"
 * property. The "TRIGGER" property value type can alternatively be set to an
 * absolute calendar date with UTC time.
 * <p>
 * In an alarm set to trigger on the "START" of an event or to-do, the "DTSTART"
 * property MUST be present in the associated event or to-do. In an alarm in a
 * "VEVENT" calendar component set to trigger on the "END" of the event, either
 * the "DTEND" property MUST be present, or the "DTSTART" and "DURATION"
 * properties MUST both be present. In an alarm in a "VTODO" calendar component
 * set to trigger on the "END" of the to-do, either the "DUE" property MUST be
 * present, or the "DTSTART" and "DURATION" properties MUST both be present.
 * <p>
 * The alarm can be defined such that it triggers repeatedly. A definition of an
 * alarm with a repeating trigger MUST include both the "DURATION" and "REPEAT"
 * properties. The "DURATION" property specifies the delay period, after which
 * the alarm will repeat. The "REPEAT" property specifies the number of
 * additional repetitions that the alarm will be triggered. This repetition
 * count is in addition to the initial triggering of the alarm. Both of these
 * properties MUST be present in order to specify a repeating alarm. If one of
 * these two properties is absent, then the alarm will not repeat beyond the
 * initial trigger.
 * <p>
 * Example: TRIGGER;VALUE=DATE-TIME:19970317T133000Z
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TriggerPropType", propOrder = {
  "duration",
  "dateTime"
})
public class TriggerPropType extends BasePropertyType {

  /**
   * DURATION: This value type is used to identify properties that contain a
   * duration of time.
   * <p>
   * The format is based on the [ISO.8601.2004] complete representation basic
   * format with designators for the duration of time. The format can represent
   * nominal durations (weeks and days) and accurate durations (hours, minutes,
   * and seconds). Note that unlike [ISO.8601.2004], this value type doesn't
   * support the "Y" and "M" designators to specify durations in terms of years
   * and months.
   * <p>
   * The duration of a week or a day depends on its position in the calendar. In
   * the case of discontinuities in the time scale, such as the change from
   * standard time to daylight time and back, the computation of the exact
   * duration requires the subtraction or addition of the change of duration of
   * the discontinuity. Leap seconds MUST NOT be considered when computing an
   * exact duration. When computing an exact duration, the greatest order time
   * components MUST be added first, that is, the number of days MUST be added
   * first, followed by the number of hours, number of minutes, and number of
   * seconds.
   * <p>
   * Negative durations are typically used to schedule an alarm to trigger
   * before an associated time (see Section 3.8.6.3).
   * <p>
   * No additional content value encoding (i.e., BACKSLASH character encoding,
   * see Section 3.3.11) are defined for this value type.
   * <p>
   * Example: A duration of 15 days, 5 hours, and 20 seconds would be:
   * P15DT5H0M20S. A duration of 7 weeks would be: P7W
   */
  protected String duration;
  /**
   * xsd:dateTime — Instant of time (Gregorian calendar)
   * <p/>
   * This datatype describes instances identified by the combination of a date
   * and a time. Its value space is described as a combination of date and time
   * of day in Chapter 5.4 of ISO 8601. Its lexical space is the extended
   * format: <code>[-]CCYY-MM-DDThh:mm:ss[Z|(+|-)hh:mm]</code> The time zone may
   * be specified as Z (UTC) or (+|-)hh:mm. Time zones that aren't specified are
   * considered undetermined.
   * <p/>
   * Restrictions
   * <p/>
   * The basic format of ISO 8601 calendar datetimes, CCYYMMDDThhmmss, isn't
   * supported.
   * <p/>
   * The other forms of date-times available in ISO 8601—ordinal dates defined
   * by the year, the number of the day in the year, dates identified by
   * calendar week, and day numbers—aren't supported.
   * <p/>
   * As the value space is defined by reference to ISO 8601, there is no support
   * for any calendar system other than Gregorian. As the lexical space is also
   * defined in reference to ISO 8601, there is no support for any localization
   * such as different orders for date parts or named months.
   * <p/>
   * The order relation between date-times with and without time zone is
   * partial: they can be compared only outside of a +/- 14 hours interval.
   * Example
   * <p/>
   * Valid values for xsd:dateTime include: 2001-10-26T21:32:52,
   * 2001-10-26T21:32:52+02:00, 2001-10-26T19:32:52Z, 2001-10-26T19:32:52+00:00,
   * -2001-10-26T21:32:52, or 2001-10-26T21:32:52.12679.
   * <p/>
   * The following values are invalid: 2001-10-26 (all the parts must be
   * specified), 2001-10-26T21:32 (all the parts must be specified),
   * 2001-10-26T25:32:52+02:00 (the hours part—25—is out of range), or
   * 01-10-26T21:32 (all the parts must be specified).
   * <p/>
   * @see <a
   * href="http://books.xmlschemata.org/relaxng/ch19-77049.html">xsd:dateTime</a>
   * <p/>
   */
  @XmlElement(name = "date-time")
  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDateTime.class)
  protected XMLGregorianCalendar dateTime;

  /**
   * Gets the value of the duration property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Sets the value of the duration property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setDuration(String value) {
    this.duration = value;
  }

  public boolean isSetDuration() {
    return (this.duration != null);
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

  public boolean isSetDateTime() {
    return (this.dateTime != null);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 17 * hash + Objects.hashCode(this.duration);
    hash = 17 * hash + Objects.hashCode(this.dateTime);
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
    final TriggerPropType other = (TriggerPropType) obj;
    if (!Objects.equals(this.duration, other.duration)) {
      return false;
    }
    return Objects.equals(this.dateTime, other.dateTime);
  }
}
