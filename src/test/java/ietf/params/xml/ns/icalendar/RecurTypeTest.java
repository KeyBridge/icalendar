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

import java.time.LocalDate;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

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

}
