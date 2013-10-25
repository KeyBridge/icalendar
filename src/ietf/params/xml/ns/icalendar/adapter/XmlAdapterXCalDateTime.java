/*
 * Copyright 2013 Jesse Caulfield.
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

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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
 * <p>
 * @author Jesse Caulfield
 */
public class XmlAdapterXCalDateTime extends XmlAdapter<String, XMLGregorianCalendar> {

  /**
   * RFC 5545 3.3.5. DATE-TIME
   * <p/>
   * Purpose: This value type is used to identify values that specify a precise
   * calendar date and time of day.
   * <p/>
   * Format Definition: This value type is defined by the following notation:
   * <pre>
   * date-time  = date "T" time ;As specified in the DATE and TIME
   *                            ;value definitions
   * </pre> Description: If the property permits, multiple "DATE-TIME" values
   * are specified as a COMMA-separated list of values. No additional content
   * value encoding (i.e., BACKSLASH character encoding, see Section 3.3.11) is
   * defined for this value type.
   * <p/>
   * The "DATE-TIME" value type is used to identify values that contain a
   * precise calendar date and time of day. The format is based on the
   * [ISO.8601.2004] complete representation, basic format for a calendar date
   * and time of day. The text format is a concatenation of the "date", followed
   * by the LATIN CAPITAL LETTER T character, the time designator, followed by
   * the "time" format.
   * <p/>
   * The "DATE-TIME" value type expresses time values in three forms:
   * <p/>
   * The form of date and time with UTC offset MUST NOT be used. For example,
   * the following is not valid for a DATE-TIME value:
   * <p/>
   * 19980119T230000-0800 ;Invalid time format
   * <p/>
   * FORM #1: DATE WITH LOCAL TIME <em>NOT SUPPORTED</em>
   * <p/>
   * FORM #2: DATE WITH UTC TIME
   * <p/>
   * The date with UTC time, or absolute time, is identified by a LATIN CAPITAL
   * LETTER Z suffix character, the UTC designator, appended to the time value.
   * For example, the following represents January 19, 1998, at 0700 UTC:
   * <code>19980119T070000Z</code>
   * <p/>
   * The "TZID" property parameter MUST NOT be applied to DATE-TIME properties
   * whose time values are specified in UTC.
   * <p/>
   * FORM #3: DATE WITH LOCAL TIME AND TIME ZONE REFERENCE <em>NOT
   * SUPPORTED</em>
   * <p/>
   * @see <a
   * href="http://tools.ietf.org/html/rfc5545#section-3.3.5">Date-Time</a>
   */
  private static final String PATTERN_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss'Z'";

  /**
   * Unmarshal a string xCal DATE-TIME into a XMLGregorianCalendar instance.
   * <p>
   * This method is extremely forgiving of the input pattern and accepts any
   * xsd:date-time — Instant of time (Gregorian calendar) formatted input string
   * representation.
   * <p/>
   * This datatype describes instances identified by the combination of a date
   * and a time. Its value space is described as a combination of date and time
   * of day in Chapter 5.4 of ISO 8601. Its lexical space is the extended
   * format: <code>[-]CCYY-MM-DDThh:mm:ss[Z|(+|-)hh:mm]</code> The time zone may
   * be specified as Z (UTC) or (+|-)hh:mm. Time zones that aren't specified are
   * considered undetermined.
   * <p/>
   * Restrictions
   * <p/>
   * The basic format of ISO 8601 calendar datetimes, CCYYMMDDThhmmss, isn't
   * supported.
   * <p/>
   * The other forms of date-times available in ISO 8601—ordinal dates defined
   * by the year, the number of the day in the year, dates identified by
   * calendar week, and day numbers—aren't supported.
   * <p/>
   * As the value space is defined by reference to ISO 8601, there is no support
   * for any calendar system other than Gregorian. As the lexical space is also
   * defined in reference to ISO 8601, there is no support for any localization
   * such as different orders for date parts or named months.
   * <p/>
   * The order relation between date-times with and without time zone is
   * partial: they can be compared only outside of a +/- 14 hours interval.
   * Example
   * <p/>
   * Valid values for xsd:dateTime include: 2001-10-26T21:32:52,
   * 2001-10-26T21:32:52+02:00, 2001-10-26T19:32:52Z, 2001-10-26T19:32:52+00:00,
   * -2001-10-26T21:32:52, or 2001-10-26T21:32:52.12679.
   * <p/>
   * The following values are invalid: 2001-10-26 (all the parts must be
   * specified), 2001-10-26T21:32 (all the parts must be specified),
   * 2001-10-26T25:32:52+02:00 (the hours part—25—is out of range), or
   * 01-10-26T21:32 (all the parts must be specified).
   * <p/>
   * From RFC 5545 3.3.12: Fractions of a second are not supported by this
   * format.
   * <p>
   * @see <a
   * href="http://books.xmlschemata.org/relaxng/ch19-77049.html">xsd:date-time</a>
   * <p/>
   * @param v The xsd:date-time datatype string
   * @return a XMLGregorianCalendar instance, normalized to UTC, null if the
   *         input string is null or empty.
   * @throws Exception if the datatype string fails to parse
   */
  @Override
  public XMLGregorianCalendar unmarshal(String v) throws Exception {
    if (v == null || v.isEmpty()) {
      return null;
    }
    return DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) DatatypeConverter.parseDateTime(v)).normalize();
  }

  /**
   * Marshal a XMLGregorianCalendar instance into the xCal DATE format. This
   * differs from the xsd:date implementation with a more restrictive output
   * pattern:
   * <p>
   * <code>pattern = "\d\d\d\d-\d\d-\d\dT\d\d:\d\d:\d\dZ?"</code>
   * <p>
   * An example output value is: 2001-10-26
   * <p>
   * @param v the XMLGregorianCalendar instance
   * @return a patterned date string, null if the input calendar is null
   * @throws Exception should not occur
   */
  @Override
  public String marshal(XMLGregorianCalendar v) throws Exception {
    if (v == null) {
      return null;
    }
    /**
     * Ensure the calendar is always normalized to UTC as the 'Z' suffix is
     * permanently affixed.
     */
    v.normalize();
    return new SimpleDateFormat(PATTERN_DATE_TIME).format(v.toGregorianCalendar().getTime());
  }
}
