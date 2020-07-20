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

import ietf.params.xml.ns.icalendar.Constants;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Java XML adapter to translate between the W3C xsd:date-time format and the
 * RelaxNG date-time format specified within the RFC 6321 (xCal) specification.
 * <p>
 * Patterns for date/time, duration, and UTC offset values are given because
 * those differ from the values used in iCalendar. More restrictive schema with
 * patterns and numerical limits could be derived from the example schema here
 * if more comprehensive schema validation is required.
 * <p>
 * RELAX NG Schema for iCalendar in XML
 * <p>
 * default namespace = "urn:ietf:params:xml:ns:icalendar-2.0"
 * <p>
 * 3.3.5 DATE-TIME pattern-date-time = xsd:string { pattern =
 * "\d\d\d\d-\d\d-\d\dT\d\d:\d\d:\d\dZ?" }
 *
 * @author Jesse Caulfield
 */
public class XmlAdapterLocalDateTimeXCalDateTime extends XmlAdapter<String, LocalDateTime> {

  /**
   * Unmarshal a string xCal DATE-TIME into a java.time.LocalDateTime instance.
   * <p>
   * This method is extremely forgiving of the input pattern and accepts any
   * xsd:date-time — Instant of time (Gregorian calendar) formatted input string
   * representation.
   * <p>
   * This datatype describes instances identified by the combination of a date
   * and a time. Its value space is described as a combination of date and time
   * of day in Chapter 5.4 of ISO 8601. Its lexical space is the extended
   * format: <code>[-]CCYY-MM-DDThh:mm:ss[Z|(+|-)hh:mm]</code> The time zone may
   * be specified as Z (UTC) or (+|-)hh:mm. Time zones that aren't specified are
   * considered undetermined.
   * <p>
   * Restrictions
   * <p>
   * The basic format of ISO 8601 calendar datetimes, CCYYMMDDThhmmss, isn't
   * supported.
   * <p>
   * The other forms of date-times available in ISO 8601—ordinal dates defined
   * by the year, the number of the day in the year, dates identified by
   * calendar week, and day numbers—aren't supported.
   * <p>
   * As the value space is defined by reference to ISO 8601, there is no support
   * for any calendar system other than Gregorian. As the lexical space is also
   * defined in reference to ISO 8601, there is no support for any localization
   * such as different orders for date parts or named months.
   * <p>
   * The order relation between date-times with and without time zone is
   * partial: they can be compared only outside of a +/- 14 hours interval.
   * Example
   * <p>
   * Valid values for xsd:dateTime include: 2001-10-26T21:32:52,
   * 2001-10-26T21:32:52+02:00, 2001-10-26T19:32:52Z, 2001-10-26T19:32:52+00:00,
   * -2001-10-26T21:32:52, or 2001-10-26T21:32:52.12679.
   * <p>
   * The following values are invalid: 2001-10-26 (all the parts must be
   * specified), 2001-10-26T21:32 (all the parts must be specified),
   * 2001-10-26T25:32:52+02:00 (the hours part—25—is out of range), or
   * 01-10-26T21:32 (all the parts must be specified).
   * <p>
   * From RFC 5545 3.3.12: Fractions of a second are not supported by this
   * format.
   *
   * @see <a
   * href="http://books.xmlschemata.org/relaxng/ch19-77049.html">xsd:date-time</a>
   *
   * @param v The xsd:date-time datatype string
   * @return a LocalDateTime instance, normalized to UTC, null if the input
   *         string is null or empty.
   * @throws DateTimeParseException if the datatype string fails to parse
   */
  @Override
  public LocalDateTime unmarshal(String v) throws DateTimeParseException {
    if (v == null || v.isEmpty()) {
      return null;
    }
    for (DateTimeFormatter formatter : Arrays.asList(Constants.FORMATTER_RFC5545_DATE_TIME, Constants.FORMATTER_RFC2245_DATE_TIME)) {
      try {
        return LocalDateTime.parse(v, formatter);
      } catch (Exception e) {
      }
    }
    return null;
  }

  /**
   * Marshal a LocalDateTime instance into the xCal DATE format. This differs
   * from the xsd:date implementation with a more restrictive output pattern:
   * <p>
   * <code>pattern = "\d\d\d\d-\d\d-\d\dT\d\d:\d\d:\d\dZ?"</code>
   * <p>
   * An example output value is: 2001-10-26
   *
   * @param v the LocalDateTime instance
   * @return a patterned date string, null if the input calendar is null
   * @throws DateTimeException if an error occurs during printing
   */
  @Override
  public String marshal(LocalDateTime v) throws DateTimeException {
    if (v == null) {
      return null;
    }
    /**
     * Ensure the calendar is always normalized to UTC as the 'Z' suffix is
     * permanently affixed.
     */
    return v.format(Constants.FORMATTER_RFC5545_DATE_TIME);
  }
}
