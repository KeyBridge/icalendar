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

import java.time.DayOfWeek;

/**
 * Enumeration of Weekday values for building a proper recurrence rule
 * description.
 */
@SuppressWarnings("PublicInnerClass")
public enum EWeekday {
  /**
   * Sunday (1)
   */
  SU("Sunday", DayOfWeek.SUNDAY),
  /**
   * Monday (2)
   */
  MO("Monday", DayOfWeek.MONDAY),
  /**
   * Tuesday (3)
   */
  TU("Tuesday", DayOfWeek.TUESDAY),
  /**
   * Wednesday (4)
   */
  WE("Wednesday", DayOfWeek.WEDNESDAY),
  /**
   * Thursday (5)
   */
  TH("Thursday", DayOfWeek.THURSDAY),
  /**
   * Friday (6)
   */
  FR("Friday", DayOfWeek.FRIDAY),
  /**
   * Saturday (7)
   */
  SA("Saturday", DayOfWeek.SATURDAY);

  /**
   * The day common name. e.g. 'Sunday'
   */
  private final String label;
  /**
   * The DAY_OF_WEEK index. This corresponds to the iCalendar.DAY_OF_WEEK
   * number.
   */
  private final DayOfWeek dayOfWeek;

  EWeekday(String label, DayOfWeek dayOfWeek) {
    this.label = label;
    this.dayOfWeek = dayOfWeek;
  }

  /**
   * Get the entity name.
   *
   * @return the entity name. e.g. "WE"
   */
  public String getName() {
    return name();
  }

  /**
   * Get the numerical day of week value
   *
   * @return the numerical day of week value
   */
  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  /**
   * Get the day common label
   *
   * @return The day common label. e.g. 'Sunday'
   */
  public String getLabel() {
    return label;
  }

  /**
   * Return the day for the indicated day of week.
   *
   * @param dayOfWeek the day of week number corresponding to the
   *                  java.time.DayOfWeek
   * @return the matching EWeekday instance. null if no match.
   */
  public static EWeekday byDayOfWeek(DayOfWeek dayOfWeek) {
    for (EWeekday eWeekday : EWeekday.values()) {
      if (eWeekday.getDayOfWeek() == dayOfWeek) {
        return eWeekday;
      }
    }
    return null;
  }

  /**
   * Find by the day label.
   *
   * @param label the day label. e.g. "Sunday". not case sensitive.
   * @return the matching EWeekday instance. null if no match.
   */
  public static EWeekday byLabel(String label) {
    for (EWeekday enum_Weekday : EWeekday.values()) {
      if (enum_Weekday.getLabel().equalsIgnoreCase(label.toUpperCase())) {
        return enum_Weekday;
      }
    }
    return null;
  }
}
