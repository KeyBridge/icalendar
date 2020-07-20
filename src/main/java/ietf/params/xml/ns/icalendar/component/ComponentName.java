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
package ietf.params.xml.ns.icalendar.component;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlTransient;

/**
 * An enumerate list of iCalendar component types. The name is used when writing
 * the component to String.
 * <p>
 * 3.3. Components (RFC 6321)
 * <p>
 * Each calendar component in the "VCALENDAR" object, delimited by "BEGIN" and
 * "END", will be converted to an enclosing XML element with the same name, but
 * in lowercase. As an example, the table below shows iCalendar-to-xCal mappings
 * for current iCalendar components. Any new iCalendar components added in the
 * future will be converted in the same way.
 *
 * @author Jesse Caulfield <jesse@caulfield.org> 07/04/14
 */
@XmlEnum
@XmlTransient
public enum ComponentName {

  AVAILABLE,
  DAYLIGHT,
  STANDARD,
  VALARM,
  VAVAILABILITY,
  VCALENDAR,
  VEVENT,
  VFREEBUSY,
  VJOURNAL,
  VTIMEZONE,
  VTODO,
  VVENUE,

}
