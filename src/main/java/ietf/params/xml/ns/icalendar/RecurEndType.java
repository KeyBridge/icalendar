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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A helper class containing Recurrence end type strategy.
 * <p>
 * This is useful when examining the (calculated) Recur object and returns
 * either "COUNT", "UNTIL" or "NONE" depending upon whether the recurrence has a
 * count or until configuration (or neither).
 */
@XmlType(name = "RecurEndType")
@XmlEnum
@XmlTransient
public enum RecurEndType {

  COUNT,
  UNTIL,
  NONE;

  public String value() {
    return name();
  }

  public static RecurEndType fromValue(String v) {
    return valueOf(v);
  }
}
