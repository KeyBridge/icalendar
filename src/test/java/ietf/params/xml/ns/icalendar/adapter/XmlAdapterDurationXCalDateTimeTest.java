package ietf.params.xml.ns.icalendar.adapter;

import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrius Druzinis-Vitkus
 * @since 0.0.1 created 19/07/2017
 */
public class XmlAdapterDurationXCalDateTimeTest {

  private static XmlAdapterDurationXCalDateTime adapter = new XmlAdapterDurationXCalDateTime();

  @Test
  public void unmarshal() throws Exception {
    Duration duration = Duration.ZERO;

    testMarshalUnmarsal(duration, true);

    LocalDateTime start = DateTestUtil.generateDateTimes()
      .findFirst()
      .orElseThrow(IllegalStateException::new);
    DateTestUtil.generateDateTimes()
      .map(t -> Duration.between(start, t))
      .forEach(d -> testMarshalUnmarsal(d, false));
  }

  private static void testMarshalUnmarsal(Duration duration, boolean logToConsole) {
    if (logToConsole) {
      System.out.println("Input duration: " + duration);
    }
    String marshalled = adapter.marshal(duration);
    if (logToConsole) {
      System.out.println("Marshalled duration: " + marshalled);
    }
    Duration unmarshalled = adapter.unmarshal(marshalled);
    if (logToConsole) {
      System.out.println("Unmarshalled duration: " + unmarshalled);
    }

    assertEquals(duration, unmarshalled);
    if (logToConsole) {
      System.out.println();
    }
  }

}
