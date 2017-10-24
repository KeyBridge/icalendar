/*
 *  Copyright (C) 2014 Caulfield IP Holdings (Caulfield) and/or its affiliates.
 *  All rights reserved. Use is subject to license terms.
 *
 *  Software Code is protected by Caulfield Copyrights. Caulfield hereby reserves
 *  all rights in and to Caulfield Copyrights and no license is granted under
 *  Caulfield Copyrights in this Software License Agreement. Caulfield generally
 *  licenses Caulfield Copyrights for commercialization pursuant to the terms of
 *  either Caulfield's Standard Software Source Code License Agreement or
 *  Caulfield's Standard Product License Agreement.
 *
 *  A copy of either License Agreement can be obtained on request by email from:
 *  info@caufield.org.
 */
package ch.keybridge.icalendar.jsf.dto;

import ietf.params.xml.ns.icalendar.RecurType;
import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

/**
 * ScheduledEvent is a implementation of the the Primefaces ScheduleEvent
 * interface.
 * <p>
 * This class is used instead of the PrimeFaces DefaultScheduleEvent as that
 * implementation does not have Setter methods.
 * <p>
 * ScheduledEvent is a simple POJO and acts as a bridge between the Calendar GUI
 * and a separate logical or physical data model. ScheduledEvent may also be
 * easily converted to iCalendar vEvent entities.
 *
 * @author Jesse Caulfield
 * @since v7.5.0 created 12/10/2015
 */
public class ScheduledEvent implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Id is mapped to the Schedule UUID. Used internally by PrimeFaces, auto
   * generated.
   */
  private String id;
  /**
   * The title of this event. Title is a reference to schedule.summary. However,
   * if the summary is not set then a simple DateFormat of the start date is
   * provided.
   */
  private String title;
  /**
   * tooltip text to display on mouseover of an event.
   */
  private String description;
  /**
   * Optional (text) data you can set to be represented by ScheduledEvent.
   */
  private Object data;

  /**
   * The event Start date and time. This is an Instant and knows nothing of time
   * zones.
   */
  private Date startDate;
  /**
   * The event End date and time. This is an Instant and knows nothing of time
   * zones.
   */
  private Date endDate;
  /**
   * The event time zone.
   */
  private TimeZone timeZone;

  /**
   * Get the configured visual style class. If no style class is set and the
   * ScheduledEvent is configured as editable then the style class 'editable' is
   * returned by default. A Visual style class to enable multi resource display.
   */
  private String styleClass;
  /**
   * Boolean Flag indicating event is all day.
   */
  private boolean allDay;

  /**
   * Boolean flag indicating whether the event is editable or not.
   */
  private boolean editable;

  /**
   * Indicator that there is a recurrence configuration that should be
   * considered. If this is false then the {@code recur} field should be ignored
   * even if configured.
   */
  private boolean hasRecur;
  /**
   * Recurrence configuration.
   */
  private RecurType recur;

  public ScheduledEvent() {
  }

  public ScheduledEvent(String title, Date startDate, Date endDate) {
    this.title = title;
    this.endDate = endDate;
    this.startDate = startDate;
  }

  public ScheduledEvent(Date startDate, Date endDate, boolean editable) {
    this.endDate = endDate;
    this.startDate = startDate;
    this.editable = editable;
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  /**
   * {@inheritDoc
   */
  public String getId() {
    return id;
  }

  /**
   * {@inheritDoc
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * {@inheritDoc
   */
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * {@inheritDoc
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * {@inheritDoc
   */
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  /**
   * {@inheritDoc
   */
  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  /**
   * {@inheritDoc
   */
  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public TimeZone getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(TimeZone timeZone) {
    this.timeZone = timeZone;
  }

  /**
   * {@inheritDoc
   */
  public String getStyleClass() {
    return styleClass;
  }

  public void setStyleClass(String styleClass) {
    this.styleClass = styleClass;
  }

  /**
   * {@inheritDoc
   */
  public boolean isAllDay() {
    return allDay;
  }

  public void setAllDay(boolean allDay) {
    this.allDay = allDay;
  }

  /**
   * {@inheritDoc
   */
  public boolean isEditable() {
    return editable;
  }

  public void setEditable(boolean editable) {
    this.editable = editable;
  }

  public boolean isHasRecur() {
    return hasRecur;
  }

  public void setHasRecur(boolean hasRecur) {
    this.hasRecur = hasRecur;
  }

  public RecurType getRecur() {
    if (recur == null) {
      recur = new RecurType(); // DAILY
    }
    return recur;
  }

  public void setRecur(RecurType recur) {
    this.recur = recur;
  }

  public boolean isSetRecur() {
    return this.recur != null;
  }//</editor-fold>

  /**
   * Indicator that the start and end dates are configured.
   *
   * @return TRUE when the start and end dates are both configured.
   */
  public boolean isValid() {
    return startDate != null && endDate != null;
  }

  public String toString() {
    return "ScheduledEvent startDate [" + startDate
           + "] endDate [" + endDate
           + "] timeZone [" + (timeZone != null ? timeZone.getID() : null) + "]";
  }

}
