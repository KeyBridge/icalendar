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
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ejb.Schedule;

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
   *         dates.) // * @throws DatatypeConfigurationException if a PeriodType
   *         fails to build
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
    if (periodEnd.isBefore(eventStart) || periodStart.isAfter(calculateExpiration(ZonedDateTime.of(eventEnd, ZONE_UTC), recurType).toLocalDateTime())) {
      throw new IllegalArgumentException("Event does not contain period of interest.");
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
    if ((pStart.isBefore(eventStart) || pStart.isEqual(eventEnd)) && periodEnd.isAfter(eventStart)) {
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
    while (pStart.isBefore(eventStart)) {
      pStart = pStart.plus(duration);
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
    while (pStart.isBefore(periodEnd)) {
      /**
       * Build a list of candidate DTSTART dates within the current FREQ period.
       * Each candidate LocalDateTime entry corresponding to the original event
       * (or the hour if BYHOUR is set).
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
       * by the FREQ INTERVAL value if present. This tncrements the specified
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

  //<editor-fold defaultstate="collapsed" desc="RRULE Calculators">
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
  private static Set<LocalDateTime> byGeneric(Set<LocalDateTime> dateSet,
                                              Collection<Integer> values,
                                              LocalDateTime periodStart,
                                              BiFunction<LocalDateTime, Integer, LocalDateTime> function) {
    if (values.isEmpty()) {
      return dateSet;
    }
    /**
     * The function indicates a LocalDatetime field and value that should be set
     * in each entry in the dateSet. e.g. LocalDateTime::withDayOfYear
     * <p>
     * byWeekNo: (date, integer) -> date.with(weekFields.weekOfYear(), integer)
     */

    return (dateSet.isEmpty()
            ? Stream.of(periodStart)
            : dateSet.stream()).flatMap(date -> values.stream()
                    .map(integer -> function.apply(date, integer)))
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
  protected static Set<LocalDateTime> bySecond(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getBysecond(), periodStart, LocalDateTime::withSecond);
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
  protected static Set<LocalDateTime> byMinute(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getByminute(), periodStart, LocalDateTime::withMinute);
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
  protected static Set<LocalDateTime> byHour(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getByhour(), periodStart, LocalDateTime::withHour);
  }

  /**
   * Calculate the DAILY recurrence rule. The DAILY rule is very simple: just
   * add the current daily. Developer note: DAILY recurrence should (preferably)
   * have an UNTIL or COUNT, which are handled in the WHILE loop wrapping this
   * method. If UNTIL and COUNT are not specified then the DAILY will return
   * every daily in the period after the event start.
   * <p>
   * This is ONLY called for DAILY type recurrence.
   *
   * @param dateSet     the existing set of candidate dates
   * @param recurType   the recurrence type (not used but present here for
   *                    consistency with other date set generators.
   * @param periodStart the period start
   * @return a non-null HashSet
   */
  protected static Set<LocalDateTime> daily(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    Set<LocalDateTime> set = new HashSet<>();
    if (dateSet.isEmpty()) {
      set.add(LocalDateTime.from(periodStart));
    } else {
      for (LocalDateTime localDateTime : dateSet) {
        set.add(LocalDateTime.from(localDateTime));
      }
    }
    return set;
  }

  /**
   * Calculate the BYDAY rule. The BYDAY rule part specifies a COMMA character
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
  protected static Set<LocalDateTime> byDay(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    if (!recurType.isSetByday()) {
      return dateSet;
    }
    Set<LocalDateTime> set = new HashSet<>();
    if (dateSet.isEmpty()) {
      for (EWeekdayRecurType weekday : recurType.getByday()) {
        set.add(periodStart.with(ChronoField.DAY_OF_WEEK, weekday.getDayOfWeek().getValue()));
      }
    } else {
      for (LocalDateTime localDateTime : dateSet) {
        for (EWeekdayRecurType weekday : recurType.getByday()) {
          set.add(localDateTime.with(ChronoField.DAY_OF_WEEK, weekday.getDayOfWeek().getValue()));
        }
      }
    }
    return set;
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
  protected static Set<LocalDateTime> byWeekNo(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart, WeekFields weekFields) {
    return byGeneric(dateSet,
                     recurType.getByweekno(),
                     periodStart,
                     (date, integer) -> date.with(weekFields.weekOfYear(), integer));
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
  protected static Set<LocalDateTime> byMonth(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
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
  protected static Set<LocalDateTime> byMonthDay(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
    return byGeneric(dateSet, recurType.getBymonthday(), periodStart, LocalDateTime::withDayOfMonth);
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
  protected static Set<LocalDateTime> byYearDay(Set<LocalDateTime> dateSet, RecurType recurType, LocalDateTime periodStart) {
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
   * @param weekFields  the definitions of the daily-of-week, week-of-month and
   *                    week-of-year fields.
   * @return a non-null TreeSet
   */
  public static Set<LocalDateTime> buildCandidateList(RecurType recurType, LocalDateTime periodStart, WeekFields weekFields) {
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
        dateSet.addAll(bySecond(byMinute(byHour(daily(dateSet, recurType, periodStart),
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
      List<LocalDateTime> dates = new ArrayList<>(new TreeSet<>(dateSet));
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
   * Build an iCalendar VEvent from a Schedule entity.
   * <p>
   * If a location is configured the location name will be recorded in the
   * vEvent.location field.
   * <p>
   * Developer note: This method includes an indirect dependency upon the
   * Apache.lang HashCodeBuilder method, which is not linked to the library by
   * default.
   *
   * @return an iCalendar VEvent from this Schedule configuration
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
     * Developer note: Set DTSTART/DTEND as DATE if the schedule is an all-day
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
        Logger.getLogger(Schedule.class.getName()).log(Level.WARNING, "Schedule recurrence error:  {0}", e.getMessage());
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
   * of a Scheduled event, accounting for recurrence if configured. If
   * recurrence is not configured then the {@code dateEnd} field is returned.
   *
   * @param dateTime the event start date
   * @param dateEnd  the event end date
   * @param recur    a recurrence rule
   * @return the last date of this Schedule (accounting for recurrence)
   */
  public static ZonedDateTime calculateExpiration(ZonedDateTime dateTime, RecurType recur) {
    return calculateExpiration(dateTime, null, recur);
  }

  /**
   * Calculate and return the calculated expiration date (i.e. that last date)
   * of a Scheduled event, accounting for recurrence if configured. If
   * recurrence is not configured then the {@code dateEnd} field is returned.
   *
   * @param dateTime       the event end date
   * @param recur          a recurrence rule
   * @param dateEndMaximum the maximum duration allowable (default is one year
   *                       if not configured)
   * @return the last date of this Schedule (accounting for recurrence)
   */
  public static ZonedDateTime calculateExpiration(ZonedDateTime dateTime, ZonedDateTime dateEndMaximum, RecurType recur) {
    /**
     * Sanity check.
     */
    if (recur == null) {
      return dateTime;
    }
    /**
     * Schedule Recurrences should always have an UNTIL or COUNT association but
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
      switch (recur.getFreq()) {
        case SECONDLY:
          return dateTime.plus(amount, ChronoUnit.SECONDS);
        case MINUTELY:
          return dateTime.plus(amount, ChronoUnit.MINUTES);
        case HOURLY:
          return dateTime.plus(amount, ChronoUnit.HOURS);
        case DAILY:
          return dateTime.plus(amount, ChronoUnit.DAYS);
        case WEEKLY:
          return dateTime.plus(amount, ChronoUnit.WEEKS);
        case MONTHLY:
          return dateTime.plus(amount, ChronoUnit.MONTHS);
        case YEARLY:
          return dateTime.plus(amount, ChronoUnit.YEARS);
        default:
          throw new AssertionError(recur.getFreq().name());
      }
    }
    /**
     * Return dateEndMaximum if configured; else return the start date plus 1
     * year.
     */
    return dateEndMaximum != null ? dateEndMaximum : dateTime.plus(1, ChronoUnit.YEARS);
  }

//  Schedule calculator methods
}
