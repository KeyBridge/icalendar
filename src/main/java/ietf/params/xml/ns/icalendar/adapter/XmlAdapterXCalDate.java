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

import java.util.GregorianCalendar;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java XML adapter to translate between the W3C xsd:date format and the RelaxNG
 * date format specified within the RFC 6321 (xCal) specification.
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
 * 3.3.4 DATE: pattern-date = xsd:string { pattern = "\d\d\d\d-\d\d-\d\d" }
 *
 * @author Jesse Caulfield
 */
public class XmlAdapterXCalDate extends XmlAdapter<String, XMLGregorianCalendar> {

  /**
   * Unmarshal a string xCal DATE into a XMLGregorianCalendar instance.
   * <p>
   * This method is extremely forgiving of the input pattern and accepts any
   * xsd:date (Gregorian calendar date) formatted input string representation.
   * <p>
   * The xsd:date datatype is modeled after the calendar dates defined in
   * Chapter 5.2.1 of ISO (International Organization for Standardization) 8601.
   * Its value space is the set of Gregorian calendar dates as defined by this
   * standard; i.e., a one-day-long period of time. Its lexical space is the ISO
   * 8601 extended format: <code>[-]CCYY-MM-DD[Z|(+|-)hh:mm]</code> with an
   * optional time zone. Time zones that aren't specified are considered
   * undetermined.
   * <p>
   * Restrictions
   * <p>
   * The basic format of ISO 8601 calendar dates, CCYYMMDD, isn't supported.
   * <p>
   * The other forms of dates available in ISO 8601 aren't supported: ordinal
   * dates defined by the year, the number of the day in the year, dates
   * identified by calendar week, and day numbers.
   * <p>
   * As the value space is defined by reference to ISO 8601, there is no support
   * for any calendar system other than Gregorian. Because the lexical space is
   * also defined using a reference to ISO 8601, there is no support for any
   * localization such as different orders for date parts or named months.
   * <p>
   * The order relation between dates with and without time zone is partial:
   * they can be compared beyond a +/- 14 hour interval.
   * <p>
   * There is a difference between ISO 8601, which defines a day as a 24-hour
   * period of time, and the W3C XML Schema, which indicates that a date is a
   * "one-day-long, non-periodic instance ... independent of how many hours this
   * day has." Even though technically correct, some days don't last exactly 24
   * hours because of leap seconds; this definition doesn't concur with the
   * definition of xsd:duration that states that a day is always exactly 24
   * hours long.
   * <p>
   * Valid values include: 2001-10-26, 2001-10-26+02:00, 2001-10-26Z,
   * 2001-10-26+00:00, -2001-10-26, or -20000-04-01.
   * <p>
   * The following values would be invalid: 2001-10 (all the parts must be
   * specified), 2001-10-32 (the days part—32—is out of range), 2001-13-26+02:00
   * (the month part—13—is out of range), or 01-10-26 (the century part is
   * missing).
   *
   * @see <a
   * href="http://books.xmlschemata.org/relaxng/ch19-77041.html">xsd:date</a>
   *
   * @param v The xsd:date datatype string
   * @return a XMLGregorianCalendar instance, normalized to UTC, null if the
   *         input string is null or empty.
   * @throws Exception if the datatype string fails to parse
   */
  @Override
  public XMLGregorianCalendar unmarshal(String v) throws Exception {
    if (v == null || v.isEmpty()) {
      return null;
    }
    return DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) DatatypeConverter.parseDate(v)).normalize();
  }

  /**
   * Marshal a XMLGregorianCalendar instance into the xCal DATE format. This
   * differs from the xsd:date implementation with a more restrictive output
   * pattern: <code>pattern = "\d\d\d\d-\d\d-\d\d"</code>
   * <p>
   * An example output value is: 2001-10-26
   *
   * @param v the XMLGregorianCalendar instance
   * @return a patterned date string, null if the input calendar is null
   * @throws Exception should not occur
   */
  @Override
  public String marshal(XMLGregorianCalendar v) throws Exception {
    if (v == null) {
      return null;
    }
    return String.format("%04d-%02d-%02d", v.getYear(), v.getMonth(), v.getDay());
  }
}
