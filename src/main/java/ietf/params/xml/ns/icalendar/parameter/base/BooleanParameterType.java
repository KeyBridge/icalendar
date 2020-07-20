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
import ietf.params.xml.ns.icalendar.parameter.base.bool.RsvpParamType;
import javax.xml.bind.annotation.*;

/**
 * Java class for BooleanParameterType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="BooleanParameterType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}boolean"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BooleanParameterType", propOrder = {"_boolean"})
@XmlSeeAlso({RsvpParamType.class})
public class BooleanParameterType extends BaseParameterType {

  @XmlElement(name = "boolean")
  protected boolean _boolean;

  /**
   * Gets the value of the boolean property.
   */
  public boolean isBoolean() {
    return _boolean;
  }

  /**
   * Sets the value of the boolean property.
   */
  public void setBoolean(boolean value) {
    this._boolean = value;
  }

  public boolean isSetBoolean() {
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 61 * hash + (this._boolean ? 1 : 0);
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
    final BooleanParameterType other = (BooleanParameterType) obj;
    return this._boolean == other._boolean;
  }
}
