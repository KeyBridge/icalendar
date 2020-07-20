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
package ch.keybridge.icalendar;

import ietf.params.xml.ns.icalendar.PeriodType;
import ietf.params.xml.ns.icalendar.RecurType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Key Bridge
 */
public class ICalendarTest {

  @Test
  public void testPeriodListX() throws Exception {
    System.out.println("TestPeriodList");

    TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");

    DateFormat sdf = new SimpleDateFormat("EEEE MMMM dd HH:mm z yyyy Z", Locale.ENGLISH);
    sdf.setTimeZone(TIMEZONE_UTC);

    Calendar dtstart = Calendar.getInstance(TIMEZONE_UTC);
    dtstart.set(2014, 1, 29, 0, 0, 0);
    Calendar dtend = Calendar.getInstance(TIMEZONE_UTC);
    dtend.add(Calendar.MONTH, 3);
    dtend.set(2015, 12, 29, 0, 0, 0);

    System.out.println("dtstart      " + sdf.format(dtstart.getTime()));
    System.out.println("dtend        " + sdf.format(dtend.getTime()));

//    Schedule s = new Schedule(start, end, null, timeZoneEst, null);
//    s.setRecur(new Recur("FREQ=DAILY;INTERVAL=2"));
    Calendar periodStart = Calendar.getInstance(TIMEZONE_UTC);
    periodStart.set(2014, 5, 29, 0, 0, 0);
    Calendar periodEnd = Calendar.getInstance(TIMEZONE_UTC);
    periodEnd.set(2014, 7, 2, 0, 0, 0);
//    Date periodEnd = new Date(2014, 7, 10);
    System.out.println("period start " + sdf.format(periodStart.getTime()));
    System.out.println("period End   " + sdf.format(periodEnd.getTime()));
//    List<Schedule> list = s.getPeriodList(periodStart, periodEnd);
//    for (Schedule schedule : list) {
//      System.out.println("  period " + schedule);
//    }

//    RecurType recur = new RecurType("FREQ=DAILY;INTERVAL=2;UNTIL=20140725T000000Z");
//    RecurType recur = new RecurType("FREQ=WEEKLY;UNTIL=20140730T000000Z;WKST=SU;BYDAY=TU,WE,TH,SA");
//    RecurType recur = new RecurType("FREQ=WEEKLY;COUNT=15;INTERVAL=2;WKST=SU;BYDAY=TU,WE,TH");
//    RecurType recur = new RecurType("FREQ=DAILY;INTERVAL=1;COUNT=5");
//    RecurType recur = new RecurType("FREQ=WEEKLY;INTERVAL=2;BYDAY=MO,FR;BYHOUR=11,18");
    RecurType recur = new RecurType("FREQ=WEEKLY;COUNT=20;BYDAY=MO,FR;BYHOUR=11,18;BYSETPOS=-1");

    System.out.println(" recur " + recur);
    System.out.println(" recur " + recur.toStringFull());
//    Set<PeriodType> recurSet = ICalendar.calculateRecurrenceSet(dtstart.getTime(),
//                                                                    dtend.getTime(),
//                                                                    recur,
//                                                                    periodStart.getTime(),
//                                                                    periodEnd.getTime());
    System.out.println("RecurSet");
    int i = 0;
//    for (PeriodType periodType : recurSet) {
//      System.out.println(i++ + "   " + periodType);
//    }

  }

  @Test
  public void testPeriodList() throws Exception {
    System.out.println("TestPeriodList");

    DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy KK:mm a");

    ZonedDateTime eventStart = LocalDateTime.of(2014, 1, 5, 0, 0, 0).atZone(ZoneId.systemDefault());
    ZonedDateTime eventEnd = LocalDateTime.of(2014, 1, 6, 0, 0, 0).atZone(ZoneId.systemDefault());

    System.out.println("  event Start      " + eventStart.format(format));
    System.out.println("  event End        " + eventEnd.format(format));

//    RecurType recur = new RecurType("FREQ=DAILY;INTERVAL=2;UNTIL=20140725T000000Z");
//    RecurType recur = new RecurType("FREQ=WEEKLY;UNTIL=20140730T000000Z;WKST=SU;BYDAY=TU,WE,TH,SA");
//    RecurType recur = new RecurType("FREQ=WEEKLY;COUNT=15;INTERVAL=2;WKST=SU;BYDAY=TU,WE,TH");
//    RecurType recur = new RecurType("FREQ=DAILY;INTERVAL=1;COUNT=5");
    RecurType recur = new RecurType("FREQ=WEEKLY;INTERVAL=2;BYDAY=MO,FR;BYHOUR=11,18");
//    RecurType recur = new RecurType("FREQ=WEEKLY;COUNT=20;BYDAY=MO,FR;BYHOUR=11,18;BYSETPOS=-1");
    System.out.println("  event Recur      " + recur);

    System.out.println(recur.getFreq());
    System.out.println(recur.getInterval());

    ZonedDateTime periodStart = LocalDateTime.of(2014, 1, 1, 0, 0, 0).atZone(ZoneId.systemDefault());
    ZonedDateTime periodEnd = LocalDateTime.of(2014, 2, 28, 0, 0, 0).atZone(ZoneId.systemDefault());
    System.out.println("  period start     " + periodStart.format(format));
    System.out.println("  period End       " + periodEnd.format(format));
//    List<Schedule> list = s.getPeriodList(periodStart, periodEnd);
//    for (Schedule schedule : list) {
//      System.out.println("  period " + schedule);
//    }

    Set<PeriodType> periodSet = ICalendar.calculatePeriodSet(eventStart,
                                                             eventEnd,
                                                             recur,
                                                             periodStart,
                                                             periodEnd);
    System.out.println("  PeriodSet");
    int i = 0;
    for (PeriodType periodType : periodSet) {
      System.out.println("    " + i++
        + " " + Duration.between(periodType.getStart(), periodType.getEnd())
        + "   " + periodType.getStart().format(format)
        + "   " + periodType.getEnd().format(format)
      );
    }

  }

  @Test
  public void testWeekly() throws Exception {
    System.out.println("TestWeekly");
    Set<ZonedDateTime> dateSet = new HashSet<>();
//    RecurType recurType = new RecurType("FREQ=WEEKLY;INTERVAL=2;UNTIL=20171025T000000Z");
//    RecurType recur = new RecurType("FREQ=WEEKLY;COUNT=15;INTERVAL=2;BYDAY=TU,WE,TH");
//    RecurType recur = new RecurType("FREQ=DAILY;INTERVAL=2;UNTIL=20170925T000000Z");
//    RecurType recur = new RecurType("FREQ=WEEKLY;UNTIL=20140730T000000Z;WKST=SU;BYDAY=TU,WE,TH,SA");
//    RecurType recur = new RecurType("FREQ=WEEKLY;COUNT=15;INTERVAL=2;WKST=SU;BYDAY=TU,WE,TH");
//    RecurType recur = new RecurType("FREQ=DAILY;INTERVAL=1;COUNT=5");
    RecurType recur = new RecurType("FREQ=WEEKLY;INTERVAL=2;BYDAY=MO,FR;BYHOUR=11,18");

    WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 4);

    Set<ZonedDateTime> daily = ICalendar.asSet(ZonedDateTime.now());

    System.out.println("  weekly size  " + daily.size());
    for (ZonedDateTime dateTime : daily) {
      System.out.println("   " + dateTime);
    }
    for (Integer integer : recur.getByweekno()) {
      System.out.println("  by week no " + integer);
    }

  }

  @Test
  public void testBuildCandidateList() throws Exception {
    System.out.println("TestBuildCandidateList");

    WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 4);

//    RecurType recur = new RecurType("FREQ=WEEKLY;COUNT=10");
//    RecurType recur = new RecurType("FREQ=DAILY;INTERVAL=2;UNTIL=20170925T000000Z");
    RecurType recur = new RecurType("FREQ=DAILY;INTERVAL=1;COUNT=5");

    System.out.println("  RecurType " + recur);

    ZonedDateTime periodStart = ZonedDateTime.now();

    Set<ZonedDateTime> candidates = ICalendar.expandByRecurrenceRule(recur, periodStart, weekFields);

    for (ZonedDateTime candidate : candidates) {
      System.out.println("  candidate  " + candidate);
    }
    /**
     * At least one candidate should always be returned.
     */
    Assert.assertTrue(candidates.size() > 0);
  }

}
