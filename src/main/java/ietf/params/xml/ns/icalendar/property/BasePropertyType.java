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
   *
   * @return possible object is {@link ArrayOfParameters }
   */
  public ArrayOfParameters getParameters() {
    if (parameters == null) {
      parameters = new ArrayOfParameters();
    }
    return parameters;
  }

  /**
   * Sets the value of the parameters property.
   *
   * @param value allowed object is {@link ArrayOfParameters }
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
    return Objects.equals(this.parameters, other.parameters);
  }
}
