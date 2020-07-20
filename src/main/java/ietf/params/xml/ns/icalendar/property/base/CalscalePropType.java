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

import ietf.params.xml.ns.icalendar.CalscaleValueType;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for CalscalePropType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="CalscalePropType"&gt; &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 * &lt;sequence&gt; &lt;element name="text"
 * type="{urn:ietf:params:xml:ns:icalendar-2.0}ECalscaleValueType"/&gt;
 * &lt;/sequence&gt; &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalscalePropType", propOrder = {
  "text"
})
public class CalscalePropType extends BasePropertyType {

  @XmlElement(required = true)
  protected CalscaleValueType text;

  public CalscalePropType() {
    this.text = CalscaleValueType.GREGORIAN;
  }

  public CalscalePropType(CalscaleValueType text) {
    this.text = text;
  }

  /**
   * Gets the value of the text property.
   *
   * @return possible object is {@link CalscaleValueType }
   */
  public CalscaleValueType getText() {
    return text;
  }

  /**
   * Sets the value of the text property.
   *
   * @param value allowed object is {@link CalscaleValueType }
   */
  public void setText(CalscaleValueType value) {
    this.text = value;
  }

  public boolean isSetText() {
    return (this.text != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 71 * hash + (this.text != null ? this.text.hashCode() : 0);
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
    final CalscalePropType other = (CalscalePropType) obj;
    return this.text == other.text;
  }
}
