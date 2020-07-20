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
package ietf.params.xml.ns.icalendar.component;

import ietf.params.xml.ns.icalendar.ArrayOfComponents;
import ietf.params.xml.ns.icalendar.ArrayOfProperties;
import ietf.params.xml.ns.icalendar.ObjectFactory;
import ietf.params.xml.ns.icalendar.RecurType;
import ietf.params.xml.ns.icalendar.component.base.*;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.DurationPropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.DtendPropType;
import ietf.params.xml.ns.icalendar.property.base.datedatetime.DtstartPropType;
import ietf.params.xml.ns.icalendar.property.base.recur.RrulePropType;
import ietf.params.xml.ns.icalendar.property.base.text.UidPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.DtstampPropType;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

/**
 *
 * This type is the basis for all components and provides a base class for
 * applications.
 * <p>
 * Essentially it states that a component is a set of properties and components.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseComponentType", propOrder = {
  "properties",
  "components"
})
@XmlSeeAlso({
  AvailableType.class,
  DaylightType.class,
  StandardType.class,
  ValarmType.class,
  VavailabilityType.class,
  VcalendarType.class,
  VeventType.class,
  VfreebusyType.class,
  VjournalType.class,
  VtimezoneType.class,
  VtodoType.class,
  WsCalendarGluonType.class,
  WsCalendarIntervalType.class
})
@SuppressWarnings("unchecked")
public abstract class BaseComponentType {

  /**
   * Component start token.
   */
  @XmlTransient
  public static final String BEGIN = "BEGIN";
  /**
   * Component end token.
   */
  @XmlTransient
  public static final String END = "END";
  /**
   * A string used to denote the start (and end) of iCalendar content lines.
   */
  @XmlTransient
  public static final String LINE_SEPARATOR = "\r\n";
  /**
   * Prefix for non-standard components.
   */
  @XmlTransient
  public static final String EXPERIMENTAL_PREFIX = "X-";
  /**
   * The iCalendar object name. This is set in the component constructor.
   */
  @XmlTransient
  protected ComponentName name;

  protected ArrayOfProperties properties;
  protected ArrayOfComponents components;

  public BaseComponentType() {
  }

  public BaseComponentType(ComponentName name) {
    this.name = name;
  }

  public BaseComponentType(ComponentName name, ArrayOfProperties properties) {
    this.name = name;
    this.properties = properties;
  }

  public BaseComponentType(ComponentName name, ArrayOfComponents components) {
    this.name = name;
    this.components = components;
  }

  public BaseComponentType(ComponentName name, ArrayOfProperties properties, ArrayOfComponents components) {
    this.name = name;
    this.properties = properties;
    this.components = components;
  }

  /**
   * Get the iCalendar object name. This is set in the component constructor.
   *
   * @return the iCalendar object name
   */
  public ComponentName getName() {
    return name;
  }

  /**
   * Gets the value of the properties property.
   *
   * @return possible object is {@link ArrayOfProperties }
   *
   */
  public ArrayOfProperties getProperties() {
    if (properties == null) {
      properties = new ArrayOfProperties();
    }
    return properties;
  }

  /**
   * Sets the value of the properties property.
   *
   * @param value allowed object is {@link ArrayOfProperties }
   *
   */
  public void setProperties(ArrayOfProperties value) {
    this.properties = value;
  }

  public boolean isSetProperties() {
    return (this.properties != null);
  }

  /**
   * Gets the value of the components property.
   *
   * @return possible object is {@link ArrayOfComponents }
   *
   */
  public ArrayOfComponents getComponents() {
    if (components == null) {
      components = new ArrayOfComponents();
    }
    return components;
  }

  /**
   * Sets the value of the components property.
   *
   * @param value allowed object is {@link ArrayOfComponents }
   *
   */
  public void setComponents(ArrayOfComponents value) {
    this.components = value;
  }

  public boolean isSetComponents() {
    return (this.components != null);
  }

  /**
   * Unique Identifier. Property Name: UID
   * <p>
   * This property defines the persistent, globally unique identifier for the
   * calendar component.
   * <p>
   * Implementations MUST be able to receive and persist values of at least 255
   * octets for this property, but they MUST NOT truncate values in the middle
   * of a UTF-8 multi-octet sequence.
   *
   * @return The UID Property
   */
  public String getUID() {
    /**
     * QName {urn:ietf:params:xml:ns:icalendar-2.0}uid is a UidPropType
     */
    JAXBElement<UidPropType> jAXBElement = findJaXBElement("UID");
    if (jAXBElement != null) {
      return jAXBElement.getValue().getText();
    } else {
      return null;
    }
  }

  public void setUID(String uid) {
    getProperties().addProperty(new ObjectFactory().createUid(new UidPropType(uid)));
  }

  /**
   * Date-Time Stamp
   * <p>
   * Property Name: DTSTAMP
   * <p>
   * Purpose: In the case of an iCalendar object that specifies a "METHOD"
   * property, this property specifies the date and time that the instance of
   * the iCalendar object was created. In the case of an iCalendar object that
   * doesn't specify a "METHOD" property, this property specifies the date and
   * time that the information associated with the calendar component was last
   * revised in the calendar store.
   *
   * @return
   */
  public LocalDateTime getDTSTAMP() {
    /**
     * QName {urn:ietf:params:xml:ns:icalendar-2.0}dtstamp is a DtstampPropType
     */
    JAXBElement<DtstampPropType> jAXBElement = findJaXBElement("DTSTAMP");
    if (jAXBElement != null) {
      return jAXBElement.getValue().getUtcDateTime();
    } else {
      return null;
    }
  }

  public void setDTSTAMP(LocalDateTime dateTime) {
    getProperties().addProperty(new ObjectFactory().createDtstamp(new DtstampPropType(dateTime)));
  }

  /**
   * Date-Time Start
   * <p>
   * Property Name: DTSTART
   * <p>
   * Purpose: This property specifies when the calendar component begins.
   * <p>
   * Value Type: The default value type is DATE-TIME. The time value MUST be one
   * of the forms defined for the DATE-TIME value type. The value type can be
   * set to a DATE value type.
   * <p>
   * Property Parameters: IANA, non-standard, value data type, and time zone
   * identifier property parameters can be specified on this property.
   *
   * @return
   */
  public LocalDateTime getDTSTART() {
    /**
     * QName {urn:ietf:params:xml:ns:icalendar-2.0}dtstart is a DtstartPropType
     */
    JAXBElement<DtstartPropType> jAXBElement = findJaXBElement("DTSTART");
    if (jAXBElement != null) {
      return jAXBElement.getValue().getDateTime();
    } else {
      return null;
    }
  }

  public void setDTSTART(LocalDateTime dateTime) {
    getProperties().addProperty(new ObjectFactory().createDtstart(new DtstartPropType(dateTime)));
  }

  /**
   * Date-Time Start
   * <p>
   * Property Name: DTSTART
   * <p>
   * Purpose: This property specifies when the calendar component begins.
   * <p>
   * Value Type: The default value type is DATE-TIME. The time value MUST be one
   * of the forms defined for the DATE-TIME value type. The value type can be
   * set to a DATE value type.
   * <p>
   * Property Parameters: IANA, non-standard, value data type, and time zone
   * identifier property parameters can be specified on this property.
   *
   * @return
   */
  public LocalDateTime getDTEND() {
    /**
     * QName {urn:ietf:params:xml:ns:icalendar-2.0}dtend is a DtendPropType
     * <p>
     * RFC5545 says either 'dtend' or 'duration' may appear in a 'eventprop',
     * but 'dtend' and 'duration' MUST NOT occur in the same 'eventprop'
     */
    JAXBElement<DtendPropType> jAXBElement = findJaXBElement("DTEND");
    if (jAXBElement != null) {
      return jAXBElement.getValue().getDateTime();
    } else if (findJaXBElement("DURATION") != null) {
      /**
       * If the dtEnd is not set then try to calculate it from the duration.
       */
      return getDTSTART().plus(getDURATION());
    } else {
      return null;
    }
  }

  public void setDTEND(LocalDateTime dateTime) throws Exception {
    if (findJaXBElement("DURATION") != null) {
      throw new Exception("DURATION is already set. RFC5545 says either 'dtend' or 'duration' may appear in a 'eventprop', but 'dtend' and 'duration' MUST NOT occur in the same 'eventprop'");
    }
    getProperties().addProperty(new ObjectFactory().createDtend(new DtendPropType(dateTime)));
  }

  /**
   * 3.8.2.5. Duration
   * <p>
   * Purpose: This property specifies a positive duration of time.
   * <p>
   * e.g. The following is an example of this property that specifies an
   * interval of time of one hour and zero minutes and zero seconds:
   * DURATION:PT1H0M0S
   * <p>
   * RFC5545 says either 'dtend' or 'duration' may appear in a 'eventprop', but
   * 'dtend' and 'duration' MUST NOT occur in the same 'eventprop'
   *
   * @return the DURATION property
   */
  public Duration getDURATION() {
    /**
     * QName {urn:ietf:params:xml:ns:icalendar-2.0}duration is a
     * DurationPropType
     */
    JAXBElement<DurationPropType> jAXBElement = findJaXBElement("DURATION");
    if (jAXBElement != null) {
      return jAXBElement.getValue().getDuration();
    } else if (findJaXBElement("DTEND") != null) {
      /**
       * If the duration is not set then try to calculate it from the start/end
       * dates.
       */
      return Duration.between(getDTSTART(), getDTEND());
    } else {
      return null;
    }
  }

  public void setDURATION(String duration) throws Exception {
    setDURATION(Duration.parse(duration));
  }

  public void setDURATION(Duration duration) throws Exception {
    if (findJaXBElement("DTEND") != null) {
      throw new Exception("DTEND is already set. RFC5545 says either 'dtend' or 'duration' may appear in a 'eventprop', but 'dtend' and 'duration' MUST NOT occur in the same 'eventprop'");
    }
    getProperties().addProperty(new ObjectFactory().createDuration(new DurationPropType(duration)));
  }

  /**
   * Recurrence Rule
   * <p>
   * Value Name: RECUR
   * <p>
   * Purpose: This value type is used to identify properties that contain a
   * recurrence rule specification.
   *
   * @return
   */
  public RrulePropType getRRULE() {
    /**
     * QName {urn:ietf:params:xml:ns:icalendar-2.0}rrule is a RrulePropType
     */
    JAXBElement<RrulePropType> jAXBElement = findJaXBElement("RRULE");
    if (jAXBElement != null) {
      return jAXBElement.getValue();
    } else {
      return null;
    }
  }

  /**
   * Set the RRULE parameter with a RecurType definition. This method creates an
   * internal RrulePropType.
   *
   * @param recurType
   */
  public void setRRULE(RecurType recurType) {
    getProperties().addProperty(new ObjectFactory().createRrule(new RrulePropType(recurType)));
  }

  /**
   * The RrulePropType must contain a valid RecurType.
   *
   * @param rrulePropType
   */
  public void setRRULE(RrulePropType rrulePropType) {
    getProperties().addProperty(new ObjectFactory().createRrule(rrulePropType));
  }

  /**
   * Scans the properties or components looking for a QName local part that
   * matches the input name.
   *
   * @param qNameLocalPart the QName local part (e.g. 'fn'). Not case sensitive.
   * @return the corresponding JaXBElement, null if not found.
   */
  private JAXBElement findJaXBElement(String qNameLocalPart) {
    for (JAXBElement<? extends BasePropertyType> jAXBElement : getProperties().getBasePropertyOrTzid()) {
      if (qNameLocalPart.equalsIgnoreCase(jAXBElement.getName().getLocalPart())) {
        return jAXBElement;
      }
    }
    for (JAXBElement<? extends BaseComponentType> jAXBElement : getComponents().getBaseComponent()) {
      if (qNameLocalPart.equalsIgnoreCase(jAXBElement.getName().getLocalPart())) {
        return jAXBElement;
      }
    }
    return null;
  }

  /**
   * Important: Hash code is based on the UID value returned from the getUID
   * method and NOT a blind hash of the properties array. This ensures
   * consistent hash code value.
   *
   * @return hash of the getUID method returned value.
   */
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(getUID());
    return hash;
  }

  /**
   * Equals is based on hash code, which is based on UID.
   *
   * @param obj
   * @return TRUE if the UID values match, otherwise FALSE
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final BaseComponentType other = (BaseComponentType) obj;
    return this.hashCode() == other.hashCode();
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName()
           + "]\n properties [" + properties
           + "]\n components [" + components
           + "]\n";
  }
}
