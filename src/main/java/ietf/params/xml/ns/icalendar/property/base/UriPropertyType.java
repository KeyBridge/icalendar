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
import ietf.params.xml.ns.icalendar.property.base.uri.TzurlPropType;
import ietf.params.xml.ns.icalendar.property.base.uri.UrlPropType;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for UriPropertyType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre> &lt;complexType name="UriPropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}uri"/>
 * &lt;/sequence> &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UriPropertyType", propOrder = {
  "uri"
})
@XmlSeeAlso({
  TzurlPropType.class,
  UrlPropType.class
})
public class UriPropertyType extends BasePropertyType {

  @XmlElement(required = true)
  protected String uri;

  /**
   * Gets the value of the uri property.
   *
   * @return possible object is {@link String }
   */
  public String getUri() {
    return uri;
  }

  /**
   * Sets the value of the uri property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUri(String value) {
    this.uri = value;
  }

  public boolean isSetUri() {
    return (this.uri != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + Objects.hashCode(this.uri);
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
    final UriPropertyType other = (UriPropertyType) obj;
    return Objects.equals(this.uri, other.uri);
  }
}
