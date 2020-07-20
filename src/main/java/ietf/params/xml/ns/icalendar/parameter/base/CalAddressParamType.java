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
import ietf.params.xml.ns.icalendar.parameter.base.caladdress.SentByParamType;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for CalAddressParamType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="CalAddressParamType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}cal-address"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalAddressParamType", propOrder = {"calAddress"})
@XmlSeeAlso({SentByParamType.class})
public class CalAddressParamType extends BaseParameterType {

  @XmlElement(name = "cal-address", required = true)
  protected String calAddress;

  /**
   * Gets the value of the calAddress property.
   *
   * @return possible object is {@link String }
   */
  public String getCalAddress() {
    return calAddress;
  }

  /**
   * Sets the value of the calAddress property.
   *
   * @param value allowed object is {@link String }
   */
  public void setCalAddress(String value) {
    this.calAddress = value;
  }

  public boolean isSetCalAddress() {
    return (this.calAddress != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 89 * hash + Objects.hashCode(this.calAddress);
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
    final CalAddressParamType other = (CalAddressParamType) obj;
    return Objects.equals(this.calAddress, other.calAddress);
  }
}
