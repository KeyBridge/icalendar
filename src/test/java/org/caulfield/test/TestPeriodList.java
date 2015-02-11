/*
 * Copyright 2014 Jesse Caulfield <jesse@caulfield.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.keybridge.test;

import ietf.params.xml.ns.icalendar.PeriodType;
import ietf.params.xml.ns.icalendar.RecurType;
import ietf.params.xml.ns.icalendar.util.ICalendarUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Jesse Caulfield <jesse@caulfield.org>
 */
public class TestPeriodList {

  public static void main(String[] args) throws Exception {
    System.out.println("TestPeriodList");

    TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");

    DateFormat sdf = new SimpleDateFormat("EEEE MMMM dd HH:mm z yyyy Z", Locale.ENGLISH);
    sdf.setTimeZone(TIMEZONE_UTC);

    Calendar dtstart = Calendar.getInstance(TIMEZONE_UTC);
    Calendar dtend = Calendar.getInstance(TIMEZONE_UTC);
    dtend.add(Calendar.HOUR, 3);

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

    System.out.println("DEBUG recur " + recur.toStringFull());
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
