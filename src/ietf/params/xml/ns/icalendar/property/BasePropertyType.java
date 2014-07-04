package ietf.params.xml.ns.icalendar.property;

import ietf.params.xml.ns.icalendar.ArrayOfParameters;
import ietf.params.xml.ns.icalendar.property.base.*;
import java.util.Objects;
import java.util.TimeZone;
import javax.xml.bind.annotation.*;

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
    if (parameters == null) {
      parameters = new ArrayOfParameters();
    }
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
