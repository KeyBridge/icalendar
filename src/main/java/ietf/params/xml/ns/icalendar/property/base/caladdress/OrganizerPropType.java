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
package ietf.params.xml.ns.icalendar.property.base.caladdress;

import ietf.params.xml.ns.icalendar.property.base.CalAddressPropertyType;
import java.net.URI;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for OrganizerPropType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>  &lt;complexType name="OrganizerPropType"&gt; &lt;complexContent&gt;
 * &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}CalAddressPropertyType"&gt;
 * &lt;/extension&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizerPropType")
public class OrganizerPropType extends CalAddressPropertyType {

  public OrganizerPropType() {
  }

  public OrganizerPropType(String calAddress) {
    super(calAddress);
  }

  public OrganizerPropType(URI calAddress) {
    super(calAddress.toString());
  }

}
