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

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.utcoffset.TzoffsetfromPropType;
import ietf.params.xml.ns.icalendar.property.base.utcoffset.TzoffsettoPropType;
import java.util.Objects;
import java.util.TimeZone;
import javax.xml.bind.annotation.*;

/**
 * Java class for UtcOffsetPropertyType complex type.
 * <p>
 * 3.6.14. UTC Offset (RFC 5545, Section 3.3.14)
 * <p>
 * iCalendar "UTC-OFFSET" property values are represented by the IC:utc-offset
 * XML element. The content of the element is the same UTC offset value
 * specified by [RFC5545], with the exception that the hour, minute, and second
 * components are separated by a ":" character, for consistency with
 * [W3C.REC-xmlschema-2-20041028].
 * <p>
 * value-utc-offset = element utc-offset { xsd:string { pattern =
 * "(+|-)\d\d:\d\d(:\d\d)?" } }
 * <p>
 * Example: -04:00
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UtcOffsetPropertyType", propOrder = {
  "utcOffset"
})
@XmlSeeAlso({
  TzoffsettoPropType.class,
  TzoffsetfromPropType.class
})
public class UtcOffsetPropertyType extends BasePropertyType {

  /**
   * UTC-OFFSET: This value type is used to identify properties that contain an
   * offset from UTC to local time.
   * <p>
   * This value type is defined by the following notation:
   * <p>
   * utc-offset = time-numzone
   * <p>
   * time-numzone = ("+" / "-") time-hour time-minute [time-second]
   * <p>
   * he PLUS SIGN character MUST be specified for positive UTC offsets (i.e.,
   * ahead of UTC). The HYPHEN-MINUS character MUST be specified for negative
   * UTC offsets (i.e., behind of UTC). The value of "-0000" and "-000000" are
   * not allowed. The time-second, if present, MUST NOT be 60; if absent, it
   * defaults to zero.
   * <p>
   * The following UTC offsets are given for standard time for New York (five
   * hours behind UTC) and Geneva (one hour ahead of UTC): <code>-0500</code>
   * and <code>+0100</code>
   */
  @XmlElement(name = "utc-offset", required = true)
  protected String utcOffset;

  /**
   * Construct a new empty UtcOffset.
   */
  public UtcOffsetPropertyType() {
  }

  /**
   * Construct a new UtcOffset with a pre-configured offset string.
   *
   * @param utcOffset a pre-configured offset string.
   */
  public UtcOffsetPropertyType(String utcOffset) {
    this.utcOffset = utcOffset;
  }

  /**
   * Construct a new UtcOffset calculated from the indicated time zone.
   *
   * @param timeZone a standard Timezone instance.
   */
  public UtcOffsetPropertyType(TimeZone timeZone) {
    setUtcOffset(timeZone);
  }

  /**
   * Gets the value of the utcOffset property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getUtcOffset() {
    return utcOffset;
  }

  /**
   * Sets the value of the utcOffset property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setUtcOffset(String value) {
    this.utcOffset = value;
  }

  /**
   * Helper method to automatically set the UTC offset string from a given Time
   * Zone.
   *
   * @param timeZone
   */
  public final void setUtcOffset(TimeZone timeZone) {
    this.utcOffset = String.format("%s%02d:%02d",
                                   timeZone.getRawOffset() >= 0 ? "+" : "-",
                                   Math.abs(timeZone.getRawOffset() / 3600000),
                                   (timeZone.getRawOffset() / 60000) % 60);
  }

  public boolean isSetUtcOffset() {
    return (this.utcOffset != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 73 * hash + Objects.hashCode(this.utcOffset);
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
    final UtcOffsetPropertyType other = (UtcOffsetPropertyType) obj;
    return Objects.equals(this.utcOffset, other.utcOffset);
  }

  @Override
  public String toString() {
    return "utcOffset [" + utcOffset + ']';
  }

}
