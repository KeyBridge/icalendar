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
package ietf.params.xml.ns.icalendar.component.base;

import ietf.params.xml.ns.icalendar.component.BaseComponentType;
import ietf.params.xml.ns.icalendar.component.ComponentName;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * This type is the basis for all components and provides a base class for
 * applications.
 * <p>
 * Java class for VcalendarType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="VcalendarType"&gt; &lt;complexContent&gt; &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseComponentType"&gt;
 * &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VcalendarType")
public class VcalendarType extends BaseComponentType {

  public VcalendarType() {
    super(ComponentName.VCALENDAR);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final String toString() {
    final StringBuilder b = new StringBuilder();
    b.append(BEGIN).append(':').append(getName());
    b.append(LINE_SEPARATOR);
    b.append(getProperties());
    b.append(getComponents());
    b.append(END).append(':').append(getName());
    b.append(LINE_SEPARATOR);
    return b.toString();
  }

}
