package ietf.params.xml.ns.icalendar;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for ECalscaleValueType.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>
 * &lt;simpleType name="ECalscaleValueType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GREGORIAN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * <p/>
 */
@XmlType(name = "CalscaleValueType")
@XmlEnum
public enum ECalscaleValueType {

  GREGORIAN;

  public String value() {
    return name();
  }

  public static ECalscaleValueType fromValue(String v) {
    return valueOf(v);
  }
}
