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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for GeoPropType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="GeoPropType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"> &lt;sequence>
 * &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}latitude"/>
 * &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}longitude"/>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoPropType", propOrder = {
  "latitude",
  "longitude"
})
public class GeoPropType
  extends BasePropertyType {

  protected float latitude;
  protected float longitude;

  /**
   * Gets the value of the latitude property.
   */
  public float getLatitude() {
    return latitude;
  }

  /**
   * Sets the value of the latitude property.
   */
  public void setLatitude(float value) {
    this.latitude = value;
  }

  public boolean isSetLatitude() {
    return true;
  }

  /**
   * Gets the value of the longitude property.
   */
  public float getLongitude() {
    return longitude;
  }

  /**
   * Sets the value of the longitude property.
   */
  public void setLongitude(float value) {
    this.longitude = value;
  }

  public boolean isSetLongitude() {
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 97 * hash + Float.floatToIntBits(this.latitude);
    hash = 97 * hash + Float.floatToIntBits(this.longitude);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final GeoPropType other = (GeoPropType) obj;
    if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
      return false;
    }
    return Float.floatToIntBits(this.longitude) == Float.floatToIntBits(other.longitude);
  }

}
