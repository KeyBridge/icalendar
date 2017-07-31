/*
 * Copyright 2016 Key Bridge LLC.
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

import ietf.params.xml.ns.icalendar.PeriodType;
import ietf.params.xml.ns.icalendar.RecurType;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A utility class to help interact and manipulate ICalendar classes and
 * instances.
 * <p>
 * Portions of code in this class are either inspired by or copied from the
 * Recur.java class in the iCal4j project (v2.0) and are &copy; 2004 Ben
 * Fortuna. Credit to the original author for paving the way.
 *
 * @author Jesse Caulfield <jesse@caulfield.org> 07/07/14
 */
public class ICalendar {

  private static final Logger LOGGER = Logger.getLogger(ICalendar.class.getName());

  /**
   * Calculate a recurrence set during the specified period for an event
   * beginning and ending on the specified days and having the specified
   * recurrence rule.
   * <p>
   * The recurrence set is derived from a combination of the component start
   * date, recurrence rules and dates.
   * <p>
   * Developer note: This method only calculates the RRULE portion of an
   * iCalendar event. A complete calendaring implementation should also account
   * for RDATE, EXDATE and EXRULE components.
   * <p>
   * Also note that component transparency and anniversary-style dates do not
   * affect set calculation.
   *
   * @param eventStart  the (master) event start date and mergeTime
   * @param eventEnd    the (master) event end date and mergeTime
   * @param recurType   the (master) event recurrence type
   * @param periodStart the period of interest start date. This should be on a
   *                    SUNDAY at or before the first day of a month.
   * @param periodEnd   the period of interest end date. This should be on a
   *                    SATURDAY at or after the last day of the month.
   * @return a non-null TreeSet containing calculated event instances occurring
   *         during the defined period (e.g. between the period start and end
   *         dates.) // * @throws DatatypeConfigurationException if a PeriodType
   *         fails to build
   * @throws Exception if the event does not contain the period of interest
   */
  public static Set<PeriodType> calculateRecurrenceSet(final LocalDateTime eventStart,
                                                       final LocalDateTime eventEnd,
                                                       final RecurType recurType,
                                                       final LocalDateTime periodStart,
                                                       final LocalDateTime periodEnd) {
    /**
     * Initialize the period list. Use a HashSet to enforce uniqueness.
     */
    Set<PeriodType> periodSet = new HashSet<>();
    /**
     * Confirm the period of interest is contained within the event
     */
    if (periodEnd.isBefore(eventStart) || periodStart.isAfter(eventEnd)) {
      throw new IllegalArgumentException("Event does not contain period of interest.");
    }
    /**
     * Preserve the event duration. This is applied later to each calculated
     * PeriodType.
     */
    final Duration duration = Duration.between(eventStart, eventEnd);
    /**
     * Copy the period start datetime into calendar instances to facilitate
     * calculation. Calculating with java.util.Date is ... less than satisfying.
     */
    LocalDateTime pStart = LocalDateTime.from(periodStart);
    /**
     * Apply RFC 5545 Page 41: The BYWEEKNO rule corresponds to weeks according
     * to week numbering as defined in [ISO.8601.2004]. A week is defined as a
     * seven day period, starting on the day of the week defined to be the week
     * start (see WKST). Week number one of the calendar year is the first week
     * that contains at least four (4) days in that calendar year.
     */
    final WeekFields weekFields = WeekFields.of(
            recurType.isSetWkst() ? recurType.getWkst().getDayOfWeek() : DayOfWeek.MONDAY, 4);
    /**
     * Copy the period end datetime into a calendar instance.
     */
    LocalDateTime pEnd = LocalDateTime.from(periodEnd);
    /**
     * Now begin the recurrence set calculation.
     * <p>
     * First: Back up (reverse) the period start by the event DURATION to
     * include any events that may have begun before the period start and end
     * during the period.
     */
    if (eventStart.isBefore(pStart)) {
      pStart = eventStart;
    }
    /**
     * Second: Add the initial event if it falls within the (adjusted) period.
     */
    if ((pStart.isBefore(eventStart) || pStart.isEqual(eventEnd)) && periodEnd.isAfter(eventStart)) {
      periodSet.add(new PeriodType(eventStart, duration));
    }
    /**
     * Third: Fast forward PSTART to the EVENT start if the event begins within
     * the period. This will ensure only recurring events that are AFTER the
     * original EVENT are added.
     */
    while (pStart.isBefore(eventStart)) {
      pStart = pStart.minus(duration);
    }
    /**
     * Finally: Scan through the period of interest in FREQ increments. For each
     * increment calculate a list of candidate occurrence dates. Analyze each
     * candidate to determine if it is a valid start-date for the original event
     * RECUR rule.
     * <p>
     * Developer note: Recurrence sets only require adjustment of the event
     * start date. Therefore only the start date for each period is calculated.
     * If a candidate start date is deemed valid then the duration is applied to
     * create a new Period, which is added to the list of PeriodTypes. The
     * PeriodType list is the set of recurring events within the period of
     * inquiry.
     */
    while (pStart.isBefore(pEnd)) {
      /**
       * Build a list of candidate DTSTART dates within the current FREQ period.
       * Each candidate Calendar has a unique DATE value and a TIME value
       * corresponding to the original event (or the hour if BYHOUR is set).
       */
      Set<LocalDateTime> startCandidateSet = buildCandidateList(recurType, pStart, weekFields);
      /**
       * Scan through the set of candidate START dates, evaluating their
       * validity and adding only those that match the recurrence rule.
       */
      for (LocalDateTime startCandidate : startCandidateSet) {
        if (recurType.isSetUntil() && recurType.getUntil().before(startCandidate)) {
          /**
           * INVALID: candidate is AFTER the UNTIL date.
           */
          LOGGER.log(Level.FINEST, "Warning: AFTER the UNTIL date {0}", startCandidate);
        } else if (recurType.isSetCount() && periodSet.size() >= recurType.getCount()) {
          /**
           * INVALID: COUNT value is exceeded.
           */
          LOGGER.log(Level.FINEST, "Warning: COUNT EXCEEDED {0}", startCandidate);
        } else if (startCandidate.isAfter(periodStart)
                && startCandidate.isAfter(eventStart)
                && startCandidate.isBefore(periodEnd)) {
          /**
           * VALID: CREATE and ADD and new PeriodType to the set.
           */
          periodSet.add(new PeriodType(startCandidate, duration));
        } else {
          /**
           * INVALID: OUT OF RANGE or other UNKNOWN error.
           */
          LOGGER.log(Level.FINEST, "Warning: OUT OF RANGE or other UNKNOWN error {0}", startCandidate);
        }
      }
      /**
       * Important: Increment the pStart value by the FREQ increment, multiplied
       * by the FREQ INTERVAL value if present.
       */
      long amount = recurType.isSetInterval() && recurType.getInterval() >= 1
                    ? recurType.getInterval()
                    : 1;
      pStart = pStart.plus(amount, recurType.getFreq().getTemporalUnit());
    } // END while loop
    /**
     * Return a sorted version of the period set.
     */
    return new TreeSet<>(periodSet);
  }

  //<editor-fold defaultstate="collapsed" desc="RRULE Calculators">
  /**
   * Calculate the BYSECOND rule.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> bySecond(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getBysecond(), periodStart, LocalDateTime::withSecond);
  }

  /**
   * Calculate the BYMINUTE rule.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> byMinute(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getByminute(), periodStart, LocalDateTime::withMinute);
  }

  /**
   * Calculate the BYHOUR rule.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> byHour(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getByhour(), periodStart, LocalDateTime::withHour);
  }

  /**
   * Calculate a rule for a generic input.
   *
   * @param dateSet     the existing set of candidate dates
   * @param values      an Integer collection that represent the
   *                    BY[TEMPORAL_AMOUNT] rule values
   * @param periodStart the period start
   * @param function    a function that creates new LocalDateTimes given the
   *                    cartesian product of input dates and BY[TEMPORAL_AMOUNT]
   *                    rule values
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> byGeneric(Set<LocalDateTime> dateSet, Collection<Integer> values,
                                              LocalDateTime periodStart,
                                              BiFunction<LocalDateTime, Integer, LocalDateTime> function) {
    if (values.isEmpty()) {
      return dateSet;
    }
    return (dateSet.isEmpty()
            ? Stream.of(periodStart)
            : dateSet.stream()).flatMap(date -> values.stream()
                    .map(integer -> function.apply(date, integer)))
            .collect(Collectors.toSet());
  }

  /**
   * Calculate the DAILY recurrence rule.
   * <p>
   * This is ONLY called for DAILY type recurrence.
   * <p>
   * The DAILY rule is very simple: just add the current day. Developer note:
   * DAILY recurrence should (preferably) have an UNTIL or COUNT, which are
   * handled in the WHILE loop wrapping this method. If UNTIL and COUNT are not
   * specified then the DAILY will return every day in the period after the
   * event start.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> day(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    Set<LocalDateTime> set = new HashSet<>();
    if (dateSet.isEmpty()) {
      set.add(LocalDateTime.from(periodStart));
    } else {
      for (LocalDateTime calendar : dateSet) {
        set.add(LocalDateTime.from(calendar));
      }
    }
    return set;
  }

  /**
   * Calculate the BYDAY rule.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> byDay(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getByhour(), periodStart, LocalDateTime::withHour);
  }

  /**
   * Calculate the BYWEEKNO rule.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> byWeekNo(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart, WeekFields weekFields) {
    return byGeneric(dateSet, recurType.getByweekno(), periodStart,
                     (date, integer) -> date.with(weekFields.weekOfYear(), integer));
  }

  /**
   * Calculate the BYMONTH rule.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> byMonth(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getBymonth(), periodStart, LocalDateTime::withMonth);
  }

  /**
   * Calculate the BYMONTHDAY rule.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> byMonthDay(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getBymonthday(), periodStart, LocalDateTime::withDayOfMonth);
  }

  /**
   * Calculate the BYYEARDAY rule.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> byYearDay(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getBymonthday(), periodStart, LocalDateTime::withDayOfYear);
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
   * Developer note: the returned list contains DATE-TIME values. The TIME
   * component of the periodStart parameter SHOULD be set to match the DTSTART
   * time.
   *
   * @param recurType   the event recurrence. If null or invalid then a empty
   *                    HashSet is returned.
   * @param periodStart the PERIOD start DATE-TIME value.
   * @return a non-null TreeSet
   */
  private static Set<LocalDateTime> buildCandidateList(RecurType recurType, LocalDateTime periodStart, WeekFields weekFields) {
    /**
     * Initialize the set. Use a HashSet to enforce uniqueness. Each (cascaded)
     * calculating method called within the SWITCH statement inspects and is
     * able to initialize the dateSet.
     */
    Set<LocalDateTime> dateSet = new HashSet<>();
    /**
     * Intercept invalid or incomplete RecurType entries.
     */
    if (recurType.getFreq() == null) {
      return dateSet;
    }
    /**
     * Apply a cascaded set of calculations based upon the recurrence rule
     * configuration.
     */
    switch (recurType.getFreq()) {
      case SECONDLY:
        dateSet.addAll(bySecond(dateSet, recurType, periodStart));
        break;
      case MINUTELY:
        dateSet.addAll(bySecond(byMinute(dateSet, recurType, periodStart),
                                recurType, periodStart));
        break;
      case HOURLY:
        dateSet.addAll(bySecond(byMinute(byHour(dateSet, recurType, periodStart),
                                         recurType, periodStart),
                                recurType, periodStart));
        break;
      case DAILY:
        dateSet.addAll(bySecond(byMinute(byHour(day(dateSet, recurType, periodStart),
                                                recurType, periodStart),
                                         recurType, periodStart),
                                recurType, periodStart));

        break;
      case WEEKLY:
        dateSet.addAll(bySecond(byMinute(byHour(byDay(byWeekNo(dateSet, recurType, periodStart, weekFields),
                                                      recurType, periodStart),
                                                recurType, periodStart),
                                         recurType, periodStart),
                                recurType, periodStart));

        break;
      case MONTHLY:
        dateSet.addAll(bySecond(byMinute(byHour(byDay(byWeekNo(byMonthDay(byMonth(dateSet, recurType, periodStart),
                                                                          recurType, periodStart),
                                                               recurType, periodStart, weekFields),
                                                      recurType, periodStart),
                                                recurType, periodStart),
                                         recurType, periodStart),
                                recurType, periodStart));
        break;
      case YEARLY:
        dateSet.addAll(bySecond(byMinute(byHour(byDay(byWeekNo(byMonthDay(byMonth(byYearDay(dateSet, recurType, periodStart),
                                                                                  recurType, periodStart),
                                                                          recurType, periodStart),
                                                               recurType, periodStart, weekFields),
                                                      recurType, periodStart),
                                                recurType, periodStart),
                                         recurType, periodStart),
                                recurType, periodStart));
        break;
      default:
        throw new AssertionError(recurType.getFreq().name());
    }
    /**
     * Apply the BYSETPOS rule.
     * <p>
     * This is a filter, returning ONLY matched entries. Valid positions are
     * from 1 to the size of the date list. Invalid positions are ignored. See
     * Recur.java ~785.
     */
    if (recurType.isSetBysetpos()) {
      List<LocalDateTime> dates = new ArrayList<>(new TreeSet<>(dateSet));
      Set<LocalDateTime> setPosDates = new TreeSet<>();
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
     * Return a sorted Set of java.util.Calendar values.
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
   *
   * @param calendar a java.util.Calendar to increment
   */
//  private static void increment(RecurType recurType, final Calendar calendar) {
//    calendar.add(recurType.getFreq().getTemporalUnit(),
//                 recurType.isSetInterval() && recurType.getInterval() >= 1
//                 ? recurType.getInterval()
//                 : 1);
//  }
  /**
   * Obtain a new instance of a Duration specifying the Duration as
   * milliseconds.
   * <p>
   * XML Schema Part 2: Datatypes, 3.2.6 duration, defines duration as: duration
   * represents a duration of mergeTime. The value space of duration is a
   * six-dimensional space where the coordinates designate the Gregorian year,
   * month, day, hour, minute, and second components defined in Section 5.5.3.2
   * of [ISO 8601], respectively. These components are ordered in their
   * significance by their order of appearance i.e. as year, month, day, hour,
   * minute, and second.
   *
   * @param milliseconds the duration in milliseconds.
   * @return a Duration instance
   * @throws DatatypeConfigurationException
   */
//  public static Duration duration(long milliseconds) throws DatatypeConfigurationException {
//    return DatatypeFactory.newInstance().newDuration(milliseconds);
//  }
  /**
   * Obtain a new instance of a Duration between two dates.
   * <p>
   * XML Schema Part 2: Datatypes, 3.2.6 duration, defines duration as: duration
   * represents a duration of mergeTime. The value space of duration is a
   * six-dimensional space where the coordinates designate the Gregorian year,
   * month, day, hour, minute, and second components defined in Section 5.5.3.2
   * of [ISO 8601], respectively. These components are ordered in their
   * significance by their order of appearance i.e. as year, month, day, hour,
   * minute, and second.
   *
   * @param start the start date and mergeTime
   * @param end   the end date and mergeTime
   * @return a Duration instance
   * @throws DatatypeConfigurationException
   */
//  public static Duration duration(Calendar start, Calendar end) throws DatatypeConfigurationException {
//    return duration(end.getTimeInMillis() - start.getTimeInMillis());
//  }
  /**
   * Obtain a new instance of a Duration between two dates.
   * <p>
   * XML Schema Part 2: Datatypes, 3.2.6 duration, defines duration as: duration
   * represents a duration of mergeTime. The value space of duration is a
   * six-dimensional space where the coordinates designate the Gregorian year,
   * month, day, hour, minute, and second components defined in Section 5.5.3.2
   * of [ISO 8601], respectively. These components are ordered in their
   * significance by their order of appearance i.e. as year, month, day, hour,
   * minute, and second.
   *
   * @param start the start date and mergeTime
   * @param end   the end date and mergeTime
   * @return a Duration instance
   * @throws DatatypeConfigurationException
   */
//  public static Duration duration(Date start, Date end) throws DatatypeConfigurationException {
//    return duration(end.getTime() - start.getTime());
//  }
  /**
   * Set the TIME (Hour, Minute and Second) values for the start (and end
   * mergeTime if set) to match the mergeTime (HMS) values of the given date
   * value.
   *
   * @param date the DATETIME calendar - only the TIME values are extracted
   * @param time the TIME calendar value - only the TIME values are extracted
   * @return a calendar with date values from the date calendar and TIME values
   *         from the mergeTime calendar.
   */
//  private static Calendar mergeTime(Calendar date, Date time) {
//    Calendar timeCalendar = Calendar.getInstance(TIMEZONE_UTC);
//    timeCalendar.setTime(time);
//    return mergeTime(date, timeCalendar);
//  }
  /**
   * Set the TIME (Hour, Minute and Second) values for the start (and end
   * mergeTime if set) to match the mergeTime (HMS) values of the given date
   * value.
   *
   * @param date the DATETIME calendar - only the TIME values are extracted
   * @param time the TIME calendar value - only the TIME values are extracted
   * @return a calendar with date values from the date calendar and TIME values
   *         from the mergeTime calendar.
   */
//  private static Calendar mergeTime(Calendar date, Calendar time) {
//    final Calendar datetime = (Calendar) date.clone();
//    for (int calendarField : new int[]{Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND}) {
//      datetime.set(calendarField, time.get(calendarField));
//    }
//    return datetime;
//  }//</editor-fold>
}
