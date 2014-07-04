package ietf.params.xml.ns.icalendar;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for EFreqRecurType.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>
 * &lt;simpleType name="EFreqRecurType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="SECONDLY"/>
 *     &lt;enumeration value="MINUTELY"/>
 *     &lt;enumeration value="HOURLY"/>
 *     &lt;enumeration value="DAILY"/>
 *     &lt;enumeration value="WEEKLY"/>
 *     &lt;enumeration value="MONTHLY"/>
 *     &lt;enumeration value="YEARLY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * <p/>
 */
@XmlType(name = "FreqRecurType")
@XmlEnum
public enum EFreqRecurType {

  SECONDLY,
  MINUTELY,
  HOURLY,
  DAILY,
  WEEKLY,
  MONTHLY,
  YEARLY;

  public String value() {
    return name();
  }

  public static EFreqRecurType fromValue(String v) {
    return valueOf(v);
  }
}
