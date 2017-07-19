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

import java.time.Duration;
import java.time.format.DateTimeParseException;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Java XML adapter to translate between the a duration string as defined in the
 * W3C XML Schema 1.0 specification [ISO 8601] extended format and a
 * java.time.Duration
 *
 * @author Andrius Druzinis-Vitkus
 * @since 0.0.1 created 15/07/2017
 */
public class XmlAdapterDurationXCalDateTime extends XmlAdapter<String, Duration> {

  /**
   * Unmarshal an ISO 8601 extended format duration string.
   * <p>
   * For example, P1347Y, P1347M and P1Y2MT2H are all allowed; P0Y1347M and
   * P0Y1347M0D are allowed. P-1347M is not allowed although -P1347M is allowed.
   * P1Y2MT is not allowed.
   *
   * @param v input string
   * @return duration instance. Null if an empty string is provided.
   * @throws DateTimeParseException parsing failure
   */
  @Override
  public Duration unmarshal(String v) throws DateTimeParseException {
    if (v == null || v.isEmpty()) {
      return null;
    }
    return Duration.parse(v);
  }

  /**
   * Marshal a java.time.Duration instance into the [ISO 8601] extended format.
   *
   * @param v the java.time.Duration instance
   * @return a patterned duration string, null if the input calendar is null
   */
  @Override
  public String marshal(Duration v) {
    if (v == null) {
      return null;
    }
    return v.toString();
  }
}
