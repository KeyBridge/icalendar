package ietf.params.xml.ns.icalendar.adapter;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrius Druzinis-Vitkus
 * @since 0.0.1 created 19/07/2017
 */
public class XmlAdapterLocalDateTimeXCalDateTimeTest {
  private static XmlAdapterLocalDateTimeXCalDateTime adapter = new XmlAdapterLocalDateTimeXCalDateTime();

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
    LocalDateTime dateTime = LocalDateTime.now().withNano(0);
    testMarshalUnmarsal(dateTime, true);

    dateTime = LocalDateTime.now().minusDays(5).withNano(0);
    testMarshalUnmarsal(dateTime, true);

    // Test leap years
    for (int leapYear : DateTestUtil.leapYears) {
      dateTime = LocalDateTime.of(leapYear, 2, 29, 12, 30);
      testMarshalUnmarsal(dateTime, false);
    }

    // Test for all dateTimes in year 1970-01-01 at 30 second increments
    DateTestUtil.generateDateTimes()
        .forEach(dateTime1 -> testMarshalUnmarsal(dateTime1, false));
  }

  private static void testMarshalUnmarsal(LocalDateTime dateTime, boolean logToConsole) {
    if (logToConsole) System.out.println("Input dateTime: " + dateTime);
    String marshalled = adapter.marshal(dateTime);
    if (logToConsole) System.out.println("Marshalled dateTime: " + marshalled);
    LocalDateTime unmarshalled = adapter.unmarshal(marshalled);
    if (logToConsole) System.out.println("Unmarshalled dateTime: " + unmarshalled);

    assertEquals(dateTime, unmarshalled);
    if (logToConsole) System.out.println();
  }
}