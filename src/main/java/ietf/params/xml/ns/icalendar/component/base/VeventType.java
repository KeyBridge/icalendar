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

import static ietf.params.xml.ns.icalendar.Constants.FORMATTER_RFC2245_DATE_TIME;

import ietf.params.xml.ns.icalendar.component.BaseComponentType;
import ietf.params.xml.ns.icalendar.component.ComponentName;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for VeventType complex type.
 * <p>
 * RFC5545 says:
 * <p>
 * Either 'dtend' or 'duration' may appear in a 'eventprop', but 'dtend' and
 * 'duration' MUST NOT occur in the same 'eventprop'
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VeventType")
@XmlRootElement
public class VeventType extends BaseComponentType {

  public VeventType() {
    super(ComponentName.VEVENT);
  }

  /**
   * Print the VeventType start and end string on a single line..
   *
   * @return From [UTC_PATTERN] to [UTC_PATTERN]
   */
  @Override
  public String toString() {
    return "From " + (getDTSTART() != null ? getDTSTART().format(FORMATTER_RFC2245_DATE_TIME) : "")
           + "to " + (getDTEND() != null ? getDTEND().format(FORMATTER_RFC2245_DATE_TIME) : "");
  }

  /**
   * Print the VEvent to a simple string format.
   *
   * @return
   */
  public String toStringMultiline() {
    return BEGIN + ':' + getName()
           + LINE_SEPARATOR
           + "DTSTAMP:" + (getDTSTAMP() != null ? getDTSTAMP().format(FORMATTER_RFC2245_DATE_TIME) : "")
           + LINE_SEPARATOR
           + "DTSTART:" + (getDTSTART() != null ? getDTSTART().format(FORMATTER_RFC2245_DATE_TIME) : "")
           + LINE_SEPARATOR
           + "DTEND:" + (getDTEND() != null ? getDTEND().format(FORMATTER_RFC2245_DATE_TIME) : "")
           + LINE_SEPARATOR
           + END + ':' + getName()
           + LINE_SEPARATOR;
  }

  public String toStringFull() {
    return "VeventType"
           + " uid " + getUID()
           + "]\n dtstamp [" + (getDTSTAMP() != null ? getDTSTAMP().format(FORMATTER_RFC2245_DATE_TIME) : "")
           + "]\n dtstart [" + (getDTSTART() != null ? getDTSTART().format(FORMATTER_RFC2245_DATE_TIME) : "")
           + "]\n dtend   [" + (getDTEND() != null ? getDTEND().format(FORMATTER_RFC2245_DATE_TIME) : "")
           + "]\n duration [" + getDURATION()
           + "] rrule [" + getRRULE()
           + ']';
  }

  public String toStringBrief() {
    return "VeventType"
           + " dtstart [" + (getDTSTART() != null ? getDTSTART().format(FORMATTER_RFC2245_DATE_TIME) : "")
           + "] dtend [" + (getDTEND() != null ? getDTEND().format(FORMATTER_RFC2245_DATE_TIME) : "")
           + "] rrule [" + getRRULE()
           + ']';
  }
}
