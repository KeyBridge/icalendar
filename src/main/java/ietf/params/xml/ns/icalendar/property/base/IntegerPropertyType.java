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

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.integer.*;
import java.math.BigInteger;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for IntegerPropertyType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="IntegerPropertyType"&gt; &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 * &lt;sequence&gt; &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}integer"/&gt; &lt;/sequence&gt;
 * &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegerPropertyType", propOrder = {
  "integer"
})
@XmlSeeAlso({
  PercentCompletePropType.class,
  PriorityPropType.class,
  RepeatPropType.class,
  SequencePropType.class,
  XBedeworkMaxTicketsPerUserPropType.class,
  XBedeworkMaxTicketsPropType.class
})
public class IntegerPropertyType extends BasePropertyType {

  @XmlElement(required = true)
  protected Integer integer;

  /**
   * Gets the value of the integer property.
   *
   * @return possible object is {@link BigInteger }
   */
  public Integer getInteger() {
    return integer;
  }

  /**
   * Sets the value of the integer property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setInteger(Integer value) {
    this.integer = value;
  }

  public boolean isSetInteger() {
    return (this.integer != null);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 17 * hash + Objects.hashCode(this.integer);
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
    final IntegerPropertyType other = (IntegerPropertyType) obj;
    return Objects.equals(this.integer, other.integer);
  }
}
