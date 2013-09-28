package ietf.params.xml.ns.icalendar.property;

import ietf.params.xml.ns.icalendar.ArrayOfParameters;
import ietf.params.xml.ns.icalendar.property.base.FreebusyPropType;
import ietf.params.xml.ns.icalendar.property.base.TextPropertyType;
import ietf.params.xml.ns.icalendar.property.base.DatetimePropertyType;
import ietf.params.xml.ns.icalendar.property.base.RequestStatusPropType;
import ietf.params.xml.ns.icalendar.property.base.IntegerPropertyType;
import ietf.params.xml.ns.icalendar.property.base.RecurPropertyType;
import ietf.params.xml.ns.icalendar.property.base.CalAddressPropertyType;
import ietf.params.xml.ns.icalendar.property.base.LinkPropType;
import ietf.params.xml.ns.icalendar.property.base.DurationPropType;
import ietf.params.xml.ns.icalendar.property.base.CalscalePropType;
import ietf.params.xml.ns.icalendar.property.base.TextListPropertyType;
import ietf.params.xml.ns.icalendar.property.base.UtcOffsetPropertyType;
import ietf.params.xml.ns.icalendar.property.base.UtcDatetimePropertyType;
import ietf.params.xml.ns.icalendar.property.base.UriPropertyType;
import ietf.params.xml.ns.icalendar.property.base.GeoPropType;
import ietf.params.xml.ns.icalendar.property.base.RelatedToPropType;
import ietf.params.xml.ns.icalendar.property.base.DateDatetimePropertyType;
import ietf.params.xml.ns.icalendar.property.base.AttachPropType;
import ietf.params.xml.ns.icalendar.property.base.TriggerPropType;
import ietf.params.xml.ns.icalendar.property.base.TolerancePropType;
import ietf.params.xml.ns.icalendar.property.base.WsCalendarAttachType;
import java.util.Objects;
import java.util.TimeZone;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for BasePropertyType complex type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasePropertyType", propOrder = {
  "parameters"
})
@XmlSeeAlso({
  AttachPropType.class,
  CalAddressPropertyType.class,
  CalscalePropType.class,
  DateDatetimePropertyType.class,
  DatetimePropertyType.class,
  DurationPropType.class,
  FreebusyPropType.class,
  GeoPropType.class,
  IntegerPropertyType.class,
  LinkPropType.class,
  RecurPropertyType.class,
  RelatedToPropType.class,
  RequestStatusPropType.class,
  TextListPropertyType.class,
  TextPropertyType.class,
  TolerancePropType.class,
  TriggerPropType.class,
  UriPropertyType.class,
  UtcDatetimePropertyType.class,
  UtcOffsetPropertyType.class,
  WsCalendarAttachType.class
})
public abstract class BasePropertyType {

  @XmlTransient
  protected static final TimeZone TIME_ZONE = TimeZone.getTimeZone("UTC");
  protected ArrayOfParameters parameters;

  /**
   * Gets the value of the parameters property.
   * <p/>
   * @return possible object is {@link ArrayOfParameters }
   *
   */
  public ArrayOfParameters getParameters() {
    return parameters;
  }

  /**
   * Sets the value of the parameters property.
   * <p/>
   * @param value allowed object is {@link ArrayOfParameters }
   *
   */
  public void setParameters(ArrayOfParameters value) {
    this.parameters = value;
  }

  public boolean isSetParameters() {
    return (this.parameters != null);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 73 * hash + Objects.hashCode(this.parameters);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final BasePropertyType other = (BasePropertyType) obj;
    if (!Objects.equals(this.parameters, other.parameters)) {
      return false;
    }
    return true;
  }
}
