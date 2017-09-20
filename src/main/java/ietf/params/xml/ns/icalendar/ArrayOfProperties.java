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
package ietf.params.xml.ns.icalendar;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

/**
 * Java class for ArrayOfProperties complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre> &lt;complexType name="ArrayOfProperties"> &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence> &lt;choice maxOccurs="unbounded" minOccurs="0"> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}baseProperty"/> &lt;element
 * name="tzid" type="{urn:ietf:params:xml:ns:icalendar-2.0}TextPropertyType"/>
 * &lt;/choice> &lt;/sequence> &lt;/restriction> &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * <p>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProperties", propOrder = {
  "basePropertyOrTzid"
})
public class ArrayOfProperties {

  @XmlElementRefs({
    @XmlElementRef(name = "baseProperty", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false),
    @XmlElementRef(name = "tzid", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
  })
  protected List<JAXBElement<? extends BasePropertyType>> basePropertyOrTzid;

  /**
   * Gets the value of the basePropertyOrTzid property.
   */
  public List<JAXBElement<? extends BasePropertyType>> getBasePropertyOrTzid() {
    if (basePropertyOrTzid == null) {
      basePropertyOrTzid = new ArrayList<>();
    }
    return this.basePropertyOrTzid;
  }

  public boolean isSetBasePropertyOrTzid() {
    return ((this.basePropertyOrTzid != null) && (!this.basePropertyOrTzid.isEmpty()));
  }

  public void unsetBasePropertyOrTzid() {
    this.basePropertyOrTzid = null;
  }

  /**
   * Method to add a jaXBElement to the baseProperty list.
   * <p>
   * Developer note: Use the ObjectFactory to build jaXBElements.
   *
   * @param jaXBElement
   */
  public void addProperty(JAXBElement<? extends BasePropertyType> jaXBElement) {
    getBasePropertyOrTzid().add(jaXBElement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ArrayOfProperties ");
    if (basePropertyOrTzid != null) {
      for (JAXBElement<? extends BasePropertyType> jaxbElement : basePropertyOrTzid) {
        sb.append("\n")
                .append("  [").append(jaxbElement.getName()).append("]")
                .append(" ")
                .append(jaxbElement.getValue());
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.basePropertyOrTzid);
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
    final ArrayOfProperties other = (ArrayOfProperties) obj;
    if (!Objects.equals(this.basePropertyOrTzid, other.basePropertyOrTzid)) {
      return false;
    }
    return true;
  }
}
