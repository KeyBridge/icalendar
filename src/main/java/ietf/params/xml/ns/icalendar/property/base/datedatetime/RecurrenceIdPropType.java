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
package ietf.params.xml.ns.icalendar.property.base.datedatetime;

import ietf.params.xml.ns.icalendar.property.base.DateDatetimePropertyType;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 * Java class for RecurrenceIdPropType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre> &lt;complexType name="RecurrenceIdPropType"> &lt;complexContent>
 * &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}DateDatetimePropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecurrenceIdPropType")
public class RecurrenceIdPropType extends DateDatetimePropertyType {

  public RecurrenceIdPropType() {
  }

  public RecurrenceIdPropType(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    super(dateTime);
  }

  public RecurrenceIdPropType(Date date) throws DatatypeConfigurationException {
    super(date);
  }

}
