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
package ietf.params.xml.ns.icalendar.adapter;

import ietf.params.xml.ns.icalendar.EWeekdayRecurType;
import ietf.params.xml.ns.icalendar.NthWeekdayRecurType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * A parser for BYDAY RRULE values, such as 1MO, TU, -2FR.
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
public class XmlAdapterNthWeekday extends XmlAdapter<String, NthWeekdayRecurType> {

  /**
   * Unmarshall BYDAY RRULE values, such as 1MO, TU, -2FR.
   *
   * @param v BYDAY RRULE string value
   * @return an NthWeekdayRecurType instance if input string valid, null
   *         otherwise
   */
  @Override
  public NthWeekdayRecurType unmarshal(String v) {
    if (v == null || v.isEmpty() || v.length() < 2) {
      return null;
    }
    NthWeekdayRecurType weekdayRecurType = new NthWeekdayRecurType(EWeekdayRecurType.valueOf(v.substring(v.length() - 2)));
    if (v.length() > 2) {
      weekdayRecurType.setInteger(Integer.valueOf(v.substring(0, v.length() - 2)));
    }
    return weekdayRecurType;
  }

  /**
   * Convert an NthWeekdayRecurType instance to an BYDAY RRULE string, such as
   * 1MO, TU, -2FR
   *
   * @param v NthWeekdayRecurType instance
   * @return BYDAY RRULE string, such as 1MO, TU, -2FR
   */
  @Override
  public String marshal(NthWeekdayRecurType v) {
    return v != null ? v.toString() : null;
  }
}
