/*
 * Copyright 2017 IETF. All rights reserved.
 * Use is subject to license terms.
 *
 * This software code is protected by Copyrights and remains the property of
 * IETF and its suppliers, if any.
 * IETF reserves all rights in and to Copyrights and
 * no license is granted under Copyrights in this Software License Agreement.
 *
 * IETF generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request from: info@keybridgewireless.com
 *
 * All information contained herein is the property of {project.organization!user}
 * and its suppliers, if any. The intellectual and technical concepts contained
 * herein are proprietary.
 */
package ietf.params.xml.ns.icalendar.util;

import ietf.params.xml.ns.icalendar.PeriodType;
import ietf.params.xml.ns.icalendar.RecurType;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author Key Bridge
 */
public class PeriodSetTest {

  @Test
  public void testCalculatePeriodSet() throws Exception {

    LocalDateTime eventStart = LocalDateTime.of(2017, Month.NOVEMBER, 12, 0, 0);
    LocalDateTime eventEnd = eventStart.plusHours(2);

    LocalDateTime periodStart = LocalDateTime.of(2017, Month.OCTOBER, 29, 0, 0);
    LocalDateTime periodEnd = LocalDateTime.of(2017, Month.DECEMBER, 9, 0, 0);

//    RecurType recurType = new RecurType("FREQ=WEEKLY;INTERVAL=1;BYDAY=SU,MO");;
    RecurType recurType = new RecurType("FREQ=WEEKLY;INTERVAL=2;BYDAY=SU,WE,FR");

    System.out.println("RECUR ");
    System.out.println("  " + recurType.toString());

    Set<PeriodType> periodSet = ICalendar.calculatePeriodSet(eventStart, eventEnd, recurType, periodStart, periodEnd);

    System.out.println("Calculate period set " + periodSet.size() + " events");

    for (PeriodType periodType : periodSet) {
      System.out.println("  " + periodType);
    }

  }

}
