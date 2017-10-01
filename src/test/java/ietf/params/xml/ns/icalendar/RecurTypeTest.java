/*
 * Copyright 2017 IETF. All rights reserved.
 * Use is subject to license terms.
 *
 * Software Code is protected by Copyrights. Author hereby reserves all rights
 * in and to Copyrights and no license is granted under Copyrights in this
 * Software License Agreement.
 *
 * IETF generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request from: info@keybridgewireless.com
 */
package ietf.params.xml.ns.icalendar;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Key Bridge
 */
public class RecurTypeTest {

  public RecurTypeTest() {
  }

  @Test
  public void testUntilDate() {

    RecurType r = new RecurType();

    LocalDate untilLocalDate = r.getUntil().getDate();
    System.out.println("start with untilLocalDate  " + untilLocalDate);

//    Date instanceDate = Date.from(untilLocalDate.atStartOfDay().toInstant(ZoneOffset.UTC));
//    System.out.println("Instant date    " + instanceDate);
    Date untildate = r.getUntilDate();
    System.out.println("convert to date            " + untildate);

    r.setUntilDate(untildate);

    System.out.println("set date, should be equal: " + r.getUntil().getDate().equals(untilLocalDate));

    Assert.assertEquals(untilLocalDate, r.getUntil().getDate());
  }

  @Test
  public void xmlMarshalUnmarshalTest() throws Exception {
    testMarshalUnmarshal(new RecurType());
    testMarshalUnmarshal(new RecurType("FREQ=WEEKLY;COUNT=10"));
    testMarshalUnmarshal(new RecurType("FREQ=DAILY;INTERVAL=2;UNTIL=20170925T000000Z"));
    testMarshalUnmarshal(new RecurType("FREQ=DAILY;INTERVAL=1;COUNT=5"));
    testMarshalUnmarshal(new RecurType("FREQ=DAILY;INTERVAL=1;COUNT=5;BYDAY=MO,SU"));
    testMarshalUnmarshal(new RecurType("FREQ=DAILY;INTERVAL=1;COUNT=5;BYDAY=1MO,-2SU"));
  }

  private static void testMarshalUnmarshal(RecurType recur) {
    try {
      JAXBContext context = JAXBContext.newInstance(RecurType.class);
      Marshaller m = context.createMarshaller();
      StringWriter writer = new StringWriter();
      m.marshal(recur, writer);
      Unmarshaller um = context.createUnmarshaller();
      Assert.assertEquals(recur, um.unmarshal(new StringReader(writer.toString())));
    } catch (JAXBException e) {
      e.printStackTrace();
      Assert.fail("Failed to marshal or unmarshal: " + e.getMessage());
    }
  }
}
