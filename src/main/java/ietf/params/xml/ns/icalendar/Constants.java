package ietf.params.xml.ns.icalendar;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * A collection of date(-time) formats, formatters, and the default time zone (UTC).
 *
 * @author Andrius Druzinis-Vitkus
 * @since 0.0.1 created 15/07/2017
 */
public class Constants {
  /**
   * RFC5545 3.3.4. DATE
   * <p>
   * Purpose: This value type is used to identify values that contain a calendar
   * date.
   * <p>
   * Format Definition: This value type is defined by the following notation:
   * <pre>
   * date               = date-value
   * date-value         = date-fullyear date-month date-mday
   * date-fullyear      = 4DIGIT
   * date-month         = 2DIGIT        ;01-12
   * date-mday          = 2DIGIT        ;01-28, 01-29, 01-30, 01-31
   *                                    ;based on month/year
   * </pre> Description: If the property permits, multiple "date" values are
   * specified as a COMMA-separated list of values. The format for the value
   * type is based on the [ISO.8601.2004] complete representation, basic format
   * for a calendar date. The textual format specifies a four-digit year,
   * two-digit month, and two-digit day of the month. There are no separator
   * characters between the year, month, and day component text.
   * <p>
   * No additional content value encoding (i.e., BACKSLASH character encoding,
   * see Section 3.3.11) is defined for this value type.
   * <p>
   * RFC 6321: 3.3.4 DATE: The date encoding pattern is:
   * <code>pattern-date = xsd:string { pattern = "\d\d\d\d-\d\d-\d\d" }</code>
   * XML Definition: Appendix A # 3.3.4 Example:
   * <date>2011-05-17</date>
   *
   * @see <a href="http://tools.ietf.org/html/rfc5545#section-3.3.4">Date</a>
   * @see <a href="http://tools.ietf.org/html/rfc6321#section-3.6.4">RELAX NG
   * Schema 3.6.4 DATE</a>
   */
  public static final String PATTERN_RFC5545_DATE = "yyyyMMdd";
  public static final String PATTERN_RFC6321_DATE = "yyyy-MM-dd";
  /**
   * RFC 5545 3.3.5. DATE-TIME
   * <p>
   * Purpose: This value type is used to identify values that specify a precise
   * calendar date and time of day.
   * <p>
   * Format Definition: This value type is defined by the following notation:
   * <pre>
   * date-time  = date "T" time ;As specified in the DATE and TIME
   *                            ;value definitions
   * </pre> Description: If the property permits, multiple "DATE-TIME" values
   * are specified as a COMMA-separated list of values. No additional content
   * value encoding (i.e., BACKSLASH character encoding, see Section 3.3.11) is
   * defined for this value type.
   * <p>
   * The "DATE-TIME" value type is used to identify values that contain a
   * precise calendar date and time of day. The format is based on the
   * [ISO.8601.2004] complete representation, basic format for a calendar date
   * and time of day. The text format is a concatenation of the "date", followed
   * by the LATIN CAPITAL LETTER T character, the time designator, followed by
   * the "time" format.
   * <p>
   * The "DATE-TIME" value type expresses time values in three forms:
   * <p>
   * The form of date and time with UTC offset MUST NOT be used. For example,
   * the following is not valid for a DATE-TIME value:
   * <p>
   * 19980119T230000-0800 ;Invalid time format
   * <p>
   * FORM #1: DATE WITH LOCAL TIME <em>NOT SUPPORTED</em>
   * <p>
   * FORM #2: DATE WITH UTC TIME
   * <p>
   * The date with UTC time, or absolute time, is identified by a LATIN CAPITAL
   * LETTER Z suffix character, the UTC designator, appended to the time value.
   * <p>
   * RFC 6321: 3.3.5 DATE-TIME: The date-time encoding pattern is:
   * <code>pattern-date-time = xsd:string { pattern = "\d\d\d\d-\d\d-\d\dT\d\d:\d\d:\d\dZ?" }</code>
   * XML Definition: Appendix A # 3.3.5 Example:
   * <date-time>2011-05-17T12:00:00</date-time>
   * <p>
   * The "TZID" property parameter MUST NOT be applied to DATE-TIME properties
   * whose time values are specified in UTC.
   * <p>
   * FORM #3: DATE WITH LOCAL TIME AND TIME ZONE REFERENCE <em>NOT
   * SUPPORTED</em>
   *
   * @see <a
   * href="http://tools.ietf.org/html/rfc5545#section-3.3.5">Date-Time</a>
   * @see <a href="http://tools.ietf.org/html/rfc6321#section-3.6.5">RELAX NG
   * Schema 3.6.5 DATE-TIME</a>
   */
  public static final String PATTERN_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  /**
   * RFC 2445 UTC date time pattern.
   * <p>
   * This pattern is to be used only when printing to String. The PATTERN_RFC5545_DATE
   * and PATTERN_DATE_TIME are to be used when marshaling to XML.
   *
   * @see RFC 6321
   */
  public static final String PATTERN_UTC = "yyyyMMdd'T'HHmmss'Z'";
  /**
   * Coordinated Universal Time.
   * <p>
   * Used to normalize all calendar instances to UTC. e.g.
   * 2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z. Implements
   * W3C XML Schema Part 2, Section 3.2.7.3 (A)
   */
  public static final ZoneId TIMEZONE_UTC = ZoneId.of("UTC");

  public static final DateTimeFormatter FORMATTER_RFC5545_DATE = DateTimeFormatter.ofPattern(PATTERN_RFC5545_DATE, Locale.ENGLISH);
  public static final DateTimeFormatter FORMATTER_RFC6321_DATE = DateTimeFormatter.ofPattern(PATTERN_RFC6321_DATE, Locale.ENGLISH);
  public static final DateTimeFormatter FORMATTER_DATE_TIME = DateTimeFormatter.ofPattern(PATTERN_DATE_TIME, Locale.ENGLISH);
  public static final DateTimeFormatter FORMATTER_UTC = DateTimeFormatter.ofPattern(PATTERN_UTC, Locale.ENGLISH);
}
