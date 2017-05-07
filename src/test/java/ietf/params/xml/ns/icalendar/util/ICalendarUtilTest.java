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
package ietf.params.xml.ns.icalendar.util;

import ietf.params.xml.ns.icalendar.PeriodType;
import ietf.params.xml.ns.icalendar.RecurType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import org.junit.Test;

/**
 *
 * @author Key Bridge
 */
public class ICalendarUtilTest {

  public ICalendarUtilTest() {
  }

  @Test
  public void testPeriodList() throws Exception {
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

    System.out.println(" recur " + recur.toStringFull());
    Set<PeriodType> recurSet = ICalendarUtil.calculateRecurrenceSet(dtstart.getTime(),
                                                                    dtend.getTime(),
                                                                    recur,
                                                                    periodStart.getTime(),
                                                                    periodEnd.getTime());
    System.out.println("RecurSet");
    int i = 0;
    for (PeriodType periodType : recurSet) {
      System.out.println(i++ + "   " + periodType);
    }

  }

}
