package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;

/**
 * Java class for DurationPropType complex type.
 * <p>
 * DURATION specifies a positive duration of time.
 * <p>
 * In a "VEVENT" calendar component the property may be used to specify a
 * duration of the event, instead of an explicit end DATE-TIME. In a "VTODO"
 * calendar component the property may be used to specify a duration for the
 * to-do, instead of an explicit due DATE-TIME. In a "VALARM" calendar component
 * the property may be used to specify the delay period prior to repeating an
 * alarm. When the "DURATION" property relates to a "DTSTART" property that is
 * specified as a DATE value, then the "DURATION" property MUST be specified as
 * a "dur-day" or "dur-week" value.
 * <p>
 * Example: The following is an example of this property that specifies an
 * interval of time of one hour and zero minutes and zero seconds:
 * DURATION:PT1H0M0S
 * <p>
 * The following is an example of this property that specifies an interval of
 * time of 15 minutes: DURATION:PT15M
 * <p>
 * @see <a href="http://tools.ietf.org/html/rfc5545">3.8.2.5. Duration</a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DurationPropType", propOrder = {
  "duration"
})
public class DurationPropType extends BasePropertyType {

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
  @XmlElement(required = true)
  protected Duration duration;

  public DurationPropType() {
  }

  public DurationPropType(Duration duration) {
    this.duration = duration;
  }

  /**
   * Gets the value of the duration property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public Duration getDuration() {
    return duration;
  }

  /**
   * Sets the value of the duration property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setDuration(Duration value) {
    this.duration = value;
  }

  public boolean isSetDuration() {
    return (this.duration != null);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 67 * hash + Objects.hashCode(this.duration);
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
    final DurationPropType other = (DurationPropType) obj;
    return Objects.equals(this.duration, other.duration);
  }

  @Override
  public String toString() {
    return "DurationPropType" + " duration [" + duration + ']';
  }
}
