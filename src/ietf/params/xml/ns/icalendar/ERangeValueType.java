package ietf.params.xml.ns.icalendar;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for ERangeValueType.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>
 * &lt;simpleType name="ERangeValueType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="THISANDFUTURE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * <p/>
 */
@XmlType(name = "RangeValueType")
@XmlEnum
public enum ERangeValueType {

  THISANDFUTURE;

  public String value() {
    return name();
  }

  public static ERangeValueType fromValue(String v) {
    return valueOf(v);
  }
}
