package ietf.params.xml.ns.icalendar;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for WeekdayRecurType.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>
 * &lt;simpleType name="WeekdayRecurType">
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
public enum WeekdayRecurType {

  /**
   * Sunday
   */
  SU,
  /**
   * Monday
   */
  MO,
  /**
   * Tuesday
   */
  TU,
  /**
   * Wednesday
   */
  WE,
  /**
   * Thursday
   */
  TH,
  /**
   * Friday
   */
  FR,
  /**
   * Saturday
   */
  SA;

  public String value() {
    return name();
  }

  public static WeekdayRecurType fromValue(String v) {
    return valueOf(v);
  }
}
