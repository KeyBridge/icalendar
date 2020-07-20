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

import ietf.params.xml.ns.icalendar.ToleranceValueType;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for TolerancePropType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>  &lt;complexType name="TolerancePropType"&gt; &lt;complexContent&gt;
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 * &lt;sequence&gt; &lt;element name="tolerate"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}ToleranceValueType"/&gt;
 * &lt;/sequence&gt; &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TolerancePropType", propOrder = {
  "tolerate"
})
public class TolerancePropType extends BasePropertyType {

  @XmlElement(required = true)
  protected ToleranceValueType tolerate;

  /**
   * Gets the value of the tolerate property.
   *
   * @return possible object is {@link ToleranceValueType }
   */
  public ToleranceValueType getTolerate() {
    return tolerate;
  }

  /**
   * Sets the value of the tolerate property.
   *
   * @param value allowed object is {@link ToleranceValueType }
   */
  public void setTolerate(ToleranceValueType value) {
    this.tolerate = value;
  }

  public boolean isSetTolerate() {
    return (this.tolerate != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + Objects.hashCode(this.tolerate);
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
    final TolerancePropType other = (TolerancePropType) obj;
    return Objects.equals(this.tolerate, other.tolerate);
  }
}
