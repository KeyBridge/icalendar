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
package ietf.params.xml.ns.icalendar.parameter.base;

import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;

/**
 * Java class for DurationParameterType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="DurationParameterType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType">
 * &lt;sequence> &lt;element name="duration"
 * type="{http://www.w3.org/2001/XMLSchema}duration"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DurationParameterType", propOrder = {
  "duration"
})
public class DurationParameterType extends BaseParameterType {

  @XmlElement(required = true)
  protected Duration duration;

  /**
   * Gets the value of the duration property.
   *
   * @return possible object is {@link Duration }
   */
  public Duration getDuration() {
    return duration;
  }

  /**
   * Sets the value of the duration property.
   *
   * @param value allowed object is {@link Duration }
   */
  public void setDuration(Duration value) {
    this.duration = value;
  }

  public boolean isSetDuration() {
    return (this.duration != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.duration);
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
    final DurationParameterType other = (DurationParameterType) obj;
    return Objects.equals(this.duration, other.duration);
  }
}
