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

import ietf.params.xml.ns.icalendar.component.base.VcalendarType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for IcalendarType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="IcalendarType"&gt; &lt;complexContent&gt;
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 * &lt;sequence&gt; &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}vcalendar" maxOccurs="unbounded"/&gt;
 * &lt;/sequence&gt; &lt;/restriction&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IcalendarType", propOrder = {
  "vcalendar"
})
public class ICalendarType {

  @XmlElement(required = true)
  protected List<VcalendarType> vcalendar;

  /**
   * Gets the value of the vcalendar property.
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
   * for the vcalendar property.
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getVcalendar().add(newItem);
   * </pre>
   *
   * @return the value of the vcalendar
   */
  public List<VcalendarType> getVcalendar() {
    if (vcalendar == null) {
      vcalendar = new ArrayList<>();
    }
    return this.vcalendar;
  }

  public boolean isSetVcalendar() {
    return ((this.vcalendar != null) && (!this.vcalendar.isEmpty()));
  }

  public void unsetVcalendar() {
    this.vcalendar = null;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.vcalendar);
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
    final ICalendarType other = (ICalendarType) obj;
    if (!Objects.equals(this.vcalendar, other.vcalendar)) {
      return false;
    }
    return true;
  }
}
