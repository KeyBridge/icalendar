
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

import ietf.params.xml.ns.icalendar.RecurType;
import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * The Event object is designed to enable the recording, persistence and
 * distribution of standardized iCalendar-compatible messages.
 * <p>
 * Event attributes comprise the minimum set necessary to record and recreate a
 * fully qualified iCalendar event that maintains Rules compliant scheduling
 * information while also retaining compatibility with most scheduling software
 * packages including iCal&reg; and Outlook&reg;.
 * <p>
 * The Event entity class may be losslessly converted to and from a
 * standards-compliant iCalendar VEVENT representation as defined in RFC2445.
 * <p>
 * The Event entity enables database persistence and provides simplified
 * serialization for enhanced inter-operability. Event is modeled on the
 * iCalendar 'VEVENT', which provides a grouping of component properties that
 * describe an event that represents a scheduled amount of time on a . For
 * example, it can be an activity; such as a one-hour long, department meeting
 * from 8:00 AM to 9:00 AM, tomorrow. Generally, an event will take up time on
 * an individual . Hence, the event will appear as an opaque interval in a
 * search for busy time. Alternately, the event can have its Time Transparency
 * set to "TRANSPARENT" in order to prevent blocking of the event in searches
 * for busy time.
 * <p>
 * The "VEVENT" is also the component used to specify an anniversary or daily
 * reminder within a . These events have a DATE value type for the "DTSTART"
 * property instead of the default data type of DATE-TIME. If such a "VEVENT"
 * has a "DTEND" property, it MUST be specified as a DATE value also. The
 * anniversary type of "VEVENT" can span more than one date (i.e, "DTEND"
 * property value is set to a date after the "DTSTART" property value).
 * <p>
 * The "DTSTART" property for a "VEVENT" specifies the inclusive Start of the
 * event. For recurring events, it also specifies the very first instance in the
 * recurrence set. The "DTEND" property for a "VEVENT" component specifies the
 * non-inclusive calendarEnd of the event. For cases where a "VEVENT" component
 * specifies a "DTSTART" property with a DATE data type but no "DTEND" property,
 * the events non-inclusive calendarEnd is the calendarEnd of the date specified
 * by the "DTSTART" property. For cases where a "VEVENT" component specifies a
 * "DTSTART" property with a DATE-TIME data type but no "DTEND" property, the
 * event calendarEnds on the same date and time of day specified by the
 * "DTSTART" property.
 * <p>
 * The "VEVENT" component cannot be nested within another component. However,
 * "VEVENT" components can be related to each other or to a "VTODO" or to a
 * "VJOURNAL" component with the "RELATED-TO" property. <h2>Validation</h2> <ul>
 * <li>The dateEnd attribute must follow the dateStart attribute.</li> <li>A day
 * is defined as beginning at midnight and calendarEnding at one second before
 * midnight on the same day: From 0:00:00 to 23:59:59.</li>
 * <li>If a recurrence rule rrule attribute is present the dateExpiration
 * attribute must be calculated.</li> <li>The time zone tzid attribute is always
 * required. </li> <li>Three-character time zone notation (e.g. “EDT”) is not
 * supported</li> <li>If more than one category is indicated they must be
 * formatted as comma-delimited text with no spaces. For example:
 * “CATEGORIES:WHITESPACE,LICENSED,LPTV”.</li> <li>The RDATE and EXDATE
 * parameters are not supported by this implementation. If present they must be
 * ignored.</li>
 * <li>Within a iCalendar event the following constraints are placed on the
 * recurrence rule rrule attribute: <ul> <li>Valid FREQ values are: HOURLY,
 * DAILY, WEEKLY, MONTHLY, YEARLY</li> <li>SECONDLY and MINUTELY FREQ values are
 * not supported</li> <li>BYSECOND and BYMINUTE rule parts are not
 * supported</li> <li>The week Start parameter WKST is defined as Monday
 * (“MO”)</li> <li>BYSETPOS is limited to a maximum of one single integer value.
 * It is an ERROR to provide more than one value.</li>
 * <li> BYSETPOS may only be used with a MONTHLY recurrence frequency.</li>
 * </ul> </li> <li>If the allDayEvent attribute is set to “TRUE” then the
 * schedule times must be set to begin at 0:00:00 and calendarEnd at 23:59:59 on
 * the respective Start and calendarEnd dates.</li> </ul>
 *
 * @see <a href="http://tools.ietf.org/html/rfc5545">Internet Calendaring and
 * Scheduling</a>
 * @author Jesse Caulfield
 * @since 1.0.0 created 06/05/2012
 * @since 2.3.1 copied 11/28/17 into iCalendar from lib-sas-entity
 */
public class Event implements Comparable<Event>, Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * "UTC". Coordinated Universal Time.
   * <p>
   * Used to normalize all calendar instances to UTC. e.g.
   * 2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z. Implements
   * W3C XML Schema Part 2, Section 3.2.7.3 (A)
   * <p>
   * Coordinated Universal Time, abbreviated to UTC, is the primary time
   * standard by which the world regulates clocks and time. It is within about 1
   * second of mean solar time at 0° longitude; it does not observe daylight
   * saving time.
   */
  private static final ZoneId ZONE_UTC = ZoneId.of("UTC");

  /**
   * "EEEE, MMMM dd yyyy KK:mm a"
   * <p>
   * Formatter for pretty printing date-time objects. e.g.
   * {@code "Tuesday, July 18 2017 04:15 PM"}
   */
  private static final String DATE_FORMAT_12HR = "EEEE, MMMM dd yyyy KK:mm a";
  /**
   * "EEEE, MMMM dd yyyy kk:mm z"
   * <p>
   * Formatter for pretty printing date-time objects. e.g.
   * {@code "Wednesday, August 02 2017 14:33 EDT"}
   */
  private static final String DATE_FORMAT_24HR_TIMEZONE = "EEEE, MMMM dd yyyy kk:mm z";

  /**
   * An automatically generated database record id. This is the database record
   * primary key id.
   */
  private Long id;

  /**
   * The "DTSTART" property for a "VEVENT" specifies the inclusive Start of the
   * event. For recurring events, it also specifies the very first instance in
   * the recurrence set.
   * <p>
   * The value is specified in the UTC Time Zone.
   */
  private ZonedDateTime dateStart;
  /**
   * The "DTEND" property for a "VEVENT" component specifies the non-inclusive
   * calendarEnd of the event.
   * <p>
   * For cases where a "VEVENT" component specifies a "DTSTART" property with a
   * DATE data type but no "DTEND" property, the events non-inclusive
   * calendarEnd is the calendarEnd of the date specified by the "DTSTART"
   * property. For cases where a "VEVENT" component specifies a "DTSTART"
   * property with a DATE-TIME data type but no "DTEND" property, the event
   * calendarEnds on the same date and time of day specified by the "DTSTART"
   * property.
   * <p>
   * The value is specified in the UTC Time Zone.
   */
  private ZonedDateTime dateEnd;
  /**
   * The schedule display Time Zone. (Optional) If not specifically configured
   * otherwise the default {@code UTC} time zone is always returned.
   */
  private ZoneId zone;

  /**
   * This property defines the persistent, globally unique identifier for the
   * component.
   * <p>
   * The UID itself MUST be a globally unique identifier. The generator of the
   * identifier MUST guarantee that the identifier is unique. There are several
   * algorithms that can be used to accomplish this. The identifier is
   * RECOMMENDED to be the identical syntax to the [RFC 822] addr-spec. A good
   * method to assure uniqueness is to put the domain name or a domain literal
   * IP address of the host on which the identifier was created on the right
   * hand side of the "&amp;", and on the left hand side, put a combination of
   * the current date and time of day (i.e., formatted in as a DATE-TIME value)
   * along with some other currently unique (perhaps sequential) identifier
   * available on the system (for example, a process id number). Using a
   * date/time value on the left hand side and a domain name or domain literal
   * on the right hand side makes it possible to guarantee uniqueness since no
   * two hosts should be using the same domain name or IP address at the same
   * time. Though other algorithms will work, it is RECOMMENDED that the right
   * hand side contain some domain identifier (either of the host itself or
   * otherwise) such that the generator of the message identifier can guarantee
   * the uniqueness of the left hand side within the scope of that domain.
   * <p>
   * This identifier is created by the system that generates an iCalendar
   * object.
   * <p>
   * Implementations MUST be able to receive and persist values of at least 255
   * characters for this property.
   * <p>
   * Ihe "UID" and "DTSTAMP" properties are specified to assist in proper
   * sequencing of multiple free/busy time requests.
   */
  private String uuid;

  /**
   * This property specifies the date and time that the information was created
   * by the user agent in the store.
   * <p>
   * The time zone for this field is the system time zone.
   * <p>
   * Developer note: This is analogous to the creation date and time for a file
   * in the file system.
   */
  private LocalDateTime created;

  /**
   * This is the iCalendar 'CLASS' field, but is renamed to 'classification' as
   * 'class' is a reserved word in Java.
   * <p>
   * This property corresponds to the iCalendar property “CLASS” which defines
   * the access classification for a component. Examples include "PUBLIC",
   * "PRIVATE", and “CONFIDENTIAL".
   * <p>
   * An access classification is only one component of the general security
   * system within a application. It provides a method of capturing the scope of
   * the access the owner for information within an individual entry. The access
   * classification of an individual iCalendar component is useful when measured
   * along with the other security components of a system (e.g., user
   * authentication, authorization, access rights, access role, etc.). Hence,
   * the semantics of the individual access classifications cannot be completely
   * defined by this memo alone. Additionally, due to the "blind" nature of most
   * exchange processes using this memo, these access classifications cannot
   * serve as an enforcement statement for a system receiving an iCalendar
   * object. Rather, they provide a method for capturing the intention of the
   * owner for the access to the component.
   */
  private EClassification classification;

  /**
   * The property defines the organizer for a component. Non-standard, language,
   * common name, directory entry reference, sent by property parameters can be
   * specified on this property.
   * <p>
   * This property MUST be specified in an iCalendar object that specifies a
   * group scheduled entity. This property MUST be specified in an iCalendar
   * object that specifies the publication of a user's busy time. This property
   * MUST NOT be specified in an iCalendar object that specifies only a time
   * zone definition or that defines entities that are not group scheduled
   * entities, but are entities only on a single user's .
   * <p>
   * The property has the property parameters CN, for specifying the common or
   * display name associated with the "Organizer", DIR, for specifying a pointer
   * to the directory information associated with the "Organizer", SENT-BY, for
   * specifying another user that is acting on behalf of the "Organizer". The
   * non-standard parameters may also be specified on this property. If the
   * LANGUAGE property parameter is specified, the identified language applies
   * to the CN parameter value.
   * <p>
   * Example: The following is an example of this property:
   * <br>ORGANIZER;CN=John Smith:MAILTO:jsmith &#64;host1.com
   */
  private String organizer;
  /**
   * The property defines the relative priority for a component. Non-standard
   * property parameters can be specified on this property.
   * <p>
   * Developer note: The default implementation value is 0 (zero) = undefined
   * priority.
   * <p>
   * The priority is specified as an integer in the range zero to nine. A value
   * of zero (US-ASCII decimal 48) specifies an undefined priority. A value of
   * one (US-ASCII decimal 49) is the highest priority. A value of two (US-ASCII
   * decimal 50) is the second highest priority. Subsequent numbers specify a
   * decreasing ordinal priority. A value of nine (US-ASCII decimal 58) is the
   * lowest priority.
   * <p>
   * A CUA with a three-level priority scheme of "HIGH", "MEDIUM" and "LOW" is
   * mapped into this property such that a property value in the range of one
   * (US-ASCII decimal 49) to four (US-ASCII decimal 52) specifies "HIGH"
   * priority. A value of five (US-ASCII decimal 53) is the normal or "MEDIUM"
   * priority. A value in the range of six (US- ASCII decimal 54) to nine
   * (US-ASCII decimal 58) is "LOW" priority.
   * <p>
   * A CUA with a priority schema of "A1", "A2", "A3", "B1", "B2", ..., "C3" is
   * mapped into this property such that a property value of one (US-ASCII
   * decimal 49) specifies "A1", a property value of two (US- ASCII decimal 50)
   * specifies "A2", a property value of three (US-ASCII decimal 51) specifies
   * "A3", and so forth up to a property value of 9 (US-ASCII decimal 58)
   * specifies "C3".
   * <p>
   * Other integer values are reserved for future use.
   * <p>
   * Within a "VEVENT" component, this property specifies a priority for the
   * event. This property may be useful when more than one event is scheduled
   * for a given time period.
   */
  private Integer priority;

  /**
   * This property defines whether an event is transparent or not to busy time
   * searches. It corresponds to the Time Transparency iCalendar field.
   * <p>
   * Time Transparency is the characteristic of an event that determines whether
   * it appears to consume time on a . Events that consume actual time for the
   * individual or resource associated with the SHOULD be recorded as OPAQUE,
   * allowing them to be detected by free-busy time searches. Other events,
   * which do not take up the individual's (or resource's) time SHOULD be
   * recorded as TRANSPARENT, making them invisible to free-busy time searches.
   */
  private ETransparency transparency;
  /**
   * This property is an extension field the identifies whether the Schedule
   * represents an all day (e.g. 24-hour) event.
   * <p>
   * The default implementation value is false.
   */
  private boolean allDayEvent = false;

  /**
   * Boolean indicator that this schedule has recurrence information. If set to
   * TRUE then the {@link #recurType} should be parsed and used. If set to to
   * FALSE then the {@link #recurType} should be ignored.
   * <p>
   * Default is FALSE.
   */
  private boolean recurrence = false;
  /**
   * The recurrence object. This transient field is populated in postConstruct
   * and populated the RRule on setting.
   */
  private RecurType recurType;

  /**
   * The (unique set of) categories for this event.
   * <p>
   * The categories are useful in searching for a component of a particular type
   * and category.
   * <p>
   * More than one category can be specified as a list of categories separated
   * by the COMMA character (US-ASCII decimal 44). Some possible English values
   * for "CATEGORIES" property include: "ANNIVERSARY", "APPOINTMENT",
   * "BUSINESS", "EDUCATION", "HOLIDAY", "MEETING", "MISCELLANEOUS",
   * "NON-WORKING HOURS", "NOT IN OFFICE", "PERSONAL", "PHONE CALL", "SICK DAY",
   * "SPECIAL OCCASION", "TRAVEL", and " VACATION". Categories can be specified
   * in any registered language.
   * <p>
   * This property defines the categories for a component.
   * <p>
   * Non-standard and language property parameters can be specified on this
   * property. This property may be used to specify categories or subtypes of
   * the component. The categories are useful in searching for a component of a
   * particular type and category.
   * <p>
   * Developer note: Use the {@link #addCategory(java.lang.String) } and
   * {@link #getCategories() } methods to manage the categories.
   */
  private Collection<String> categories;
  /**
   * A short, one line summary about the activity or journal entry. This
   * property defines a short summary or subject for the component.
   * <p>
   * This property is used to capture a short, one line summary about the
   * activity or journal entry.
   */
  private String summary;
  /**
   * A complete description of the component than that provided by the "SUMMARY"
   * property, [and is used in the "VEVENT" to] capture lengthy textual
   * descriptions associated with the activity
   * <p>
   * If a description is not set this returns a pretty-print description of the
   * Start and calendarEnd date plus recurrence.
   * <p>
   * This property provides a more complete description of the component than
   * that provided by the "SUMMARY" property, [and is used in the "VEVENT" to]
   * capture lengthy textual descriptions associated with the activity.
   * <p>
   * Non-standard, alternate text representation and language property
   * parameters can be specified on this property. This property is used to
   * capture lengthy textual descriptions associated with the activity.
   */
  private String description;
  /**
   * The location of this scheduled event. This is typically either a free-text
   * description or address.
   * <p>
   * The property defines the venue for the activity defined by a component.
   * <p>
   * Specific venues such as conference or meeting rooms may be explicitly
   * specified using this property. An alternate representation may be specified
   * that is a URI that points to directory information with more structured
   * specification of the location.
   * <p>
   * This provides an option to associate a location with this Schedule.
   */
  private String location;

  /**
   * Default no-arg constructor. This should only be called by JPA.
   */
  public Event() {
    this.created = LocalDateTime.now(Clock.systemUTC());
  }

  /**
   * Build a regular schedule with the indicated Start/calendarEnd dates and
   * times. The returned Schedule is NOT configured as all day.
   * <p>
   * If the dateEnd parameter is set to NULL then a default 1-hour duration is
   * configured.
   *
   * @param dateStart the Start date and time in the indicated time zone.
   * @param dateEnd   the End date and time.
   * @return a Schedule instance with the desired configuration
   */
  public static Event getInstance(ZonedDateTime dateStart, ZonedDateTime dateEnd) {
    Event s = new Event();
    s.setDateStart(dateStart);
    s.setDateEnd(dateEnd);
    s.setZoneSameInstant(dateStart.getZone());
    return s;
  }

  /**
   * Build a regular schedule with the indicated Start/calendarEnd dates and
   * times. The returned Schedule is NOT configured as all day.
   * <p>
   * If the dateEnd parameter is set to NULL then a default 1-hour duration is
   * configured.
   *
   * @param dateStart the Start date and time in the indicated time zone.
   * @param dateEnd   the End date and time.
   * @param timeZone  (Optional) the time zone (defaults to UTC)
   * @return a Schedule instance with the desired configuration
   */
  public static Event getInstance(LocalDateTime dateStart, LocalDateTime dateEnd, ZoneId timeZone) {
    return getInstance(ZonedDateTime.of(dateStart, timeZone), ZonedDateTime.of(dateEnd, timeZone));
  }

  /**
   * Build a regular schedule with the indicated Start date and duration amount
   * times. Duration is configured as a static Calendar field type and amount.
   * <p>
   * Adds the specified amount of time to the given calendar field, based on the
   * calendar's rules. For example, to set a duration of 5 days use
   * (Calendar.DAY_OF_MONTH, 5).
   *
   * @param dateStart      the Start date and time in the indicated time zone.
   * @param temporalUnit   the duration calendar field. e.g.
   *                       {@code ChronoUnit.MINUTES}.
   * @param durationAmount the duration amount to be added in increments of the
   *                       declared calendar field unit.
   * @return a Schedule instance with the desired configuration
   * @throws IllegalArgumentException if the duration amount is zero or negative
   */
  public static Event getInstance(ZonedDateTime dateStart, TemporalUnit temporalUnit, long durationAmount) {
    if (durationAmount <= 0) {
      throw new IllegalArgumentException("Duration must be a positive number.");
    }
    return getInstance(dateStart, dateStart.plus(durationAmount, temporalUnit));
  }

  /**
   * Build a regular schedule with the indicated Start date and duration amount
   * times. Duration is configured as a static Calendar field type and amount.
   * <p>
   * Adds the specified amount of time to the given calendar field, based on the
   * calendar's rules. For example, to set a duration of 5 days use
   * (Calendar.DAY_OF_MONTH, 5).
   *
   * @param dateStart      the Start date and time in the indicated time zone.
   * @param temporalUnit   the duration calendar field. e.g.
   *                       {@code ChronoUnit.MINUTES}.
   * @param durationAmount the duration amount to be added in increments of the
   *                       declared calendar field unit.
   * @return a Schedule instance with the desired configuration
   * @throws IllegalArgumentException if the duration amount is zero or negative
   */
  public static Event getInstance(LocalDateTime dateStart, TemporalUnit temporalUnit, long durationAmount) {
    if (durationAmount <= 0) {
      throw new IllegalArgumentException("Duration must be a positive number.");
    }
    return getInstance(ZonedDateTime.of(dateStart, ZONE_UTC),
                       ZonedDateTime.of(dateStart.plus(durationAmount, temporalUnit), ZONE_UTC));
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  /**
   * Get the database record id.
   *
   * @return a numerical database record id.
   */
  public Long getId() {
    return id;
  }

  /**
   * Set the database record id. Note:
   *
   * @param id a numerical database record id.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get the "DTSTART" property for a "VEVENT", which specifies the inclusive
   * Start of the event. For recurring events, it also specifies the very first
   * instance in the recurrence set.
   * <p>
   * The value is specified in the UTC Time Zone.
   *
   * @return the "DTSTART" property for a "VEVENT" configured for the UTC time
   *         zone.
   */
  public ZonedDateTime getDateStart() {
    return dateStart;
  }

  /**
   * Set the "DTSTART" property for a "VEVENT", which specifies the inclusive
   * Start of the event. For recurring events, it also specifies the very first
   * instance in the recurrence set.
   * <p>
   * The value MUST be specified in the UTC Time Zone.
   *
   * @param dateStart the "DTSTART" property for a "VEVENT" configured for the
   *                  UTC time zone.
   */
  public void setDateStart(ZonedDateTime dateStart) {
    this.dateStart = dateStart;
    /**
     * 07/06/17 - require valid start/end dates.
     * <p>
     * Deprecated 07/06/17: UI logic should detect and prevent this. Couple the
     * start and end times. If dtEnd is set and user is changing dtStart then
     * update dtEnd to ensure dtEnd is not before dtStart. This is useful for
     * date select UI components.
     */
    if (dateStart != null && dateEnd != null && dateEnd.isBefore(dateStart)) {
      throw new IllegalArgumentException("Negative interval error: Cannot set start date after end date. [" + dateStart + "] is after [" + dateEnd + "]");
    }
  }

  /**
   * Get the "DTEND" property for a "VEVENT" component specifies the
   * non-inclusive END of the event; the event may continue if a recurrence is
   * configured.
   * <p>
   * The value is specified in the UTC Time Zone.
   *
   * @return the end of the event configured for the UTC time zone.
   */
  public ZonedDateTime getDateEnd() {
    return dateEnd;
  }

  /**
   * Set the "DTEND" property for a "VEVENT" component using a Date format.
   * <p>
   * The value MUST be specified in the UTC Time Zone.
   *
   * @param dateEnd the end of the event configured for the UTC time zone.
   */
  public void setDateEnd(ZonedDateTime dateEnd) {
    this.dateEnd = dateEnd;
    /**
     * Ensure dtEnd is not before dtStart.
     * <p>
     * Deprecated 07/06/17: If the user is making an error and sets the END time
     * to the START time then back up the start time by one hour. e.g. set the
     * duration to 1 hour ending at the selected end time. Important: UI logic
     * should detect and prevent this.
     */
    if (dateEnd != null && dateStart != null && dateStart.isAfter(dateEnd)) {
      throw new IllegalArgumentException("Negative interval error: Cannot set end date before start date. [" + dateEnd + "] is before [" + dateStart + "]");
    }
  }

  /**
   * Get the Recurrence Rule. This is used to identify properties that contain a
   * recurrence rule specification.
   * <p>
   * Developer note: This bean field is not accessed directly. Instead it is
   * automatically converted to/from an iCalendar Recur object on postLoad and
   * set events.
   * <p>
   * Recurrence rules may generate recurrence instances with an invalid date
   * (e.g., February 30) or nonexistent local time (e.g., 1:30 AM on a day where
   * the local time is moved forward by an hour at 1:00 AM). Such recurrence
   * instances MUST be ignored and MUST NOT be counted as part of the recurrence
   * set.
   * <p>
   * Information, not contained in the rule, necessary to determine the various
   * recurrence instance Start time and dates are derived from the Start Time
   * ("DTSTART") component attribute. For example, "FREQ=YEARLY;BYMONTH=1"
   * doesn't specify a specific day within the month or a time. This information
   * would be the same as what is specified for "DTSTART".
   * <p>
   * Developer note: <strong>RDATE AND EXDATE ATTRIBUTES ARE NOT
   * SUPPORTED.</strong> If present the RDATE and EXDATE parameters must be
   * ignored. The {@code rrule} attribute definition is provided here with
   * divergences from RFC noted by strike-through: <br> <em>3.8.5.3. Recurrence
   * Rule This rrule attribute defines a rule or repeating pattern for recurring
   * events or time zone definitions. The recurrence rule, if specified, is used
   * in computing the recurrence set. The recurrence set is the complete set of
   * recurrence instances for a component. The recurrence set is generated by
   * considering the initial "DTSTART" property along with the "RRULE", "RDATE",
   * and "EXDATE" properties contained within the recurring component. The
   * "DTSTART" property defines the first instance in the recurrence set. The
   * "DTSTART" property value SHOULD be synchronized with the recurrence rule,
   * if specified. The recurrence set generated with a "DTSTART" property value
   * not synchronized with the recurrence rule is undefined. The final
   * recurrence set is generated by gathering all of the Start DATE-TIME values
   * generated by any of the specified "RRULE" and "RDATE" properties, and then
   * excluding any Start DATE-TIME values specified by "EXDATE" properties</em>.
   *
   * @return a non-null, possibly empty {@code RecurType} instance.
   */
  public RecurType getRecurType() {
    if (recurType == null) {
      recurType = new RecurType();
    }
    return recurType;
  }

  /**
   * Set the Schedule rrule parameter using an iCal4j Recur instance. If a null
   * instance is given then the internal rrule field is set to an empty
   * (non-null) string.
   *
   * @param recurType a Recurrence instance
   */
  public void setRecurType(RecurType recurType) {
    this.recurType = recurType;
    this.recurrence = recurType != null;
  }

  /**
   * Set the Recurrence Rule. This is used to identify properties that contain a
   * recurrence rule specification.
   * <p>
   * Developer note: In general the <code>rrule</code> should not be set
   * directly. Instead prefer to set the <code>recur</code> field.
   *
   * @param rrule a RRule string. For example, "FREQ=YEARLY;BYMONTH=1"
   * @return the schedule instance
   * @throws java.lang.Exception if the input rule cannot be parsed
   */
  public Event withRecurrence(String rrule) throws Exception {
    setRecurType(new RecurType(rrule));
    return this;
  }

  /**
   * Indicate whether the Recurrence rule is configured.
   *
   * @return TRUE if the {@code rrule} is configured.
   */
  public boolean hasRecur() {
    return this.recurType != null;
  }

  /**
   * Get the schedule display Time Zone. (Optional) If not specifically
   * configured otherwise the default {@code UTC} time zone is always returned.
   * <p>
   * This is the user local time zone. The {@code #dateStart} and
   * {@link #dateEnd} fields are stored using the {@code UTC} time zone and
   * should be translated to this local time zone for display.
   * <p>
   * Defaults to UTC unless otherwise specifically configured by the user.
   * <p>
   * This field specifies the Time Zone identifier from a time zone database or
   * registry. The 'tzid' parameter must be set from a valid java.util.TimeZone
   * id. e.g. 'America/New_York'. The persisted String value of this field is
   * typically not directly accessible. Rather, the field getter and setter
   * automatically convert to and from a java.util.TimeZone representation.
   *
   * @return a non-null TimeZone instance. {@code UTC America/New_York} is
   *         returned by default if not otherwise configured.
   */
  public ZoneId getZoneId() {
    return zone == null ? ZONE_UTC : zone;
  }

  /**
   * Set the schedule display Time Zone.
   * <p>
   * This method changes the time-zone and retains the local date-time. This
   * method ONLY sets the time zone and does NOT adjust the start and end clock
   * times. The time zone is changed but the local time is preserved. For
   * example: 2:00 EST will become 2:00 PST.
   *
   * @param zone the time zone instance
   */
  public void setZoneSameLocal(ZoneId zone) {
    if (zone != null) {
      dateStart = dateStart.withZoneSameLocal(zone);
      dateEnd = dateEnd.withZoneSameLocal(zone);
    }
    this.zone = zone;
  }

  /**
   * Set the schedule display Time Zone.
   * <p>
   * This method changes the time-zone and retains the instant. This normally
   * results in a change to the local date-time. This method is based on
   * retaining the same instant, thus gaps and overlaps in the local time-line
   * have no effect on the result. This method sets the time zone and adjusts
   * the start and end clock times. The time zone is changed but the local time
   * is preserved. For example: 14:00 EST will become 11:00 PST.
   *
   * @param zone the time zone instance
   */
  public void setZoneSameInstant(ZoneId zone) {
    if (zone != null) {
      dateStart = dateStart.withZoneSameInstant(zone);
      dateEnd = dateEnd.withZoneSameInstant(zone);
    }
    this.zone = zone;
  }

  /**
   * Get the time zone ID.
   *
   * @return the time zone id. null if no time zone it set.
   */
  public String getTzid() {
    return getZoneId().getId();
  }

  /**
   * Set the time zone by providing a String ID. This will be automatically
   * converted to a java.time.ZoneId. This is a convenience shortcut to
   * {@link #setZoneSameLocal(java.time.ZoneId) }
   * <p>
   * Developer note: This method fails silently. If the ID is invalid or
   * conversion to a java.util.TimeZone fails the <em>tzid</em> field will be
   * set to null and no error will be posted.
   *
   * @param tzid a valid time zone ID.
   */
  public void setTzid(String tzid) {
    try {
      setZoneSameLocal(ZoneId.of(tzid));
    } catch (Exception exception) {
      setZoneSameLocal(null);
    }
  }

  /**
   * Get the persistent, globally unique identifier for the component. If not
   * set a random UUID is assigned.
   *
   * @return the globally unique identifier
   */
  public String getUuid() {
    if (uuid == null) {
      this.uuid = UUID.randomUUID().toString();
    }
    return uuid;
  }

  /**
   * Set the persistent, globally unique identifier for the component.
   *
   * @param uuid the globally unique identifier
   */
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /**
   * Get the (concatenated list of) categories for this event.
   * <p>
   * The categories are useful in searching for a component of a particular type
   * and category.
   * <p>
   * More than one category can be specified as a list of categories separated
   * by the COMMA character (US-ASCII decimal 44). Some possible English values
   * for "CATEGORIES" property include: "ANNIVERSARY", "APPOINTMENT",
   * "BUSINESS", "EDUCATION", "HOLIDAY", "MEETING", "MISCELLANEOUS",
   * "NON-WORKING HOURS", "NOT IN OFFICE", "PERSONAL", "PHONE CALL", "SICK DAY",
   * "SPECIAL OCCASION", "TRAVEL", and " VACATION". Categories can be specified
   * in any registered language.
   * <p>
   * This property defines the categories for a component.
   * <p>
   * Non-standard and language property parameters can be specified on this
   * property. This property may be used to specify categories or subtypes of
   * the component. The categories are useful in searching for a component of a
   * particular type and category.
   * <p>
   * Developer note: Use the {@link #addCategory(java.lang.String) } and
   * {@link #getCategories() } methods to manage the categories.
   *
   * @return A non-null HashSet of categories
   */
  public Collection<String> getCategories() {
    if (categories == null) {
      categories = new HashSet<>();
    }
    return categories;
  }

  /**
   * Set the (concatenated list of) categories for this event.
   *
   * @param categories A collection of categories
   */
  public void setCategories(Collection<String> categories) {
    this.categories = new HashSet<>(categories);
  }

  /**
   * Get the date and time that the information was created by the user agent in
   * the calendar store.
   *
   * @return the date-time stamp when this schedule was created
   */
  public LocalDateTime getCreated() {
    return created;
  }

  /**
   * Set the date and time that the information was created by the user agent in
   * the calendar store.
   * <p>
   * This value is automatically set in the object constructor and users should
   * have nary a reason to set it manually.
   *
   * @param created the date-time stamp when this schedule was created
   */
  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  /**
   * Get the iCalendar “CLASS” property which defines the access classification
   * for a component. Examples include "PUBLIC", "PRIVATE", and “CONFIDENTIAL".
   *
   * @return the iCalendar “CLASS” property
   */
  public EClassification getClassification() {
    return classification;
  }

  /**
   * Set the iCalendar “CLASS” property which defines the access classification
   * for a component.
   *
   * @param classification the iCalendar “CLASS” property. e.g. "PUBLIC",
   *                       "PRIVATE", “CONFIDENTIAL".
   */
  public void setClassification(EClassification classification) {
    this.classification = classification;
  }

  /**
   * Get a more complete description of the component than that provided by the
   * "SUMMARY" property, [and is used in the "VEVENT" to] capture lengthy
   * textual descriptions associated with the activity
   * <p>
   * If a description is not set this returns a pretty-print description of the
   * Start and calendarEnd date plus recurrence.
   * <p>
   * This property provides a more complete description of the component than
   * that provided by the "SUMMARY" property, [and is used in the "VEVENT" to]
   * capture lengthy textual descriptions associated with the activity.
   * <p>
   * Non-standard, alternate text representation and language property
   * parameters can be specified on this property. This property is used to
   * capture lengthy textual descriptions associated with the activity.
   *
   * @return a non-null, non-empty description of this entry.
   */
  public String getDescription() {
    return description != null
           ? description
           : "From " + dateStart.toLocalDate().format(DateTimeFormatter.ISO_DATE)
      + " to " + dateEnd.toLocalDate().format(DateTimeFormatter.ISO_DATE)
      + (hasRecur() ? recurType.toString() : "");
  }

  /**
   * Set a more complete description of the component than that provided by the
   * "SUMMARY" property, [and is used in the "VEVENT" to] capture lengthy
   * textual descriptions associated with the activity
   * <p>
   * This property provides a more complete description of the component than
   * that provided by the "SUMMARY" property, [and is used in the "VEVENT" to]
   * capture lengthy textual descriptions associated with the activity.
   * <p>
   * Non-standard, alternate text representation and language property
   * parameters can be specified on this property. This property is used to
   * capture lengthy textual descriptions associated with the activity.
   *
   * @param description a complete description of this entry.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Get the organizer for a component. Non-standard, language, common name,
   * directory entry reference, sent by property parameters can be specified on
   * this property.
   * <p>
   * This property MUST be specified in an iCalendar object that specifies a
   * group scheduled entity. This property MUST be specified in an iCalendar
   * object that specifies the publication of a user's busy time. This property
   * MUST NOT be specified in an iCalendar object that specifies only a time
   * zone definition or that defines entities that are not group scheduled
   * entities, but are entities only on a single user.
   * <p>
   * The property has the property parameters CN, for specifying the common or
   * display name associated with the "Organizer", DIR, for specifying a pointer
   * to the directory information associated with the "Organizer", SENT-BY, for
   * specifying another user that is acting on behalf of the "Organizer". The
   * non-standard parameters may also be specified on this property. If the
   * LANGUAGE property parameter is specified, the identified language applies
   * to the CN parameter value.
   * <p>
   * Example: The following is an example of this property:
   * <br>ORGANIZER;CN=John Smith:MAILTO:jsmith &#64;host1.com
   * <p>
   * This is typically the owner email address.
   *
   * @return the organizer
   */
  public String getOrganizer() {
    return organizer;
  }

  /**
   * Set the organizer for a component. Non-standard, language, common name,
   * directory entry reference, sent by property parameters can be specified on
   * this property.
   * <p>
   * This property MUST be specified in an iCalendar object that specifies a
   * group scheduled entity. This property MUST be specified in an iCalendar
   * object that specifies the publication of a user's busy time. This property
   * MUST NOT be specified in an iCalendar object that specifies only a time
   * zone definition or that defines entities that are not group scheduled
   * entities, but are entities only on a single user.
   * <p>
   * The property has the property parameters CN, for specifying the common or
   * display name associated with the "Organizer", DIR, for specifying a pointer
   * to the directory information associated with the "Organizer", SENT-BY, for
   * specifying another user that is acting on behalf of the "Organizer". The
   * non-standard parameters may also be specified on this property. If the
   * LANGUAGE property parameter is specified, the identified language applies
   * to the CN parameter value.
   * <p>
   * Example: The following is an example of this property:
   * <br>ORGANIZER;CN=John Smith:MAILTO:jsmith &#64;host1.com the organizer for
   * this component.
   * <p>
   * This is typically the owner email address.
   *
   * @param organizer the organizer
   */
  public void setOrganizer(String organizer) {
    this.organizer = organizer;
  }

  /**
   * Get the relative priority for a component.
   * <p>
   * The priority is specified as an integer in the range zero to nine. A value
   * of zero is an undefined priority. A value of one is the highest priority.
   *
   * @return the relative priority for a component
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * Set the relative priority for a component.
   * <p>
   * A value of zero is an undefined priority. A value of one is the highest
   * priority. A value of nine is the lowest priority.
   *
   * @param priority the relative priority for a component as an integer in the
   *                 range zero to nine
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  /**
   * Get a short, one line summary about the activity or journal entry. This
   * property defines a short summary or subject for the component.
   * <p>
   * This property is used to capture a short, one line summary about the
   * activity or journal entry.
   *
   * @return a brief one-line event summary or the Start date.
   */
  public String getSummary() {
    return summary;
  }

  /**
   * Set a short, one line summary about the activity or journal entry. This
   * property defines a short summary or subject for the component.
   * <p>
   * This property is used to capture a short, one line summary about the
   * activity or journal entry.
   *
   * @param summary e.g. a one-line event name.
   */
  public void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Get the transparency indicator corresponding to the Time Transparency
   * iCalendar field.
   * <p>
   * Events that consume actual time SHOULD be recorded as OPAQUE while Events
   * which do not take up time SHOULD be recorded as TRANSPARENT.
   *
   * @return the transparency indicator
   */
  public ETransparency getTransparency() {
    return transparency;
  }

  /**
   * Set the transparency indicator corresponding to the Time Transparency
   * iCalendar field.
   * <p>
   * Events that consume actual time SHOULD be recorded as OPAQUE while Events
   * which do not take up time SHOULD be recorded as TRANSPARENT.
   *
   * @param transparency the transparency indicator: OPAQUE or TRANSPARENT
   */
  public void setTransparency(ETransparency transparency) {
    this.transparency = transparency;
  }

  /**
   * Determine if this schedule is an all day event.
   *
   * @return TRUE if event is all day (24 hrs).
   */
  public boolean isAllDayEvent() {
    return allDayEvent;
  }

  /**
   * Set this schedule to an all day event.
   *
   * @param allDayEvent TRUE if event is all day (24 hrs).
   */
  public void setAllDayEvent(boolean allDayEvent) {
    this.allDayEvent = allDayEvent;
  }

  /**
   * Get the location of this scheduled event. This is typically either a
   * free-text description or address.
   * <p>
   * The property defines the venue for the activity defined by a component.
   * <p>
   * Specific venues such as conference or meeting rooms may be explicitly
   * specified using this property. An alternate representation may be specified
   * that is a URI that points to directory information with more structured
   * specification of the location.
   * <p>
   * This provides an option to associate a location with this Schedule.
   *
   * @return the schedule event location
   */
  public String getLocation() {
    return location;
  }

  /**
   * Set the location of this scheduled event. This is typically either a
   * free-text description or address.
   * <p>
   * The property defines the venue for the activity defined by a component.
   * <p>
   * Specific venues such as conference or meeting rooms may be explicitly
   * specified using this property. An alternate representation may be specified
   * that is a URI that points to directory information with more structured
   * specification of the location.
   * <p>
   * This provides an option to associate a location with this Schedule.
   *
   * @param location the schedule event location
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * Boolean indicator that this schedule repeats, includes a recurrence rule in
   * the {@link #recurType} field, and that the {@link #recurType} should be
   * parsed and interpreted.
   * <p>
   * Default is FALSE.
   *
   * @return TRUE if this schedule has a recurrence rule configuration (i.e.
   *         repeats)
   */
  public boolean isRecurrence() {
    return recurrence;
  }

  /**
   * Set the indicator that this schedule repeats.
   *
   * @param recurrence TRUE if this schedule has a recurrence rule configuration
   */
  public void setRecurrence(boolean recurrence) {
    this.recurrence = recurrence;
  }//</editor-fold>

  /**
   * Adds the specified (signed) amount to the specified field. This method
   * updates both the event schedule Start and calendarEnd times.
   * <p>
   * Add operation is made on <em>both</em> the START and END fields.
   * <p>
   * NOTE: This default implementation on CalcalendarEndar just repeatedly calls
   * the version of roll() that rolls by one unit. This may not always do the
   * right thing. For example, if the DAY_OF_MONTH field is 31, rolling through
   * February will leave it set to 28. The GregorianCalcalendarEndar version of
   * this function takes care of this problem. Other subclasses should also
   * provide overrides of this function that do the right thing.
   *
   * @param temporalUnit the field
   * @param amount       the signed amount to add to the field.
   */
  public void plus(TemporalUnit temporalUnit, long amount) {
    dateStart = dateStart.plus(amount, temporalUnit);
    dateEnd = dateEnd.plus(amount, temporalUnit);
  }

  /**
   * Updates the START field by adding the specified (signed) amount of time to
   * the given field, based on the TemporalUnit rules. For example, to subtract
   * 5 days from the current time of the call resize(ChronoUnit.DAYS, -5).
   * <p>
   * Resize operation is made on <em>only</em> the END field.
   *
   * @param temporalUnit the given field
   * @param amount       the value to be set for the given field.
   */
  public void plusStart(TemporalUnit temporalUnit, long amount) {
    dateStart = dateStart.plus(amount, temporalUnit);
  }

  /**
   * Updates the END field by adding the specified (signed) amount of time to
   * the given field, based on the TemporalUnit rules. For example, to subtract
   * 5 days from the current time of the call resize(ChronoUnit.DAYS, -5).
   * <p>
   * Resize operation is made on <em>only</em> the END field.
   *
   * @param temporalUnit the given field
   * @param amount       the value to be set for the given field.
   */
  public void plusEnd(TemporalUnit temporalUnit, long amount) {
    dateEnd = dateEnd.plus(amount, temporalUnit);
  }

  // <editor-fold defaultstate="collapsed" desc="Category List Management">
  /**
   * Adds a new Category. Categories are useful in searching for a component of
   * a particular type and category.
   *
   * @param category a category.
   */
  public void addCategory(String category) {
    getCategories().add(category);
  }// </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Schedule calculator methods">
  /**
   * Returns the first date of this Schedule. This returns the
   * {@link #dateStart} field.
   *
   * @return the first date of this Schedule
   */
  public ZonedDateTime getDateEffective() {
    return getDateStart();
  }

  /**
   * Calculate and return the calculated expiration date (i.e. that last date)
   * of a Scheduled event, accounting for recurrence if configured. If
   * recurrence is not configured then the {@code dateEnd} field is returned.
   * <p>
   * If no recurrence {@code UNTIL} date is specified then the default maximum
   * of 1 year is returned.
   *
   * @return the last date of this Schedule (accounting for recurrence)
   */
  public ZonedDateTime getDateExpire() {
    return ICalendar.calculateExpiration(dateEnd, null, recurType);
  }

  /**
   * Quick convenience method to check if the dateStart and dateEnd values have
   * been set.
   *
   * @return TRUE if the start and end dates are configured.
   */
  public boolean isUsable() {
    return dateStart != null && dateEnd != null;
  }

  /**
   * Determine if this schedule event contains the indicated date. That is,
   * determine whether the query date falls within the event period covered by
   * the schedule between the start and end dates.
   * <p>
   * This method does not account for recurrence.
   *
   * @param date the date of interest
   * @return true if the date falls within the period covered by the schedule
   */
  public boolean contains(LocalDate date) {
    if (date == null) {
      return false;
    }
    return !getDateStart().toLocalDate().isAfter(date) && !getDateEnd().toLocalDate().isBefore(date);
  }

  /**
   * Determine if this schedule event contains the indicated date. That is,
   * determine whether the query date falls within the event period covered by
   * the schedule between the start and end dates.
   * <p>
   * This method does not account for recurrence.
   *
   * @param date the date of interest
   * @return true if the date falls within the period covered by the schedule
   */
  public boolean contains(ZonedDateTime date) {
    if (date == null) {
      return false;
    }
    return !getDateStart().isAfter(date) && !getDateEnd().isBefore(date);
  }

  /**
   * Determine if this schedule contains another. That is, determine whether
   * this schedule event start and end dates fall outside the other schedule
   * start and end dates.
   *
   * @param schedule the other schedule instance
   * @return true if the date falls within the event described by the schedule
   */
  public boolean contains(Event schedule) {
    if (schedule == null) {
      return false;
    }
    return !getDateStart().isAfter(schedule.getDateStart()) && !getDateEnd().isBefore(schedule.getDateEnd());
  }

  /**
   * Determine if this schedule event intersects the indicated date. That is,
   * determine whether the query date falls anywhere within the schedule between
   * the start and expire dates.
   * <p>
   * This method accounts for recurrence.
   *
   * @param date the date of interest
   * @return true if the date falls within the period covered by the schedule
   */
  public boolean intersects(ZonedDateTime date) {
    if (date == null) {
      return false;
    }
    return !(date.isBefore(getDateStart()) || date.isAfter(getDateEnd()));
  }

  /**
   * Determine if any period of this schedule intersects any period of another.
   * In the event of recurrence this method expands both schedule configurations
   * and evaluates whether ANY period from the second schedule intersects ANY
   * period of this schedule.
   * <p>
   * Developer note: Read the functional description carefully: the comparison
   * applies recurrence to both schedules.
   *
   * @param schedule the other schedule to evaluate
   * @return true if the date falls within the event described by the schedule
   */
  public boolean intersects(Event schedule) {
    if (schedule == null) {
      return false;
    }

    if (recurrence) {
      if (schedule.isRecurrence()) {
        final Collection<Event> scheduleEvents = schedule.calculatePeriodList(schedule.getDateStart(), schedule.getDateExpire());
        for (Event s : calculatePeriodList(getDateStart(), getDateExpire())) {
          for (Event t : scheduleEvents) {
            if (intersect(s, t) || intersect(t, s)) {
              return true;
            }
          }
        }
        return false;
      } else {
        return calculatePeriodList(getDateStart(), getDateExpire()).stream().anyMatch(s -> intersect(s, schedule) || intersect(schedule, s));
      }
    } else if (schedule.isRecurrence()) {
      for (Event t : schedule.calculatePeriodList(schedule.getDateStart(), schedule.getDateExpire())) {
        if (intersect(this, t) || intersect(t, this)) {
          return true;
        }
      }
      return false;
    } else {
      return intersect(this, schedule) || intersect(schedule, this);
    }
  }

  /**
   * Internal helper method to evaluate whether the second schedule {@code t}
   * intersects the first schedule {@code s}.
   *
   * @param s the first schedule
   * @param t the second schedule
   * @return TRUE if the second schedule intersects the first
   */
  public static boolean intersect(Event s, Event t) {
    return !(s.getDateEnd().isBefore(t.getDateStart()) || s.getDateStart().isAfter(t.getDateEnd()));
  }

  /**
   * Calculate the difference between this Schedule and another.
   * <p>
   * This method computes the temporal equivalent of an inverted
   * <em>set-theoretic difference</em>: the period in this schedule {@code A}
   * that are not in the other schedule {@code B}:
   * <pre>
   * |-------------|          A: this schedule
   *          |------------|  B: that schedule
   * |--------|               result (this not in that)
   * </pre>
   *
   * @param schedule the other schedule.
   * @return the period in the other schedule not in this schedule
   * @throws Exception if the other schedule is wholly contains in this
   */
  public Event difference(Event schedule) throws Exception {
    return difference(this, schedule);
  }

  /**
   * Calculate the part of Schedule A not in Schedule B.
   * <p>
   * This method computes the temporal equivalent of an
   * <strong>inverted</strong> <em>relative complement</em> or
   * <strong>inverted</strong>
   * <em>set-theoretic difference</em>. A normal <em>relative complement</em> of
   * A would produce the set of elements in B but not in A. This method
   * calculated the inverse: the set of elements in A but not in B. That is: the
   * time interval in the FIRST interval that is not in the second interval.
   * <p>
   * Developer note: For two schedule configurations A and B the intersection
   * returns the first period in {@code A} not in {@code B}. Where the
   * intersection of A and B is partial only the first difference period is
   * returned.
   * <p>
   * For schedules with recurrence the intersection explodes each schedule into
   * a period list according to each schedule's recurrence configuration, with
   * the period list starting at the current date-time and extending to each
   * schedule's respective expiration. The intersection algorithm then
   * recursively evaluates period entries to identify the first intersection and
   * the difference of the first intersection is returned.
   * <p>
   * There are many cases to consider when evaluating the difference of A and B,
   * written as {@code A\B = C} and defined as "the period of A not in B". A few
   * cases are illustrated here for reference:
   * <pre>
   * Case: no intercept
   * A:  a-----------a
   * B:                  b-----------b
   * C:  a-----------a
   * Case: A before B (and A contains B)
   * A:  a-----------------------------a
   * B:         b-----------b
   * C:  a------b           b----------a    [note: the second period is discarded]
   * Case: A after B
   * A:         a-----------a
   * B:  b-----------b
   * C:              b------a
   * Case: A before B
   * A:  a-----------a
   * B:        b-----------b
   * C:  a-----b
   * Case: A starts with B (and A contains B)
   * A:  a-----------------a
   * B:  b-----------b
   * C:              b-----a
   * Case: Recurrence (showing A after B)
   * A:  a----a      a----a      a----a
   * B:           b----b
   * C:                b--a
   * Case: A after and ends with B (B contains A)
   * A:            a-------a
   * B:  b-----------------b
   * C:  FAIL
   * Case: B containd A
   * A:         a-----------a
   * B:  b-----------------------------b
   * C:  FAIL</pre>
   *
   * @param a the first schedule
   * @param b the second schedule
   * @return a new schedule describing the period of A not in B
   * @throws Exception if schedules B wholly contains schedule A then there is
   *                   no part of A not in B
   */
  public static Event difference(final Event a, final Event b) throws Exception {
    /**
     * Case: no intercept. Return original A.
     */
    if (!a.intersects(b)) {
      return Event.getInstance(a.getDateStart(), a.getDateEnd());
    }
    /**
     * Case: A contains B
     */
    if (b.contains(a)) {
      throw new Exception("Difference calculation A\\B is not defined: Schedule B contains A and there is no part of A not in B");
    }
    /**
     * Case: A after B produces leading interval (b_start--a_start), Case: A
     * before B produces trailing interval (a_end--b_end).
     */
    if (a.isRecurrence()) {
      /**
       * In case of recurrence scan all A and B period entries searching for the
       * _first_ overlap. Note that the first overlap can be anywhere along the
       * time line. For best results it is generally best if A not have
       * recurrence.
       * <p>
       * Developer note: start the period list with the recurring schedule start
       * date but end the period list at the OTHER schedule end date. This has
       * the effect of limiting the period list to a reasonable term.
       */
      for (Event s : a.calculatePeriodList(a.getDateStart(), b.getDateExpire())) {
        if (b.isRecurrence()) {
          /**
           * Scan all B period entries, searching for the first overlapping
           * period with the A sub-period S. Note that the candidate periods may
           * not intersect, so add a logic test to process the first
           * intersecting periods.
           */
          for (Event t : b.calculatePeriodList(b.getDateStart(), s.getDateExpire())) {
            if (s.intersects(t)) {
              return difference(s, t);
            }
          }
        } else if (s.intersects(b)) {
          /**
           * A sub-period S intersects B, which does not recur. Evaluate the
           * difference.
           */
          return difference(s, b);
        }
      }
    } else if (b.isRecurrence()) {
      /**
       * A does not recur but B does. Evaluate the difference of A with each
       * entry in the B period list. Since the _difference_ method includes an
       * _intersect_ test there it is faster to just call _difference_ directly.
       */
      Event x = a;
      for (Event t : b.calculatePeriodList(b.getDateStart(), a.getDateExpire())) {
        x = x.difference(t);
      }
      return x;
    }
    /**
     * Calculate B not in A.
     * <p>
     * If A starts after or with B then return the trailing fragment. If A
     * starts before B then return the leading fragment.
     */
    if (a.getDateStart().isAfter(b.getDateStart()) || a.getDateStart().equals(b.getDateStart())) {
      /**
       * <pre>
       * A:     a_s-------------a_e
       * B:  b_s---------b_e
       * C:             b_e-----a_e        (b_end - a_end)
       * </pre>
       */
      return Event.getInstance(b.getDateEnd(), a.getDateEnd());
    } else {
      /**
       * <pre>
       * A:  a_s-------------a_e
       * B:          b_s---------b_e
       * C:  a_s------b_s                 (a_start - b_start)
       * </pre>
       */
      return Event.getInstance(a.getDateStart(), b.getDateStart());
    }
  }

  /**
   * Convenience method to evaluate if this Schedule is active and should be
   * considered valid. The opposite of this method is {@link #isExpired()}
   * <p>
   * Returns TRUE if the Start date is before or after NOW and the calendarEnd
   * date is not before NOW
   *
   * @return TRUE if the schedule is EITHER not expired OR begins in the future.
   */
  public boolean isActive() {
    return isCurrent() || isFuture();
  }

  /**
   * Convenience method to evaluate if this Schedule includes the current date
   * and time.
   * <p>
   * Returns TRUE if the Start date is before NOW and the calendarEnd date is
   * after NOW.
   *
   * @return TRUE if the schedule contains the current date and time.
   */
  public boolean isCurrent() {
    return dateStart.toLocalDate().isBefore(LocalDate.now(ZONE_UTC)) && !isExpired();
  }

  /**
   * Convenience method to evaluate if the Schedule has a Start date in the
   * future.
   *
   * @return TRUE if the Start date is after the current system time
   */
  public boolean isFuture() {
    return dateStart.toLocalDate().isAfter(LocalDate.now(ZONE_UTC));
  }

  /**
   * Convenience method to evaluate if the Schedule has expired. The opposite of
   * this method is {@link #isActive()}
   *
   * @return TRUE if the expiration date is before the current system time
   */
  public boolean isExpired() {
    return dateEnd.toLocalDate().isBefore(LocalDate.now(ZONE_UTC));
  }

  /**
   * Convenience method to print a human-readable sentence description.
   *
   * @return A formatted, human readable description of this schedule. e.g. "All
   *         day from [DtTART] to [DteND] with recurrence, calendarEnding on
   *         [EXIPIRE]"
   */
  public String getFormattedDescription() {
    /**
     * Do not process if the start and end Dates are not set
     */
    if (!isUsable()) {
      return null;
    }
    /**
     * Start with "all day" if this is an all day event.
     */
    StringBuilder stringBuilder = new StringBuilder();
    if (isAllDayEvent()) {
      stringBuilder.append("All day ");
    }
    /**
     * Instantiate a local date time formatter. Build a date formatter and set
     * its internal calendar so that it will display the correct time zone
     * information. Output will be formatted like 'Thursday April 18 13:04 UTC
     * 2013'.
     */
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_24HR_TIMEZONE, Locale.ENGLISH);
    stringBuilder.append(stringBuilder.length() > 0 ? "from " : "From ").
      append(dateStart.format(dateTimeFormatter)).
      append(" to ").
      append(dateEnd.format(dateTimeFormatter));
    if (isRecurrence()) {
      stringBuilder.append(" with recurrence pattern ").append(getRecurType());
      stringBuilder.append(", concluding on ").append(getDateExpire().format(DateTimeFormatter.ISO_DATE));
    }
    return stringBuilder.toString();
  }

  /**
   * Get the Duration representing the duration between the start and end
   * ZonedateTimes.
   * <p>
   * This calculates the duration between two temporal objects. If the objects
   * are of different types, then the duration is calculated based on the type
   * of the first object. For example, if the first argument is a LocalTime then
   * the second argument is converted to a LocalTime.
   *
   * @return the schedule duration
   */
  public Duration getDuration() {
    return Duration.between(dateStart, dateEnd);
  }

  /**
   * Determine the duration between the Start and expiration dates. This
   * calculator uses the dateExpiration field to account for Recurrence, if
   * present.
   * <p>
   * Utility method to determine the Duration of this Schedule.
   * <p>
   * This method is forked from the example presented in Marc Whitlow's blog.
   *
   * @return String describing the time between the Start and calendarEnd dates.
   *         e.g. 2 years 1 day 6 hours and 23 minutes.
   * @see <a
   * href="http://www.colabrativ.com/calendar-and-timestamp-duration-determination-method-in-java/">CalcalendarEndar
   * and Timestamp Duration Determination Method in Java</a>
   */
  public String getDurationDataTypeString() {
    return durationDescription(getDateStart(), getDateEnd());
  }

  /**
   * Determine the duration between the Start and calendarEnd dates. This is the
   * duration of a single event and does not evaluate recurrence.
   * <p>
   * Utility method to determine the Duration of this Schedule
   *
   * @return String describing the time between the Start and calendarEnd dates,
   *         e.g. 6 hours and 23 minutes.
   */
  public String getDurationEvent() {
    return durationDescription(dateStart.withHour(0).withMinute(0), dateEnd.withHour(23).withMinute(59));
  }

  /**
   * Determine the duration between the effective and expiration dates.
   * <p>
   * Utility method to determine the Duration of this Schedule
   *
   * @return String describing the time between the Start and calendarEnd dates,
   *         e.g. 2 years 1 day 6 hours and 23 minutes.
   */
  public String getDurationExpiration() {
    return durationDescription(allDayEvent ? dateStart.withHour(0).withMinute(0) : dateStart,
                               allDayEvent ? getDateExpire().withHour(23).withMonth(59) : getDateExpire());
  }

  /**
   * Helper method to build a duration description String from two s.
   *
   * @param start the Start date/time
   * @param end   the calendarEnd date/time
   * @return a non-null string
   */
  public static String durationDescription(ZonedDateTime start, ZonedDateTime end) {
    /**
     * Full-time schedules run from 00:00 to 23:59. In this case round the end
     * time up by one minute to produce a pretty-print hourly description.
     */
    if (end.getMinute() == 59) {
      end = end.plusMinutes(1);
    }

    ZonedDateTime ldt = start;
    long years = ChronoUnit.YEARS.between(ldt, end);
    ldt = ldt.plus(years, ChronoUnit.YEARS);
    long days = ChronoUnit.DAYS.between(ldt, end);
    ldt = ldt.plus(days, ChronoUnit.DAYS);
    long hours = ChronoUnit.HOURS.between(ldt, end);
    ldt = ldt.plus(hours, ChronoUnit.HOURS);
    long mins = ChronoUnit.MINUTES.between(ldt, end);

    /**
     * Build the Duration String.
     */
    StringBuilder stringBuilder = new StringBuilder();
    if (years > 0) {
      stringBuilder.append(years);
      addUnits(stringBuilder, years, "year");
    }
    if (days > 0) {
      stringBuilder.append(days);
      addUnits(stringBuilder, days, "day");
    }
    if (hours > 0) {
      stringBuilder.append(hours);
      addUnits(stringBuilder, hours, "hour");
    }
    if (mins > 0) {
      stringBuilder.append(mins);
      addUnits(stringBuilder, mins, "minute");
    }
    return stringBuilder.toString().trim();
  }

  /**
   * Internal method to add units to the getDuration pretty-printer.
   *
   * @param stringBuilder the string builder
   * @param value         the unit value
   * @param units         the unit type
   */
  private static void addUnits(StringBuilder stringBuilder, long value, String units) {
    stringBuilder.append(" ");
    if (value == 1) {
      stringBuilder.append(units).append(" ");
    } else {
      stringBuilder.append(units).append("s ");
    }
  }

  /**
   * Adjust the DTEND field to set the Schedule duration to the indicated value.
   * <p>
   * This method sets the DTEND field to the DTSTART value, then adds the
   * indicated amount to adjust the schedule duration.
   *
   * @param field  the TemporalUnit
   * @param amount the signed amount to add to the DTEND field.
   */
  public void setDuration(TemporalUnit field, long amount) {
    dateEnd = dateStart.plus(amount, field);
  }

  /**
   * Set the DTEND field by specifying an XML Duration data type instead of a
   * specific time.
   * <p>
   * If not set this method sets the START to NOW. It then overwrites the
   * current DTEND value. This method also includes a null check and will ignore
   * null input values.
   * <p>
   * RFC5545 says either 'dateEnd' or 'duration' may appear in a 'eventprop',
   * but 'dateEnd' and 'duration' MUST NOT occur in the same 'eventprop'. Use
   * this method when creating a Schedule from a VCARD datatype that specified
   * duration but not DTEND.
   *
   * @param duration a non-null javax.xml.datatype.Duration object. null values
   *                 are ignored.
   */
  public void setDuration(Duration duration) {
    if (duration != null) {
      if (dateStart == null) {
        dateStart = ZonedDateTime.now(Clock.systemUTC());
      }
      dateEnd = dateStart.plus(duration);
    }
  }// </editor-fold>

  /**
   * Confirm that the dateStart and dateEnd fields are not null.
   * <p>
   * Inspect this Entity Class to determine that it is correctly configured.
   * This method never returns FALSE. Instead it throws an exception with a
   * description of the error.
   *
   * @return TRUE if valid.
   * @throws Exception If the start or end is not configured.
   */
  public boolean isValid() throws Exception {
    /**
     * Throw an exception if this entity cannot be properly prePersistd
     */
    if (dateStart == null) {
      throw new Exception("Schedule start date is required.");
    }
    if (dateEnd == null) {
      throw new Exception("Schedule end date is required.");
    }
    return true;
  }

  /**
   * Hash code and equals are evaluated from the {@link #dateStart} and
   * {@link #dateEnd} fields.
   *
   * @return generated gash code
   */
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 59 * hash + Objects.hashCode(this.dateStart);
    hash = 59 * hash + Objects.hashCode(this.dateEnd);
    return hash;
  }

  /**
   * Hash code and equals are evaluated from the {@link #dateStart} and
   * {@link #dateEnd} fields.
   *
   * @param obj the other schedule object
   * @return true if the UUID match
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Event other = (Event) obj;
    if (!Objects.equals(this.dateStart, other.dateStart)) {
      return false;
    }
    return Objects.equals(this.dateEnd, other.dateEnd);
  }

  /**
   * Creates a copy of this object. The returned object is unique from the
   * original object and may be indepcalendarEndently persisted to the database
   * without concern for a pre-existing record error.
   *
   * @return a copy of this Schedule with a new ID and UUID and null location.
   */
  @SuppressWarnings("AccessingNonPublicFieldOfAnotherObject")
  public Event copy() {
    /**
     * Set the dateStart/dateEnd. No need to set the start/end calendar fields
     * as they will be populated in their respective getter.
     */
    Event copy = getInstance(dateStart, dateEnd);
    /**
     * Force copy the recurrence rule field to avoid creating an unneeded
     * RecurType.
     */
    copy.setAllDayEvent(allDayEvent);
    copy.setOrganizer(organizer);
    copy.setPriority(priority);
    copy.setTransparency(transparency);
    return copy;
  }

  /**
   * Get a complete representation of all Schedule entity class fields and their
   * current setting.
   *
   * @return a String representation of this Schedule
   */
  public String toStringFull() {
    if (dateStart == null || dateEnd == null) {
      return "Schedule not configured.";
    }
    return "Schedule"
      + " id [" + id
      + "] allDayEvent [" + allDayEvent
      + "] classification [" + classification
      + "] created [" + created
      + "] dtstart [" + dateStart
      + "] dtend [" + dateEnd
      + "] priority [" + priority
      + "] transp [" + transparency
      //            + "] timeZone [" + timeZone
      + "] uuid [" + uuid;
  }

  /**
   * Provide an abbreviate list of configuration parameters.
   *
   * @return an abbreviate list of configuration parameters
   */
  @Override
  public String toString() {
    if (dateStart == null || dateEnd == null) {
      return "Schedule not configured.";
    }
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_12HR, Locale.ENGLISH);
    return allDayEvent ? "All day " : "" + dateStart.format(dateFormatter) + " to " + dateEnd.format(dateFormatter) + " (" + getZoneId().getId() + ")";
  }

  /**
   * {@inheritDoc }
   * <p>
   * Sort in chronological order.
   */
  @Override
  public int compareTo(Event o) {
    return dateStart.equals(o.getDateStart())
           ? dateEnd.compareTo(o.getDateEnd())
           : dateStart.compareTo(o.getDateStart());
  }

  /**
   * Enumerated values for the Schedule.transparency field.
   * <p>
   * This property defines whether an event is transparent or not to busy time
   * searches. It corresponds to the Time Transparency iCalendar field.
   * <p>
   * Time Transparency is the characteristic of an event that determines whether
   * it appears to consume time on a . Events that consume actual time for the
   * individual or resource associated with the SHOULD be recorded as OPAQUE,
   * allowing them to be detected by free-busy time searches. Other events,
   * which do not take up the individual's (or resource's) time SHOULD be
   * recorded as TRANSPARENT, making them invisible to free-busy time searches.
   */
  @SuppressWarnings("PublicInnerClass")
  @XmlType(name = "ETransparency")
  @XmlEnum
  public static enum ETransparency {

    /**
     * An events that consumes actual time for the individual or resource.
     */
    OPAQUE,
    /**
     * An event which does not take up the individual's (or resource's) time.
     */
    TRANSPARENT
  }

  /**
   * Enumerated values for the Schedule.classification field.
   * <p>
   * These are allowed values for the iCalendar 'CLASS' field, which corresponds
   * to the iCalendar property “CLASS” and defines the access classification for
   * a component. Examples include "PUBLIC", "PRIVATE", and “CONFIDENTIAL".
   * <p>
   * An access classification is only one component of the general security
   * system within a application. It provides a method of capturing the scope of
   * the access the owner iCalendars for information within an individual entry.
   * The access classification of an individual iCalendar component is useful
   * when measured along with the other security components of a system (e.g.,
   * user authentication, authorization, access rights, access role, etc.).
   * Hence, the semantics of the individual access classifications cannot be
   * completely defined by this memo alone. Additionally, due to the "blind"
   * nature of most exchange processes using this memo, these access
   * classifications cannot serve as an enforcement statement for a system
   * receiving an iCalendar object. Rather, they provide a method for capturing
   * the intention of the owner for the access to the component.
   */
  @SuppressWarnings("PublicInnerClass")
  @XmlType(name = "EClassification")
  @XmlEnum
  public static enum EClassification {
    PUBLIC,
    PRIVATE,
    CONFIDENTIAL
  }

  //<editor-fold defaultstate="collapsed" desc="iCalendar methods">
  /**
   * Build a period list for a recurring event within the indicated dates of
   * interest.
   * <p>
   * The Start and calendarEnd dates denote the dates of interest. If no events
   * fall within the Start and calendarEnd dates and an empty list is returned.
   * For example, if building a view for the month of May the Start date and
   * calendarEnd dates would be May 01, May 31, respectively.
   * <p>
   * This method is typically used when rendering a iCalendar widget.
   * <p>
   * Developer note: Each returned occurrence is configured with no RRULE plus a
   * unique ID and UUID distinct from the master schedule's configuration. Each
   * occurrence may therefore be modified and persisted as an individual entry
   * without affecting the master entry. The master schedule UUID is stored in
   * each period schedule's extension under the "DATA" key and care must be
   * taken to recover the master record before editing it.
   * <p>
   * Developer Note: There is currently no exclusion/exception (EXDATE/RDATE)
   * support in RRULE processing.
   * <p>
   * Developer note: This method includes an indirect dependency upon the
   * Apache.lang HashCodeBuilder method, which is not linked to the library by
   * default.
   *
   * @param periodStart the date to begin calculating schedule occurrences
   * @param periodEnd   the period calendarEnd date
   * @return a list of individual Schedule occurrences.
   */
  public List<Event> calculatePeriodList(final ZonedDateTime periodStart, final ZonedDateTime periodEnd) {
    /**
     * If there is no recurrence then simply return this instance.
     */
    if (!isRecurrence()) {
      return Collections.singletonList(this);
    }
    /**
     * Calculate a recurrence set for this schedule configuration.
     * <p>
     * Developer note: Schedule currently ONLY supports RRULE. Possible
     * recurrence configurations include: <br>
     * RDATE. A list to include in a recurrence set.<br>
     * RRULE: A rule to calculate inclusion in a recurrence set.<br>
     * EXDATE: A list to exclude from a recurrence set.<br>
     * EXRULE: A rule to calculate exclusion from a recurrence set.
     */
    try {
      return ICalendar.calculatePeriodSet(dateStart.toLocalDateTime(),
                                          dateEnd.toLocalDateTime(),
                                          recurType,
                                          periodStart.withZoneSameInstant(getZoneId()).toLocalDateTime(),
                                          periodEnd.withZoneSameInstant(getZoneId()).toLocalDateTime()).stream()
        .map(periodType -> {
          /**
           * Developer note: PeriodType DATETIME values are ALWAYS set to UTC
           * (ZULU) time. //todo Comment does not reflect existing code:
           * getTimeZone() returns a non-UTC timezone if one is set
           */
          return Event.getInstance(periodType.getStart(), periodType.getEnd(), getZoneId());
        }).collect(Collectors.toList());
    } catch (Exception e) {
      Logger.getLogger(Event.class.getName()).log(Level.SEVERE, "Schedule period list error:  {0}", e.getMessage());
      Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, e);
    }
    /**
     * If calculateRecurrenceSet fails then this method returns an empty List
     */
    return Collections.emptyList();
  }//</editor-fold>

}
