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
package ch.keybridge.icalendar.jsf.dto;

import ietf.params.xml.ns.icalendar.PeriodType;
import ietf.params.xml.ns.icalendar.RecurType;
import ietf.params.xml.ns.icalendar.util.ICalendar;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

/**
 *
 * @author Key Bridge
 */
public class ScheduledEventTest {

  public ScheduledEventTest() {
  }

  @Test
  public void testToString() {

    ScheduledEvent se = new ScheduledEvent(new Date(), new Date(), true);
    se.setTimeZone(TimeZone.getTimeZone("Canada/Pacific"));
    System.out.println("SE " + se);

    LocalDateTime ldt = LocalDateTime.ofInstant(se.getStartDate().toInstant(), ZoneId.of(se.getTimeZone().getID()));
    System.out.println("ldt  " + ldt);
    ZonedDateTime zdt = ZonedDateTime.ofInstant(se.getStartDate().toInstant(), ZoneId.of(se.getTimeZone().getID()));
    System.out.println("ZDT: " + zdt);

    DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;

    System.out.println("format " + zdt.format(formatter));

  }

  @Test
  public void testPeriodList() throws Exception {
    LocalDateTime eventStart = LocalDateTime.of(2017, 9, 1, 9, 0, 0),
        eventEnd = eventStart.plus(2, ChronoUnit.HOURS),
        periodStart = eventStart,
        periodEnd = eventStart.plus(1, ChronoUnit.YEARS);

    System.out.println("eventStart = " + eventStart);
    System.out.println("eventEnd = " + eventEnd);
    System.out.println("periodStart = " + periodStart);
    System.out.println("periodEnd = " + periodEnd);

    Set<PeriodType> periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=WEEKLY;INTERVAL=1"), periodStart, periodEnd);
    Assert.assertTrue(!periods.isEmpty());
    testEveryEventInSet(periods, periodEnd, new PeriodType(eventStart, eventEnd), 1, ChronoUnit.WEEKS);

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=MONTHLY;INTERVAL=1"), periodStart, periodEnd);
    Assert.assertTrue(!periods.isEmpty());
    testEveryEventInSet(periods, periodEnd, new PeriodType(eventStart, eventEnd), 1, ChronoUnit.MONTHS);

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=WEEKLY;BYDAY=FR"), periodStart, periodEnd);
    Assert.assertTrue(!periods.isEmpty());
    testEveryEventInSet(periods, periodEnd, new PeriodType(eventStart, eventEnd), 1, ChronoUnit.WEEKS);

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=WEEKLY;BYDAY=SU"), periodStart, periodEnd);
    Assert.assertTrue(!periods.isEmpty());
    testEveryEventInSet(periods, periodEnd, new PeriodType(eventStart.plus(2, ChronoUnit.DAYS), eventEnd.plus(2, ChronoUnit.DAYS)), 1, ChronoUnit.WEEKS);

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=DAILY;INTERVAL=1"), periodStart, periodEnd);
    Assert.assertTrue(!periods.isEmpty());
    testEveryEventInSet(periods, periodEnd, new PeriodType(eventStart, eventEnd), 1, ChronoUnit.DAYS);

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=HOURLY;INTERVAL=1"), periodStart, periodEnd);
    Assert.assertTrue(!periods.isEmpty());
    testEveryEventInSet(periods, periodEnd, new PeriodType(eventStart, eventEnd), 1, ChronoUnit.HOURS);

  }

  public static void testEveryEventInSet(Set<PeriodType> periodsToTest, LocalDateTime periodEnd, PeriodType firstEvent, int interval, TemporalUnit temporalUnit) {
    int count = 0;
    Duration eventLength = firstEvent.getDuration();
    LocalDateTime testDate = firstEvent.getStart();
    while (testDate.compareTo(periodEnd) <= 0) {
      count++;
      Assert.assertTrue(periodsToTest.contains(new PeriodType(testDate, testDate.plus(eventLength))));
      testDate = testDate.plus(interval, temporalUnit);
    }
    Assert.assertEquals(count, periodsToTest.size());
  }

//  @Test //todo
  public void testByDay() throws Exception {
    LocalDateTime eventStart = LocalDateTime.of(2017, 9, 1, 9, 0, 0),
        eventEnd = eventStart.plus(2, ChronoUnit.HOURS),
        periodStart = eventStart,
        periodEnd = periodStart.plus(1, ChronoUnit.WEEKS);

    System.out.println("eventStart = " + eventStart);
    System.out.println("eventEnd = " + eventEnd);
    System.out.println("periodStart = " + periodStart);
    System.out.println("periodEnd = " + periodEnd);
    Assert.assertEquals(5, ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=WEEKLY;INTERVAL=1;BYDAY=SU,MO,TU,TH"), periodStart, periodEnd).size());
  }

}
