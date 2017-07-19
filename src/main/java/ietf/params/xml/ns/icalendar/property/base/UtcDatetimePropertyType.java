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
package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.Constants;
import ietf.params.xml.ns.icalendar.adapter.XmlAdapterZonedDateTimeXCalDateTime;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.CompletedPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.CreatedPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.DtstampPropType;
import ietf.params.xml.ns.icalendar.property.base.utcdatetime.LastModifiedPropType;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for UtcDatetimePropertyType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre> &lt;complexType name="UtcDatetimePropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}utc-date-time"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UtcDatetimePropertyType", propOrder = {
  "utcDateTime"
})
@XmlSeeAlso({
  CompletedPropType.class,
  CreatedPropType.class,
  DtstampPropType.class,
  LastModifiedPropType.class
})
public class UtcDatetimePropertyType extends BasePropertyType {

  @XmlElement(name = "utc-date-time", required = true)
  @XmlJavaTypeAdapter(type = ZonedDateTime.class, value = XmlAdapterZonedDateTimeXCalDateTime.class)
  protected ZonedDateTime utcDateTime;

  public UtcDatetimePropertyType() {
  }

  public UtcDatetimePropertyType(ZonedDateTime dateTime) {
    this.utcDateTime = dateTime;
  }

  /**
   * Gets the value of the utcDateTime property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public ZonedDateTime getUtcDateTime() {
    return utcDateTime;
  }

  /**
   * Sets the value of the utcDateTime property.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setUtcDateTime(ZonedDateTime value) {
    this.utcDateTime = value;
  }

  public void setUtcDateTime(LocalDateTime value) {
    this.utcDateTime = ZonedDateTime.of(value, Constants.ZONE_UTC);
  }

  public boolean isSetUtcDateTime() {
    return (this.utcDateTime != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + Objects.hashCode(this.utcDateTime);
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
    final UtcDatetimePropertyType other = (UtcDatetimePropertyType) obj;
    if (!Objects.equals(this.utcDateTime, other.utcDateTime)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "UtcDatetimePropertyType" + " utcDateTime [" + utcDateTime + ']';
  }
}
