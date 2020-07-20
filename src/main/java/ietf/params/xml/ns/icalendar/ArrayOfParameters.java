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

import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for ArrayOfParameters complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="ArrayOfParameters"&gt; &lt;complexContent&gt;
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 * &lt;sequence&gt; &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}baseParameter"
 * maxOccurs="unbounded" minOccurs="0"/&gt; &lt;/sequence&gt; &lt;/restriction&gt;
 * &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfParameters", propOrder = {
  "baseParameter"
})
public class ArrayOfParameters {

  @XmlElementRef(name = "baseParameter", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
  protected List<JAXBElement<? extends BaseParameterType>> baseParameter;

  /**
   * Gets the value of the baseParameter property.
   *
   * @return the value of the baseParameter
   */
  public List<JAXBElement<? extends BaseParameterType>> getBaseParameter() {
    if (baseParameter == null) {
      baseParameter = new ArrayList<>();
    }
    return this.baseParameter;
  }

  public boolean isSetBaseParameter() {
    return ((this.baseParameter != null) && (!this.baseParameter.isEmpty()));
  }

  public void unsetBaseParameter() {
    this.baseParameter = null;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 47 * hash + Objects.hashCode(this.baseParameter);
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
    final ArrayOfParameters other = (ArrayOfParameters) obj;
    return Objects.equals(this.baseParameter, other.baseParameter);
  }
}
