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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for ECalscaleValueType.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>
 * &lt;simpleType name="ECalscaleValueType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GREGORIAN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * <p>
 */
@XmlType(name = "CalscaleValueType")
@XmlEnum
public enum ECalscaleValueType {

  GREGORIAN;

  public String value() {
    return name();
  }

  public static ECalscaleValueType fromValue(String v) {
    return valueOf(v);
  }
}
