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
 * <p>
 * <
 * pre> &lt;complexType name="ArrayOfParameters"> &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}baseParameter"
 * maxOccurs="unbounded" minOccurs="0"/> &lt;/sequence> &lt;/restriction>
 * &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p>
 * <p>
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
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
   * for the baseParameter property.
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getBaseParameter().add(newItem);
   * </pre>
   * <p>
   * <p>
   * Objects of the following type(s) are allowed in the list null null null null   {@link JAXBElement }{@code <}{@link TextParameterType }{@code >}
     * {@link JAXBElement }{@code <}{@link RelatedParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link RoleParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link FbtypeParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link CutypeParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link MemberParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link LanguageParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link DirParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link DelegatedFromParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link ScheduleAgentParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link RangeParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link DelegatedToParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link ScheduleForceSendParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link RsvpParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link DurationParameterType }{@code >}
   * {@link JAXBElement }{@code <}{@link ReltypeParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link CnParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link SentByParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link AltrepParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link EncodingParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link ScheduleStatusParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link TzidParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link XBedeworkUidParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link BaseParameterType }{@code >}
   * {@link JAXBElement }{@code <}{@link FmttypeParamType }{@code >}
   * {@link JAXBElement }{@code <}{@link PartstatParamType }{@code >}
   * <p>
   * <p>
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
    if (!Objects.equals(this.baseParameter, other.baseParameter)) {
      return false;
    }
    return true;
  }
}
