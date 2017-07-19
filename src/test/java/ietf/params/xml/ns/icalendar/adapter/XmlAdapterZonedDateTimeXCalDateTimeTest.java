package ietf.params.xml.ns.icalendar.adapter;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrius Druzinis-Vitkus
 * @since 0.0.1 created 19/07/2017
 */
public class XmlAdapterZonedDateTimeXCalDateTimeTest {
  private static XmlAdapterZonedDateTimeXCalDateTime adapter = new XmlAdapterZonedDateTimeXCalDateTime();

  @Test
  public void unmarshalAndUnmarshalTest() throws Exception {
    /**
     * Developer note:
     * PATTERN_DATE_TIME used by XmlAdapterLocalDateTimeXCalDateTime
     * does not contain a nanosecond field. If a LocalDateTime
     * has non-zero nanoseconds, they will be effectively set to zero.
     *
     * The following two test cases have this field set to zero
     * explicitly so that the original date equals the marshalled
     * and unmarshalled result.
     */
    ZonedDateTime dateTime = ZonedDateTime.now().withNano(0);
    testMarshalUnmarsal(dateTime, true);

    dateTime = ZonedDateTime.now().minusDays(5).withNano(0);
    testMarshalUnmarsal(dateTime, true);

    // Test leap years
    for (int leapYear : DateTestUtil.leapYears) {
      dateTime = ZonedDateTime.of(leapYear, 2, 29, 12, 30, 0, 0, ZoneId.of("UTC"));
      testMarshalUnmarsal(dateTime, false);
    }

    // Test for all dateTimes in year 1970-01-01 at 30 second increments
    DateTestUtil.generateDateTimes()
        .map(t -> ZonedDateTime.of(t, ZoneId.of("UTC")))
        .forEach(dateTime1 -> testMarshalUnmarsal(dateTime1, false));
  }

  private static void testMarshalUnmarsal(ZonedDateTime dateTime, boolean logToConsole) {
    if (logToConsole) System.out.println("Input dateTime: " + dateTime);
    String marshalled = adapter.marshal(dateTime);
    if (logToConsole) System.out.println("Marshalled dateTime: " + marshalled);
    ZonedDateTime unmarshalled = adapter.unmarshal(marshalled);
    if (logToConsole) System.out.println("Unmarshalled dateTime: " + unmarshalled);

    assertEquals(dateTime, unmarshalled);
    if (logToConsole) System.out.println();
  }
}