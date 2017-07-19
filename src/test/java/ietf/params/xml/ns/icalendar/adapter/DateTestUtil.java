package ietf.params.xml.ns.icalendar.adapter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A utility class listing some leap years and generating
 * a large number of LocalDateTimes for testing purposes.
 *
 * @author Andrius Druzinis-Vitkus
 * @since 0.0.1 created 19/07/2017
 */
class DateTestUtil {

  /**
   * A array with every leap year between 1900 and 2020.
   */
  static int[] leapYears = new int[] {1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948,
      1952, 1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012,
      2016, 2020};

  /**
   * Generate a stream of LocalDateTime instances starting at midnight on 1970-01-01
   * at every 30 seconds until the end of that year.
   * @return  stream of LocalDateTime instances
   */
  static Stream<LocalDateTime> generateDateTimes() {
    int secondsInYear = Math.toIntExact(Duration.ofDays(365).getSeconds()) / 30;
    return IntStream.range(0, secondsInYear)
        .parallel()
        .mapToObj(i -> LocalDateTime.ofEpochSecond(i * 30, 0, ZoneOffset.UTC));
  }
}
