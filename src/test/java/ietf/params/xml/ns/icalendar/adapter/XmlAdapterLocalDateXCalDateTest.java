package ietf.params.xml.ns.icalendar.adapter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andrius Druzinis-Vitkus
 * @since 0.0.1 created 19/07/2017
 */
public class XmlAdapterLocalDateXCalDateTest {

  private static XmlAdapterLocalDateXCalDate adapter = new XmlAdapterLocalDateXCalDate();

  @Test
  public void unmarshalAndUnmarshalTest() throws Exception {
    /**
     * Developer note: PATTERN_DATE_TIME used by
     * XmlAdapterLocalDateTimeXCalDateTime does not contain a nanosecond field.
     * If a LocalDateTime has non-zero nanoseconds, they will be effectively set
     * to zero.
     * <p>
     * The following two test cases have this field set to zero explicitly so
     * that the original date equals the marshalled and unmarshalled result.
     */
    LocalDate dateTime = LocalDate.now();
    testMarshalUnmarsal(dateTime, true);

    dateTime = LocalDate.now().minusDays(5);
    testMarshalUnmarsal(dateTime, true);

    // Test leap years
    for (int leapYear : DateTestUtil.leapYears) {
      dateTime = LocalDate.of(leapYear, 2, 29);
      testMarshalUnmarsal(dateTime, false);
    }

    // Test for all dates in year 1970-01-01
    DateTestUtil.generateDateTimes()
      .map(LocalDateTime::toLocalDate)
      .distinct()
      .forEach(dateTime1 -> testMarshalUnmarsal(dateTime1, false));
  }

  private static void testMarshalUnmarsal(LocalDate date, boolean logToConsole) {
    if (logToConsole) {
      System.out.println("Input date: " + date);
    }
    try {
      String marshalled = adapter.marshal(date);
      if (logToConsole) {
        System.out.println("Marshalled date: " + marshalled);
      }
      LocalDate unmarshalled = adapter.unmarshal(marshalled);
      if (logToConsole) {
        System.out.println("Unmarshalled date: " + unmarshalled);
      }

      assertEquals(date, unmarshalled);
    } catch (DateTimeException dateTimeException) {
      fail(dateTimeException.getMessage());
    }
    if (logToConsole) {
      System.out.println();
    }
  }

}
