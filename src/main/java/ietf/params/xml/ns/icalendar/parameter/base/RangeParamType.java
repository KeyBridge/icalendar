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

import ietf.params.xml.ns.icalendar.RangeValueType;
import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for RangeParamType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre> &lt;complexType name="RangeParamType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType"> &lt;sequence>
 * &lt;element name="text"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}ERangeValueType"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RangeParamType", propOrder = {
  "text"
})
public class RangeParamType extends BaseParameterType {

  @XmlElement(required = true)
  protected RangeValueType text;

  /**
   * Gets the value of the text property.
   *
   * @return possible object is {@link RangeValueType }
   *
   */
  public RangeValueType getText() {
    return text;
  }

  /**
   * Sets the value of the text property.
   *
   * @param value allowed object is {@link RangeValueType }
   *
   */
  public void setText(RangeValueType value) {
    this.text = value;
  }

  public boolean isSetText() {
    return (this.text != null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + (this.text != null ? this.text.hashCode() : 0);
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
    final RangeParamType other = (RangeParamType) obj;
    if (this.text != other.text) {
      return false;
    }
    return true;
  }
}
