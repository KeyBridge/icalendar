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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

/**
 *
 * This type is the basis for all components and provides a base class for
 * applications.
 * <p/>
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
   * yyyyMMdd'T'HHmmss'Z' - the default date time formatting pattern
   */
  public static final String UTC_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
  public static final String RELAXED_PATTERN = "yyyyMMdd";

  @XmlTransient
  protected static final TimeZone TIME_ZONE = TimeZone.getTimeZone("UTC");
  /**
   * The iCalendar object name. This is set in the component constructor.
   */
  @XmlTransient
  protected EComponentName name;

  protected ArrayOfProperties properties;
  protected ArrayOfComponents components;

  public BaseComponentType() {
  }

  public BaseComponentType(EComponentName name) {
    this.name = name;
  }

  public BaseComponentType(EComponentName name, ArrayOfProperties properties) {
    this.name = name;
    this.properties = properties;
  }

  public BaseComponentType(EComponentName name, ArrayOfComponents components) {
    this.name = name;
    this.components = components;
  }

  public BaseComponentType(EComponentName name, ArrayOfProperties properties, ArrayOfComponents components) {
    this.name = name;
    this.properties = properties;
    this.components = components;
  }

  /**
   * Get the iCalendar object name. This is set in the component constructor.
   * <p>
   * @return the iCalendar object name
   */
  public EComponentName getName() {
    return name;
  }

  /**
   * Gets the value of the properties property.
   * <p/>
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
   * <p/>
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
   * <p/>
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
   * <p/>
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
   * <p/>
   * This property defines the persistent, globally unique identifier for the
   * calendar component.
   * <p/>
   * Implementations MUST be able to receive and persist values of at least 255
   * octets for this property, but they MUST NOT truncate values in the middle
   * of a UTF-8 multi-octet sequence.
   * <p/>
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
   * <p/>
   * Property Name: DTSTAMP
   * <p/>
   * Purpose: In the case of an iCalendar object that specifies a "METHOD"
   * property, this property specifies the date and time that the instance of
   * the iCalendar object was created. In the case of an iCalendar object that
   * doesn't specify a "METHOD" property, this property specifies the date and
   * time that the information associated with the calendar component was last
   * revised in the calendar store.
   * <p/>
   * @return
   */
  public Calendar getDTSTAMP() {
    /**
     * QName {urn:ietf:params:xml:ns:icalendar-2.0}dtstamp is a DtstampPropType
     */
    JAXBElement<DtstampPropType> jAXBElement = findJaXBElement("DTSTAMP");
    if (jAXBElement != null) {
      return jAXBElement.getValue().getCalendar();
    } else {
      return null;
    }
  }

  public void setDTSTAMP(Calendar calendar) throws DatatypeConfigurationException {
    getProperties().addProperty(new ObjectFactory().createDtstamp(new DtstampPropType((GregorianCalendar) calendar)));
  }

  /**
   * Date-Time Start
   * <p/>
   * Property Name: DTSTART
   * <p/>
   * Purpose: This property specifies when the calendar component begins.
   * <p/>
   * Value Type: The default value type is DATE-TIME. The time value MUST be one
   * of the forms defined for the DATE-TIME value type. The value type can be
   * set to a DATE value type.
   * <p/>
   * Property Parameters: IANA, non-standard, value data type, and time zone
   * identifier property parameters can be specified on this property.
   * <p/>
   * @return
   */
  public Calendar getDTSTART() {
    /**
     * QName {urn:ietf:params:xml:ns:icalendar-2.0}dtstart is a DtstartPropType
     */
    JAXBElement<DtstartPropType> jAXBElement = findJaXBElement("DTSTART");
    if (jAXBElement != null) {
      return jAXBElement.getValue().getCalendar();
    } else {
      return null;
    }
  }

  public void setDTSTART(Calendar calendar) throws DatatypeConfigurationException {
    getProperties().addProperty(new ObjectFactory().createDtstart(new DtstartPropType((GregorianCalendar) calendar)));
  }

  /**
   * Date-Time Start
   * <p/>
   * Property Name: DTSTART
   * <p/>
   * Purpose: This property specifies when the calendar component begins.
   * <p/>
   * Value Type: The default value type is DATE-TIME. The time value MUST be one
   * of the forms defined for the DATE-TIME value type. The value type can be
   * set to a DATE value type.
   * <p/>
   * Property Parameters: IANA, non-standard, value data type, and time zone
   * identifier property parameters can be specified on this property.
   * <p/>
   * @return
   */
  public Calendar getDTEND() {
    /**
     * QName {urn:ietf:params:xml:ns:icalendar-2.0}dtend is a DtendPropType
     * <p/>
     * RFC5545 says either 'dtend' or 'duration' may appear in a 'eventprop',
     * but 'dtend' and 'duration' MUST NOT occur in the same 'eventprop'
     */
    JAXBElement<DtendPropType> jAXBElement = findJaXBElement("DTEND");
    if (jAXBElement != null) {
      return jAXBElement.getValue().getCalendar();
    } else if (findJaXBElement("DURATION") != null) {
      /**
       * If the dtEnd is not set then try to calculate it from the duration.
       */
      Calendar dtEnd = (Calendar) getDTSTART().clone();
      dtEnd.add(Calendar.MILLISECOND, (int) getDURATION().getTimeInMillis(dtEnd));
      return dtEnd;
    } else {
      return null;
    }
  }

  public void setDTEND(Calendar calendar) throws Exception {
    if (findJaXBElement("DURATION") != null) {
      throw new Exception("DURATION is already set. RFC5545 says either 'dtend' or 'duration' may appear in a 'eventprop', but 'dtend' and 'duration' MUST NOT occur in the same 'eventprop'");
    }
    getProperties().addProperty(new ObjectFactory().createDtend(new DtendPropType((GregorianCalendar) calendar)));
  }

  /**
   * 3.8.2.5. Duration
   * <p/>
   * Purpose: This property specifies a positive duration of time.
   * <p/>
   * e.g. The following is an example of this property that specifies an
   * interval of time of one hour and zero minutes and zero seconds:
   * DURATION:PT1H0M0S
   * <p/>
   * RFC5545 says either 'dtend' or 'duration' may appear in a 'eventprop', but
   * 'dtend' and 'duration' MUST NOT occur in the same 'eventprop'
   * <p/>
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
      try {
        return DatatypeFactory.newInstance().newDuration(getDTEND().getTimeInMillis() - getDTSTART().getTimeInMillis());
      } catch (DatatypeConfigurationException datatypeConfigurationException) {
        return null;
      }
    } else {
      return null;
    }
  }

  public void setDURATION(String duration) throws Exception {
    setDURATION(DatatypeFactory.newInstance().newDuration(duration));
  }

  public void setDURATION(Duration duration) throws Exception {
    if (findJaXBElement("DTEND") != null) {
      throw new Exception("DTEND is already set. RFC5545 says either 'dtend' or 'duration' may appear in a 'eventprop', but 'dtend' and 'duration' MUST NOT occur in the same 'eventprop'");
    }
    getProperties().addProperty(new ObjectFactory().createDuration(new DurationPropType(duration)));
  }

  /**
   * Recurrence Rule
   * <p/>
   * Value Name: RECUR
   * <p/>
   * Purpose: This value type is used to identify properties that contain a
   * recurrence rule specification.
   * <p/>
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
   * <p/>
   * @param recurType
   */
  public void setRRULE(RecurType recurType) {
    getProperties().addProperty(new ObjectFactory().createRrule(new RrulePropType(recurType)));
  }

  /**
   * The RrulePropType must contain a valid RecurType.
   * <p/>
   * @param rrulePropType
   */
  public void setRRULE(RrulePropType rrulePropType) {
    getProperties().addProperty(new ObjectFactory().createRrule(rrulePropType));
  }

  /**
   * Scans the properties or components looking for a QName local part that
   * matches the input name.
   * <p/>
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
   * <p/>
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
   * <p/>
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
