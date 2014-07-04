package ietf.params.xml.ns.icalendar;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A helper class containing Recurrence end type strategy.
 * <p>
 * This is useful when examining the (calculated) Recur object and returns
 * either "COUNT", "UNTIL" or "NONE" depending upon whether the recurrence has a
 * count or until configuration (or neither).
 */
@XmlType(name = "RecurEndType")
@XmlEnum
@XmlTransient
public enum ERecurEndType {

  COUNT, UNTIL, NONE;

  public String value() {
    return name();
  }

  public static ERecurEndType fromValue(String v) {
    return valueOf(v);
  }
}
