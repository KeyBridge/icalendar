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
package ietf.params.xml.ns.icalendar.property.base.text;

import ietf.params.xml.ns.icalendar.property.base.TextPropertyType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for MethodPropType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre> &lt;complexType name="MethodPropType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}TextPropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MethodPropType")
public class MethodPropType extends TextPropertyType {

  public MethodPropType() {
  }

  public MethodPropType(String text) {
    super(text);
  }

  /**
   * Used to publish a calendar entry to one or more Calendar Users. There is no
   * interactivity between the publisher and any other calendar user. An example
   * might include a baseball team publishing its schedule to the public. [RFC
   * 2446]
   */
  public static final MethodPropType PUBLISH = new MethodPropType("PUBLISH");

  /**
   * Used to schedule a calendar entry with other Calendar Users. Requests are
   * interactive in that they require the receiver to respond using the Reply
   * methods. Meeting Requests, Busy Time requests and the assignment of VTODOs
   * to other Calendar Users are all examples. Requests are also used by the
   * "Organizer" to update the status of a calendar entry. [RFC 2446]
   */
  public static final MethodPropType REQUEST = new MethodPropType("REQUEST");

  /**
   * A Reply is used in response to a Request to convey "Attendee" status to the
   * "Organizer". Replies are commonly used to respond to meeting and task
   * requests. [RFC2446]
   */
  public static final MethodPropType REPLY = new MethodPropType("REPLY");

  /**
   * Add one or more instances to an existing VEVENT, VTODO, or VJOURNAL. [RFC
   * 2446]
   */
  public static final MethodPropType ADD = new MethodPropType("ADD");

  /**
   * Cancel one or more instances of an existing VEVENT, VTODO, or VJOURNAL.
   * [RFC 2446]
   */
  public static final MethodPropType CANCEL = new MethodPropType("CANCEL");

  /**
   * The Refresh method is used by an "Attendee" to request the latest version
   * of a calendar entry. [RFC 2446]
   */
  public static final MethodPropType REFRESH = new MethodPropType("REFRESH");

  /**
   * The Counter method is used by an "Attendee" to negotiate a change in the
   * calendar entry. Examples include the request to change a proposed Event
   * time or change the due date for a VTODO. [RFC 2446]
   */
  public static final MethodPropType COUNTER = new MethodPropType("COUNTER");

  /**
   * Used by the "Organizer" to decline the proposed counter-proprosal. [RFC
   * 2446]
   */
  public static final MethodPropType DECLINE_COUNTER = new MethodPropType("DECLINE-COUNTER");

}
