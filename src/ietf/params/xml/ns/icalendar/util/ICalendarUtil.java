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
package ietf.params.xml.ns.icalendar.util;

import ietf.params.xml.ns.icalendar.EWeekdayRecurType;
import ietf.params.xml.ns.icalendar.PeriodType;
import ietf.params.xml.ns.icalendar.RecurType;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

/**
 * A utility class to help interact and manipulate ICalendar classes and
 * instances.
 * <p>
 * Portions of code in this class are from the Recur.java class in the iCal4j
 * project (v2.0) and are &copy; 2004 Ben Fortuna
 * <p>
 * @author Jesse Caulfield <jesse@caulfield.org>
 */
public class ICalendarUtil {

  public static final java.util.TimeZone TIMEZONE_UTC = java.util.TimeZone.getTimeZone("UTC");
  private static final SimpleDateFormat sdf;

  /**
   * Populate the internal SimpleDateFormat.
   */
  static {
    sdf = new SimpleDateFormat();
    sdf.setTimeZone(TIMEZONE_UTC);
  }

  /**
   * Calculate a recurrence set during the specified period for an event
   * beginning and ending on the specified days and having the specified
   * recurrence rule.
   * <p>
   * The recurrence set is derived from a combination of the component start
   * date, recurrence rules and dates
   * <p>
   * Developer note: exception rules and dates are not supported.
   * <p>
   * Note that component transparency and anniversary-style dates do not affect
   * the resulting intersection.
   * <p>
   * @param dtStart     the (master) event start date and time
   * @param dtEnd       the (master) event end date and time
   * @param recurType   the (master) event recurrence type
   * @param periodStart the period of interest start date. This should be on a
   *                    SUNDAY at or before the first day of a month.
   * @param periodEnd   the period of interest end date. This should be on a
   *                    SATURDAY at or after the last day of the month.
   * @return a non-null TreeSet of calculated events occurring between the
   *         period start and end dates.
   * @throws DatatypeConfigurationException if a PeriodType fails to build
   */
  public static Set<PeriodType> calculateRecurrenceSet(Date dtStart, Date dtEnd, RecurType recurType, Date periodStart, Date periodEnd) throws DatatypeConfigurationException {
    /**
     * Calculation should account for: RDATE, RRULE, EXDATE, EXRULE. However,
     * this method only calculated RRULE.
     */
    /**
     * Initialize the period list. Use a HashSet to enforce uniqueness.
     */
    Set<PeriodType> periodSet = new HashSet<>();
    /**
     * Preserve the event duration.
     */
    Duration duration = duration(dtStart, dtEnd);
    /**
     * Copy the period start and end dates into calendar instances to facilitate
     * calculation.
     */
    Calendar pStart = Calendar.getInstance(TIMEZONE_UTC);
    /**
     * RFC 5545 Page 41: The BYWEEKNO rule corresponds to weeks according to
     * week numbering as defined in [ISO.8601.2004]. A week is defined as a
     * seven day period, starting on the day of the week defined to be the week
     * start (see WKST). Week number one of the calendar year is the first week
     * that contains at least four (4) days in that calendar year.
     */
    pStart.setTime(periodStart);
    pStart.setMinimalDaysInFirstWeek(4);

    Calendar pEnd = Calendar.getInstance(TIMEZONE_UTC);
    pEnd.setTime(periodEnd);
    /**
     * First: Back up (reverse) the period start by the recurrence frequency to
     * include any events that began before the period start but also end during
     * the period.
     */
    while (pStart.getTime().after(dtStart)) {
      pStart.add(Calendar.MILLISECOND, -(int) duration.getTimeInMillis(pStart));
    }
    /**
     * Second: Add the initial event if it falls within the (adjusted) period.
     */
    if (dtStart.after(periodStart) && dtStart.before(periodEnd)) {
      periodSet.add(new PeriodType(dtStart, duration));
    }
    /**
     * Third: Fast forward PSTART to the day of the EVENT start if the event
     * begins within the period.
     */
    while (pStart.getTime().before(dtStart)) {
      pStart.add(Calendar.MILLISECOND, (int) duration.getTimeInMillis(pStart));
    }
    /**
     * Finally: Scan through the period of interest in FREQ increments. For each
     * increment calculate a list of candidate occurrence dates. Analyze each
     * candidate to determine if it is a valid start-date by the rules of the
     * event.
     * <p>
     * Developer note: Recurrence Sets only require adjustment of the event
     * start date. Therefore only the start date for each period is calculated
     * and evaluated. If a candidate start date is deemed valid then the
     * duration is applied and a new Period is added to the list of PeriodTypes,
     * which are the set of recurring events within the period of inquiry.
     */
    while (pStart.before(pEnd)) {
      /**
       * Build a list of candidate DTSTART dates within the current FREQ period.
       */
      Set<Calendar> candidateSet = buildCandidateList(recurType, pStart, dtStart);
      /**
       * Scan through the set of candidate START dates, evaluating their
       * validity and adding only those that match the recurrence rule.
       */
      for (Calendar candidateDtStart : candidateSet) {
        if (recurType.isSetUntil() && recurType.getUntil().before(candidateDtStart)) {
          /**
           * INVALID: candidate is AFTER the UNTIL date.
           */
        } else if (recurType.isSetCount() && periodSet.size() >= recurType.getCount()) {
          /**
           * INVALID: COUNT value is exceeded.
           */
          System.err.println("   COUNT EXCEEDED " + sdf.format(candidateDtStart.getTime()));
        } else if (candidateDtStart.getTime().after(periodStart)
          && candidateDtStart.getTime().after(dtStart)
          && candidateDtStart.getTime().before(periodEnd)) {
          /**
           * VALID: CREATE and ADD and new PeriodType to the set.
           */
          PeriodType period = new PeriodType((GregorianCalendar) candidateDtStart, duration);
          period.setTime(dtStart);
          periodSet.add(period);
        } else {
          /**
           * INVALID: UNKNOWN error.
           */
          System.err.println("   ERR " + sdf.format(candidateDtStart.getTime()));
        }
      }
      /**
       * Important: Increment the pStart value by the FREQ interval.
       */
      increment(recurType, pStart);
    } // END while loop
    /**
     * Return a sorted version of the period set.
     */
    return new TreeSet<>(periodSet);
  }

  /**
   * Calculate a list of candidate DATE values by incrementing the DATESTART
   * value according to the RecurType rules.
   * <p>
   * The returned candidate values should then be filtered against an UNTIL or
   * COUNT rule or checked to see if they fall within the period of interest.
   * <p>
   * The returned list may be recombined with the original event duration to
   * create a list of single events. Note that is DATESTART value is NOT added
   * to the candidate list.
   * <p>
   * Developer note: the returned list contains DATE values only. The TIME
   * component should be ignored when recombining with a DTSTART value.
   * <p>
   * @param recurType the event recurrence. If null or invalid then a empty
   *                  HashSet is returned.
   * @param dtStart   the event DTSTART value
   * @return a non-null HashSet
   */
//  private static Set<Calendar> buildCandidateList(RecurType recurType, Date dateStart) {
  private static Set<Calendar> buildCandidateList(RecurType recurType, Calendar periodStart, Date dtStart) {
    /**
     * Initialize the set. Use a HashSet to enforce uniqueness.
     */
    Set<Calendar> dateSet = new HashSet<>();
    /**
     * Intercept invalid or incomplete RecurType entries.
     */
    if (recurType.getFreq() == null) {
      return dateSet;
    }
    /**
     * Calculate candidate (start) dates for the indicated period.
     */
    switch (recurType.getFreq()) {
      case SECONDLY: {
        //<editor-fold defaultstate="collapsed" desc="Apply the BYSECOND rule.">
        for (Integer integer : recurType.getBysecond()) {
          final Calendar cal = merge(periodStart, dtStart);
          cal.set(Calendar.SECOND, integer);
          dateSet.add(cal);
        }//</editor-fold>
      }
      break;
      case MINUTELY: {
        //<editor-fold defaultstate="collapsed" desc="Apply the BYMINUTE rule.">
        for (Integer integer : recurType.getByminute()) {
          final Calendar cal = merge(periodStart, dtStart);
          cal.set(Calendar.MINUTE, integer);
          dateSet.add(cal);
        }//</editor-fold>
      }
      break;
      case HOURLY: {
        //<editor-fold defaultstate="collapsed" desc="Apply the BYHOUR rule.">
        for (Integer integer : recurType.getByhour()) {
          final Calendar cal = merge(periodStart, dtStart);
          cal.set(Calendar.HOUR_OF_DAY, integer);
          dateSet.add(cal);
        }//</editor-fold>
      }
      break;
      case DAILY: {
        //<editor-fold defaultstate="collapsed" desc="Apply the DAILY rule">
        dateSet.add(merge(periodStart, dtStart));
        /**
         * The DAILY rule is very simple: just add the current day. Developer
         * note: DAILY recurrence should (preferably) have an UNTIL or COUNT,
         * which are handled in the WHILE loop wrapping this method. If UNTIL
         * and COUNT are not specified then the DAILY will return every day in
         * the period after the event start.
         */
//</editor-fold>
      }
      break;
      case WEEKLY: {
        //<editor-fold defaultstate="collapsed" desc="Apply the BYDAY rule.">
        for (EWeekdayRecurType weekday : recurType.getBydayEnum()) {
          final Calendar cal = merge(periodStart, dtStart);
          cal.set(Calendar.DAY_OF_WEEK, weekday.getCalendarValue());
          dateSet.add(cal);
        }//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Apply the BYWEEKNO rule.">
        for (Integer integer : recurType.getByweekno()) {
          final Calendar cal = merge(periodStart, dtStart);
          cal.roll(Calendar.WEEK_OF_YEAR, integer);
          dateSet.add(cal);
        }//</editor-fold>
      }
      break;
      case MONTHLY: {
        //<editor-fold defaultstate="collapsed" desc="Apply the BYMONTH rule.">
        for (Integer integer : recurType.getBymonth()) {
          final Calendar cal = merge(periodStart, dtStart);
          cal.set(Calendar.MONDAY, integer);
          dateSet.add(cal);
        }//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Apply the BYMONTHDAY rule.">
        for (Integer integer : recurType.getBymonthday()) {
          final Calendar cal = merge(periodStart, dtStart);
          cal.set(Calendar.DAY_OF_MONTH, integer);
          dateSet.add(cal);
        }//</editor-fold>
      }
      break;
      case YEARLY: {
        //<editor-fold defaultstate="collapsed" desc="Apply the BYYEARDAY rule">
        for (Integer integer : recurType.getByyearday()) {
          final Calendar cal = merge(periodStart, dtStart);
          cal.set(Calendar.DAY_OF_YEAR, integer);
          dateSet.add(cal);
        }
      }//</editor-fold>
      break;
      default:
        throw new AssertionError(recurType.getFreq().name());
    }
    /**
     * @TODO: Apply the BYSETPOS rule.
     * <p>
     * This is a filter, removing unmatched entries. Valid positions are from 1
     * to the size of the date list. Invalid positions are ignored. See
     * Recur.java ~785.
     * <p>
     * for (Integer pos : recurType.getBysetpos()) { if (pos > 0 && pos <=
     * dateList.size()) { } }
     */
    if (recurType.isSetBysetpos()) {
      List<Calendar> dates = new ArrayList<>(new TreeSet<>(dateSet));
      Set<Calendar> setPosDates = new TreeSet<>();
      for (Integer integer : recurType.getBysetpos()) {
        if (integer > 0 && integer <= dates.size()) {
          setPosDates.add(dates.get(integer));
        } else if (integer < 0 && integer >= -dates.size()) {
          setPosDates.add((dates.get(dates.size() + integer)));
        }
      }
      return setPosDates;
    }
    /**
     * Return a sorted Set of Date values.
     */
    return new TreeSet<>(dateSet);
  }

  /**
   * Increments the specified calendar according to the FREQ and INTERVAL
   * specified in this recurrence rule.
   * <p>
   * If no INTERVAL value is set in the recurrence then the calendar is
   * incremented by one FREQ period. Otherwise the calendar is incremented by
   * INTERVAL FREQ periods.
   * <p>
   * @param calendar a java.util.Calendar to increment
   */
  private static void increment(RecurType recurType, final Calendar calendar) {
    calendar.add(recurType.getFreq().getCalendarValue(),
                 recurType.isSetInterval() && recurType.getInterval() >= 1
      ? recurType.getInterval()
      : 1);
  }

  /**
   * Obtain a new instance of a Duration specifying the Duration as
   * milliseconds.
   * <p>
   * XML Schema Part 2: Datatypes, 3.2.6 duration, defines duration as: duration
   * represents a duration of time. The value space of duration is a
   * six-dimensional space where the coordinates designate the Gregorian year,
   * month, day, hour, minute, and second components defined in Section 5.5.3.2
   * of [ISO 8601], respectively. These components are ordered in their
   * significance by their order of appearance i.e. as year, month, day, hour,
   * minute, and second.
   * <p>
   * @param milliseconds the duration in milliseconds.
   * @return a Duration instance
   * @throws DatatypeConfigurationException
   */
  public static Duration duration(long milliseconds) throws DatatypeConfigurationException {
    return DatatypeFactory.newInstance().newDuration(milliseconds);
  }

  /**
   * Obtain a new instance of a Duration between two dates.
   * <p>
   * XML Schema Part 2: Datatypes, 3.2.6 duration, defines duration as: duration
   * represents a duration of time. The value space of duration is a
   * six-dimensional space where the coordinates designate the Gregorian year,
   * month, day, hour, minute, and second components defined in Section 5.5.3.2
   * of [ISO 8601], respectively. These components are ordered in their
   * significance by their order of appearance i.e. as year, month, day, hour,
   * minute, and second.
   * <p>
   * @param start the start date and time
   * @param end   the end date and time
   * @return a Duration instance
   * @throws DatatypeConfigurationException
   */
  public static Duration duration(Calendar start, Calendar end) throws DatatypeConfigurationException {
    return duration(end.getTimeInMillis() - start.getTimeInMillis());
  }

  /**
   * Obtain a new instance of a Duration between two dates.
   * <p>
   * XML Schema Part 2: Datatypes, 3.2.6 duration, defines duration as: duration
   * represents a duration of time. The value space of duration is a
   * six-dimensional space where the coordinates designate the Gregorian year,
   * month, day, hour, minute, and second components defined in Section 5.5.3.2
   * of [ISO 8601], respectively. These components are ordered in their
   * significance by their order of appearance i.e. as year, month, day, hour,
   * minute, and second.
   * <p>
   * @param start the start date and time
   * @param end   the end date and time
   * @return a Duration instance
   * @throws DatatypeConfigurationException
   */
  public static Duration duration(Date start, Date end) throws DatatypeConfigurationException {
    return duration(end.getTime() - start.getTime());
  }

  /**
   * Set the TIME (Hour, Minute and Second) values for the start (and end time
   * if set) to match the time (HMS) values of the given date value.
   * <p>
   * @param date the DATETIME calendar - only the TIME values are extracted
   * @param time the TIME calendar value - only the TIME values are extracted
   * @return a calendar with date values from the date calendar and TIME values
   *         from the time calendar.
   */
  public static Calendar merge(Calendar date, Date time) {
    Calendar timeCalendar = Calendar.getInstance(TIMEZONE_UTC);
    timeCalendar.setTime(time);
    return merge(date, timeCalendar);
  }

  /**
   * Set the TIME (Hour, Minute and Second) values for the start (and end time
   * if set) to match the time (HMS) values of the given date value.
   * <p>
   * @param date the DATETIME calendar - only the TIME values are extracted
   * @param time the TIME calendar value - only the TIME values are extracted
   * @return a calendar with date values from the date calendar and TIME values
   *         from the time calendar.
   */
  public static Calendar merge(Calendar date, Calendar time) {
    final Calendar datetime = (Calendar) date.clone();
    for (int calendarField : new int[]{Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND}) {
      datetime.set(calendarField, time.get(calendarField));
    }
    return datetime;
  }

}
