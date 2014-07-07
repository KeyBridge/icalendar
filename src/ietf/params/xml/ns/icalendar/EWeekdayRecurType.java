package ietf.params.xml.ns.icalendar;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for EWeekdayRecurType.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>
 * &lt;simpleType name="EWeekdayRecurType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="SU"/>
 *     &lt;enumeration value="MO"/>
 *     &lt;enumeration value="TU"/>
 *     &lt;enumeration value="WE"/>
 *     &lt;enumeration value="TH"/>
 *     &lt;enumeration value="FR"/>
 *     &lt;enumeration value="SA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * <p/>
 */
@XmlType(name = "WeekdayRecurType")
@XmlEnum
public enum EWeekdayRecurType {

  /**
   * Sunday
   */
  SU(Calendar.SUNDAY),
  /**
   * Monday
   */
  MO(Calendar.MONDAY),
  /**
   * Tuesday
   */
  TU(Calendar.TUESDAY),
  /**
   * Wednesday
   */
  WE(Calendar.WEDNESDAY),
  /**
   * Thursday
   */
  TH(Calendar.THURSDAY),
  /**
   * Friday
   */
  FR(Calendar.FRIDAY),
  /**
   * Saturday
   */
  SA(Calendar.SATURDAY);

  private final int calendarValue;

  private EWeekdayRecurType(int calendarValue) {
    this.calendarValue = calendarValue;
  }

  /**
   * Get the corresponding java.util.Calendar integer value for this weekday.
   * <p>
   * @return the Calendar integer value
   */
  public int getCalendarValue() {
    return calendarValue;
  }

  public String value() {
    return name();
  }

  public static EWeekdayRecurType fromValue(String v) {
    return valueOf(v);
  }
}
