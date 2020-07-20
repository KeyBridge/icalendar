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

/**
 * A class that holds information on a single BYDAY value with an optional
 * preceding integer. For example: -3SU (third last Sunday), 1MO (first Monday),
 * TH (every Thursday).
 * <p>
 * Each BYDAY value can also be preceded by a positive (+n) or negative (-n)
 * integer. If present, this indicates the nth occurrence of a specific day
 * within the MONTHLY or YEARLY "RRULE". For example, within a MONTHLY rule,
 * +1MO (or simply 1MO) represents the first Monday within the month, whereas
 * -1MO represents the last Monday of the month. The numeric value in a BYDAY
 * rule part with the FREQ rule part set to YEARLY corresponds to an offset
 * within the month when the BYMONTH rule part is present, and corresponds to an
 * offset within the year when the BYWEEKNO or BYMONTH rule parts are present.
 */
public class NthWeekdayRecurType {

  /**
   * The weekday recur type. Any valid instance requires a non-null
   * weekdayRecurType field
   */
  private final WeekdayRecurType weekdayRecurType;
  /**
   * A null or zero integer indicates every occurrence of a weekday in WEEKLY
   * context (isMonthly() returns false), whereas a non-null and non-zero
   * integer instance indicates the nth occurrence of a specific day within the
   * MONTHLY or YEARLY "RRULE" (isMonthly() returns true)
   */
  private Integer integer;

  public NthWeekdayRecurType(WeekdayRecurType weekdayRecurType) {
    this.weekdayRecurType = weekdayRecurType;
  }

  /**
   * Get the EWeekdayRecurType instance
   *
   * @return non-null EWeekdayRecurType instance
   */
  public WeekdayRecurType getWeekdayRecurType() {
    return weekdayRecurType;
  }

  /**
   * Get the integer instance. Can be null!
   *
   * @return
   */
  public Integer getInteger() {
    return integer;
  }

  public void setInteger(Integer integer) {
    this.integer = integer;
  }

  /**
   * Returns true if this BYDAY value expands in a MONTHLY or YEARLY "RRULE".
   *
   * @return boolean
   */
  public boolean isMonthly() {
    return integer != null && integer != 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    NthWeekdayRecurType that = (NthWeekdayRecurType) o;

    if (weekdayRecurType != that.weekdayRecurType) {
      return false;
    }
    return integer != null ? integer.equals(that.integer) : that.integer == null;
  }

  @Override
  public int hashCode() {
    int result = weekdayRecurType.hashCode();
    result = 31 * result + (integer != null ? integer.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return integer == null || integer == 0
           ? weekdayRecurType.getName()
           : integer.toString() + weekdayRecurType.getName();
  }
}
