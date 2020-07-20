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

import ietf.params.xml.ns.icalendar.component.BaseComponentType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for ArrayOfComponents complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="ArrayOfComponents"> &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}baseComponent"
 * maxOccurs="unbounded" minOccurs="0"/> &lt;/sequence> &lt;/restriction>
 * &lt;/complexContent> &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfComponents", propOrder = {
  "baseComponent"
})
public class ArrayOfComponents {

  @XmlElementRef(name = "baseComponent", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
  protected List<JAXBElement<? extends BaseComponentType>> baseComponent;

  /**
   * Gets the value of the baseComponent property.
   *
   * @return the value of the baseComponent
   */
  public List<JAXBElement<? extends BaseComponentType>> getBaseComponent() {
    if (baseComponent == null) {
      baseComponent = new ArrayList<>();
    }
    return this.baseComponent;
  }

  public boolean isSetBaseComponent() {
    return ((this.baseComponent != null) && (!this.baseComponent.isEmpty()));
  }

  public void unsetBaseComponent() {
    this.baseComponent = null;
  }

  /**
   * Method to add a jaXBElement to the baseProperty list.
   * <p>
   * Developer note: Use the ObjectFactory to build jaXBElements.
   *
   * @param jaXBElement
   */
  public void addComponent(JAXBElement<? extends BaseComponentType> jaXBElement) {
    getBaseComponent().add(jaXBElement);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.baseComponent);
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
    final ArrayOfComponents other = (ArrayOfComponents) obj;
    return Objects.equals(this.baseComponent, other.baseComponent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ArrayOfComponents ");
    if (baseComponent != null) {
      for (JAXBElement<? extends BaseComponentType> jaxbElement : baseComponent) {
        sb.append("\n")
          .append("  [").append(jaxbElement.getName()).append("]")
          .append(" ")
          .append(jaxbElement.getValue());
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
