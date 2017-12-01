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
package ch.keybridge.icalendar;

import ietf.params.xml.ns.icalendar.*;
import ietf.params.xml.ns.icalendar.component.base.VcalendarType;
import ietf.params.xml.ns.icalendar.component.base.VeventType;
import ietf.params.xml.ns.icalendar.property.base.CalscalePropType;
import ietf.params.xml.ns.icalendar.property.base.caladdress.OrganizerPropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.DtendPropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.DtstartPropType;
import ietf.params.xml.ns.icalendar.property.base.integer.PriorityPropType;
import ietf.params.xml.ns.icalendar.property.base.integer.SequencePropType;
import ietf.params.xml.ns.icalendar.property.base.recur.RrulePropType;
import ietf.params.xml.ns.icalendar.property.base.text.*;
import ietf.params.xml.ns.icalendar.property.base.textlist.CategoriesPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.CreatedPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.DtstampPropType;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.*;
import java.time.temporal.*;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ietf.params.xml.ns.icalendar.Constants.ZONE_UTC;

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
   *                    SUNDAY at or before the first daily of a month.
   * @param periodEnd   the period of interest end date. This should be on a
   *                    SATURDAY at or after the last daily of the month.
   * @return a non-null TreeSet containing calculated event instances occurring
   *         during the defined period (e.g. between the period start and end
   *         dates.) Returns an EMPTY TreeSet if the event does not intersect
   *         the period of interest.
   */
  public static Set<PeriodType> calculatePeriodSet(final LocalDateTime eventStart,
                                                   final LocalDateTime eventEnd,
                                                   final RecurType recurType,
                                                   final LocalDateTime periodStart,
                                                   final LocalDateTime periodEnd) {
    /**
     * Initialize the period list. Use a HashSet for speed and to enforce
     * uniqueness. This is copied into a TreeSet later to provide a sorted set.
     */
    Set<PeriodType> periodSet = new HashSet<>();
    /**
     * Confirm the period of interest contains the event.
     */
    if (periodEnd.isBefore(eventStart) || periodStart.isAfter(calculateExpiration(ZonedDateTime.of(eventEnd, ZONE_UTC), null, recurType).toLocalDateTime())) {
      /**
       * Update 11/28/17: Fail gracefully if the period does not contain the
       * event and return an empty set.
       */
//      throw new IllegalArgumentException("Event does not contain period of interest.");
      LOGGER.fine("Event does not intersect period of interest");
      return periodSet;
    }
    /**
     * Preserve the event duration. This is applied later to each calculated
     * PeriodType.
     */
    final Duration duration = Duration.between(eventStart, eventEnd);
    /**
     * Copy the period start datetime into a local variable to facilitate
     * calculation. This local variable will be internally manipulated.
     */
    LocalDateTime pStart = LocalDateTime.from(periodStart);
    /**
     * Now begin the recurrence set calculation.
     * <p>
     * First: If the event starts before the period then back up (reverse) the
     * period by the event DURATION. This will include any events that may have
     * begun before the period started and that end during the period.
     */
    if (eventStart.isBefore(pStart)) {
      pStart = eventStart;
    }
    /**
     * Second: Add the initial event if it falls within the (adjusted) period.
     */
    if ((pStart.isBefore(eventStart) || pStart.isEqual(eventStart))
      && (periodEnd.isAfter(eventStart) || periodEnd.isEqual(eventStart))) {
      periodSet.add(new PeriodType(eventStart, duration));
    }
    /**
     * Third: Set the pStart TIME component to the dtStart TIME value. This
     * preserves the pStart DATE value set above but ensures that calculated
     * recurring events match the DTSTART TIME. Sets the TIME (Hour, Minute and
     * Second) values.
     */
    pStart = pStart
      .withHour(eventStart.getHour())
      .withMinute(eventStart.getMinute())
      .withSecond(eventStart.getSecond());
    /**
     * Fourth: Fast forward PSTART to the EVENT start if the event begins within
     * the period. This will ensure only recurring events that occur AFTER the
     * original EVENT are added.
     */
    if (pStart.isBefore(eventStart)) {
      pStart = eventStart;
    }
    /**
     * Apply RFC 5545 Page 41: The BYWEEKNO rule corresponds to weeks according
     * to week numbering as defined in [ISO.8601.2004]. A week is defined as a
     * seven day period, starting on the day of the week defined to be the week
     * start (see WKST). Week number one of the calendar year is the first week
     * that contains at least four (4) days in that calendar year.
     */
    final WeekFields weekFields = WeekFields.of(recurType.isSetWkst()
                                                ? recurType.getWkst().getDayOfWeek()
                                                : DayOfWeek.SUNDAY, 4);
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
    while (pStart.compareTo(periodEnd) <= 0) {
      /**
       * Before we move on to create a startCandidateSet, check if this pStart
       * dateTime is ruled out by any BYxxx rule
       */
      if (!isNegatedByLimitRule(recurType, pStart)) {
        /**
         * Build a list of candidate DTSTART dates within the current FREQ
         * period. Each candidate LocalDateTime entry corresponding to the
         * original event (or the hour if BYHOUR is set).
         */
        Set<LocalDateTime> startCandidateSet = expandByRecurrenceRule(recurType, pStart, weekFields);
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
          } else if (!startCandidate.isBefore(periodStart)
            && !startCandidate.isBefore(eventStart)
            && !startCandidate.isAfter(periodEnd)) {
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
      }
      /**
       * Important: Increment the pStart value by the FREQ increment, multiplied
       * by the FREQ INTERVAL value if present. This increments the specified
       * calendar according to the FREQ and INTERVAL specified in this
       * recurrence rule. If no INTERVAL value is set in the recurrence then the
       * calendar is incremented by one FREQ period. Otherwise the calendar is
       * incremented by INTERVAL FREQ periods.
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

  /**
   * A static utility method that checks if a LocalDateTime candidate is rueld
   * out by any of the BYxxx rules. For example, a SECONDLY recurrence with
   * BYSECOND=1 should only occur on the first second of each minute (thus
   * making it equivalent to a MINUTELY recurrence with BYSECOND=1 or a MINUTELY
   * recurrence with an event starting on the first second.
   *
   * @param recurType RecurType instance
   * @param candidate candidate dateTime
   * @return is this candidate dateTime ruled out by RRULEs in the RecurType
   */
  private static boolean isNegatedByLimitRule(final RecurType recurType, final LocalDateTime candidate) {
    switch (recurType.getFreq()) {
      case SECONDLY:
        if (recurType.isSetBysecond() && noneMatch(recurType.getBysecond(), 60, candidate.getSecond())) {
          return true;
        }
      case MINUTELY:
        if (recurType.isSetByminute() && noneMatch(recurType.getByminute(), 60, candidate.getMinute())) {
          return true;
        }
      case HOURLY:
        if (recurType.isSetByhour() && noneMatch(recurType.getByhour(), 24, candidate.getHour())) {
          return true;
        }
      case DAILY:
        if (recurType.isSetByday() && recurType.getByday().stream()
          .noneMatch(t -> t.getWeekdayRecurType().getDayOfWeek() == candidate.getDayOfWeek() && (!t.isMonthly()
                                                                                                 || candidate.equals(calculateNthWeekday(candidate, t))))) {
          return true;
        }
        if (recurType.isSetBymonthday() && noneMatch(recurType.getBymonthday(), candidate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth(), candidate.getDayOfMonth())) {
          return true;
        }
        if (recurType.getFreq() != EFreqRecurType.DAILY
          && recurType.isSetByyearday() && noneMatch(recurType.getByyearday(), Year.from(candidate).length(), candidate.getDayOfYear())) {
          return true;
        }
      case WEEKLY:
      case MONTHLY:
        if (recurType.isSetBymonth() && noneMatch(recurType.getBymonth(), 12, candidate.getMonthValue())) {
          return true;
        }
    }

    return false;
  }

  private static boolean noneMatch(Collection<Integer> acceptedValues, int negativeValueOffset, int candidate) {
    return acceptedValues.stream().map(value -> value > 0 ? value : value + negativeValueOffset).noneMatch(v -> v
      == candidate);
  }

  //<editor-fold defaultstate="collapsed" desc="RRULE Calculators">
  /**
   * Calculate a rule for a generic input.
   *
   * @param dateSet            the existing set of candidate dates
   * @param isSet              is this rule set?
   * @param byValueSupplier    a supplier for an Integer collection that
   *                           represent the BY[TEMPORAL_AMOUNT] rule values
   * @param temporalUnitLength a function providing the length of the
   * @param periodStart        the period start
   * @param function           a function that creates new LocalDateTimes given
   *                           the cartesian product of input dates and
   *                           BY[TEMPORAL_AMOUNT] rule values
   * @return a non-null HashSet
   */
  private static Set<LocalDateTime> expandByGeneric(Set<LocalDateTime> dateSet,
                                                    boolean isSet,
                                                    Supplier<Collection<Integer>> byValueSupplier,
                                                    Function<LocalDateTime, Integer> temporalUnitLength,
                                                    LocalDateTime periodStart,
                                                    BiFunction<LocalDateTime, Integer, LocalDateTime> function,
                                                    TemporalUnit forwardAdjustment) {
    if (!isSet) {
      return dateSet;
    }
    /**
     * The function indicates a LocalDatetime field and value that should be set
     * in each entry in the dateSet. e.g. LocalDateTime::withDayOfYear
     * <p>
     * expandByWeekNo: (date, integer) -> date.with(weekFields.weekOfYear(),
     * integer)
     */
    return (dateSet.isEmpty()
            ? Stream.of(periodStart)
            : dateSet.stream()).flatMap(date -> byValueSupplier.get().stream()
      .map(integer -> function.apply(date, integer > 0 ? integer : temporalUnitLength.apply(date) + integer)))
      .map(date -> date.isBefore(periodStart) ? date.plus(1, forwardAdjustment) : date)
      .collect(Collectors.toSet());
  }

  /**
   * Calculate the BYSECOND rule. The BYSECOND rule part specifies a
   * COMMA-separated list of seconds within a minute. Valid values are 0 to 60.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  protected static Set<LocalDateTime> expandBySecond(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return expandByGeneric(dateSet, recurType.isSetBysecond(), recurType::getBysecond, date -> 60, periodStart, LocalDateTime::withSecond, ChronoUnit.MINUTES);
  }

  /**
   * Calculate the BYMINUTE rule. The BYMINUTE rule part specifies a
   * COMMA-separated list of minutes within an hour. Valid values are 0 to 59.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  protected static Set<LocalDateTime> expandByMinute(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return expandByGeneric(dateSet, recurType.isSetByminute(), recurType::getByminute, date -> 60, periodStart, LocalDateTime::withMinute, ChronoUnit.HOURS);
  }

  /**
   * Calculate the BYHOUR rule. The BYHOUR rule part specifies a COMMA-
   * separated list of hours of the daily. Valid values are 0 to 23.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  protected static Set<LocalDateTime> expandByHour(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return expandByGeneric(dateSet, recurType.isSetByhour(), recurType::getByhour, date -> 24, periodStart, LocalDateTime::withHour, ChronoUnit.DAYS);
  }

  /**
   * Utility method that creates a HashSet containing one LocalDateTime
   *
   * @param dateTime some LocalDateTime
   * @return a HashSet containing only dateTime
   */
  protected static Set<LocalDateTime> asSet(LocalDateTime dateTime) {
    Set<LocalDateTime> set = new HashSet<>();
    set.add(Objects.requireNonNull(dateTime));
    return set;
  }

  /**
   * Calculate the BYDAY rule with no integer prefixes, i.e. rules like
   * SU,MO,TU, and not 2SU,3WE. The BYDAY rule part specifies a COMMA character
   * (US-ASCII decimal 44) separated list of days of the week; MO indicates
   * Monday; TU indicates Tuesday; WE indicates Wednesday; TH indicates
   * Thursday; FR indicates Friday; SA indicates Saturday; SU indicates Sunday.
   * <p>
   * This rule is handled differently then others as it specifies the enumerated
   * daily of week and not an integer reference.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  protected static Set<LocalDateTime> expandByDay(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    if (!recurType.isSetByday() || recurType.getByday().stream().allMatch(NthWeekdayRecurType::isMonthly)) {
      return dateSet;
    }
    return (dateSet.isEmpty()
            ? Stream.of(periodStart)
            : dateSet.stream())
      .flatMap(date -> recurType.getByday().stream()
      .filter(nthWeekDay -> !nthWeekDay.isMonthly())
      .map(dayOfWeek -> date.with(ChronoField.DAY_OF_WEEK, dayOfWeek.getWeekdayRecurType().getDayOfWeek().getValue())))
      .map(date -> date.isBefore(periodStart) ? date.plus(1, ChronoUnit.WEEKS) : date)
      .collect(Collectors.toSet());
  }

  /**
   * Calculate the BYDAY rule with integer prefixes, i.e. rules like
   * 2SU,-1MO,4TU, and not SU,WE. The BYDAY rule part specifies a COMMA
   * character (US-ASCII decimal 44) separated list of days of the week; MO
   * indicates Monday; TU indicates Tuesday; WE indicates Wednesday; TH
   * indicates Thursday; FR indicates Friday; SA indicates Saturday; SU
   * indicates Sunday.
   * <p>
   * This rule is handled differently then others as it specifies the enumerated
   * daily of week with associated integer and not an integer reference.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  protected static Set<LocalDateTime> expandByNthWeekday(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    if (!recurType.isSetByday() || recurType.getByday().stream().noneMatch(NthWeekdayRecurType::isMonthly)) {
      return dateSet;
    }
    return (dateSet.isEmpty()
            ? Stream.of(periodStart)
            : dateSet.stream())
      .flatMap(date -> recurType.getByday().stream()
      .filter(NthWeekdayRecurType::isMonthly)
      .map(dayOfWeek -> calculateNthWeekday(date, dayOfWeek)))
      .map(date -> date.isBefore(periodStart) ? date.plus(1, ChronoUnit.MONTHS) : date)
      .collect(Collectors.toSet());
  }

  /**
   * Utility method for obtaining the n'th weekday in a month
   *
   * @param date             original date
   * @param weekdayRecurType NthWeekdayRecurType containing the weekday (Monday,
   *                         Tuesday, etc...) and an integer specifying which
   *                         (1st, 2nd, ..., second last, last) one to pick
   * @return LocalDateTime with the day field set accordingly and all other
   *         fields the same as in the input date
   */
  private static LocalDateTime calculateNthWeekday(LocalDateTime date, NthWeekdayRecurType weekdayRecurType) {
    return date.with(
      TemporalAdjusters.dayOfWeekInMonth(weekdayRecurType.getInteger(),
                                         weekdayRecurType.getWeekdayRecurType().getDayOfWeek()));
  }

  /**
   * Calculate the BYWEEKNO rule. The BYWEEKNO rule part specifies a
   * COMMA-separated list of ordinals specifying weeks of the year. Valid values
   * are 1 to 53 or -53 to -1. This corresponds to weeks according to week
   * numbering as defined in [ISO.8601.2004]. A week is defined as a seven daily
   * period, starting on the daily of the week defined to be the week start (see
   * WKST). Week number one of the calendar year is the first week that contains
   * at least four (4) days in that calendar year. This rule part MUST NOT be
   * used when the FREQ rule part is set to anything other than YEARLY. For
   * example, 3 represents the third week of the year.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  protected static Set<LocalDateTime> expandByWeekNo(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart, WeekFields weekFields) {
    return expandByGeneric(dateSet,
                           recurType.isSetByweekno(),
                           recurType::getByweekno,
                           date -> (int) weekFields.weekOfYear().getFrom(date.with(TemporalAdjusters.lastDayOfYear())),
                           periodStart,
                           (date, integer) -> date.with(weekFields.weekOfYear(), integer), ChronoUnit.YEARS);
  }

  /**
   * Calculate the BYMONTH rule. The BYMONTH rule part specifies a
   * COMMA-separated list of months of the year. Valid values are 1 to 12.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  protected static Set<LocalDateTime> expandByMonth(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return expandByGeneric(dateSet, recurType.isSetBymonth(), recurType::getBymonth, date -> 12, periodStart, LocalDateTime::withMonth, ChronoUnit.YEARS);
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
  protected static Set<LocalDateTime> expandByMonthDay(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return expandByGeneric(dateSet, recurType.isSetBymonthday(), recurType::getBymonthday, date -> Month.from(date).length(Year.from(date).isLeap()), periodStart, LocalDateTime::withDayOfMonth, ChronoUnit.MONTHS);
  }

  /**
   * Calculate the BYYEARDAY rule. The BYYEARDAY rule part specifies a
   * COMMA-separated list of days of the year. Valid values are 1 to 366 or -366
   * to -1. For example, -1 represents the last daily of the year (December
   * 31st) and -306 represents the 306th to the last daily of the year (March
   * 1st). The BYYEARDAY rule part MUST NOT be specified when the FREQ rule part
   * is set to DAILY, WEEKLY, or MONTHLY.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  protected static Set<LocalDateTime> expandByYearDay(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return expandByGeneric(dateSet, recurType.isSetByyearday(), recurType::getByyearday, date -> Year.from(date).length(), periodStart, LocalDateTime::withDayOfYear, ChronoUnit.YEARS);
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
   * @param weekFields  the definitions of the daily-of-week, week-of-month and
   *                    week-of-year fields.
   * @return a non-null TreeSet
   */
  protected static Set<LocalDateTime> expandByRecurrenceRule(RecurType recurType, LocalDateTime periodStart, WeekFields weekFields) {
    /**
     * Initialize the set. Use a HashSet to enforce uniqueness. Each (cascaded)
     * calculating method called within the SWITCH statement inspects and is
     * able to initialize the dateSet.
     */
    Set<LocalDateTime> dateSet = asSet(periodStart);
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
      case YEARLY:
        dateSet = expandByMonth(dateSet, recurType, periodStart);
        dateSet = expandByWeekNo(dateSet, recurType, periodStart, weekFields);
        dateSet = expandByYearDay(dateSet, recurType, periodStart);
      case MONTHLY:
        dateSet = expandByMonthDay(dateSet, recurType, periodStart);
        dateSet = expandByNthWeekday(dateSet, recurType, periodStart);
      case WEEKLY:
        dateSet = expandByDay(dateSet, recurType, periodStart);
      case DAILY:
        dateSet = expandByHour(dateSet, recurType, periodStart);
      case HOURLY:
        dateSet = expandByMinute(dateSet, recurType, periodStart);
      case MINUTELY:
        dateSet = expandBySecond(dateSet, recurType, periodStart);
      case SECONDLY:
        break;
      default:
        throw new AssertionError(recurType.getFreq().name());
    }
    /**
     * Apply the BYSETPOS rule. Each BYSETPOS value can include a positive (+n)
     * or negative (-n) integer. If present, this indicates the nth occurrence
     * of the specific occurrence within the set of occurrences specified by the
     * rule. The BYSETPOS rule part specifies a COMMA-separated list of values
     * that corresponds to the nth occurrence within the set of recurrence
     * instances specified by the rule. BYSETPOS operates on a set of recurrence
     * instances in one interval of the recurrence rule. For example, in a
     * WEEKLY rule, the interval would be one week A set of recurrence instances
     * starts at the beginning of the interval defined by the FREQ rule part.
     * Valid values are 1 to 366 or -366 to -1. It MUST only be used in
     * conjunction with another BYxxx rule part. For example "the last work day
     * of the month" could be represented as:
     * <p>
     * This is a filter that return ONLY matched entries. Valid positions are
     * from 1 to the size of the date list. Invalid positions are ignored. See
     * Recur.java ~785.
     */
    if (recurType.isSetBysetpos()) {
      /**
       * Organize the dataSet into a sorted ArrayList, then extract entries
       * based upon their position in the list.
       */
      List<LocalDateTime> dates = dateSet.stream().sorted().collect(Collectors.toList());
      Set<LocalDateTime> setPosDates = new TreeSet<>();
      for (Integer setPosition : recurType.getBysetpos()) {
        if (setPosition > 0 && setPosition <= dates.size()) {
          /**
           * Get the nth entry from the START of the list.
           */
          setPosDates.add(dates.get(setPosition));
        } else if (setPosition < 0 && setPosition >= -dates.size()) {
          /**
           * Get the nth entry from the END of the list.
           */
          setPosDates.add((dates.get(dates.size() + setPosition))); // setPosition is negative
        }
      }
      return setPosDates;
    }
    /**
     * Return a sorted Set of java.util.Calendar values.
     */
    return new TreeSet<>(dateSet);
  }//</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="VCalendar builder">
  /**
   * Build a VCalendar object from a station and (optional) location
   *
   * @param vEvent the vEvent
   * @return vCal formatted string
   * @throws java.lang.Exception if the VeventType fails to build
   */
  public String buildVCalendar(VeventType vEvent) throws Exception {
    String PRODID = "-//Key Bridge iCalendarFactory/2.00//EN";
    VcalendarType vc = new VcalendarType();
    ObjectFactory o = new ObjectFactory();
    vc.getProperties().addProperty(o.createCalscale(new CalscalePropType(ECalscaleValueType.GREGORIAN)));
    vc.getProperties().addProperty(o.createVersion(new VersionPropType("2.0")));
    vc.getProperties().addProperty(o.createProdid(new ProdidPropType(PRODID)));
    vc.getComponents().addComponent(o.createVevent(vEvent));
    return vc.toString();
  }

  /**
   * Build an iCalendar VEvent from an Event entity.
   * <p>
   * If a location is configured the location name will be recorded in the
   * vEvent.location field.
   * <p>
   * Developer note: This method includes an indirect dependency upon the
   * Apache.lang HashCodeBuilder method, which is not linked to the library by
   * default.
   *
   * @return an iCalendar VEvent from this Event configuration
   */
  public VeventType vEvent(LocalDate dateStart,
                           LocalDate dateEnd,
                           String uid,
                           boolean allDay,
                           String organizer,
                           String summary,
                           String description,
                           List<String> categories,
                           String classification,
                           String transparency,
                           String rrule,
                           String tzid,
                           String location) {
    VeventType vEvent = new VeventType();

    ObjectFactory o = new ObjectFactory();
    /**
     * Developer note: Set DTSTART/DTEND as DATE if the Event is an all-day
     * event. This will strip the time component. Otherwise set as a DATETIME,
     * which preserves the time component.
     */
    if (allDay) {
      vEvent.getProperties().addProperty(o.createDtstart(new DtstartPropType(dateStart)));
      vEvent.getProperties().addProperty(o.createDtend(new DtendPropType(dateEnd)));
    } else {
      vEvent.getProperties().addProperty(o.createDtstart(new DtstartPropType(dateStart)));
      vEvent.getProperties().addProperty(o.createDtend(new DtendPropType(dateEnd)));
    }
    vEvent.getProperties().addProperty(o.createDtstamp(new DtstampPropType(LocalDateTime.now(ZONE_UTC))));
    vEvent.getProperties().addProperty(o.createCreated(new CreatedPropType(LocalDateTime.now(ZONE_UTC))));
    vEvent.getProperties().addProperty(o.createPriority(new PriorityPropType(5)));
    vEvent.getProperties().addProperty(o.createMethod(MethodPropType.PUBLISH));
    vEvent.getProperties().addProperty(o.createSequence(new SequencePropType(0)));
    vEvent.getProperties().addProperty(o.createUid(new UidPropType(uid)));
    /**
     * Conditionally set the following parameters only if they are present.
     */
    if (isSetProperty(summary)) {
      vEvent.getProperties().addProperty(o.createSummary(new SummaryPropType(summary)));
//      vEvent.getProperty(Property.SUMMARY).getParameters().add(new Language("en-us"));
    }
    if (isSetProperty(description)) {
      vEvent.getProperties().addProperty(o.createDescription(new DescriptionPropType(description)));
    }
    if (isSetProperty(categories)) {
      vEvent.getProperties().addProperty(o.createCategories(new CategoriesPropType(categories)));
    }
    if (classification != null) {
      vEvent.getProperties().addProperty(o.createClass(new ClassPropType(classification)));
    }
    if (transparency != null) {
      vEvent.getProperties().addProperty(o.createTransp(new TranspPropType(transparency)));
    }
    /**
     * Surround the organizer with a try/catch to ensure correct handling of
     * invalid URI entries. The add() method will fail if it cannot create a
     * valid URI. Ignore the error.and keep going.
     */
    if (isSetProperty(organizer)) {
      try {
        vEvent.getProperties().addProperty(o.createOrganizer(new OrganizerPropType(new URI("mailto", organizer, null))));
      } catch (URISyntaxException ex) {
      }
    }
    /**
     * Surround the RRULE with a try/catch to ensure correct handling of
     * Recurrence parse errors. The add() method will fail if it cannot create a
     * valid RRule object. Ignore the error.and keep going.
     */
    if (isSetProperty(rrule)) {
      try {
        vEvent.getProperties().addProperty(o.createRrule(new RrulePropType(new RecurType(rrule))));

      } catch (Exception e) {
        Logger.getLogger(ICalendar.class.getName()).log(Level.WARNING, "Event recurrence error:  {0}", e.getMessage());
      }
    }
    /**
     * Set the Time Zone.
     */
    vEvent.getProperties().addProperty(o.createTzname(new TznamePropType(tzid)));
    /**
     * Set the location if present.
     */
    if (isSetProperty(location)) {
      vEvent.getProperties().addProperty(o.createLocation(new LocationPropType(location)));
    }
    return vEvent;
  }

  private boolean isSetProperty(List<String> property) {
    return property != null && !property.isEmpty();
  }

  private boolean isSetProperty(String property) {
    return property != null && !property.isEmpty();
  }//</editor-fold>

  /**
   * Calculate and return the calculated expiration date (i.e. that last date)
   * of an Event event, accounting for recurrence if configured. If recurrence
   * is not configured then the {@code dateEnd} field is returned.
   *
   * @param dateTime       the event end date
   * @param dateEndMaximum (optional) the maximum duration allowable (set to
   *                       NULL for default of one year)
   * @param recur          a recurrence rule
   * @return the last date of this Event (accounting for recurrence)
   */
  public static ZonedDateTime calculateExpiration(ZonedDateTime dateTime, ZonedDateTime dateEndMaximum, RecurType recur) {
    /**
     * Sanity check.
     */
    if (recur == null) {
      return dateTime;
    }
    /**
     * Event Recurrences should always have an UNTIL or COUNT association but
     * never both. If they do not then force the expiration to +1 year. If the
     * recurrence specified a UNTIL date then use it. Otherwise verify that the
     * COUNT is configured. If it is not configured then return the default
     * expiry from above.
     */
    if (recur.isSetUntil()) {
      if (recur.getUntil().isSetDate()) {
        /**
         * Only a date is provided with no time. We must convert a date to a
         * ZonedDateTime. Set the time to midnight tonight.
         */
        return ZonedDateTime.of(recur.getUntil().getDate(),
                                LocalTime.of(23, 59), // midnight tonight
                                dateTime.getZone());
      } else {
        /**
         * The until is a date-time; easily to transform to a ZonedDateTime.
         */
        return ZonedDateTime.of(recur.getUntil().getDateTime(), dateTime.getZone());
      }
    } else if (recur.isSetCount()) {
      /**
       * Add the number of events.
       */
      /**
       * If an all-day event then set the externally visible time component to 0
       * Internally keep the time component to preserve expected behavior in a
       * scheduling UI when a user toggles allDayEvent on and off.
       */
      int amount = (recur.isSetInterval() ? recur.getInterval() : 0) * (recur.isSetCount() ? recur.getCount() : 0);
      /**
       * Calculate the UNTIL date by adding up each instance.
       */
      return dateTime.plus(amount, recur.getFreq().getTemporalUnit());
    }
    /**
     * Return dateEndMaximum if configured; else return the start date plus 1
     * year.
     */
    return dateEndMaximum != null ? dateEndMaximum : dateTime.plus(1, ChronoUnit.YEARS);
  }

//  Event calculator methods
}
