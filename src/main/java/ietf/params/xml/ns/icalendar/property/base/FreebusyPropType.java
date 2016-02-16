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

import ietf.params.xml.ns.icalendar.PeriodType;
import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for FreebusyPropType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre> &lt;complexType name="FreebusyPropType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}period"
 * maxOccurs="unbounded"/> &lt;/sequence> &lt;/extension> &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * <p>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FreebusyPropType", propOrder = {
  "period"
})
public class FreebusyPropType extends BasePropertyType {

  @XmlElement(required = true)
  protected List<PeriodType> period;

  /**
   * Gets the value of the period property.
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
   * for the period property.
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getPeriod().add(newItem);
   * </pre>
   * <p>
   * <p>
   * Objects of the following type(s) are allowed in the list
     * {@link PeriodType }
   * <p>
   * <p>
   */
  public List<PeriodType> getPeriod() {
    if (period == null) {
      period = new ArrayList<>();
    }
    return this.period;
  }

  public boolean isSetPeriod() {
    return ((this.period != null) && (!this.period.isEmpty()));
  }

  public void unsetPeriod() {
    this.period = null;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + Objects.hashCode(this.period);
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
    final FreebusyPropType other = (FreebusyPropType) obj;
    if (!Objects.equals(this.period, other.period)) {
      return false;
    }
    return true;
  }
}
