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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Java class for EFreqRecurType.
 * <p>
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
 * <p>
 */
@XmlType(name = "FreqRecurType")
@XmlEnum
public enum FreqRecurType {

  SECONDLY(ChronoUnit.SECONDS),
  MINUTELY(ChronoUnit.MINUTES),
  HOURLY(ChronoUnit.HOURS),
  DAILY(ChronoUnit.DAYS),
  WEEKLY(ChronoUnit.WEEKS),
  MONTHLY(ChronoUnit.MONTHS),
  YEARLY(ChronoUnit.YEARS);
  private final TemporalUnit temporalUnit;

  private FreqRecurType(TemporalUnit temporalField) {
    this.temporalUnit = temporalField;
  }

  /**
   * Get the Calendar value corresponding to the recurrence frequency. The
   * Calendar value is used when calculating incremental recurring events.
   *
   * @return a non-null Integer
   */
  public TemporalUnit getTemporalUnit() {
    return temporalUnit;
  }

  /**
   * JSF-friendly getter.
   *
   * @return the name
   */
  public String getName() {
    return name();
  }

  public String value() {
    return name();
  }

  public static FreqRecurType fromValue(String v) {
    return valueOf(v);
  }
}
