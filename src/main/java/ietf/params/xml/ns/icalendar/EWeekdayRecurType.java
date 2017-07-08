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

import java.util.Calendar;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for EWeekdayRecurType.
 * <p>
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
 * <p>
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

  EWeekdayRecurType(int calendarValue) {
    this.calendarValue = calendarValue;
  }

  /**
   * Get the corresponding java.util.Calendar integer value for this weekday.
   *
   * @return the Calendar integer value
   */
  public int getCalendarValue() {
    return calendarValue;
  }

  /**
   * JSF-friendly getter
   *
   * @return the name
   */
  public String getName() {
    return name();
  }

  public String value() {
    return name();
  }

  public static EWeekdayRecurType fromValue(String v) {
    return valueOf(v);
  }
}
