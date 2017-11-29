/*
 * Copyright 2017 Key Bridge. All rights reserved.
 * Use is subject to license terms.
 *
 * Software Code is protected by Copyrights. Author hereby reserves all rights
 * in and to Copyrights and no license is granted under Copyrights in this
 * Software License Agreement.
 *
 * Key Bridge generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request from: info@keybridgewireless.com
 */
package ch.keybridge.icalendar;

import ietf.params.xml.ns.icalendar.PeriodType;
import ietf.params.xml.ns.icalendar.RecurType;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.time.temporal.WeekFields;
import java.util.*;
import javax.xml.bind.JAXBException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Key Bridge
 */
public class EventTest {

  public EventTest() {
  }

//  @Test
  public void testZones() throws JAXBException {

    System.out.println("  Zones ");
//    for (Map.Entry<String, String> entry : ZoneId.SHORT_IDS.entrySet()) {
//      String key = entry.getKey();
//      String value = entry.getValue();
//
//      System.out.println(key + " - " + value);
//
//    }

//    System.out.println("  ZoneId.getAvailableZoneIds");
//    for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
//      System.out.println("     " + availableZoneId);
//    }
    Event s = Event.getInstance(
      ZonedDateTime.now(),
      ZonedDateTime.now().plus(4, ChronoUnit.HOURS)
    );

    ZoneId zone = ZoneId.of("Canada/Pacific");
    System.out.println("  convert to zone " + zone);

    s.setZoneSameLocal(ZoneId.of("Canada/Pacific"));

    System.out.println("  s start " + s.getDateStart());
    System.out.println("  s end   " + s.getDateEnd());

  }

//  @Test
  public void testParse() {
    System.out.println("  Test date parser");

    DateTimeFormatter df = DateTimeFormatter.ISO_ZONED_DATE_TIME;

//    df = Constants.FORMATTER_RFC5545_DATE_TIME;
//    DateTimeFormatter.ISO_ZONED_DATE_TIME;
    ZonedDateTime znow = ZonedDateTime.now();
    System.out.println("  znow         " + znow);

    String znowString = znow.format(df);
    System.out.println("  znow string  " + znowString);

    ZonedDateTime znowRecover = ZonedDateTime.parse(znowString, df);
    System.out.println("  recover      " + znowRecover);

    LocalDateTime ldt = LocalDateTime.now();
    System.out.println("  ldt:      " + ldt);
    String ldtString = ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    System.out.println("  ldtstr    " + ldtString);
    LocalDateTime ldtRecover = LocalDateTime.parse(ldtString);
    System.out.println("  recover   " + ldtRecover);

  }

//  @Test
  public void testFormat() {
    System.out.println("  Test date formatter");
    DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy KK:mm a", Locale.ENGLISH);
    DateTimeFormatter zonedDateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy KK:mm z", Locale.ENGLISH);

    LocalDateTime now = LocalDateTime.now();
    System.out.println("  NOW: " + now);
    System.out.println("  NOW: " + now.format(localDateTimeFormatter));

    ZoneId zone = ZoneId.of("UTC");

    ZonedDateTime Znow = ZonedDateTime.of(now, zone);

//    System.out.println("  Znow: " + Znow);
    System.out.println("  Znow: " + Znow.format(zonedDateTimeFormatter));

    ZonedDateTime utc = ZonedDateTime.now(zone);
    System.out.println("  Znow " + utc);
    System.out.println("  UTC " + utc.format(zonedDateTimeFormatter));

    LocalDateTime utcLocal = utc.toLocalDateTime();
//        System.out.println("  Znow local " + utcLocal);
    System.out.println("  UTC local " + utcLocal.format(localDateTimeFormatter));

    ZoneOffset z = ZoneOffset.of("Z");
    System.out.println("  Z: " + z);

    OffsetDateTime local = utcLocal.atOffset(z);
    System.out.println("  local " + local.toLocalDateTime());

    Clock clock = Clock.systemUTC();
    Instant instant = clock.instant();
    LocalDateTime localDT = LocalDateTime.now(clock);
    zone = clock.getZone();
    System.out.println("  clock   " + clock);
    System.out.println("  localdt " + localDT);
    System.out.println("  instant " + instant);
    System.out.println("  zone    " + zone);

  }

  @Test
  public void testDuration() {
    Event s = Event.getInstance(ZonedDateTime.now(), ChronoUnit.HOURS, 48);
    System.out.println("Test Duration");
    System.out.println("  Event s: " + s);
    System.out.println("    start : " + s.getDateStart());
    System.out.println("    end   : " + s.getDateEnd());
  }

  @Test
  public void testSort() throws Exception {
    Event scheduleMain = Event.getInstance(ZonedDateTime.of(LocalDateTime.of(2017, 1, 12, 12, 0, 0), ZoneId.systemDefault()), ChronoUnit.DAYS, 2);
    System.out.println("  Event MAIN   : " + scheduleMain);

    /**
     * A four hour schedule on Jan 06.
     */
    Event srecur = Event.getInstance(LocalDateTime.of(2017, 1, 06, 10, 0, 0), ChronoUnit.HOURS, 4);
    srecur.setRecurType(new RecurType("FREQ=WEEKLY;INTERVAL=1;BYDAY=TH,FR,SA"));
//    System.out.println("  Event sRecur : " + srecur);

    /**
     *
     */
//    for (Event srr : srecur.calculatePeriodList(srecur.getDateStart(),
//                                             scheduleMain.getDateEnd())) {
//      System.out.println("     period: " + srr);
//      schedules.add(srr);
//    }
//    for (Event schedule : srecur.calculatePeriodList(scheduleMain.getDateStart(), scheduleMain.getDateEnd())) {      System.out.println("    period intercept " + schedule);    }
    Collection<Event> schedules = new TreeSet<>();
    schedules.add(srecur);
    schedules.add(Event.getInstance(LocalDateTime.of(2017, 1, 03, 6, 0, 0), ChronoUnit.DAYS, 2));
    schedules.add(Event.getInstance(LocalDateTime.of(2017, 1, 04, 6, 0, 0), ChronoUnit.DAYS, 2));
//    schedules.add(Event.getInstance(new Date(2017, 1, 01, 6, 0, 0), Calendar.DAY_OF_YEAR, 2));
//    schedules.add(Event.getInstance(new Date(2017, 1, 01, 6, 0, 0), Calendar.DAY_OF_YEAR, 3));
//    schedules.add(Event.getInstance(new Date(2017, 1, 02, 6, 0, 0), Calendar.DAY_OF_YEAR, 1));

    for (Event schedule : schedules) {
      System.out.println("    sorted " + schedule);

//      System.out.println("    test intersect  " + scheduleMain.intersects(schedule) + " : " + schedule + " with " + scheduleMain);
    }
//    for (Event schedule : schedules) {      System.out.println("  Contains   " + scheduleMain + " with " + schedule + " ? " + scheduleMain.contains(schedule));    }
//    for (Event schedule : schedules) {
//      System.out.println("  \nDifference \n  " + scheduleMain + " with \n  " + schedule + " ? \n  " + scheduleMain.difference(schedule));
//    }

//    Event x = scheduleMain.copy();
//    System.out.println("  Multi " + x);
//    for (Event schedule : schedules) {
////      System.out.println("     " + x);
////      x = x.difference(schedule);
////      Event diff = schedule.difference(x);
//      Event diff = x.difference(schedule);
//      System.out.println("    " + schedule + " diff \n  " + x + " produces \n  " + diff + "\n");
//      x = diff;
//    }
//
//    System.out.println("  X Final " + x);
//
//    System.out.println("  Events\n" + schedules);
//
//    Event s = Event.getInstance(LocalDateTime.now(), ChronoUnit.HOURS, 48);
//    System.out.println("  Test Duration");
//    System.out.println("  Event s: " + s);
//    System.out.println("    start : " + s.getDateStart());
//    System.out.println("    end   : " + s.getDateEnd());
  }

  @Test
  public void testPeriodSet() throws Exception {
    System.out.println("\nTest PeriodSet");
    Event srecur = Event.getInstance(LocalDateTime.of(2017, 1, 6, 10, 0, 0), ChronoUnit.HOURS, 4);
//    srecur.setRrule("FREQ=WEEKLY;INTERVAL=1;");
    srecur.setRrule("FREQ=DAILY;COUNT=10");
    System.out.println("  Event sRecur : " + srecur + " " + srecur.getRecurType());

    List<Event> periodSet = srecur.calculatePeriodList(ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault()),
                                                       ZonedDateTime.of(2017, 3, 31, 0, 0, 0, 0, ZoneId.systemDefault()));

    System.out.println("  PeriodSet ");
    for (Event schedule : periodSet) {
      System.out.println("     " + schedule);
    }
    /**
     * The RRULE COUNT=10 should produce exactly 10 entries.
     */
    Assert.assertEquals(10, periodSet.size());
  }

  @Test
  public void testIntersection() throws Exception {
    System.out.println("Test Intersection");
    Event scheduleMain = Event.getInstance(ZonedDateTime.of(LocalDateTime.of(2017, 1, 12, 12, 0, 0), ZoneId.systemDefault()), ChronoUnit.DAYS, 2);
    System.out.println("  Event MAIN   : " + scheduleMain);

    /**
     * A four hour schedule on Jan 06.
     */
    Event srecur = Event.getInstance(LocalDateTime.of(2017, 1, 06, 10, 0, 0), ChronoUnit.HOURS, 4);
    srecur.setRrule("FREQ=DAILY;INTERVAL=1;");
    System.out.println("  Event sRecur : " + srecur + " " + srecur.getRecurType());

    System.out.println("    Intersects ? " + scheduleMain.intersects(srecur) + " " + scheduleMain + " // " + srecur + " " + srecur.getRecurType());

  }

  @Test
  public void testIntersection2() {
    ZonedDateTime time1, time2;
    Event schedule1, schedule2;
    /**
     * Case: full overlap A: a-----------a B: b-----------b intersects: true
     * a.contains(b): true b.contains(a): true
     */
    time1 = ZonedDateTime.now();
    time2 = time1.plus(1, ChronoUnit.DAYS);
    schedule1 = Event.getInstance(time1, time2);
    schedule2 = Event.getInstance(time1, time2);
    Assert.assertTrue(Event.intersect(schedule1, schedule2));
    Assert.assertTrue(schedule1.intersects(schedule2));
    Assert.assertTrue(schedule2.intersects(schedule1));
    Assert.assertTrue(schedule1.contains(schedule2));
    Assert.assertTrue(schedule2.contains(schedule1));

    /**
     * Case: partial overlap A: a-----------a B: b-------b intersects: true
     * a.contains(b): true b.contains(a): false
     */
    time1 = ZonedDateTime.now();
    time2 = time1.plus(1, ChronoUnit.DAYS);
    schedule1 = Event.getInstance(time1, time2);
    schedule2 = Event.getInstance(time1.plus(1, ChronoUnit.HOURS), time2);
    Assert.assertTrue(Event.intersect(schedule1, schedule2));
    Assert.assertTrue(schedule1.intersects(schedule2));
    Assert.assertTrue(schedule2.intersects(schedule1));
    Assert.assertTrue(schedule1.contains(schedule2));
    Assert.assertFalse(schedule2.contains(schedule1));

    /**
     * Case: partial overlap A: a-----------a B: b-------b intersects: true
     * a.contains(b): true b.contains(a): false
     */
    time1 = ZonedDateTime.now();
    time2 = time1.plus(1, ChronoUnit.DAYS);
    schedule1 = Event.getInstance(time1, time2);
    schedule2 = Event.getInstance(time1, time2.minus(1, ChronoUnit.HOURS));
    Assert.assertTrue(Event.intersect(schedule1, schedule2));
    Assert.assertTrue(schedule1.intersects(schedule2));
    Assert.assertTrue(schedule2.intersects(schedule1));
    Assert.assertTrue(schedule1.contains(schedule2));
    Assert.assertFalse(schedule2.contains(schedule1));

    /**
     * Case: a contains b A: a-----------a B: b---b intersects: true
     * a.contains(b): true b.contains(a): false
     */
    time1 = ZonedDateTime.now();
    time2 = time1.plus(1, ChronoUnit.DAYS);
    schedule1 = Event.getInstance(time1, time2);
    schedule2 = Event.getInstance(time1.plus(1, ChronoUnit.HOURS), time2.minus(1, ChronoUnit.HOURS));
    Assert.assertTrue(Event.intersect(schedule1, schedule2));
    Assert.assertTrue(schedule1.intersects(schedule2));
    Assert.assertTrue(schedule2.intersects(schedule1));
    Assert.assertTrue(schedule1.contains(schedule2));
    Assert.assertFalse(schedule2.contains(schedule1));

    /**
     * Case: b contains a A: a----a B: b----------b intersects: true
     * a.contains(b): false b.contains(a): true
     */
    time1 = ZonedDateTime.now();
    time2 = time1.plus(1, ChronoUnit.DAYS);
    schedule1 = Event.getInstance(time1.plus(1, ChronoUnit.HOURS), time2.minus(1, ChronoUnit.HOURS));
    schedule2 = Event.getInstance(time1, time2);
    Assert.assertTrue(Event.intersect(schedule1, schedule2));
    Assert.assertTrue(schedule1.intersects(schedule2));
    Assert.assertTrue(schedule2.intersects(schedule1));
    Assert.assertFalse(schedule1.contains(schedule2));
    Assert.assertTrue(schedule2.contains(schedule1));

    /**
     * Case: partial overlap A: a-------a B: b-------b intersects: true
     * a.contains(b): true b.contains(a): false
     */
    time1 = ZonedDateTime.now();
    time2 = time1.plus(1, ChronoUnit.DAYS);
    schedule1 = Event.getInstance(time1, time2);
    schedule2 = Event.getInstance(time1.minus(1, ChronoUnit.HOURS), time2.minus(1, ChronoUnit.HOURS));
    Assert.assertTrue(Event.intersect(schedule1, schedule2));
    Assert.assertTrue(schedule1.intersects(schedule2));
    Assert.assertTrue(schedule2.intersects(schedule1));
    Assert.assertFalse(schedule1.contains(schedule2));
    Assert.assertFalse(schedule2.contains(schedule1));

    /**
     * Case: partial overlap A: a-------a B: b-------b intersects: true
     * a.contains(b): true b.contains(a): false
     */
    time1 = ZonedDateTime.now();
    time2 = time1.plus(1, ChronoUnit.DAYS);
    schedule1 = Event.getInstance(time1, time2);
    schedule2 = Event.getInstance(time1.plus(1, ChronoUnit.HOURS), time2.plus(1, ChronoUnit.HOURS));
    Assert.assertTrue(Event.intersect(schedule1, schedule2));
    Assert.assertTrue(schedule1.intersects(schedule2));
    Assert.assertTrue(schedule2.intersects(schedule1));
    Assert.assertFalse(schedule1.contains(schedule2));
    Assert.assertFalse(schedule2.contains(schedule1));

    /**
     * Case: no intersection A: a-----------a B: b-----------b intersects: false
     * a.contains(b): false b.contains(a): false
     */
    schedule2 = Event.getInstance(time1.plus(1, ChronoUnit.MILLENNIA), time2.plus(1, ChronoUnit.MILLENNIA));
    Assert.assertFalse(Event.intersect(schedule1, schedule2));
    Assert.assertFalse(schedule1.intersects(schedule2));
    Assert.assertFalse(schedule2.intersects(schedule1));
    Assert.assertFalse(schedule1.contains(schedule2));
    Assert.assertFalse(schedule2.contains(schedule1));

    /**
     * Case: no intersection A: a-----------a B: b-----------b intersects: false
     * a.contains(b): false b.contains(a): false
     */
    schedule2 = Event.getInstance(time1.minus(1, ChronoUnit.MILLENNIA), time2.minus(1, ChronoUnit.MILLENNIA));
    Assert.assertFalse(Event.intersect(schedule1, schedule2));
    Assert.assertFalse(schedule1.intersects(schedule2));
    Assert.assertFalse(schedule2.intersects(schedule1));
    Assert.assertFalse(schedule1.contains(schedule2));
    Assert.assertFalse(schedule2.contains(schedule1));
  }

  @Test
  public void testIntersectionConcept() throws Exception {
    System.out.println("EventTest intersection");

    ZonedDateTime start = ZonedDateTime.now().withHour(9).withMinute(0);
    Event s = Event.getInstance(start, ChronoUnit.DAYS, 3);
//    s.setRecur(new RecurType("FREQ=WEEKLY;INTERVAL=1;BYDAY=MO,TU,TH"));
    s.setRrule("FREQ=WEEKLY;INTERVAL=1;BYDAY=MO,TU,TH");

    System.out.println("  s: " + s);
    System.out.println("  s.expire " + s.getDateExpire());

    ZonedDateTime tstart = ZonedDateTime.now().withMinute(0).minus(1, ChronoUnit.DAYS);
    ZonedDateTime tend = ZonedDateTime.now().plus(1, ChronoUnit.DAYS);
//    end.add(Calendar.DAY_OF_YEAR, 1);
    Event t = Event.getInstance(tstart, tend);

    System.out.println("  t: " + t);

    System.out.println("  s contains t date : " + s.contains(tstart));
    Assert.assertFalse(s.contains(tstart));

    System.out.println("  s contains t : " + s.contains(t));
    Assert.assertFalse(s.contains(t));
    System.out.println("  t contains s : " + t.contains(s));

    System.out.println("  s intersects t date : " + s.intersects(tstart));
    Assert.assertFalse(s.intersects(tstart));

    System.out.println("  s intersects t : " + s.intersects(t));
//    Assert.assertTrue(s.intersects(t));

    System.out.println("  t intersects s : " + t.intersects(s));
//    Assert.assertTrue(t.intersects(s));

  }

  @Test
  public void testDifference() throws Exception {
    System.out.println("EventTest difference");

//    Calendar sstart = Calendar.getInstance();    sstart.set(Calendar.HOUR_OF_DAY, 9);    sstart.set(Calendar.MINUTE, 0);
    Event s = Event.getInstance(ZonedDateTime.now().withHour(9).withMinute(0), ChronoUnit.HOURS, 3);
    s.setRrule("FREQ=WEEKLY;INTERVAL=1;BYDAY=SU,MO,TU,TH");

    System.out.println("s = " + s);
    System.out.println("s.getRecur() = " + s.getRecurType());
    System.out.println("s.getDateStart() = " + s.getDateStart());
    System.out.println("s.getDateEnd() = " + s.getDateEnd());
    System.out.println("  s.expire " + s.getDateExpire());

    ZonedDateTime tstart = ZonedDateTime.now().withHour(9).withMinute(0).withDayOfYear(14);
//    tstart.set(Calendar.HOUR_OF_DAY, 9);
//    tstart.set(Calendar.MINUTE, 0);
//    tstart.add(Calendar.DAY_OF_YEAR, 14);

    Event t = Event.getInstance(tstart, ChronoUnit.HOURS, 48);
    t.setAllDayEvent(true);

    System.out.println("  \nt: " + t);

    System.out.println("  s contains t date : " + s.contains(tstart));
    System.out.println("  s contains t : " + s.contains(t));
    System.out.println("  t contains s : " + t.contains(s));

    System.out.println("  s intersects t date : " + s.intersects(tstart));
    System.out.println("  s intersects t : " + s.intersects(t));
    System.out.println("  t intersects s : " + t.intersects(s));

    System.out.println("  s difference t : " + s.difference(t));

    try {
      System.out.println("  t difference s : " + t.difference(s));
    } catch (Exception exception) {
      System.out.println("  t difference s expected failure:" + exception.getMessage());
    }
    /**
     * <pre>
     *      June 2017
     * Su Mo Tu We Th Fr Sa
     *              1  2  3
     *  4  5  6  7  8  9 10
     * 11 12 13 14 15 16 17
     * 18 19 20 21 22 23 24
     * 25 26 27 28 29 30
     * </pre>
     */
  }

  @Test
  public void testPeriodList() throws Exception {
    Event s = Event.getInstance(
      LocalDateTime.of(2017, 9, 1, 9, 0, 0),
      ChronoUnit.HOURS, 2);

    System.out.println("s = " + s);

    s.setRrule("FREQ=DAILY;INTERVAL=1");
    System.out.println("s.getDateExpire() = " + s.getDateExpire());
    Assert.assertFalse(s.calculatePeriodList(s.getDateStart(), s.getDateExpire()).isEmpty());

    s.setRrule("FREQ=WEEKLY;INTERVAL=1");
    Assert.assertFalse(s.calculatePeriodList(s.getDateStart(), s.getDateExpire()).isEmpty());

    s.setRrule("FREQ=MONTHLY;INTERVAL=1");
    Assert.assertFalse(s.calculatePeriodList(s.getDateStart(), s.getDateExpire()).isEmpty());

    s.setRrule("FREQ=WEEKLY;BYDAY=FR");
    Assert.assertFalse(s.calculatePeriodList(s.getDateStart(), s.getDateExpire()).isEmpty());

    s.setRrule("FREQ=WEEKLY;INTERVAL=1;BYDAY=SU,MO,TU,TH");
    Assert.assertFalse(s.calculatePeriodList(s.getDateStart(), s.getDateExpire()).isEmpty());
  }

  @Test
  public void testRec() throws Exception {
    final ZoneId timeZone = ZoneId.of("UTC-4");

    LocalDateTime dateStart = LocalDateTime.of(2017, 9, 20, 15, 0, 0);
    System.out.println("dateStart = " + dateStart);

    final Event schedule = Event.getInstance(ZonedDateTime.of(dateStart, timeZone), ChronoUnit.HOURS, 2);
    schedule.setRrule("FREQ=DAILY;UNTIL=20170925;INTERVAL=1");

    System.out.println(schedule.getFormattedDescription());
    schedule.calculatePeriodList(schedule.getDateStart(), schedule.getDateExpire()).forEach(System.out::println);

    Event test = Event.getInstance(
      ZonedDateTime.of(LocalDateTime.of(2017, 9, 21, 15, 0, 0), timeZone),
      ChronoUnit.HOURS, 2);

    System.out.println("test = " + test);

    Assert.assertTrue(schedule.intersects(Event.getInstance(
      ZonedDateTime.of(LocalDateTime.of(2017, 9, 21, 14, 0, 0), timeZone),
      ChronoUnit.HOURS, 2)));
    Assert.assertTrue(schedule.intersects(Event.getInstance(
      ZonedDateTime.of(LocalDateTime.of(2017, 9, 21, 14, 0, 0), timeZone),
      ChronoUnit.HOURS, 1)));
    Assert.assertFalse(schedule.intersects(Event.getInstance(
      ZonedDateTime.of(LocalDateTime.of(2017, 9, 21, 14, 0, 0), timeZone),
      ChronoUnit.MINUTES, 59)));
    Assert.assertTrue(schedule.intersects(Event.getInstance(
      ZonedDateTime.of(LocalDateTime.of(2017, 9, 21, 15, 0, 0), timeZone),
      ChronoUnit.HOURS, 2)));
    Assert.assertTrue(schedule.intersects(Event.getInstance(
      ZonedDateTime.of(LocalDateTime.of(2017, 9, 21, 16, 0, 0), timeZone),
      ChronoUnit.HOURS, 2)));

    // Event starting 1 minute after the recurring events should not intersect
    test = Event.getInstance(
      ZonedDateTime.of(LocalDateTime.of(2017, 9, 21, 17, 1, 0), ZoneId.of("UTC")),
      ChronoUnit.MINUTES, 30);
    Assert.assertFalse(schedule.intersects(test));
  }

  @Test
  public void toLocalDateTest() {
    ZonedDateTime time1 = ZonedDateTime.of(2017, 9, 1, 12, 0, 0, 0, ZoneId.of("UTC-5"));
    ZonedDateTime time2 = ZonedDateTime.of(2017, 9, 1, 12, 0, 0, 0, ZoneId.of("UTC+1"));
    System.out.println(time1);
    System.out.println(time1.toLocalDateTime());
    System.out.println(time2);
    System.out.println(time2.toLocalDateTime());
  }

  @Test
  public void testPeriodListX() throws Exception {
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

    // BYDAY
    periodEnd = periodStart.plus(2, ChronoUnit.YEARS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=MONTHLY;INTERVAL=1;BYDAY=1MO,2TU"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().allMatch(period -> Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY).contains(period.getStart().getDayOfWeek())));
    Assert.assertTrue(periods.stream().map(PeriodType::getStart).allMatch(date -> date.get(WeekFields.of(DayOfWeek.SUNDAY, 4).weekOfMonth()) <= 3));

    // BYDAY
    periodEnd = periodStart.plus(2, ChronoUnit.YEARS);
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=MONTHLY;INTERVAL=1;BYDAY=-1FR"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    periods.remove(new PeriodType(eventStart, eventEnd));
    Assert.assertTrue(periods.stream().map(PeriodType::getStart).allMatch(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY));

    // Developer note: the last Friday that falls on 2018-02-23T07:00 is on the third week of the month, hence the 3.
    // Most often though, it's wither the 4th or the 5th week
//    periods.stream().map(PeriodType::getStart)
//        .filter(d -> d.get(WeekFields.of(DayOfWeek.SUNDAY, 4).weekOfMonth()) == 3)
//        .forEach(System.out::println);
    Assert.assertTrue(periods.stream().map(PeriodType::getStart).allMatch(date -> date.get(WeekFields.of(DayOfWeek.SUNDAY, 4).weekOfMonth()) >= 3));

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
     * <p>
     * 19970105T083000
     * RRULE:FREQ=YEARLY;INTERVAL=2;BYMONTH=1;BYDAY=SU;BYHOUR=8,9;BYMINUTE=30
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

  @Test
  public void testLimitByTemporalUnit() throws Exception {
    LocalDateTime eventStart = LocalDateTime.of(2017, 1, 1, 7, 0, 0),
      eventEnd = eventStart.plus(1, ChronoUnit.SECONDS),
      periodStart = eventStart,
      periodEnd = periodStart.plus(2, ChronoUnit.MINUTES);
    final Duration duration = Duration.ofSeconds(1);
    PeriodType originalEvent = new PeriodType(eventStart, duration);
    Set<PeriodType> periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=SECONDLY;INTERVAL=2;BYSECOND=1,2,3,4"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    Assert.assertEquals(5, periods.size());
    Assert.assertTrue(periods.contains(originalEvent));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(2), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(4), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(2).plusMinutes(1), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(4).plusMinutes(1), duration)));

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=SECONDLY;INTERVAL=2;BYSECOND=1,3"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    Assert.assertEquals(1, periods.size());
    Assert.assertTrue(periods.contains(originalEvent));

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=SECONDLY;INTERVAL=2;BYSECOND=-2,-4"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    Assert.assertEquals(5, periods.size());
    Assert.assertTrue(periods.contains(originalEvent));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(56), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(58), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(56).plusMinutes(1), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(58).plusMinutes(1), duration)));

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=SECONDLY;INTERVAL=1;BYMINUTE=1"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    Assert.assertEquals(61, periods.size());
    Assert.assertTrue(periods.contains(originalEvent));

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=SECONDLY;INTERVAL=2;BYSECOND=-2,-4;BYMINUTE=1"), periodStart, periodEnd);
//    periods.forEach(System.out::println);
    Assert.assertEquals(3, periods.size());
    Assert.assertTrue(periods.contains(originalEvent));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(56).plusMinutes(1), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusSeconds(58).plusMinutes(1), duration)));

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=MINUTELY;INTERVAL=2;BYMINUTE=2,-4"),
                                           eventStart, eventStart.plus(2, ChronoUnit.HOURS));
//    periods.forEach(System.out::println);
    Assert.assertEquals(5, periods.size());
    Assert.assertTrue(periods.contains(originalEvent));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusMinutes(2), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusMinutes(56), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusMinutes(2).plusHours(1), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.plusMinutes(56).plusHours(1), duration)));

    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd, new RecurType("FREQ=HOURLY;INTERVAL=1;BYHOUR=12,-3"),
                                           eventStart, eventStart.plus(1, ChronoUnit.DAYS));
//    periods.forEach(System.out::println);
    Assert.assertEquals(3, periods.size());
    Assert.assertTrue(periods.contains(originalEvent));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.withHour(12), duration)));
    Assert.assertTrue(periods.contains(new PeriodType(eventStart.withHour(21), duration)));

    eventStart = eventStart.withMonth(9);
    periods = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                           new RecurType("FREQ=SECONDLY;INTERVAL=1;BYSECOND=5,7;BYMINUTE=10,-10;BYHOUR=-4,16;BYDAY=MO;BYMONTHDAY=9,16;BYMONTH=9,10"),
                                           eventStart, eventStart.plus(2, ChronoUnit.MONTHS));
//    periods.forEach(System.out::println);
    Assert.assertEquals(17, periods.size());
    originalEvent = new PeriodType(eventStart, duration);
    PeriodType periodType = new PeriodType(LocalDateTime.of(2017, 10, 9, 16, 10, 5), duration);
    Assert.assertTrue(periods.contains(periodType));
    periods.remove(originalEvent);
    Assert.assertTrue(periods.stream().map(PeriodType::getStart).allMatch(d -> d.getSecond() == 5 || d.getSecond() == 7));
    Assert.assertTrue(periods.stream().map(PeriodType::getStart).allMatch(d -> d.getMinute() == 10 || d.getMinute() == 50));
    Assert.assertTrue(periods.stream().map(PeriodType::getStart).allMatch(d -> d.getHour() == 16 || d.getHour() == 20));
    Assert.assertTrue(periods.stream().map(PeriodType::getStart).allMatch(d -> d.getDayOfMonth() == 16 || d.getDayOfMonth() == 9));
    Assert.assertTrue(periods.stream().map(PeriodType::getStart).allMatch(d -> d.getMonthValue() == 9 || d.getMonthValue() == 10));

    Set<PeriodType> periods2 = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                                            new RecurType("FREQ=MINUTELY;INTERVAL=1;BYSECOND=5,7;BYMINUTE=10,-10;BYHOUR=-4,16;BYDAY=MO;BYMONTHDAY=9,16;BYMONTH=9,10"),
                                                            eventStart, eventStart.plus(2, ChronoUnit.MONTHS));
//    periods.forEach(System.out::println);
    periods2.remove(originalEvent);
    Assert.assertTrue(periods.containsAll(periods2) && periods2.containsAll(periods));

    periods2 = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                            new RecurType("FREQ=HOURLY;INTERVAL=1;BYSECOND=5,7;BYMINUTE=10,-10;BYHOUR=-4,16;BYDAY=MO;BYMONTHDAY=9,16;BYMONTH=9,10"),
                                            eventStart, eventStart.plus(2, ChronoUnit.MONTHS));
//    periods.forEach(System.out::println);
    periods2.remove(originalEvent);
    Assert.assertTrue(periods.containsAll(periods2) && periods2.containsAll(periods));

    periods2 = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                            new RecurType("FREQ=DAILY;INTERVAL=1;BYSECOND=5,7;BYMINUTE=10,-10;BYHOUR=-4,16;BYDAY=MO;BYMONTHDAY=9,16;BYMONTH=9,10"),
                                            eventStart, eventStart.plus(2, ChronoUnit.MONTHS));
//    periods.forEach(System.out::println);
    periods2.remove(originalEvent);
    Assert.assertTrue(periods.containsAll(periods2) && periods2.containsAll(periods));

    eventStart = eventStart.withMonth(1);
    /**
     * The DAILY frequency should be limited by the BYMONTH rule
     */
    periods = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                           new RecurType("FREQ=DAILY;INTERVAL=1;BYMONTH=1,3,5"),
                                           eventStart, eventStart.with(TemporalAdjusters.lastDayOfYear()));
//    periods.forEach(System.out::println);
    Assert.assertEquals(3 * 31, periods.size());
  }

  @Test
  public void testLimitRuleExceptions() throws Exception {
    final LocalDateTime eventStart = LocalDateTime.of(2017, 1, 1, 7, 0, 0);
    final Duration duration = Duration.ofSeconds(1);

    /**
     * The DAILY frequency should not be affected by the BYYEARDAY rule
     */
    Set<PeriodType> periods = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                                           new RecurType("FREQ=DAILY;INTERVAL=1;BYYEARDAY=1,2,3,4,5"),
                                                           eventStart, eventStart.with(TemporalAdjusters.lastDayOfYear()));
//    periods.forEach(System.out::println);
    Assert.assertEquals(Year.from(eventStart).length(), periods.size());
    /**
     * The DAILY frequency should not be affected by the BYWEEKNO rule
     */
    periods = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                           new RecurType("FREQ=DAILY;INTERVAL=1;BYWEEKNO=1,2,3,4,5"),
                                           eventStart, eventStart.with(TemporalAdjusters.lastDayOfYear()));
//    periods.forEach(System.out::println);
    Assert.assertEquals(Year.from(eventStart).length(), periods.size());
    /**
     * The WEEKLY frequency should not be affected by the BYMONTH rule
     */
    periods = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                           new RecurType("FREQ=WEEKLY;INTERVAL=1;BYMONTHDAY=1,3,5"),
                                           eventStart, eventStart.with(TemporalAdjusters.lastDayOfYear()));
//    periods.forEach(System.out::println);
    Assert.assertEquals(53, periods.size());
    /**
     * The WEEKLY frequency should not be affected by the BYYEARDAY rule
     */
    periods = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                           new RecurType("FREQ=WEEKLY;INTERVAL=1;BYYEARDAY=1,3,5"),
                                           eventStart, eventStart.with(TemporalAdjusters.lastDayOfYear()));
//    periods.forEach(System.out::println);
    Assert.assertEquals(53, periods.size());
    /**
     * The WEEKLY frequency should not be affected by the BYWEEKNO rule
     */
    periods = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                           new RecurType("FREQ=WEEKLY;INTERVAL=1;BYWEEKNO=1,3,5"),
                                           eventStart, eventStart.with(TemporalAdjusters.lastDayOfYear()));
//    periods.forEach(System.out::println);
    Assert.assertEquals(53, periods.size());
    /**
     * The MONTHLY frequency should not be affected by the BYWEEKNO rule
     */
    periods = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                           new RecurType("FREQ=MONTHLY;INTERVAL=1;BYWEEKNO=1,3,5"),
                                           eventStart, eventStart.with(TemporalAdjusters.lastDayOfYear()));
//    periods.forEach(System.out::println);
    Assert.assertEquals(12, periods.size());
    /**
     * The MONTHLY frequency should not be affected by the BYYEARDAY rule
     */
    periods = ICalendar.calculatePeriodSet(eventStart, eventStart.plus(duration),
                                           new RecurType("FREQ=MONTHLY;INTERVAL=1;BYYEARDAY=1,3,5"),
                                           eventStart, eventStart.with(TemporalAdjusters.lastDayOfYear()));
//    periods.forEach(System.out::println);
    Assert.assertEquals(12, periods.size());
  }

//  @Test
  public void testRuleEquivalence() throws Exception {
    LocalDateTime eventStart = LocalDateTime.of(2017, 1, 1, 7, 0, 0),
      eventEnd = eventStart.plus(1, ChronoUnit.SECONDS),
      periodStart = eventStart,
      periodEnd = periodStart.plus(2, ChronoUnit.MINUTES);
    final Duration duration = Duration.ofSeconds(1);
    final PeriodType originalEvent = new PeriodType(eventStart, duration);
    Set<PeriodType> periods = ICalendar.calculatePeriodSet(eventStart, eventEnd,
                                                           new RecurType("FREQ=SECONDLY;INTERVAL=1;BYSECOND=5,7"),
                                                           periodStart, periodStart.plus(2, ChronoUnit.DAYS));
//    periods.forEach(System.out::println);
    System.out.println(periods.size());
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd,
                                           new RecurType("FREQ=MINUTELY;INTERVAL=1;BYSECOND=5,7"),
                                           periodStart, periodStart.plus(2, ChronoUnit.DAYS));
    System.out.println(periods.size());
    periods = ICalendar.calculatePeriodSet(eventStart, eventEnd,
                                           new RecurType("FREQ=HOURLY;INTERVAL=1;BYSECOND=5,7"),
                                           periodStart, periodStart.plus(2, ChronoUnit.DAYS));
    System.out.println(periods.size());
  }

}
