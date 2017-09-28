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

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
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
    // remove the original event so that testEveryEventInSet() can check only the recurring events
    periods.remove(new PeriodType(eventStart, eventEnd));
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

  @Test
  public void testByDayAndMinute() throws Exception {
    LocalDateTime eventStart = LocalDateTime.of(2017, 9, 1, 9, 0, 0),
        eventEnd = eventStart.plus(2, ChronoUnit.HOURS),
        periodStart = eventStart,
        periodEnd = periodStart.plus(1, ChronoUnit.WEEKS);

    System.out.println("eventStart = " + eventStart);
    System.out.println("eventEnd = " + eventEnd);
    System.out.println("periodStart = " + periodStart);
    System.out.println("periodEnd = " + periodEnd);

    Set<PeriodType> periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=WEEKLY;INTERVAL=1;BYDAY=SU,MO,TU,TH"), periodStart, periodEnd);
    periods.forEach(System.out::println);
    Assert.assertEquals(5, periods.size());
    // check if the original Friday event is in the set
    Assert.assertTrue(periods.contains(new PeriodType(eventStart, eventEnd)));
    // check if the Sunday (+2 days from Friday) event is in the set
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plus(2, ChronoUnit.DAYS), eventEnd.plus(2, ChronoUnit.DAYS))));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plus(3, ChronoUnit.DAYS), eventEnd.plus(3, ChronoUnit.DAYS))));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plus(4, ChronoUnit.DAYS), eventEnd.plus(4, ChronoUnit.DAYS))));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plus(6, ChronoUnit.DAYS), eventEnd.plus(6, ChronoUnit.DAYS))));

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=WEEKLY;INTERVAL=1;BYDAY=SU,MO,TU,TH;BYHOUR=12,16"), periodStart, periodEnd);
    periods.forEach(System.out::println);
    Assert.assertEquals(9, periods.size());
    // check if the original Friday event is in the set
    Assert.assertTrue(periods.contains(new PeriodType(eventStart, eventEnd)));
    // check if the Sunday (+2 days from Friday) 12:00 and 16:00 events are in the set
    Assert.assertTrue(periods.contains(
        new PeriodType(
            eventStart.plus(2, ChronoUnit.DAYS).withHour(12),
            eventStart.plus(2, ChronoUnit.DAYS).withHour(14))));
    Assert.assertTrue(periods.contains(
        new PeriodType(
            eventStart.plus(2, ChronoUnit.DAYS).withHour(16),
            eventStart.plus(2, ChronoUnit.DAYS).withHour(18))));

    Assert.assertTrue(periods.contains(
        new PeriodType(
            eventStart.plus(3, ChronoUnit.DAYS).withHour(12),
            eventStart.plus(3, ChronoUnit.DAYS).withHour(14))));
    Assert.assertTrue(periods.contains(
        new PeriodType(
            eventStart.plus(3, ChronoUnit.DAYS).withHour(16),
            eventStart.plus(3, ChronoUnit.DAYS).withHour(18))));

    Assert.assertTrue(periods.contains(
        new PeriodType(
            eventStart.plus(4, ChronoUnit.DAYS).withHour(12),
            eventStart.plus(4, ChronoUnit.DAYS).withHour(14))));
    Assert.assertTrue(periods.contains(
        new PeriodType(
            eventStart.plus(4, ChronoUnit.DAYS).withHour(16),
            eventStart.plus(4, ChronoUnit.DAYS).withHour(18))));

    Assert.assertTrue(periods.contains(
        new PeriodType(
            eventStart.plus(6, ChronoUnit.DAYS).withHour(12),
            eventStart.plus(6, ChronoUnit.DAYS).withHour(14))));
    Assert.assertTrue(periods.contains(
        new PeriodType(
            eventStart.plus(6, ChronoUnit.DAYS).withHour(16),
            eventStart.plus(6, ChronoUnit.DAYS).withHour(18))));

    eventStart = LocalDateTime.of(2017, 9, 1, 9, 0, 0);
    eventEnd = eventStart.plus(2, ChronoUnit.HOURS);
    periodStart = eventStart;
    periodEnd = periodStart.plus(6, ChronoUnit.DAYS);

    System.out.println("eventStart = " + eventStart);
    System.out.println("eventEnd = " + eventEnd);
    System.out.println("periodStart = " + periodStart);
    System.out.println("periodEnd = " + periodEnd);

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=WEEKLY;INTERVAL=1;BYDAY=SU,MO,TU,TH"), periodStart, periodEnd);
    periods.forEach(System.out::println);
    Assert.assertEquals(5, periods.size());

    eventStart = LocalDateTime.of(2017, 9, 1, 9, 0, 0);
    eventEnd = eventStart.plus(2, ChronoUnit.HOURS);
    periodStart = eventStart.minus(2, ChronoUnit.HOURS);
    periodEnd = periodStart.plus(1, ChronoUnit.WEEKS);

    System.out.println("eventStart = " + eventStart);
    System.out.println("eventEnd = " + eventEnd);
    System.out.println("periodStart = " + periodStart);
    System.out.println("periodEnd = " + periodEnd);

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=WEEKLY;INTERVAL=1;BYDAY=SU,MO,TU,TH"), periodStart, periodEnd);
    periods.forEach(System.out::println);
    Assert.assertEquals(5, periods.size());
  }

  @Test
  public void testByTemporalUnit() throws Exception {
    LocalDateTime eventStart = LocalDateTime.of(2017, 1, 1, 7, 0, 0),
        eventEnd = eventStart.plus(1, ChronoUnit.MINUTES),
        periodStart = eventStart,
        periodEnd = periodStart.plus(50, ChronoUnit.YEARS);

    // BYYEARDAY
    Set<PeriodType> periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=YEARLY;INTERVAL=1;BYYEARDAY=20"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    testEveryEventInSet(periods, periodEnd, new PeriodType(eventStart.withDayOfYear(20), eventEnd.withDayOfYear(20)), 1, ChronoUnit.YEARS);

    // BYYEARDAY (negative)
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=YEARLY;INTERVAL=1;BYYEARDAY=-5"), periodStart.minus(10, ChronoUnit.DAYS), periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    // the fifth last day of the year is always the 26 of December.
    testEveryEventInSet(periods, periodEnd, new PeriodType(eventStart.withMonth(12).withDayOfMonth(26), eventEnd.withMonth(12).withDayOfMonth(26)), 1, ChronoUnit.YEARS);

    // BYWEEKNO
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=YEARLY;INTERVAL=1;BYWEEKNO=2,4"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    // There should be two events in each year plus the original event since it happened on week 1.
    Assert.assertEquals(101, periods.size());
    // All periods should happen in January
    Assert.assertTrue(periods.stream().allMatch(period -> period.getStart().getMonth().equals(Month.JANUARY)));

    //BYWEEKNO (negative)
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=YEARLY;INTERVAL=1;BYWEEKNO=-2,-4"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    // There should be two events in each year plus the original event since it happened on week 1.
    Assert.assertEquals(101, periods.size());
    periods.remove(new PeriodType(eventStart, eventEnd));
    // All periods should happen in January (having removed the original January event)
    Assert.assertTrue(periods.stream().allMatch(period -> period.getStart().getMonth().equals(Month.DECEMBER)));

    // BYMONTH
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=YEARLY;INTERVAL=1;BYMONTH=2,4"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    // There should be two events in each year plus the original event since it happened in January.
    Assert.assertEquals(101, periods.size());
    periods.remove(new PeriodType(eventStart, eventEnd));
    // All periods should happen in January or February
    Assert.assertTrue(periods.stream().allMatch(period -> period.getStart().getMonth().equals(Month.FEBRUARY) || period.getStart().getMonth().equals(Month.APRIL)));

    // BYMONTH (negative)
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=YEARLY;INTERVAL=1;BYMONTH=-2,-4"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    // There should be two events in each year plus the original event since it happened in January.
    Assert.assertEquals(101, periods.size());
    periods.remove(new PeriodType(eventStart, eventEnd));
    // All periods should happen in January or February
    Assert.assertTrue(periods.stream().allMatch(period -> period.getStart().getMonth().equals(Month.OCTOBER) || period.getStart().getMonth().equals(Month.AUGUST)));

    // BYMONTHDAY
    periodEnd = periodStart.plus(2, ChronoUnit.YEARS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=MONTHLY;INTERVAL=1;BYMONTHDAY=2,4"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    // There should be two events in each month plus the original event.
    Assert.assertEquals(49, periods.size());
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> period.getStart().getDayOfMonth() == 2 || period.getStart().getDayOfMonth() == 4));

    // BYMONTHDAY (negative)
    periodEnd = periodStart.plus(2, ChronoUnit.YEARS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=MONTHLY;INTERVAL=1;BYMONTHDAY=-2"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    Assert.assertEquals(25, periods.size());
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(26, 27, 28, 29).contains(period.getStart().getDayOfMonth())));

    // BYDAY
    periodEnd = periodStart.plus(2, ChronoUnit.YEARS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=WEEKLY;INTERVAL=1;BYDAY=MO,TU"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY).contains(period.getStart().getDayOfWeek())));

    // BYHOUR
    periodEnd = periodStart.plus(2, ChronoUnit.MONTHS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=DAILY;INTERVAL=1;BYHOUR=14,16"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(14, 16).contains(period.getStart().getHour())));

    // BYHOUR (negative)
    periodEnd = periodStart.plus(2, ChronoUnit.MONTHS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=DAILY;INTERVAL=1;BYHOUR=-10,-8"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(14, 16).contains(period.getStart().getHour())));

    // BYMINUTE
    periodEnd = periodStart.plus(2, ChronoUnit.DAYS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=HOURLY;INTERVAL=1;BYMINUTE=10,30"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(10, 30).contains(period.getStart().getMinute())));

    // BYMINUTE (negative)
    periodEnd = periodStart.plus(2, ChronoUnit.DAYS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=HOURLY;INTERVAL=1;BYMINUTE=-50,-30"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(10, 30).contains(period.getStart().getMinute())));

    // BYSECOND
    periodEnd = periodStart.plus(2, ChronoUnit.HOURS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=MINUTELY;INTERVAL=1;BYSECOND=10,30"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(10, 30).contains(period.getStart().getSecond())));

    // BYSECOND (negative)
    periodEnd = periodStart.plus(2, ChronoUnit.HOURS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=MINUTELY;INTERVAL=1;BYSECOND=-50,-30"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(10, 30).contains(period.getStart().getSecond())));

    /**
     * A mixed BYxxx case from https://tools.ietf.org/html/rfc5545, page 44:
     *
     *     19970105T083000
     *     RRULE:FREQ=YEARLY;INTERVAL=2;BYMONTH=1;BYDAY=SU;BYHOUR=8,9;BYMINUTE=30
     */
    eventStart = LocalDateTime.of(1997, 1, 5, 8, 30, 0);
    eventEnd = eventStart.plus(1, ChronoUnit.MINUTES);
    periodStart = eventStart;
    periodEnd = periodStart.plus(50, ChronoUnit.YEARS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=YEARLY;INTERVAL=2;BYMONTH=1;BYDAY=SU;BYHOUR=8,9;BYMINUTE=30"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    Assert.assertEquals(50, periods.size()); // two events every two years
    periods.remove(new PeriodType(eventStart, eventEnd));
    // All periods should happen in January
    Assert.assertTrue(periods.stream().allMatch(period -> period.getStart().getMonth().equals(Month.JANUARY)));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(8, 9).contains(period.getStart().getHour())));
    Assert.assertTrue(periods.stream().allMatch(period -> period.getStart().getMinute() == 30));
  }
}
